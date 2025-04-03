package pageUIs.jQuery;

public class UploadFilePageUI {

    public static final String UPLOAD_INPUT = "//input[@type='file']";
    public static final String BEFORE_UPLOAD_FILE_NAME = "//p[@class='name' and text()='%s']";
    public static final String START_BUTTON_OF_FILE = BEFORE_UPLOAD_FILE_NAME + "/ancestor::tr//button[contains(@class,'start')]";
    public static final String UPLOADED_FILE_LINK = "//p[@class='name']/a[text()='%s']";
    public static final String UPLOADED_FILE_IMAGE = "//a[@title='%s']/img";
    public static final String DELETE_BUTTON_OF_FILE = UPLOADED_FILE_LINK + "/ancestor::tr//button[contains(@class,'delete')]";

}
