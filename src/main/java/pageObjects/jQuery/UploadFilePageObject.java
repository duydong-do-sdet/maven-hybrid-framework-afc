package pageObjects.jQuery;

import commons.BasePage;
import commons.GlobalConstants;
import org.openqa.selenium.WebDriver;
import pageUIs.jQuery.UploadFilePageUI;

public class UploadFilePageObject extends BasePage {
    private WebDriver driver;

    public UploadFilePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFileToPage(String... fileNames) {
        for (String file : fileNames) {
            getWebElement(driver, UploadFilePageUI.UPLOAD_INPUT).sendKeys(GlobalConstants.UPLOAD_FILES_FOLDER + file);
        }
    }

    public boolean isFileNameDisplayedBeforeUpload(String fileName) {
        waitForElementToBeVisible(driver, UploadFilePageUI.BEFORE_UPLOAD_FILE_NAME, fileName);
        return isElementDisplayed(driver, UploadFilePageUI.BEFORE_UPLOAD_FILE_NAME, fileName);
    }

    public void clickStartButtonOfFile(String fileName) {
        waitForElementToBeClickable(driver, UploadFilePageUI.START_BUTTON_OF_FILE, fileName);
        clickElement(driver, UploadFilePageUI.START_BUTTON_OF_FILE, fileName);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public boolean isUploadedFileLinkDisplayed(String fileName) {
        waitForElementToBeVisible(driver, UploadFilePageUI.UPLOADED_FILE_LINK, fileName);
        return isElementDisplayed(driver, UploadFilePageUI.UPLOADED_FILE_LINK, fileName);
    }

    public boolean isUploadedFileImageDisplayed(String fileName) {
        waitForElementToBeVisible(driver, UploadFilePageUI.UPLOADED_FILE_IMAGE, fileName);
        return isImageLoadedByJS(driver, UploadFilePageUI.UPLOADED_FILE_IMAGE, fileName);
    }

    public void clickDeleteButtonOfFile(String fileName) {
        waitForElementToBeClickable(driver, UploadFilePageUI.DELETE_BUTTON_OF_FILE, fileName);
        clickElement(driver, UploadFilePageUI.DELETE_BUTTON_OF_FILE, fileName);
        sleepForSeconds(GlobalConstants.ONE_SECOND);
    }

    public boolean areFileNamesDisplayedBeforeUpload(String... fileNames) {
        for (String file : fileNames) {
            if (!isFileNameDisplayedBeforeUpload(file)) {
                return false;
            }
        }
        return true;
    }

    public void clickStartButtonsOfFiles(String... fileNames) {
        for (String file : fileNames) {
            clickStartButtonOfFile(file);
        }
    }

    public boolean areUploadedFileLinksDisplayed(String... fileNames) {
        for (String file : fileNames) {
            if (!isUploadedFileLinkDisplayed(file)) {
                return false;
            }
        }
        return true;
    }

    public boolean areUploadedFileImagesDisplayed(String... fileNames) {
        for (String file : fileNames) {
            if (!isUploadedFileImageDisplayed(file)) {
                return false;
            }
        }
        return true;
    }

    public void clickDeleteButtonsOfFiles(String... fileNames) {
        for (String file : fileNames) {
            clickDeleteButtonOfFile(file);
        }
    }

}
