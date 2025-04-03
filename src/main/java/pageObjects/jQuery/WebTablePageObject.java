package pageObjects.jQuery;

import commons.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.WebTablePageUI;

public class WebTablePageObject extends BasePage {
    private WebDriver driver;

    public WebTablePageObject(WebDriver driver) {
        this.driver = driver;
    }

    // CRUD

    public void clickPaginationLinkByNumber(String number) {
        waitForElementToBeClickable(driver, WebTablePageUI.DYNAMIC_PAGINATION_LINK_BY_NUMBER, number);
        clickElement(driver, WebTablePageUI.DYNAMIC_PAGINATION_LINK_BY_NUMBER, number);
    }

    public boolean isPaginationLinkActiveByNumber(String number) {
        waitForElementToBeVisible(driver, WebTablePageUI.DYNAMIC_PAGINATION_LINK_BY_NUMBER, number);
        return getElementAttribute(driver, WebTablePageUI.DYNAMIC_PAGINATION_LINK_BY_NUMBER, "class", number).endsWith("active");
    }

    public void sendKeysToFilterTextboxByLabel(String label, String keysToSend) {
        waitForElementToBeVisible(driver, WebTablePageUI.DYNAMIC_FILTER_TEXTBOX_BY_LABEL, label);
        sendKeysToElement(driver, WebTablePageUI.DYNAMIC_FILTER_TEXTBOX_BY_LABEL, keysToSend, label);
        pressKeyOnElement(driver, WebTablePageUI.DYNAMIC_FILTER_TEXTBOX_BY_LABEL, Keys.ENTER, label);
    }

    public boolean isDataRowDisplayedByValues(String females, String country, String males, String total) {
        waitForElementToBeVisible(driver, WebTablePageUI.DYNAMIC_DATA_ROW_BY_VALUES, females, country, males, total);
        return isElementDisplayed(driver, WebTablePageUI.DYNAMIC_DATA_ROW_BY_VALUES, females, country, males, total);
    }

    public void clickAddRowButton() {
        waitForElementToBeClickable(driver, WebTablePageUI.ADD_ROW_BUTTON);
        clickElement(driver, WebTablePageUI.ADD_ROW_BUTTON);
    }

    public void sendKeysToFemalesTextbox(String females) {
        waitForElementToBeVisible(driver, WebTablePageUI.FEMALES_TEXTBOX, females);
        sendKeysToElement(driver, WebTablePageUI.FEMALES_TEXTBOX, females);
    }

    public void sendKeysToCountryTextbox(String country) {
        waitForElementToBeVisible(driver, WebTablePageUI.COUNTRY_TEXTBOX, country);
        sendKeysToElement(driver, WebTablePageUI.COUNTRY_TEXTBOX, country);
    }

    public void sendKeysToMalesTextbox(String males) {
        waitForElementToBeVisible(driver, WebTablePageUI.MALES_TEXTBOX, males);
        sendKeysToElement(driver, WebTablePageUI.MALES_TEXTBOX, males);
    }

    public void sendKeysToTotalTextbox(String total) {
        waitForElementToBeVisible(driver, WebTablePageUI.TOTAL_TEXTBOX, total);
        sendKeysToElement(driver, WebTablePageUI.TOTAL_TEXTBOX, total);
    }

    public void clickOkButton() {
        waitForElementToBeClickable(driver, WebTablePageUI.OK_BUTTON);
        clickElement(driver, WebTablePageUI.OK_BUTTON);
    }

    public void addRecord(String females, String country, String males, String total) {
        sendKeysToFemalesTextbox(females);
        sendKeysToCountryTextbox(country);
        sendKeysToMalesTextbox(males);
        sendKeysToTotalTextbox(total);
        clickOkButton();
    }

    // Dynamic

    public void sendKeysToTextboxByLabelAndRow(String label, String row, String keysToSend) {
        int columnIndex = getElementCount(driver, WebTablePageUI.COLUMN_INDEX_BY_LABEL, label) + 1;
        waitForElementToBeVisible(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, row, String.valueOf(columnIndex));
        sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_ROW_AND_COLUMN_INDEX, keysToSend, row, String.valueOf(columnIndex));
    }

    public void selectCountryDropdownByRow(String row, String optionValue) {
        waitForElementToBeClickable(driver, WebTablePageUI.COUNTRY_DROPDOWN_BY_ROW, row);
        selectOptionInDefaultDropdown(driver, WebTablePageUI.COUNTRY_DROPDOWN_BY_ROW, optionValue, row);
    }

    public void checkNPOChekboxByRow(String row) {
        waitForElementToBeClickable(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, row);
        checkDefaultCheckboxOrRadioButton(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, row);
    }

    public void uncheckNPOChekboxByRow(String row) {
        waitForElementToBeClickable(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, row);
        uncheckDefaultCheckbox(driver, WebTablePageUI.NPO_CHECKBOX_BY_ROW, row);
    }

    public void setDateInDatePickerByRow(String row, String dateValue) {
        waitForElementToBeVisible(driver, WebTablePageUI.MEMBER_SINCE_DATE_PICKER_BY_ROW, row);
        removeElementAttributeByJS(driver, WebTablePageUI.MEMBER_SINCE_DATE_PICKER_BY_ROW, "type", row);
        sendKeysToElement(driver, WebTablePageUI.MEMBER_SINCE_DATE_PICKER_BY_ROW, dateValue, row);
    }

    public void clickActionButtonByRowAndTitle(String row, String actionTitle) {
        waitForElementToBeClickable(driver, WebTablePageUI.ACTION_BUTTON_BY_TITLE, row, actionTitle);
        clickElement(driver, WebTablePageUI.ACTION_BUTTON_BY_TITLE, row, actionTitle);
    }

    public void clickLoadDataButon() {
        waitForElementToBeClickable(driver, WebTablePageUI.LOAD_DATA_BUTTON);
        clickElement(driver, WebTablePageUI.LOAD_DATA_BUTTON);
    }

    public void clickAppendRowButton() {
        waitForElementToBeClickable(driver, WebTablePageUI.APPEND_ROW_BUTTON);
        clickElement(driver, WebTablePageUI.APPEND_ROW_BUTTON);
    }

    public void clickRemoveLastRowButton() {
        waitForElementToBeClickable(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
        clickElement(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
    }

}
