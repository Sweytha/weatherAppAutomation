package com.bptn.weatherapp.automation.pageObjects;


import java.net.URI;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.bptn.weatherapp.automation.provider.ResourceProvider;
import com.bptn.weatherapp.automation.web.DriverManager;

public class BasePage {

	final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	DriverManager driverManager;

	@Autowired
	ResourceProvider provider;
	
	By xPathMessageToast = By.xpath("//div[@role='status' and @aria-live='polite' and contains(@class, 'go3958317564')]");
	
	public void sendKeysToElement(By locator, String content) {
	    try {
	        WebDriverWait wait = new WebDriverWait(this.driverManager.getDriver(), Duration.ofSeconds(10));
	        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	        element.sendKeys(content);
	    } catch (Exception ex) {
	        this.logger.error(ex.getMessage(), ex);
	    }
	}
	
	/* Gets Message */
	public String getMessage(By xPathMessage) {
		try {
			WebDriverWait wait = new WebDriverWait(this.driverManager.getDriver(), Duration.ofSeconds(10));
			WebElement messageElement = wait.until(ExpectedConditions.presenceOfElementLocated(xPathMessage));

			Thread.sleep(2000);
			
			return messageElement.getText();
		} catch (Exception ex) {
			this.logger.error(ex.getMessage(), ex);
		}

		return null;
	}
	
	/* Gets the Current Page Path */
	public String getPageRoute()  {

		try{
			Thread.sleep(2000);
			return new URI(this.driverManager.getDriver().getCurrentUrl()).getPath();

		}catch (Exception ex){
			this.logger.error(ex.getMessage(), ex);
		}

		return null;
	}
}
