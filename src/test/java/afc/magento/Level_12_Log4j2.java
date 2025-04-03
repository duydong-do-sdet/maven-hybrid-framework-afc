package afc.magento;

import commons.BaseTest;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pageObjects.magento.portal.PortalHomePageObject;
import pageObjects.magento.portal.PortalRegisterPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;

@Listeners({commons.TestFailuresListener.class})
public class Level_12_Log4j2 extends BaseTest {
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
        log.info("User_01_Register - Step 01: Select 'Register' in 'Account' header dropdown");
        registerPage = homePage.selectRegisterInMyAccountHeaderDropdown();

        log.info("User_01_Register - Step 02: Enter '" + firstName + "' in 'FirstName' textbox");
        registerPage.sendKeysToFirstNameTextbox(firstName);

        log.info("User_01_Register - Step 03: Enter '" + lastName + "' in 'LastName' textbox");
        registerPage.sendKeysToLastNameTextbox(lastName);

        log.info("User_01_Register - Step 04: Enter '" + emailAddress + "' in 'Email' textbox");
        registerPage.sendKeysToEmailTextbox(emailAddress);

        log.info("User_01_Register - Step 05: Enter '" + password + "' in 'Password' textbox");
        registerPage.sendKeysToPasswordTextbox(password);

        log.info("User_01_Register - Step 06: Enter '" + password + "' in 'Confirm Password' textbox");
        registerPage.sendKeysToConfirmPasswordTextbox(password);

        log.info("User_01_Register - Step 07: Click 'Register' button");
        accountDashboardPage = registerPage.clickRegisterButton();
    }

    @Test
    public void User_02_Verify() {
        log.info("User_02_Verify - Step 01: Verify register success message");
        verifyEquals(accountDashboardPage.getRegisterSuccessMessage(), "Thank you for registering with Main Website Store");

        log.info("User_02_Verify - Step 02: Verify welcome message");
        verifyEquals(accountDashboardPage.getWelcomeMessage(), "Hello, " + fullName + "!");

        log.info("User_02_Verify - Step 03: Verify contact information message");
        String contactInfo = accountDashboardPage.getContactInformationText();
        verifyTrue(contactInfo.contains(fullName));
        verifyFalse(contactInfo.contains(emailAddress));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
