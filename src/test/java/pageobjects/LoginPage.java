package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(name = "username")
    WebElement emailField;

    @FindBy(name = "password")
    WebElement passwordField;

    @FindBy(className = "loginbtn")
    WebElement submitLoginButton;

    @FindBy(className = "alert-danger")
    WebElement alertDanger;

    @FindBy(xpath = "/html/body/div/div[1]/section/div/div[1]/div[1]/div/h3")
    WebElement loginText;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public AccountPage goToAccountPage() {
        return new AccountPage(driver, wait);
    }

    public void login(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    public boolean isLoginPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(loginText));
        return loginText.isDisplayed();
    }

    public boolean isDangerAlertTextCorrectlyDisplayed(String dangerAlertText) {
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return alertDanger.getText().contains(dangerAlertText);
    }

}
