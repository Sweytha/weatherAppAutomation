package com.bptn.weatherapp.automation.pageObjects;

import org.openqa.selenium.By;
import org.springframework.stereotype.Component;

@Component
public class RegisterPage extends BasePage {
	
	By txtFirstName = By.name("firstName");
	By txtLastName = By.name("lastName");
	By txtUsername = By.name("username");
	By txtEmail = By.name("email");
	By txtPassword = By.name("password");
	By txtPhone = By.name("phone");
	
	By xPathRegisterBtn = By.xpath("//button[text()='Register']");


	public void openRegisterPage(String registerPageRoute) {
		this.driverManager.getDriver()
		               .get(this.provider.getFrontEndUrl() + registerPageRoute);
	}

	public void setFirstName(String firstName) {
		this.driverManager.getDriver()
		                .findElement(this.txtFirstName)
		                .sendKeys(firstName);
	}
	public void setLastName(String lastName) {
		this.driverManager.getDriver()
		                .findElement(this.txtLastName)
		                .sendKeys(lastName);
	}

	public void setUsername(String username) {
		this.driverManager.getDriver()
		                .findElement(this.txtUsername)
		                .sendKeys(username);
	}

	public void setEmail(String email) {
		this.driverManager.getDriver()
		                .findElement(this.txtEmail)
		                .sendKeys(email);
	}

	public void setPassword(String password) {
		this.driverManager.getDriver()
		                .findElement(this.txtPassword)
		                .sendKeys(password);
	}

	public void setPhone(String phone) {
		this.driverManager.getDriver()
		                .findElement(this.txtPhone)
		                .sendKeys(phone);
	}

	public void clickSubmit() {
		this.driverManager.getDriver()
		                .findElement(this.xPathRegisterBtn)
		                .click();
	}

	public String getMessage() {
		
		return this.getMessage(this.xPathMessageToast);
	}

}

