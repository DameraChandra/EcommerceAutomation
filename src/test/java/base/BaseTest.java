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

    // 🔥 MAKE STATIC (IMPORTANT FIX)
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    // 🔹 Run once before all tests
    @BeforeSuite(alwaysRun = true)
    public void setupReport() {
        extent = ExtentManager.getReportInstance();
    }

    // 🔹 Before each test
    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {

        // Create test
        test.set(extent.createTest(method.getName()));

        // Launch browser
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in"); // change if needed
    }

    // 🔹 After each test
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔹 After all tests
    @AfterSuite(alwaysRun = true)
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}