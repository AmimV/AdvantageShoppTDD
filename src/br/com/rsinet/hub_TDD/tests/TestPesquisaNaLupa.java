package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageObject.PesquisaNaLupa_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;



public class TestPesquisaNaLupa {
	static ChromeDriver driver = new ChromeDriver();

	@Before
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
	}

	@Test
	public void PesquisaLupa() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaLupa");
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);
		int linha = 3;
		int coluna =0;

		pesq.lupa.click();
		try {
			pesq.busca.sendKeys(ExcelUtils.getCellData(linha++, coluna), Keys.ENTER);
			pesq.buscafecha.click();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.findElement(By.linkText(ExcelUtils.getCellData(linha++, coluna))).click();
			ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);

		} catch (Exception e) {
			ScreenShot.getScreenShots(PrintDiretorio.pesquisaLupa, driver);
			Assert.assertEquals(ExcelUtils.getCellData(linha, coluna), driver.getCurrentUrl());
		}
	}
	@After
	public void fechar() {
		driver.close();

		}
}
