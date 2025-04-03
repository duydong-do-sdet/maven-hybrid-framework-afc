package afc.magento;

import afc.magento.common.Level_17_Register_Login_Cookies;
import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalLoginPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountInformationPageObject;
import pageObjects.magento.portal.myAccount.PortalAddressBookPageObject;

public class Level_17_Share_States_Cookies extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject homePage;
    private PortalLoginPageObject loginPage;
    private PortalAccountDashboardPageObject accountDashboardPage;
    private PortalAccountInformationPageObject accountInformationPage;
    private PortalAddressBookPageObject addressBookPage;
    private String firstName, lastName, fullName, emailAddress;

    @Parameters({"browser", "portalUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getPortalHomePage(driver);

        firstName = Level_17_Register_Login_Cookies.firstName;
        lastName = Level_17_Register_Login_Cookies.lastName;
        fullName = firstName + " " + lastName;
        emailAddress = Level_17_Register_Login_Cookies.emailAddress;

        loginPage = homePage.selectLoginInMyAccountHeaderDropdown();
        accountDashboardPage = loginPage.loginByCookies(Level_17_Register_Login_Cookies.loginCookies);
    }

    @Test
    public void TC_01_My_Dashboard() {
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = accountDashboardPage.getContactInformationText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));
    }

    @Test
    public void TC_02_Account_Information() {
        accountInformationPage = accountDashboardPage.clickAccountInformationSidebarLink();

        Assert.assertTrue(accountInformationPage.isPageTitleDisplayed());
    }

    @Test
    public void TC_03_Address_Book() {
        addressBookPage = accountInformationPage.clickAddressBookSidebarLink();

        Assert.assertTrue(addressBookPage.isPageTitleDisplayed());
    }

    @Test
    public void TC_04_Logout() {
        accountDashboardPage = addressBookPage.clickAccountDashboardSidebarLink();

        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        accountDashboardPage.selectLogoutInMyAccountHeaderDropdown();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
