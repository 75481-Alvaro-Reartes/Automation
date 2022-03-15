package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;


public class BaseTest {
	  
	  public static void goToWikiMainPage(WebDriver driver) {
		  driver.get("http://wikipedia.org");
	  }
	  
	  public static void goToDespegarMainPage(WebDriver driver) {
		  driver.get("https://www.despegar.com.ar");
	  }
	
	
	  public static WebDriver LevantarBrowser (String browserName) 
	  {
		  WebDriver driver = null;
		  switch (browserName) {
		  case "CHROME":
		  {
			  System.setProperty("webdriver.chrome.driver", "D:\\Instaladores/chromedriver.exe");
			  Reporter.log("Abro Browser Chrome");
			  driver = new ChromeDriver();
			  break;
		  }
		  case "EXPLORER":
		  {
			  System.setProperty("webdriver.edge.driver", "D:\\Instaladores/msedgedriver.exe");
			  Reporter.log("Abro Browser Edge");
			  driver = new EdgeDriver();
			  break;
		  }
		  case "FIREFOX":
		  {
			  System.setProperty("webdriver.firefox.driver", "D:\\Instaladores/geckodriver.exe");
			  Reporter.log("Abro Browser Firefox");
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
		  driver.manage().window().maximize();
		  return driver;
	  }

}
