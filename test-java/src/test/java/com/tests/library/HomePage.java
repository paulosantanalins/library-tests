package com.tests.library;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	protected WebDriver driver;	
	
	private By btnLogout = By.linkText("Logout");
	
	
	public HomePage(WebDriver driver) throws Exception {
		this.driver = driver;
		
		if(!encontrouLogout()) {
			throw new Exception("Usuario nao logado");
		}
	}
	
	
	public boolean encontrouLogout() {
		return (driver.findElements(btnLogout).size() > 0);
	}

}
