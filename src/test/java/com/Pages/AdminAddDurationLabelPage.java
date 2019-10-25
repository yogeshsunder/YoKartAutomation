package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddDurationLabelPage {
	
WebDriver driver;
	
	public AdminAddDurationLabelPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Shipping API of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(5) > a")
	WebElement shippingAPI;
	
	//
	//Function to click on Shipping API of Dashboard drop down
	//
	public void clickOnShippingAPI() throws InterruptedException
	{
		Thread.sleep(1000);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(shippingAPI));
		waitForVisibility(shippingAPI);
		shippingAPI.click();
	}
	
	//
	//WebElement of Duration Labels option under Shipping API in Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(5) > ul > li:nth-child(2) > a")
	WebElement durationLabels;
	
	//
	//Function to click on Duration Labels option under Shipping API in Dashboard drop down
	//
	public void clickOnDurationLabels()
	{
		waitForVisibility(durationLabels);
		durationLabels.click();
	}
	
	//
	//WebElement of Add New Icon on Manage Shipping Durations page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > a > i")
	WebElement addNewIcon;
	
	//
	//Function to click on Add New Icon on Manage Shipping Durations page
	//
	public void clickOnAddNewIcon()
	{
		waitForVisibility(addNewIcon);
		addNewIcon.click();
	}
	
	//
	//WebElement of Add New on Manage Shipping Durations page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li > a")
	WebElement addNew;
	
	//
	//Function to click on Add New on Manage Shipping Durations page
	//
	public void clickOnAddNew()
	{
		waitForVisibility(addNew);
		addNew.click();
	}
	
	//
	//WebElement of Save Changes General on Manage Shipping Durations page
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement saveChangesGeneral;
	
	//
	//Function to click on Add New on Manage Shipping Durations page
	//
	public void clickOnSaveChangesGeneral() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(saveChangesGeneral);
		saveChangesGeneral.click();
	}
	
	//
	//WebElement of mandatory Validation error message for Identifier field of Shipping Duration Label General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_sduration_identifier")
	WebElement mandatoryValidationIdentifier;
	
	//
	//Funciton of getting mandatory Validation error message for Identifier field of Shipping Duration Label General form
	//
	public String getMandatoryValidationIdentifier()
	{
		waitForVisibility(mandatoryValidationIdentifier);
		return mandatoryValidationIdentifier.getText();
	}
	
	//
	//WebElement of Identifier field of Shipping Duration Label General form
	//
	@FindBy(how=How.NAME,using="sduration_identifier")
	WebElement identifier;
	
	//
	//Function to enter Identifier field of Shipping Duration Label General form
	//
	public void enterIdentifier(String Identifier)
	{
		waitForVisibility(identifier);
		identifier.sendKeys(Identifier);;
	}
	
	//
	//WebElement of Label field Mandatory Validation error message of Shipping Duration Label English form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmShippingDurationLang > div:nth-child(1) > div > div > div.field-wraper > div > ul > li > a")
	WebElement mandatoryvalidationLabelEnglish;
	
	//
	//Function of getting Label field Mandatory Validation error message of Shipping Duration Label English form
	//
	public String getMandatoryValidationLabelEnglish()
	{
		waitForVisibility(mandatoryvalidationLabelEnglish);
		return mandatoryvalidationLabelEnglish.getText();
	}
	
	//
	//WebElement of Label field of Shipping Duration Label English form
	//
	@FindBy(how=How.XPATH,using="//input[@name='sduration_name' and @class='error']")
	WebElement labelEnglish;
	
	//
	//Function of entering value in Label field of Shipping Duration Label English form
	//
	public void enterLabelEnglish(String labelenglish)
	{
		waitForVisibility(labelEnglish);
		labelEnglish.sendKeys(labelenglish);
	}
	
	//
	//WebElement of Mandatory validation error message of Label field of Shipping Duration Label Arabic form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_sduration_name")
	WebElement mandatoryValidationLabelArabic;
	
	//
	//Function of getting Mandatory validation error message of Label field of Shipping Duration Label Arabic form
	//
	public String getmandatoryValidationLabelArabic()
	{
		waitForVisibility(mandatoryValidationLabelArabic);
		return mandatoryValidationLabelArabic.getText();
	}
	
	//
	//WebElement of Label field of Shipping Duration Label Arabic form
	//
	@FindBy(how=How.XPATH,using="//input[@name='sduration_name' and @class='error']")
	WebElement labelArabic;
	
	//
	//Function of entering value in Label field of Shipping Duration Label English form
	//
	public void enterlabelArabic(String labelearabic)
	{
		waitForVisibility(labelArabic);
		labelArabic.sendKeys(labelearabic);
	}

}
