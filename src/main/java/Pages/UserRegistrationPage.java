package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPage extends PageBase{

	public UserRegistrationPage(WebDriver driver) {
		super(driver);	
	}

	@FindBy(id = "gender-female")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement FNtxtbox;
	
	@FindBy(id = "LastName")
	WebElement LNtxtbox;
	
	//@FindBy(name = "DateOfBirthDay")
	//WebElement Daydropdown ;
	//Select dayselection = new Select(Daydropdown);
	
	//@FindBy(name = "DateOfBirthMonth")
	//WebElement monthdropdown;
	//Select monthselection = new Select(monthdropdown);
	
	//@FindBy(name = "DateOfBirthYear")
	//WebElement yeardropdown;
	//Select yearselection = new Select(yeardropdown);
	
	@FindBy(id = "Email")
	WebElement emailtxt;
	
	//@FindBy(id = "Newsletter")
	//WebElement newslettercheckbox;
	
	@FindBy(id = "Password")
	WebElement Passwordtxt;
	
	@FindBy(id = "ConfirmPassword")
	WebElement ConfirmPasswordtxt;
	
	@FindBy(id = "register-button")
	WebElement registerbtn;
	
	@FindBy(css = "div.result")
	public WebElement successnotification;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logoutlink;
	
	@FindBy(linkText = "My account")
	WebElement myaccountlink;
	
	public void UserRegistration(String FirstName, String LastName, String Email, String Password) {
		
		Clickbutton(gender);
		SetTextElementText(FNtxtbox, FirstName);
		SetTextElementText(LNtxtbox, LastName);
		//dayselection.selectByValue(Day);
		//monthselection.selectByValue(Month);
		//yearselection.selectByValue(Year);
		SetTextElementText(emailtxt, Email);
		//newslettercheckbox.click();
		SetTextElementText(Passwordtxt, Password);
		SetTextElementText(ConfirmPasswordtxt, Password);
		Clickbutton(registerbtn);
	}
	
	public void userLogout() {
		Clickbutton(logoutlink);
	}
	
   public void openMyAccountPage() {
	   Clickbutton(myaccountlink);
   }
}
