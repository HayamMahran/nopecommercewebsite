package Tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;
import data.ExcelReader;


public class UserRegistrationTestWithDDTandExcel extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;

	@DataProvider(name = "ExcelData")
	public Object [][] userRegisterData() throws IOException {
		//get data from Excel Reader class
		
		ExcelReader er = new ExcelReader();
			return er.getExcelData();
	}
	
	@Test(priority =1, dataProvider = "ExcelData")
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
		registerobject.userLogout();
	}
}
