package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
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
        log.info("Clicking on the frenchLanguageLink");
        frenchLanguageLink.click();
        return this;
    }

    public String getTextFromNameOfRegistrationWindow() {
        log.info("Getting text from nameOfRegistrationWindow");
        return nameOfRegistrationWindow.getText();

    }

    public ForgotPasswordPage clickOnForgotPasswordLink() {
        log.info("Clicking on the forgotPasswordLink");
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public MainPage clickOnSignInButton() {
        log.info("Clicking on the signInButton");
        signInButton.click();
        return this;
    }

    public String getTextFromEmailErrorWindow() {
        log.info("Getting text from EmailErrorWindow");
        return emailErrorWindow.getText();

    }

    public String getTextFromPasswordErrorWindow() {
        log.info("Getting text from passwordErrorWindow");
        return passwordErrorWindow.getText();

    }

    public CreateAccountPage clickOnRegisterButton() {
        log.info("Clicking on the registerButton");
        registerButton.click();
        return new CreateAccountPage();
    }
}
