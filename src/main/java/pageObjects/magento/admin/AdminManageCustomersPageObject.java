package pageObjects.magento.admin;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.common.AdminPageObject;
import pageUIs.magento.admin.AdminManageCustomersPageUI;

public class AdminManageCustomersPageObject extends AdminPageObject {
    private WebDriver driver;

    public AdminManageCustomersPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void closePopup() {
        waitForElementToBeVisible(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
        clickElement(driver, AdminManageCustomersPageUI.POPUP_CLOSE_BUTTON);
    }

    public boolean isUserInfoDisplayed(String firstName, String emailAddress) {
        waitForElementToBeVisible(driver, AdminManageCustomersPageUI.CUSTOMER_INFO_BY_NAME_EMAIL, firstName, emailAddress);
        return isElementDisplayed(driver, AdminManageCustomersPageUI.CUSTOMER_INFO_BY_NAME_EMAIL, firstName, emailAddress);
    }

    public void deleteUserAccount(String firstName, String emailAddress) {
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.CUSTOMER_CHECKBOX_BY_NAME_EMAIL, firstName, emailAddress);
        checkDefaultCheckboxOrRadioButton(driver, AdminManageCustomersPageUI.CUSTOMER_CHECKBOX_BY_NAME_EMAIL, firstName, emailAddress);
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.ACTIONS_DROPDOWN);
        selectOptionInDefaultDropdown(driver, AdminManageCustomersPageUI.ACTIONS_DROPDOWN, "Delete");
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.SUBMIT_BUTTON);
        clickElement(driver, AdminManageCustomersPageUI.SUBMIT_BUTTON);
        acceptAlert(driver);
        acceptAlert(driver);
    }

    public String getDeletedSuccessMessage() {
        waitForElementToBeVisible(driver, AdminManageCustomersPageUI.DELETED_SUCCESS_MESSAGE);
        return getElementText(driver, AdminManageCustomersPageUI.DELETED_SUCCESS_MESSAGE);
    }

    public AdminLoginPageObject clickLogout() {
        waitForElementToBeClickable(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        clickElement(driver, AdminManageCustomersPageUI.LOGOUT_LINK);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

}
