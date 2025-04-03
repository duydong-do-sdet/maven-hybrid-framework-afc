package pageUIs.jQuery;

public class WebTablePageUI {

    // CRUD

    public static final String DYNAMIC_PAGINATION_LINK_BY_NUMBER = "//table/following-sibling::ul/li/a[text()='%s']";
    public static final String DYNAMIC_FILTER_TEXTBOX_BY_LABEL = "//div[text()='%s']/parent::div/following-sibling::input";
    public static final String DYNAMIC_DATA_ROW_BY_VALUES = "//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']/ancestor::tr";
    public static final String ADD_ROW_BUTTON = "//button[@class='qgrd-add-row-btn']";
    public static final String FEMALES_TEXTBOX = "//input[@name='females']";
    public static final String COUNTRY_TEXTBOX = "//input[@name='country']";
    public static final String MALES_TEXTBOX = "//input[@name='males']";
    public static final String TOTAL_TEXTBOX = "//input[@name='total']";
    public static final String OK_BUTTON = "//form[@class='qgrd-modal-form']//input[@type='submit']";

    // Dynamic

    public static final String COLUMN_INDEX_BY_LABEL = "//th[text()='%s']/preceding-sibling::th";
    public static final String TEXTBOX_BY_ROW_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/input";
    public static final String COUNTRY_DROPDOWN_BY_ROW = "//tbody/tr[%s]//select";
    public static final String NPO_CHECKBOX_BY_ROW = "//tbody/tr[%s]//input[@type='checkbox']";
    public static final String MEMBER_SINCE_DATE_PICKER_BY_ROW = "//tbody/tr[%s]//input[contains(@name,'memberSince')]";
    public static final String ACTION_BUTTON_BY_TITLE = "//tbody/tr[%s]//button[@title='%s']";
    public static final String LOAD_DATA_BUTTON = "//button[@id='load']";
    public static final String APPEND_ROW_BUTTON = "//button[@title='Append Row']";
    public static final String REMOVE_LAST_ROW_BUTTON = "//button[@title='Remove Last Row']";

}
