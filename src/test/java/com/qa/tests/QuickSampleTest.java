package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.BaseClass;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class QuickSampleTest extends BaseClass {
	
	
  @Test
  public void actualTestHere() {
	  
	  System.out.println("Hi");
	  driver.get("https://www.google.com/search?q=never+try+easy+thhings&oq=never+try+easy+thhings&aqs=chrome..69i57j33.11848j0j7&sourceid=chrome&ie=UTF-8");
	  
	  
	  
  }
  
  
  @BeforeTest
  public void launchBrowser() {
	  
	  initializeDriver("Safari");
	  
  }
  
  

  @AfterTest
  public void killBrowser() {
	  
	  killBrowserInstance();
	  
	  
  }

}
