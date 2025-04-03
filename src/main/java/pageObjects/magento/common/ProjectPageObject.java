package pageObjects.magento.common;

import commons.BasePage;
import commons.PageGeneratorManager;
import org.openqa.selenium.WebDriver;
import pageObjects.magento.admin.AdminLoginPageObject;
import pageObjects.magento.portal.PortalHomePageObject;

public class ProjectPageObject extends BasePage {
    private WebDriver driver;

    public ProjectPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public PortalHomePageObject openPortalAppUrl(WebDriver driver, String portalAppUrl) {
        openPage(driver, portalAppUrl);
        return PageGeneratorManager.getPortalHomePage(driver);
    }

    public AdminLoginPageObject openAdminAppUrl(WebDriver driver, String adminAppUrl) {
        openPage(driver, adminAppUrl);
        return PageGeneratorManager.getAdminLoginPage(driver);
    }

}
