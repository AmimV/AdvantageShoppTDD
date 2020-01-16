package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import br.com.rsinet.HUB_TDD.PageFactory.PesquisaNaLupa_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestPesquisaNaLupa {
	static ChromeDriver driver = new ChromeDriver();
	//DriverFactory driverFactory = new DriverFactory();

	@BeforeMethod
	public void url() {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//	driverFactory.iniciar();
	}

	@Test(priority = 0)
	public void PesquisaLupa() throws Exception {
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		pesq.PesqLupa(driver);
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/product/14?viewAll=Headset",
				driver.getCurrentUrl());
	}

	@Test(priority = 1)
	public void PesqLupaNenhumProduto() throws Exception {
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		pesq.BuscarProdutoInexistente(driver);
		String kir = pesq.SemResultado.getText();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//Print saindo muito antes, rever isso depois.
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);
		Assert.assertEquals(pesq.SemResultado.getText(), kir);
	}

	@AfterTest
	public void fechar() {
		driver.close();
	}
}
