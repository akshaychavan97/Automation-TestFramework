package com.util;

import com.aventstack.extentreports.model.Media;
import com.base.TestBase;
import com.base.WebDriverManager;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class TestUtil extends TestBase {
    private static String os=System.getProperty("os.name").toLowerCase();
    public static String  captureScreenShot(Boolean base64) {
        String path = "";
        File screenshot;
        Date date=new Date();
        String screenShotName=date.toString().replace(":","_").replace(" ","_")+".png";
        if (Boolean.TRUE.equals(base64)){
            path=((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
        }else {
            screenshot=((TakesScreenshot) WebDriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
            if (Boolean.TRUE.equals(isWindows())){
                path=System.getProperty("user.dir")+"\\output\\screenshot\\"+screenShotName;
            }else {
                path=System.getProperty("user.dir")+"/output/screenshot/"+screenShotName;
            }
            try {
                FileUtils.copyFile(screenshot, new File(path));
            }catch (IOException e){
                log.info("Unable to Capture ScreenShot");
            }
        }
        return path;
    }
    public static Boolean isWindows(){

        return (os.contains("win"));
    }

}
