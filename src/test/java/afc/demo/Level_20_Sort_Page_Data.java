package afc.demo;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.demo.DemoPageGenerator;
import pageObjects.demo.SortLoginPageObject;
import pageObjects.demo.SortProductsPageObject;

public class Level_20_Sort_Page_Data extends BaseTest {
    private WebDriver driver;
    private SortLoginPageObject sortingPage;
    private SortProductsPageObject sortProductsPage;

    @Parameters({"browser", "sortUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        sortingPage = DemoPageGenerator.getSortLoginPage(driver);
    }

    @Test
    public void TC_01_Login() {
        sortingPage.sendKeysToUsernameTextbox("standard_user");

        sortingPage.sendKeysToPasswordTextbox("secret_sauce");

        sortProductsPage = sortingPage.clickToLoginButton();

        Assert.assertTrue(sortProductsPage.isProductsPageTitleDisplayed());
    }

    @Test
    public void TC_02_Sort_ACS() {
        sortProductsPage.selectProductSortDropdown("Name (A to Z)");

        Assert.assertTrue(sortProductsPage.areProductsDisplayedSortedAscendingByName());

        sortProductsPage.selectProductSortDropdown("Price (low to high)");

        Assert.assertTrue(sortProductsPage.areProductsDisplayedSortedAscendingByPrice());
    }

    @Test
    public void TC_02_Sort_DESC() {
        sortProductsPage.selectProductSortDropdown("Name (Z to A)");

        Assert.assertTrue(sortProductsPage.areProductsDisplayedSortedDescendingByName());

        sortProductsPage.selectProductSortDropdown("Price (high to low)");

        Assert.assertTrue(sortProductsPage.areProductsDisplayedSortedDescendingByPrice());
    }

    @AfterClass()
    public void afterClass() {
        driver.quit();
    }

}
