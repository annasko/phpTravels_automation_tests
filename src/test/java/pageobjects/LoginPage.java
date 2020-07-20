package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @FindBy(name = "username")
    private WebElement emailField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(className = "loginbtn")
    private WebElement submitLoginButton;

    @FindBy(className = "alert-danger")
    private WebElement alertDanger;

    @FindBy(xpath = "/html/body/div/div[1]/section/div/div[1]/div[1]/div/h3")
    private WebElement loginText;

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
    public boolean isEmailRequiredAlertDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return alertDanger.getText().contains("Invalid Email");
    }

    public boolean isPasswordRequiredAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return alertDanger.getText().contains("Password");
    }

    public boolean isEmailAndPasswordRequiredAlertDisplayed(){
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return alertDanger.getText().contains("Invalid Email or Password");
    }


}
