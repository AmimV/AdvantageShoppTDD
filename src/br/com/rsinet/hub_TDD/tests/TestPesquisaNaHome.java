package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageObject.PesquisaNaHome_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;
import junit.framework.Assert;

public class TestPesquisaNaHome {

	static ChromeDriver driver = new ChromeDriver();

	@Before
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
	}

	@Test
	public void PesquisaLupa() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
		PesquisaNaHome_Page pesq = PageFactory.initElements(driver, PesquisaNaHome_Page.class);
		
		pesq.tablet.click();
		try {
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			driver.findElement(By.linkText(ExcelUtils.getCellData(0, 1))).click();
			
		} catch (Exception e) {
			System.out.println("Falha");
		}
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		Assert.assertEquals(ExcelUtils.getCellData(1, 1), driver.getCurrentUrl());
	}
	
	@After
	public void fechar() {
		driver.close();
	}
}
