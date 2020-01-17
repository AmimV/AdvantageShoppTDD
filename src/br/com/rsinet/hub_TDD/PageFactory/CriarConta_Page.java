package br.com.rsinet.HUB_TDD.PageFactory;


import br.com.rsinet.HUB_TDD.Excel.MassaDeDadosNovaConta;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CriarConta_Page {
	MassaDeDadosNovaConta celula = new MassaDeDadosNovaConta();

	@FindBy(how = How.NAME, using = "usernameRegisterPage")
	private WebElement userName;

	@FindBy(how = How.NAME, using = "emailRegisterPage")
	private WebElement email;

	@FindBy(how = How.NAME, using = "passwordRegisterPage")
	private WebElement senha;

	@FindBy(how = How.NAME, using = "confirm_passwordRegisterPage")
	private WebElement confirmarSenha;

	@FindBy(how = How.NAME, using = "first_nameRegisterPage")
	private WebElement primeiroNome;

	@FindBy(how = How.NAME, using = "last_nameRegisterPage")
	private WebElement ultimoNome;

	@FindBy(how = How.NAME, using = "phone_numberRegisterPage")
	private WebElement telefone;

	@FindBy(how = How.NAME, using = "cityRegisterPage")
	private WebElement cidade;

	@FindBy(how = How.NAME, using = "addressRegisterPage")
	private WebElement endereco;

	@FindBy(how = How.NAME, using = "state_/_province_/_regionRegisterPage")
	private WebElement estadoEMais;

	@FindBy(how = How.NAME, using = "postal_codeRegisterPage")
	private WebElement cep;

	@FindBy(how = How.NAME, using = "i_agree")
	private WebElement aceitar;

	@FindBy(how = How.ID, using = "register_btnundefined")
	private WebElement botao;

	@FindBy(how = How.NAME, using = "countryListboxRegisterPage")
	private WebElement pais;

	public void Usuario() throws Exception {

		//PageFactory.initElements(driver, CriarConta_Page.class);

		userName.sendKeys(celula.Usuario());
	}

	public void email() throws Exception {
		email.sendKeys(celula.Email());
	}

	public void senha() throws Exception {
		senha.sendKeys(celula.Senha());
	}

	public void ConfirmarSenha() throws Exception {
		confirmarSenha.sendKeys(celula.ConfirmarSenha());
	}

	public void PrimeiroNome() throws Exception {
		primeiroNome.sendKeys(celula.PrimeiroNome());
	}

	public void UltimoNome() throws Exception {
		ultimoNome.sendKeys(celula.UltimoNome());
	}

	public void Telefone() throws Exception {
		telefone.sendKeys(celula.Telefone());
	}

	public void Pais() throws Exception {
		pais.sendKeys(celula.Pais());
	}

	public void Cidade() throws Exception {
		cidade.sendKeys(celula.Cidade());
	}

	public void Endereco() throws Exception {
		endereco.sendKeys(celula.Endereco());
	}

	public void Estado() throws Exception {
		estadoEMais.sendKeys(celula.Estado());
	}

	public void Cep() throws Exception {
		cep.sendKeys(celula.Cep());
	}

	public void Aceitar() {
		aceitar.click();
	}

	public void botao() {
		botao.click();
	}
}
