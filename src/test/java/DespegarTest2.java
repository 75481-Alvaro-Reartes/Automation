import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.DespegarHomePage;
import com.selenium.pages.DespegarResultsPage;
import com.selenium.pages.WikiHomePage;
import com.selenium.pages.WikiResultsPage;


public class DespegarTest2 {

	public WebDriver driver = null;
	public DespegarHomePage homePage = null;
	
	@BeforeMethod
	  public void setup(ITestContext context) {
		  String navTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
		  String navegador = navTestSuite != null ? navTestSuite : "EDGE";
		  driver = BaseTest.LevantarBrowser(navegador);
		  BaseTest.goToDespegarMainPage(driver);
		  homePage = new DespegarHomePage(driver);
	  }

  @Test( description = "Validar busqueda de alojamineto en ciudad, con adultos y menores")
  public void validaBsuquedaAlojamientoDespegar() throws Exception{
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

  }
  
  @AfterMethod
  public void endSetup() {
	  driver.close();
  }
  
}
