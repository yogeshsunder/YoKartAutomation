package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCheckoutwithSpecialPricePage {
	
WebDriver driver;
	
	public UserCheckoutwithSpecialPricePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Buy Now button on Product Detail Page
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div.cards-content.pl-4.pr-4 > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
	WebElement specialPrice;
	
	//
	//Function to Click on Buy Now button on Product Detail Page
	//
	public String getActualSpecialPrice()
	{
		waitForVisibility(specialPrice);
		return specialPrice.getText();
	}
	
	//
	//WebElement of Special product price on Search Page
	//
	@FindBy(how=How.CLASS_NAME,using="products__price")
	WebElement productPriceonSearch;
	
	//
	//Function to get Special product price on Search Page
	//
	public String getProductPriceonSearch()
	{
		waitForVisibility(productPriceonSearch);
		return productPriceonSearch.getText();
	}
	
	//
	//WebElement of Special product price on Order Summary Page
	//
	@FindBy(how=How.CLASS_NAME,using="product_price")
	WebElement productPriceonOrderSummaryPage;
	
	//
	//Function to get Special product price on Order Summary Page
	//
	public String getProductPriceonproductPriceonOrderSummaryPage()
	{
		waitForVisibility(productPriceonOrderSummaryPage);
		return productPriceonOrderSummaryPage.getText();
	}
	
	//
	//WebElement of Special product price on Shipping Summary Page
	//
	@FindBy(how=How.CLASS_NAME,using="product_price")
	WebElement productPriceonShippingSummparyPage;
	
	//
	//Function to get Special product price on Search Page
	//
	public String getProductPriceonShippingSummparyPage()
	{
		waitForVisibility(productPriceonShippingSummparyPage);
		return productPriceonShippingSummparyPage.getText();
	}
	
	//
	//WebElement of History on Congratulations Screen
	//
	@FindBy(how=How.XPATH,using="//a[@href='/buyer/orders']")
	WebElement history;
	
	//
	//Function to click on History link on Congratulations Screen
	//
	public void clickHistory() throws InterruptedException
	{
		Thread.sleep(10000);
		waitForVisibility(history);
		history.click();
	}
	
	//
	//WebElement of eye icon on Order History screen for the latest order
	//
	@FindBy(how=How.CLASS_NAME,using="fa-eye")
	WebElement eyeIcon;
	
	//
	//Function to click on eye icon on Order History screen for the latest order
	//
	public void clickEyeIcon()
	{
		waitForVisibility(eyeIcon);
		eyeIcon.click();
	}
	
	//
	//WebElement of Selling Price on Order Details for the latest order
	//
	@FindBy(how=How.CSS,using="#main-area > div > div.content-body > div > div.cards-content.pl-4.pr-4 > table > tbody > tr:nth-child(2) > td:nth-child(4)")
	WebElement sellingPrice;
	
	//
	//Function to get Selling Price on Order Details for the latest order
	//
	public String getSellingPrice()
	{
		waitForVisibility(sellingPrice);
		return sellingPrice.getText();
	}
	

}
