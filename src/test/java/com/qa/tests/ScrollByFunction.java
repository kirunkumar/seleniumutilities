package com.qa.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class ScrollByFunction extends BaseClass {
  @Test
  public void f() {
	  
	  
	  driver.get("https://www.theverge.com/tech");
	  
/*	  int x=0, y=1000;
	  for(int i=1; i<25; i++) {
		  //smallWait();
		  mediumWait();
		  x +=1000;
		  y +=1000;
		  //jse.executeScript("window.scrollBy(x,y)");
		  jse.executeScript("window.scrollBy(0,100)");
	  }*/
	  
	  softScrollDown();
	  softScrollUp();
	  
	  //gotoLast();	  
  }
  
  public void gotoLast() {
	  
	     jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	  
  }
  
  public void softScrollDown() {
	  
	     for(int i=0; i<6000; i++) {
	    	 
	    	 jse.executeScript("window.scrollBy(0,1)", "");
	    	 
	     }
	  
}
  
  public void softScrollUp() {
	  
	     for(int i=0; i>-30; i++) {
	    	 
	    	 jse.executeScript("window.scrollBy(0,"+i+")", "");
	    	 
	     }
	  
}
  
  
  @BeforeTest
  public void launchBrowser() {
	  
	  initializeDriver("Safari");
	  initializeJavaScript();
	  
  }
  
  

  @AfterTest
  public void killBrowser() {
	  
	  killBrowserInstance();
	  
	  
  }
  
  
}
