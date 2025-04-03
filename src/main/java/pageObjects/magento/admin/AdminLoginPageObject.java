package pageObjects.magento.admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.common.AdminPageObject;
import pageUIs.magento.admin.AdminLoginPageUI;

public class AdminLoginPageObject extends AdminPageObject {
    private WebDriver driver;

    public AdminLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeysToUserNameTextbox(String userName) {
        waitForElementToBeVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.USERNAME_TEXTBOX, userName);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public AdminManageCustomersPageObject clickLoginButton() {
        waitForElementToBeClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGeneratorManager.getAdminManageCustomersPage(driver);
    }

}
