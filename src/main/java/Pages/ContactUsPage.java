package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "FullName")
	WebElement fullnametxt;
	
	@FindBy(id = "Email")
	WebElement emailtxt;
	
	@FindBy(id = "Enquiry")
	WebElement enquirytxt;
	
	@FindBy(css = "input.button-1.contact-us-button")
	WebElement submitbtn;
	
	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	public void ContactUs(String FullName, String Email, String Enquiry) {
		SetTextElementText(fullnametxt, FullName);
		SetTextElementText(emailtxt, Email);
		SetTextElementText(enquirytxt, Enquiry);
		Clickbutton(submitbtn);
	}
	
}
