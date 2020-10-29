package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ComparePage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;

public class AddToCompareTest extends TestBase{

	HomePage homepageobject;
	ProductDetailsPage productdetailsobject;
	SearchProductPage searchproductobject;
	ComparePage comparepageobject;
	String firstProductName = "Apple MacBook Pro 13-inch";
	String secondProductName = "Asus N551JK-XO076H Laptop";
	
	@Test(priority = 1)
	public void UserCanCompareProducts() {
		homepageobject = new HomePage(driver);
		searchproductobject = new SearchProductPage(driver);
		productdetailsobject = new ProductDetailsPage(driver);
		comparepageobject = new ComparePage(driver);
		//Add first product to compare page
		searchproductobject.ProductSearchUsingAutoSuggest("MacB");
		Assert.assertTrue(productdetailsobject.productNamebreadCrumb.getText().contains(firstProductName));
		productdetailsobject.AddProductToCompare();
		//Add second product to compare page
		searchproductobject.ProductSearchUsingAutoSuggest("Asus");
		Assert.assertTrue(productdetailsobject.productNamebreadCrumb.getText().contains(secondProductName));
		productdetailsobject.AddProductToCompare();
		//Open compare page
		productdetailsobject.OpenProductComparisonPage();
		
		comparepageobject.CompareProducts();
		
	}
	
	@Test(priority = 2)
	public void UserCanClearComparisonList() {
		comparepageobject.ClearCompareTable();
		Assert.assertTrue(comparepageobject.successmessage.getText().contains("You have no items to compare."));
	}
	
	@Test (priority = 3)
	public void UserCanLogOut() {
		homepageobject = new HomePage(driver);
		homepageobject.UserLogOut();
	}
	
}
