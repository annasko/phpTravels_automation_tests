package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LogoutTest extends BaseTest {
    @Test
    void shouldLogOutWithCorrectData() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        accountPage.clickOnLogoutButton();
        Assertions.assertTrue(loginPage.isLoginPageDisplayed());

    }
}
