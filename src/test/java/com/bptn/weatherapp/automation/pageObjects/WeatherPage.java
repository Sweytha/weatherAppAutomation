package com.bptn.weatherapp.automation.pageObjects;


import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class WeatherPage extends BasePage{
	
	By xPathTxtInput = By.xpath("//input[@placeholder='Search by city']");

	By xPathSearchBtn = By.xpath("//button[contains(@class, 'bg-purple-700')]");
	
	By xPathCityName = By.xpath("//div[@class='text-2xl font-semibold']");
	
	
	
	public void setCityName(String cityName){
		this.sendKeysToElement(xPathTxtInput, cityName);
	}
	
	
	public void clickSend() {
		this.driverManager.getDriver()
		                .findElement(this.xPathSearchBtn)
		                .click();
	}
	
	public void navigateToPageByTitle(String pageTitle){
		this.driverManager.getDriver()
		                .findElement(By.linkText(pageTitle))
		                .click();
	}
	
	public String getCityName(){
		
		return this.getMessage(xPathCityName);
	}
	

}
