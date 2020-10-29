package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.LoadProperties;

public class UserRegistrationTestWithDDTandFileProperties extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;
	String FirstName = LoadProperties.userdata.getProperty("firstname");
	String LastName = LoadProperties.userdata.getProperty("lastname");
	String Email = LoadProperties.userdata.getProperty("email");
	String Password = LoadProperties.userdata.getProperty("password");
	
	

	@Test(priority =1)
	public void UserRegisterSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
		registerobject.userLogout();	
	}
	
	@Test(priority =2)
	public void UserCanLoginSuccessfully() {
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(Email, Password);
		Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	
	
	@Test(priority =3)
	public void UserCanLogOutSuccessfully() {
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
	}
	

}
