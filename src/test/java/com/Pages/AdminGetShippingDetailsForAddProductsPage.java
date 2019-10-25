package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminGetShippingDetailsForAddProductsPage {
	
WebDriver driver;
	
	public AdminGetShippingDetailsForAddProductsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }

	//
	//WebElement of first Shipping Duration Label
	//
	@FindBy(how=How.CSS,using="#listing > table > tbody > tr:nth-child(1) > td:nth-child(2)")
	WebElement shippingdurationlabel;
	
	//
	//Function to get first Shipping Duration Label
	//
	public String getShppingDurationLabel()
	{
		waitForVisibility(shippingdurationlabel);
		return shippingdurationlabel.getText();
	}
}
