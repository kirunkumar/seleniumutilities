package com.qa.utilTests;

import org.testng.annotations.Test;

import com.qa.base.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;


//@Listeners(com.qa.listeners.ExtentReportListener.class)
public class ReadProperties extends BaseClass{
	
  @Test
  public void printProperties() {
	  
	  System.out.println("URL is:" + prop.getProperty("url"));
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  
	  loadProperties();
  }

}
