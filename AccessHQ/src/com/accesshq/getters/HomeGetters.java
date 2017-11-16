package com.accesshq.getters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.locators.HomeLocators;

import junit.framework.Assert;

public class HomeGetters 
{
	public static WebElement getFromPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.elementToBeClickable(HomeLocators.FROM_LOCATION_POPUP));

		return driver.findElement(HomeLocators.FROM_LOCATION_POPUP);
	}
	
	public static WebElement getToPopup(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20); 
		wait.until(ExpectedConditions.elementToBeClickable(HomeLocators.TO_LOCATION_POPUP));

		return driver.findElement(HomeLocators.TO_LOCATION_POPUP);
	}
	
	public static WebElement getFromTextBox(WebDriver driver)
	{
		return driver.findElement(HomeLocators.FROM_LOCATION);
	}
	
	public static WebElement getToTextBox(WebDriver driver)
	{
		return driver.findElement(HomeLocators.TO_LOCATION);
	}
	
	public static WebElement getSubmitButton(WebDriver driver)
	{
		return driver.findElement(HomeLocators.SUBMIT_BUTTON);
	}

	public static void validateTripList(WebDriver driver) {
		
		WebElement webElement = driver.findElement(HomeLocators.TRIP_SUMMARY);
		
		Assert.assertNotNull("Trip Summary not found!!", webElement);
		
		System.out.println("Passed : Trip Summary found!!");

	}
}
