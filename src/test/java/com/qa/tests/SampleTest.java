package com.qa.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.utilTests.ReadProperties;


@Listeners(com.qa.listeners.ExtentReportListener.class)
public class SampleTest extends BaseClass{
  SampleTest() {
		super();
		// TODO Auto-generated constructor stub
	}


  @Test
  public void firstTest() {
	
	  
	System.out.println("First Sample Test");
	driver.get(prop.getProperty("url1"));
	
	
  }

  @Test
  public void secondTest() {
	
	
	System.out.println("secondTest ");
	driver.get(prop.getProperty("url2"));
	
	
  }
  
  
  @Test
  public void thirdTest() {
	
	
	driver.get("https://www.guru99.com/listeners-selenium-webdriver.html");
	AssertJUnit.assertEquals(driver.getTitle(), "XYZ");
	
  }

  @Parameters({ "browser" })
  @BeforeTest
  public void beforeTest(String browserName) {
	  loadProperties();
	  initializeDriver(browserName);	
	  System.out.println("Browser Name passed is: " + browserName);
	  
  }

  @AfterTest
  public void afterTest() {
	  
	  
	  driver.quit();
  }
  
  @BeforeSuite
  public void beforeSuiteMethod() {
	  loadProperties();
  }  
	  
  

}
