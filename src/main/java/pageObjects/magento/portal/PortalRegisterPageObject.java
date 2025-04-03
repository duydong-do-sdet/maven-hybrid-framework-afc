package pageObjects.magento.portal;

import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.common.PortalPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;
import pageUIs.magento.portal.PortalRegisterPageUI;
import testdata.PojoData;

public class PortalRegisterPageObject extends PortalPageObject {
    private WebDriver driver;

    public PortalRegisterPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Enter '{firstName}' into the First Name textbox")
    public void sendKeysToFirstNameTextbox(String firstName) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.FIRSTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
    }

    @Step("Enter '{lastName}' into the Last Name textbox")
    public void sendKeysToLastNameTextbox(String lastName) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.LASTNAME_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.LASTNAME_TEXTBOX, lastName);
    }

    @Step("Enter '{emailAddress}' into the Email textbox")
    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    @Step("Enter '{password}' into the Password textbox")
    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.PASSWORD_TEXTBOX, password);
    }

    @Step("Enter '{confirmPassword}' into the Confirm Password textbox")
    public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
        waitForElementToBeVisible(driver, PortalRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    @Step("Click the 'Register' button")
    public PortalAccountDashboardPageObject clickRegisterButton() {
        waitForElementToBeClickable(driver, PortalRegisterPageUI.REGISTER_BUTTON);
        clickElement(driver, PortalRegisterPageUI.REGISTER_BUTTON);
        acceptAlert(driver);
        return PageGeneratorManager.getPortalAccountDashboardPage(driver);
    }

    @Step("Register a new user account with First Name: '{firstName}', Last Name: '{lastName}', Email: '{emailAddress}', and Password: '{password}'")
    public PortalAccountDashboardPageObject registerNewUserAccount(String firstName, String lastName, String emailAddress, String password) {
        sendKeysToFirstNameTextbox(firstName);
        sendKeysToLastNameTextbox(lastName);
        sendKeysToEmailTextbox(emailAddress);
        sendKeysToPasswordTextbox(password);
        sendKeysToConfirmPasswordTextbox(password);
        return clickRegisterButton();
    }

    public void sendKeysToRegisterForm(PojoData pojoData) {
        sendKeysToFirstNameTextbox(pojoData.getFirstName());
        sendKeysToLastNameTextbox(pojoData.getLastName());
        sendKeysToEmailTextbox(pojoData.getEmailAddress());
        sendKeysToPasswordTextbox(pojoData.getPassword());
        sendKeysToConfirmPasswordTextbox(pojoData.getPassword());
    }

}
