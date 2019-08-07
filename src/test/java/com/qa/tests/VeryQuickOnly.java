package com.qa.tests;

import org.testng.annotations.Test;

public class VeryQuickOnly {
	
  @Test
  public void testMethod() {
	  
	  System.out.println(whichOS());
	  
  }
  
  
  public String whichOS() {
	  
	  System.out.println( System.getProperty("os.name") );
	  	  
	  if (System.getProperty("os.name").toLowerCase().contains("mac"))
		  return "mac";
	  
	  else
		  if (System.getProperty("os.name").toLowerCase().contains("wind"))
			  	return "windows";
	  
		  else
			  	return "unable to detect OS";
  }
}
