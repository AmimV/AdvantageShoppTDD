package br.com.rsinet.HUB_TDD.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
import br.com.rsinet.HUB_TDD.PageFactory.DriverFactory;
import br.com.rsinet.HUB_TDD.PageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.PageFactory.Tablet_Page;
import br.com.rsinet.HUB_TDD.Reports.Report;

public class TestPesquisaNaHome {

	ExtentReports extent;
	ExtentTest test;
	private WebDriver driver;

	@BeforeTest
	public void report() {

		extent = Report.setReport("PesquisaNaHome");
	}

	@BeforeMethod
	public void url() throws InterruptedException {
		driver = DriverFactory.AbrirSite();

	}

	@Test(priority = 0)
	public void PesquisaHome() throws Exception {
		Home_Page pesquisa = PageFactory.initElements(driver, Home_Page.class);
		Tablet_Page tablets = PageFactory.initElements(driver, Tablet_Page.class);
		test = Report.createTest("PesquisarProdutoNaHome");

		pesquisa.tablet();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tablets.Hp_Pro(driver);

		Assert.assertTrue(driver.getPageSource().contains("HP Pro"));
	}

	@Test(priority = 1)
	public void PesquisaHomeFalha() throws Exception {

		Home_Page pesq = PageFactory.initElements(driver, Home_Page.class);
		Tablet_Page click = PageFactory.initElements(driver, Tablet_Page.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		test = Report.createTest("PesquisarProdutoNaHomeFalha");

		pesq.tablet();
		click.tela(driver);
		click.Processador(driver);
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
