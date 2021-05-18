package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='language']//a[contains(text(),'French')]")
    private WebElement frenchLanguageLink;

    @FindBy(xpath = "//h3[@class='form-title base-color']")
    private WebElement nameOfRegistrationWindow;

    @FindBy(xpath = "//p[@class='form-helper base-color text-right']//a[@href='/passwordForgot']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signInButton;

    @FindBy(xpath = "//span[text()='Email address is required.']")
    private WebElement emailErrorWindow;

    @FindBy(xpath = "//span[text()='Password is required.']")
    private WebElement passwordErrorWindow;

    @FindBy(xpath = "//div[@class='box-footer']//a[@class='button green']")
    private WebElement registerButton;

    public MainPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public MainPage clickOnFrenchLanguageLink() {
        frenchLanguageLink.click();
        return this;
    }

    public String getTextFromNameOfRegistrationWindow() {
        return nameOfRegistrationWindow.getText();

    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public MainPage clickOnSignInButton() {
        signInButton.click();
        return this;
    }

    public String getTextFromEmailErrorWindow() {
        return emailErrorWindow.getText();

    }

    public String getTextFromPasswordErrorWindow() {
        return passwordErrorWindow.getText();

    }

    public CreateAccountPage clickOnRegisterButton() {
        registerButton.click();
        return new CreateAccountPage();
    }
}
