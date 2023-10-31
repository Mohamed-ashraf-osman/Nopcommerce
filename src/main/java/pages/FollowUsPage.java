package pages;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class FollowUsPage extends BasePage{
    public FollowUsPage (WebDriver driver){ super (driver);}

    public void GetWindowHandles(String linkText){
        ClickBtn(linkText);
        String MainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for(String window:allWindows){
            if(!window.equalsIgnoreCase(MainWindow)){
                driver.switchTo().window(window);}
        }
    }
}