package com.tests.library;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	protected WebDriver driver;
	
	private By usernameBy = By.name("username");
	
	private By passwordBy = By.name("password");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	/**
	 * Login na aplicação com usuario valido
	 * 
	 * @param username
	 * @param password
	 * @return boolean
	 * @throws Exception 
	 * 
	 * */
	
	public HomePage loginUsuarioValido(String username, String password) throws Exception {
		driver.findElement(usernameBy).sendKeys(username);
		driver.findElement(passwordBy).sendKeys(password);
		driver.findElement(passwordBy).sendKeys(Keys.ENTER);
		
		return new HomePage(driver);
	}

}
