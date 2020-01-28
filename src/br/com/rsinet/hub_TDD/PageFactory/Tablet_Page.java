package br.com.rsinet.hub_TDD.PageFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import br.com.rsinet.hub_TDD.Excel.MassaDeDadosPesqHome;

public class Tablet_Page {
	private WebDriver driver;
	MassaDeDadosPesqHome celula = new MassaDeDadosPesqHome();
	
	public Tablet_Page(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "accordionAttrib0")
	private WebElement Display;

	@FindBy(how = How.ID, using = "display_0")
	private WebElement spec1;

	@FindBy(how = How.ID, using = "accordionAttrib1")
	private WebElement processador;
	
	@FindBy(how = How.ID, using = "processor_1")
	private WebElement Atom_x5;
	
	
	public void Hp_Pro() throws Exception {
		driver.findElement(By.partialLinkText(celula.HP_Pro())).click();

	}
	
	public void tela () {
		Display.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		spec1.click();
		Display.click();
	}
	public void Processador () {
	     JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 1000)");
		processador.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Atom_x5.click();
		processador.click();
	}


}
