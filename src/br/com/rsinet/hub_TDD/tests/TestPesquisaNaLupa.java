package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.com.HUB_TDD.Excel.Constant;
import br.com.rsinet.com.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.com.HUB_TDD.Excel.ScreenShot;
import br.com.rsinet.com_TDD.PageObject.PesquisaNaLupa_Page;

public class TestPesquisaNaLupa {
	static ChromeDriver driver = new ChromeDriver();

	@Before
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com");
		driver.manage().window().maximize();
	}

	@Test
	public void PesquisaLupa() throws Exception {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "BuscaLupa");
		PesquisaNaLupa_Page pesq = PageFactory.initElements(driver, PesquisaNaLupa_Page.class);

		String produto = ExcelUtils.getCellData(1, 1);

		pesq.lupa.click();
		pesq.busca.sendKeys(ExcelUtils.getCellData(0, 0), Keys.ENTER);
		pesq.buscafecha.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(produto)).click();
		ScreenShot.getSSLupa(driver);
	}
}
