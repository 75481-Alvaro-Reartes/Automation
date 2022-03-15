package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DespegarHomePage  {

	@FindBy (css="div.header-products-container>ul>li>a[title ='Alojamientos']")
	WebElement alojamiento;
	@FindBy (css="div.input-container>input[placeholder='Ingresá una ciudad, alojamiento o punto de interés']")
	WebElement searchInputOrigen;
	@FindBy (xpath="//div[@class='ac-container']//li[@class='item']")
	WebElement primerDestino;
	@FindBy (xpath="//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input1']")
	WebElement fechaDesde;
	@FindBy (xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '28']")
	WebElement fechaDesdeSeleccionado;
	@FindBy (xpath="//div[@id='searchbox-sbox-box-hotels']//div[@class='sbox5-box-dates-checkbox-container']//div[@class='sbox5-dates-input2']")
	WebElement fechaHasta;
	@FindBy (xpath="//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid' or @class='sbox5-monthgrid sbox5-compact-view'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text() = '29']")
	WebElement fechaHastaSeleccionado;
	@FindBy (xpath="//button[@class='sbox5-3-btn -primary -md']")
	WebElement botonAplicar;
	@FindBy (xpath="//input[@class='sbox5-3-first-input']")
	WebElement botonHabitaciones;
	@FindBy (css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(1) button.steppers-icon-right")
	WebElement btnAgregarAdulto;
	@FindBy (css="div.sbox5-floating-tooltip-opened div.stepper__distribution_container>div:nth-child(2) button.steppers-icon-right")
	WebElement btnAgregarMenor;
	@FindBy (xpath="//select[@class='select']")
	WebElement selectorEdad;
	@FindBy (xpath="//select[@class='select']//option[text() = '10 años']")
	WebElement edadElegida;
	@FindBy (xpath="//div[@class='distribution__container distribution__type__rooms']//a[@class='sbox5-3-btn -md -primary']")
	WebElement btnAplicarHabitacion;
	@FindBy (xpath="//button[@class='sbox5-box-button-ovr sbox5-3-btn -secondary -icon -lg']//em[@class='btn-text'][text() = 'Buscar']")
	WebElement btnBuscar;
	
	
	private WebDriver driver = null;
	private WebDriverWait wait = null;
	
	public DespegarHomePage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, 10);
	}
	
	public void alojamientoClick() {
		wait.until(ExpectedConditions.elementToBeClickable(this.alojamiento));
		this.alojamiento.click();
	}
	
	public boolean searchInputOrigenVisible() {
		return this.searchInputOrigen.isDisplayed();
	}
	
	public void searchInputOrigenIngresarCiudad (String ciudad)  throws Exception {
		wait.until(ExpectedConditions.elementToBeClickable(this.searchInputOrigen));
		this.searchInputOrigen.click();
		
		this.searchInputOrigen.sendKeys("San Salvador de Jujuy, Jujuy, Argentina");
		Thread.sleep(1000);
		
        this.searchInputOrigen.sendKeys(Keys.CONTROL);  
	    wait.until(ExpectedConditions.elementToBeClickable(this.primerDestino));
	    this.primerDestino.click();
	}

	public boolean primerDestinoVisible()  throws Exception {
		// TODO Auto-generated method stub
		
		return true;
	}

	public boolean fechaDesdeVisible() {
		// TODO Auto-generated method stub
		return this.fechaDesde.isDisplayed();
	}

	public void clikFechaDesde() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(this.fechaDesde));
		this.fechaDesde.click();
	}

	public void elegirFechaDesde() {
		wait.until(ExpectedConditions.elementToBeClickable(this.fechaDesdeSeleccionado));
		this.fechaDesdeSeleccionado.click();
	}

	public boolean fechaHastaVisible() {
		// TODO Auto-generated method stub
		return this.fechaHasta.isDisplayed();
	}

	public void clikFechaHasta() {
		wait.until(ExpectedConditions.elementToBeClickable(this.fechaHasta));
		this.fechaHasta.click();
		
	}

	public void elegirFechaHasta() {
		wait.until(ExpectedConditions.elementToBeClickable(this.fechaHastaSeleccionado));
		this.fechaHastaSeleccionado.click();
	}

	public boolean botonAplicarVisible() {
		// TODO Auto-generated method stub
		return this.botonAplicar.isDisplayed();
	}

	public void botonAplicarClick() {
		wait.until(ExpectedConditions.elementToBeClickable(this.botonAplicar));
		this.botonAplicar.click();
	}

	public void btnHabitacionesClick() {
		wait.until(ExpectedConditions.elementToBeClickable(this.botonHabitaciones));
		this.botonHabitaciones.click();
	}

	public void btnAgregarAdultoClickear() {
		wait.until(ExpectedConditions.elementToBeClickable(this.btnAgregarAdulto));
		this.btnAgregarAdulto.click();
	}

	public boolean selectorEdadVisible() {
		// TODO Auto-generated method stub
		return this.selectorEdad.isDisplayed();
	}

	public void elegirEdad() {
		wait.until(ExpectedConditions.elementToBeClickable(this.edadElegida));
		this.edadElegida.click();
	}

	public void btnAplicarHabitacionClickear() {
		wait.until(ExpectedConditions.elementToBeClickable(this.btnAplicarHabitacion));
	    this.btnAplicarHabitacion.click();
	}

	public DespegarResultsPage buscarAlojamiento() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(this.btnBuscar));
		this.btnBuscar.click();
		return new DespegarResultsPage(this.driver);
	}

	public void btnAgregarMenorVisibleyClickeable() {
			this.btnAgregarMenor.click();
	}

	public void btnAgregarMenorClickear() {
		// TODO Auto-generated method stub
		wait.until(ExpectedConditions.elementToBeClickable(this.btnAgregarMenor));
		this.btnAgregarMenor.click();
	}
	
	
	
	
}
