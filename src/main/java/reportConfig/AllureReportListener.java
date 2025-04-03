package reportConfig;

import commons.BaseTest;
import commons.GlobalConstants;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AllureReportListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    // Screenshot attachments for Allure
    @Attachment(value = "Screenshot of {0}", type = "image/png")
    public static byte[] saveScreenshotPNG(String testName, WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    // Text attachments for Allure
    @Attachment(value = "Text attachment of {0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    // HTML attachments for Allure
    @Attachment(value = "{0}", type = "text/html")
    public static String attachHtml(String html) {
        return html;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((BaseTest) testClass).getDriver();
        saveScreenshotPNG(result.getName(), driver);
        saveTextLog(getTestMethodName(result) + " failed and screenshot taken!");
    }

    @Override
    public void onFinish(ITestContext context) {
        String browserName = context.getCurrentXmlTest().getParameter("browser");
        createEnvironmentFile(browserName);
        createExecutorFile();
    }

    private static void createEnvironmentFile(String browserName) {
        try {
            File directory = new File(GlobalConstants.ALLURE_REPORT_OUTPUT);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(GlobalConstants.ALLURE_REPORT_OUTPUT + "environment.properties");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("OS=" + GlobalConstants.OS_NAME + "\n");
                writer.write("Browser=" + browserName + "\n");
                writer.write("Java.Version=" + GlobalConstants.JAVA_VERSION + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error creating environment.properties file: " + e.getMessage());
        }
    }

    private static void createExecutorFile() {
        try {
            File directory = new File(GlobalConstants.ALLURE_REPORT_OUTPUT);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            File file = new File(GlobalConstants.ALLURE_REPORT_OUTPUT + "executor.json");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write("{\n");
                writer.write("\"name\": \"Local Machine\",\n");
                writer.write("\"type\": \"local\"\n");
                writer.write("}");
            }
        } catch (IOException e) {
            System.out.println("Error creating executor.json file: " + e.getMessage());
        }
    }

}
