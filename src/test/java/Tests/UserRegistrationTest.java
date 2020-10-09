package Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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
	
	
	@DataProvider(name = "testData")
	public static Object[][] UserData(){
		
		return new Object[][]{
				{"Hayam","Mahran","testn@gmail.com","12345678"},
				{"Ahmed","Ali","testtest@test.com","09876543"}
				};
	}

	@Test(priority =1 , alwaysRun = true, dataProvider = "testData" )
	public void UserRegisterSuccessfully(String FirstName, String LastName, String Email, String Password) {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName, LastName, Email, Password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
		registerobject.userLogout();
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(Email, Password);
		Assert.assertTrue(registerobject.logoutlink.isDisplayed());
	}
	
	
	@Test(priority =2)
	public void UserCanLogOutSuccessfully() {
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
	}
	

}
