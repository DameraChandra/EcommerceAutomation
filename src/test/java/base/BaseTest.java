package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    // 🔹 Start Extent Report
    @BeforeSuite
    public void setupReport() {
        extent = ExtentManager.getReportInstance();
    }

    // 🔹 Launch Browser + Create Test
    @BeforeMethod
    public void setup(Method method) {

        // Create test in report
        test = extent.createTest(method.getName());

        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in"); // change URL if needed
    }

    // 🔹 Close Browser
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔹 Flush Report
    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}