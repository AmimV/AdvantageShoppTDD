package br.com.rsinet.HUB_TDD.tests;


import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageObject.PesquisaNaHome_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;
import junit.framework.Assert;


@SuppressWarnings("deprecation")
public class TestPesquisaNaHome {

	static ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
	
	}

	@Test(priority =0)
	public void PesquisaLupa() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
		PesquisaNaHome_Page pesq = PageFactory.initElements(driver, PesquisaNaHome_Page.class);
		
		pesq.tablet.click();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			driver.findElement(By.linkText(ExcelUtils.getCellData(0, 0))).click();
	
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		     Assert.assertEquals(ExcelUtils.getCellData(1, 0), driver.getCurrentUrl());
	}
	
	@Test(priority =1)
	public void PesquisaLupaFalha() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
		PesquisaNaHome_Page pesq = PageFactory.initElements(driver, PesquisaNaHome_Page.class);
		
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		pesq.tablet.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		try {
		driver.findElement(By.linkText(ExcelUtils.getCellData(0, 1))).click();
		} catch(Exception e) {
			
			ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		}
		Assert.assertEquals(ExcelUtils.getCellData(1, 1), driver.getCurrentUrl());
	}
	
	@AfterTest
	public void fechar() {
		driver.close();
	}
}
