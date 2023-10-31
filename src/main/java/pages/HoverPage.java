package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;
import java.util.List;

public class HoverPage extends BasePage{
    public HoverPage(WebDriver driver){
        super(driver);
    }
    private final By productTitle = By.className("product-title");
    private final By pageTitle = By.xpath("//div[@class='page-title']//h1");

    public void ChecKHoverMenu(String link , String linkText){
        WebElement mainMenu = driver.findElement(By.linkText(link));
        Actions action = new Actions(driver);
        action.moveToElement(mainMenu).perform();
        ClickBtn(linkText);
    }

    // check number of product in notebooks page
    public int checkCountOfProductTitles (){
        List<WebElement> title = driver.findElements(productTitle);
        return title.size();}

    // get page title
    public String GetPageTitle() throws InterruptedException {


        return  driver.findElement(pageTitle).getText();
    }
}