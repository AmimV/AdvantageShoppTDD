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
import br.com.rsinet.hub_TDD.PageFactory.PesquisaNaLupa_Page;
import br.com.rsinet.hub_TDD.Reports.Report;


public class TestPesquisaNaLupa {
	private WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void report() {
		extent = Report.setReport("PesquisarNaLupa");
	}
	
	@BeforeMethod
	public void url() {
		driver = DriverFactory.AbrirSite();
	}

	@Test(priority = 0)
	public void PesquisaLupa() throws Exception {
		test = Report.createTest("PesquisarNaLupa");
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		pesq.ClicarLupa();
		pesq.BuscaProduto();
		pesq.FechaLupa();
		pesq.ClicarEmProduto(driver);

		Assert.assertEquals("https://www.advantageonlineshopping.com/#/product/14?viewAll=Headset",
				driver.getCurrentUrl());
	}

	@Test(priority = 1)
	public void PesqLupaNenhumProduto() throws Exception {
		test = Report.createTest("PesquisarProdutoInexistenteNaLupa");
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		pesq.ClicarLupa();
		pesq.BuscaProdutoInexistente(driver);
		Boolean nenhumEncontrado = wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("/html/body/div[3]/section/article/div[3]/div/label/span"), "No results for"));
		Assert.assertTrue(nenhumEncontrado);
		
	}

	@AfterMethod
	public void fechar(ITestResult result) throws IOException {
		Report.statusReported(test, result, driver);
		Report.quitExtent(extent);
		DriverFactory.fecharChrome(driver);
	}
}
