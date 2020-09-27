package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "strong.current-item")
	public WebElement productNamebreadCrumb;
	
	@FindBy(css = "input.button-2.email-a-friend-button")
	WebElement emailfriendbtn;
	
	@FindBy(linkText = "Add your review")
	WebElement addreviewlink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	WebElement addtowishlistlink;
	
	@FindBy(css = "p.content")
	public WebElement successmessage;
	
	@FindBy(linkText = "wishlist")
	WebElement wishlistbutn;
	
	public void OpenEmailFriendPage() {
		Clickbutton(emailfriendbtn);
	}
	
	public void OpenAddReviewPage() {
		Clickbutton(addreviewlink);
	}
	
	public void AddToWishlist() {
		Clickbutton(addtowishlistlink);
	}
	
	public void OpenWishListPage() {
		Clickbutton(wishlistbutn);
	}

}
