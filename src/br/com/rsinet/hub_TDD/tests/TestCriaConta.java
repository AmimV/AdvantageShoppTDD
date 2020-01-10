package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import br.com.rsinet.com.HUB_TDD.Excel.Constant;
import br.com.rsinet.com.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.com_TDD.PageObject.*;
import br.com.rsinet.com.HUB_TDD.Excel.*;

public class TestCriaConta {

	static ChromeDriver driver = new ChromeDriver();

	@Before
	public void url() throws InterruptedException {
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void CliqueConta() throws InterruptedException {
		Home_Page inicio = PageFactory.initElements(driver, Home_Page.class);
		
		inicio.Menu.click();
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",Home_Page.CreateNewAcount);
		
	}

	@Test
	public void Preencher() throws Exception {

		int coluna = 0;
		int linha = 1;

		CriarConta_Page page = PageFactory.initElements(driver, CriarConta_Page.class);
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Contas");

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

		ScreenShot.getScreenShots(driver);
		
		
	}
	@After
	public void Encerrar() {

//	driver.quit();
	}
}
