package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.AccountPage;
import pageobjects.HomePage;
import pageobjects.LoginPage;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeAll
    static void setUp() {
        driver = prepareWebDriver("chrome");
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static WebDriver prepareWebDriver(String name) {
        switch (name.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "ff":
                driver = new FirefoxDriver();
                break;
            case "headless":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("disable-gpu");
                driver = new ChromeDriver(chromeOptions);
            default:
                driver = new ChromeDriver();
                System.out.println("Starting Default Browser");
        }
        return driver;
    }

    public HomePage openHomePage () {
        HomePage homePage = new HomePage(driver, wait);
        homePage.open();
        return homePage;
    }

    public HomePage loginAndGoToHomePage () {
        HomePage homePage = openHomePage();
        LoginPage loginPage = homePage.goToLoginPage();
        loginPage.login("user@phptravels.com", "demouser");
        AccountPage accountPage = loginPage.goToAccountPage();
        accountPage.waitUntilAccountPageIsLoaded();
       return accountPage.goToHomePage();
    }

    @BeforeEach
    void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    @AfterAll
    static void tearDown() throws InterruptedException {
        driver.quit();
    }

//    @Test
//    void shouldHomePageBeOpen() {
//        HomePage homePage = new HomePage(driver, wait);
//        homePage.open();
//
//    }
}
