package afc.magento;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.magento.admin.AdminLoginPageObject;
import pageObjects.magento.admin.AdminManageCustomersPageObject;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalLoginPageObject;
import pageObjects.magento.portal.PortalRegisterPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;

public class Level_08_Cross_Site_Portal_Admin extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject portalHomePage;
    private PortalRegisterPageObject portalRegisterPage;
    private PortalAccountDashboardPageObject portalAccountDashboardPage;
    private PortalLoginPageObject portalLoginPage;
    private AdminLoginPageObject adminLoginPage;
    private AdminManageCustomersPageObject adminManageCustomersPage;
    private String firstName, lastName, fullName, emailAddress, password;
    private String portalAppUrl, adminAppUrl;

    @Parameters({"browser", "portalUrl", "adminUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String portalAppUrl, String adminAppUrl) {
        driver = getWebDriver(browserName, portalAppUrl);
        portalHomePage = PageGeneratorManager.getPortalHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
        password = "SeJava@4";

        this.portalAppUrl = portalAppUrl;
        this.adminAppUrl = adminAppUrl;

        portalRegisterPage = portalHomePage.selectRegisterInMyAccountHeaderDropdown();
        portalAccountDashboardPage = portalRegisterPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
        Assert.assertEquals(portalAccountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");
        portalHomePage = portalAccountDashboardPage.selectLogoutInMyAccountHeaderDropdown();
    }

    @Test
    public void TC_01_Portal_Site_Login_With_User_Account() {
        portalLoginPage = portalHomePage.selectLoginInMyAccountHeaderDropdown();

        portalAccountDashboardPage = portalLoginPage.loginToSystem(emailAddress, password);

        Assert.assertTrue(portalAccountDashboardPage.isPageTitleDisplayed());

        Assert.assertEquals(portalAccountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = portalAccountDashboardPage.getContactInformationText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));

        portalHomePage = portalAccountDashboardPage.selectLogoutInMyAccountHeaderDropdown();
    }

    @Test
    public void TC_02_Admin_Site_Delete_User_Account() {
        adminLoginPage = portalHomePage.openAdminAppUrl(driver, adminAppUrl);

        adminLoginPage.sendKeysToUserNameTextbox("user01");

        adminLoginPage.sendKeysToPasswordTextbox("guru99com");

        adminManageCustomersPage = adminLoginPage.clickLoginButton();

        adminManageCustomersPage.closePopup();

        Assert.assertTrue(adminManageCustomersPage.isUserInfoDisplayed(firstName, emailAddress));

        adminManageCustomersPage.deleteUserAccount(firstName, emailAddress);

        Assert.assertEquals(adminManageCustomersPage.getDeletedSuccessMessage(), "Total of 1 record(s) were deleted.");

        adminLoginPage = adminManageCustomersPage.clickLogout();
    }

    @Test
    public void TC_03_Portal_Site_Verify_Account_Is_Deleted() {
        portalHomePage = adminLoginPage.openPortalAppUrl(driver, portalAppUrl);

        portalLoginPage = portalHomePage.selectLoginInMyAccountHeaderDropdown();

        portalLoginPage.loginToSystem(emailAddress, password);

        Assert.assertEquals(portalLoginPage.getLoginErrorMessage(), "Invalid login or password.");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
