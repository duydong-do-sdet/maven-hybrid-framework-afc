package pageObjects.magento.portal.myAccount;

import org.openqa.selenium.WebDriver;
import pageUIs.magento.portal.myAccount.PortalAccountInformationPageUI;

public class PortalAccountInformationPageObject extends PortalMyAccountSidebar {
    private WebDriver driver;

    public PortalAccountInformationPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public boolean isPageTitleDisplayed() {
        waitForElementToBeVisible(driver, PortalAccountInformationPageUI.PAGE_TITLE);
        return isElementDisplayed(driver, PortalAccountInformationPageUI.PAGE_TITLE);
    }

}
