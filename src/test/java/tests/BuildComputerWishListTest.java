package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BuildComputerPage;
import pages.BuildComputerWishListPage;

public class BuildComputerWishListTest extends BaseTest {
    BuildComputerPage buildComputerPage;
    BuildComputerWishListPage wishListPage;
    @Test
    public void TestBuildYourOwnComputer() {
        buildComputerPage = homePage.NavigateToBuildComputerPage();
        buildComputerPage.fillInfoAndAddForProduct()
                .clickAddToWishBtn();
        Assert.assertTrue(buildComputerPage.successMessageText().contains("added"), "Item wasn't successfully Added");
        buildComputerPage.closeSuccessMsg();

        wishListPage = buildComputerPage.NavigateToWishListPage();
        Assert.assertTrue(wishListPage.AssertWishListPage(), "Assertion False ");
    }
}