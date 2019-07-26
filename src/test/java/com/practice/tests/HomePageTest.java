package com.practice.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practice.pages.HomePage;
import com.practice.pages.PropertyPage;
import com.practice.testbase.TestBase;


public class HomePageTest extends TestBase {

	HomePage homePage;
	PropertyPage propertyPage;

	public HomePageTest(){
		 super();
	}


	@BeforeTest
	public void setupHomePage() {
		initialization();
		homePage = new HomePage();
	}

	@Test
	public void verifyhomePageTitleTest() {
		Assert.assertEquals(driver.getTitle(), prop.getProperty("expectedTitle"));

	}

	@Test
	public void verifyForSalePageLocationTest() {
		
		propertyPage = homePage.searchSaleLocation("London");
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
