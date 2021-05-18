package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;

    }

    public static WebDriver getDriver() {
        return driver;

    }
}
