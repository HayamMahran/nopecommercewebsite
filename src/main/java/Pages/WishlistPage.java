package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistPage extends PageBase{

	public WishlistPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement removefromwishlistcheckbox;
	
	@FindBy(css = "input.button-2.update-wishlist-button")
	WebElement updatewishlistbtn;
	
	@FindBy(css ="div.no-data")
	public WebElement successmessage;
	
	public void RemoveProductFromWishlist() {
		Clickbutton(removefromwishlistcheckbox);
		Clickbutton(updatewishlistbtn);
	}

}
