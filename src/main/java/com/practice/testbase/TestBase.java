package com.practice.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;



public class TestBase {

	public  static WebDriver driver;
	public Properties prop;
	

	public TestBase() {
		prop = new Properties();
		FileInputStream ip = null;
		try {
			ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/practice/config/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initialization() {

		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/drivers/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
			
		
			
			
		} else if (browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/drivers/geckodriver-v0.21.0-win32/geckodriver.exe");
		} else if (browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
			System.setProperty("webdriver.IE.driver",
					System.getProperty("user.dir") + "/drivers\\geckodriver-v0.21.0-win32\\geckodriver.exe");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

}
