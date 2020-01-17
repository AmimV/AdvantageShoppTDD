package br.com.rsinet.HUB_TDD.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_Page {
	private WebDriver driver;
//	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);
	@FindBy(how = How.ID, using = "menuUser")
	public WebElement Menu;

	@FindBy(how = How.ID, using = "tabletsTxt")
	private WebElement tablets;

	public void Register() {
		//wait.until(ExpectedConditions.elementToBeClickable(Menu));
		Menu.click();
	}

	public void ClicarEmRegister(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);
	}

	public void tablet() {
		tablets.click();
	}

}
