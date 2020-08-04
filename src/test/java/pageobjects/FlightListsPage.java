package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FlightListsPage extends BasePage {

    public FlightListsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(className = "heading-title")
    WebElement headingTitleText;

    @FindBy(className = "theme-search-results-item-price-btn")
    WebElement bookNowButton;

    @FindBy(xpath = "//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/div/p[2]")
    WebElement typeClassText;

    @FindBy(className = "text-center")
    List<WebElement> changeCurrencyButtons; //usunąć

    @FindBy(className = "dropdown-currency")
    List<WebElement> currencyList; //usunąć

    @FindBy(xpath = "//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/div/p[1]/strong")
    WebElement flightPrice;

    @FindBy(css = ".irs-slider.from")
    WebElement leftSideBar;

    @FindBy(className = "theme-search-results-item-price-tag")
    List<WebElement> flightPrices;

    @FindBy(xpath = "//*[@id=\"myBtn\"]")
    WebElement airArabiaAirlinesButton;

    @FindBy(className = "theme-search-results-item-flight-section-airline-title")
    WebElement nameOfAirlinesText;

    public boolean isFlightsPageDisplayed(String text) {
        wait.until(ExpectedConditions.elementToBeClickable(headingTitleText));
        return headingTitleText.getText().contains(text);
    }

    public BookingConfirmationPage goToBookingConfirmationPage() {
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
        bookNowButton.click();
        return new BookingConfirmationPage(driver, wait);
    }

    public boolean isTypeClassTextDisplayed(String typeClass) {
        wait.until(ExpectedConditions.visibilityOf(typeClassText));
        return typeClassText.getText().contains(typeClass);
    }
//    public void changeCurrency (int currencyIndex) {
//        WebElement listElements = currencyList.get(0);
//        listElements.click();
//        WebElement currencyChangeElement = changeCurrencyButtons.get(currencyIndex);
//        currencyChangeElement.click();
//    }

//    public boolean isChangeToSARCurrencyDisplayed(String currency) {
////        WebElement listElements = currencyList.get(0);
////        listElements.click();
////        WebElement sarElement = changeCurrencyButtons.get(2);
////        sarElement.click();
//        clickChangeCurrency(2);
//        wait.until(ExpectedConditions.visibilityOf(flightPrice));
//        return flightPrice.getText().contains(currency);
//    }

    public boolean isCurrencyDisplayed(String currency) {
        wait.until(ExpectedConditions.visibilityOf(flightPrice));
        return flightPrice.getText().contains(currency);
    }

    public int extractFirstFlightPriceValue() {
        wait.until(ExpectedConditions.visibilityOf(flightPrice));
        int flightPriceValue = Integer.parseInt(flightPrice.getText().substring(4));
        return flightPriceValue;
    }

    public int extractPriceValueFromWebElement(WebElement priceElement) {
        return Integer.parseInt(priceElement.getText().substring(4));

    }

    public FlightListsPage changeCurrency(int newCurrencyIndexNumber) throws InterruptedException {
//        WebElement listElements = currencyList.get(0);
//        listElements.click();
//        WebElement currencyName = changeCurrencyButtons.get(newCurrencyIndexNumber);
//        currencyName.click();
        clickChangeCurrency(newCurrencyIndexNumber);
        Thread.sleep(5000);
        return new FlightListsPage(driver, wait);
    }

    public boolean isNarrowerPriceRangeFlightsListCorrectlyDisplayed() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(leftSideBar));
        Actions builder = new Actions(driver);
        Action moveRight = builder.dragAndDropBy(leftSideBar, 60, 0).build();
        Thread.sleep(1000);
        moveRight.perform();
        for (WebElement price : flightPrices) {
            int priceValue = extractPriceValueFromWebElement(price);
            System.out.println(priceValue);
            if (priceValue < 36) {
                return false;
            }
        }
        return true;
    }


    public void selectAirArabiaAirlines () {
        wait.until(ExpectedConditions.visibilityOf(airArabiaAirlinesButton));
        airArabiaAirlinesButton.click();
    }

    public boolean isAirlineNameCorrectlyDisplayed(String airlineName) {
        return nameOfAirlinesText.getText().equals(airlineName);
    }

}
