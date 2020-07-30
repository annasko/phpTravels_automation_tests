package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

public class RegisterTest extends BaseTest {

    @Test
    void shouldRegisterPageIsOpen () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        RegisterPage registerPage = homePage.goToRegisterPage();
        Assertions.assertTrue(registerPage.isRegisterPageDisplayed());
    }

    @Test
    void shouldRegisterWithCorrectData () {
        HomePage homePage= new HomePage(driver, wait);
        homePage.open();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register("Piotr", "Nowak", "555555555", "pnowak@no.eu", "123456", "123456");
        AccountPage accountPage = registerPage.goToAccountPage();
        Assertions.assertTrue(accountPage.isDemoUserAccountButtonDisplayed());
    }

    @Test
    void shouldDisplayEmailFieldMustContainAlertWhenWrongEmailIsProvided () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register("Piotr", "Nowak", "555555555", "w", "123456", "123456");
        Assertions.assertTrue(registerPage.isEmailAlertDisplayed());
    }

    @Test
    void shouldDisplayPasswordTooShortAlertWhenShortEmailIsProvided () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register("Piotr", "Nowak", "555555555", "pinowak@no.pl", "123", "123");
        Assertions.assertTrue((registerPage.isPasswordTooShortAlertDisplayed()));
    }

    @Test
    void shouldDisplayPasswordNotMatchingAlertWhenNotMatchingPasswordIsProvided () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        RegisterPage registerPage = homePage.goToRegisterPage();
        registerPage.register("Piotr", "Nowak", "555555555", "piotnow@no.rr", "1234567", "123456");
        Assertions.assertTrue(registerPage.isConfirmPasswordAlertDisplayed());
    }

}
