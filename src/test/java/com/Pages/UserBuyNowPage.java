package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserBuyNowPage {
	
WebDriver driver;
	
	public UserBuyNowPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Buy Now button on Product Detail Page
	//
	@FindBy(how=How.ID,using="btnProductBuy")
	WebElement buyNow;
	
	//
	//Function to Click on Buy Now button on Product Detail Page
	//
	public void clickBuyNow()
	{
		waitForVisibility(buyNow);
		buyNow.click();
	}
	
	//
	//WebElement of Continue button on Shipping Summary screen
	//
	@FindBy(how=How.CLASS_NAME,using="btn--primary")
	WebElement continueShippingSummary;
	
	//
	//Function to click on Continue button on Shipping Summary screen
	//
	public void clickContinueShippingSummary() throws InterruptedException
	{
		Thread.sleep(20000);
		//waitForVisibility(continueShippingSummary);
		continueShippingSummary.click();
	}

}
