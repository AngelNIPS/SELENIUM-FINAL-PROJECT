package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class Login extends Base {
	
	public Login(WebDriver driver) {
		super(driver);
	}
	
	By txtUserName = By.name("username");
	By txtPassword = By.name("password");
	By btnLogin = By.xpath("//button[@type='submit']");
	By lblUserName = By.xpath("//p[@class='oxd-userdropdown-name']");
	
	public boolean login(String username, String password) {
		type(txtUserName, username);
		type(txtPassword, password);
		click(btnLogin);
		verifyVisibilityElement(lblUserName);
		takeScreenshot("TCFINAL - LOGIN");
		return lblUserName != null;
	}
	
}
