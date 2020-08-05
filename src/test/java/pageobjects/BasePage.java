package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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

    @FindBy(xpath = "//*[@id=\"mobileMenuMain\"]/nav/ul[1]/li/a")
    WebElement goToHomePageButton;

    @FindBy(className = "text-center") //dodane
            List<WebElement> changeCurrencyButtons;

    @FindBy(className = "dropdown-currency") //dodane
            List<WebElement> currencyList;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public LoginPage goToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        return new LoginPage(driver, wait);
    }

    public RegisterPage goToRegisterPage() {
        wait.until(ExpectedConditions.elementToBeClickable(myAccountButton));
        myAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
        signInButton.click();
        return new RegisterPage(driver, wait);
    }

    public HomePage goToHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(goToHomePageButton));
        goToHomePageButton.click();
        return new HomePage(driver, wait);
    }

    public HomePage changeLanguage(WebElement languageButton) {
        wait.until(ExpectedConditions.elementToBeClickable(changeLanguageButton));
        changeLanguageButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(languageButton));
        languageButton.click();
        return new HomePage(driver, wait);
    }

    public HomePage changeToRussianLanguage() {
        return changeLanguage(russianLanguageButton);
    }

    public HomePage changeToGermanLanguage() {
        return changeLanguage(germanLanguageButton);
    }

    public void open() {
        driver.get(URL);
    }

    public void clickChangeCurrency(int currencyIndex) {
        WebElement listElements = currencyList.get(0);
        listElements.click();
        WebElement currencyChangeElement = changeCurrencyButtons.get(currencyIndex);
        currencyChangeElement.click();
    }
}

