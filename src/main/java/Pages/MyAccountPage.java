package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends PageBase {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(linkText = "Change password")
	WebElement ChangePasswordlink;
	
	@FindBy(id = "OldPassword")
	WebElement oldpasswordtxt;
	
	@FindBy(id = "NewPassword")
	WebElement newpasswordtxt;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmpasswordtxt;
	
	@FindBy(css = "input.button-1.change-password-button")
	WebElement changepasswordbtn;
	
	@FindBy(css = "div.result")
    public WebElement successmessagechangepasswordtxt;
	
	public void OpenChangePasswordPage() {
		Clickbutton(ChangePasswordlink);
	}
	
	public void ChangePassword(String oldpassword, String newpassword) {
		SetTextElementText(oldpasswordtxt, oldpassword);
		SetTextElementText(newpasswordtxt, newpassword);
		SetTextElementText(confirmpasswordtxt, newpassword);
		Clickbutton(changepasswordbtn);
	}
}
