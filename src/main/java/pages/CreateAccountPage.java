package pages;

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

    @SuppressWarnings("deprecation")
    public CreateAccountPage writeIntoExcel(String file) throws IOException {
        Workbook book = new HSSFWorkbook();
        Sheet sheet = book.createSheet("Employee.xlsx");

        Row row = sheet.createRow(0);

        Cell firstName = row.createCell(0);
        firstName.setCellValue("John");

        Cell lastName = row.createCell(1);
        lastName.setCellValue("Johnson");

        Cell email = row.createCell(2);
        email.setCellValue("test-test@gmail.gc.ca ");

        Cell emailVerify = row.createCell(3);
        emailVerify.setCellValue("test-test@gmail.gc.ca");

        Cell licenseNumber = row.createCell(4);
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
            String firstName = row.getCell(0).getStringCellValue();
            firstNameField.sendKeys(firstName);

            String lastName = row.getCell(1).getStringCellValue();
            lastNameField.sendKeys(lastName);

            String email = row.getCell(2).getStringCellValue();
            emailField.sendKeys(email);

            String emailVerify = row.getCell(3).getStringCellValue();
            emailVerifyField.sendKeys(emailVerify);

            String licenseNumber = row.getCell(4).getStringCellValue();
            licenseNumberField.sendKeys(licenseNumber);
        }

        myExcelBook.close();
        return this;
    }

    public CreateAccountPage selectUserType() {
        selectUserTypeField.click();
        return this;
    }

    public CreateAccountPage selectSpeciality() {
        specialityField.click();
        return this;
    }

    public CreateAccountPage selectGender() {
        genderField.click();
        return this;
    }

    public CreateAccountPage selectProvince() {
        selectProvinceField.click();
        return this;
    }

    public CreateAccountPage clickOnRegisterButton() {
        registerButton.click();
        return this;
    }

    public boolean isErrorMessageDisplayed() {
        return errorMessage.isDisplayed();

    }

}


