package br.com.rsinet.HUB_TDD.tests;


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

import br.com.rsinet.HUB_TDD.Excel.MassaDeDadosNovaConta;
import br.com.rsinet.HUB_TDD.PageFactory.CriarConta_Page;
import br.com.rsinet.HUB_TDD.PageFactory.DriverFactory;
import br.com.rsinet.HUB_TDD.PageFactory.Home_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestCriaConta {
	ExtentReports extent;
	ExtentTest logger;
	private WebDriver driver;
	private CriarConta_Page cc;
	private Home_Page inicio;
	MassaDeDadosNovaConta celula = new MassaDeDadosNovaConta();


	@BeforeMethod
	public void url() throws InterruptedException {
		driver = DriverFactory.AbrirSite();
		inicio = PageFactory.initElements(driver, Home_Page.class);
		cc = PageFactory.initElements(driver, CriarConta_Page.class);
	}

	@Test(priority = 0)
	public void CriaConta() throws Exception {
		
		inicio.Register();
		inicio.ClicarEmRegister(driver);
		cc.Usuario();
		cc.email();
		cc.senha();
		cc.ConfirmarSenha();
		cc.PrimeiroNome();
		cc.UltimoNome();
		cc.Telefone();
		cc.Pais();
		cc.Cidade();
		cc.Endereco();
		cc.Estado();
		cc.Cep();
		cc.Aceitar();
		cc.botao();

		WebDriverWait wait = new WebDriverWait(driver, 10);
	Boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/header/nav/ul/li[3]/a/span"), celula.Usuario()));
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		Assert.assertTrue(element);
	
	}

	@Test(priority = 1)

	public void CriaContaFalha() throws Exception {
		
		inicio.Register();
		inicio.ClicarEmRegister(driver);
		cc.Usuario();
		cc.email();
		cc.senha();
		cc.ConfirmarSenha();
		cc.PrimeiroNome();
		cc.UltimoNome();
		cc.Telefone();
		cc.Pais();
		cc.Cidade();
		cc.Endereco();
		cc.Estado();
		cc.Cep();
		cc.Aceitar();
		cc.botao();

		
		WebDriverWait wait = new WebDriverWait(driver, 10);
	Boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"), "User name already exists"));
	System.out.println(element);
		//Atrasar SS depois.
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);

	}

	@AfterMethod
	public void fechar() throws Exception {

	 DriverFactory.fecharChrome(driver);
	}
}
