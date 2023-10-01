package com.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserDeviceSetting extends TestBase {

    public WebDriver setupBrowser() {
        WebDriver localdriver = null;
        Object browser = testConfigManager.getConfig("browser");
        if (browser.equals("chrome")) {
            ChromeDriver chromedriver = new ChromeDriver();
            localdriver = chromedriver;
        } else if (browser.equals("edge")) {
            EdgeDriver edgedriver = new EdgeDriver();
            localdriver = edgedriver;
        } else if (browser.equals("firefox")) {
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            localdriver = firefoxDriver;
        } else {
            log.info("Wrong Browser Name");
        }
        return localdriver;
    }
}
