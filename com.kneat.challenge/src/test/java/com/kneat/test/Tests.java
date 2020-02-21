package com.kneat.test;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.kneat.pages.PageAddFilters;
import com.kneat.pages.PageSearch;
import com.kneat.pages.PageValidation;

public class Tests {

	private WebDriver driver;
	private PageSearch pageSearch;
	private PageAddFilters pageAddFilters;
	private PageValidation pageValidation;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.booking.com/");

		pageSearch = new PageSearch(driver);
		pageAddFilters = new PageAddFilters(driver);
		pageValidation = new PageValidation(driver);

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (!result.isSuccess()) {
			File MyScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(MyScreenshot, new File("screenshots/errorEvidence" + System.currentTimeMillis() + ".png"));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		driver.quit();
	}

	@Test(priority = 1)
	public void SaunaLimerickStrandHotelListed() {

		System.out.println("--Executing First Test: Sauna Limerick Strand Hotel Listed--------------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("Sauna");
		pageValidation.Validation("Limerick Strand Hotel");
		System.out.println("--Test Passed: Limerick Strand Hotel is listed in the webside with sauna filter-----");
		System.out.println("");
	}

	@Test(priority = 2)
	public void SaunaGeorgeLimerickHotelNotListed() {

		System.out.println("--Executing Second Test: Sauna George Limerick Hotel Not Listed----------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("George Limerick Hotel");
		System.out.println("--Test Passed: George Limerick Hotel is not listed with Sauna filter-----------------");
		System.out.println("");
	}

	@Test(priority = 3)
	public void FiveStarsTheSavoryHotelListed() {

		System.out.println("--Executing Third Test: Five Stars The Savory Hotel Listed---------------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("The Savoy Hotel");
		System.out.println("--Test Passed: The Savoy Hotel is listed in the webside with 5 stars filter----------");
		System.out.println("");
	}

	@Test(priority = 4)
	public void FiveStarsGeorgeLimerickHotelNotListed() {

		System.out.println("--Executing Fourth Test: Five Stars George Limerick Hotel Not Listed------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("George Limerick Hotel");
		System.out.println("--Test Passed: George Limerick Hotel is not listed with 5 stars filter----------------");
		System.out.println("");
	}

}
