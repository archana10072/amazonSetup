package com.amazon.utils.customListeners;

import com.amazon.base.BaseClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners extends BaseClass implements ITestListener {
    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {

        log.info("Test Passed: "+ result.getName());
    }

    public void onTestFailure(ITestResult result) {
        log.info("Test Failed: "+ result.getName());

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onTestFailedWithTimeout(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
