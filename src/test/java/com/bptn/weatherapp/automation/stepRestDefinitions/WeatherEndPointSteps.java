package com.bptn.weatherapp.automation.stepRestDefinitions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

import com.bptn.weatherapp.automation.bean.User;
import com.bptn.weatherapp.automation.bean.Weather;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WeatherEndPointSteps extends EndPointSteps {

	/*
	 * To Run these tests successfully the Spring's application.yml Jackson 
	 * Timezone property must be the same as in the back-end application. 
	 */
	
	@Given("a valid user token for username {string}")
	public void a_valid_user_token(String username) {

		this.jwtToken = this.context.getToken();
		assertNotNull(this.jwtToken);
		assertEquals(username, this.jwtService.getSubject(this.jwtToken));
	}

	@Given("an expired user token for username {string}")
	public void an_expired_user_token(String username) {
		this.jwtToken = this.jwtService.generateJwtToken(username, 0);
	}

	@When("a 'GET' request is made to {string} API")
	public void a_request_is_made_to_api(String path) {

		this.weatherEndPoint.createRequestWithToken(this.jwtToken);

		this.response = this.weatherEndPoint.sendGetRequest(path);
	}

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer statusCode) {
		assertEquals(statusCode, this.response.getStatusCode());
	}

	@Then("Weather JSON Data received matches latest city searched by username {string} in weather DB")
	public void weather_json_data_received_matches_latest_city_searched_by_username_in_weather_db(String username) throws ParseException {

		User user = this.userDao.findByUsername(username);
		Weather weather = this.weatherDao.getLatestWeatherByUser(user);

		assertEquals(weather.getWeatherId(), this.response.jsonPath().getInt("weatherId"));	
		assertEquals(weather.getDescription(), this.response.jsonPath().getString("description"));
		assertEquals(weather.getIcon(), this.response.jsonPath().getString("icon"));
		assertEquals(weather.getWeatherStatusId(), this.response.jsonPath().getInt("weatherStatusId"));

		assertEquals(this.convertTimeStamp(weather.getSunrise()),this.response.jsonPath().getString("sunrise"));
		assertEquals(this.convertTimeStamp(weather.getSunset()),this.response.jsonPath().getString("sunset"));
		assertEquals(this.convertTimeStamp(weather.getUpdatedOn()),this.response.jsonPath().getString("updatedOn"));

		assertEquals(weather.getCloudsAll(), new BigDecimal(this.response.jsonPath().getString("cloudsAll")).setScale(2));
		assertEquals(weather.getFeelsLike(), new BigDecimal(this.response.jsonPath().getString("feelsLike")).setScale(2));
		assertEquals(weather.getHumidity(), new BigDecimal(this.response.jsonPath().getString("humidity")).setScale(2));
		assertEquals(weather.getPressure(), new BigDecimal(this.response.jsonPath().getString("pressure")).setScale(2));
		assertEquals(weather.getTemp(), new BigDecimal(this.response.jsonPath().getString("temp")).setScale(2));
		assertEquals(weather.getTempMax(), new BigDecimal(this.response.jsonPath().getString("tempMax")).setScale(2));
		assertEquals(weather.getTempMin(), new BigDecimal(this.response.jsonPath().getString("tempMin")).setScale(2));
		assertEquals(weather.getVisibility(), new BigDecimal(this.response.jsonPath().getString("visibility")).setScale(2));
		assertEquals(weather.getWindSpeed(), new BigDecimal(this.response.jsonPath().getString("windSpeed")).setScale(2));
		assertEquals(weather.getWindDirection(), new BigDecimal(this.response.jsonPath().getString("windDirection")).setScale(2));
	}
	
	@Then("Weather JSON Data received matches weather records searched by username {string} in weather DB")
	public void weather_json_data_received_matches_weather_records_searched_by_username_in_weather_db(String username) {
	    	
		User user = this.userDao.findByUsername(username);
		List<Weather> weathers = this.weatherDao.findFirst10ByUserOrderByWeatherIdDesc(user);

		assertEquals(weathers.get(0).getWeatherId(), this.response.jsonPath().getInt("[0].weatherId"));	
		assertEquals(weathers.get(0).getDescription(), this.response.jsonPath().getString("[0].description"));
		assertEquals(weathers.get(0).getIcon(), this.response.jsonPath().getString("[0].icon"));
		assertEquals(weathers.get(0).getWeatherStatusId(), this.response.jsonPath().getInt("[0].weatherStatusId"));
		
		assertEquals(this.convertTimeStamp(weathers.get(0).getSunrise()),this.response.jsonPath().getString("[0].sunrise"));
		assertEquals(this.convertTimeStamp(weathers.get(0).getSunset()),this.response.jsonPath().getString("[0].sunset"));
		assertEquals(this.convertTimeStamp(weathers.get(0).getUpdatedOn()),this.response.jsonPath().getString("[0].updatedOn"));

		assertEquals(weathers.get(0).getCloudsAll(), new BigDecimal(this.response.jsonPath().getString("[0].cloudsAll")).setScale(2));
		assertEquals(weathers.get(0).getFeelsLike(), new BigDecimal(this.response.jsonPath().getString("[0].feelsLike")).setScale(2));
		assertEquals(weathers.get(0).getHumidity(), new BigDecimal(this.response.jsonPath().getString("[0].humidity")).setScale(2));
		assertEquals(weathers.get(0).getPressure(), new BigDecimal(this.response.jsonPath().getString("[0].pressure")).setScale(2));
		assertEquals(weathers.get(0).getTemp(), new BigDecimal(this.response.jsonPath().getString("[0].temp")).setScale(2));
		assertEquals(weathers.get(0).getTempMax(), new BigDecimal(this.response.jsonPath().getString("[0].tempMax")).setScale(2));
		assertEquals(weathers.get(0).getTempMin(), new BigDecimal(this.response.jsonPath().getString("[0].tempMin")).setScale(2));
		assertEquals(weathers.get(0).getVisibility(), new BigDecimal(this.response.jsonPath().getString("[0].visibility")).setScale(2));
		assertEquals(weathers.get(0).getWindSpeed(), new BigDecimal(this.response.jsonPath().getString("[0].windSpeed")).setScale(2));
		assertEquals(weathers.get(0).getWindDirection(), new BigDecimal(this.response.jsonPath().getString("[0].windDirection")).setScale(2));
	}

	@Then("the response body should contain the error message {string}")
	public void the_response_body_should_contain_the_error_message(String message) {

		assertEquals(401, this.response.jsonPath().getInt("httpStatusCode"));
		assertEquals(UNAUTHORIZED, this.response.jsonPath().getString("httpStatus"));
		assertEquals(UNAUTHORIZED, this.response.jsonPath().getString("reason"));
		assertEquals(message, this.response.jsonPath().getString("message"));
	}
}
