package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookingConfirmationPage extends BasePage {

    @FindBy(className = "float-right")
    List<WebElement> floatRightElements;

    @FindBy(id = "passenger_name_0")
    WebElement passengerName;

    @FindBy(id = "passenger_age_0")
    WebElement passengerAge;

    @FindBy(id = "passenger_passport_0")
    WebElement passengerPassportNumber;

    @FindBy(className = "completebook")
    WebElement confirmBookingButton;

    public BookingConfirmationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public BookingSummaryPage fillPassengerDataAndConfirm(String name, String age, String passportNo) {
        wait.until(ExpectedConditions.elementToBeClickable(passengerName));
        passengerName.sendKeys(name);
        wait.until(ExpectedConditions.elementToBeClickable(passengerAge));
        passengerAge.sendKeys(age);
        wait.until(ExpectedConditions.elementToBeClickable(passengerPassportNumber));
        passengerPassportNumber.sendKeys(passportNo);
        wait.until(ExpectedConditions.elementToBeClickable(confirmBookingButton));
        confirmBookingButton.click();
        return new BookingSummaryPage(driver, wait);
    }

    public BookingSummaryPage confirmHotelBooking() {
        wait.until(ExpectedConditions.elementToBeClickable(confirmBookingButton));
        confirmBookingButton.click();
        return new BookingSummaryPage(driver, wait);
    }

    public boolean isNumberOfAdultsDisplayed(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(floatRightElements));
        WebElement element = floatRightElements.get(5);
        return element.getText().contains(text);
    }
}
