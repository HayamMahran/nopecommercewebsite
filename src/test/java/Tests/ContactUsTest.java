package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.ContactUsPage;
import Pages.HomePage;

public class ContactUsTest extends TestBase{

	HomePage homepageobject;
	ContactUsPage contactusobject;
	String FullName = "Hayam Mahran";
	String Email = "test@test.com";
	String Enquiry = "Help";
	
	@Test
	public void SubmitEnquiryfromContactUs() {
		homepageobject = new HomePage(driver);
		homepageobject.OpenContactUsPage();
		contactusobject = new ContactUsPage(driver);
		contactusobject.ContactUs(FullName, Email, Enquiry);
		Assert.assertTrue(contactusobject.successmessage.getText().contains("successfully sent"));
		
	}
	
}
