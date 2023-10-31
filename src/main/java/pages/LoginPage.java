package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {super(driver);}
    private final By welcomeMessage = By.xpath("//div[@class=\"topic-block-title\"]//h2");
    private final By emailField = By.id("Email");
    private final By passwordfield = By.className("password");
    private final By loginBtn = By.xpath("//button[@class=\"button-1 login-button\"]");
    private final By loginPageMsg = By.xpath("//div[@class='topic-block-title']//h2");
    private final By myAccountLink = By.className("ico-account");
    private final By logoutBtn = By.className("ico-logout");

    public LoginPage fillLoginInfo(String email, String password) {
        SetText(emailField, email);
        SetText(passwordfield, password);
        return this;
    }
    public LoginPage ClickOnLoginBtn() {
        driver.findElement(loginBtn).click();
        return this;
    }
    public HomePage ClickOnLogOut() {
        driver.findElement(logoutBtn).click();
        return new HomePage(driver);}
    public String SuccessLoginMessage() {
        WaitTime(loginPageMsg);
        return driver.findElement(loginPageMsg).getText();}
    public MyAccountPage ClickOnMyAccount(){
        driver.findElement(myAccountLink).click();
        return new MyAccountPage(driver);}

}