package pageObjects.demo;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.demo.SortProductsPageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProductsPageObject extends BasePage {
    private WebDriver driver;

    public SortProductsPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isProductsPageTitleDisplayed() {
        waitForElementToBeVisible(driver, SortProductsPageUI.PRODUCTS_PAGE_TITLE);
        return isElementDisplayed(driver, SortProductsPageUI.PRODUCTS_PAGE_TITLE);
    }

    public void selectProductSortDropdown(String optionValue) {
        waitForElementToBeClickable(driver, SortProductsPageUI.PRODUCT_SORT_DROPDOWN);
        selectOptionInDefaultDropdown(driver, SortProductsPageUI.PRODUCT_SORT_DROPDOWN, optionValue);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    private List<String> getProductNames() {
        waitForAllElementsToBeVisible(driver, SortProductsPageUI.PRODUCT_NAMES);
        List<WebElement> nameElements = getWebElements(driver, SortProductsPageUI.PRODUCT_NAMES);
        List<String> namesList = new ArrayList<>();
        for (WebElement name : nameElements) {
            namesList.add(name.getText().trim());
        }
        return namesList;
    }

    public boolean areProductsDisplayedSortedAscendingByName() {
        List<String> namesList = getProductNames();
        List<String> sortedList = new ArrayList<>(namesList);
        Collections.sort(sortedList);
        for (String name : sortedList) {
            System.out.println(name);
        }
        return namesList.equals(sortedList);
    }

    public boolean areProductsDisplayedSortedDescendingByName() {
        List<String> namesList = getProductNames();
        List<String> sortedList = new ArrayList<>(namesList);
        Collections.sort(sortedList, Collections.reverseOrder());
        for (String name : sortedList) {
            System.out.println(name);
        }
        return namesList.equals(sortedList);
    }

    private List<Double> getProductPrices() {
        waitForAllElementsToBeVisible(driver, SortProductsPageUI.PRODUCT_PRICES);
        List<WebElement> priceElements = getWebElements(driver, SortProductsPageUI.PRODUCT_PRICES);
        List<Double> pricesList = new ArrayList<>();
        for (WebElement price : priceElements) {
            pricesList.add(Double.parseDouble(price.getText().trim().replace("$", "")));
        }
        return pricesList;
    }

    public boolean areProductsDisplayedSortedAscendingByPrice() {
        List<Double> pricesList = getProductPrices();
        List<Double> sortedList = new ArrayList<>(pricesList);
        Collections.sort(sortedList);
        for (Double price : sortedList) {
            System.out.printf("$%.2f%n", price);
        }
        return pricesList.equals(sortedList);
    }

    public boolean areProductsDisplayedSortedDescendingByPrice() {
        List<Double> pricesList = getProductPrices();
        List<Double> sortedList = new ArrayList<>(pricesList);
        Collections.sort(sortedList, Collections.reverseOrder());
        for (Double price : sortedList) {
            System.out.printf("$%.2f%n", price);
        }
        return pricesList.equals(sortedList);
    }

}
