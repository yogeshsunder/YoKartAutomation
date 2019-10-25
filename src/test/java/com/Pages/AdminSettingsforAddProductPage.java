package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSettingsforAddProductPage {
	
WebDriver driver;
	
	public AdminSettingsforAddProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of General Settings under Settings in Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(6) > ul > li:nth-child(1) > a")
	WebElement generalSettings;
	
	//
	//Function to click on General Settings under Settings in Dashboard drop down
	//
	public void clickOnGeneralSettings()
	{
		waitForVisibility(generalSettings);
		generalSettings.click();
	}
	
	//
	//WebElement of Product option on General Settings page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > div.tabs_nav_container.vertical > ul > li:nth-child(5) > a")
	WebElement product;
	
	//
	//Function to click on Product option on General Settings page
	//
	public void clickOnProduct() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(product);
		product.click();
	}
	
	//
	//WebElement of Product's Model Mandatory
	//
	@FindBy(how=How.NAME,using="CONF_PRODUCT_MODEL_MANDATORY")
	WebElement productModelMandatory;
	
	//
	//Function to Check Product Model Mandatory Checked if not check it
	//
	public void checkproductModelMandatoryChecked() throws InterruptedException
	{
		Thread.sleep(2000);
		//waitForVisibility(productModelMandatory);
		if(!productModelMandatory.isSelected())
			productModelMandatory.click();
	}
	
	//
	//WebElement of Product's Sku Mandatory
	//
	@FindBy(how=How.NAME,using="CONF_PRODUCT_SKU_MANDATORY")
	WebElement productSkuMandatory;
	
	//
	//Function to Check Product's Sku Mandatory Checked if not check it
	//
	public void checkproductSkuMandatoryChecked() throws InterruptedException
	{
		Thread.sleep(2000);
		//waitForVisibility(productModelMandatory);
		if(!productSkuMandatory.isSelected())
			productSkuMandatory.click();
	}
	
	//
	//WebElement of Product's Dimensions
	//
	@FindBy(how=How.NAME,using="CONF_PRODUCT_DIMENSIONS_ENABLE")
	WebElement productDimensions;
	
	//
	//Function to Check Product's Dimensions Mandatory Checked if not check it
	//
	public void checkproductDimensionsChecked() throws InterruptedException
	{
		Thread.sleep(2000);
		//waitForVisibility(productModelMandatory);
		if(!productDimensions.isSelected())
			productDimensions.click();
	}
	
	//
	//WebElement of Save Changes button
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	

}
