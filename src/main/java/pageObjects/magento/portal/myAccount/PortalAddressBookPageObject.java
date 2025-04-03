package pageObjects.magento.portal.myAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.magento.portal.myAccount.PortalAddressBookPageUI;

public class PortalAddressBookPageObject extends PortalMyAccountSidebar {
    private WebDriver driver;

    public PortalAddressBookPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, PortalAddressBookPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, PortalAddressBookPageUI.PAGE_TITLE);
    }

}
