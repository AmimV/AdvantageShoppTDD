package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import br.com.rsinet.HUB_TDD.PageFactory.CriarConta_Page;
import br.com.rsinet.HUB_TDD.PageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestCriaConta {
	ExtentReports extent;
	ExtentTest logger;
	static ChromeDriver driver = new ChromeDriver();
	static CriarConta_Page cc = new CriarConta_Page();
	static Home_Page inicio = PageFactory.initElements(driver, Home_Page.class);

	@BeforeMethod
	public void url() throws InterruptedException {

		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void CriaConta() throws Exception {
		
		Thread.sleep(2000);
		inicio.Register();
		inicio.ClicarEmRegister(driver);
		cc.CriaAcc(driver);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id("tabletsTxt"));
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());

	}

	@Test(priority = 1)

	public void CriaContaFalha() throws Exception {
		Thread.sleep(3000);
		inicio.Menu.click();

		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		cc.CriaAcc(driver);

		Assert.assertEquals("https://www.advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);

	}

	@AfterTest
	public void fechar() throws Exception {

		driver.close();
	}

}
