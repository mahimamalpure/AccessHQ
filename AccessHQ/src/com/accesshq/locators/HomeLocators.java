package com.accesshq.locators;

import org.openqa.selenium.By;

import com.accesshq.locatorvalues.HomeLocatorValues;

public interface HomeLocators 
{
	public static final By FROM_LOCATION = By.xpath(HomeLocatorValues.FROM_LOCATION);
	public static final By TO_LOCATION = By.xpath(HomeLocatorValues.TO_LOCATION);
	public static final By FROM_LOCATION_POPUP = By.xpath(HomeLocatorValues.FROM_LOCATION_POPUP);
	public static final By TO_LOCATION_POPUP = By.xpath(HomeLocatorValues.TO_LOCATION_POPUP);
	public static final By SUBMIT_BUTTON = By.xpath(HomeLocatorValues.GO_BUTTON);
	public static final By TRIP_SUMMARY = By.xpath(HomeLocatorValues.TRIP_SUMMARY);
}
