package pageFactory;

import commons.BaseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountDashboardPageFactory extends BaseFactory {
    private WebDriver driver;

    public AccountDashboardPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//li[@class='success-msg']//span")
    private WebElement registerSuccessMessage;

    @FindBy(xpath = "//div[@class='welcome-msg']//strong")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div/p")
    private WebElement contactInformationText;

    public String getRegisterSuccessMessage() {
        return getElementText(driver, registerSuccessMessage);
    }

    public String getWelcomeMessage() {
        return getElementText(driver, welcomeMessage);
    }

    public String getContactInformationText() {
        return getElementText(driver, contactInformationText);
    }

}
