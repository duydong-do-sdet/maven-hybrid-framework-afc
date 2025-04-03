package pageObjects.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.demo.SortLoginPageUI;

public class SortLoginPageObject extends BasePage {
    private WebDriver driver;

    public SortLoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeysToUsernameTextbox(String username) {
        waitForElementToBeVisible(driver, SortLoginPageUI.USERNAME_TEXTBOX);
        sendKeysToElement(driver, SortLoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void sendKeysToPasswordTextbox(String password) {
        waitForElementToBeVisible(driver, SortLoginPageUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, SortLoginPageUI.PASSWORD_TEXTBOX, password);
    }

    public SortProductsPageObject clickToLoginButton() {
        waitForElementToBeClickable(driver, SortLoginPageUI.LOGIN_BUTTON);
        clickElement(driver, SortLoginPageUI.LOGIN_BUTTON);
        return DemoPageGenerator.getSortProductsPage(driver);
    }

}
