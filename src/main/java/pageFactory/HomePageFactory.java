package pageFactory;

import commons.BaseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePageFactory extends BaseFactory {
    private WebDriver driver;

    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header//span[text()='Account']")
    private WebElement myAccountHeaderDropdown;

    @FindBy(xpath = "//div[@id='header-account']//a")
    private List<WebElement> myAccountHeaderDropdownOptions;

    public void selectRegisterInMyAccountHeaderDropdown() {
        selectOptionInCustomDropdown(driver, myAccountHeaderDropdown, myAccountHeaderDropdownOptions, "Register");
    }

}
