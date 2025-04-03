package afc.magento;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalRegisterPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountInformationPageObject;
import pageObjects.magento.portal.myAccount.PortalAddressBookPageObject;

public class Level_07_Page_Navigation extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject homePage;
    private PortalRegisterPageObject registerPage;
    private PortalAccountDashboardPageObject accountDashboardPage;
    private PortalAccountInformationPageObject accountInformationPage;
    private PortalAddressBookPageObject addressBookPage;
    private String firstName, lastName, fullName, emailAddress, password;

    @Parameters({"browser", "portalUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getPortalHomePage(driver);

        firstName = "Dong";
        lastName = "Do";
        fullName = firstName + " " + lastName;
        emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
        password = "SeJava@4";

        registerPage = homePage.selectRegisterInMyAccountHeaderDropdown();
        accountDashboardPage = registerPage.registerNewUserAccount(firstName, lastName, emailAddress, password);
    }

    @Test
    public void User_01_Page_Navigation() {
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        accountInformationPage = accountDashboardPage.clickAccountInformationSidebarLink();
        Assert.assertTrue(accountInformationPage.isPageTitleDisplayed());

        addressBookPage = accountInformationPage.clickAddressBookSidebarLink();
        Assert.assertTrue(addressBookPage.isPageTitleDisplayed());

        accountDashboardPage = addressBookPage.clickAccountDashboardSidebarLink();
        Assert.assertTrue(accountDashboardPage.isPageTitleDisplayed());

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = accountDashboardPage.getContactInformationText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(emailAddress));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
