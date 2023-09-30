package com.base;

import com.config.DriverConfigManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserDeviceSetting extends TestBase {
    public BrowserDeviceSetting() {
    }
    DriverConfigManager driverConfigManager=DriverConfigManager.getInstance();

    public WebDriver setupBrowser() {
        WebDriver localdriver = null;
        switch (driverConfigManager.getConfig("browser")){
            case "chrome":
                ChromeDriver driver = new ChromeDriver();
                break;
        }
        return localdriver;
    }
}
