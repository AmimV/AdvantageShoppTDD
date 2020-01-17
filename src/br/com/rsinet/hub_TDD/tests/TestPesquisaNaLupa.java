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

import br.com.rsinet.HUB_TDD.PageFactory.DriverFactory;
import br.com.rsinet.HUB_TDD.PageFactory.PesquisaNaLupa_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;

public class TestPesquisaNaLupa {
	private WebDriver driver;

	@BeforeMethod
	public void url() {
		driver = DriverFactory.AbrirSite();
	}

	@Test(priority = 0)
	public void PesquisaLupa() throws Exception {
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		pesq.ClicarLupa();
		pesq.BuscaProduto();
		pesq.FechaLupa();
		pesq.ClicarEmProduto(driver);
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);

		Assert.assertEquals("https://www.advantageonlineshopping.com/#/product/14?viewAll=Headset",
				driver.getCurrentUrl());
	}

	@Test(priority = 1)
	public void PesqLupaNenhumProduto() throws Exception {
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		WebDriverWait wait = new WebDriverWait(driver, 10);

		pesq.ClicarLupa();
		pesq.BuscaProdutoInexistente();
		Boolean nenhumEncontrado = wait.until(ExpectedConditions.textToBePresentInElementLocated(
				By.xpath("/html/body/div[3]/section/article/div[3]/div/label/span"), "No results for"));
		Assert.assertTrue(nenhumEncontrado);
		//Atrasar a SS depois.
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);
	}

	@AfterMethod
	public void fechar() {
		DriverFactory.fecharChrome(driver);
	}
}
