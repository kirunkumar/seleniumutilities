package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class GotoNextPageInSchoolPortal extends BaseClass {

	 @Test
	  public void actualTestHere() {
		  
		  System.out.println("Hi");
		  //driver.get("https://cfbisd.edu/eventscalendar/list/?tribe_paged=11&tribe_event_display=list");
		  
		  openURL("https://cfbisd.edu/eventscalendar/list/?tribe_paged=11&tribe_event_display=list");
		  
		  WebElement ele = driver.findElement(By.partialLinkText("Next Event"));
		
		  initializeJavaScript();
		  
		  for(int i=1; i< 25; i++) {
			  
			  
			  //jse.executeScript("window.scrollTo(document.body.scrollHeight, 0)");


			  System.out.println(driver.getTitle());
			  
			  //ele.click();
			  
			  //mediumWait();
			  softScrollDown();
			  driver.findElement(By.xpath("//*[@id=\'tribe-events-footer\']/nav/ul/li[2]/a")).click();
			  waitForLoad(driver);
			  //driver.navigate().refresh();
			  
			  
		  }
		  
		  
		  
	  }
	 
	  
	  
	  @BeforeTest
	  public void launchBrowser() {
		  
		  initializeDriver("chrome");
		  
	  }
	  
	  

	  @AfterTest
	  public void killBrowser() {
		  
		  killBrowserInstance();
		  
		  
	  }
	
	
	
}
