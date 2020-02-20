package com.kneat.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageHelpers {

	private WebDriver driver;

	public PageHelpers(WebDriver driver) {
		this.driver = driver;
	}

	public void ScrollToElement(By element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}
}
