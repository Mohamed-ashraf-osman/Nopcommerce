package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BuildComputerWishListPage extends BasePage {
    public BuildComputerWishListPage(WebDriver driver){
        super(driver);
    }
    private final By productName = By.xpath("//td//a[@class='product-name']");
    private final By productProcessor = By.xpath("//td//div[@class='attributes']");
    private final By quantityNumber = By.xpath("//td//input[@class='qty-input']");
    private final By productPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");
    public boolean AssertWishListPage(){
        driver.findElement(productName).isDisplayed();
        driver.findElement(productProcessor).isDisplayed();
        driver.findElement(quantityNumber).isDisplayed();
        driver.findElement(productPrice).isDisplayed();
        driver.findElement(totalPrice).isDisplayed();
        return true;
    }

}