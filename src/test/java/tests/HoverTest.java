package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoverPage;

public class HoverTest extends BaseTest {
    HoverPage hoverPage;
    @Test()
    public void HoverOverComputers(){
        hoverPage = new HoverPage(driver);
        hoverPage.ChecKHoverMenu("Computers", "Notebooks");
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
        Assert.assertEquals(hoverPage.checkCountOfProductTitles(),6);
        homePage.ScrollToBtn("scrollBy(0,400)");}
    @Test()
    public void HoverOverElectronics () throws InterruptedException {
        hoverPage = new HoverPage(driver);
        hoverPage.ChecKHoverMenu("Electronics", "Camera & photo");
        Assert.assertTrue(hoverPage.GetPageTitle().contains("Camera"));
        homePage.ScrollToBtn("scrollBy(0,400)");}
    @Test()
    public void HoverOverApparel () throws InterruptedException {
        hoverPage = new HoverPage(driver);
        hoverPage.ChecKHoverMenu("Apparel", "Shoes");
        Assert.assertTrue(hoverPage.GetPageTitle().contains("Shoes"));
        homePage.ScrollToBtn("scrollBy(0,400)");}
}