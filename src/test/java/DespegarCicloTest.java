import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DespegarCicloTest {
	@Test(description = "Validar Clickear cad boton de la barra superior de la apgina de despegar.com")
  public void validarBotonesConCiclo() throws Exception{
		System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
		  WebDriver driver = new EdgeDriver();
		  driver.get("https://www.despegar.com.ar");
		  driver.manage().window().maximize();
		  Thread.sleep(1000);
		  
		  List<WebElement> listaElementos = driver.findElements(By.xpath("//ul[@class='header-list-products']/li"));
		  for(WebElement elemento : listaElementos) {
			  //WebElement aElemento = elemento.findElement(By.xpath("//a[@title]"));
			  //aElemento.click();
			  System.out.print(elemento.getText() + " ");
			  Assert.assertTrue(elemento.isDisplayed());
			  Thread.sleep(2000);
		  }
		  driver.close();  
  }
}