package com.base;


import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class AppTest extends TestBase{

  @Test
  public void Test() {
    setup();
    seleniumMethods.navigateURL("https://www.google.com");
  }

  @AfterClass
  public void tearDown(){
    quitDriver();

  }
}
