package com.base;



import com.exceptions.FrameworkExceptions;
import com.poiji.annotation.ExcelCell;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class AppTest extends TestBase{
  @BeforeClass
  public void SetUp(){

    setup();

  }

  @Test(priority = 1)
  public void LaunchURLValidateTitle( ) {

    driver().get("https://www.google.com/");
    String title=driver().getTitle();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(title,"Gooogle");
    softAssert.assertAll();
  }
  @Test(priority = 2)
  public void ValidateSecondTitle(){
    String title=driver().getTitle();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(title,"Google");
    softAssert.assertAll();
  }
  @Test(priority = 3)
  public void ValidateNewTitle(){
    String title=driver().getTitle();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(title,"Google");
    softAssert.assertAll();
  }
  @Test(priority = 4)
  public void ValidateFinalTitle(){
    String title=driver().getTitle();
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(title,"Gooogle");
    softAssert.assertAll();
  }
  @AfterClass
  public void tearDown(){
    quitDriver();

  }
}
