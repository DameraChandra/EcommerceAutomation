package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class CartPage {

    WebDriver driver;

    @FindBy(xpath="//span[@class='cart-qty']")
    WebElement cartCount;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCartCount(){
    	try {
            Thread.sleep(2000);   // ✅ ADD HERE
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return cartCount.getText();
    }
}
