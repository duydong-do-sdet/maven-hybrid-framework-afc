package commons;

import java.io.File;
import java.nio.file.Paths;

public class GlobalConstants {

    public static final long LONG_TIMEOUT = 30;
    public static final long ONE_SECOND = 1;
    public static final long ZERO_TIME = 0;

    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String SRC_MAIN_RESOURCES_PATH = PROJECT_PATH + "/src/main/resources";
    public static final String SRC_TEST_RESOURCES_PATH = PROJECT_PATH + "/src/test/resources";
    public static final String FILE_SEP = File.separator;
    public static final String PROJECT_BASE_PATH = PROJECT_PATH + FILE_SEP;

    public static final String UPLOAD_FILES_FOLDER = Paths.get(SRC_TEST_RESOURCES_PATH, "uploadFiles").toString() + FILE_SEP;
    public static final String EXTENTREPORTS_OUTPUT = Paths.get(PROJECT_PATH, "extentreports-output", "extentreports.html").toString();
    public static final String ALLURE_REPORT_OUTPUT = Paths.get(PROJECT_PATH, "allure-results").toString() + FILE_SEP;
    public static final String DATA_JSON_PATH = Paths.get(SRC_TEST_RESOURCES_PATH, "externalData").toString() + FILE_SEP;

    public static final String OS_NAME = System.getProperty("os.name");
    public static final String JAVA_VERSION = System.getProperty("java.version");

}
