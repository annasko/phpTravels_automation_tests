package pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage {

    @FindBy(name = "firstname")
    WebElement firstnameField;

    @FindBy(name = "lastname")
    WebElement lastnameField;

    @FindBy(name = "phone")
    WebElement phoneField;

    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[5]/label")
    WebElement emailField;

    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[6]/label")
    WebElement passwordField;

    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[7]/label")
    WebElement confirmPasswordField;

    @FindBy(xpath = "/html/body/div[2]/div[1]/section/div/div/div[1]/div/h3")
    WebElement singUpText;

    @FindBy(xpath = "//*[@id=\"headersignupform\"]/div[2]/div")
    WebElement alertDanger;

    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void register(String firstName, String lastName, String mobilePhone, String email, String password, String confirmPassword) {
        firstnameField.sendKeys(firstName);
        lastnameField.sendKeys(lastName);
        phoneField.sendKeys(mobilePhone);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
        confirmPasswordField.sendKeys(Keys.ENTER);
    }

    public AccountPage goToAccountPage() {
        return new AccountPage(driver, wait);
    }

    public boolean isRegisterPageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(singUpText));
        return singUpText.isDisplayed();
    }

    public boolean isAlertTextDisplayed(String alertText) {
        wait.until(ExpectedConditions.visibilityOf(alertDanger));
        return alertDanger.getText().contains(alertText);
    }

    public boolean isPasswordTooShortAlertDisplayed() {
      return  isAlertTextDisplayed("The Password field must be at least 6 characters in");
    }

    public boolean isConfirmPasswordAlertDisplayed() {
      return  isAlertTextDisplayed("Password not matching with confirm password.");
    }

    public boolean isEmailAlertDisplayed() {
       return isAlertTextDisplayed("Email field must contain a valid email address");
    }

}
