package pageObjects.magento.common;

import org.openqa.selenium.WebDriver;

public class AdminPageObject extends ProjectPageObject {
    private WebDriver driver;

    public AdminPageObject(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

}
