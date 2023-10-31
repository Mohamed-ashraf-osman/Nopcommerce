package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;

public class MyAccountPage extends BasePage {
    public MyAccountPage (WebDriver driver){super(driver);}
    private static final By changePassword = By.linkText("Change password");
    private static final By oldPassword = By.id("OldPassword");
    private static final By newPassword = By.id("NewPassword");
    private static final By confirmPassword = By.id("ConfirmNewPassword");
    private static final By changePasswordButton = By.xpath("//button[@class=\"button-1 change-password-button\"]");
    private final By logout = By.className("ico-logout");
    private final By alertMsg = By.className("content");
    private final By close = By.className("close");
    public static void ClickOnChangePassword(){
        driver.findElement(changePassword).click();
    }
    public static void fillPassword(String oldpassword, String newpassword, String confirmpassword) {
        driver.findElement(oldPassword).sendKeys(oldpassword);
        driver.findElement(newPassword).sendKeys(newpassword);
        driver.findElement(confirmPassword).sendKeys(confirmpassword);
    }
    public static void ClickOnChangePasswordbtn() {
        driver.findElement(changePasswordButton).click();
    }
    public HomePage ClickOnLogout() {
        driver.findElement(logout).click();
        return new HomePage(driver);
    }
    public String AlertMessage() {
        WaitTime(alertMsg);
        return driver.findElement(alertMsg).getText();
    }
    public void ClickOnClose() {
        driver.findElement(close).click();
    }
}
