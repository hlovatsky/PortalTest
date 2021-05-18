package tests;

import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import pages.MainPage;

public class ChangeLanguageTest extends BaseTest {
    @Test
    public void checkChangeLanguage() {
        MainPage mainPage = new MainPage();

        String textFromRegistrationWindow = mainPage.clickOnFrenchLanguageLink()
                .getTextFromNameOfRegistrationWindow();

        assertThat(textFromRegistrationWindow)
                .as("The texts are different")
                .isEqualTo("Ouverture de session");
    }
}
