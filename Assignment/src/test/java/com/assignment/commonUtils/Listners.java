package com.assignment.commonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class Listners implements ITestListener {

	public void onTestStart(ITestResult result) {
		
		System.out.println("The Test case execution has started");
		
		
	}

	public void onTestSuccess(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("test case failed");
		CaptureScreenshot.fScreenshot(result);
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Case Skipped");
		CaptureScreenshot.skippedScreenshot(result);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
	
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	

}
