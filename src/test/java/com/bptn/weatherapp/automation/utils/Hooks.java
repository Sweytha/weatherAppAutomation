package com.bptn.weatherapp.automation.utils;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.web.DriverManager;

import io.cucumber.java.After;

public class Hooks {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    DriverManager driverManager;
    
	@After("@WebTestOutline")
	public void afterAll() {

		// Test
	}

	//@After
	public void screenshot(Scenario scenario) {
		byte[] screenshot = ((TakesScreenshot) this.driverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName() + " Screenshot");
	}

}
