package com.kneat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class PageValidation {

	private WebDriver driver;
	private By LimStrand;
	private By GeorLimer;
	private By TheSavoy;
	private By FirstELement;

	public PageValidation(WebDriver driver) {
		this.driver = driver;

		LimStrand = By.xpath("//span[normalize-space(text())='Limerick Strand Hotel']");
		GeorLimer = By.xpath("//span[normalize-space(text())='George Limerick Hotel']");
		TheSavoy = By.xpath("//span[normalize-space(text())='The Savoy Hotel']");

	}

	public void Validation(String text) {

		boolean isListed;
		switch (text) {
		case "Limerick Strand Hotel":

			isListed = isElementPresent(LimStrand);
			Assert.assertTrue(isListed, "Limerick Strand Hotel should be Listed in webside with sauna filter, where true is: Listed and false is: Not listed");
			break;

		case "George Limerick Hotel":

			isListed = isElementPresent(GeorLimer);
			Assert.assertFalse(isListed, "Limerick Strand Hotel is not Listed");
			break;

		case "The Savoy Hotel":

			isListed = isElementPresent(TheSavoy);
			Assert.assertTrue(isListed, "The Savoy Hotelis Listed");
			break;

		default:
			break;
		}

	}

	public boolean isElementPresent(By element) {
		try {
			driver.findElement(element);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}
}
