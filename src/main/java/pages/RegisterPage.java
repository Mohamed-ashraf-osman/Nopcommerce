package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends HomePage {
    public RegisterPage(WebDriver driver) {super(driver);}
    private final By genderMale = By.id("gender-male");
    private final By firstNameField = By.id("FirstName");
    private final By LastNameField = By.id("LastName");
    private final By dateOfBirthDay = By.name("DateOfBirthDay");
    private final By dateOfBirthMonth = By.name("DateOfBirthMonth");
    private final By dateOfBirthYear = By.name("DateOfBirthYear");
    private final By emailFeild = By.id("Email");
    private final By companyFeild = By.id("Company");
    private final By passwordField = By.id("Password");
    private final By confirmPassWord = By.id("ConfirmPassword");
    private final By registerBtn = By.name("register-button");
    private final By completeMessage = By.className("result");
    private final By ContinueBtn = By.xpath("//a[@class='button-1 register-continue-button']");

    public RegisterPage FillMaleFields(String firstname, String lastname, String day, String month, String year, String email, String company , String password, String confPassword) {
        driver.findElement(genderMale).click();
        SetText(firstNameField, firstname);
        SetText(LastNameField, lastname);
        SelectBirthInfo(day, month, year);
        SetText(emailFeild, email);
        SetText(companyFeild, company);
        SetText(passwordField, password);
        SetText(confirmPassWord, confPassword);
        return this;
    }
    public void SelectBirthInfo(String day, String month, String year) {
        WebElement element = driver.findElement(dateOfBirthDay);
        Select select = new Select(element);
        select.selectByValue(day);

        element = driver.findElement(dateOfBirthMonth);
        select = new Select(element);
        select.selectByValue(month);

        element = driver.findElement(dateOfBirthYear);
        select = new Select(element);
        select.selectByValue(year);
    }

    public HomePage ClickOnRegisterBtn() {
        driver.findElement(registerBtn).click();
        return new HomePage(driver);
    }

    public String CompleteMessage() {
        WaitTime(completeMessage);
        return driver.findElement(completeMessage).getText();
    }

    public HomePage ClickOnContinue() {
        driver.findElement(ContinueBtn).click();
        return new HomePage(driver);}
}