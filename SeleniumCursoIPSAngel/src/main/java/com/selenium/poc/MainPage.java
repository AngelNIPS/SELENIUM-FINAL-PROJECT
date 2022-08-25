package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class MainPage extends Base {
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
	
	// Objects
	By btnAddComputer = By.id("add");
	By txtComputerName = By.id("name");
	By txtIntroduced = By.id("introduced");
	By txtDiscontinued = By.id("discontinued");
	By btnCreateComputer = By.xpath("//input[@type='submit']");
	By alertMessage = By.className("alert-message");

		
	public void addNewComputer (String name, String introduced, String discontinued) {
		click(btnAddComputer);
		type(txtComputerName, name);
		type(txtIntroduced, introduced);
		type(txtDiscontinued, discontinued);
		click(btnCreateComputer);	
	}
	
	public boolean verifyAlertMessage() {
		return isDisplayed(alertMessage);
	}

}
