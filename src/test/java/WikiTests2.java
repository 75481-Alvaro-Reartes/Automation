import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.WikiHomePage;
import com.selenium.pages.WikiResultsPage;

public class WikiTests2 extends BaseTest  {
  @Test(description = "Validar que las busquedas en Wikipedia funciona")
  public void validarBusquedaWikipedia() throws Exception{
	  //inicializo el driver
	  WebDriver driver = BaseTest.LevantarBrowser("EXPLORER");
	  //metodo de la calse base la cual me lleva hasta la apgina de wikiepdia incial
	  BaseTest.goToWikiMainPage(driver);
	  //creo el objeto de tipo home donde estan definidos metodos de visibilidad y de ingreso por teclado y devolucion de un nuevo
	  //objeto de la pagina a la cual se redirecciono WikiResult
	  WikiHomePage homePage = new WikiHomePage(driver);
	  //homePage llama a su metodo de visibilidad
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no es visible");
	  // objeto de pagina resultado, que lo retorna el objeto homePage 
	  WikiResultsPage resultsPage = homePage.searchText("Talleres De Cordoba");
	  //resultsPage con el metodo si el titulo es visible
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no es visible");
	  
	  resultsPage.cerrarPagina();
  }
}
