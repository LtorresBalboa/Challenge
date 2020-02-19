package com.kneat.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void tearDown() {
		driver.quit();
	}

	@Test(priority = 1)
	public void FirstTest() {

		System.out.println("---------------Executing First Test-------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("Sauna");
		pageValidation.Validation("Limerick Strand Hotel");
		System.out.println("---------------Test Passed----------------------------");
	}

	@Test(priority = 2)
	public void SecondTest() {

		System.out.println("---------------Executing Second Test------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("George Limerick Hotel");
		System.out.println("---------------Test Passed----------------------------");
	}

	@Test(priority = 3)
	public void ThridTest() {

		System.out.println("---------------Executing Third Test-------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("The Savoy Hotel");
		System.out.println("---------------Test Passed----------------------------");
	}

	@Test(priority = 4)
	public void ForthTest() {

		System.out.println("---------------Executing Fourth Test-------------------");
		pageSearch.SearchLocation();
		pageAddFilters.SelectFilters("STARS");
		pageValidation.Validation("George Limerick Hotel");
		System.out.println("---------------Test Passed----------------------------");
	}

}
