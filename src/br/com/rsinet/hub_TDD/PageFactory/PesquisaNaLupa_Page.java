package br.com.rsinet.HUB_TDD.PageFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;

public class PesquisaNaLupa_Page {

	@FindBy(how = How.ID, using = "menuSearch")
	public WebElement lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	public WebElement busca;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[4]/a/div/div[1]/div/div/div/img")
	public WebElement buscafecha;
		
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/label/span")
	public WebElement SemResultado;

	public void PesqLupa(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaLupa");

		lupa.click();
		busca.sendKeys(ExcelUtils.getCellData(0, 0), Keys.ENTER);
		buscafecha.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.partialLinkText(ExcelUtils.getCellData(1, 0))).click();	

	}
	
	public void BuscarProdutoInexistente(WebDriver driver) throws Exception {
		ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaLupa");
		
		lupa.click();
		
		busca.sendKeys(ExcelUtils.getCellData(0, 1), Keys.ENTER);
				
	}
	
}
