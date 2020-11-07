package Tests;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.opencsv.exceptions.CsvValidationException;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestWithJavaFaker extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;
	Faker fakeData = new Faker();
	String FirstName = fakeData.name().firstName();
	String LastName = fakeData.name().lastName() ;
	String Email = fakeData.internet().emailAddress();
	String Password = fakeData.number().digits(8).toString();

	@Test(priority =1 , alwaysRun = true )
	public void UserRegisterSuccessfully() throws CsvValidationException, IOException {
			
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
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
		
		
	}
	
	


}
