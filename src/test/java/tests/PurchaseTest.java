package tests;

import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class PurchaseTest extends BaseTest {

    // ✅ DataProvider Method
    @DataProvider(name = "testData")
    public Object[][] getData() {

        Object[][] data = new Object[3][3];

        data[0][0] = "testuser@gmail.com";
        data[0][1] = "Test@123";
        data[0][2] = "book";

        data[1][0] = "testuser@gmail.com";
        data[1][1] = "Test@123";
        data[1][2] = "computer";

        data[2][0] = "testuser@gmail.com";
        data[2][1] = "Test@123";
        data[2][2] = "laptop";

        return data;
    }

    // ✅ Test Method using DataProvider
    @Test(dataProvider = "testData")
    public void testAddToCart(String email, String password, String product){

        LoginPage login = new LoginPage(driver);
        HomePage home = new HomePage(driver);
        CartPage cart = new CartPage(driver);

        // Login
        login.login(email, password);
        System.out.println("Login Done");

        // Search Product
        home.searchProduct(product);
        System.out.println("Search Done: " + product);

        // Select Product
        home.selectProduct();
        System.out.println("Product Selected");

        // Add to Cart
        home.addProductToCart();
        System.out.println("Added to Cart");

        // Get Cart Count
        String count = cart.getCartCount();
        System.out.println("Cart Count: " + count);
    }
}