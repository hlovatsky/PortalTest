package tests;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.MainPage;

public class SignInWithEmptyFieldsTest extends BaseTest {
    @Test
    public void checkSignInWithEmptyFields() {
        MainPage mainPage = new MainPage();

        SoftAssertions softAssert = new SoftAssertions();

        MainPage textFromWindows = mainPage.clickOnSignInButton();

        softAssert.assertThat(textFromWindows.getTextFromEmailErrorWindow())
                .as("The texts are different")
                .isEqualTo("Email address is required.");

        softAssert.assertThat(textFromWindows.getTextFromPasswordErrorWindow())
                .as("The texts are different")
                .isEqualTo("Password is required.");

        softAssert.assertAll();
    }
}
