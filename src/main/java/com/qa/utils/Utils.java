package com.qa.utils;

public class Utils {
	
	
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
