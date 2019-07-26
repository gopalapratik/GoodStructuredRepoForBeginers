package com.practice.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practice.testbase.TestBase;


public class HomePage extends TestBase  {
	

	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath= "//input[@id ='search-input-location']//parent::div//span//span[contains(@class,'search-input-location-placeholder-1')]")
	WebElement txtBoxSearch;
	

	
	public PropertyPage searchSaleLocation(String location)
	{
		Actions action = new Actions(driver);
		action.moveToElement(txtBoxSearch);
		action.click();
		action.sendKeys(location);
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		return new PropertyPage();
	}

}
