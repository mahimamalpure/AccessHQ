package com.accesshq.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.accesshq.config.Configurations;

public class Utils 
{
	public static void getScreenShot(WebDriver driver , String screenName) throws InterruptedException 
	{
	    Thread.sleep(2000);
	    
		System.out.println("Taking the screenshot of " + screenName);   
	   
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    try
	    {
	    	FileUtils.copyFile(scrFile, new File(Configurations.SCREENSHOT_LOCATION + screenName + ".png"));
	    
	    } catch (IOException e) 
	    {
	        e.printStackTrace();
	    }
	}
	
	public static WebDriver launchSelectedBrowser(String browserName)
	{
		WebDriver driver = null;
		
		switch(browserName)
		{
			case "Chrome":
		
				System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_LOCATION);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.get(Configurations.URL);
				break;
		}
		
		return driver;
	}
}
