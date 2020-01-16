package br.com.rsinet.HUB_TDD.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Home_Page {
		
	 @FindBy(how = How.ID, using = "menuUser")
	  public WebElement Menu;
	 
	 public void Register () {
		 
			Menu.click();
	 }
	 
	 public void ClicarEmRegister (WebDriver driver) {
			WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
	 }
}


