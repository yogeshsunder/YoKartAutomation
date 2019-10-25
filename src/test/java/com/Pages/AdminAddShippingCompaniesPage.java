package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddShippingCompaniesPage {
	
WebDriver driver;
	
	public AdminAddShippingCompaniesPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of option shipping companies under Shipping API drop down in Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(5) > ul > li:nth-child(3) > a")
	WebElement shippingCompanies;
	
	//
	//Function to click on option shipping companies under Shipping API drop down in Dashboard drop down
	//
	public void clickOnShippingCompanies()
	{
		waitForVisibility(shippingCompanies);
		shippingCompanies.click();
	}
	
	//
	//WebElement of Add New icon on Manage Shipping Companies
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > a > i")
	WebElement addNewIcon;
	
	//
	//Function to click on Add New icon on Manage Shipping Companies
	//
	public void clickOnAddNewIcon()
	{
		waitForVisibility(addNewIcon);
		addNewIcon.click();
	}
	
	//
	//WebElement of Add New option on Manage Shipping Companies page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > div > ul > li > a")
	WebElement addNew;
	
	//
	//Function to click on Add New option on Manage Shipping Companies page
	//
	public void clickOnAddNew()
	{
		waitForVisibility(addNew);		
		addNew.click();
	}
	
	//
	//WebElement of save Changes General
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement saveChangesGeneral;
	
	//
	//Function to click on save Changes General
	//
	public void clickOnSaveChangesGeneral() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(saveChangesGeneral);
		saveChangesGeneral.click();
	}
	
	//
	//WebElement of mandatory Shipping Identifier
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_scompany_identifier")
	WebElement mandatoryShippingIdentifier;
	
	//
	//Function of getting mandatory Shipping Identifier
	//
	public String getmandatoryShippingIdentifier()
	{
		waitForVisibility(mandatoryShippingIdentifier);
		return mandatoryShippingIdentifier.getText();
	}
	
	//
	//WebElement of Shipping Identifier in Shipping Company General form
	//
	@FindBy(how=How.XPATH,using="//input[@type='text' and @name='scompany_identifier']")
	WebElement shippingIdentifier;
	
	//
	//Function to enter Shipping Identifier in Shipping Company General form
	//
	public void enterShippingIdentifier(String shippingidentifier)
	{
		waitForVisibility(shippingIdentifier);
		shippingIdentifier.clear();
		shippingIdentifier.sendKeys(shippingidentifier);
	}	
	
	//
	//WebElement of duplicate Shipping Identifier validation error message
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement duplicateShippingIdentifier;
	
	//
	//Function of duplicate Shipping Identifier validation error message
	//
	public String getduplicateShippingIdentifier()
	{
		waitForVisibility(duplicateShippingIdentifier);
		return duplicateShippingIdentifier.getText();
	}
	
	//
	//WebElement of mandatory Shipping API Name English
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_scompany_name")
	WebElement mandatoryShippingApiNameEnglish;
	
	//
	//Function of getting mandatory Shipping API Name English
	//
	public String getmandatoryShippingApiNameEnglish()
	{
		waitForVisibility(mandatoryShippingApiNameEnglish);
		return mandatoryShippingApiNameEnglish.getText();
	}
	
	//
	//WebElement of Shipping API Name in Shipping Company English form
	//
	@FindBy(how=How.XPATH,using="//input[@type='text' and @name='scompany_name']")
	WebElement shippingApiNameEnglish;
	
	//
	//Function to enter Shipping API Name in Shipping Company English form
	//
	public void enterShippingApiNameEnglish(String shippingapinameenglish)
	{
		waitForVisibility(shippingApiNameEnglish);
		shippingApiNameEnglish.clear();
		shippingApiNameEnglish.sendKeys(shippingapinameenglish);
	}
	
	//
	//WebElement of mandatory Shipping API Name Arabic
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_scompany_name")
	WebElement mandatoryShippingApiNameArabic;
	
	//
	//Function of getting mandatory Shipping API Name Arabic
	//
	public String getmandatoryShippingApiNameArabic()
	{
		waitForVisibility(mandatoryShippingApiNameArabic);
		return mandatoryShippingApiNameArabic.getText();
	}
	
	//
	//WebElement of Shipping API Name in Shipping Company Arabic form
	//
	@FindBy(how=How.XPATH,using="//input[@type='text' and @name='scompany_name']")
	WebElement shippingApiNameArabic;
	
	//
	//Function to enter Shipping API Name in Shipping Company Arabic form
	//
	public void enterShippingApiNameArabic(String shippingapinameArabic)
	{
		waitForVisibility(shippingApiNameArabic);
		shippingApiNameArabic.clear();
		shippingApiNameArabic.sendKeys(shippingapinameArabic);
	}
	
	//
	//WebElement of Successful message for creating Shipping Company
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--success")
	WebElement successMessage;
	
	//
	//Function of getting Successful message for creating Shipping Company
	//
	public String getsuccessMessage()
	{
		waitForVisibility(successMessage);
		return successMessage.getText();
	}

}
