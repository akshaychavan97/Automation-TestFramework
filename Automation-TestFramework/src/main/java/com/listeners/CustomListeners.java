package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.base.TestBase;
import com.config.TestConfigManager;
import com.reportmanager.ExtentReportManager;
import org.testng.*;

public class CustomListeners extends TestBase implements ITestListener, ISuiteListener {
    private ExtentReports reports;
    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        TestConfigManager testConfigManager = TestConfigManager.getInstance();
        testConfigManager.setConfig();
        reports= ExtentReportManager.createExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        reports.setSystemInfo("Executed by User: ",System.getProperty("user.name"));
        reports.setSystemInfo("Executed on OS: ",System.getProperty("os.name"));
        reports.setSystemInfo("Executed Browser: ",System.getProperty("browser"));
        reports.flush();
        log.info("Execution is Completed Please find report on Path - "+TestConfigManager.getInstance().getConfig("extentReportPath"));
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        ExtentReportManager.setExtentTest(reports.createTest(result.getName(),result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        ExtentReportManager.getExtentTest().log(Status.PASS,result.getName()+" is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        ExtentReportManager.getExtentTest().log(Status.FAIL,result.getName()+" is Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        ExtentReportManager.getExtentTest().log(Status.SKIP,result.getTestName()+" is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }
}
