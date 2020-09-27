package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchProductPage extends PageBase{

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchtextbox;
	
	@FindBy(css = "input.button-1.search-box-button")
	WebElement searchbtn;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productlistautocomplete;
	
	@FindBy(linkText = "Apple MacBook Pro 13-inch")
	WebElement ProductTitlelink;
	
	public void ProductSearch(String ProductName) {
		SetTextElementText(searchtextbox, ProductName);
		Clickbutton(searchbtn);
	}

	public void OpenProductDetailsPage() {
		Clickbutton(ProductTitlelink);
	}
	
	public void ProductSearchUsingAutoSuggest(String searchtxt) {
		SetTextElementText(searchtextbox, searchtxt);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productlistautocomplete.get(0).click();
	}
}
