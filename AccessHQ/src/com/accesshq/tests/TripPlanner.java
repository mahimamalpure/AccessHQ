package com.accesshq.tests;

import java.awt.AWTException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;

import com.accesshq.actions.HomeActions;
import com.accesshq.config.Configurations;
import com.accesshq.config.ReadConfig;
import com.accesshq.utils.ExcelReader;
import com.accesshq.utils.Utils;

public class TripPlanner 
{
	private WebDriver driver;
	private Map<Object, Object> DataMap;
    @Rule public TestName testName = new TestName();


	@Before
	public void setUp()
	{
		ReadConfig readConfig = new ReadConfig();
		readConfig.loadConfig();

		DataMap = ExcelReader.readData("./data.xlsx", "data", 1);
		
		System.out.println("***************** " + testName.getMethodName() + " is started ***********************");
		driver = Utils.launchSelectedBrowser(Configurations.BROWSER_NAME);
	}
	
	@After
	public void tearDown()
	{
		System.out.println("***************** " + testName.getMethodName() + " is finished ***********************");
		driver.close();
	}
	
	@Test
	public void planATrip() throws InterruptedException, AWTException
	{
		try {
			HomeActions.planTrip(driver, DataMap);
			
//			boolean isFlightDetailsPageDisplayed = FlightDetailsActions.validateIfFlightDetailsPageIsDisplayed(driver);

//			Assert.assertTrue(isFlightDetailsPageDisplayed);
			
		
		} catch (Exception e) 
		{
			Utils.getScreenShot(driver, "bookAFlight");
			e.printStackTrace();
		}
	}
}
