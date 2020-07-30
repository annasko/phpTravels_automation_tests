package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.ShortMessage;

public class BasePage {

    final String URL = "https://www.phptravels.net";
    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(xpath = "(//*[@id=\"dropdownCurrency\"])[2]")
    WebElement myAccountButton;

    @FindBy(xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[1]")
    WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[3]/div/div/div/a[2]")
    WebElement signInButton;

    @FindBy(xpath = "//*[@id=\"//header-waypoint-sticky\"]/div[1]/div/div/div[2]/div/ul/li[2]/div")
    WebElement changeLanguageButton;

    @FindBy(xpath = "//*[@id=\"ru\"]")
    WebElement russianLanguageButton;

    @FindBy(xpath = "//*[@id=\"de\"]")
    WebElement germanLanguageButton;


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

    public RegisterPage goToRegisterPage () {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new RegisterPage (driver, wait);
    }

    public HomePage changeToRussianLanguage () {
        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageButton));
        changeLanguageButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(russianLanguageButton));
        russianLanguageButton.click();
        return new HomePage(driver, wait);
    }

    public HomePage changeToGermanLanguage () {
        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageButton));
        changeLanguageButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(germanLanguageButton));
        germanLanguageButton.click();
        return new HomePage(driver, wait);
    }
}

