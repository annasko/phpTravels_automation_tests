package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BookFlightPage extends BasePage {

    @FindBy(className = "float-right")
    List<WebElement> floatRightElements;


    public BookFlightPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isNumberOfAdultsDisplayed(String text) {
        wait.until(ExpectedConditions.visibilityOfAllElements(floatRightElements));
        WebElement element = floatRightElements.get(5);
        return element.getText().contains(text);
    }


}
