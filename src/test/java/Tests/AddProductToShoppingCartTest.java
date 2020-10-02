package Tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;
import Pages.ShoppingCartPage;

public class AddProductToShoppingCartTest extends TestBase {

	HomePage homepageobject;
	SearchProductPage searchproductobject;
	ProductDetailsPage productdetailsobject;
	ShoppingCartPage shoppingcartobject;
	String productname = "MacB";
	String Quantity = "4";
	String Pricebeforeupdate;
	
	
	@Test(priority = 1)
	public void UserCanAddProductToCart() {
		searchproductobject = new SearchProductPage(driver);
		searchproductobject.ProductSearchUsingAutoSuggest(productname);
		
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.AddProductToCart();
		productdetailsobject.OpenShoppingCartPage();
		//Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}
	
	@Test(priority = 2)
	public void UserCanUpdateProductQuantityInCart() {
		shoppingcartobject = new ShoppingCartPage(driver);
		shoppingcartobject.UpdateProductQuantityInCart(Quantity);
		
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromCart() {
		shoppingcartobject = new ShoppingCartPage(driver);
		shoppingcartobject.RemoveProductFromCart();
		Assert.assertTrue(shoppingcartobject.sucessmessage.getText().contains("Your Shopping Cart is empty!"));
	}
	
	@Test (priority = 4)
	public void UserCanLogOut() {
		homepageobject = new HomePage(driver);
		homepageobject.UserLogOut();
	}
}
