package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import br.com.rsinet.HUB_TDD.PageFactory.DriverFactory;
import br.com.rsinet.HUB_TDD.PageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.PageFactory.Tablet_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestPesquisaNaHome {

	ExtentReports extent;
	ExtentTest logger;
	//static ChromeDriver driver = new ChromeDriver();
	private WebDriver driver;
	@BeforeMethod
	public void url() throws InterruptedException {

		driver = DriverFactory.AbrirSite();

	}

	@Test(priority = 0)
	public void PesquisaHome() throws Exception {
		Home_Page pesquisa = PageFactory.initElements(driver, Home_Page.class);
		Tablet_Page tablets = PageFactory.initElements(driver, Tablet_Page.class);

		pesquisa.tablet();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tablets.Hp_Pro(driver);

		ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/product/18", driver.getCurrentUrl());
	}

	@Test(priority = 1)
	public void PesquisaHomeFalha() throws Exception {
		Home_Page pesq = PageFactory.initElements(driver, Home_Page.class);
		Tablet_Page click = PageFactory.initElements(driver, Tablet_Page.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		pesq.tablet();
		click.tela(driver);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("18")));
		click.Processador(driver);
		Boolean semResultado = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[3]/label/span"), "No results"));
		Assert.assertTrue(semResultado);
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
	}

	@AfterMethod
	public void fechar() {
		 DriverFactory.fecharChrome(driver);
	}
}
