package com.kneat.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.kneat.helpers.PageHelpers;

public class PageAddFilters {

	private WebDriver driver;
	private By SpaFilter;
	private By StarsFilter;
	private By FirstELement;

	public PageAddFilters(WebDriver driver) {
		this.driver = driver;

		SpaFilter = By.xpath(
				"(//span[normalize-space(text())='Spa and wellness centre' or normalize-space(text())='Spa y centro de bienestar'])[1]");
		StarsFilter = By
				.xpath("(//span[normalize-space(text())='5 stars' or normalize-space(text())='5 estrellas'])[1]");
		FirstELement = By.xpath("//section[@class='bui-banner']");
	}

	public void SelectFilters(String filter) {

		// Wait until the web page is full loaded
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		PageHelpers pageHelpers = new PageHelpers(driver);
		
		switch (filter.toUpperCase()) {
		case "SAUNA":

			// Scroll
			pageHelpers.ScrollToElement(SpaFilter);
			
            //Select filter SPA-Sauna
			driver.findElement(SpaFilter).click();

			break;
		case "STARS":
			
			// Scroll
			pageHelpers.ScrollToElement(StarsFilter);
			
			//Select filter 5 stars
			driver.findElement(StarsFilter).click();

			break;

		default:
			break;
		}

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FirstELement));
	}
}
