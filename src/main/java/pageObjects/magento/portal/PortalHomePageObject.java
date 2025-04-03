package pageObjects.magento.portal;

import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.common.PortalPageObject;
import pageUIs.magento.portal.PortalHomePageUI;

public class PortalHomePageObject extends PortalPageObject {
    private WebDriver driver;

    public PortalHomePageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Select 'Register' option from 'Account' header dropdown")
    public PortalRegisterPageObject selectRegisterInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Register");
        return PageGeneratorManager.getPortalRegisterPage(driver);
    }

    @Step("Select 'Login' option from 'Account' header dropdown")
    public PortalLoginPageObject selectLoginInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log In");
        return PageGeneratorManager.getPortalLoginPage(driver);
    }

    public boolean isLogoutSuccessMessageDisplayed() {
        waitForElementToBeVisible(driver, PortalHomePageUI.LOGOUT_SUCCESS_MESSAGE);
        return isElementDisplayed(driver, PortalHomePageUI.LOGOUT_SUCCESS_MESSAGE);
    }

    public boolean isLogoutSuccessMessageUndisplayed() {
        waitForElementToBeInvisible(driver, PortalHomePageUI.LOGOUT_SUCCESS_MESSAGE);
        return isElementUndisplayed(driver, PortalHomePageUI.LOGOUT_SUCCESS_MESSAGE);
    }

    public boolean isHomePageTitleDisplayed() {
        waitForElementToBeVisible(driver, PortalHomePageUI.HOME_PAGE_TITLE);
        return isElementDisplayed(driver, PortalHomePageUI.HOME_PAGE_TITLE);
    }

}
