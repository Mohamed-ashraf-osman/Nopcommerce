package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected static void ClickBtn(String linkTest) {
        driver.findElement(By.linkText(linkTest)).click();
    }

    protected static void SetText(By by, String textValue) {
        driver.findElement(by).sendKeys(textValue);
    }

    public static void ScrollToBtn(String scroll) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(scroll);
    }

    public static void WaitTime(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

}