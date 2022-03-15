package com.selenium.driver;



import org.testng.annotations.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;

public class DriverFactory {
	private enum browsers{
		EXPLORER, SAFARI, FIREFOX, CHROME
	};
  //@Test
  public static WebDriver LevantarBrowser (WebDriver driver, String browserName, String URL) 
  {
	  switch (browsers.valueOf(browserName)) {
	  case CHROME:
	  {
		  System.setProperty("webdriver.chrome.driver", "D:\\Instaladores/chromedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new ChromeDriver();
		  break;
	  }
	  case EXPLORER:
	  {
		  System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  case FIREFOX:
	  {
		  System.setProperty("webdriver.firefox.driver", "D:\\Instaladores/geckodriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new FirefoxDriver();
		  break;
	  }
	  default:
		  Reporter.log("No selecciono ningun browser correcto, se le asginara edge");
		  System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
		  Reporter.log("Abro Browser");
		  driver = new EdgeDriver();
		  break;
	  }
	  driver.get(URL);
	  driver.manage().window().maximize();
	  return driver;
  }
}
