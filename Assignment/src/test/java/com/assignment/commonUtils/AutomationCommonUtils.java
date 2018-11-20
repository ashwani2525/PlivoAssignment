package com.assignment.commonUtils;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class AutomationCommonUtils {
	
	// Sleep Method
	
	
		public static void sleep(int numberOfSecondsToSleep)
		{
			try {
				Thread.sleep(numberOfSecondsToSleep);
			    } 
			catch (InterruptedException e) {
				
				e.printStackTrace();
			    }
		}
		
		// implicit Wait method
		
		public static void implicitWait(long time)
		{
			WebBrowser.driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		}
		
		//pressing enter
		
		public static void pressEnter()
		{
			Actions act = new Actions(WebBrowser.driver);
			act.sendKeys(Keys.ENTER);
		}
		
		//wait for a specified time for element to be present
	
		public static void waitUntilElementPresent(By element,long time)
		{
			WebDriverWait wait= new WebDriverWait(WebBrowser.driver,time);
			wait.until(ExpectedConditions.presenceOfElementLocated(element));
			
		}
		
		
		//wait for a specified time for element to become visible
		
		public static void waitUntilVisible(By element,long time)
		{
			WebDriverWait wait= new WebDriverWait(WebBrowser.driver,time);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			
		}
		
		//wait for a specified time for element to become clickable
		
		public static void waitUntilClickable(By element,long time)
		{
			WebDriverWait wait = new WebDriverWait(WebBrowser.driver,time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		// To get the URL of the page
		
		public static String getUrl()
		{
			return WebBrowser.driver.getCurrentUrl().toString();
		}

		// To get the Title of the page
		
		public static String title()
		{
			return WebBrowser.driver.getTitle().toString();
		}
		
		// To click on the Button or element
		
		public static void click(By locator)
		{
			WebBrowser.driver.findElement(locator).click();
		}
		
		//To get the text from a Alert
		
		public static String getText(By locator)
		{
			return WebBrowser.driver.findElement(locator).getText().toString();
		}
		
		public static void findElement(By locator)
		{
			WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("locator")));
		}
		
		//To accept Alert
		
		public static void acceptAlert()
		{
			WebBrowser.driver.switchTo().alert().accept();
		}
		
		//To Reject the Alert
		
		public static void chooseCancelOnAlert()
		{  
			WebBrowser.driver.switchTo().alert().dismiss();
		}
		
		// To close the browser
		
		public static void CloseBrowser()
		{
			 WebBrowser.driver.close();
		}
		
		//To perform Right Click on the specified position
		
		public static void rightClick(By locator)
		{
			Actions action = new Actions(WebBrowser.driver);
			action.contextClick(WebBrowser.driver.findElement(locator)).perform();
	    }
		
		
		
		//To perform the Right click in case of Dropdown on the specified postion
		
		public static void actionClick(By locator)
		{
			Actions action = new Actions(WebBrowser.driver);
			action.moveToElement(WebBrowser.driver.findElement(locator)).click().perform();		
		}
		
		//To perform pressing Enter button 
		
		public static void pressEnter(By locator) throws Exception
		{
			Actions action = new Actions(WebBrowser.driver);
			action.moveToElement(WebBrowser.driver.findElement(locator)).sendKeys(Keys.ENTER).perform();
	    }
		
		//To perform Double Click
		
		public static void doubleClick(By locator)
		{
	    	Actions action = new Actions(WebBrowser.driver);
			action.doubleClick(WebBrowser.driver.findElement(locator)).perform();					 
	    }
		
		//To Switch to Frame
		
		public static void switchToFrame(String locator) 
		{
		 	WebBrowser.driver.switchTo().frame(locator);			
		}
		
		//To witch to Window
		
		public static void selectWindow(String windowID)
		{
			WebBrowser.driver.switchTo().window(windowID);	
	    }
		
		//To get the text present on the Alert
		
		public static String getAlertText()
		{
			return WebBrowser.driver.switchTo().alert().getText();
	    }
		
		//To Refresh the page
		
		public static void refresh()
		{
			WebBrowser.driver.navigate().refresh();	
		}
		
		//To verify file is downloaded or not
		public static boolean isFileDownloaded(String downloadPath, String fileName) {
			boolean flag = false;
		    File dir = new File(downloadPath);
		    File[] dir_contents = dir.listFiles();
		  	    
		    for (int i = 0; i < dir_contents.length; i++) {
		        if (dir_contents[i].getName().equals(fileName))
		            return flag=true;
		            }

		    return flag;
		}
		 
		
		public static void deleteFiles(File dir) {
			for(File file: dir.listFiles()) 
			    if (!file.isDirectory()) 
			        file.delete();
		}
		
		public static boolean isNotExists(By sLocator, int timeoutInSec){
	        WebBrowser.driver.manage().timeouts().implicitlyWait(timeoutInSec, TimeUnit.SECONDS);  
	        boolean present = false;
	        List<WebElement> ele = WebBrowser.driver.findElements(sLocator);
	        if (ele.isEmpty() == true) {
		        	   present = true;
	        } else{
	        	   present = false;
	        } 
	        WebBrowser.driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);  
			return present;
	    }
		
		//To maximize the window
		
		public static void windowMaximize() { 
			WebBrowser.driver.manage().window().maximize();	
		  }
		
		//Fluent wait
		
		public static WebElement waitForElement(WebElement element)
		{
			Wait<WebDriver> wait = new FluentWait<WebDriver>(WebBrowser.driver)
					.withTimeout(30,TimeUnit.SECONDS).pollingEvery(2,TimeUnit.SECONDS)
					.ignoring(NoSuchElementException.class);
			
			WebElement element1= wait.until(new Function<WebDriver,WebElement>()
					{
				public WebElement apply(WebDriver driver) 
				    {
					 
				       return driver.findElement(By.id("element"));
					}
					});
			return element1;
		
			   
		}
		
		

}
