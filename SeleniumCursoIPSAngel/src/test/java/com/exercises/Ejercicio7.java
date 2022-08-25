package com.exercises;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.MainPage;

public class Ejercicio7 {
	
	WebDriver driver;
	Base base;
	MainPage mainPage;
	String expectedComputer;
	String newComputerName;
	String newComputerIntroduced;
	String newComputerDiscontinued;
	
	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		mainPage = new MainPage(driver);		
		newComputerName = base.getJSONValue("tc001", "name");
		newComputerIntroduced = base.getJSONValue("tc001", "introduced");
		newComputerDiscontinued = base.getJSONValue("tc001", "discontinued");
	}
	
	@Test
	public void tc001() {
		base.launchBrowser(GlobalVariables.QA_EXCERCISE);
		mainPage.addNewComputer(newComputerName, newComputerIntroduced, newComputerDiscontinued);
		Assert.assertTrue(mainPage.verifyAlertMessage());
	}
	
	@AfterTest
	public void afterTest() {
		base.closeBrowser();
	}
	
}
