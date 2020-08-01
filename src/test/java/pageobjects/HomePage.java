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

    public boolean isRussianLanguageDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        return flightsButton.getText().contains("ПОЛЕТЫ");
    }

    public boolean isGermanLanguageDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        return flightsButton.getText().contains("FLÜGE");
    }

    public HotelDetailsPage goToSearchHotelsPageWithNoResults(String destination) {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton));
        hotelsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
        destinationInput.click();
        destinationInputContainer.sendKeys(destination);
        wait.until(ExpectedConditions.elementToBeClickable(selectDisneylandParis));
        selectDisneylandParis.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelsButton));
        searchHotelsButton.click();
        return new HotelDetailsPage(driver, wait);
    }

    public HotelDetailsPage goToSearchHotelsPageWithOneResult() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton));
        hotelsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
        destinationInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectTriaHotelIstanbul));
        selectTriaHotelIstanbul.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelsButton));
        searchHotelsButton.click();
        return new HotelDetailsPage(driver, wait);
    }

    public HotelDetailsPage goToSearchHotelsPageWithMoreThanOneResults() {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsButton));
        hotelsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(destinationInput));
        destinationInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(selectAlzerHotelInstanbul));
        selectAlzerHotelInstanbul.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchHotelsButton));
        searchHotelsButton.click();
        return new HotelDetailsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithResults(String airport) {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(fromAirportInput));
        fromAirportInput.click();
        destinationInputContainer.sendKeys(airport);
        wait.until(ExpectedConditions.elementToBeClickable(fromAirportListDropdown));
        fromAirportListDropdown.click();

        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithRoundTripResults() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(roundTripButton));
        roundTripButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithChangeDepartAndReturnDate() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(roundTripButton));
        roundTripButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(departDateButton));
        departDateButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(goToNextMonthOnDepartDataButton));
        goToNextMonthOnDepartDataButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(departDateFromOtherMonth));
        departDateFromOtherMonth.click();

        wait.until(ExpectedConditions.elementToBeClickable(returnDateFromOtherMonth));
        returnDateFromOtherMonth.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);

    }

    public FlightListsPage goToSearchFlightsPageWithChoose100Adults() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        for (int i = 0; i < 99; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(addAdultToFlightsButton));
            addAdultToFlightsButton.click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithBusinessClass() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchTypeClass));
        searchTypeClass.click();
        wait.until(ExpectedConditions.elementToBeClickable(businessClassButton));
        businessClassButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithEconomyClass() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchTypeClass));
        searchTypeClass.click();
        wait.until(ExpectedConditions.elementToBeClickable(economyClassButton));
        economyClassButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }

    public FlightListsPage goToSearchFlightsPageWithFirstClass() {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        flightsButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchTypeClass));
        searchTypeClass.click();
        wait.until(ExpectedConditions.elementToBeClickable(firstClassButton));
        firstClassButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(searchFlightsButton));
        searchFlightsButton.click();
        return new FlightListsPage(driver, wait);
    }
}
