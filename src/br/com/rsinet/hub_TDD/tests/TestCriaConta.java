package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import br.com.rsinet.HUB_TDD.PageObject.Criando_Conta;
import br.com.rsinet.HUB_TDD.PageObject.Home_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestCriaConta {
	ExtentReports extent;
	ExtentTest logger;
	static ChromeDriver driver = new ChromeDriver();
	static Criando_Conta cc = new Criando_Conta();
	static Home_Page inicio = PageFactory.initElements(driver, Home_Page.class);

	@BeforeMethod
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("target/CriarConta.html");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("CriaContaTeste");

		 Thread.sleep(3000);
		inicio.Menu.click();
	}

	@Test(priority = 0)
	public void CriaConta() throws Exception {

		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		cc.Preenchendo(driver);

		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.findElement(By.id("tabletsTxt"));
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		AssertJUnit.assertEquals("https://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
//		
//		logger.log(Status.PASS, "Passou");
//		logger.log(Status.FAIL, "Falha");
		logger.fail("Falhou");
		logger.pass("Passou");

	}

	@Test(priority = 1)

	public void CriaContaFalha() throws Exception {

		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		cc.Preenchendo(driver);

		AssertJUnit.assertEquals("https://www.advantageonlineshopping.com/#/register", driver.getCurrentUrl());
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		
	}

	@AfterTest
	public void fechar() throws Exception {
		extent.flush();
		logger.fail("Falhou");
		logger.pass("Passou");
		driver.close();
	}

}
