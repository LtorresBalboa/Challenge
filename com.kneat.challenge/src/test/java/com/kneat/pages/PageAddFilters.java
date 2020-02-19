package com.kneat.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageAddFilters {

	private WebDriver driver;
	private By SpaFilter;
	private By StarsFilter;

	public PageAddFilters(WebDriver driver) {
		this.driver = driver;

		// Wait until the web page is full loaded
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		SpaFilter = By.xpath("(//span[normalize-space(text())='Spa and wellness centre' or normalize-space(text())='Spa y centro de bienestar'])[1]");
		StarsFilter = By.xpath("(//span[normalize-space(text())='5 stars' or normalize-space(text())='5 estrellas'])[1]");

	}

	public void SelectFilters(String filter) {

		switch (filter.toUpperCase()) {
		case "SAUNA":
			driver.findElement(SpaFilter).click();
			break;
		case "STARS":
			driver.findElement(StarsFilter).click();
			break;

		default:
			break;
		}

	}
}
