package testes.eplayers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteNavegaEplayers {
	
ChromeDriver driver;
			
	@Before
	
	public void PreTeste( ) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Micro\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:4200");
		driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]")).click();
		
	}
	@Test
	public void TesteNagacao() {

		// Criar os WebElements
		WebElement inputEmail = driver.findElement(By.id("usuario"));
		WebElement inputSenha = driver.findElement(By.id("senha"));
		WebElement inputSubmit = driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/button[1]"));
		String[] listaEmails = { "jose@email.com", "eduardo@email.com", "email sem formato", "eduardo@email.com",
				"eduardo@email.com" };
		String[] listaSenhas = { "senhaum", "outrasenha", "senhaerrada", "12345678", "123" };

		for (int tentativas = 0; tentativas < listaSenhas.length; tentativas++) {

			try {
				// limpar os campos
				inputEmail.clear();
				inputSenha.clear();

				
				// preencher os campos 
				inputEmail.sendKeys(listaEmails[tentativas]);
				inputSenha.sendKeys(listaSenhas[tentativas]);
				inputSubmit.click();
				
				
				// espera 3 segundos
				Thread.sleep(3000);

			} catch (InterruptedException error) {
				error.printStackTrace();
			}

		}

	}

	@After
	public void FinalizarTeste() {
		
		try {
			//espera 2 segundos
			Thread.sleep(2000);//
			driver.quit();
		} catch( Exception error ) {
			error.printStackTrace();
		}
		
	}

}