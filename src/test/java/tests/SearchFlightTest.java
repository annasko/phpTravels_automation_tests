package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BookingConfirmationPage;
import pageobjects.HomePage;
import pageobjects.FlightListsPage;


public class SearchFlightTest extends BaseTest {

    @Test
    void shouldOneWayResultsFoundDisplay() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed("WWA to DXB"));
    }

    @Test
    void shouldRoundTripResultsFoundDisplay() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithRoundTripResults();
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed("LHE to DXB and DXB to LHE"));
    }

    @Test
    void shouldReturnRoundTripWithChangeDepartAndReturnDataResultsFoundDisplay() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithChangedDepartAndReturnDate();
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed(" and return flight"));
    }

    @Test
    void shouldAdd100AdultsAndReturnTripResultsFoundDisplay() {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithManyAdults(100);
        BookingConfirmationPage bookFlightPage = flightListsPage.goToBookingConfirmationPage();
        Assertions.assertTrue(bookFlightPage.isNumberOfAdultsDisplayed("100"));
    }

    @Test
    void shouldChangeClassToBusinessAndReturnResultsFoundDisplay() {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithBusinessClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("business"));
    }

    @Test
    void shouldChangeClassToEconomyAndReturnResultsFoundDisplay() {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithEconomyClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("economy"));
    }

    @Test
    void shouldChangeClassToFirstAndReturnResultsFoundDisplay() {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithFirstClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("first"));
    }

    @Test
    void shouldChangeCurrencyToSAR() throws InterruptedException {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        FlightListsPage reloadedFlightListPage = flightListsPage.changeCurrency(2);
        Assertions.assertTrue(reloadedFlightListPage.isCurrencyDisplayed("SAR"));
    }

    @Test
    void shouldChangeCurrencyToUSD() throws InterruptedException {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        FlightListsPage reloadedFlightListPage = flightListsPage.changeCurrency(0);
        Assertions.assertTrue(reloadedFlightListPage.isCurrencyDisplayed("USD"));
    }


    @Test
    void shouldCorrectlyConvertCurrency() throws InterruptedException {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPageUSD = homePage.goToSearchFlightsPageWithResults("WWA");
        int usdValue = flightListsPageUSD.extractFirstFlightPriceValue();
        FlightListsPage flightListsPageJPY = flightListsPageUSD.changeCurrency(6);
        int jpyValue = flightListsPageJPY.extractFirstFlightPriceValue();
        Assertions.assertTrue((usdValue * 100 < jpyValue) && (usdValue * 150 > jpyValue));
    }

    @Test
    void shouldCorrectlyChangePriceRange() throws InterruptedException {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isNarrowerPriceRangeFlightsListCorrectlyDisplayed());
    }

    @Test
    void shouldCorrectlyChangeAirlines() {
        HomePage homePage = openHomePage();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        flightListsPage.selectAirArabiaAirlines();
        Assertions.assertTrue(flightListsPage.isAirlineNameCorrectlyDisplayed("Air Arabia Maroc"));
    }

}
