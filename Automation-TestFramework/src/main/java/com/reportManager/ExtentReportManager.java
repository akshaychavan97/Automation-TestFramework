package com.reportmanager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.config.TestConfigManager;


import static com.util.TestUtil.isWindows;

public class ExtentReportManager {
    private ExtentReportManager(){
        throw new IllegalStateException("Extent Manager Class");
    }

 private static ExtentReports extent;
 private static ExtentSparkReporter spark;

 public static ExtentReports createExtentReport(){
     if (extent==null){
         extent=new ExtentReports();
         spark=new ExtentSparkReporter(TestConfigManager.getInstance().getConfig("extentReportPath"));
     }
     spark.config().setTheme(Theme.STANDARD);
     spark.config().setReportName("Automation-TestFramrework");
     extent.attachReporter(spark);
     return extent;
 }

   private static ThreadLocal<ExtentTest> extentTest=new ThreadLocal<>();

    public static ExtentTest getExtentTest(){
        return extentTest.get();
    }
    public static void setExtentTest(ExtentTest test){
        extentTest.set(test);
    }
    public static void removeExtentTest(){
        extentTest.remove();
    }
}
