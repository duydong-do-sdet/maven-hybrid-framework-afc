package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    // WebDriver methods

    protected void openPage(WebDriver driver, String pageUrl) {
        driver.get(pageUrl);
    }

    protected String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    protected String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    protected String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    protected String getWindowId(WebDriver driver) {
        return driver.getWindowHandle();
    }

    protected Set<String> getAllWindowIds(WebDriver driver) {
        return driver.getWindowHandles();
    }

    protected void navigateBack(WebDriver driver) {
        driver.navigate().back();
    }

    protected void navigateForward(WebDriver driver) {
        driver.navigate().forward();
    }

    protected void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    protected void navigateToUrl(WebDriver driver, String pageUrl) {
        driver.navigate().to(pageUrl);
    }

    private Alert waitForAlert(WebDriver driver) {
        return initExplicitWait(driver).until(ExpectedConditions.alertIsPresent());
    }

    protected void acceptAlert(WebDriver driver) {
        waitForAlert(driver).accept();
    }

    protected void dismissAlert(WebDriver driver) {
        waitForAlert(driver).dismiss();
    }

    protected String getAlertText(WebDriver driver) {
        return waitForAlert(driver).getText();
    }

    protected void sendKeysToAlert(WebDriver driver, String keysToSend) {
        waitForAlert(driver).sendKeys(keysToSend);
    }

    protected void switchToOtherWindowByCurrentId(WebDriver driver, String windowId) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        if (allWindowIds.size() > 1) {
            for (String id : allWindowIds) {
                if (!id.equals(windowId)) {
                    driver.switchTo().window(id);
                    break;
                }
            }
        }
    }

    protected void switchToWindowByTitle(WebDriver driver, String windowTitle) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        for (String id : allWindowIds) {
            driver.switchTo().window(id);
            if (getPageTitle(driver).equals(windowTitle)) {
                break;
            }
        }
    }

    protected void closeAllWindowsExceptWindowById(WebDriver driver, String windowId) {
        Set<String> allWindowIds = getAllWindowIds(driver);
        for (String id : allWindowIds) {
            if (!id.equals(windowId)) {
                driver.switchTo().window(id);
                driver.close();
            }
        }
        driver.switchTo().window(windowId);
    }

    protected Set<Cookie> getCookies(WebDriver driver) {
        return driver.manage().getCookies();
    }

    protected void setCookies(WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    // WebElement methods

    private By getByXPath(String xpathLocator) {
        return By.xpath(xpathLocator);
    }

    private String getDynamicXPath(String xpathLocator, String... dynamicValues) {
        return String.format(xpathLocator, (Object[]) dynamicValues);
    }

    protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
        return driver.findElement(getByXPath(xpathLocator));
    }

    protected WebElement getWebElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return driver.findElement(getByXPath(getDynamicXPath(xpathLocator, dynamicValues)));
    }

    protected List<WebElement> getWebElements(WebDriver driver, String xpathLocator) {
        return driver.findElements(getByXPath(xpathLocator));
    }

    protected List<WebElement> getWebElements(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return driver.findElements(getByXPath(getDynamicXPath(xpathLocator, dynamicValues)));
    }

    protected void clickElement(WebDriver driver, String xpathLocator) {
        getWebElement(driver, xpathLocator).click();
    }

    protected void clickElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        getWebElement(driver, xpathLocator, dynamicValues).click();
    }

    protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend) {
        WebElement element = getWebElement(driver, xpathLocator);
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend, String... dynamicValues) {
        WebElement element = getWebElement(driver, xpathLocator, dynamicValues);
        element.clear();
        element.sendKeys(keysToSend);
    }

    protected String getElementText(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).getText();
    }

    protected String getElementText(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).getText();
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName) {
        return getWebElement(driver, xpathLocator).getDomAttribute(attributeName);
    }

    protected String getElementAttribute(WebDriver driver, String xpathLocator, String attributeName, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).getDomAttribute(attributeName);
    }

    protected String getElementProperty(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getDomProperty(propertyName);
    }

    protected String getElementProperty(WebDriver driver, String xpathLocator, String propertyName, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).getDomProperty(propertyName);
    }

    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
        return getWebElement(driver, xpathLocator).getCssValue(propertyName);
    }

    protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).getCssValue(propertyName);
    }

    protected String getElementColorHex(WebDriver driver, String xpathLocator, String propertyName) {
        return Color.fromString(getElementCssValue(driver, xpathLocator, propertyName)).asHex().toUpperCase();
    }

    protected String getElementColorHex(WebDriver driver, String xpathLocator, String propertyName, String... dynamicValues) {
        return Color.fromString(getElementCssValue(driver, xpathLocator, propertyName, dynamicValues)).asHex().toUpperCase();
    }

    protected int getElementCount(WebDriver driver, String xpathLocator) {
        return getWebElements(driver, xpathLocator).size();
    }

    protected int getElementCount(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElements(driver, xpathLocator, dynamicValues).size();
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isDisplayed();
    }

    protected boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).isDisplayed();
    }

    protected boolean isElementUndisplayed(WebDriver driver, String xpathLocator) {
        configureImplicitWait(driver, zeroTime);
        List<WebElement> elements = getWebElements(driver, xpathLocator);
        configureImplicitWait(driver, longTimeout);
        if (elements.isEmpty()) {
            return true;
        } else return !elements.getFirst().isDisplayed();
    }

    protected boolean isElementUndisplayed(WebDriver driver, String xpathLocator, String... dynamicValues) {
        configureImplicitWait(driver, zeroTime);
        List<WebElement> elements = getWebElements(driver, xpathLocator, dynamicValues);
        configureImplicitWait(driver, longTimeout);
        if (elements.isEmpty()) {
            return true;
        } else return !elements.getFirst().isDisplayed();
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isEnabled();
    }

    protected boolean isElementEnabled(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).isEnabled();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
        return getWebElement(driver, xpathLocator).isSelected();
    }

    protected boolean isElementSelected(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return getWebElement(driver, xpathLocator, dynamicValues).isSelected();
    }

    protected void selectOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String optionValue) {
        new Select(getWebElement(driver, xpathLocator)).selectByVisibleText(optionValue);
    }

    protected void selectOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String optionValue, String... dynamicValues) {
        new Select(getWebElement(driver, xpathLocator, dynamicValues)).selectByVisibleText(optionValue);
    }

    protected String getSelectedOptionInDefaultDropdown(WebDriver driver, String xpathLocator) {
        return new Select(getWebElement(driver, xpathLocator)).getFirstSelectedOption().getText();
    }

    protected String getSelectedOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return new Select(getWebElement(driver, xpathLocator, dynamicValues)).getFirstSelectedOption().getText();
    }

    protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator) {
        return new Select(getWebElement(driver, xpathLocator)).isMultiple();
    }

    protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return new Select(getWebElement(driver, xpathLocator, dynamicValues)).isMultiple();
    }

    protected void checkDefaultCheckboxOrRadioButton(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void checkDefaultCheckboxOrRadioButton(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebElement element = getWebElement(driver, xpathLocator, dynamicValues);
        if (!element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckDefaultCheckbox(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void uncheckDefaultCheckbox(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebElement element = getWebElement(driver, xpathLocator, dynamicValues);
        if (element.isSelected()) {
            element.click();
        }
    }

    protected void switchToFrame(WebDriver driver, String xpathLocator) {
        initExplicitWait(driver).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(xpathLocator)));
    }

    protected void switchToFrame(WebDriver driver, String xpathLocator, String... dynamicValues) {
        initExplicitWait(driver).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
    }

    protected void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    // Actions methods

    protected void moveToElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).moveToElement(getWebElement(driver, xpathLocator)).perform();
    }

    protected void moveToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        new Actions(driver).moveToElement(getWebElement(driver, xpathLocator, dynamicValues)).perform();
    }

    protected void clickAndHoldOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).clickAndHold(getWebElement(driver, xpathLocator)).perform();
    }

    protected void clickAndHoldOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        new Actions(driver).clickAndHold(getWebElement(driver, xpathLocator, dynamicValues)).perform();
    }

    protected void releaseMouseFromElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).release(getWebElement(driver, xpathLocator)).perform();
    }

    protected void releaseMouseFromElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        new Actions(driver).release(getWebElement(driver, xpathLocator, dynamicValues)).perform();
    }

    protected void rightClickOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).contextClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void rightClickOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        new Actions(driver).contextClick(getWebElement(driver, xpathLocator, dynamicValues)).perform();
    }

    protected void doubleClickOnElement(WebDriver driver, String xpathLocator) {
        new Actions(driver).doubleClick(getWebElement(driver, xpathLocator)).perform();
    }

    protected void doubleClickOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
        new Actions(driver).doubleClick(getWebElement(driver, xpathLocator, dynamicValues)).perform();
    }

    protected void pressKeyOnElement(WebDriver driver, String xpathLocator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, xpathLocator), key).perform();
    }

    protected void pressKeyOnElement(WebDriver driver, String xpathLocator, Keys key, String... dynamicValues) {
        new Actions(driver).sendKeys(getWebElement(driver, xpathLocator, dynamicValues), key).perform();
    }

    // JavascriptExecutor methods

    protected Object executeJS(WebDriver driver, String javascript) {
        return ((JavascriptExecutor) driver).executeScript(javascript);
    }

    protected void scrollToTopByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-document.body.scrollHeight);");
    }

    protected void scrollToBottomByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight);");
    }

    protected void scrollElementIntoViewTopByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
    }

    protected void scrollElementIntoViewTopByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected void scrollElementIntoViewBottomByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
    }

    protected void scrollElementIntoViewBottomByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected void clickElementByJS(WebDriver driver, String xpathLocator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
    }

    protected void clickElementByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected String getElementValidationMessageByJS(WebDriver driver, String xpathLocator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
    }

    protected String getElementValidationMessageByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected void setElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator));
    }

    protected void setElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName, String attributeValue, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected void removeElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
    }

    protected void removeElementAttributeByJS(WebDriver driver, String xpathLocator, String attributeName, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator, dynamicValues));
    }

    protected void highlightElementByJS(WebDriver driver, String xpathLocator) {
        WebElement element = getWebElement(driver, xpathLocator);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String originalStyle = (String) jsExecutor.executeScript("return arguments[0].getAttribute('style') || '';", element);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; border-style: dashed;');", element);
        sleepForSeconds(oneSecond);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    protected void highlightElementByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        WebElement element = getWebElement(driver, xpathLocator, dynamicValues);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String originalStyle = (String) jsExecutor.executeScript("return arguments[0].getAttribute('style') || '';", element);
        jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red; border-style: dashed;');", element);
        sleepForSeconds(oneSecond);
        jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, originalStyle);
    }

    protected boolean isImageLoadedByJS(WebDriver driver, String xpathLocator) {
        Object result = ((JavascriptExecutor) driver).executeScript("return arguments[0] && arguments[0].complete && arguments[0].naturalWidth > 0;", getWebElement(driver, xpathLocator));
        return Boolean.TRUE.equals(result);
    }

    protected boolean isImageLoadedByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
        Object result = ((JavascriptExecutor) driver).executeScript("return arguments[0] && arguments[0].complete && arguments[0].naturalWidth > 0;", getWebElement(driver, xpathLocator, dynamicValues));
        return Boolean.TRUE.equals(result);
    }

    // Wait methods

    protected void waitForPageReady(WebDriver driver) {
        try {
            initExplicitWait(driver).until(WebDriver -> (Boolean) ((JavascriptExecutor) driver).executeScript("return (typeof jQuery === 'undefined' || (jQuery.active === 0)) && document.readyState === 'complete';"));
        } catch (TimeoutException e) {
            throw new RuntimeException("Page load timeout exceeded!", e);
        }
    }

    protected void waitForElementToBeVisible(WebDriver driver, String xpathLocator) {
        initExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
    }

    protected void waitForElementToBeVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        initExplicitWait(driver).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
    }

    protected void waitForAllElementsToBeVisible(WebDriver driver, String xpathLocator) {
        initExplicitWait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(xpathLocator)));
    }

    protected void waitForAllElementsToBeVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        initExplicitWait(driver).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
    }

    protected void waitForElementToBeInvisible(WebDriver driver, String xpathLocator) {
        configureImplicitWait(driver, zeroTime);
        initExplicitWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(xpathLocator)));
        configureImplicitWait(driver, longTimeout);
    }

    protected void waitForElementToBeInvisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        configureImplicitWait(driver, zeroTime);
        initExplicitWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
        configureImplicitWait(driver, longTimeout);
    }

    protected void waitForAllElementsToBeInvisible(WebDriver driver, String xpathLocator) {
        configureImplicitWait(driver, zeroTime);
        initExplicitWait(driver).until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathLocator)));
        configureImplicitWait(driver, longTimeout);
    }

    protected void waitForAllElementsToBeInvisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
        configureImplicitWait(driver, zeroTime);
        initExplicitWait(driver).until(ExpectedConditions.invisibilityOfAllElements(getWebElements(driver, xpathLocator, dynamicValues)));
        configureImplicitWait(driver, longTimeout);
    }

    protected void waitForElementToBeClickable(WebDriver driver, String xpathLocator) {
        initExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(getByXPath(xpathLocator)));
    }

    protected void waitForElementToBeClickable(WebDriver driver, String xpathLocator, String... dynamicValues) {
        initExplicitWait(driver).until(ExpectedConditions.elementToBeClickable(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
    }

    // Custom methods

    protected void selectOptionInCustomDropdown(WebDriver driver, String dropdownXPath, String allOptionsXPath, String expectedOption) {
        clickElement(driver, dropdownXPath);
        sleepForSeconds(oneSecond);
        List<WebElement> allOptions = initExplicitWait(driver).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(allOptionsXPath)));
        for (WebElement option : allOptions) {
            if (option.getText().trim().equals(expectedOption)) {
                option.click();
                break;
            }
        }
    }

    protected void sleepForSeconds(long timeInSeconds) {
        try {
            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private WebDriverWait initExplicitWait(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(longTimeout));
    }

    private void configureImplicitWait(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    // Common constants

    private final long longTimeout = GlobalConstants.LONG_TIMEOUT;
    private final long oneSecond = GlobalConstants.ONE_SECOND;
    private final long zeroTime = GlobalConstants.ZERO_TIME;

}
