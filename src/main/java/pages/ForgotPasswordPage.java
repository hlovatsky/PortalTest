package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {
    @FindBy(xpath = "//form[@id='form-reset']//h3[@class='form-title base-color']")
    private WebElement nameOfResetPasswordWindow;

    public ForgotPasswordPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public String getTextFromNameOfResetPasswordWindow() {
        return nameOfResetPasswordWindow.getText();

    }
}
