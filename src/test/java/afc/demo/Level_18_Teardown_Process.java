package afc.demo;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Level_18_Teardown_Process extends BaseTest {
    private WebDriver driver;

    @Parameters({"browser", "appUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        Assert.fail();
    }

    @Test
    public void TC_01() {
        System.out.println("Test 01");
    }

    @Test
    public void TC_02() {
        System.out.println("Test 02");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        quitDriver();
    }

}
