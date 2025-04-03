package reportConfig;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import commons.BaseTest;
import commons.GlobalConstants;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ExtentReportsListener implements ITestListener {
    private static final ExtentReports extentReports = createExtentReports();
    private static final Map<Long, ExtentTest> extentTestMap = new ConcurrentHashMap<>();

    private static ExtentReports createExtentReports() {
        ExtentReports extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(GlobalConstants.EXTENTREPORTS_OUTPUT);

        sparkReporter.config().setDocumentTitle("ExtentReports - AFC");
        sparkReporter.config().setReportName("ExtentReports - Magento");
        sparkReporter.config().setTimelineEnabled(true);
        sparkReporter.config().setEncoding("utf-8");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Company", "AFC");
        extentReports.setSystemInfo("Project", "Magento");
        extentReports.setSystemInfo("SDET", "Do Duy Dong");
        extentReports.setSystemInfo("OS", GlobalConstants.OS_NAME);

        return extentReports;
    }

    public static synchronized void startTest(String testName, String stepDesc) {
        ExtentTest test = extentReports.createTest(testName, stepDesc);
        extentTestMap.put(Thread.currentThread().threadId(), test);
    }

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get(Thread.currentThread().threadId());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        getTest().log(Status.PASS, result.getName() + " [PASSED]");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Object testInstance = result.getInstance();
        WebDriver driver = ((BaseTest) testInstance).getDriver();
        String screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        getTest().log(Status.FAIL, result.getThrowable().getMessage());
        getTest().addScreenCaptureFromBase64String(screenshot);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        getTest().log(Status.SKIP, result.getThrowable().getMessage());
    }

    @Override
    public void onFinish(ITestContext context) {
        String browserName = context.getCurrentXmlTest().getParameter("browser");
        extentReports.setSystemInfo("Browser", browserName.toUpperCase());

        extentReports.flush();

        if (Desktop.isDesktopSupported()) {
            File extentReports = new File(GlobalConstants.EXTENTREPORTS_OUTPUT);
            try {
                Desktop.getDesktop().browse(extentReports.toURI());
            } catch (IOException e) {
                System.out.println("Error opening the report: " + e.getMessage());
            }
        }
    }

}
