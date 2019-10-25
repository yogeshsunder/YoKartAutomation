package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCheckoutwithDiscountCouponPage {
	
	WebDriver driver;
	String brandidentifier;
	
	public UserCheckoutwithDiscountCouponPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	public void waitForClickability(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }

}
