package com.bptn.weatherapp.automation.stepPageDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.pageObjects.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	@Autowired
	LoginPage loginPage;

	
	@Given("User is on the login page {string}")
	public void user_is_on_the_login_page(String loginPageRoute) {
		this.loginPage.openLoginPage(loginPageRoute);
	}

	@When("User login into application with {string} and password {string}")
	public void user_login_into_application_with_and_password(String username, String password) {
		this.loginPage.setUsername(username);
		this.loginPage.setPassword(password);
	}

	@When("User click 'Submit' on login page")
	public void i_click_submit_on_login_page() {
		this.loginPage.clickSubmit();
	}

	@Then("User should see the message {string} on login page")
	public void i_should_see_the_message_on_login_page(String message) {
		assertEquals(this.loginPage.getMessage(), message);
	}
	
	@Then("User should navigate to {string} from login")
	public void user_should_navigate_to(String route) {
		assertEquals(this.loginPage.getPageRoute(), route);
	}

}
