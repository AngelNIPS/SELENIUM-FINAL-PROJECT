package com.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ejercicio6 {
	
	@Test
	public void f() {
		
		// EJERCICIO EN CLASE
		// RELLENAR EL FORMULARIO DE "ADD A COMPUTER"
				
		ChromeOptions chromeOpt = new ChromeOptions();
		WebDriverManager.chromedriver().setup();	  
		WebDriver driver = new ChromeDriver(chromeOpt);
		  
		driver.get("https://computer-database.gatling.io/computers");
		
		driver.findElement(By.id("add")).click();
	
		driver.findElement(By.id("name")).sendKeys("ASUS");
		driver.findElement(By.id("introduced")).sendKeys("2022-10-19");
		driver.findElement(By.id("discontinued")).sendKeys("2020-08-20");
		driver.findElement(By.id("company")).click();
		driver.findElement(By.xpath("//option[3]")).click();
		
		driver.close();
		
	}

}
