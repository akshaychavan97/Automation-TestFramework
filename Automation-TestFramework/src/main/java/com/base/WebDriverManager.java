package com.base;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    public static ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void remove(){
        driver.remove();
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }



}
