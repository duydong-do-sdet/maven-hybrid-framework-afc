package pageFactory;

import commons.BaseFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageFactory extends BaseFactory {
    private WebDriver driver;

    public RegisterPageFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstnameTextbox;

    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastnameTextbox;

    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement emailTextbox;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordTextbox;

    @FindBy(xpath = "//input[@id='confirmation']")
    private WebElement confirmPasswordTextbox;

    @FindBy(xpath = "//button[@title='Register']")
    private WebElement registerButton;

    public void sendKeysToFirstNameTextbox(String firstName) {
        sendKeysToElement(driver, firstnameTextbox, firstName);
    }

    public void sendKeysToLastNameTextbox(String lastName) {
        sendKeysToElement(driver, lastnameTextbox, lastName);
    }

    public void sendKeysToEmailTextbox(String emailAddress) {
        sendKeysToElement(driver, emailTextbox, emailAddress);
    }

    public void sendKeysToPasswordTextbox(String password) {
        sendKeysToElement(driver, passwordTextbox, password);
    }

    public void sendKeysToConfirmPasswordTextbox(String confirmPassword) {
        sendKeysToElement(driver, confirmPasswordTextbox, confirmPassword);
    }

    public void clickRegisterButton() {
        clickElement(driver, registerButton);
        acceptAlert(driver);
    }

}
