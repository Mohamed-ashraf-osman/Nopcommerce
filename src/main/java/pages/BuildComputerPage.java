package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BuildComputerPage extends BasePage {
    public BuildComputerPage(WebDriver driver){super(driver);}
    private final By ramList =By.id("product_attribute_2");
    private final By hddCheckBox = By.id("product_attribute_3_7");
    private final By osCheckBox = By.id("product_attribute_4_9");
    private final By softwareCheckBox = By.id("product_attribute_5_11");
    private final By addToWishListBtn = By.xpath("//button[@id='add-to-wishlist-button-1']");
    private final By successMessage = By.xpath("//div[@class='bar-notification success']//p");
    private final By closeSuccessMsg = By.xpath("//span[@class='close']");
    private final By wishListPageBtn = By.xpath("//span[@class='wishlist-label']");

    /*
    use fluent pattern in java (return this) to show all methods in the class at test and to navigate from page to page
    easy and write simple code.
    */
    public BuildComputerPage fillInfoAndAddForProduct(){
        WebElement element = driver.findElement(ramList);
        Select select = new Select(element);
        select.selectByValue("4");
        driver.findElement(hddCheckBox).click();
        driver.findElement(osCheckBox).click();
        driver.findElement(softwareCheckBox).click();
        return this;}
    public void clickAddToWishBtn(){driver.findElement(addToWishListBtn).click();}
    public String successMessageText() {
        WaitTime(successMessage);
        return driver.findElement(successMessage).getText();}
    public void closeSuccessMsg(){
        driver.findElement(closeSuccessMsg).click();
    }
    public BuildComputerWishListPage NavigateToWishListPage(){
        driver.findElement(wishListPageBtn).click();
        return new BuildComputerWishListPage(driver);}
}