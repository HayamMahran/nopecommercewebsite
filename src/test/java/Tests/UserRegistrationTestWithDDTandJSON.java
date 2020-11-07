package Tests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.JsonDataReader;

public class UserRegistrationTestWithDDTandJSON extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;

	

	@Test(priority =1 , alwaysRun = true )
	public void UserRegisterSuccessfully() throws ParseException, IOException {
		
	    JsonDataReader jsonReader = new JsonDataReader();
	    jsonReader.JsonReader();
	    homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(jsonReader.firstname, jsonReader.lastname, jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
		registerobject.userLogout();
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(jsonReader.email, jsonReader.password);
		Assert.assertTrue(registerobject.logoutlink.isDisplayed());
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
		
		
	}
	
	


}
