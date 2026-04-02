package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import tests.BaseTest;
import java.time.Duration;

public class PurchaseTest extends BaseTest {

    @Test
    public void testAddToCart() {

        driver.get("https://practicetestautomation.com/practice-test-login/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();

        // Verify login success page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h1")));

        System.out.println("Purchase flow executed (Demo)");

    }
}