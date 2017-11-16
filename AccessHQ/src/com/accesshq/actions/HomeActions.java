package com.accesshq.actions;

import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.accesshq.getters.HomeGetters;

public class HomeActions 
{
	public static void planTrip(WebDriver driver, Map<Object, Object> dataMap) throws InterruptedException
	{
		HomeGetters.getFromTextBox(driver).sendKeys(dataMap.get("From").toString());
		HomeGetters.getFromPopup(driver).click();

		HomeGetters.getToTextBox(driver).sendKeys(dataMap.get("To").toString());
		HomeGetters.getToPopup(driver).click();

		HomeGetters.getSubmitButton(driver).click();
		
		HomeGetters.validateTripList(driver);
	}
}
