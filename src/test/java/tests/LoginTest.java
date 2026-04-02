package tests;

import org.testng.annotations.Test;
import tests.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLogin() {

        LoginPage login = new LoginPage(driver);

        login.login("student", "Password123");

        System.out.println("Login Test Passed");
    }
}