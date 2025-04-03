package reportConfig;

import commons.BaseTest;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ReportNGListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            System.setProperty("org.uncommons.reportng.escape-output", "false");
            Object testInstance = result.getInstance();
            WebDriver driver = ((BaseTest) testInstance).getDriver();
            String screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            Reporter.log("<br><a href=\"data:image/png;base64," + screenshot + "\">" + "<img src=\"data:image/png;base64," + screenshot + "\" " + "height='100' width='150'/> " + "</a></br>");
        } catch (Exception e) {
            Reporter.log("<br><b>Error in onTestFailure: </b>" + e.getMessage() + "<br>");
        }
    }

}
