package com.base;


import com.commonMethods.SeleniumMethods;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;


public class AppTest extends TestBase{

  @Test
  public void Test() {
    Setup();
  }

  @AfterClass
  public void tearDown(){
    QuitDriver();
  }
}
