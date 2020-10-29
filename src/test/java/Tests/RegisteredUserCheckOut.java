package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.CheckOutPage;
import Pages.HomePage;
import Pages.OrderDetailsPage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;
import Pages.ShoppingCartPage;
import Pages.UserRegistrationPage;

public class RegisteredUserCheckOut extends TestBase{

	HomePage homepageobject;
	UserRegistrationPage userregistrationobject;
	SearchProductPage searchproductobject;
	ProductDetailsPage productdetailsobject;
	ShoppingCartPage shoppingcartobject;
	CheckOutPage checkoutobject;
	OrderDetailsPage orderdetailsobject;
	String FirstName = "Hayam";
	String LastName = "Mahran";
	String Email = "test34@test.com";
	String Password = "12111145678";
	String ProductName = "MacB";
	String Country = "Egypt";
	String City = "cairo";
	String Address= "Cairo,Egypt";
	String ZipCode = "1234";
	String PhoneNumber = "01222222334";
	
	
	@Test(priority =1 , alwaysRun = true)
	public void UserRegisterSuccessfully() {
		homepageobject = new HomePage(driver);
		homepageobject.OpenRegistrationPage();
		userregistrationobject = new UserRegistrationPage(driver);
		userregistrationobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(userregistrationobject.successnotification.getText().contains("Your registration"));
	}
	
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		try {
			searchproductobject = new SearchProductPage(driver);
			searchproductobject.ProductSearchUsingAutoSuggest(ProductName);
			productdetailsobject = new ProductDetailsPage(driver);
			Assert.assertEquals(productdetailsobject.productNamebreadCrumb.getText(), "Apple MacBook Pro 13-inch");
			
		} catch (Exception e) {
			System.out.println("Erro occurred"+ e.getMessage());
		}
	}
	
	@Test(priority = 3)
	public void UserCanAddProductToCart() {
		searchproductobject = new SearchProductPage(driver);
		searchproductobject.ProductSearchUsingAutoSuggest(ProductName);
		
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.AddProductToCart();
		productdetailsobject.OpenShoppingCartPage();
		//Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
	}
	
	@Test(priority = 4)
	public void RegisteredUserCanCheckout() throws Exception {
		shoppingcartobject = new ShoppingCartPage(driver);
		shoppingcartobject.OpenCheckOutPage();
		Thread.sleep(1000);
		//1,2- billing address and shipping address
		checkoutobject = new CheckOutPage(driver);
		checkoutobject.Addbillandshippingaddress(Country, City, Address, ZipCode, PhoneNumber);
		Thread.sleep(500);
		//3- shipping method
		checkoutobject.ChooseShippingMethod();
		Thread.sleep(500);
		//4- payment method
		checkoutobject.ChoosePaymentMethod();
		Thread.sleep(500);
		//5- payment info
		checkoutobject.ContinueToConfirmTheOrder();
		Thread.sleep(1000);
		//6- confirm order
		checkoutobject.ConfirmTheOrder();
		Thread.sleep(1000);
		Assert.assertTrue(checkoutobject.successmessage.getText().contains("has been successfully"));
	}
	
	@Test(priority = 5)
	public void UserCanDownloadOrderInvoicePDF() throws Exception {
		checkoutobject = new CheckOutPage(driver);
		Thread.sleep(1000);
		checkoutobject.OpenOrderDetailsPage();
		orderdetailsobject = new OrderDetailsPage(driver);
		orderdetailsobject.DownloadOrderInvoicePDF();
	}
	
	@Test (priority = 6)
	public void UserCanLogOut() {
		homepageobject = new HomePage(driver);
		homepageobject.UserLogOut();
	}
	
}
