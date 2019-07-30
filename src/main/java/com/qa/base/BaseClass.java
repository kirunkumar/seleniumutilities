package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
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
		driver.manage().window().fullscreen();
		
	}
	
	public void loadProperties() {
		
		try {
			//fis = new FileInputStream(System.getProperty("user.dir") + "/srsc/main/java/com/qa/data/config.properties");
			
			fis = new FileInputStream("/Users/kiran/Documents/Eclipse/Workspace/seleniumutilities/src/main/java/com/qa/data/config.properties");
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

}
