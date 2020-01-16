package br.com.rsinet.HUB_TDD.PageFactory;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PesquisaNaHome_Page {

	@FindBy(how = How.ID, using = "tabletsTxt")
	private static WebElement tablets;

	public void tablet() {
		tablets.click();
	}
}