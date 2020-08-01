package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class BookFlightTest extends BaseTest {
    @Test
    void shouldCorrectlyBookingFlightDisplay() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        accountPage.waitUntilAccountPageIsLoaded();
        accountPage.goToHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithChoose100Adults();
        BookingConfirmationPage bookFlightPage = flightListsPage.goToBookingConfirmationPage();
        BookingSummaryPage bookingSummaryPage = bookFlightPage.fillPassengerDataAndConfirm("Tadeusz", "30", "frgs4453");
        Assertions.assertTrue(bookingSummaryPage.isBookingAlertDisplayed());

    }
}
