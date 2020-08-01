package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobjects.BookingConfirmationPage;
import pageobjects.HomePage;
import pageobjects.FlightListsPage;


public class SearchFlightTest extends BaseTest {

    @Test
    void shouldOneWayResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed("WWA to DXB"));
    }

    @Test
    void shouldRoundTripResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithRoundTripResults();
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed("LHE to DXB and DXB to LHE"));
    }

    @Test
    void shouldReturnRoundTripWithChangeDepartAndReturnDataResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithChangeDepartAndReturnDate();
        Assertions.assertTrue(flightListsPage.isFlightsPageDisplayed(" and return flight"));
    }

    @Test
    void shouldAdd100AdultsAndReturnTripResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithChoose100Adults();
        BookingConfirmationPage bookFlightPage = flightListsPage.goToBookingConfirmationPage();
        Assertions.assertTrue(bookFlightPage.isNumberOfAdultsDisplayed("100"));
    }

    @Test
    void shouldChangeClassToBusinessAndReturnResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithBusinessClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("business"));
    }

    @Test
    void shouldChangeClassToEconomyAndReturnResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithEconomyClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("economy"));
    }

    @Test
    void shouldChangeClassToFirstAndReturnResultsFoundDisplay() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithFirstClass();
        Assertions.assertTrue(flightListsPage.isTypeClassTextDisplayed("first"));
    }

    @Test
    void shouldChangeCurrencyToSAR() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isChangeToSARCurrencyDisplayed("SAR"));
    }

    @Test
    void shouldChangeCurrencyToUSD() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isChangeToUSDCurrencyDisplayed("USD"));
    }


    @Test
    void shouldCorrectlyConvertCurrency() throws InterruptedException {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPageUSD = homePage.goToSearchFlightsPageWithResults("WWA");
        int usdValue = flightListsPageUSD.extractFirstFlightPriceValue(0);
        FlightListsPage flightListsPageJPY = flightListsPageUSD.changeCurrency(6);
        int jpyValue = flightListsPageJPY.extractFirstFlightPriceValue(6);
        Assertions.assertTrue((usdValue * 100 < jpyValue) && (usdValue * 150 > jpyValue));
    }

    @Test
    void shouldCorrectlyChangePriceRange() throws InterruptedException {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isNarrowerPriceRangeFlightsListCorrectlyDisplayed());
    }

    @Test
    void shouldCorrectlyChangeAirlines() {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        FlightListsPage flightListsPage = homePage.goToSearchFlightsPageWithResults("WWA");
        Assertions.assertTrue(flightListsPage.isChangeAirlinesCorrectlyDisplayed());
    }

}
