package br.com.rsinet.com_TDD.PageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {

	 @FindBy(how = How.ID, using = "menuUser")
	  public WebElement Menu;
	  
	 @FindBy(how = How.XPATH, using = "/html/body/login-modal/div/div/div[3]/a[2]")
	 public static WebElement CreateNewAcount;
	 
}
