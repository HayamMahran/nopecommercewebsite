package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.EmailFriendPage;
import Pages.HomePage;
import Pages.ProductDetailsPage;
import Pages.SearchProductPage;
import Pages.UserRegistrationPage;

public class EmailFriendTest extends TestBase{
	
	HomePage homeobject;
	UserRegistrationPage registerobject;
	SearchProductPage searchobject;
	ProductDetailsPage productdetailsobject;
	EmailFriendPage emailfriendobject;
	String FirstName = "Hayam";
	String LastName = "Mahran";
	String Email = "test4@test.com";
	String Password = "12345678";
	String PartialProductName = "MacB";
	String FriendEmail = "ahmed@test.com";
	String MessageToFriend = "This Product is awsome, I think you may want to buy it";
	
	@Test(priority =1 , alwaysRun = true)
	public void UserRegisterSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
	}
	
	@Test(priority = 2)
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
	
	@Test(priority = 3)
	public void UserCanSendEmailToFriend() {
		productdetailsobject = new ProductDetailsPage(driver);
		productdetailsobject.OpenEmailFriendPage();
		emailfriendobject = new EmailFriendPage(driver);
		emailfriendobject.EmailAfriend(FriendEmail, MessageToFriend);
		Assert.assertTrue(emailfriendobject.successmessagetxt.getText().contains("has been sent"));
	}

}
