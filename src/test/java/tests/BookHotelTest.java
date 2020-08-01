package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.*;

public class BookHotelTest extends BaseTest {
    @Test
    void shouldCorrectlyBookingHotelDisplay() {

        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        accountPage.waitUntilAccountPageIsLoaded();
        accountPage.goToHomePage();
        HotelDetailsPage hotelDetailsPage = homePage.goToSearchHotelsPageWithOneResult();
        BookingConfirmationPage bookingConfirmationPage = hotelDetailsPage.goToBookPage();
        BookingSummaryPage bookingSummaryPage = bookingConfirmationPage.confirmHotelBooking();
        Assertions.assertTrue(bookingSummaryPage.isBookingAlertDisplayed());

    }
}
