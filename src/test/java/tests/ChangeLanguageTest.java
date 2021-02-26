package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

public class ChangeLanguageTest extends BaseTest {
    @Test
    void shouldChangeToRussianLanguage() {
        HomePage homePage = openHomePage();
        HomePage russianHomePage = homePage.changeToRussianLanguage();
        Assertions.assertTrue(russianHomePage.isFlightNameTextCorrectlyDisplayed("ПОЛЕТЫ"));
    }

    @Test
    void shouldChangeToGermanLanguage() {
        HomePage homePage = openHomePage();
        HomePage germanHomePage = homePage.changeToGermanLanguage();
        Assertions.assertTrue(germanHomePage.isFlightNameTextCorrectlyDisplayed("FLÜGE"));
    }


}
