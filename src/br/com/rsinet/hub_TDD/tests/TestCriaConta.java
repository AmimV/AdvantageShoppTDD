package br.com.rsinet.hub_TDD.tests;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import br.com.rsinet.com.HUB_TDD.Excel.Constant;
import br.com.rsinet.com.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.com_TDD.PageObject.*;

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
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/login-modal/div/div/div[3]/a[2]")));
		element.click();
	}

	@Test
	public void Preencher() throws Exception {
		
		CriarConta_Page page = PageFactory.initElements(driver, CriarConta_Page.class);

		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Contas");

		page.userName.sendKeys(ExcelUtils.getCellData(1, 0));
		page.email.sendKeys(ExcelUtils.getCellData(1, 0));
		page.senha.sendKeys(ExcelUtils.getCellData(1, 0));
		page.confirmarSenha.sendKeys(ExcelUtils.getCellData(1, 0));
		page.primeiroNome.sendKeys(ExcelUtils.getCellData(1, 0));
		page.ultimoNome.sendKeys(ExcelUtils.getCellData(1, 0));
		page.ultimoNome.sendKeys(ExcelUtils.getCellData(1, 0));

		Select pais = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
		pais.selectByValue("oisad");

		page.cidade.sendKeys(ExcelUtils.getCellData(1, 7));
		page.endereco.sendKeys(ExcelUtils.getCellData(1, 8));
		page.estadoEMais.sendKeys(ExcelUtils.getCellData(1, 9));
		page.cep.sendKeys(ExcelUtils.getCellData(1, 10));
		page.aceitar .click();
		page.botao.click();
		
		

	}

	@After
	public void Encerrar() {

//	driver.quit();
	}
}
