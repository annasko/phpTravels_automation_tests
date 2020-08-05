package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[2]")
    WebElement flightsButton;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li/ul/li[4]/div")
    WebElement selectDisneylandParis;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[1]/div")
    WebElement selectAlzerHotelInstanbul;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/ul/li[1]/ul/li[2]")
    WebElement selectTriaHotelIstanbul;

    @FindBy(css = "div.locationlistHotels")
    WebElement destinationInput;

    @FindBy(id = "s2id_location_from")
    WebElement fromAirportInput;

    @FindBy(xpath = "//*[@id=\"select2-drop\"]/div/input")
    WebElement destinationInputContainer;

    @FindBy(className = "select2-match")
    WebElement fromAirportListDropdown;

    @FindBy(xpath = "//*[@id=\"hotels\"]/div/div/form/div/div/div[4]/button")
    WebElement searchHotelsButton;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[4]/button")
    WebElement searchFlightsButton;

    @FindBy(xpath = "//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[1]/a")
    WebElement hotelsButton;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[1]/div/div[2]")
    WebElement roundTripButton;

    @FindBy(xpath = "//*[@id=\"airDatepickerRange-flight\"]/div[1]/div/div[2]")
    WebElement departDateButton;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[7]/nav/div[3]")
    WebElement goToNextMonthOnDepartDataButton;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[7]/div/div/div[2]/div[33]")
    WebElement departDateFromOtherMonth;

    @FindBy(xpath = "//*[@id=\"datepickers-container\"]/div[8]/div/div/div[2]/div[28]")
    WebElement returnDateFromOtherMonth;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[3]/div[3]/div/div/div[1]/div/div[2]/div/span/button[1]")
    WebElement addAdultToFlightsButton;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[2]/div/div/a")
    WebElement searchTypeClass;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[2]/div/div/div/ul/li[2]")
    WebElement businessClassButton;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[2]/div/div/div/ul/li[3]")
    WebElement economyClassButton;

    @FindBy(xpath = "//*[@id=\"flights\"]/div/div/form/div/div/div[1]/div[2]/div/div/div/ul/li[1]")
    WebElement firstClassButton;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private HotelDetailsPage goToSearchHotelResults(String hotelInputText, WebElement hotelListSelectButton) {
        findDestinationHotelInput(hotelInputText);
        wait.until(ExpectedConditions.elementToBeClickable(hotelListSelectButton));
        hotelListSelectButton.click();
//        wait.until(ExpectedConditions.elementToBeClickable(searchHotelsButton));
//        searchHotelsButton.click();
//        return new HotelDetailsPage(driver, wait);
        return submitSearchHotelForm();
    }

    public HotelDetailsPage goToDisneylandNoResultsFoundPage() {
        return goToSearchHotelResults("Disneyland", selectDisneylandParis);
    }

    public HotelDetailsPage goToTriaOneResultFoundPage() {
        return goToSearchHotelResults("Tria", selectTriaHotelIstanbul);
    }

    public HotelDetailsPage goToAlzerhManyResultsFoundPage() {
        return goToSearchHotelResults("Alzer", selectAlzerHotelInstanbul);
    }

    public FlightListsPage goToSearchFlightsPageWithResults(String airportSearchText) {
        selectFlightsTab();
        selectDepartureAirportByName(airportSearchText);
        return submitSearchFlightForm();
    }

    public FlightListsPage goToSearchFlightsPageWithRoundTripResults() {
        selectFlightsTab();
        selectRoundTrip();
        return submitSearchFlightForm();
    }

    public FlightListsPage goToSearchFlightsPageWithChangedDepartAndReturnDate() {
        selectFlightsTab();
        selectRoundTrip();
        selectNextMonthFlightDates();
        return submitSearchFlightForm();
    }

    public FlightListsPage goToSearchFlightsPageWithManyAdults(int numberOfAdults) {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        for (int i = 0; i < numberOfAdults; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addAdultToFlightsButton));
            addAdultToFlightsButton.click();
        }
//        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
//        searchFlightsButton.click();
//        return new FlightListsPage(driver, wait);
        return submitSearchFlightForm();
    }


    private FlightListsPage goToFlightsPageWithOtherClass(WebElement classTypeButton) {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchTypeClass));
        searchTypeClass.click();
        wait.until(ExpectedConditions.elementToBeClickable(classTypeButton));
        classTypeButton.click();
//        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
//        searchFlightsButton.click();
//        return new FlightListsPage(driver, wait);
        return submitSearchFlightForm();
    }

    public FlightListsPage goToSearchFlightsPageWithBusinessClass() {
        return goToFlightsPageWithOtherClass(businessClassButton);
    }

    public FlightListsPage goToSearchFlightsPageWithEconomyClass() {
        return goToFlightsPageWithOtherClass(economyClassButton);
    }

    public FlightListsPage goToSearchFlightsPageWithFirstClass() {
        return goToFlightsPageWithOtherClass(firstClassButton);
    }

    private FlightListsPage submitSearchFlightForm() {
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    private HotelDetailsPage submitSearchHotelForm() {
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelsButton));
        searchHotelsButton.click();
        return new HotelDetailsPage(driver, wait);
    }

    private void findDestinationHotelInput(String destinationInputText) {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton));
        hotelsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
        destinationInput.click();
        destinationInputContainer.sendKeys(destinationInputText);
    }

    private void selectFlightsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
    }

    private void selectRoundTrip() {
        wait.until(ExpectedConditions.elementToBeClickable(roundTripButton));
        roundTripButton.click();
    }

    private void selectDepartureAirportByName(String airportSearchText) {
        wait.until(ExpectedConditions.elementToBeClickable(fromAirportInput));
        fromAirportInput.click();
        destinationInputContainer.sendKeys(airportSearchText);
        wait.until(ExpectedConditions.elementToBeClickable(fromAirportListDropdown));
        fromAirportListDropdown.click();
    }

    private void selectNextMonthFlightDates() {
        wait.until(ExpectedConditions.elementToBeClickable(departDateButton));
        departDateButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(goToNextMonthOnDepartDataButton));
        goToNextMonthOnDepartDataButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(departDateFromOtherMonth));
        departDateFromOtherMonth.click();
        wait.until(ExpectedConditions.elementToBeClickable(returnDateFromOtherMonth));
        returnDateFromOtherMonth.click();
    }

    public boolean isFlightNameTextCorrectlyDisplayed(String flightText) {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        return flightsButton.getText().contains(flightText);
    }
}
