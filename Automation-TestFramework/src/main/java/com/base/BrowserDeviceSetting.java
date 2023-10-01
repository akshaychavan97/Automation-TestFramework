package com.base;

import com.config.DriverConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDeviceSetting extends TestBase {
    public BrowserDeviceSetting() {
    }
    DriverConfigManager driverConfigManager=DriverConfigManager.getInstance();

    public WebDriver setupBrowser() {
        WebDriver localdriver = null;
        switch (driverConfigManager.getConfig("browser")){
            case "chrome":
                ChromeDriver chromedriver = new ChromeDriver();
                localdriver=chromedriver;
                break;
            case "edge":
                EdgeDriver edgedriver = new EdgeDriver();
                localdriver=edgedriver;
                break;
            case "firefox":
                FirefoxDriver firefoxDriver = new FirefoxDriver();
                localdriver=firefoxDriver;
                break;
        }
        return localdriver;
    }
}
