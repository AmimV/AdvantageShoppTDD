package br.com.rsinet.hub_TDD.tests;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import br.com.rsinet.hub_TDD.PageFactory.DriverFactory;
import br.com.rsinet.hub_TDD.PageFactory.Home_Page;
import br.com.rsinet.hub_TDD.PageFactory.Tablet_Page;
import br.com.rsinet.hub_TDD.Reports.Report;

public class TestPesquisaNaHome {

	ExtentReports extent;
	ExtentTest test;
	private WebDriver driver;
	private Tablet_Page tablet;
	private Home_Page home;

	@BeforeTest
	public void report() {

		extent = Report.setReport("PesquisaNaHome");
	}

	@BeforeMethod
	public void url() throws InterruptedException {
		driver = DriverFactory.AbrirSite();
		home = PageFactory.initElements(driver, Home_Page.class);
		tablet = PageFactory.initElements(driver, Tablet_Page.class);

	}

	@Test(priority = 0)
	public void PesquisaHome() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		test = Report.createTest("PesquisarProdutoNaHome");

		home.tablet();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tablet.Hp_Pro();
		
		Boolean semResultado = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/h1"), "HP PRO TABLET"));
		Assert.assertTrue(semResultado);
	

	}

	@Test(priority = 1)
	public void PesquisaHomeFalha() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		test = Report.createTest("PesquisarProdutoNaHomeFalha");

		home.tablet();
		tablet.tela();
		tablet.Processador();
		
		Boolean semResultado = wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("/html/body/div[3]/section/article/div[3]/div/div/div[3]/label/span"), "No results"));
		Assert.assertTrue(semResultado);
	}

	@AfterMethod
	public void fechar(ITestResult result) throws IOException {
		Report.statusReported(test, result, driver);
		Report.quitExtent(extent);
		DriverFactory.fecharChrome(driver);
	}
}
