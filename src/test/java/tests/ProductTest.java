package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;

public class ProductTest extends BaseTest {
    ProductPage productPage;
    @Test
    public void testProductPage(){
        productPage = homePage
                .SearchProduct("mac")
                .NavigateToSearchPage()
                .NavigateToProductLink();
        productPage.ClickAddToCartBtn();
        Assert.assertTrue(productPage.successMsgAddProduct().contains("added"), "product wasn't added successfully");
        productPage.CloseAddProductMsg();}
}