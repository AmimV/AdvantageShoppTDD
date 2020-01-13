package br.com.rsinet.HUB_TDD.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaNaHome_Page {

	 @FindBy(how = How.ID, using = "tabletsTxt")
	  public WebElement tablet; 
	
}
