package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FollowUsPage;

public class FollowUsTest extends BaseTest {
    FollowUsPage followUsPage;
    @Test ()
    public void TestFacebookPage(){
        followUsPage = new FollowUsPage(driver);
        followUsPage.GetWindowHandles("Facebook");
        Assert.assertTrue(driver.getCurrentUrl().contains("facebook"));}
    @Test ()
    public void TestTwitterPage(){
        followUsPage = new FollowUsPage(driver);
        followUsPage.GetWindowHandles("Twitter");
        Assert.assertTrue(driver.getCurrentUrl().contains("twitter"));}
    @Test ()
    public void TestYouTubePage(){
        followUsPage = new FollowUsPage(driver);
        followUsPage.GetWindowHandles("YouTube");
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));}
}