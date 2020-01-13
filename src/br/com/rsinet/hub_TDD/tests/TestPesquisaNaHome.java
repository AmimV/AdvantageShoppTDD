package br.com.rsinet.HUB_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.PageObject.PesquisaNaHome_Page;


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
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.linkText(ExcelUtils.getCellData(1, 0))).click();
		
}
}
