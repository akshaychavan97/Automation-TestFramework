package com.base;

import org.testng.annotations.*;

public class Annotations extends TestBase{

@BeforeSuite
public void BeforeSuite(){
  System.out.println("This is BeforeSuite");
}
  @BeforeTest
  public void BeforeTest(){
    System.out.println("This is BeforeTest");
  }

  @BeforeClass
  public void BeforeClass(){
    System.out.println("This is BeforeClass");
  }

  @BeforeMethod
  public void BeforeMethod(){
    System.out.println("This is BeforeMethod");
  }

  @Test
  public void Test(){
    System.out.println("This is Test");
  }

  @AfterMethod
  public void AfterMethod(){
    System.out.println("This is AfterMethod");
  }
  @AfterClass
  public void AfterClass(){
    System.out.println("This is AfterClass");
  }

  @AfterTest
  public void AfterTest(){
    System.out.println("This is AfterTest");
  }

  @AfterSuite
  public void AfterSuite(){
    System.out.println("This is AfterSuite");
  }
}
