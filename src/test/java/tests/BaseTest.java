package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.BasePage;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://qatest-28flsd5.meshmd.com/SignIn?r=%2F");
        BasePage.setDriver(driver);
    }

    @AfterMethod
    public void afterMethod() {
        BasePage.getDriver().quit();

    }
}
