package afc.magento;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalRegisterPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;

@Listeners({commons.TestFailuresListener.class})
public class Level_11_Assert_Verify extends BaseTest {
    private WebDriver driver;
    private PortalHomePageObject homePage;
    private PortalRegisterPageObject registerPage;
    private PortalAccountDashboardPageObject accountDashboardPage;
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
    }

    @Test
    public void User_01_Register() {
        registerPage = homePage.selectRegisterInMyAccountHeaderDropdown();

        registerPage.sendKeysToFirstNameTextbox(firstName);

        registerPage.sendKeysToLastNameTextbox(lastName);

        registerPage.sendKeysToEmailTextbox(emailAddress);

        registerPage.sendKeysToPasswordTextbox(password);

        registerPage.sendKeysToConfirmPasswordTextbox(password);

        accountDashboardPage = registerPage.clickRegisterButton();
    }

    @Test
    public void User_02_Verify() {
        verifyEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store");

        verifyEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        String contactInfo = accountDashboardPage.getContactInformationText();
        verifyTrue(contactInfo.contains(fullName));
        verifyFalse(contactInfo.contains(emailAddress));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
