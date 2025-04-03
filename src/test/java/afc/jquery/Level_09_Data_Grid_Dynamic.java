package afc.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Level_09_Data_Grid_Dynamic extends BaseTest {
    private WebDriver driver;
    private WebTablePageObject webTablePage;

    @Parameters({"browser", "dynamicUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
    }

    @Test
    public void TC_01_Cell_Interaction() {
        webTablePage.sendKeysToTextboxByLabelAndRow("Company", "1", "AFC");

        webTablePage.sendKeysToTextboxByLabelAndRow("Contact Person", "2", "Dong");

        webTablePage.selectCountryDropdownByRow("3", "United States");

        webTablePage.checkNPOChekboxByRow("1");

        webTablePage.sendKeysToTextboxByLabelAndRow("Order Placed", "2", "12345");

        webTablePage.setDateInDatePickerByRow("3", "04/03/2025");

        webTablePage.clickActionButtonByRowAndTitle("1", "Insert Row Above");

        webTablePage.clickActionButtonByRowAndTitle("1", "Remove Current Row");

        webTablePage.clickActionButtonByRowAndTitle("3", "Move Up");

        webTablePage.clickActionButtonByRowAndTitle("2", "Move Down");

        webTablePage.uncheckNPOChekboxByRow("1");
    }

    @Test
    public void TC_02_Load_Data() {
        webTablePage.clickLoadDataButon();

        webTablePage.clickAppendRowButton();

        webTablePage.sendKeysToTextboxByLabelAndRow("Company", "9", "AFC");

        webTablePage.sendKeysToTextboxByLabelAndRow("Contact Person", "9", "Dong");

        webTablePage.selectCountryDropdownByRow("9", "Japan");

        webTablePage.checkNPOChekboxByRow("9");

        webTablePage.sendKeysToTextboxByLabelAndRow("Order Placed", "9", "1310");

        webTablePage.setDateInDatePickerByRow("9", "04/03/2025");

        webTablePage.uncheckNPOChekboxByRow("9");

        webTablePage.clickRemoveLastRowButton();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
