package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase{

	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendemailtxt;
	
	@FindBy(id = "PersonalMessage")
	WebElement messagetxt;
	
	@FindBy(css = "div.result")
	public WebElement successmessagetxt;
	
	@FindBy(css = "input.button-1.send-email-a-friend-button")
	WebElement sendbtn;
	
	public void EmailAfriend(String FriendEmail, String MessageToFriend) {
		SetTextElementText(friendemailtxt, FriendEmail);
		SetTextElementText(messagetxt, MessageToFriend);
		Clickbutton(sendbtn);
	}
	
	

}
