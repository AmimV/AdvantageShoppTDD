package br.com.rsinet.hub_TDD.tests;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
	PesquisaNaLupa_Page pesq;

	@BeforeTest
	public void report() {
		extent = Report.setReport("PesquisarNaLupa");
	}
	
	@BeforeMethod
	public void url() {
		driver = DriverFactory.AbrirSite();
		pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		
	}

	@Test(priority = 0)
	public void PesquisaLupa() throws Exception {
		test = Report.createTest("PesquisarNaLupa");
		pesq.ClicarLupa();
		pesq.BuscaProduto();
		pesq.FechaLupa();
		pesq.ClicarEmProduto();
		pesq.ConfereAddAoCarrinho();
	}

	@Test(priority = 1)
	public void PesqLupaNenhumProduto() throws Exception {
		test = Report.createTest("PesquisarProdutoInexistenteNaLupa");

		pesq.ClicarLupa();
		pesq.BuscaProdutoInexistente(driver);
		pesq.CofereNenhumProdutoEncontrado();
		
	}

	@AfterMethod
	public void fechar(ITestResult result) throws IOException {
		Report.statusReported(test, result, driver);
		Report.quitExtent(extent);
		DriverFactory.fecharChrome(driver);
	}
}
