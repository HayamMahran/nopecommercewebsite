package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;
import Pages.WishlistPage;

public class RemoveFromWishlistTest extends TestBase{
	String PartialProductName = "MacB";
	SearchProductPage searchobject;
	ProductDetailsPage productdetailsobject;
	WishlistPage wishlistobject;
	
	@Test
	public void UserCanSearchUsingAutoSuggest() {
		try {
			searchobject = new SearchProductPage(driver);
			searchobject.ProductSearchUsingAutoSuggest(PartialProductName);
			productdetailsobject = new ProductDetailsPage(driver);
			Assert.assertEquals(productdetailsobject.productNamebreadCrumb.getText(), "Apple MacBook Pro 13-inch");
			
		} catch (Exception e) {
			System.out.println("Erro occurred"+ e.getMessage());
		}
	}
	
	@Test(priority =2)
	public void UserCanAddProductToWishlist() {
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.AddToWishlist();
		Assert.assertTrue(productdetailsobject.successmessage.getText().contains("has been added"));
	}
	
	@Test(priority = 3)
	public void UserCanRemoveProductFromWishlist() {
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.OpenWishListPage();
		wishlistobject = new WishlistPage(driver);
		wishlistobject.RemoveProductFromWishlist();
		Assert.assertTrue(wishlistobject.successmessage.getText().contains("The wishlist is empty!"));
	}

}
