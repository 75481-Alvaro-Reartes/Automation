import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/*Test de pagina despegar que incorpore DataProviders con dsitintos datos*/
public class DespegarDPTest {

	  @DataProvider (name = "Data Provider Despegar")
	  public Object[][] metodoDP(){
		  return new Object[][] { {"Mendoza, Mendoza, Argentina"},{"San Salvador de Jujuy, Jujuy, Argentina"},{"Villa Carlos Paz, Córdoba, Argentina"},
			   };
	  }  	
	
  @Test(dataProvider = "Data Provider Despegar",description = "Validar sleccionar alojamineto con destino y fechas con 3 adultos y un menor y que figure algo")
  public void validaBsuquedaAlojamientoDespegar(String ciudad) throws Exception{
	  System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
	  WebDriver driver = new EdgeDriver();
	  driver.get("https://www.despegar.com.ar");
	  driver.manage().window().maximize();
	  Thread.sleep(1000);
	  
	  WebElement alojamiento = driver.findElement(By.cssSelector("div.header-products-container>ul>li>a[title ='Alojamientos']"));
	  alojamiento.click();
	  
	 WebElement searchInputOrigen = driver.findElement(By.cssSelector("div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']"));
	  //Assert.assertTrue(searchInputOrigen.isDisplayed());
	 Assert.assertTrue(searchInputOrigen.isDisplayed(), "Input no Visible");
	  searchInputOrigen.click();
	  
	  
	  // ACA COMO HAGOP PARA OMITIR ESOS SLEEPS DE LA BUSQUEDA DE CIUDAD???
	  searchInputOrigen.sendKeys(ciudad);
	  Thread.sleep(3000);
	  searchInputOrigen.sendKeys(Keys.CONTROL);
	  Thread.sleep(3000);
	  //searchInputOrigen.sendKeys(Keys.ENTER);
	  //Thread.sleep(3000);
	  WebElement primerDestino = driver.findElement(By.xpath("//div[@class='ac-container']//li[@class='item']"));
	  primerDestino.click();
	  
	  WebElement fechaDesde = driver.findElement(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']"));
	  fechaDesde.click();
	  Thread.sleep(2000);
	  WebElement fechaDesdeSeleccionado = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '20']"));
	  fechaDesdeSeleccionado.click();
	  
	  WebElement fechaHasta = driver.findElement(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input2']"));
	  fechaHasta.click();
	  Thread.sleep(2000);
	  WebElement fechaHastaSeleccionado = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '23']"));
	  fechaHastaSeleccionado.click();
	  Thread.sleep(2000);
	  
	  WebElement botonAplicar = driver.findElement(By.xpath("//button[@class='sbox5-3-btn -primary -md']"));
	  botonAplicar.click();
	  Thread.sleep(2000);
			  
	  WebElement botonHabitaciones = driver.findElement(By.xpath("//input[@class='sbox5-3-first-input']"));
	  botonHabitaciones.click();
	  Thread.sleep(2000);
	  //driver.close();
	  
	  WebElement btnAgregarAdulto = driver.findElement(By.xpath("//div[@class='distribution__container distribution__type__rooms']//div[@class='sbox5-3-steppers -md']//button[@class='steppers-icon-right stepper__icon']"));
	  btnAgregarAdulto.click();
	  Thread.sleep(1000);
	  
	  WebElement btnAgregarMenor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
	  btnAgregarMenor.click();
	  Thread.sleep(1000);
	  //driver.close();
	  
	  WebElement selectorEdad = driver.findElement(By.xpath("//select[@class='select']"));
	  selectorEdad.click();
	  Thread.sleep(1000);
	  
	  WebElement edadElegida =  driver.findElement(By.xpath("//select[@class='select']//option[text() = '10 años']"));
	  edadElegida.click();
	  Thread.sleep(1000);
	  
	  WebElement btnAplicarHabitacion = driver.findElement(By.xpath("//div[@class='distribution__container distribution__type__rooms']//a[@class='sbox5-3-btn -md -primary']"));
	  btnAplicarHabitacion.click();
	  Thread.sleep(1000);
	  

	  
	  WebElement btnBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']//em[@class='btn-text'][text() = 'Buscar']"));
	  btnBuscar.click();
	  
	  WebElement tituloPreViaje = driver.findElement(By.xpath("//div[@class='results-banner-inner']//h6[@class='main-text']"));
	  Assert.assertTrue(tituloPreViaje.isDisplayed());
	  System.out.println("Texto encontrado pre Viaje: "+ tituloPreViaje.getText());
	  
	  Thread.sleep(5000);
	  driver.close();
  }
}


