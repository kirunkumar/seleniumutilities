package com.broken.links;

import org.testng.annotations.Test;

import com.qa.base.BaseClass;

import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;

public class VerifyBrokenLinks extends BaseClass {
	
	
  @Test
  public void actualTestHere() {
	  
	  String homePage = "https://www.google.com/search?q=go+to+top+of+the+page+selenium&oq=go+to+top+of+the+page+selenium&aqs=chrome..69i57j0l2j69i64.9053j0j7&sourceid=chrome&ie=UTF-8";
	  
	  List<String> validLinks = new ArrayList<String> ();
	  List<String> invalidLinks = new ArrayList<String> ();
	  
	  //openURL("https://www.guru99.com/find-broken-links-selenium-webdriver.html");
      openURLHeadLess("https://www.google.com/search?q=go+to+top+of+the+page+selenium&oq=go+to+top+of+the+page+selenium&aqs=chrome..69i57j0l2j69i64.9053j0j7&sourceid=chrome&ie=UTF-8");
	  
	  
      List<WebElement> links = driver.findElements(By.tagName("a"));
      List<WebElement> imgs = driver.findElements(By.tagName("img"));
      
      links.addAll(imgs);
      
      Iterator<WebElement> it = links.iterator();
      
      while(it.hasNext()){
          
       String    url = it.next().getAttribute("href");
          
          System.out.println(url);
      
          if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
              continue;
          }
          
          /*if(!url.startsWith(homePage)){
              System.out.println("URL belongs to another domain, skipping it.");
              continue;
          }*/
          
          try {
        	  HttpURLConnection huc = (HttpURLConnection)(new URL(url).openConnection());
        	  
              huc.setRequestMethod("HEAD");
              
              huc.connect();
              
              int respCode = huc.getResponseCode();
              
              log.info("Response Code is: " + respCode + "  "+ url);
              
              if(respCode >= 400){
                  System.out.println(url+" is a broken link");
                  invalidLinks.add(url);
              }
              else{
                  System.out.println(url+" is a valid link");
                  validLinks.add(url);
              }
                  
          } catch (MalformedURLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
          }
      }
      
      driver.quit();
      
      
      System.out.println("Valid Links Are:");
      
      Iterator<String> strItr = validLinks.iterator();
      
      
      while(strItr.hasNext()) {
    	  
    	  String validURL = strItr.next();
    	  System.out.println(validURL);
    	  openURLHeadLess(validURL);
    	  System.out.println(driver.getTitle());
    	  log.info(driver.getTitle());
    	  
    	  
    	  
      }
      System.out.println("Total number of valid URLs are:" + validLinks.size());

	  
	  
  }
  
  
  @BeforeTest
  public void launchBrowser() {
	  
	  
	  
  }
  
  

  @AfterTest
  public void killBrowser() {
	  
	  killBrowserInstance();
	  
	  
  }

}
