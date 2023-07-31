package com.bptn.weatherapp.automation.stepPageDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;


import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.pageObjects.RegisterPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPageSteps {
	
	@Autowired
	RegisterPage registerPage;

	@Given("User is on the register page {string}")
	public void user_is_on_the_register_page(String registerPageRoute) {
		this.registerPage.openRegisterPage(registerPageRoute);
	}
	
	

	@When("User register into application with the following user details:")
	public void user_register_into_application_with_the_following_user_details(DataTable data) {

		this.registerPage.setFirstName(data.asMap().get("firstName"));
		this.registerPage.setLastName(data.asMap().get("lastName"));
		this.registerPage.setUsername(data.asMap().get("username"));
		this.registerPage.setPassword(data.asMap().get("password"));
		this.registerPage.setPhone(data.asMap().get("phone"));
		this.registerPage.setEmail(data.asMap().get("email"));
	}

	@And("User click 'Register' on signup page")
	public void user_click_register_on_signup_page() {
		this.registerPage.clickSubmit();
	}
		
	@Then("User should see the message {string} on signup page")
	public void user_should_see_the_message_on_signup_page(String message) {
		String incomingMessage = this.registerPage.getMessage().replaceAll("\\n", "");
		assertEquals(message, incomingMessage);
	}
}
