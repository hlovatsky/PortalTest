package tests;

import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.MainPage;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTest extends BaseTest {
    @Test
    public void RegistrationTest() throws IOException {
        MainPage mainPage = new MainPage();

        CreateAccountPage register = mainPage.clickOnRegisterButton()
                .selectUserType()
                .writeIntoExcel("C:\\Users\\hlova\\PortalTest\\Employee.xlsx")
                .readFromExcel("C:\\Users\\hlova\\PortalTest\\Employee.xlsx")
                .selectSpeciality()
                .selectGender()
                .selectProvince()
                .clickOnRegisterButton();

        assertThat(register.isErrorMessageDisplayed())
                .as("The texts isn't displayed")
                .isTrue();
    }

}
