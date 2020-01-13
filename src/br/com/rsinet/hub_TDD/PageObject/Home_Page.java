package br.com.rsinet.HUB_TDD.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {

	 @FindBy(how = How.ID, using = "menuUser")
	  public WebElement Menu;

}
