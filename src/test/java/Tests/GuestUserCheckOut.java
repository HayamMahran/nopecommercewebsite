package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;
import Pages.ShoppingCartPage;

public class GuestUserCheckOut extends TestBase {
	
	String PartialProductName = "MacB";
	String FirstName = "Hayam";
	String LastName = "Mahran";
	String Email = "testt32@test.com";
	String Country = "Egypt";
	String City = "cairo";
	String Address= "Cairo,Egypt";
	String ZipCode = "1234";
	String PhoneNumber = "01222222334";
	HomePage homepageobject;
	SearchProductPage searchobject;
	ProductDetailsPage productdetailsobject;
	ShoppingCartPage shoppingcartobject;
	CheckOutPage checkoutobject;
	OrderDetailsPage orderdetailsobject;

	@Test(priority = 1)
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
	
	@Test(priority = 2)
	public void UserCanAddProductToCart() {
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.AddProductToCart();
		productdetailsobject.OpenShoppingCartPage();
		//Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}
	
	@Test(priority = 3)
	public void GusetUserCanCheckOut() throws Exception {
		shoppingcartobject = new ShoppingCartPage(driver);
		shoppingcartobject.OpenCheckOutPage();
		shoppingcartobject.OpenCheckoutAsGuest();
		//1,2- billing address and shipping address
		checkoutobject = new CheckOutPage(driver);
		checkoutobject.GuestUserAddbillandshippingaddress(FirstName, LastName, Email, Country, City, Address, ZipCode, PhoneNumber);
		Thread.sleep(500);
		//3- shipping method
		checkoutobject.ChooseShippingMethod();
		Thread.sleep(500);
		//4- payment method
		checkoutobject.ChoosePaymentMethod();
		Thread.sleep(1000);
		//5- payment info
		checkoutobject.ContinueToConfirmTheOrder();
		Thread.sleep(1000);
		//6- confirm order
		checkoutobject.ConfirmTheOrder();
		Thread.sleep(1000);
		Assert.assertTrue(checkoutobject.successmessage.getText().contains("has been successfully"));
		Thread.sleep(500);
	}

	@Test(priority = 4)
	public void UserCanDownloadOrderInvoicePDF() throws Exception {
		checkoutobject = new CheckOutPage(driver);
		Thread.sleep(1000);
		checkoutobject.OpenOrderDetailsPage();
		orderdetailsobject = new OrderDetailsPage(driver);
		orderdetailsobject.DownloadOrderInvoicePDF();
	}
	
	@Test (priority = 5)
	public void UserCanLogOut() {
		homepageobject = new HomePage(driver);
		homepageobject.UserLogOut();
	}
	
}
