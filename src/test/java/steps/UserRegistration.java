package steps;

import Pages.HomePage;
import Pages.UserRegistrationPage;
import Tests.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserRegistration extends TestBase{

	HomePage homeobject;
	UserRegistrationPage registerobject;

	@Given("the user in the home page")
	public void the_user_in_the_home_page() {
		homeobject = new HomePage(driver);
		homeobject.OpenRegistrationPage();
	}

	@When("I click on register link")
	public void i_click_on_register_link() {
		//Assert.assertTrue(driver.getCurrentUrl().contains("register"));
	}

	/*
	 * @When("I entered the user data") public void i_entered_the_user_data() {
	 * registerobject = new UserRegistrationPage(driver);
	 * registerobject.UserRegistration("Hayam", "Mahran", "hayamm@hayam.com",
	 * "12345678"); }
	 */
	
	@When("I entered {string} , {string} , {string} , {string}")
	public void i_entered(String firstname, String lastname, String email, String password) {
		 registerobject = new UserRegistrationPage(driver);
		 registerobject.UserRegistration(firstname, lastname, email, password);
	}

	@Then("the registration page displayed successfully")
	public void the_registration_page_displayed_successfully() {
		//registerobject.userLogout();
	}
}
