package pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ForgotPasswordPage extends BasePage {
    @FindBy(xpath = "//form[@id='form-reset']//h3[@class='form-title base-color']")
    private WebElement nameOfResetPasswordWindow;

    public ForgotPasswordPage() {
        PageFactory.initElements(getDriver(), this);

    }

    public String getTextFromNameOfResetPasswordWindow() {
        log.info("Getting text from nameOfResetPasswordWindow");
        return nameOfResetPasswordWindow.getText();

    }
}
