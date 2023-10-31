package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest {
    ProductPage productPage;
    ShoppingCartPage shoppingCartPage;
    @Test
    public void ShoppingCartPageTest() {
        productPage = homePage
                .SearchProduct("mac")
                .NavigateToSearchPage()
                .NavigateToProductLink()
                .ClickAddToCartBtn();
        Assert.assertTrue(productPage.successMsgAddProduct().contains("added"), "Product not added to Cart");
        productPage.CloseAddProductMsg();

        shoppingCartPage = productPage.NavigateToShoppingCartPage();
        Assert.assertTrue(shoppingCartPage.getProductName().contains("MacBook") ,"Incorrect Product name" );
        Assert.assertTrue(shoppingCartPage.productPrice().contains("$1,800.00") ,"Incorrect Product price" );
    }
}