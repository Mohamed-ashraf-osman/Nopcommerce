package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import java.io.File;
import java.io.IOException;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage homePage;
    @BeforeClass
    @Parameters({"browserType"})
    public void SetUp(@Optional("Firefox Driver")  String browserType) {
        if (browserType.equalsIgnoreCase("Firefox Driver")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("ChromeDriver")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("Edge Driver")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        goHome();
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://demo.nopcommerce.com/");
        homePage = new HomePage(driver);
    }
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus()){
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot,new File("C:\\Users\\pc\\IdeaProjects\\NopCommerceDemo\\screenshot" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @AfterClass
    public void TearDown(){
        driver.quit();
    }
}
