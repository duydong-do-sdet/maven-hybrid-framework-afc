package pageObjects.magento.portal;

import commons.PageGeneratorManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.common.PortalPageObject;
import pageObjects.magento.portal.myAccount.PortalAccountDashboardPageObject;
import pageUIs.magento.portal.PortalLoginPageUI;

import java.util.Set;

public class PortalLoginPageObject extends PortalPageObject {
    private WebDriver driver;

    public PortalLoginPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        waitForElementToBeVisible(driver, PortalLoginPageUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver, PortalLoginPageUI.EMAIL_TEXTBOX, emailAddress);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, PortalLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, PortalLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public PortalAccountDashboardPageObject clickLoginButton() {
        waitForElementToBeClickable(driver, PortalLoginPageUI.LOGIN_BUTTON);
        clickElement(driver, PortalLoginPageUI.LOGIN_BUTTON);
        acceptAlert(driver);
        return PageGeneratorManager.getPortalAccountDashboardPage(driver);
    }

    public String getLoginErrorMessage() {
        waitForElementToBeVisible(driver, PortalLoginPageUI.LOGIN_ERROR_MESSAGE);
        return getElementText(driver, PortalLoginPageUI.LOGIN_ERROR_MESSAGE);
    }

    public PortalAccountDashboardPageObject loginToSystem(String emailAddress, String password) {
        sendKeysToEmailTextbox(emailAddress);
        sendKeysToPasswordTextbox(password);
        return clickLoginButton();
    }

    public PortalAccountDashboardPageObject loginByCookies(Set<Cookie> cookies) {
        setCookies(driver, cookies);
        refreshPage(driver);
        return PageGeneratorManager.getPortalAccountDashboardPage(driver);
    }

}
