package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.HomePage;
import pageobjects.SearchHotelsPage;

public class SearchHotelsTest extends BaseTest {
    @Test
    void shouldNoResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        SearchHotelsPage searchHotelsPage = homePage.goToSearchHotelsPageWithNoResults("Paris");
        Assertions.assertTrue(searchHotelsPage.isDisneylandHotelsDisplayed());
    }

    @Test
    void shouldTriaHotelIstanbulSpecialDisplay () {
        HomePage homePage = new HomePage(driver,wait);
        homePage.open();
        SearchHotelsPage searchHotelsPage = homePage.goToSearchHotelsPageWithOneResult();
        Assertions.assertTrue(searchHotelsPage.isTriaHotelInInstanbulDisplayed());
    }

    @Test
    void shouldMoreResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver,wait);
        homePage.open();
        SearchHotelsPage searchHotelsPage = homePage.goToSearchHotelsPageWithMoreThanOneResults();

        Assertions.assertTrue(searchHotelsPage.isAlzerHotelInInstanbulDisplay());
    }
}
