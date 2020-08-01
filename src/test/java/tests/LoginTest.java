package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

class LoginTest extends BaseTest {
    @Test
    void shouldLoginPageBeOpen() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        Assertions.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    void shouldLoginWithCorrectData() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        Assertions.assertTrue(accountPage.isDemoUserAccountButtonDisplayed());

    }

    @Test
    void shouldDisplayInvalidEmailAlertWhenWrongEmailIsProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@user.user", "demouser");
        Assertions.assertTrue(loginPage.isEmailRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayInvalidPasswordAlertWhenWrongPasswordIsProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "DeMouse");
        Assertions.assertTrue(loginPage.isPasswordRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayInvalidEmailAndPasswordAlertWhenWrongEmailAndPasswordAreProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@user.pl", "DemouseR");
        Assertions.assertTrue(loginPage.isEmailAndPasswordRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayEmailAndPasswordRequiredAlertWhenNoEmailAndPasswordAreProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("", "");
        Assertions.assertTrue(loginPage.isEmailAndPasswordRequiredAlertDisplayed());
    }
}