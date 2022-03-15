import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DespegarResultsPage;
import com.selenium.pages.WikiResultsPage;


public class DespegarTest2 {
  @Test(description = "Validar busqueda de alojamineto en ciudad, con adultos y menores")
  public void validaBsuquedaAlojamientoDespegar() throws Exception{
	  WebDriver driver = BaseTest.LevantarBrowser("EXPLORER");
	  BaseTest.goToDespegarMainPage(driver);
	  
	  DespegarHomePage homePage = new DespegarHomePage(driver);
	  homePage.alojamientoClick();
	  
	  Assert.assertTrue(homePage.searchInputOrigenVisible(), "search Input Ciudad No visible");
	  homePage.searchInputOrigenIngresarCiudad("San Salvador de Jujuy, Jujuy, Argentina");
	  
	  Assert.assertTrue(homePage.fechaDesdeVisible(),"No hay fecha desde visible");
	  homePage.clikFechaDesde();
	  
	  homePage.elegirFechaDesde();
	  
	  Assert.assertTrue(homePage.fechaHastaVisible(),"No hay fecha hasta visible");
	  homePage.clikFechaHasta();
	  homePage.elegirFechaHasta();

	  
	  Assert.assertTrue(homePage.botonAplicarVisible(),"No es visible el boton aplicar");
	  homePage.botonAplicarClick();
	  
	  
	  homePage.btnHabitacionesClick();
	  homePage.btnAgregarAdultoClickear();
	  
	  homePage.btnAgregarMenorClickear();
	  
	  Assert.assertTrue(homePage.selectorEdadVisible(),"No es posible ver el seelctor edad");
	  homePage.elegirEdad();
	  
      homePage.btnAplicarHabitacionClickear();
	  
	  DespegarResultsPage resultsPage = homePage.buscarAlojamiento();
	  
	  Assert.assertTrue(resultsPage.tituloPreViajeVisible(),"No es visible el titulo previaje");
	  driver.close();
  }
}
