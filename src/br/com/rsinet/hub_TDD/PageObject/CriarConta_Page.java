package br.com.rsinet.HUB_TDD.PageObject;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class CriarConta_Page {
	
 @FindBy(how = How.NAME, using = "usernameRegisterPage")
  public WebElement userName;
 
 @FindBy(how = How.NAME, using = "emailRegisterPage")
 public WebElement email;
 
 @FindBy(how = How.NAME, using = "passwordRegisterPage")
 public WebElement senha;
 
 @FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
 public WebElement confirmarSenha ;
 
 @FindBy(how = How.NAME, using = "first_nameRegisterPage")
 public WebElement primeiroNome;
 
 @FindBy(how = How.NAME, using = "last_nameRegisterPage")
 public WebElement ultimoNome;
 
 @FindBy(how = How.NAME, using = "phone_numberRegisterPage")
 public WebElement telefone;
 
 @FindBy(how = How.NAME, using = "cityRegisterPage")
 public WebElement cidade;
 
 @FindBy(how = How.NAME, using = "addressRegisterPage")
 public WebElement endereco;
 
 @FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
 public WebElement estadoEMais;
 
 @FindBy(how = How.NAME, using = "postal_codeRegisterPage")
 public WebElement cep;
 
 @FindBy(how = How.NAME, using = "i_agree")
 public WebElement aceitar;
 
 @FindBy(how = How.ID, using = "register_btnundefined")
 public WebElement botao;
  
 @FindBy(how =  How.NAME, using = "countryListboxRegisterPage")
 public  WebElement pais;
 

 }
