package com.bptn.weatherapp.automation.pageObjects;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class VerifyEmailPage extends BasePage {

	
    By xPathVerifyEmailBtn = By.xpath("//button[text()='Verify Email']");



	public void openVerifyEmailPage(String verifyEmailPageRoute) {
		this.driverManager.getDriver()
		                .get(this.provider.getFrontEndUrl() + verifyEmailPageRoute);
	}

	public void clickSubmit() {
		this.driverManager.getDriver()
				.findElement(this.xPathVerifyEmailBtn)
				.click();
	}

	public String getMessage() {
		
		return this.getMessage(this.xPathMessageToast);
	}

}

