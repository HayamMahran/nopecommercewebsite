package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.ProductReviewPage;
import Pages.SearchProductPage;
import Pages.UserRegistrationPage;

public class AddProductReviewTest extends TestBase{

	HomePage homepageobject;
	UserRegistrationPage registerobject;
	ProductDetailsPage productdetailsobject;
	SearchProductPage searchproductobject;
	ProductReviewPage productreviewobject;
	String FirstName = "Hayam";
	String LastName = "Mahran";
	String Email = "test1@test.com";
	String Password = "12345678";
	String PartialProductName = "MacB";
	String ReviewTitle = "Product Review Title";
	String ReviewMessage = "This is a awsome product"; 
	
	@Test(priority =1 , alwaysRun = true)
	public void UserRegisterSuccessfully() {
		homepageobject = new HomePage(driver);
		homepageobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
	}
	
	@Test(priority = 2)
	public void UserCanSearchUsingAutoSuggest() {
		try {
			searchproductobject = new SearchProductPage(driver);
			searchproductobject.ProductSearchUsingAutoSuggest(PartialProductName);
			productdetailsobject = new ProductDetailsPage(driver);
			Assert.assertEquals(productdetailsobject.productNamebreadCrumb.getText(), "Apple MacBook Pro 13-inch");

		} catch (Exception e) {
			System.out.println("Erro occurred"+ e.getMessage());
		}
	}

	@Test(priority = 3)
	public void UserCanAddProductReview() {
		try {
			productdetailsobject = new ProductDetailsPage(driver);
			productdetailsobject.OpenAddReviewPage();
			productreviewobject = new ProductReviewPage(driver);
			productreviewobject.AddProductReview(ReviewTitle, ReviewMessage);
			Assert.assertTrue(productreviewobject.successmessage.getText().contains("successfully added"));

		} catch (Exception e) {
			System.out.println("Erro occurred"+ e.getMessage());
		}
	}
		
		@Test (priority = 4)
		public void UserCanLogOut() {
			homepageobject = new HomePage(driver);
			homepageobject.UserLogOut();
		}

	}