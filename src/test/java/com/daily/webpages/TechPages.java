package com.daily.webpages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;

public class TechPages extends BaseClass {

	ArrayList<Object> techLinks = new ArrayList<Object>();

	@Test(enabled=true)
	public void actualTestHere() {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// initializeJavaScript();

		techLinks.forEach(link -> {

			try {
				System.out.println("Opening URL: " + link.toString());
				openURL(link.toString());
				softScrollDown();
				System.out.println("Done: " + link.toString());

			} catch (Exception e) {
				System.out.println("****In Exception and continuing with next one**** \n\n");
				e.printStackTrace();
			}
		}

		);

	}
	
	@Test
	public void secondTest() {

		driver.get("https://cloud.google.com/apigee/");
		System.out.println("Browser title is:" + driver.getTitle());

	}

	@BeforeTest
	  public void launchBrowser() {
		  
		  initializeDriver("chrome");
		  
		  techLinks.add("https://www.theverge.com/");
		  techLinks.add("https://www.complex.com/music/");
		  techLinks.add("https://techcrunch.com/");
		  //techLinks.add("https://www.samsung.com/us/mobile/galaxy-note10/");
		  techLinks.add("https://www.theverge.com/tech");		  
		  techLinks.add("https://www.greatandhra.com/index.php");
		  techLinks.add("https://www.seleniumhq.org/");
		  techLinks.add("https://telugu.oneindia.com/");
		  techLinks.add("https://www.softwaretestingmaterial.com/selenium-interview-questions/");
		  techLinks.add("https://www.apple.com/mac/");
		  techLinks.add("https://www.samsung.com/us/mobile/galaxy-note10/");
		  techLinks.add("https://www.lenovo.com/us/en/d/laptops-by-specs?IPromoID=LEN878502&sort=sortBy&currentResultsLayoutType=grid&visibleDatas=&mode=normal");
		  techLinks.add("https://www.sakshi.com/");
		  techLinks.add("https://www.cnn.com/");
		  techLinks.add("https://cloud.google.com/apigee/");
		  techLinks.add("https://slickdeals.net/");
		  
		  

		
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		//techLinks.add("https://www.skysports.com/football/news");
		  //techLinks.add("https://www.skysports.com/football/news");
		  
		  
		  
		  
		  //techLinks.add("");
		  
		  
	  }

	@AfterTest
	public void killBrowser() {

		killBrowserInstance();

	}

}
