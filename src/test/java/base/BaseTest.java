package base;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import utilities.ScreenshotUtil;
import utilities.ExtentManager;

import com.aventstack.extentreports.*;

public class BaseTest {

    public WebDriver driver;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeSuite
    public void startReport() {
        System.out.println("Report started");
        extent = ExtentManager.getReport();
    }

    @BeforeMethod
    public void setup(Method method) {

        System.out.println("Browser launching");

        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();

        test = extent.createTest(method.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {

            test.fail(result.getThrowable());

            String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

            try {
                test.addScreenCaptureFromPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (result.getStatus() == ITestResult.SUCCESS) {

            test.pass("Test Passed");

        } else {

            test.skip("Test Skipped");
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void endReport() {
        System.out.println("Report generated");
        extent.flush();
    }
}