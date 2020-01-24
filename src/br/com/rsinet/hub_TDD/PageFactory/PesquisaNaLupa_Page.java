package br.com.rsinet.HUB_TDD.PageFactory;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
import br.com.rsinet.HUB_TDD.Excel.MassaDeDadosPesqLupa;

public class PesquisaNaLupa_Page {
	MassaDeDadosPesqLupa celula = new MassaDeDadosPesqLupa();

	@FindBy(how = How.ID, using = "menuSearch")
	public WebElement lupa;

	@FindBy(how = How.ID, using = "autoComplete")
	public WebElement busca;

	@FindBy(how = How.XPATH, using = "/html/body/header/nav/ul/li[4]/a/div/div[1]/div/div/div/img")
	public WebElement buscafecha;

	@FindBy(how = How.XPATH, using = "/html/body/div[3]/section/article/div[3]/div/label/span")
	public WebElement SemResultado;

	public void ClicarLupa() {

		lupa.click();
	}

	public void BuscaProduto() throws Exception {
		busca.sendKeys(celula.PesquisaProduto01(), Keys.ENTER);
	}
	
	public void BuscaProdutoInexistente(WebDriver driver) throws Exception {
		busca.sendKeys(celula.ProdutoInvalido(), Keys.ENTER);
		JavascriptExecutor js;
		js = (JavascriptExecutor) driver;
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000)");
	}

	public void FechaLupa() {
		buscafecha.click();
	}

	public void ClicarEmProduto(WebDriver driver) throws Exception {
	driver.findElement(By.partialLinkText(celula.ClicaProduto01())).click();
	}

}
