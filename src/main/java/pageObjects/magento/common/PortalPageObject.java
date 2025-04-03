package pageObjects.magento.common;

import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageUIs.magento.common.PortalPageUI;
import pageUIs.magento.portal.PortalHomePageUI;

public class PortalPageObject extends ProjectPageObject {
    private WebDriver driver;

    public PortalPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public PortalPageObject selectAccountHeaderDropdownWithValue(String optionValue) {
        waitForElementToBeClickable(driver, PortalPageUI.ACCOUNT_HEADER_DROPDOWN);
        selectOptionInCustomDropdown(driver, PortalPageUI.ACCOUNT_HEADER_DROPDOWN, PortalHomePageUI.MY_ACCOUNT_HEADER_DROPDOWN_OPTIONS, optionValue);
        return switch (optionValue) {
            case "Register" -> PageGeneratorManager.getPortalRegisterPage(driver);
            case "Log Out" -> PageGeneratorManager.getPortalHomePage(driver);
            default -> throw new RuntimeException("Incorrect option value" + optionValue);
        };
    }

    public void sendKeysToTextboxByTitle(String textboxTitle, String keysToSend) {
        waitForElementToBeVisible(driver, PortalPageUI.TEXTBOX_BY_TITLE, textboxTitle);
        sendKeysToElement(driver, PortalPageUI.TEXTBOX_BY_TITLE, keysToSend, textboxTitle);
    }

    public PortalPageObject clickMyAccountSidebarLinkByLinkText(String linkTextValue) {
        waitForElementToBeClickable(driver, PortalPageUI.MY_ACCOUNT_SIDEBAR_LINK_BY_LINK_TEXT, linkTextValue);
        clickElement(driver, PortalPageUI.MY_ACCOUNT_SIDEBAR_LINK_BY_LINK_TEXT, linkTextValue);
        return switch (linkTextValue) {
            case "Account Information" -> PageGeneratorManager.getPortalAccountInformationPage(driver);
            case "Address Book" -> PageGeneratorManager.getPortalAddressBookPage(driver);
            default -> throw new RuntimeException("Incorrect link text value" + linkTextValue);
        };
    }

    public boolean isMyAccountPageTitleDisplayedByHeader(String pageTitle) {
        waitForElementToBeVisible(driver, PortalPageUI.MY_ACCOUNT_PAGE_TITLE_BY_HEADER, pageTitle);
        return isElementDisplayed(driver, PortalPageUI.MY_ACCOUNT_PAGE_TITLE_BY_HEADER, pageTitle);
    }

}
