package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.HotelDetailsPage;

public class SearchHotelsTest extends BaseTest {
    @Test
    void shouldDisneylandNoFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToDisneylandNoResultsFoundPage();
        Assertions.assertTrue(hotelDetailsPage.isDisneylandHotelDisplayed());
    }

    @Test
    void shouldTriaHotelIstanbulSpecialDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToTriaOneResultFoundPage();
        Assertions.assertTrue(hotelDetailsPage.isTriaHotelInInstanbulDisplayed());
    }

    @Test
    void shouldAlzerHotelIstanbulManyResultsDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToAlzerhManyResultsFoundPage();
        Assertions.assertTrue(hotelDetailsPage.isAlzerHotelInInstanbulDisplay());
    }
}
