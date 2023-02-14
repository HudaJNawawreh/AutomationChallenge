package selenium.testBase;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import selenium.utils.SeleniumActions;

import java.io.File;
import java.util.HashMap;

public class TestBase extends SeleniumActions {

    public static String filePath;

    @BeforeClass
    public static void beforeAll()
    {
        filePath= new File("").getAbsolutePath();
        filePath=filePath.concat("\\src\\test\\resources");
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", filePath);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        initObjectsAndLogics();

    }
    @AfterClass
    public static void afterAll()
    {

        System.out.println(new File(filePath+"\\bill.pdf").delete());
        driver.quit();
    }
}
