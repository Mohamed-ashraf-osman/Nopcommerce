package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends BaseTest {
    SearchPage searchPage;
    @Test
    public void SearchForProduct() {
        String productSearch = "mac";
        homePage.SearchProduct(productSearch);
        searchPage= homePage.NavigateToSearchPage();
        homePage.ScrollToBtn("scrollBy(0,700)");
        Assert.assertEquals(searchPage.CheckProductName(), "Apple MacBook Pro 13-inch");
        Assert.assertEquals(searchPage.CheckProductNameInSearchkeyword(), productSearch , "Product Name don't match");
    }
}