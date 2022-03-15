import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.driver.DriverFactory;

public class WikiTests1 {
	
	@Test(description = "Validar que las busquedas en Wikipedia funcionan")
	public void ValidarBusquedaWikipedia() throws Exception {
		WebDriver driver = null;
     	driver = DriverFactory.LevantarBrowser( driver, "EXPLORER", "http://wikipedia.org");
        WebDriverWait wait = new WebDriverWait(driver, 30);
		    
		    
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchInput")));    
	    WebElement searchInput = driver.findElement(By.id("searchInput"));
	    Assert.assertTrue(searchInput.isDisplayed());
	    searchInput.sendKeys("Selenium");
	    searchInput.submit();
	    //Thread.sleep(2000);
	    
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstHeading")));
	    WebElement tituloResultado = driver.findElement(By.id("firstHeading"));
	    System.out.println("Texto encontrado "+ tituloResultado.getText());
	    Assert.assertTrue(tituloResultado.isDisplayed());
	    driver.close();
	}
}