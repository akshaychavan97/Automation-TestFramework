package com.commonMethods;

import com.base.WebDriverManager;
import com.reportManager.ExtentReportManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumMethods {

    public void navigateURL(String url){
        WebDriverManager.getDriver().get(url);
    }
   public WebElement getWebElementByXpath(String xPath){
        return WebDriverManager.getDriver().findElement(By.xpath(xPath));
   }

   public void typeintoXpath(String xpath,String value){
        typeintoWebElement(getWebElementByXpath(xpath),value);
   }
   public void typeintoWebElement(WebElement element,String value){
        element.sendKeys(value);

   }
   private void logging(String message){
       ExtentReportManager.getExtentTest().info(message);
   }
}
