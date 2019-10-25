package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerProductVolumeDiscountPage {
	
WebDriver driver;
	
	public SellerProductVolumeDiscountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Volume Discount link on Inventory Setup page
	//
	@FindBy(how=How.LINK_TEXT,using="Volume Discount")
	WebElement volumeDiscount;
	
	//
	//Function to click on Volume Discount link on Inventory Setup page
	//
	public void clickOnVolumeDiscount()
	{
		waitForVisibility(volumeDiscount);
		volumeDiscount.click();
	}
	
	//
	//WebElement of Inventory Setup list on product inventory setup form
	//
	@FindBy(how=How.CSS,using="#listing > div.tabs.tabs--small.tabs--scroll.clearfix > ul")
	WebElement inventoryMenuList;
	
	//
	//Function to click on special price on product inventory setup form
	//
	public void click_Volume_Discount()
	{
		waitForVisibility(inventoryMenuList);
		List<WebElement> inventorySetupList = inventoryMenuList.findElements(By.cssSelector("#listing > div.tabs.tabs--small.tabs--scroll.clearfix > ul > li"));
		for(int i = 0; i < inventorySetupList.size(); i++)
		{
			if(inventorySetupList.get(i).getText().contains("Volume Discount"))
			{
				inventorySetupList.get(i).click();
				break;
			}
		}
	}
	
	
	//
	//WebElement of Add New Volume Discount button under Volume Discount on Inventory Setup page
	//
	@FindBy(how=How.LINK_TEXT,using="Add New Volume Discount")
	WebElement addNewVolumeDiscount;
	
	//
	//Function to click on Add New Volume Discount button under Volume Discount on Inventory Setup page
	//
	public void clickOnAddNewVolumeDiscount() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(addNewVolumeDiscount);
		addNewVolumeDiscount.click();
	}
	
	//
	//WebElement of Manage Volume Discount button under Volume Discount on Inventory Setup page
	//
	@FindBy(how=How.LINK_TEXT,using="Manage Volume Discount")
	WebElement manageVolumeDiscount;
	
	//
	//Function to click on Add New Volume Discount button under Volume Discount on Inventory Setup page
	//
	public void clickOnmanageVolumeDiscount() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(manageVolumeDiscount);
		manageVolumeDiscount.click();
	}
	
	
	
	//
	//WebElement of Save Changes button in Volume Discount form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button in Volume Discount form
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Save Changes button in Manage Volume Discount page
	//
	@FindBy(how=How.NAME,using="btn_update")
	WebElement save_Changes;
	
	//
	//Function to click on Save Changes button in Manage Volume Discount page
	//
	public void clickOnSave_Changes()
	{
		waitForVisibility(save_Changes);
		save_Changes.click();
	}
	
	//
	//WebElement of validation error message of Minimum Quantity on Volume Discount form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_voldiscount_min_qty")
	WebElement validationMinimumQuantity;
	
	//
	//Function to get validation error message of Minimum Quantity on Volume Discount form
	//
	public String getVlidationMinimumQuantity()
	{
		waitForVisibility(validationMinimumQuantity);
		return validationMinimumQuantity.getText();
	}
	
	//
	//WebElement of Minimum Quantity field of Volume Discount form
	//
	@FindBy(how=How.NAME,using="voldiscount_min_qty")
	WebElement minimumQuantity;
	
	//
	//Function to enter Minimum Quantity field of Volume Discount form
	//
	public void enterMinimumQuantity(String minimum_quantity)
	{
		waitForVisibility(minimumQuantity);
		minimumQuantity.clear();
		minimumQuantity.sendKeys(minimum_quantity);
	}
	
	//
	//WebElement of validation error message of Discount In field of Volume Discount form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_voldiscount_percentage")
	WebElement validationDiscountIn;
	
	//
	//Function to get validation error message of Discount In field of Volume Discount form
	//
	public String getValidationDiscountIn()
	{
		waitForVisibility(validationDiscountIn);
		return validationDiscountIn.getText();
	}
	
	//
	//WebElement Discount In of Volume Discount form
	//
	@FindBy(how=How.NAME,using="voldiscount_percentage")
	WebElement discountIn;
	
	//
	//Function to enter Discount In of Volume Discount form
	//
	public void enterDiscountIn(String discount_in)
	{
		waitForVisibility(discountIn);
		discountIn.clear();
		discountIn.sendKeys(discount_in);
	}
	
	//
	//WebElement of created discount 
	//
	@FindBy(how=How.CLASS_NAME,using="form__subcontent")
	WebElement createdDiscount;
	
	//
	//Function to get created discount 
	//
	public String getCreatedDiscount() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(createdDiscount);
		return createdDiscount.getText();
	}
	
	//
	//WebElement of created another discount 
	//
	@FindBy(how=How.ID,using="listing")
	WebElement createdAnotherDiscount;
	
	//
	//Function to get created discount 
	//
	public String getCreatedAnotherDiscount() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(createdAnotherDiscount);
		return createdAnotherDiscount.getText();
	}
	
	//
	//WebElement of Add New Volume Discount top button
	//
	@FindBy(how=How.CSS,using="#listing > div.cards-header.p-3 > div > a")
	WebElement addNewDiscount;
	
	//
	//Function to click on Add New Volume Discount top button
	//
	public void clickOnAddNewDiscountAother() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(addNewDiscount);
		addNewDiscount.click();
	}
	
	//
	//WebElement for the validaion error message for complete form
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-top-full.alert--danger > div.content")
	WebElement validationForm;
	
	//
	//Function to get the validaion error message for complete form
	//
	public String getValidationForm() throws InterruptedException
	{
		//Thread.sleep(500);
		waitForVisibility(validationForm);
		return validationForm.getText();
	}
	
	//
	//WebElement of close icon of Volume Discount form
	//
	@FindBy(how=How.CLASS_NAME,using="close--white")
	WebElement closeIcon;
	
	//
	//Function to click on close icon of Volume Discount form
	//
	public void clickOnCloseIcon()
	{
		waitForVisibility(closeIcon);
		closeIcon.click();
	}

}
