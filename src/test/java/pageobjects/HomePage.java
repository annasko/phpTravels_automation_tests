package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"search\"]/div/div/div/div/div/nav/ul/li[2]")
    WebElement flightsButton;

    public HomePage (WebDriver driver, WebDriverWait wait) {
        super( driver, wait);
    }

    public boolean isRussianLanguageDisplayed () {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        System.out.println(flightsButton.getText());
        return flightsButton.getText().contains("ПОЛЕТЫ");
    }

    public boolean isGermanLanguageDisplayed () {
        wait.until(ExpectedConditions.elementToBeClickable(flightsButton));
        System.out.println(flightsButton.getText());
        return flightsButton.getText().contains("FLÜGE");
    }

}
