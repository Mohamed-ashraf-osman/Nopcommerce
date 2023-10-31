package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends HomePage {
    public SearchPage(WebDriver driver){
        super (driver);
    }
    private final By ProductName = By.xpath("//h2[@class='product-title']");
    private final By productLink = By.xpath("//h2[@class='product-title']//a");
    private final By searchInput = By.xpath("//input[@id='q']");
    public String CheckProductName(){
        return driver.findElement(ProductName).getText();
    }
    public String CheckProductNameInSearchkeyword(){
        return driver.findElement(searchInput).getAttribute("value");
    }
    public ProductPage NavigateToProductLink(){
        driver.findElement(productLink).click();
        return new ProductPage(driver);}
}