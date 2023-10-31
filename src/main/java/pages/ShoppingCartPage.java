package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

public class ShoppingCartPage extends HomePage {
    public ShoppingCartPage(WebDriver driver){
        super(driver);
    }
    private static final By productName = By.xpath("//td//a[@class='product-name']");
    private static final By quantityNumber = By.xpath("//td//input[@class='qty-input'] ");
    private final By productPrice = By.xpath("//td//span[@class='product-unit-price']");
    private final By totalPrice =By.xpath("//td//span[@class='product-subtotal']");

    public static String getProductName(){
        return driver.findElement(productName).getText();}
    public static String getQuantityNumber(){
        return driver.findElement(quantityNumber).getAttribute("value");}
    public String productPrice()  {
        return driver.findElement(productPrice).getText();}
    public String totalPrice(){return driver.findElement(totalPrice).getText();}

}