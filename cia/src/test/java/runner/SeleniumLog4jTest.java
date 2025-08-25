package runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;


public class SeleniumLog4jTest {

    private static final Logger logger = LogManager.getLogger(SeleniumLog4jTest.class);
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        logger.info("Setting up WebDriver");
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriverManager.chromedriver().browserVersion("139.0.7258.67 ").setup();
        driver = new ChromeDriver();
        logger.info("Browser launched");
    }

    @Test
    public void openExampleDotCom() {
        logger.info("Navigating to example.com");
        driver.get("https://example.com");
        logger.info("Page title is: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
