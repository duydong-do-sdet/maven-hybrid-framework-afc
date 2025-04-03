package afc.demo;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.demo.DemoPageGenerator;
import pageObjects.demo.UndisplayedPageObject;

public class Level_16_Undisplayed_In_DOM extends BaseTest {
    private WebDriver driver;
    private UndisplayedPageObject undisplayedPage;

    @Parameters({"browser", "inDomUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        undisplayedPage = DemoPageGenerator.getUndisplayedPage(driver);
    }

    @Test
    public void TC_01() {
        undisplayedPage.clickStartButton();

        Assert.assertTrue(undisplayedPage.isStartButtonUndisplayed());

        Assert.assertTrue(undisplayedPage.isLoadingIconDisplayed());

        Assert.assertTrue(undisplayedPage.isHelloWorldTextDisplayed());

        Assert.assertTrue(undisplayedPage.isLoadingIconUndisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
