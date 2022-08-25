package com.selenium.poc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.base.Base;

public class Dashboard extends Base {
	
	public Dashboard(WebDriver driver) {
		super(driver);
	}
	
	By btnAdmin = By.xpath("//ul[@class='oxd-main-menu']/li/a/span[text() = 'Admin']");
	By brcmAdmin = By.xpath("//div[@class='oxd-topbar-header-title']/span/h6[1]");
	By btnAdd = By.xpath("//div[@class='orangehrm-header-container']/button");
	By userForm = By.xpath("//form[@class='oxd-form']");
	By slcUserRole = By.xpath("(//div[@class='oxd-select-wrapper'])[1]");
	By optUser = By.xpath("//div[@role='option']/span[text() = 'Admin']");
	By txtEmployee = By.xpath("//div[contains(@class, 'oxd-input-group')]/div[2]/div/div/input");
	By optEmployee = By.xpath("//div[@role='option']/span[text()='Aaliyah  Haq']");
	By slcStatus = By.xpath("(//div[@class='oxd-select-wrapper'])[2]");
	By optStatus = By.xpath("//div[@role='option']/span[text() = 'Enabled']");
	By txtUserName = By.xpath("(//div[contains(@class, 'oxd-input-group')]/div[2]/input)[1]");
	By txtPassword = By.xpath("(//div[contains(@class, 'oxd-input-group')]/div[2]/input)[2]");
	By txtConfirmPass = By.xpath("(//div[contains(@class, 'oxd-input-group')]/div[2]/input)[3]");
	By lblError = By.xpath("//span[contains(@class, 'oxd-input-field-error-message')]");
	By btnSave = By.xpath("(//form//button)[2]");
	By okToast = By.xpath("//div[contains(@class,'oxd-toast')]");
	By txtSearchUserName = By.xpath("(//div[@class='oxd-table-filter']//input)[1]");
	By btnSearch = By.xpath("//form[@class='oxd-form']//button[@type='submit']");
	By lstResults = By.xpath("//div[@class='oxd-table-card']");
	By btnDelete = By.xpath("(//div[@class='oxd-table-card']//button)[1]");
	By mdlDelete = By.xpath("//div[contains(@class, 'oxd-sheet')]");
	By btnDeleteModal = By.xpath("//div[contains(@class, 'oxd-sheet')]//button[text()=' Yes, Delete ']");
	
	public boolean navigateToAdmin() {
		click(btnAdmin);
		return verifyAdminPage();
	}
	
	public boolean verifyAdminPage() {
		verifyVisibilityElement(brcmAdmin);
		verifyVisibilityElement(lstResults);
		takeScreenshot("TCFINAL - ADMIN PAGE");
		return getText(btnAdmin).equals("Admin");
	}
	
	public boolean addNewUser(String username, String password) {
		click(btnAdd);
		verifyVisibilityElement(userForm);
		click(slcUserRole);
		click(optUser);
		type(txtEmployee, "Aaliyah ");
		click(optEmployee);
		click(slcStatus);
		click(optStatus);
		type(txtUserName, username);
		type(txtPassword, password);
		type(txtConfirmPass, password);
		verifyInvisibilityElement(lblError);
		click(btnSave);
		verifyVisibilityElement(okToast);
		if(verifyUserExist(username)) {
			takeScreenshot("TCFINAL - USER ADDED");
			return true;
		} 			
		return false;
	}
	
	public boolean deleteUser(String username) {
		if (verifyUserExist(username)) { 
			click(btnDelete);
			verifyVisibilityElement(mdlDelete);
			click(btnDeleteModal);
			verifyVisibilityElement(okToast);
			if(!verifyUserExist(username)) {
				takeScreenshot("TCFINAL - USER DELETED");
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean verifyUserExist(String username) {
		click(btnAdmin);
		verifyVisibilityElement(lstResults);
		type(txtSearchUserName, username);
		click(btnSearch);
		return getLength(lstResults) == 1;
	}
	
	
	

}
