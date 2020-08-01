package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

public class ChangeLanguageTest extends BaseTest {
    @Test
    void shouldChangeToRussianLanguage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HomePage russianHomePage = homePage.changeToRussianLanguage();
        Assertions.assertTrue(russianHomePage.isRussianLanguageDisplayed());
    }

    @Test
    void shouldChangeToGermanLanguage() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HomePage germanHomePage = homePage.changeToGermanLanguage();
        Assertions.assertTrue(germanHomePage.isGermanLanguageDisplayed());
    }


}
