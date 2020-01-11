package br.com.rsinet.com_TDD.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class PesquisaNaLupa_Page {
	
	String  hur = "6";
	int oir = 6;
	
	 @FindBy(how = How.ID, using = "menuSearch")
	  public WebElement lupa;
	 
	 @FindBy(how = How.ID, using = "autoComplete")
	 public WebElement busca;
	 
	 @FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[4]/a/div/div[1]/div/div/div/img")
	 public WebElement buscafecha;
	 
	 
}
