package com.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DespegarResultsPage {
	@FindBy(xpath="//div[@class='text-container']/h6[@class='main-text']")
	WebElement tituloPreViaje;

private WebDriver driver = null;
	
	public DespegarResultsPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean tituloPreViajeVisible() {
		// TODO Auto-generated method stub
		return this.tituloPreViaje.isDisplayed();
	}
}
