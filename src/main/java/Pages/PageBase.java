package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PageBase {

	protected WebDriver driver;
	public JavascriptExecutor jse;
	public Select select;
	public Actions action;

	//Create Constructor
	public PageBase(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	protected static void Clickbutton(WebElement button) {
		button.click();
	}
	
	protected static void SetTextElementText(WebElement TextElement , String value) {
		TextElement.sendKeys(value);
	}
	
	public void scrollToButtom() {
		jse.executeScript("scrollBy(0,2500)");
		
	}
	
	
}
