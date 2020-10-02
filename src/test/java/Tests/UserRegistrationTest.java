package Tests;



import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTest extends TestBase{

	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;
	String FirstName = "Hayam";
	String LastName = "Mahran";
	String Email = "test@test.com";
	String Password = "12345678";

	@Test(priority =1 , alwaysRun = true)
	public void UserRegisterSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
	}

	@Test(dependsOnMethods = {"UserRegisterSuccessfully"} )
	public void RegisteredUserCanLogOut() {
		registerobject.userLogout();

	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"} )
	public void RegisteredUserCanLogin() {
		loginobject = new LoginPage(driver);
		homeobject.OpenLoginPage();
		loginobject.UserLogin("testtest3@test.com", "a123456783");
		//Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	
	@Test (priority = 4)
	public void UserCanLogOut() {
		homeobject = new HomePage(driver);
		homeobject.UserLogOut();
	}
}
