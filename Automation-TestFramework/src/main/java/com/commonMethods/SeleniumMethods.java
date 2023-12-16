package com.commonmethods;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.base.TestBase;
import com.base.WebDriverManager;
import com.reportmanager.ExtentReportManager;
import com.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumMethods extends TestBase {
    public void navigateURL(String url,Boolean screenShot){
        WebDriverManager.getDriver().get(url);
        logging(null,"navigate",url,screenShot);
    }
    public WebElement locateElement(By locator){
        return WebDriverManager.getDriver().findElement(locator);
    }
   public WebElement getWebElementByXpath(String xPath){
        return locateElement(By.xpath(xPath));
   }
    public void typeintoXpath(String xpath,String value,Boolean screenShot){
        typeintoWebElement(locateElement(By.xpath(xpath)),value,screenShot);
   }

   public void typeintoWebElement(WebElement element,String value,Boolean screenShot){
        element.sendKeys(value);
        logging(element,"typed",value,screenShot);
   }
    public void typeintoLocator(By locator,String value,Boolean screenShot){
        WebElement element=locateElement(locator);
        typeintoWebElement(element,value,screenShot);
    }
    public void clickintoXpath(String xpath,Boolean screenShot){
        clickintoWebElement(locateElement(By.xpath(xpath)),screenShot);
    }

    public void clickintoWebElement(WebElement element,Boolean screenShot){
        element.click();
        logging(element,"clicked",null,screenShot);
    }
    public void clickintoLocator(By locator,Boolean screenShot){
        WebElement element=locateElement(locator);
        clickintoWebElement(element,screenShot);

    }
    public void selectFromDropDownUsingValueByWebElement(WebElement element,String value,Boolean screenShot){
        Select select = new Select(element);
        select.selectByValue(value);
        logging(element,"selected",value,screenShot);
    }
    public void selectFromDropDownUsingVisibleTextByWebElement(WebElement element,String value,Boolean screenShot){
        Select select = new Select(element);
        select.selectByVisibleText(value);
        logging(element,"selected",value,screenShot);
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
       } else if (keyword.equalsIgnoreCase("clicked")){
           logStatement = element+" Web Element was Clicked";
       } else if (keyword.equalsIgnoreCase("selected")){
           logStatement = value+ " was Selected From DropDown in Web Element "+element ;
       } else if (keyword.equalsIgnoreCase("navigate")){
           logStatement = "Navigated to URL - "+value;
       }else {
           logStatement = "Unknown Action Occurred Please Contact Automation Framework Developer";
       }
    return logStatement;
   }
}
