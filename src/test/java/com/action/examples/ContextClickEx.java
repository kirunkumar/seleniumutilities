package com.action.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ContextClickEx {
  @Test
  public void f() {
	  
		WebDriver driver;
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/kiran/Documents/Eclipse/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get("https://www.google.com/search?q=camel+has+hump+on+its+back&spell=1&sa=X&ved=0ahUKEwj--5q5pJngAhUGHqwKHejDDDQQBQgpKAA&biw=1397&bih=798");
		System.out.println("Before Click");
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/div/div[1]/div[2]/div[2]/div/div/div[1]/a/h3"));
		
		
		
		System.out.println("After Click");
		
		  Actions builder=new Actions(driver);
		  //WebElement ele=driver.findElement(By.tagName("body"));
		  Action contextClick=builder.contextClick(ele).build();
		  contextClick.perform();
	  
	  
  }
}
