package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "Email")
	WebElement emailtxt;
	
	@FindBy(id = "Password")
	WebElement passwordtxt;
	
	@FindBy(css ="input.button-1.login-button")
	WebElement loginbtn;
	
	public void UserLogin(String Email , String Password) {
		SetTextElementText(emailtxt, Email);
		SetTextElementText(passwordtxt, Password);
		Clickbutton(loginbtn);
	}
	
	
	
}
