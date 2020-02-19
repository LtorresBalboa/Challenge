package com.kneat.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageSearch {

	private WebDriver driver;
	
	private By DestinationField;
	private By CalendarField;
	private By CheckInField;
	private By CheckOutField;
	private By NumPeopleField;
	private By SearchBtn;

	public PageSearch(WebDriver driver) {
		this.driver = driver;

		// Wait until the web page is full loaded
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		DestinationField = By.xpath("//input[@type='search']");
		CalendarField = By.xpath("(//span[@class='sb-date-field__icon sb-date-field__icon-btn bk-svg-wrapper calendar-restructure-sb'])[1]");
		CheckInField = By.xpath("//td[@data-date='2020-03-02']");
		CheckOutField = By.xpath("//td[@data-date='2020-03-03']");
		SearchBtn = By.xpath("//button/span[normalize-space(text())='Search' or normalize-space(text())='Buscar']");

	}

	public void SearchLocation() {
		
		driver.findElement(DestinationField).sendKeys("Limerick");
		driver.findElement(CalendarField).click();
		driver.findElement(CheckInField).click();
		driver.findElement(CheckOutField).click();
		driver.findElement(SearchBtn).click();

	}

}
