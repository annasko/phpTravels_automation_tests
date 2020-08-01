package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingSummaryPage extends BasePage {
    @FindBy(className = "success-box")
    WebElement bookingAlert;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div/div[2]/center/button[2]")
    WebElement payNowButton;

    public BookingSummaryPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isBookingAlertDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(payNowButton));
        wait.until(ExpectedConditions.visibilityOf(bookingAlert));
        return bookingAlert.getText().contains("Your booking status is Unpaid");
    }
}
