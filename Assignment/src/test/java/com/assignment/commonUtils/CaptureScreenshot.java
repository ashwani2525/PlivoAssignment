package com.assignment.commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class CaptureScreenshot {
	
	public static WebDriver driver;
	public static void captureScreenshot(WebDriver driver,String screenshotName)
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./Screenshot/"+ screenshotName+".png"));
		    } 
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static void fScreenshot(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			CaptureScreenshot.captureScreenshot(driver,result.getName());
		}
	}
	
	public static void skippedScreenshot(ITestResult result)
	{
		
		if(ITestResult.SKIP==result.getStatus())
		{
			CaptureScreenshot.captureScreenshot(driver,result.getName());
		}
	}

}
