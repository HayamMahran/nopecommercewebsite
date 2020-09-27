package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;

public class ProductHoverMenuTest extends TestBase{
	
	HomePage homepageobject;
	
	@Test
	public void UserCanSelectSubCategoryFromMainMenu() {
		homepageobject = new HomePage(driver);
		homepageobject.SelectNotebooksMenu();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//System.out.println(driver.getCurrentUrl());
		Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
	}

}
