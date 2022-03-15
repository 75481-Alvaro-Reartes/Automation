import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
/*Crear un test en despegar.com que seleccione alojamiento, cargue un destino y fechas, 
 * seleccione
3 adultos y 1 menor, haga la busqueda, clickee el primer resultado y valide algo 
de la pagina
resultante*/
public class DespegarTest {
  @Test(description = "Validar sleccionar alojamineto con destino y fechas con 3 adultos y un menor y que figure algo")
  public void validaBsuquedaAlojamientoDespegar() throws Exception{
	  //System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
	  
	  WebDriver driver = null;
	  driver = DriverFactory.LevantarBrowser(driver, "CHROME", "https://www.despegar.com.ar");
	  //driver.get("https://www.despegar.com.ar");
	  //driver.manage().window().maximize();
	  
	  //Thread.sleep(1000);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.header-products-container>ul>li>a[title ='Alojamientos']")));
	  WebElement alojamiento = driver.findElement(By.cssSelector("div.header-products-container>ul>li>a[title ='Alojamientos']"));
	  alojamiento.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")));
	  WebElement searchInputOrigen = driver.findElement(By.cssSelector("div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']"));
	  //Assert.assertTrue(searchInputOrigen.isDisplayed());
	  wait.until(ExpectedConditions.elementToBeClickable(searchInputOrigen));
	  searchInputOrigen.click();
	  
	  
	  searchInputOrigen.sendKeys("San Salvador de Jujuy, Jujuy, Argentina");
	  
	  Thread.sleep(1000);
	  searchInputOrigen.sendKeys(Keys.CONTROL);
	  Thread.sleep(3000);
	  //searchInputOrigen.sendKeys(Keys.ENTER);
	  //Thread.sleep(3000);
	  WebElement primerDestino = driver.findElement(By.xpath("//div[@class='ac-container']//li[@class='item']"));
	  wait.until(ExpectedConditions.elementToBeClickable(primerDestino));
	  primerDestino.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']")));
	  WebElement fechaDesde = driver.findElement(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']"));
	  wait.until(ExpectedConditions.elementToBeClickable(fechaDesde));
	  fechaDesde.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '26']")));
	  WebElement fechaDesdeSeleccionado = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '26']"));
	  wait.until(ExpectedConditions.elementToBeClickable(fechaDesdeSeleccionado ));
	  fechaDesdeSeleccionado.click();
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input2']")));
	  WebElement fechaHasta = driver.findElement(By.xpath("//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input2']"));
	  wait.until(ExpectedConditions.elementToBeClickable(fechaHasta ));
	  fechaHasta.click();
	  
	  //Thread.sleep(2000);
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '28']")));
	  WebElement fechaHastaSeleccionado = driver.findElement(By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '28']"));
	  wait.until(ExpectedConditions.elementToBeClickable(fechaHastaSeleccionado));
	  fechaHastaSeleccionado.click();
	  //Thread.sleep(2000);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='sbox5-3-btn -primary -md']")));
	  WebElement botonAplicar = driver.findElement(By.xpath("//button[@class='sbox5-3-btn -primary -md']"));
	  wait.until(ExpectedConditions.elementToBeClickable(botonAplicar ));
	  botonAplicar.click();
	  //Thread.sleep(2000);
			  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='sbox5-3-first-input']")));
	  WebElement botonHabitaciones = driver.findElement(By.xpath("//input[@class='sbox5-3-first-input']"));
	  wait.until(ExpectedConditions.elementToBeClickable(botonHabitaciones ));
	  botonHabitaciones.click();
	 // Thread.sleep(2000);
	  //driver.close();
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='distribution__container distribution__type__rooms']//div[@class='sbox5-3-steppers -md']//button[@class='steppers-icon-right stepper__icon']")));
	  WebElement btnAgregarAdulto = driver.findElement(By.xpath("//div[@class='distribution__container distribution__type__rooms']//div[@class='sbox5-3-steppers -md']//button[@class='steppers-icon-right stepper__icon']"));
	  wait.until(ExpectedConditions.elementToBeClickable(btnAgregarAdulto ));
	  btnAgregarAdulto.click();
	  //Thread.sleep(1000);
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right")));
	  WebElement btnAgregarMenor = driver.findElement(By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right"));
	  wait.until(ExpectedConditions.elementToBeClickable(btnAgregarMenor ));
	  btnAgregarMenor.click();
	  //Thread.sleep(1000);
	  //driver.close();
	  
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='select']")));
	  WebElement selectorEdad = driver.findElement(By.xpath("//select[@class='select']"));
	  wait.until(ExpectedConditions.elementToBeClickable(selectorEdad ));
	  selectorEdad.click();
	  //Thread.sleep(1000);
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@class='select']//option[text() = '10 años']")));
	  WebElement edadElegida =  driver.findElement(By.xpath("//select[@class='select']//option[text() = '10 años']"));
	  wait.until(ExpectedConditions.elementToBeClickable(edadElegida ));
	  edadElegida.click();
	  //Thread.sleep(1000);
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='distribution__container distribution__type__rooms']//a[@class='sbox5-3-btn -md -primary']")));
	  WebElement btnAplicarHabitacion = driver.findElement(By.xpath("//div[@class='distribution__container distribution__type__rooms']//a[@class='sbox5-3-btn -md -primary']"));
	  wait.until(ExpectedConditions.elementToBeClickable(btnAplicarHabitacion));
	  btnAplicarHabitacion.click();
	  //Thread.sleep(1000);
	  

	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']//em[@class='btn-text'][text() = 'Buscar']")));
	  WebElement btnBuscar = driver.findElement(By.xpath("//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']//em[@class='btn-text'][text() = 'Buscar']"));
	  wait.until(ExpectedConditions.elementToBeClickable(btnBuscar));
	  btnBuscar.click();
	  
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='text-container']/h6[@class='main-text']")));
	  WebElement tituloPreViaje = driver.findElement(By.xpath("//div[@class='text-container']/h6[@class='main-text']"));
	  Assert.assertTrue(tituloPreViaje.isDisplayed(), "Elemento no visible");
	  System.out.println("Texto encontrado pre Viaje: "+ tituloPreViaje.getText());
	  
	  
	  driver.close();
  }
}

