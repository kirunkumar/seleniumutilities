package com.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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

import com.qa.utils.Utils;

public class BaseClass extends Utils {

	public WebDriver driver, safdriver;
	public Properties prop;
	public FileInputStream fis;
	public JavascriptExecutor jse;
	public Logger log;
	ChromeOptions options;
	DesiredCapabilities capabilities;

	public BaseClass() {

	}

	public void initializeDriver() {
		initializeDriver("Chrome");

	}

	public void initializeDriver(String browserName) {

		log = Logger.getLogger(getClass());

		if (browserName.equalsIgnoreCase("Chrome")) {
			options = new ChromeOptions();
			options.addArguments("--incognito");
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			capabilities = DesiredCapabilities.chrome();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			
				

			// WebDriver driver = new RemoteWebDriver(caps);

			if (whichOS() == "mac") {
				//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\kk\\Documents\\Kiran\\Automation\\drivers\\chromedriver.exe");
				// /Users/kiran/Documents/Eclipse/Workspace/seleniumutilities/drivers/chromedriver
			} else

			if (whichOS() == "windows") {

				//System.setProperty("webdriver.chrome.driver",
					//	System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\kk\\Documents\\Kiran\\Automation\\drivers\\chromedriver.exe");

				// System.setProperty("webdriver.chrome.driver",
				// "D:\\Software\\Eclipse\\drivers\\chromedriver.exe");

			} else {
				System.out.println("Browser not listed in this Program");
				System.exit(0);

			}

			driver = new ChromeDriver();
		}

		else {

			if (browserName.equalsIgnoreCase("Safari")) {

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

	public void killBrowserInstance() {

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
		options.addArguments("start-maximized");
		capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver(options);
		driver.get(url);

	}

	public void waitForLoad(WebDriver driver) {

		initializeJavaScript();
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				System.out.println("Document State:" + jse.executeScript("return document.readyState"));
				return jse.executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public void initializeJavaScript() {

		jse = (JavascriptExecutor) driver;

	}

	public void softScrollDown() {

		for (int i = 0; i < 6000; i++) {

			jse.executeScript("window.scrollBy(0,1)", "");

		}

	}

}
