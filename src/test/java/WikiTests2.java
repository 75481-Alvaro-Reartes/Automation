import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.selenium.pages.BaseTest;
import com.selenium.pages.WikiHomePage;
import com.selenium.pages.WikiResultsPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;


public class WikiTests2 extends BaseTest  {
	
  public WebDriver driver = null;
  public WikiHomePage homePage;
	
  @BeforeMethod
  public void setup(ITestContext context) {
	  String navTestSuite = context.getCurrentXmlTest().getParameter("Navegador");
	  String navegador = navTestSuite != null ? navTestSuite : "EDGE";
	  driver = BaseTest.LevantarBrowser(navegador);
	  BaseTest.goToWikiMainPage(driver);
	  homePage = new WikiHomePage(driver);
  }
  @Test(description = "Validar que las busquedas en Wikipedia funciona")
  public void validarBusquedaWikipedia() throws Exception{
	  Assert.assertTrue(homePage.searchInputEsVisible(), "El input no es visible"); 
	  WikiResultsPage resultsPage = homePage.searchText("Talleres De Cordoba");
	  Assert.assertTrue(resultsPage.tituloEsVisible(), "El titulo no es visible");
  }
  
  @AfterMethod
  public void endSetup() {
	  driver.close();
  }
}
