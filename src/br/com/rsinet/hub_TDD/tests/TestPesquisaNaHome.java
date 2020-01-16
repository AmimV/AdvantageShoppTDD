package br.com.rsinet.HUB_TDD.tests;


import java.util.concurrent.TimeUnit;



import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageFactory.PesquisaNaHome_Page;
import br.com.rsinet.HUB_TDD.ScreenShot.PrintDiretorio;
import br.com.rsinet.HUB_TDD.ScreenShot.ScreenShot;



public class TestPesquisaNaHome {

	ExtentReports extent;
	ExtentTest logger;
	static ChromeDriver driver = new ChromeDriver();

	@BeforeMethod
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
	
	}

	@Test(priority =0)
	public void PesquisaHome() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
		PesquisaNaHome_Page pesq = PageFactory.initElements(driver, PesquisaNaHome_Page.class);
		
		pesq.tablet();
			
		//Esperar 5 segundos para achar um elemento que está na home para tirar a ScreenShot.
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
			driver.findElement(By.partialLinkText(ExcelUtils.getCellData(0, 0))).click();
	
		ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		     Assert.assertEquals("https://www.advantageonlineshopping.com/#/product/18", driver.getCurrentUrl());
	}
	
	@Test(priority =1)
	public void PesquisaHomeFalha() throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
		PesquisaNaHome_Page pesq = PageFactory.initElements(driver, PesquisaNaHome_Page.class);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		pesq.tablet();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		try {
		driver.findElement(By.linkText(ExcelUtils.getCellData(0, 1))).click();
		} catch(Exception e) {
			
			ScreenShot.getScreenShots(PrintDiretorio.pesquisaHome, driver);
		}
		Assert.assertEquals("https://www.advantageonlineshopping.com/#/category/Tablets/3", driver.getCurrentUrl());
	}
	
	@AfterTest
	public void fechar() {
		driver.close();
	}
}
