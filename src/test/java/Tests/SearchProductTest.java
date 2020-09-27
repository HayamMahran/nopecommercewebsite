package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ProductDetailsPage;
import Pages.SearchProductPage;

public class SearchProductTest extends TestBase{

	String ProductName = "Apple MacBook Pro 13-inch";
	SearchProductPage searchobject;
	ProductDetailsPage productdetailsobject;
	
	@Test
	public void UserCanSearchForProducts() {
		searchobject = new SearchProductPage(driver);
		searchobject.ProductSearch(ProductName);
		searchobject.OpenProductDetailsPage();
		productdetailsobject = new ProductDetailsPage(driver);
		Assert.assertTrue(productdetailsobject.productNamebreadCrumb.getText().equalsIgnoreCase(ProductName));
	}
}
