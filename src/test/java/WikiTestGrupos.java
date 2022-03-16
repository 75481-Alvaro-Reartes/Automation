import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.WikiHomePage;
import com.selenium.pages.WikiResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class WikiTestGrupos extends BaseTest  {
	
  public WebDriver driver = null;
  public WikiHomePage homePage;
	
  @BeforeMethod(alwaysRun=true)
  public void setup(ITestContext context) {
	  String navTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
	  String navegador = navTestSuite != null ? navTestSuite : "CHROME";
	  driver = BaseTest.LevantarBrowser(navegador);
	  BaseTest.goToWikiMainPage(driver);
	  homePage = new WikiHomePage(driver);
  }
  @Test(groups = {"grupo_1"},description = "Validar que las busquedas en Wikipedia funciona")
  public void validarBusquedaWikipediaG1() throws Exception{
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no es visible"); 
	  WikiResultsPage resultsPage = homePage.searchText("Talleres De Cordoba");
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no es visible");
  }
  @Test(groups = {"grupo_2"},description = "Validar que las busquedas en Wikipedia funciona")
  public void validarBusquedaWikipediaG2() throws Exception{
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no es visible"); 
	  WikiResultsPage resultsPage = homePage.searchText("Belgrano De Cordoba");
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no es visible");
  }
  
  @Test(groups = {"grupo_1","grupo_2"},description = "Validar que las busquedas en Wikipedia funciona")
  public void validarBusquedaWikipediaG3() throws Exception{
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no es visible"); 
	  WikiResultsPage resultsPage = homePage.searchText("Instituto De Cordoba");
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no es visible");
  }
  
  @AfterMethod(alwaysRun=true)
  public void endSetup() {
	  driver.close();
  }
}

