package com.qa.tests;

import org.testng.annotations.Test;

import com.qa.base.BaseClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SampleTest extends BaseClass{
  SampleTest() {
		super();
		// TODO Auto-generated constructor stub
	}


@Test
  public void firstTest() {
	
	System.out.println("First Sample Test");
	
  }


  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
