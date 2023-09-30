package com.base;

import com.commonMethods.SeleniumMethods;
import com.config.ConfigHandler;
import com.config.DriverConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public SeleniumMethods seleniumMethods=new SeleniumMethods();
    public DriverConfigManager driverConfigManager= DriverConfigManager.getInstance();
    public ConfigHandler config= ConfigHandler.getInstance();
    public void Setup(){
        BrowserDeviceSetting browserDeviceSetting=new BrowserDeviceSetting();
        switch (driverConfigManager.getConfig("browser")){
            case "chrome":
            case "edge":
            case "firefox":
            case "ie":
                browserDeviceSetting.setupBrowser();
                break;
        }

    }
    public WebDriver driver(){
        return WebDriverManager.getDriver();
    }
    public void QuitDriver(){
        WebDriverManager.getDriver().quit();
        WebDriverManager.remove();
    }
    
}
