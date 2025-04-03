package afc.jquery;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.jQuery.PageGeneratorJQuery;
import pageObjects.jQuery.UploadFilePageObject;

public class Level_10_Upload_File extends BaseTest {
    private WebDriver driver;
    private UploadFilePageObject uploadFilePage;

    String javaFile = "java.jpg";
    String csharpFile = "csharp.jpg";
    String javascriptFile = "javascript.jpg";
    String rubyFile = "ruby.jpg";
    String pythonFile = "python.jpg";
    String[] multipleFiles = {javaFile, csharpFile, javascriptFile, rubyFile, pythonFile};

    @Parameters({"browser", "uploadUrl"})
    @BeforeClass
    public void beforeClass(String browserName, String appUrl) {
        driver = getWebDriver(browserName, appUrl);
        uploadFilePage = PageGeneratorJQuery.getUploadPage(driver);
    }

    @Test
    public void TC_01_Single_File() {
        uploadFilePage.uploadFileToPage(javaFile);

        Assert.assertTrue(uploadFilePage.isFileNameDisplayedBeforeUpload(javaFile));

        uploadFilePage.clickStartButtonOfFile(javaFile);

        Assert.assertTrue(uploadFilePage.isUploadedFileLinkDisplayed(javaFile));

        Assert.assertTrue(uploadFilePage.isUploadedFileImageDisplayed(javaFile));

        uploadFilePage.clickDeleteButtonOfFile(javaFile);
    }

    @Test
    public void TC_02_Multiple_Files() {
        uploadFilePage.uploadFileToPage(multipleFiles);

        Assert.assertTrue(uploadFilePage.areFileNamesDisplayedBeforeUpload(multipleFiles));

        uploadFilePage.clickStartButtonsOfFiles(multipleFiles);

        Assert.assertTrue(uploadFilePage.areUploadedFileLinksDisplayed(multipleFiles));

        Assert.assertTrue(uploadFilePage.areUploadedFileImagesDisplayed(multipleFiles));

        uploadFilePage.clickDeleteButtonsOfFiles(multipleFiles);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
