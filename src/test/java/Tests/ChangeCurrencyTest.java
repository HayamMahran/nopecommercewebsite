package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class ChangeCurrencyTest extends TestBase{
	
	HomePage homepageobject;
	
	@Test
	public void UserCanChangeCurrency() {
		try {
			homepageobject = new HomePage(driver);
			homepageobject.ChangeCurrency();
			Assert.assertTrue(homepageobject.pricelabel.getText().contains("€"));
		} catch (Exception e) {
			System.out.println("Error Ocurred "+ e.getMessage());
		}
		
		
		
	}

}
