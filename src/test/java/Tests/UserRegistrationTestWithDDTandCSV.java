package Tests;
import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.UserRegistrationPage;

public class UserRegistrationTestWithDDTandCSV extends TestBase{
	HomePage homeobject;
	UserRegistrationPage registerobject;
	LoginPage loginobject;
	CSVReader reader;
	

	@Test(priority =1 , alwaysRun = true )
	public void UserRegisterSuccessfully() throws CsvValidationException, IOException {
		
		//get path of CSV
		String CSV_file = System.getProperty("user.dir")+"/src/test/java/data/userdatacsv.csv";
		reader = new CSVReader(new FileReader(CSV_file));
		String [] csvCell;
		
		while((csvCell= reader.readNext())!= null) 
		{
			String FirstName1 = csvCell[0];
			String LastName1 = csvCell[1];
			String Email1 = csvCell[2];
			String Password1 = csvCell[3] ;
			
	    homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
		registerobject = new UserRegistrationPage(driver);
		registerobject.UserRegistration(FirstName1, LastName1, Email1, Password1);
		Assert.assertTrue(registerobject.successnotification.getText().contains("Your registration"));
		registerobject.userLogout();
		homeobject.OpenLoginPage();
		loginobject = new LoginPage(driver);
		loginobject.UserLogin(Email1, Password1);
		Assert.assertTrue(registerobject.logoutlink.isDisplayed());
		registerobject = new UserRegistrationPage(driver);
		registerobject.userLogout();
		}
		
	}
	
	


}
