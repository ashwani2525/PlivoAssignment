package com.assignment.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.assignment.commonUtils.AutomationCommonUtils;
import com.assignment.commonUtils.ConfigReader;
import com.assignment.commonUtils.Excel;
import com.assignment.commonUtils.WebBrowser;

public class TestScript {

 public static Integer longTimeoutInSec=10000;
 public static Integer shortTimeoutInSec=5000;
 
 @BeforeMethod
 public void login()
 {
	 ConfigReader.browserConfig();
	 WebBrowser.driver.navigate().to(ConfigReader.pro.getProperty("plumfuseUrl"));
	 AutomationCommonUtils.implicitWait(longTimeoutInSec);
 }
 
 @Test
 public void VariousOperations()
 {
	 AutomationCommonUtils.waitUntilClickable(By.xpath(ConfigReader.pro.getProperty("CreateAppLink")), shortTimeoutInSec);
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("CreateAppLink"))).click();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("LetsGetStartedBtn")), shortTimeoutInSec);
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("LetsGetStartedBtn"))).click(); 
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("NewPageName"))).sendKeys(Excel.getExcelData(0,1));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("CreateBtnOnNewPage"))).click(); 
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("MessagingLink"))).click();
	 Actions action = new Actions(WebBrowser.driver);
	 action.dragAndDropBy((WebElement) By.xpath(ConfigReader.pro.getProperty("SendAnSMS")), 80, 0).build().perform();
	 Point point = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int SendSMSXcord = point.getX();
	 int SendSMSYcord = point.getY();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("SendAnSMS")), shortTimeoutInSec);
	 action.moveToElement((WebElement) By.xpath(ConfigReader.pro.getProperty("StartLineJoin"))).clickAndHold().moveByOffset(SendSMSXcord,SendSMSYcord).release().build().perform();
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("phoneNumber"))).sendKeys(Excel.getExcelData(0,2));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("MessagePhrase"))).sendKeys(Excel.getExcelData(0,3));
	 Actions EmailAction = new Actions(WebBrowser.driver);
	 EmailAction.dragAndDropBy((WebElement) By.xpath(ConfigReader.pro.getProperty("SendAnEmail")), 115, 0).build().perform();
	 Point Emailpoint = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int EmailXcord = Emailpoint.getX();
	 int EmailSMSYcord = Emailpoint.getY();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("SendAnEmail")), shortTimeoutInSec);
	 Point Emailpoints = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int ptX= Emailpoints.getX();
	 int PtY= Emailpoints.getY();
	 EmailAction.moveToElement((WebElement) By.xpath(ConfigReader.pro.getProperty("StartLineJoin")),ptX,PtY).clickAndHold().moveByOffset(EmailXcord,EmailSMSYcord).release().build().perform();
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SMTPHost"))).sendKeys(Excel.getExcelData(0,4));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("Port"))).sendKeys(Excel.getExcelData(0,5));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("Username"))).sendKeys(Excel.getExcelData(0,6));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("Password"))).sendKeys(Excel.getExcelData(0,7));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("FromAddress"))).sendKeys(Excel.getExcelData(0,8));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("ToAddress"))).sendKeys(Excel.getExcelData(0,9));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("Subject"))).sendKeys(Excel.getExcelData(0,10));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("CC"))).sendKeys(Excel.getExcelData(0,11));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("MessageText"))).sendKeys(Excel.getExcelData(0,12));
	 WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("BasicComponent"))).click(); 
	 Actions FirstExitaction = new Actions(WebBrowser.driver);
	 FirstExitaction.dragAndDropBy((WebElement) By.xpath(ConfigReader.pro.getProperty("Exit")), 130, 0).build().perform();
	 Point FirstExitActionpoint = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int FirstExitSendSMSXcord = point.getX();
	 int FirstExitSendSMSYcord = point.getY();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("Exit")), shortTimeoutInSec);
	 Point ptlocations = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("NotSentJoin"))).getLocation();
	 int locX= ptlocations.getX();
	 int LocY= ptlocations.getY();
	 FirstExitaction.moveToElement((WebElement) By.xpath(ConfigReader.pro.getProperty("NotSentJoin")),locX,LocY).clickAndHold().moveByOffset(FirstExitSendSMSXcord,FirstExitSendSMSYcord).release().build().perform();
	 Actions SecondExitaction = new Actions(WebBrowser.driver);
	 SecondExitaction.dragAndDropBy((WebElement) By.xpath(ConfigReader.pro.getProperty("Exit")), 145, 10).build().perform();
	 Point SecondExitActionpoint = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int SecondExitSendSMSXcord = point.getX();
	 int SecondExitSendSMSYcord = point.getY();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("Exit")), shortTimeoutInSec);
	 Point ptlocation = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("EmailSentJoin"))).getLocation();
	 int ptLcX=ptlocation.getX();
	 int ptLcY= ptlocation.getY();
	 SecondExitaction.moveToElement((WebElement) By.xpath(ConfigReader.pro.getProperty("EmailSentJoin")),ptLcX,ptLcY).clickAndHold().moveByOffset(SecondExitSendSMSXcord,SecondExitSendSMSYcord).release().build().perform();
	 Actions ThirdExitaction = new Actions(WebBrowser.driver);
	 SecondExitaction.dragAndDropBy((WebElement) By.xpath(ConfigReader.pro.getProperty("Exit")), 165, 15).build().perform();
	 Point ThirdExitActionpoint = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("SendAnSMS"))).getLocation();
	 int ThirdExitSendSMSXcord = point.getX();
	 int ThirdExitSendSMSYcord = point.getY();
	 AutomationCommonUtils.waitUntilVisible(By.xpath(ConfigReader.pro.getProperty("Exit")), shortTimeoutInSec);
	 Point pointlocation = WebBrowser.driver.findElement(By.xpath(ConfigReader.pro.getProperty("EmailNotSent"))).getLocation();
	 int pointlocationOfX=pointlocation.getX();
	 int pointlocationOfY= pointlocation.getY();
	 ThirdExitaction.moveToElement((WebElement) By.xpath(ConfigReader.pro.getProperty("EmailNotSent")),pointlocationOfX,pointlocationOfY).clickAndHold().moveByOffset(ThirdExitSendSMSXcord,ThirdExitSendSMSYcord).release().build().perform();
	 
	 
 }
 
 @AfterMethod
 public void EndTest() {
	 WebBrowser.driver.close();
 }
}
