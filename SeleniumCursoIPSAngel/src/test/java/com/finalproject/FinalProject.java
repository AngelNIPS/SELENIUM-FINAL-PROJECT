package com.finalproject;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.base.Base;
import com.selenium.base.GlobalVariables;
import com.selenium.poc.Dashboard;
import com.selenium.poc.Login;

public class FinalProject {
	
	WebDriver driver;
	Base base;
	Login loginPage;
	Dashboard dashboard;
	String username;
	String password;
	String newusername;
	String newpassword;
	
	@BeforeTest
	public void beforeTest() {
		base = new Base(driver);
		driver = base.chromeDriverCon();
		loginPage = new Login(driver);
		dashboard = new Dashboard(driver);
		username = base.getJSONValue("tcfinal", "user");
		password = base.getJSONValue("tcfinal", "password");
		newusername = base.getJSONValue("tcfinal", "newuser");
		newpassword = base.getJSONValue("tcfinal", "newpassword");
	}
	
	@Test
	public void tcfinal() {
		base.launchBrowser(GlobalVariables.QA_URL);
		Assert.assertTrue(loginPage.login(username, password));
		Assert.assertTrue(dashboard.navigateToAdmin());
		Assert.assertTrue(dashboard.addNewUser(newusername, newpassword));
		Assert.assertTrue(dashboard.deleteUser(newusername));
	}
	
	@AfterTest
	public void afterTest() {
		base.closeBrowser();
	}

}
