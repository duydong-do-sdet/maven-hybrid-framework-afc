package pageObjects.demo;

import org.openqa.selenium.WebDriver;

public class DemoPageGenerator {

    public static UndisplayedPageObject getUndisplayedPage(WebDriver driver) {
        return new UndisplayedPageObject(driver);
    }

    public static SortLoginPageObject getSortLoginPage(WebDriver driver) {
        return new SortLoginPageObject(driver);
    }

    public static SortProductsPageObject getSortProductsPage(WebDriver driver) {
        return new SortProductsPageObject(driver);
    }

}
