package com.tests.library;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LivroPage {
	protected WebDriver driver;
	
	private By livrosBy = By.linkText("Livros");
	
	private By listaLivrosBy = By.linkText("Lista de Livros");
	
	private By btnEditarBy = By.linkText("Editar");
	
	private By tituloBy = By.id("titulo");
	
	private By autorBy = By.id("autor");
	
	private By isbnBy = By.id("isbn");
   
	private By btnAtualizaLivroBy = By.cssSelector(".btn");
	
	private By btnEditarListaBy = By.linkText("Editar");
    
	
	public LivroPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean encontrouEditar() {
		return (driver.findElements(btnEditarListaBy).size() > 0);
	}
	
	
	public void atualizaLivro(String ISBN, String autor, String titulo) throws Exception {
		driver.findElement(livrosBy).click();
        driver.findElement(listaLivrosBy).click();
        driver.findElement(btnEditarBy).click();
        
        
        driver.findElement(isbnBy).clear();
        driver.findElement(autorBy).clear();
        driver.findElement(tituloBy).clear();
        
        driver.findElement(isbnBy).sendKeys(ISBN);
        driver.findElement(autorBy).sendKeys(autor);
        driver.findElement(tituloBy).sendKeys(titulo);
        driver.findElement(btnAtualizaLivroBy).click();
        
        if(!encontrouEditar())
        	throw new Exception("Nao foi possivel atualizar");
	}
	
	
	public void excluirLivro(String ISBN) throws Exception {
		
		boolean encontrou = false;
		driver.findElement(livrosBy).click();
	    driver.findElement(listaLivrosBy).click();
				
		List<WebElement> Trs = driver.findElement(By.className("table")).findElements(By.tagName("tr"));
		
		for(WebElement tr : Trs) {
			List<WebElement> Tds = tr.findElements(By.tagName("td"));
			
			for(int i=0; i<Tds.size(); i++) {	
				
				if(Tds.get(1).getText().equals(ISBN)) {
					
					String id = Tds.get(0).getText();
					
					String href = "https://ts-scel.herokuapp.com/sig/livro/" + id;
					
					encontrou = true;
					driver.get(href);
					
				}
			}
			
		}
		
		if(!encontrou)
			throw new Exception("Livro nao encontrado!");
		
	}
	
	
}
