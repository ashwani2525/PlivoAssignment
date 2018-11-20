package com.assignment.commonUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebBrowser {
	public static  WebDriver driver;
	
	public static void browser(String browsername)
		{
		
		if(browsername.equalsIgnoreCase("Firefox"))
		{
			
			DesiredCapabilities cap= DesiredCapabilities.firefox();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver=new FirefoxDriver(cap);
						
		}
		
		else if(browsername.equalsIgnoreCase("Chrome"))
		{
			
			DesiredCapabilities cap=  DesiredCapabilities.chrome();
			cap.setCapability (CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver=new ChromeDriver(cap);
			
		}
		
		else if(browsername.equalsIgnoreCase("InternetExplorer"))
		{
			
			DesiredCapabilities cap=DesiredCapabilities.internetExplorer();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.ie.driver","./Drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver(cap);
			
		
			
		}
		
	}
		

}
