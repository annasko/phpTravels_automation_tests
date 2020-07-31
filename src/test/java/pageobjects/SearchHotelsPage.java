package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchHotelsPage extends BasePage {

    @FindBy(xpath = "/html/body/div[2]/div[1]/div[1]/section/div/div[2]/div[2]/div/div[2]/h2")
    WebElement hotelsAlert;

    @FindBy(xpath = "//*[@id=\"detail-content-sticky-nav-00\"]")
    WebElement hotelTriaHeader;

    @FindBy(className = "text-primary")
    WebElement hotelAlzerHeader;

    public SearchHotelsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isDisneylandHotelsDisplayed () {
        wait.until(ExpectedConditions.elementToBeClickable(hotelsAlert));
        return hotelsAlert.getText().contains("No Results Found");
    }

    public boolean isTriaHotelInInstanbulDisplayed () {
        wait.until(ExpectedConditions.elementToBeClickable(hotelTriaHeader));
        return hotelTriaHeader.getText().contains("Tria Hotel Istanbul Special");
    }

    public boolean isAlzerHotelInInstanbulDisplay () {
//        wait.until(ExpectedConditions.visibilityOf(resultSummaryText));
        wait.until(ExpectedConditions.elementToBeClickable(hotelAlzerHeader));
        //System.out.println(hotelAlzerHeader.getText());
        return hotelAlzerHeader.getText().contains("Alzer-Hotel-Istanbuls");
    }
}
