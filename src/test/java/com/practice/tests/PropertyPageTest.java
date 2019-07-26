package com.practice.tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.practice.pages.HomePage;
import com.practice.pages.PropertyPage;
import com.practice.testbase.TestBase;


public class PropertyPageTest extends TestBase {

	HomePage homePage;
	PropertyPage propertyPage;
	

	public PropertyPageTest(){
		 super();
	}


	@BeforeTest
	public void setupHomePage() {
		initialization();
		homePage = new HomePage();
		propertyPage= homePage.searchSaleLocation("London");
	}
	


	
	@Test
	public void verifyPropertyPageTest(){
	
		Assert.assertEquals(driver.getTitle(), "Property for Sale in London - Buy Properties in London - Zoopla");
	}
	
	
		


	
	@AfterTest
	public void teardown() {
		driver.quit();
	}
}
