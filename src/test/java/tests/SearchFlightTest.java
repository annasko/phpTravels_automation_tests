package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BookFlightPage;
import pageobjects.HomePage;
import pageobjects.SearchFlightsPage;


public class SearchFlightTest extends BaseTest{

    @Test
    void shouldOneWayResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(searchFlightsPage.isFlightsPageDisplay("WWA to DXB"));
    }

    @Test
    void shouldRoundTripResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithRoundTripResults();
        Assertions.assertTrue(searchFlightsPage.isFlightsPageDisplay("LHE to DXB and DXB to LHE"));
    }

    @Test
    void shouldReturnRoundTripWithChangeDepartAndReturnDataResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithChangeDepartAndReturnDate();
        Assertions.assertTrue(searchFlightsPage.isFlightsPageDisplay("depart fly on 27.08 and return fly on 28.08"));
    }

    @Test
    void shouldAdd100AdultsAndReturnTripResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithChoose100adults();
        BookFlightPage bookFlightPage = searchFlightsPage.isBookNowPageDisplay();
        Assertions.assertTrue(bookFlightPage.isNumberOfAdultsDisplayed("100"));
    }

    @Test
    void shouldChangeClassToBusinessAndReturnResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver,wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithBusinessClass();
        Assertions.assertTrue(searchFlightsPage.isTypeClassTextDisplay("business"));
    }

    @Test
    void shouldChangeClassToEconomyAndReturnResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver,wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithEconomyClass();
        Assertions.assertTrue(searchFlightsPage.isTypeClassTextDisplay("economy"));
    }

    @Test
    void shouldChangeClassToFirstAndReturnResultsFoundDisplay () {
        HomePage homePage = new HomePage(driver,wait);
        homePage.open();
        SearchFlightsPage searchFlightsPage = homePage.goToSearchFlightsPageWithFirstClass();
        Assertions.assertTrue(searchFlightsPage.isTypeClassTextDisplay("first"));
    }
}
