package com.bptn.weatherapp.automation.stepRestDefinitions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.context.TestContext;
import com.bptn.weatherapp.automation.dao.UserDao;
import com.bptn.weatherapp.automation.dao.WeatherDao;
import com.bptn.weatherapp.automation.jwt.JwtService;
import com.bptn.weatherapp.automation.provider.ResourceProvider;
import com.bptn.weatherapp.automation.restObjects.UserEndPoint;
import com.bptn.weatherapp.automation.restObjects.WeatherEndPoint;

import io.restassured.response.Response;

public class EndPointSteps {

	protected static final String AUTHORIZATION = "Authorization";
	protected static final String UNAUTHORIZED = "UNAUTHORIZED";


	@Autowired
	UserDao userDao;
	
	@Autowired
	TestContext context;

	@Autowired
	WeatherDao weatherDao;

	@Autowired
	JwtService jwtService;

	@Autowired
	UserEndPoint userEndPoint;

	@Autowired
	WeatherEndPoint weatherEndPoint;

	@Autowired
	ResourceProvider resourceProvider;


	String jwtToken;

	Response response;
	
	String convertTimeStamp(Timestamp timeStamp) {
                                        	  
		DateFormat df = new SimpleDateFormat(this.resourceProvider.getDateFormat());
		df.setTimeZone(TimeZone.getTimeZone(this.resourceProvider.getTimeZone()));
		
		return df.format(timeStamp);
	}
}