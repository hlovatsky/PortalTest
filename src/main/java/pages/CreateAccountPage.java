package pages;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Slf4j
public class CreateAccountPage extends BasePage {
    @FindBy(xpath = "//form[@id='frm_register']//h3[@class='form-title base-color']")
    private WebElement createAccountText;

    @FindBy(xpath = "//select[@id='usertype']//option[@value='1']")
    private WebElement selectUserTypeField;

    @FindBy(xpath = "//div[@class='col-md-6']//input[@name='first']")
    private WebElement firstNameField;

    @FindBy(xpath = "//label[@class='has-input']//input[@name='last']")
    private WebElement lastNameField;

    @FindBy(xpath = "//label[@class='has-input']//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//label[@class='has-input']//input[@name='email_verify']")
    private WebElement emailVerifyField;

    @FindBy(xpath = "//label[@class='has-input doc-only']//input[@id='cpso']")
    private WebElement licenseNumberField;

    @FindBy(xpath = "//select[@id='specialty']//option[@value='gastro']")
    private WebElement specialityField;

    @FindBy(xpath = "//span[@class='has-icon']//input[@class='datepicker hasDatepicker']")
    private WebElement birthdayField;

    @FindBy(xpath = "//select[@id='gender']//option[@value='F']")
    private WebElement genderField;

    @FindBy(xpath = "//label[@class='has-input']//select[@name='lang']")
    private WebElement selectLanguageField;

    @FindBy(xpath = "//select[@id='prov']//option[@value='BC']")
    private WebElement selectProvinceField;

    @FindBy(xpath = "//button[@id='btn_submit']")
    private WebElement registerButton;

    @FindBy(xpath = "//label[@class='has-input']//span[contains(text(),'Bad')]")
    private WebElement errorMessage;

    public CreateAccountPage() {
        PageFactory.initElements(getDriver(), this);

    }


    public String getTextFromRegisterWindow() {
        return createAccountText.getText();

    }

    public CreateAccountPage selectUserType() {
        log.info("Clicking on the userTypeField and choose value");
        selectUserTypeField.click();
        return this;
    }

    public CreateAccountPage writeIntoExcel(String file) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Employee.xlsx");

        Row row = sheet.createRow(0);

        log.info("Creating cell firstName with value John");
        Cell firstName = row.createCell(0);
        firstName.setCellValue("John");

        log.info("Creating cell lastName with value Johnson");
        Cell lastName = row.createCell(1);
        lastName.setCellValue("Johnson");

        log.info("Creating cell email with value test-test@gmail.gc.ca");
        Cell email = row.createCell(2);
        email.setCellValue("test-test@gmail.gc.ca");

        log.info("Creating cell emailVerify with value test-test@gmail.gc.ca");
        Cell emailVerify = row.createCell(3);
        emailVerify.setCellValue("test-test@gmail.gc.ca");

        log.info("Entering birthdate");
        Cell birthdate = row.createCell(4);
        Calendar calendar = new GregorianCalendar(1982, Calendar.AUGUST, 15);

        log.info("Creating cell licenseNumber with value 21548624");
        Cell licenseNumber = row.createCell(5);
        licenseNumber.setCellValue("21548624");

        sheet.autoSizeColumn(1);

        book.write(new FileOutputStream(file));
        book.close();
        return this;
    }

    public CreateAccountPage readFromExcel(String file) throws IOException {
        HSSFWorkbook myExcelBook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet myExcelSheet = myExcelBook.getSheet("Employee.xlsx");
        HSSFRow row = myExcelSheet.getRow(0);

        if (row.getCell(0).getCellType() == HSSFCell.CELL_TYPE_STRING) {
            log.info("Entering value in firstNameField");
            String firstName = row.getCell(0).getStringCellValue();
            firstNameField.sendKeys(firstName);

            log.info("Entering value in lastNameField");
            String lastName = row.getCell(1).getStringCellValue();
            lastNameField.sendKeys(lastName);

            log.info("Entering value in emailField");
            String email = row.getCell(2).getStringCellValue();
            emailField.sendKeys(email);

            log.info("Entering value in emailVerifyField");
            String emailVerify = row.getCell(3).getStringCellValue();
            emailVerifyField.sendKeys(emailVerify);

            log.info("Entering value in licenseNumberField");
            String licenseNumber = row.getCell(5).getStringCellValue();
            licenseNumberField.sendKeys(licenseNumber);
        }

        if (row.getCell(4).getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
            Date birthdate = row.getCell(4).getDateCellValue();
            birthdayField.sendKeys((CharSequence) birthdate);
        }

        myExcelBook.close();
        return this;
    }

    public CreateAccountPage selectSpeciality() {
        log.info("Clicking on the specialityField and choose value");
        specialityField.click();
        return this;
    }

    public CreateAccountPage selectGender() {
        log.info("Clicking on the genderField and choose value");
        genderField.click();
        return this;
    }

    public CreateAccountPage selectProvince() {
        log.info("Clicking on the provinceField and choose value");
        selectProvinceField.click();
        return this;
    }

    public CreateAccountPage clickOnRegisterButton() {
        log.info("Clicking on the registerButton");
        registerButton.click();
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        log.info("Check is errorMassage displayed");
        return errorMessage.isDisplayed();
    }
}


