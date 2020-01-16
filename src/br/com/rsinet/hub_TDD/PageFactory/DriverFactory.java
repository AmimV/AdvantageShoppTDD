package br.com.rsinet.HUB_TDD.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	static WebDriver driver;
	private DriverFactory() {
	}

	public static WebDriver AbrirSite() {
			
			driver = new ChromeDriver();
			driver.get("https://www.advantageonlineshopping.com/#/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return  driver;
	

	}

	public static void fecharChrome() {
		if (driver != null)
			driver.quit();
		driver = null;
	}
}
