package com.assignment.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


public class ConfigReader {
	public static Properties pro;
	public static Properties pro1;
	public ConfigReader() 
	{
		File src = new File("./PropertiesFile/config.properties");
		File src1=new File("./PropertiesFile/Locators.properties");
		
		FileInputStream fis;
		FileInputStream fis1;
		try {
			
			// Loading the Config.properties file
			fis = new FileInputStream(src);
			pro= new Properties();
			pro.load(fis);
			
			//Loading the Locators.properties file
			fis1=new FileInputStream(src1);
			pro1=new Properties();
			pro1.load(fis1);
			
			//Merging both the properties file
			pro.putAll(pro1);
						
		    }
		catch (Exception e) 
		{
			System.out.println("Exception is==" +e.getMessage());
		}
				
	}
	

	
	//Method to read the Browser config and then open Browser
	
	public static void browserConfig()
	{
		WebBrowser browser=new WebBrowser();
		ConfigReader reader=new ConfigReader();
		String browsername=reader.pro.getProperty("browsername");
		browser.browser(browsername);
	}
	
}
