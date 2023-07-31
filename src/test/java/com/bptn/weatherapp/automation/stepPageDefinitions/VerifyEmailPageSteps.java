package com.bptn.weatherapp.automation.stepPageDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.cucumber.java.en.And;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.jwt.JwtService;
import com.bptn.weatherapp.automation.pageObjects.VerifyEmailPage;
import com.bptn.weatherapp.automation.provider.ResourceProvider;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class VerifyEmailPageSteps {

	@Autowired
	ResourceProvider resourceProvider;
	
	@Autowired
	VerifyEmailPage verifyEmailPage;

	@Autowired
	JwtService jwtService;

	String jwtToken;
		
	@Given("User {string} has an email with a valid JWT token")
	public void user_has_an_email_with_a_valid_JWT_token(String username) {
		this.jwtToken = this.jwtService.generateJwtToken(username, this.resourceProvider.getJwtExpiration());
	}

	@When("User is on verify email page {string}")
	public void user_is_on_verify_email_page(String verifyEmailPageRoute) {

		String verifyEmailPageRouteWithToken = verifyEmailPageRoute +  this.jwtToken;
		this.verifyEmailPage.openVerifyEmailPage(verifyEmailPageRouteWithToken);
	}

	@And("User click 'Verify Email' on verify email page")
	public void user_click_verify_email_on_verify_email_page() {
		this.verifyEmailPage.clickSubmit();
	}

	@Then("User should see the message {string} on verify email page.")
	public void user_should_see_the_message_on_verify_email_page(String message) {
		assertEquals(message,this.verifyEmailPage.getMessage());
	}


}
