package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators (UPDATED - FIXED)
    By signInBtn = By.id("nav-link-accountList");  // Amazon login button
    By emailField = By.id("ap_email");
    By continueBtn = By.id("continue");
    By passwordField = By.id("ap_password");
    By loginBtn = By.id("signInSubmit");

    // Login Method
    public void login(String username, String password) {

        // Click Sign In
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();

        // Enter Email
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(username);

        // Click Continue
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();

        // Enter Password
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);

        // Click Login
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}