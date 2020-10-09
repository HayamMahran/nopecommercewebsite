package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MyAccountPage;
import Pages.UserRegistrationPage;

public class MyAccountTest extends TestBase {
	HomePage homeobject;
	UserRegistrationPage registerobject;
	MyAccountPage myaccountobject;
	LoginPage loginobject;
	String oldpassword = "12345678";
	String newpassword = "123456789" ;
	String firstname = "Hayam" ;
	String lastname = "Mahran" ;
	String email = "testtestt@test.com" ;

	@Test(priority =1 , alwaysRun = true)
	public void UserRegisterSuccessfully() {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(firstname, lastname, email, oldpassword);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
	}
	
	@Test(dependsOnMethods = {"UserRegisterSuccessfully"} )
	public void RegisteredUserCanChangePassword() {
		myaccountobject = new MyAccountPage(driver);
		registerobject.openMyAccountPage();
		myaccountobject.OpenChangePasswordPage();
		myaccountobject.ChangePassword(oldpassword, newpassword);
		Assert.assertTrue(myaccountobject.successmessagechangepasswordtxt.getText().contains("Password was changed"));
	}
	
	@Test(dependsOnMethods = {"RegisteredUserCanChangePassword"} )
	public void RegisteredUserCanLogOut() {
		registerobject.userLogout();

	}

	@Test(dependsOnMethods = {"RegisteredUserCanLogOut"} )
	public void RegisteredUserCanLogin() {
		loginobject = new LoginPage(driver);
		homeobject.OpenLoginPage();
		loginobject.UserLogin(email, newpassword);
		//Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}

	@Test (priority = 5)
	public void UserCanLogOut() {
		homeobject = new HomePage(driver);
		homeobject.UserLogOut();
	}
}
