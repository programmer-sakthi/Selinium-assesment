package runner;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestScreenshot {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    public void setup() {
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test
    public void takeScreenshot() {
        try {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File("screenshot/screen.png"));
        } catch (Exception e) {
            System.out.println("error ");
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
