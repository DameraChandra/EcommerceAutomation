package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// ✅ Imports for WAIT
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//input[@value='Log in']")
    WebElement loginBtn;

    // ✅ Constructor
    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // ✅ Login Method with Explicit Wait
    public void login(String user, String pass){

        // Wait for Login link and click
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();

        // Wait for Email field
        wait.until(ExpectedConditions.visibilityOf(email)).sendKeys(user);

        // Enter password
        password.sendKeys(pass);

        // Click login button
        loginBtn.click();
    }
}