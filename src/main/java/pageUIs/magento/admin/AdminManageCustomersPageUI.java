package pageUIs.magento.admin;

public class AdminManageCustomersPageUI {

    public static final String POPUP_CLOSE_BUTTON = "//div[@class='message-popup-head']/a[@title='close']";
    public static final String ACTIONS_DROPDOWN = "//label[text()='Actions']/following-sibling::select";
    public static final String SUBMIT_BUTTON = "//button[@title='Submit']";
    public static final String DELETED_SUCCESS_MESSAGE = "//li[@class='success-msg']//span";
    public static final String LOGOUT_LINK = "//div[@class='header']//a[text()='Log Out']";
    public static final String CUSTOMER_INFO_BY_NAME_EMAIL = "//td[contains(text(),'%s')]/following-sibling::td[contains(text(),'%s')]";
    public static final String CUSTOMER_CHECKBOX_BY_NAME_EMAIL = CUSTOMER_INFO_BY_NAME_EMAIL + "/parent::tr//input[@type='checkbox']";

}
