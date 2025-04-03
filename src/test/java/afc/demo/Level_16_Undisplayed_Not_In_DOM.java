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

public class Level_16_Undisplayed_Not_In_DOM extends BaseTest {
    private WebDriver driver;
    private UndisplayedPageObject undisplayedPage;

    @Parameters({"browser", "notInDomUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        undisplayedPage = DemoPageGenerator.getUndisplayedPage(driver);
    }

    @Test
    public void TC_01_Form() {
        undisplayedPage.clickRegisterButton();

        Assert.assertTrue(undisplayedPage.isRegisterFormDialogDisplayed());

        undisplayedPage.clickCloseDialogButton();

        Assert.assertTrue(undisplayedPage.isRegisterFormDialogUndisplayed());
    }

    @Test
    public void TC_02_Text_Fields() {
        String[] placeholderValues = {"Tài khoản đăng nhập*", "Mật khẩu*", "Xác nhận mật khẩu*", "Họ và tên*", "Email*", "Số điện thoại*"};

        undisplayedPage.clickRegisterButton();

        Assert.assertTrue(undisplayedPage.isTextFieldByPlaceholderDisplayed("Họ và tên*"));
        Assert.assertTrue(undisplayedPage.areAllTextFieldsDisplayed(placeholderValues));

        undisplayedPage.clickCloseDialogButton();

        Assert.assertTrue(undisplayedPage.isTextFieldByPlaceholderUndisplayed("Họ và tên*"));
        Assert.assertTrue(undisplayedPage.areAllTextFieldsUndisplayed(placeholderValues));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
