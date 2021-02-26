package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

class LoginTest extends BaseTest {
    @Test
    void shouldLoginPageBeOpen() {
        HomePage homePage = openHomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        Assertions.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    void shouldLoginWithCorrectData() {
        HomePage homePage = openHomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        Assertions.assertTrue(accountPage.isDemoUserAccountButtonDisplayed());

    }

    public void shouldDisplayDangerAlertWhenWrongCredentialsProvided(String email, String password, String textAlert) {
        HomePage homePage = openHomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login(email, password);
        Assertions.assertTrue(loginPage.isDangerAlertTextCorrectlyDisplayed(textAlert));
    }

    @Test
    void shouldDisplayInvalidEmailAlertWhenWrongEmailIsProvided() {
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@user.user", "demouser", "Invalid Email");
    }

    @Test
    void shouldDisplayInvalidPasswordAlertWhenWrongPasswordIsProvided() {
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@phptravels.com", "DeMouse", "Password");
    }

    @Test
    void shouldDisplayInvalidEmailAndPasswordAlertWhenWrongEmailAndPasswordAreProvided() {
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@user.pl", "DemouseR", "Invalid Email or Password");
    }

    @Test
    void shouldDisplayEmailAndPasswordRequiredAlertWhenNoEmailAndPasswordAreProvided() {
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("", "", "Invalid Email or Password");
    }
}