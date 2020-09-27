package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		jse = (JavascriptExecutor)driver;
		action = new Actions(driver);
	}

	@FindBy(linkText = "Register")
	WebElement RigesterLink;
	
	@FindBy(css = "a.ico-login")
	WebElement Loginlink;
	
	@FindBy(linkText = "Contact us")
	WebElement ContactUsLink;
	
	@FindBy(id = "customerCurrency")
	WebElement currencydropdown;
	
	@FindBy(css = "span.price.actual-price")
	public WebElement pricelabel;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computersmenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebooksmenu;
	
	public void OpenRegistrationPage() {
		Clickbutton(RigesterLink);
	}
	
	public void OpenLoginPage() {
		Clickbutton(Loginlink);
	}
	
	public void OpenContactUsPage() {
		scrollToButtom();
		Clickbutton(ContactUsLink);	
	}
	
	public void ChangeCurrency() {
		select = new Select(currencydropdown);
		select.selectByIndex(1);
	}
	
	public void SelectNotebooksMenu() {
		action.moveToElement(computersmenu).
		moveToElement(notebooksmenu).click().build().perform();
	}
}
