package pageObjects.demo;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.demo.UndisplayedPageUI;

public class UndisplayedPageObject extends BasePage {
    private WebDriver driver;

    public UndisplayedPageObject(WebDriver driver) {
        this.driver = driver;
    }

    // In DOM

    public void clickStartButton() {
        waitForElementToBeClickable(driver, UndisplayedPageUI.START_BUTTON);
        clickElement(driver, UndisplayedPageUI.START_BUTTON);
    }

    public boolean isStartButtonUndisplayed() {
        waitForElementToBeInvisible(driver, UndisplayedPageUI.START_BUTTON);
        return isElementUndisplayed(driver, UndisplayedPageUI.START_BUTTON);
    }

    public boolean isLoadingIconDisplayed() {
        waitForElementToBeVisible(driver, UndisplayedPageUI.LOADING_ICON);
        return isElementDisplayed(driver, UndisplayedPageUI.LOADING_ICON);
    }

    public boolean isHelloWorldTextDisplayed() {
        waitForElementToBeVisible(driver, UndisplayedPageUI.HELLO_WORLD);
        return isElementDisplayed(driver, UndisplayedPageUI.HELLO_WORLD);
    }

    public boolean isLoadingIconUndisplayed() {
        waitForElementToBeInvisible(driver, UndisplayedPageUI.LOADING_ICON);
        return isElementUndisplayed(driver, UndisplayedPageUI.LOADING_ICON);
    }

    // Not in DOM

    public void clickRegisterButton() {
        waitForElementToBeClickable(driver, UndisplayedPageUI.REGISTER_BUTTON);
        clickElement(driver, UndisplayedPageUI.REGISTER_BUTTON);
    }

    public boolean isRegisterFormDialogDisplayed() {
        waitForElementToBeVisible(driver, UndisplayedPageUI.REGISTER_FORM_DIALOG);
        return isElementDisplayed(driver, UndisplayedPageUI.REGISTER_FORM_DIALOG);
    }

    public void clickCloseDialogButton() {
        waitForElementToBeClickable(driver, UndisplayedPageUI.CLOSE_DIALOG_BUTTON);
        clickElement(driver, UndisplayedPageUI.CLOSE_DIALOG_BUTTON);
    }

    public boolean isRegisterFormDialogUndisplayed() {
        waitForElementToBeInvisible(driver, UndisplayedPageUI.REGISTER_FORM_DIALOG);
        return isElementUndisplayed(driver, UndisplayedPageUI.REGISTER_FORM_DIALOG);
    }

    public boolean isTextFieldByPlaceholderDisplayed(String placeholderValue) {
        waitForElementToBeVisible(driver, UndisplayedPageUI.TEXT_FIELD_BY_PLACEHOLDER, placeholderValue);
        return isElementDisplayed(driver, UndisplayedPageUI.TEXT_FIELD_BY_PLACEHOLDER, placeholderValue);
    }

    public boolean isTextFieldByPlaceholderUndisplayed(String placeholderValue) {
        waitForElementToBeInvisible(driver, UndisplayedPageUI.TEXT_FIELD_BY_PLACEHOLDER, placeholderValue);
        return isElementUndisplayed(driver, UndisplayedPageUI.TEXT_FIELD_BY_PLACEHOLDER, placeholderValue);
    }

    public boolean areAllTextFieldsDisplayed(String... placeholderValues) {
        for (String value : placeholderValues) {
            if (!isTextFieldByPlaceholderDisplayed(value)) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllTextFieldsUndisplayed(String... placeholderValues) {
        for (String value : placeholderValues) {
            if (!isTextFieldByPlaceholderUndisplayed(value)) {
                return false;
            }
        }
        return true;
    }

}
