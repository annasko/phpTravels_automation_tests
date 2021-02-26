package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class BookHotelTest extends BaseTest {
    @Test
    void shouldCorrectlyBookingHotelDisplay() {
        HomePage homePage = loginAndGoToHomePage();
        HotelDetailsPage hotelDetailsPage = homePage.goToTriaOneResultFoundPage();
        BookingConfirmationPage bookingConfirmationPage = hotelDetailsPage.goToBookPage();
        BookingSummaryPage bookingSummaryPage = bookingConfirmationPage.confirmHotelBooking();
        Assertions.assertTrue(bookingSummaryPage.isBookingAlertDisplayed());

    }
}
