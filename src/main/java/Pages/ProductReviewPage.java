package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{

	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "AddProductReview_Title")
	WebElement reviewtitletxt;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewmessagetxt;
	
	@FindBy(id = "addproductrating_3")
	WebElement ratingradiobtn;
	
	@FindBy(css = "input.button-1.write-product-review-button")
	WebElement submitbtn;
	
	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	public void AddProductReview(String ReviewTitle, String ReviewMessage) {
		SetTextElementText(reviewtitletxt, ReviewTitle);
		SetTextElementText(reviewmessagetxt, ReviewMessage);
		Clickbutton(ratingradiobtn);
		Clickbutton(submitbtn);
	}
	
}
