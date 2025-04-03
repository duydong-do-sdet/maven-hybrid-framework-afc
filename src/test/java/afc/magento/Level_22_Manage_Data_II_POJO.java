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
import testdata.PojoData;

public class Level_22_Manage_Data_II_POJO extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject homePage;
    private PortalRegisterPageObject registerPage;
    private PortalAccountDashboardPageObject accountDashboardPage;
    private PortalAccountInformationPageObject accountInformationPage;
    private PortalAddressBookPageObject addressBookPage;
    private String fullName;
    private PojoData pojoData;

    @Parameters({"browser", "portalUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        homePage = PageGeneratorManager.getPortalHomePage(driver);

        pojoData = PojoData.getPojoData();

        pojoData.setFirstName("Dong");
        pojoData.setLastName("Do");
        pojoData.setEmailAddress("dongafc" + getRandomNumber() + "@gmail.com");
        pojoData.setPassword("SeJava@4");

        fullName = pojoData.getFirstName() + " " + pojoData.getLastName();
    }

    @Test
    public void User_01_Register() {
        registerPage = (PortalRegisterPageObject) homePage.selectAccountHeaderDropdownWithValue("Register");

        registerPage.sendKeysToRegisterForm(pojoData);

        accountDashboardPage = registerPage.clickRegisterButton();
    }

    @Test
    public void User_02_My_Dashboard() {
        Assert.assertTrue(accountDashboardPage.isMyAccountPageTitleDisplayedByHeader("My Dashboard"));

        Assert.assertEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store.");

        Assert.assertEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = accountDashboardPage.getContactInformationText();
        Assert.assertTrue(contactInfo.contains(fullName));
        Assert.assertTrue(contactInfo.contains(pojoData.getEmailAddress()));
    }

    @Test
    public void User_03_Account_Information() {
        accountInformationPage = (PortalAccountInformationPageObject) accountDashboardPage.clickMyAccountSidebarLinkByLinkText("Account Information");

        Assert.assertTrue(accountInformationPage.isMyAccountPageTitleDisplayedByHeader("Edit Account Information"));
    }

    @Test
    public void User_04_Address_Book() {
        addressBookPage = (PortalAddressBookPageObject) accountInformationPage.clickMyAccountSidebarLinkByLinkText("Address Book");

        Assert.assertTrue(addressBookPage.isMyAccountPageTitleDisplayedByHeader("Add New Address"));
    }

    @Test
    public void User_05_Logout() {
        homePage = (PortalHomePageObject) addressBookPage.selectAccountHeaderDropdownWithValue("Log Out");

        Assert.assertTrue(homePage.isLogoutSuccessMessageDisplayed());

        Assert.assertTrue(homePage.isLogoutSuccessMessageUndisplayed());

        Assert.assertTrue(homePage.isHomePageTitleDisplayed());
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
