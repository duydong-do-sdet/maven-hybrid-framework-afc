package afc.magento.common;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalLoginPageObject;
import pageObjects.magento.portal.PortalRegisterPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;

import java.util.Set;

public class Level_17_Register_Login_Cookies extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject homePage;
    private PortalRegisterPageObject registerPage;
    private PortalAccountDashboardPageObject accountDashboardPage;
    private PortalLoginPageObject loginPage;
    public static String firstName, lastName, emailAddress, password;
    public static Set<Cookie> loginCookies;

    @Parameters({"browser", "portalUrl"})
    @BeforeTest
    public void beforeTest(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getPortalHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
        password = "SeJava@4";

        registerPage = homePage.selectRegisterInMyAccountHeaderDropdown();

        accountDashboardPage = registerPage.registerNewUserAccount(firstName, lastName, emailAddress, password);

        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        homePage = accountDashboardPage.selectLogoutInMyAccountHeaderDropdown();

        loginPage = homePage.selectLoginInMyAccountHeaderDropdown();

        accountDashboardPage = loginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        loginCookies = accountDashboardPage.getCookiesAfterLogin();

        driver.quit();
    }

}
