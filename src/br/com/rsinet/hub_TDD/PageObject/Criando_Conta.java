package br.com.rsinet.HUB_TDD.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.HUB_TDD.Excel.Diretorio;
import br.com.rsinet.HUB_TDD.Excel.ExcelUtils;

public class Criando_Conta {
	
	public void Preenchendo (WebDriver driver) throws Exception {
	ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "Contas");
	CriarConta_Page page = PageFactory.initElements(driver, CriarConta_Page.class);
	
	int coluna = 0;
	int linha = 1;

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
	
	}
}
