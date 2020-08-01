package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage extends BasePage {

    @FindBy(xpath = "(//*[@id=\"dropdownCurrency\"])[2]")
    WebElement userDemoAccountButton;

    @FindBy(xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")
    WebElement logoutButton;

    @FindBy(xpath = "/html/body/div/div[1]/div[1]/div/div/div[1]/div/div[2]/h3")
    WebElement hiDemoUserText;

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isDemoUserAccountButtonDisplayed() {
        waitUntilAccountPageIsLoaded();
        return userDemoAccountButton.isDisplayed();
    }

    public void clickOnLogoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(hiDemoUserText));
        wait.until(ExpectedConditions.elementToBeClickable(userDemoAccountButton));
        userDemoAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButton.click();

    }

    public void waitUntilAccountPageIsLoaded() {
        wait.until(ExpectedConditions.visibilityOf(hiDemoUserText));
    }
}
