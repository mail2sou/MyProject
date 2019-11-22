package step_definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public WebDriverWait wait;
    private Properties property = new Properties();
    private FileInputStream fis;
    @Before
    public void baseCapabilities() throws IOException {
        fis = new FileInputStream(System.getProperty("user.dir")+"\\config\\config.properties");
        property.load(fis);
        if(property.getProperty("browser").equals("chrome")){
            System.setProperty("webdriver.chrome.driver", property.getProperty("driverPath"));
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("useAutomationExtension", false);
            options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();
            driver.manage().window().maximize();
        }
    }
    @After
    public void beforeQuit() {
        driver.quit();
    }
}
