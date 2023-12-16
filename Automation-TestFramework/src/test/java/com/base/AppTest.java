package com.base;


import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AppTest extends TestBase{
  @BeforeClass
  public void SetUp(){
    setup();

  }
  @Test
  public void Test() {
    loadBrowser("https://www.amazon.in/");
  }

  @AfterClass
  public void tearDown(){
    quitDriver();

  }
}
