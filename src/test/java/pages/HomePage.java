package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class HomePage {

    WebDriver driver;

    @FindBy(id="small-searchterms")
    WebElement searchBox;

    @FindBy(xpath="//input[@value='Search']")
    WebElement searchBtn;

    @FindBy(xpath="//h2[@class='product-title']/a")
    WebElement product;

    @FindBy(xpath="//input[@value='Add to cart']")
    WebElement addToCart;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName){
        searchBox.sendKeys(productName);
        searchBtn.click();
    }

    public void selectProduct(){
        product.click();
    }

    public void addProductToCart(){
    	 try {
    	        Thread.sleep(2000);   // ✅ ADD HERE
    	    } catch (InterruptedException e) {
    	        e.printStackTrace();
    	    }
        addToCart.click();
    }
}