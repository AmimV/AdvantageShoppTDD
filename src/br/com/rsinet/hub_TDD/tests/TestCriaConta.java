package br.com.rsinet.HUB_TDD.tests;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Excel.CriarContaExcel;
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
	CriarContaExcel celula = new CriarContaExcel();


	@BeforeMethod
	public void url() throws InterruptedException {

		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	@Test(priority = 0)
	public void CriaConta() throws Exception {
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		inicio.Register(driver);
		inicio.ClicarEmRegister(driver);
		cc.Usuario(driver);
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

		WebDriverWait wait = new WebDriverWait(driver, 15);
	Boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/header/nav/ul/li[3]/a/span"), celula.Usuario()));
	System.out.println(element);	
		driver.findElement(By.id("tabletsTxt"));
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		Assert.assertTrue(element);
	
	}

	@Test(priority = 1)

	public void CriaContaFalha() throws Exception {
		
		inicio.Register(driver);
		inicio.ClicarEmRegister(driver);
		cc.Usuario(driver);
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

		
		WebDriverWait wait = new WebDriverWait(driver, 20);
	Boolean element = wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/label[1]"), "User name already exists"));
	System.out.println(element);
		
		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);

	}

	@AfterTest
	public void fechar() throws Exception {

		driver.quit();
	}

}
