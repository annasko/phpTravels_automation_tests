package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {
    @FindBy (xpath = "//*[@id=\"dropdownCurrency\"]")
    WebElement userDemoAccountButton;

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isDemoUserAccountButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(userDemoAccountButton));
        return userDemoAccountButton.isDisplayed();
    }
}
