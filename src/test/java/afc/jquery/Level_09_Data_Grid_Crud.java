package afc.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Level_09_Data_Grid_Crud extends BaseTest {
    private WebDriver driver;
    private WebTablePageObject webTablePage;

    @Parameters({"browser", "crudUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
    }

    @Test
    public void TC_01_Pagination_Filter_Data() {
        webTablePage.clickPaginationLinkByNumber("23");

        Assert.assertTrue(webTablePage.isPaginationLinkActiveByNumber("23"));

        webTablePage.sendKeysToFilterTextboxByLabel("Country", "Vietnam");

        Assert.assertTrue(webTablePage.isDataRowDisplayedByValues("642000", "Vietnam", "678000", "1320000"));

        webTablePage.clickPaginationLinkByNumber("11");

        Assert.assertTrue(webTablePage.isPaginationLinkActiveByNumber("11"));

        webTablePage.sendKeysToFilterTextboxByLabel("Country", "Japan");

        Assert.assertTrue(webTablePage.isDataRowDisplayedByValues("581262", "Japan", "610166", "1191442"));
    }

    @Test
    public void TC_02_CRUD_Data() {
        webTablePage.clickAddRowButton();

        webTablePage.addRecord("12345", "Teyvat", "11111", "23456");

        webTablePage.clickPaginationLinkByNumber("24");

        Assert.assertTrue(webTablePage.isPaginationLinkActiveByNumber("24"));

        webTablePage.sendKeysToFilterTextboxByLabel("Country", "Teyvat");

        Assert.assertTrue(webTablePage.isDataRowDisplayedByValues("12345", "Teyvat", "11111", "23456"));
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
