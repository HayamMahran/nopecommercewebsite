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
	String FirstName;
	String LastName ;
	String Email ;
	String Password ;
	
	
	@DataProvider(name = "testData")
	public static Object[][] UserData(){
		
		return new Object[][]{
				{"Hayam","Mahran","testn1@gmail.com","12345678"},
				{"Ahmed","Ali","testtes1t@test.com","09876543"}
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
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
	}
	
	


}
