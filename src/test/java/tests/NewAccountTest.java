package tests;

import org.testng.annotations.Test;
import pages.MainPage;

import static org.assertj.core.api.Assertions.assertThat;

public class NewAccountTest extends BaseTest {
    @Test
    public void checkTextInRegisterForm() {

        MainPage mainPage = new MainPage();

        String textFromRegisterForm = mainPage.clickOnRegisterButton()
                .getTextFromRegisterWindow();

        assertThat(textFromRegisterForm)
                .as("The texts are different")
                .isEqualTo("Create an Account");
    }
}
