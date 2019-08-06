package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	public JavascriptExecutor jse;
	public Logger log;
	ChromeOptions options;
	DesiredCapabilities capabilities;
	
	public BaseClass(){
		
	}
	
	public void initializeDriver(){
		initializeDriver("Chrome");
		
	}
		
	
	public void initializeDriver(String browserName){
		
		log = Logger.getLogger(getClass());
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			options = new ChromeOptions();
			options.addArguments("--incognito");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			// /Users/kiran/Documents/Eclipse/Workspace/seleniumutilities/drivers/chromedriver
			
			driver = new ChromeDriver();
		}
		
		else {
			
				if(browserName.equalsIgnoreCase("Safari"))
				{

					 driver = new SafariDriver();
					 					
				}
						
		}
		
		System.out.println("Test is being executed in " + browserName + " Browser");
		
		
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
		driver.manage().window().fullscreen();
		
	}
	
	public void loadProperties() {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/qa/data/config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void killBrowserInstance(){
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		
	}
	
	public void smallWait() {
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void mediumWait() {
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
	 public void openURL(String url) {
		 
		 driver.get(url);
		 waitForLoad(driver);
		 
	 }
	 
	 
	 public void openURLHeadLess(String url) {
		 
		 log = Logger.getLogger(getClass());
		 
			options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--headless");
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver(options);
			driver.get(url);
			
	 }
	 
	 public void waitForLoad(WebDriver driver) {
		 
		 initializeJavaScript();
	        ExpectedCondition<Boolean> pageLoadCondition = new
	                ExpectedCondition<Boolean>() {
	                    public Boolean apply(WebDriver driver) {
	                        return jse.executeScript("return document.readyState").equals("complete");
	                    }
	                };
	        WebDriverWait wait = new WebDriverWait(driver, 30);
	        wait.until(pageLoadCondition);
	  }

	
	public void initializeJavaScript(){
		
		jse = (JavascriptExecutor) driver;
		
	}
	
	public void softScrollDown() {
		  
	     for(int i=0; i<2000; i++) {
	    	 
	    	 jse.executeScript("window.scrollBy(0,1)", "");
	    	 
	     }
	     
	}

}
