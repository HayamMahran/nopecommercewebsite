package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends PageBase{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "BillingNewAddress_FirstName")
	WebElement firstnametxt;
	
	@FindBy(id ="BillingNewAddress_LastName")
	WebElement lastnametxt;
	
	@FindBy(id = "BillingNewAddress_Email")
	WebElement emailtxt;
	
	@FindBy(id = "BillingNewAddress_CountryId")
	WebElement countrydropdown;
	
	@FindBy(id = "BillingNewAddress_City")
	WebElement citytxt;
	
	@FindBy(id = "BillingNewAddress_Address1")
	WebElement firstaddresstxt;
	
	@FindBy(id = "BillingNewAddress_ZipPostalCode")
	WebElement zipcodetxt;
	
	@FindBy(id = "BillingNewAddress_PhoneNumber")
	WebElement phonenumbertxt;
	
	@FindBy(css = "input.button-1.new-address-next-step-button")
	WebElement continuebtn;
	
	@FindBy(id = "shippingoption_1")
	WebElement shippingmethodradiobtn;
	
	@FindBy(css = "input.button-1.shipping-method-next-step-button")
	WebElement continuetopaymentmethodbtn;
	
	@FindBy(id = "paymentmethod_0")
	WebElement paymentmethodradiobtn;
	
	@FindBy(css = "input.button-1.payment-method-next-step-button")
	WebElement continuetopaymentinfobtn;
	
	@FindBy(css = "input.button-1.payment-info-next-step-button")
	WebElement continuetoconfirmbtn;
	
	@FindBy(css = "input.button-1.confirm-order-next-step-button")
	WebElement confirmbtn;
	
	@FindBy(css = "div.title")
	public WebElement successmessage;
	
	@FindBy(linkText = "Click here for order details.")
	WebElement orderdetailslink;
	
	@FindBy(css = "input.button-1.order-completed-continue-button")
	WebElement completecontinuebtn;
	
	//@FindBy(css = "input.button-1.order-completed-continue-button")
	//WebElement ordercompletedcontinuebtn;
	
	public void Addbillandshippingaddress(String Country, String City, String Address, String ZipCode, String PhoneNumber) {
		select = new Select(countrydropdown);
		select.selectByVisibleText(Country);
		SetTextElementText(citytxt, City);
		SetTextElementText(firstaddresstxt, Address);
		SetTextElementText(zipcodetxt, ZipCode);
		SetTextElementText(phonenumbertxt, PhoneNumber);
		Clickbutton(continuebtn);
	}
	
	public void GuestUserAddbillandshippingaddress(String FirstName, String LastName, String Email, String Country, String City, String Address, String ZipCode, String PhoneNumber) {
		SetTextElementText(firstnametxt, FirstName);
		SetTextElementText(lastnametxt, LastName);
		SetTextElementText(emailtxt, Email);
		select = new Select(countrydropdown);
		select.selectByVisibleText(Country);
		SetTextElementText(citytxt, City);
		SetTextElementText(firstaddresstxt, Address);
		SetTextElementText(zipcodetxt, ZipCode);
		SetTextElementText(phonenumbertxt, PhoneNumber);
		Clickbutton(continuebtn);
	}
	
	public void ChooseShippingMethod() {
		Clickbutton(shippingmethodradiobtn);
		Clickbutton(continuetopaymentmethodbtn);
	}
	
	public void ChoosePaymentMethod() {
		Clickbutton(paymentmethodradiobtn);
		Clickbutton(continuetopaymentinfobtn);
	}
	
	public void ContinueToConfirmTheOrder() {
		Clickbutton(continuetoconfirmbtn);
	}
	
	public void ConfirmTheOrder() {
		Clickbutton(confirmbtn);
	}
	
	public void OpenOrderDetailsPage() {
		Clickbutton(orderdetailslink);
	}
	
}
