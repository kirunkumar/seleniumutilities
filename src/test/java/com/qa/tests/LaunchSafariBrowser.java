package com.qa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class LaunchSafariBrowser {
  @Test
  public void f() {
	  
		 WebDriver driver = new SafariDriver();
		 driver.get("http://store.demoqa.com");
		 
		 
	  
  }
}
