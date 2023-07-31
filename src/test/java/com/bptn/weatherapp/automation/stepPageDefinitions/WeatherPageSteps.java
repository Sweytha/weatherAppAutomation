package com.bptn.weatherapp.automation.stepPageDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.pageObjects.WeatherPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherPageSteps {

	
	@Autowired
	WeatherPage weatherPage;
	
	@Given("the user is on the welcome page {string}")
	public void the_user_is_on_the_current_weather_page(String welcomeRoute) {
		assertEquals(this.weatherPage.getPageRoute(), welcomeRoute);
	     
	}
	
	@When("User clicks on {string} which navigates to current weather page")
	public void user_clicks_on_which_navigates_to_current_weather_page(String liveWeatherDataTitle){
		
	    this.weatherPage.navigateToPageByTitle(liveWeatherDataTitle);
	   
	}
	
		
	@When("the user searches for the city {string}")
	public void the_user_searches_for_the_city(String cityName) {
	     this.weatherPage.setCityName(cityName);;
	}
	
	
	@When("User clicks on the 'Search' button to retrieve current weather for city")
	public void user_clicks_on_the_button_to_retrieve_current_weather_for_city() {
	     this.weatherPage.clickSend();
	}
	
	
	@Then("the current weather for {string} should be displayed")
	public void the_current_weather_for_should_be_displayed(String cityName) {
		
		assertTrue(this.weatherPage.getCityName().contains(cityName));
	     
	}
	
	
	@When("User clicks on {string} which navigates to history weather page")
	public void user_clicks_on_which_navigates_to_history_weather_page(String historyWeatherDataTitle) {
		
	    this.weatherPage.navigateToPageByTitle(historyWeatherDataTitle);
	}
	
	
	@Then("the history weather data for {string} should be displayed")
	public void the_history_weather_data_for_should_be_displayed(String cityName) {
		assertTrue(this.weatherPage.getCityName().contains(cityName));
	}
	
	
}
