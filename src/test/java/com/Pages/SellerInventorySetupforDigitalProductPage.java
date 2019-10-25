package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerInventorySetupforDigitalProductPage 
{
	
	WebDriver driver;
	
	public SellerInventorySetupforDigitalProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of validation error message of Max Download Times field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_max_download_times")
	WebElement validaionMaxDownloadTimes;
	
	//
	//Function to get validation error message of Max Download Times field
	//
	public String getValidationMaxDownloadTimes()
	{
		waitForVisibility(validaionMaxDownloadTimes);
		return validaionMaxDownloadTimes.getText();
	}
	
	//
	//WebElement of Max Download Times field
	//
	@FindBy(how=How.NAME,using="selprod_max_download_times")
	WebElement maxDownloadTimes;
	
	//
	//Function to enter Max Download Times field
	//
	public void enterMaxDownloadTimes(String MaxDownloadTimes)
	{
		waitForVisibility(maxDownloadTimes);
		maxDownloadTimes.clear();
		maxDownloadTimes.sendKeys(MaxDownloadTimes);
	}
	
	//
	//WebElement of validation error message of Validity (days)
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_download_validity_in_days")
	WebElement validationValidityDays;
	
	//
	//Function to get validation error message of Validity (days)
	//
	public String getValidationOfValiditydays()
	{
		waitForVisibility(validationValidityDays);
		return validationValidityDays.getText();
	}
	
	//
	//WebElement of Validity Days field
	//
	@FindBy(how=How.NAME,using="selprod_download_validity_in_days")
	WebElement validityDays;
	
	//
	//Function to enter Validity Days in the form
	//
	public void enterValidityDays(String validity_days)
	{
		waitForVisibility(validityDays);
		validityDays.clear();
		validityDays.sendKeys(validity_days);
	}

}
