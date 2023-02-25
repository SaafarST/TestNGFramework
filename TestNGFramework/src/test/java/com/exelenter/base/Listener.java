package com.exelenter.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.exelenter.utils.CommonMethods;
import com.exelenter.utils.Constants;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    ExtentSparkReporter reporter;
    ExtentReports reports;
    ExtentTest test;
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test started " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test passed " + result.getName());
        test = reports.createTest(result.getName());
        test.pass("Test case passed: "+result.getName());

        // Optionally, you can capture screenshot here, for each success test case. (Not recommended!).
        test.addScreenCaptureFromPath(CommonMethods.takeScreenshot( "PASS/" + result.getName()));

        test.log(Status.PASS, "Test Passed. This is coming from the log status");
        test.log(Status.PASS,"Test passed. This is coming from the log status");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test failed " + result.getName());

        test = reports.createTest(result.getName());
        test.fail("Test case failed: "+result.getName());
        test.addScreenCaptureFromPath(CommonMethods.takeScreenshot("FAIL/" + result.getName())); // + "_" + getTimeStamp()

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test skipped");

        test = reports.createTest(result.getName());
        test.skip("Test case skipped: " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started " + context.getName() +", " +context.getStartDate());

        //Adding Reports:
        reporter = new ExtentSparkReporter(Constants.REPORT_FILEPATH);
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Exelenter Test Report"); // This will show on the browser Tab, just like page title (driver.getTitle()).
        reporter.config().setReportName("Exelenter Project Test Report"); // This will show in the top right corner of report Dashboard.
         reports = new ExtentReports();
        reports.attachReporter(reporter);

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n**********************************\n Test finished " + context.getName() +", " +context.getEndDate());
        reports.flush(); // Erases previous (old) data and creates new one.
    }
}
