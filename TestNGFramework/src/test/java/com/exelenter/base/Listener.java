package com.exelenter.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Regression Test started " + context.getName() +", " +context.getStartDate());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Regression Test finished " + context.getName() +", " +context.getEndDate());
    }
}
