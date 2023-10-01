package com.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.config.DriverConfigManager;
import com.reportManager.ExtentReportManager;
import org.testng.*;

public class CustomListeners implements ITestListener, ISuiteListener {
    private ExtentReports reports;
    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        DriverConfigManager driverConfigManager=DriverConfigManager.getInstance();
        driverConfigManager.setConfig();
        reports= ExtentReportManager.createExtentReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        reports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        ExtentReportManager.setExtentTest(reports.createTest(result.getName(),result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
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
