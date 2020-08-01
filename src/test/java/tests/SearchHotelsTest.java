package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.HotelDetailsPage;

public class SearchHotelsTest extends BaseTest {
    @Test
    void shouldNoResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToSearchHotelsPageWithNoResults("Paris");
        Assertions.assertTrue(hotelDetailsPage.isDisneylandHotelDisplayed());
    }

    @Test
    void shouldTriaHotelIstanbulSpecialDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToSearchHotelsPageWithOneResult();
        Assertions.assertTrue(hotelDetailsPage.isTriaHotelInInstanbulDisplayed());
    }

    @Test
    void shouldMoreResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        HotelDetailsPage hotelDetailsPage = homePage.goToSearchHotelsPageWithMoreThanOneResults();
        Assertions.assertTrue(hotelDetailsPage.isAlzerHotelInInstanbulDisplay());
    }
}
