package com.kneat.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageHelpers {

	private WebDriver driver;

	public PageHelpers(WebDriver driver) {
		this.driver = driver;
	}

	public void ScrollToElement(By element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(element));
	}

	public boolean isElementPresent(By element) {

		WebDriverWait wait = new WebDriverWait(driver, 2);

		try {
			driver.findElement(element);
			try {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				return true;
			} catch (TimeoutException e) {
				return false;
			}

		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
