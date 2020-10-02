package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;

public class AddProductToWishlistTest extends TestBase{

	String PartialProductName = "MacB";
	HomePage homepageobject;
	SearchProductPage searchobject;
	ProductDetailsPage productdetailsobject;

	@Test(priority =1)
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
	}
	
	@Test (priority = 3)
	public void UserCanLogOut() {
		homepageobject = new HomePage(driver);
		homepageobject.UserLogOut();
	}
}
