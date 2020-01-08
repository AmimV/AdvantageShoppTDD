package Dados;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class criarConta {

	static ChromeDriver driver = new ChromeDriver();
	
	@Before
	public void url() throws InterruptedException {
		
		driver.get("https://www.advantageonlineshopping.com/#/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void CliqueConta() throws InterruptedException {
		driver.findElement(By.id("menuUser")).click();		
		Thread.sleep(2000);
		driver.findElementByXPath("/html/body/login-modal/div/div/div[3]/a[2]").click();
	}
	
	@Test
	public void Preencher() throws Exception {
	ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Contas");
	
	int valor = 0;
	driver.findElement(By.name("usernameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, valor++));
	driver.findElement(By.name("emailRegisterPage")).sendKeys(ExcelUtils.getCellData(1, valor++));
	driver.findElement(By.name("passwordRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 2));
	driver.findElement(By.name("confirm_passwordRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 2));
	driver.findElement(By.name("first_nameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 3));
	driver.findElement(By.name("last_nameRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 4));
	driver.findElement(By.name("phone_numberRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 5));
	
	Select pais = new Select(driver.findElement(By.name("countryListboxRegisterPage")));
	pais.selectByValue(ExcelUtils.getCellData(1, 6));
	
	driver.findElement(By.name("cityRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 7));
	driver.findElement(By.name("addressRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 8));
	driver.findElement(By.name("state_/_province_/_regionRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 9));
	driver.findElement(By.name("postal_codeRegisterPage")).sendKeys(ExcelUtils.getCellData(1, 10));
	driver.findElement(By.name("i_agree")).click();
	driver.findElement(By.id("register_btnundefined")).click();

	}
	
	@After
	public void Encerrar() {

//	driver.quit();
	}
}
