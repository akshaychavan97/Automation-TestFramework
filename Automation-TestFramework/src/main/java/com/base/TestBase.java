package com.base;

import com.commonMethods.SeleniumMethods;
import com.config.ConfigHandler;
import com.config.DriverConfigManager;
import com.listeners.CustomListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.Listeners;

@Listeners(CustomListeners.class)
public class TestBase {

    public SeleniumMethods seleniumMethods=new SeleniumMethods();
    public DriverConfigManager driverConfigManager= DriverConfigManager.getInstance();
    public ConfigHandler config= ConfigHandler.getInstance();
    public Logger log = LogManager.getRootLogger();
    public void Setup(){
        log.info("Testmessae");
        BrowserDeviceSetting browserDeviceSetting=new BrowserDeviceSetting();
        switch (driverConfigManager.getConfig("browser")){
            case "chrome":
            case "edge":
            case "firefox":
            case "ie":
                WebDriverManager.setDriver(browserDeviceSetting.setupBrowser());
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
