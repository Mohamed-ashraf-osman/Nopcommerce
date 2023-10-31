package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver driver) {super (driver);}
    private final By addToCartBtn = By.id("add-to-cart-button-4");
    private final By cartPageBtn = By.xpath("//span[@class='cart-label']");
    private final By successMsg = By.xpath("//div[@class='bar-notification success']//p");
    private final By closeSuccessMsg = By.xpath("//span[@class='close']");
    private final By emailAfriendBtn = By.xpath("//div[@class='email-a-friend']//button");
    public ProductPage ClickAddToCartBtn() {
        driver.findElement(addToCartBtn).click();
        return this;}
    public String successMsgAddProduct(){
        WaitTime(successMsg);
        return driver.findElement(successMsg).getText();}
    public void CloseAddProductMsg(){driver.findElement(closeSuccessMsg).click();}
    public ShoppingCartPage NavigateToShoppingCartPage() {
        WaitTime(cartPageBtn);
        driver.findElement(cartPageBtn).click();
        return new ShoppingCartPage(driver);}
    public EmailToFriendPage NavigateToEmailPage() {
        driver.findElement(emailAfriendBtn).click();
        return new EmailToFriendPage(driver);}
}