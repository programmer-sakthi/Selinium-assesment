package runner;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utils.ExtentReportUtil;

public class TestExtentReport {

    WebDriver driver;
    ExtentReportUtil reporterUtil;
    ExtentReports reporter;

    ExtentTest test;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        driver=new ChromeDriver();
        reporterUtil = new ExtentReportUtil();
        reporter = reporterUtil.log();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    // start your script here

    @Test
    public void test1() throws Exception {
        try {
            test = reporter.createTest("test1");
            driver.get("https://opensource-demo.orangehrmlive.com");
            WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
            username.sendKeys("Admin");
            WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
            password.sendKeys("admin123");
            WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
            submit.click();
            Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
            test.pass("Passed");
        } catch (Exception e) {
            System.out.println("error ");
            e.printStackTrace();
        }

    }

    // @Test
    // public void test2() throws Exception
    // {

    // }

    @AfterMethod
    public void teardown() {
        // quit your driver
        // flush your reports
        driver.quit();
        reporter.flush();
    }
}