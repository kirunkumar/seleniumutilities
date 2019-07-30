package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	
	public BaseClass(){
		
	}
	
	public void initializeDriver(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		
	}
	
	public void loadProperties() {
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/srsc/main/java/com/qa/data/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
