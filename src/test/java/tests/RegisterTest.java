package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterPageBeOpen() {
        HomePage homePage = openHomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();
        Assertions.assertTrue(registerPage.isRegisterPageDisplayed());
    }

    @Test
    void shouldRegisterWithCorrectData() {
        HomePage homePage = openHomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register("Piotr", "Nowak", "555555555", "pnowak@no.eu",
                "123456", "123456");
        AccountPage accountPage = registerPage.goToAccountPage();
        Assertions.assertTrue(accountPage.isDemoUserAccountButtonDisplayed());
    }

    public RegisterPage shouldDisplayDangerAlertWhenWrongCredentialsProvided(String firstName, String lasName,
                                                                             String mobilePhone, String email, String password,
                                                                             String confirmPassword) {
        HomePage homePage = openHomePage();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register(firstName, lasName, mobilePhone, email, password, confirmPassword);
        return registerPage;
    }

    @Test
    void shouldDisplayEmailFieldMustContainAlertWhenWrongEmailIsProvided() {
        RegisterPage registerPage = shouldDisplayDangerAlertWhenWrongCredentialsProvided("Piotr", "Nowak",
                "555555555", "w", "123456", "123456");
        Assertions.assertTrue(registerPage.isEmailAlertDisplayed());
    }

    @Test
    void shouldDisplayPasswordTooShortAlertWhenShortPasswordIsProvided() {
        RegisterPage registerPage = shouldDisplayDangerAlertWhenWrongCredentialsProvided("Piotr", "Nowak",
                "5555555555", "pinowak@no.pl", "123", "123");
        Assertions.assertTrue(registerPage.isPasswordTooShortAlertDisplayed());
    }

    @Test
    void shouldDisplayPasswordNotMatchingAlertWhenNotMatchingPasswordIsProvided() {
        RegisterPage registerPage = shouldDisplayDangerAlertWhenWrongCredentialsProvided("Piotr", "Nowak",
                "555555555", "poitnow@no.rr", "1234567", "123456");
        Assertions.assertTrue(registerPage.isConfirmPasswordAlertDisplayed());
    }

}
