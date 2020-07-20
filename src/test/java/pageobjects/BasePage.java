package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    final String URL = "https://www.phptravels.net";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "(//*[@id=\"dropdownCurrency\"])[2]")
    WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]")
    WebElement loginButton;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    public void open() {
        driver.get(URL);
    }

    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage(driver, wait);
    }
}

//public LoginPage goToLogin () {
//    wait.until(ExpectedConditions.elementToBeClickable(signInButton));
//    signInButton.click();
//    return new LoginPage(driver, wait);
//}
//}