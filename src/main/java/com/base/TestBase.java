package com.base;

import com.commonMethods.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public SeleniumMethods seleniumMethods=new SeleniumMethods();
    public void Setup(){
        ChromeDriver driver = new ChromeDriver();
        WebDriverManager.setDriver(driver);

    }
    public WebDriver driver(){
        return WebDriverManager.getDriver();
    }
    public void QuitDriver(){
        WebDriverManager.getDriver().quit();
        WebDriverManager.remove();
    }
    
}
