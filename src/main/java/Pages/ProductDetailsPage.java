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
	
	@FindBy(css = "input.button-2.add-to-compare-list-button")
	WebElement addtocomparebtn;
	
	@FindBy(linkText = "product comparison")
	WebElement comparisonbtn;
	
	@FindBy(id = "add-to-cart-button-4")
	WebElement addtocartbtn;
	
	@FindBy(css = "a.ico-cart")
	WebElement cartbtn;
	
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
	
	public void AddProductToCompare() {
		Clickbutton(addtocomparebtn);
	}

	public void OpenProductComparisonPage() {
		Clickbutton(comparisonbtn);
	}
	
	public void AddProductToCart() {
		Clickbutton(addtocartbtn);
	}
	
	public void OpenShoppingCartPage() {
		Clickbutton(cartbtn);
	}
}
