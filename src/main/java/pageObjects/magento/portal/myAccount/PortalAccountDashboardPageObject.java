package pageObjects.magento.portal.myAccount;

import commons.PageGeneratorManager;
import io.qameta.allure.Step;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.portal.PortalHomePageObject;
import pageUIs.magento.portal.myAccount.PortalAccountDashboardPageUI;

import java.util.Set;

public class PortalAccountDashboardPageObject extends PortalMyAccountSidebar {
    private WebDriver driver;

    public PortalAccountDashboardPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Step("Get the registration success message")
    public String getRegisterSuccessMessage() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
        return getElementText(driver, PortalAccountDashboardPageUI.REGISTER_SUCCESS_MESSAGE);
    }

    @Step("Get the welcome message")
    public String getWelcomeMessage() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.WELCOME_MESSAGE);
        return getElementText(driver, PortalAccountDashboardPageUI.WELCOME_MESSAGE);
    }

    @Step("Get the contact information text")
    public String getContactInformationText() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
        return getElementText(driver, PortalAccountDashboardPageUI.CONTACT_INFORMATION_TEXT);
    }

    @Step("Check if the page title is displayed")
    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, PortalAccountDashboardPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, PortalAccountDashboardPageUI.PAGE_TITLE);
    }

    @Step("Verify the visibility of the page title")
    public PortalHomePageObject selectLogoutInMyAccountHeaderDropdown() {
        waitForElementToBeClickable(driver, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN, PortalAccountDashboardPageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, "Log Out");
        sleepForSeconds(8);
        return PageGeneratorManager.getPortalHomePage(driver);
    }

    public Set<Cookie> getCookiesAfterLogin() {
        return getCookies(driver);
    }

}
