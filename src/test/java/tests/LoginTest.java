package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

class LoginTest extends BaseTest {
    @Test
    void shouldLoginPageBeOpen() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
        HomePage homePage = openHomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        Assertions.assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Test
    void shouldLoginWithCorrectData() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
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
// //       HomePage homePage = new HomePage(driver, wait);
// //       homePage.open();
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@user.user", "demouser", "Invalid Email");
//        HomePage homePage = openHomePage();
//        LoginPage loginPage = homePage.goToLoginPage();
//        loginPage.login("user@user.user", "demouser");
//        Assertions.assertTrue(loginPage.isDangerAlertTextCorrectlyDisplayed("Invalid Email"));
    }

    @Test
    void shouldDisplayInvalidPasswordAlertWhenWrongPasswordIsProvided() {
// //       HomePage homePage = new HomePage(driver, wait);
//  //      homePage.open();
//        HomePage homePage = openHomePage();
//        LoginPage loginPage = homePage.goToLoginPage();
//        loginPage.login("user@phptravels.com", "DeMouse");
//        Assertions.assertTrue(loginPage.isDangerAlertTextCorrectlyDisplayed("Password"));
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@phptravels.com", "DeMouse", "Password");
    }

    @Test
    void shouldDisplayInvalidEmailAndPasswordAlertWhenWrongEmailAndPasswordAreProvided() {
////        HomePage homePage = new HomePage(driver, wait);
////        homePage.open();
//        HomePage homePage = openHomePage();
//        LoginPage loginPage = homePage.goToLoginPage();
//        loginPage.login("user@user.pl", "DemouseR");
//        Assertions.assertTrue(loginPage.isDangerAlertTextCorrectlyDisplayed("Invalid Email or Password"));
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("user@user.pl", "DemouseR", "Invalid Email or Password");
    }

    @Test
    void shouldDisplayEmailAndPasswordRequiredAlertWhenNoEmailAndPasswordAreProvided() {
////        HomePage homePage = new HomePage(driver, wait);
////        homePage.open();
//        HomePage homePage = openHomePage();
//        LoginPage loginPage = homePage.goToLoginPage();
//        loginPage.login("", "");
//        Assertions.assertTrue(loginPage.isDangerAlertTextCorrectlyDisplayed("Invalid Email or Password"));
        shouldDisplayDangerAlertWhenWrongCredentialsProvided("", "", "Invalid Email or Password");
    }
}