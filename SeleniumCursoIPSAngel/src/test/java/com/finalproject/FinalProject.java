package com.finalproject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
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
	ExtentReports extent;
	ExtentTest logger;

	private String className = this.getClass().getSimpleName();
	
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
		
		// Set up Extend reports
		extent = new ExtentReports(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.REPORT_PATH, true);
		extent.addSystemInfo(GlobalVariables.EXTENT_QA_URL, GlobalVariables.QA_URL);
		extent.loadConfig(new File(System.getProperty(GlobalVariables.USER_DIR) + GlobalVariables.CONFIG_EXTENT));
	}
	
	@Test
	public void tcfinal() {
		logger = extent.startTest(className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName());
		
		base.launchBrowser(GlobalVariables.QA_URL);
		Assert.assertTrue(loginPage.login(username, password));
		Assert.assertTrue(dashboard.navigateToAdmin());
		Assert.assertTrue(dashboard.addNewUser(newusername, newpassword));
		Assert.assertTrue(dashboard.deleteUser(newusername));
		
		logger.log(LogStatus.PASS, "Validation " + className + " - " + new Object() {
		}.getClass().getEnclosingMethod().getName() + " was successfully");	
	}
	
	@AfterMethod
	public void getResult(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			logger.log(LogStatus.FAIL, logger.addScreenCapture(base.takeScreenshot("TCFINAL - ERROR")));
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(LogStatus.SKIP, "Test Case Skipped is " + result.getName());
		}
		extent.endTest(logger);
	}
	
	@AfterTest
	public void afterTest() {
		extent.flush();
		extent.close();
		base.closeBrowser();
	}

}
