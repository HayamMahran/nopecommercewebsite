package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(name = "removefromcart")
	WebElement removebtn;
	
	@FindBy(css = "input.qty-input")
	WebElement quantitytxt;
	
	@FindBy(css = "span.product-subtotal")
	public WebElement pricelbl;
	
	@FindBy(css = "input.button-2.update-cart-button")
	WebElement updatebtn;
	
	@FindBy(css = "div.no-data")
	public WebElement sucessmessage;
	
	@FindBy(id = "termsofservice")
	WebElement termscheckbox;
	
	@FindBy(id = "checkout")
	WebElement checkoutbtn;
	
	@FindBy(css = "input.button-1.checkout-as-guest-button")
	WebElement checkoutasguestbtn;
	
	public void RemoveProductFromCart() {
		Clickbutton(removebtn);
		Clickbutton(updatebtn);
	}
	
	public void UpdateProductQuantityInCart(String Quantity) {
		//clear textbox
		ClearText(quantitytxt);
		SetTextElementText(quantitytxt, Quantity);
		Clickbutton(updatebtn);
	}
	
	public void OpenCheckOutPage() {
		Clickbutton(termscheckbox);
		Clickbutton(checkoutbtn);
	}

	public void OpenCheckoutAsGuest() {
		Clickbutton(checkoutasguestbtn);
	}
}
