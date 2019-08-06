package com.highlight.element;

import org.testng.annotations.Test;

import com.qa.base.BaseClass;


import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

public class HighlightElementTest extends BaseClass {
	
  @Test
  public void highlightHere() {
	  
	  
	  
		log.info("Started");
	  //Logger log = Logger.getLogger(LoginTest.class);
	  
	  driver.get("https://www.gmail.com");
      //Collects the webelement
		WebElement ele = driver.findElement(By.id("identifierId"));
		      //Create object of a JavascriptExecutor interface
		JavascriptExecutor js = (JavascriptExecutor) driver;
		      //use executeScript() method and pass the arguments 
		      //Here i pass values based on css style. Yellow background color with solid red color border. 
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", ele);

	  
	  
  }
  
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  
	  //initializeDriver("Safari");
	  initializeDriver();
	  log.info("In Before Method");
	  
  }
  
  

  @AfterMethod
  public void afterMethod() {
	  
	  log.info("In After Method");
	  killBrowserInstance();
	  
  }

}
