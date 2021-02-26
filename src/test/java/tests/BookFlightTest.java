package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class BookFlightTest extends BaseTest {
    @Test
    void shouldCorrectlyBookingFlightDisplay() {
        HomePage homePage = loginAndGoToHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithRoundTripResults();
        BookingConfirmationPage bookFlightPage = flightListsPage.goToBookingConfirmationPage();
        BookingSummaryPage bookingSummaryPage = bookFlightPage.fillPassengerDataAndConfirm("Tadeusz", "30", "frgs4453");
        Assertions.assertTrue(bookingSummaryPage.isBookingAlertDisplayed());

    }
}
