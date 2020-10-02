package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase{

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "a.button-2.print-order-button")
	WebElement printorderbtn;
	
	@FindBy(css = "a.button-2.pdf-invoice-button")
	WebElement pdfinvoicebtn;
	
	public void OpenPrintOrderInvoice() {
		Clickbutton(printorderbtn);
	}
	
	public void DownloadOrderInvoicePDF() {
		Clickbutton(pdfinvoicebtn);
	}

}
