package com.commonmethods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.TestBase;
import com.base.WebDriverManager;
import com.reportmanager.ExtentReportManager;
import com.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumMethods extends TestBase {
    public void navigateURL(String url){
        WebDriverManager.getDriver().get(url);
    }
   public WebElement getWebElementByXpath(String xPath){
        return WebDriverManager.getDriver().findElement(By.xpath(xPath));
   }

   public void typeintoXpath(String xpath,String value,Boolean screenShot){
        typeintoWebElement(getWebElementByXpath(xpath),value,screenShot);
   }
   public void typeintoWebElement(WebElement element,String value,Boolean screenShot){
        element.sendKeys(value);
        logging(element,"typed",value,screenShot);
   }
   private void logging(WebElement element,String keyword,String value,Boolean screenshot){
        //Capture ScreenShot
        String logStatement=handleLogStatement(element,keyword, value);
        if (Boolean.TRUE.equals(screenshot)){
            if (testConfigManager.getConfig("base64img").equalsIgnoreCase("true")){
                ExtentReportManager.getExtentTest().info(logStatement,MediaEntityBuilder.createScreenCaptureFromBase64String(TestUtil.captureScreenShot(true)).build());
            }else {
                ExtentReportManager.getExtentTest().info(logStatement, MediaEntityBuilder.createScreenCaptureFromPath(TestUtil.captureScreenShot(false)).build());
            }
        } else{
            ExtentReportManager.getExtentTest().info(logStatement);
        }
        log.info(logStatement);
   }
   private String handleLogStatement(WebElement element,String keyword,String value){
    String logStatement="";
       if (keyword.equalsIgnoreCase("typed")) {
           logStatement = value + " was Typed in Web Element " + element;
       } else {
           logStatement = "Unknown Action Occurred Please Contact Automation Framework Developer";
       }
    return logStatement;
   }
}
