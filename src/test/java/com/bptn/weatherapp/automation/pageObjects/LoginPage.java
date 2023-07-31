package com.bptn.weatherapp.automation.pageObjects;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {
	
	By txtUsername = By.name("username");
	By txtPassword = By.name("password");
	By xPathLoginBtn = By.xpath("//button[text()='Login']");



	public void openLoginPage(String loginPageRoute) {
		this.driverManager.getDriver()
		                .get(this.provider.getFrontEndUrl() + loginPageRoute);
	}

	public void setUsername(String username) {
		this.driverManager.getDriver()
		                .findElement(this.txtUsername)
		                .sendKeys(username);
	}

	public void setPassword(String password) {
		this.driverManager.getDriver()
		                .findElement(this.txtPassword)
		                .sendKeys(password);
	}

	public void clickSubmit() {
		this.driverManager.getDriver()
		                .findElement(this.xPathLoginBtn)
		                .click();
	}

	public String getMessage() {
		
		return this.getMessage(this.xPathMessageToast);
	}

}

