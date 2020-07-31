package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFlightsPage extends BasePage {

    public SearchFlightsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy (className = "heading-title")
    WebElement headingTitleText;

    @FindBy (className = "theme-search-results-item-price-btn")
    WebElement bookNowButton;

    @FindBy (xpath = "//*[@id=\"LIST\"]/li[1]/div/div[1]/div[2]/form/div[2]/div/div/p[2]")
    WebElement typeClassText;

    public boolean isFlightsPageDisplay (String text) {
        wait.until(ExpectedConditions.elementToBeClickable(headingTitleText));
        return headingTitleText.getText().contains(text);
    }

    public BookFlightPage isBookNowPageDisplay () {
        wait.until(ExpectedConditions.elementToBeClickable(bookNowButton));
        bookNowButton.click();
        return new BookFlightPage(driver,wait);
    }

    public boolean isTypeClassTextDisplay (String typeClass) {
        wait.until(ExpectedConditions.visibilityOf(typeClassText));
        return typeClassText.getText().contains(typeClass);
    }

}
