package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class ForgotPasswordTest extends BaseTest {
    @Test
    public void checkForgotPasswordLink() {
        MainPage mainPage = new MainPage();

        String textFromNameOfResetPasswordWindow = mainPage.clickOnForgotPasswordLink()
                .getTextFromNameOfResetPasswordWindow();

        assertThat(textFromNameOfResetPasswordWindow)
                .as("The texts are different")
                .isEqualTo("Reset Password");
    }
}
