package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparePage extends PageBase{

	public ComparePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "a.clear-list")
	WebElement clearlistbtn;
	
	@FindBy(css = "table.compare-products-table")
	WebElement comparetable;
	
	@FindBy(tagName = "tr")
	List<WebElement> allrows;
	
	@FindBy(tagName = "td")
	List<WebElement> allcols;
	
	@FindBy(css = "div.no-data")
	public WebElement successmessage;
	
	public void ClearCompareTable() {
		Clickbutton(clearlistbtn);
	}
	
	public void CompareProducts() {
		 //Get all Rows
		System.out.println(allrows.size());
		//Get Data From each row
		for(WebElement row : allrows) {
			System.out.println(row.getText() + "\t");
			for(WebElement col : allcols) {
				System.out.println(col.getText() + "\t");
			}
		}
	}

}
