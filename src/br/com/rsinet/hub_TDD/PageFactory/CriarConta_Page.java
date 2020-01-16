package br.com.rsinet.HUB_TDD.PageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;
 
public class CriarConta_Page {
	
 @FindBy(how = How.NAME, using = "usernameRegisterPage")
  private static WebElement userName;
 
 @FindBy(how = How.NAME, using = "emailRegisterPage")
 private static WebElement email;
 
 @FindBy(how = How.NAME, using = "passwordRegisterPage")
 private static WebElement senha;
 
 @FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
 private static WebElement confirmarSenha ;
 
 @FindBy(how = How.NAME, using = "first_nameRegisterPage")
 private static WebElement primeiroNome;
 
 @FindBy(how = How.NAME, using = "last_nameRegisterPage")
 private static WebElement ultimoNome;
 
 @FindBy(how = How.NAME, using = "phone_numberRegisterPage")
 private static WebElement telefone;
 
 @FindBy(how = How.NAME, using = "cityRegisterPage")
 private static WebElement cidade;
 
 @FindBy(how = How.NAME, using = "addressRegisterPage")
 private static WebElement endereco;
 
 @FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
 private static WebElement estadoEMais;
 
 @FindBy(how = How.NAME, using = "postal_codeRegisterPage")
 private static WebElement cep;
 
 @FindBy(how = How.NAME, using = "i_agree")
 private static WebElement aceitar;
 
 @FindBy(how = How.ID, using = "register_btnundefined")
 private static WebElement botao;
  
 @FindBy(how =  How.NAME, using = "countryListboxRegisterPage")
 private static  WebElement pais;
 
 public void CriaAcc(WebDriver driver) throws Exception {
	 ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "Contas");
	

	 PageFactory.initElements(driver, CriarConta_Page.class);
	 
		int coluna = 0;
		int linha = 1;

		userName.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		email.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		senha.sendKeys(ExcelUtils.getCellData(linha, coluna));
		confirmarSenha.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		primeiroNome.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		ultimoNome.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		telefone.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		pais.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		cidade.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		endereco.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		estadoEMais.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		cep.sendKeys(ExcelUtils.getCellData(linha, coluna++));
		aceitar.click();
		botao.click();
	 
 
 }


 }
