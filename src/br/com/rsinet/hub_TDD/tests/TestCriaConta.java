package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageObject.CriarConta_Page;
import br.com.rsinet.HUB_TDD.PageObject.Home_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;
import junit.framework.Assert;


public class TestCriaConta {

	static ChromeDriver driver = new ChromeDriver();

	@Before
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void CliqueConta() throws Exception {

		Home_Page inicio = PageFactory.initElements(driver, Home_Page.class);
		
		inicio.Menu.click();
		
		WebElement element = driver.findElement(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		int coluna = 0;
		int linha = 1;

		CriarConta_Page page = PageFactory.initElements(driver, CriarConta_Page.class);
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "Contas");

		page.userName.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.email.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.senha.sendKeys(ExcelUtils.getCellData(linha, coluna));
		page.confirmarSenha.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.primeiroNome.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.ultimoNome.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.telefone.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.pais.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.cidade.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.endereco.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.estadoEMais.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.cep.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		page.aceitar.click();
		page.botao.click();

		ScreenShot.getScreenShots(PrintDiretorio.criaConta, driver);
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/", driver.getCurrentUrl());
	}

}
