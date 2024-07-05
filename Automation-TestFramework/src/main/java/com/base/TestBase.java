package com.base;

import com.commonmethods.SeleniumMethods;
import com.config.ConfigHandler;
import com.config.TestConfigManager;
import com.listeners.CustomListeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;


@Listeners(CustomListeners.class)
public class TestBase {

    public static SeleniumMethods seleniumMethods=new SeleniumMethods();
    public static final TestConfigManager testConfigManager = TestConfigManager.getInstance();
    public static final ConfigHandler config= ConfigHandler.getInstance();
    public static final Logger log = LogManager.getRootLogger();
    public void setup(){

        BrowserDeviceSetting browserDeviceSetting=new BrowserDeviceSetting();
        switch (testConfigManager.getConfig("browser")){
            case "chrome":
            case "edge":
            case "firefox":
            case "ie":
                WebDriverManager.setDriver(browserDeviceSetting.setupBrowser());
                break;
            default:

        }

    }
    public WebDriver driver(){
        return WebDriverManager.getDriver();
    }
    public void quitDriver(){
        WebDriverManager.getDriver().quit();
        WebDriverManager.remove();
    }
    public void loadBrowser(String url){
        seleniumMethods.navigateURL(url,true);
        driver().manage().window().maximize();
    }

}
