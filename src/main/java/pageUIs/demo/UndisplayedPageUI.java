package pageUIs.demo;

public class UndisplayedPageUI {

    // In DOM

    public static final String START_BUTTON = "//div[@id='start']/button";
    public static final String LOADING_ICON = "//div[@id='loading' and text()='Loading... ']";
    public static final String HELLO_WORLD = "//div[@id='finish']/h4[text()='Hello World!']";

    // Not in DOM

    public static final String REGISTER_BUTTON = "//button[text()='Đăng ký']";
    public static final String REGISTER_FORM_DIALOG = "//div[@id='custom-dialog']//div[@role='dialog']";
    public static final String CLOSE_DIALOG_BUTTON = REGISTER_FORM_DIALOG + "//button[contains(@class,'close-btn')]";
    public static final String TEXT_FIELDS = "//form[@class='form-auth']//input";
    public static final String TEXT_FIELD_BY_PLACEHOLDER = TEXT_FIELDS + "[@placeholder='%s']";

}
