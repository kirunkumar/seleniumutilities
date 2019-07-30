package com.qa.tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class SampleTest extends BaseClass{
  SampleTest() {
		super();
		// TODO Auto-generated constructor stub
	}


  @Test
  public void firstTest() {
	
	initializeDriver();	  
	System.out.println("First Sample Test");
	driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/3.141.59");
	
	
  }


  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
	  
	  driver.quit();
  }

}
