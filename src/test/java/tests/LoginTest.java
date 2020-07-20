package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

class LoginTest extends BaseTest {
    @Test
    void shouldLoginPageIsOpen() {
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
    void shouldDisplayedInvalidEmailAlertWhenWrongEmailIsProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@user.user", "demouser");
        Assertions.assertTrue(loginPage.isEmailRequiredAlertDisplayed());
    }

    @Test
    void shouldDisplayedInvalidPasswordAlertWhenWrongPasswordIsProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "DeMouse");
        Assertions.assertTrue(loginPage.isPasswordRequiredAlertDisplayed());
    }
    @Test
    void shouldDisplayedInvalidEmailAndPasswordAlertWhenWrongEmailAndPasswordAreProvided() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@user.user", "DeMouse");
        Assertions.assertTrue(loginPage.isEmailAndPasswordRequiredAlertDisplayed());
    }
    @Test
    void shouldDisplayedEmailAndPasswordRequiredAlertWhenNoEmailAndPasswordAreProvided () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("", "");
        Assertions.assertTrue(loginPage.isEmailAndPasswordRequiredAlertDisplayed());
    }
}