package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddOptionsPage {
	
	WebDriver driver;
	
	public AdminAddOptionsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//Function to click on Add New Option
	//
	public void clickAddNewOption() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> listCatalog = options.findElements(By.xpath("//*[@id=\"body\"]/aside/div/ul/li[2]/ul/li"));
		
		for(int i = 0; i < listCatalog.size(); i++)
		{
			
			if(listCatalog.get(i).getText().equals("Brands"))
			{
				System.out.println(listCatalog.get(i).getText());
				
				listCatalog.get(i).click();
				
				break;
			}
		}
	}
	
	//
	//WebElement of options from Catalog drop down of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(2) > ul > li:nth-child(9) > a")
	WebElement options;
	
	//
	//Function of clicking options from Catalog drop down of Dashboard drop down
	//
	public void clickOnOptions()
	{
		waitForVisibility(options);
		options.click();
	}
	
	//
	//WebElement of Save Changes of Option Setup form 
	//
	@FindBy(how=How.CSS,using="#frmOptions > div:nth-child(4) > div > div > div.field-wraper > div > input[type=\"submit\"]")
	WebElement saveChanges;
	
	//
	//Function of click on Save Changes of Option Setup form 
	//
	public void clickonSaveChanges() throws InterruptedException
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Mandatory validation for Option Identifier
	//
	@FindBy(how=How.CSS,using="#frmOptions > div:nth-child(1) > div:nth-child(1) > div > div.field-wraper > div > ul > li > a")
	WebElement validationMandatoryOptionIdentifier;
	
	//
	//Function of getting validation message for Mandatory Option Identifier
	//
	public String getvalidationMandatoryOptionIdentifier()
	{
		return validationMandatoryOptionIdentifier.getText();
	}
	
	//
	//WebElement of Mandatory validation error message of Option Name English field.
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_option_name1")
	WebElement validationOptionNameEnglish;
	
	//
	//Function of getting Mandatory validation error message of Option Name English field.
	//
	public String getvalidationOptionNameEnglish()
	{
		return validationOptionNameEnglish.getText();
	}
	
	//
	//WebElement of Option Identifier field of Option Setup form
	//
	@FindBy(how=How.NAME,using="option_identifier")
	WebElement optionIdentifier;
	
	//
	//Function of entering option Identifier
	//
	public void enterOptionIdentifier(String optionidentifier)
	{
		waitForVisibility(optionIdentifier);
		optionIdentifier.clear();
		optionIdentifier.sendKeys(optionidentifier);
	}
	
	//
	//WebElement of Option Name English field of Option Setup form
	//
	@FindBy(how=How.NAME,using="option_name1")
	WebElement optionNameEnglish;
	
	//
	//Function of entering Option Name English field of Option Setup form
	//
	public void enterOptionNameEnglish(String optionnameenglish)
	{		
		waitForVisibility(optionNameEnglish);
		optionNameEnglish.clear();
		optionNameEnglish.sendKeys(optionnameenglish);
	}
	
	//
	//WebElement of Mandatory validation error message of Option Name Arabic field
	//
	@FindBy(how=How.CSS,using="#frmOptions > div:nth-child(2) > div.layout--rtl.col-md-6 > div > div.field-wraper > div > ul > li > a")
	WebElement mandatoryValidationOtionNameArabic;
	
	//
	//Function of getting Mandatory validation error message of Option Name Arabic Field 
	//
	public String getmandatoryValidationOtionNameArabic()
	{
		return mandatoryValidationOtionNameArabic.getText();
	}
	
	//
	//WebElement of Option Name Arabic field
	//
	@FindBy(how=How.NAME,using="option_name2")
	WebElement optionnamearabic;
	
	//
	//Function of entering Option Name Arabic field
	//
	public void enterOptionNameArabic(String optionarabicName)
	{
		waitForVisibility(optionnamearabic);
		optionnamearabic.clear();
		optionnamearabic.sendKeys(optionarabicName);
	}
	
	//
	//WebElement of validation for Duplicated Option Identifier
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement validationDuplicatedOptionIdentifier;
	
	//
	//Function of getting validation error message for Duplicated Option Identifier
	//
	public String getvalidationDuplicatedOptionIdentifier()
	{
		waitForVisibility(validationDuplicatedOptionIdentifier);
		return validationDuplicatedOptionIdentifier.getText();
	}
	
	//
	//WebElement of option Value Listing Edit icon on Option Setup form which comes in Option Value Listing
	//
	@FindBy(how=How.CSS,using="#showHideContainer > div.sectionhead > ul > li > a > i")
	WebElement optionValueListingEdit;
	
	//
	//Function of clicking option Value Listing Edit icon on Option Setup form which comes in Option Value Listing
	//
	public void clickoptionValueListingEdit() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(optionValueListingEdit);
		optionValueListingEdit.click();
	}
	
	//
	//WebElement of option Value Listing Edit icon on Option Setup form which comes in Option Value Listing
	//
	@FindBy(how=How.CSS,using="#showHideContainer > div.sectionhead > ul > li > div > ul > li > a")
	WebElement optionValueListingAddNew;
	
	//
	//Function of clicking option Value Listing Edit icon on Option Setup form which comes in Option Value Listing
	//
	public void clickoptionValueListingAddNew() throws InterruptedException
	{
		Thread.sleep(5000);
		waitForVisibility(optionValueListingAddNew);
		optionValueListingAddNew.click();
	}
	
	//
	//WebElement of save Changes of Configure OptionValues
	//
	@FindBy(how=How.CSS,using="#frmOptionValues > div:nth-child(4) > div > div > div.field-wraper > div > input[type=\"submit\"]:nth-child(1)")
	WebElement saveChangesConfigureOptionValues;
	
	//
	//Function to click on save Changes of Configure OptionValues
	//
	public void clicksaveChangesConfigureOptionValues()
	{
		waitForVisibility(saveChangesConfigureOptionValues);
		saveChangesConfigureOptionValues.click();
	}
	
	//
	//WebElement of Mandatory validation error message for Option Value Identifier
	//
	@FindBy(how=How.CSS,using="#frmOptionValues > div:nth-child(1) > div > div > div.field-wraper > div > ul > li > a")
	WebElement MandatoryvalidationforOptionValueIdentifier;
	
	//
	//Function of getting text of Mandatory validation error message for Option Value Identifier
	//
	public String getMandatoryvalidationforOptionValueIdentifier()
	{
		return MandatoryvalidationforOptionValueIdentifier.getText();
	}
	
	//
	//WebElement of Option Value Identifier field
	//
	@FindBy(how=How.NAME,using="optionvalue_identifier")
	WebElement optionValueIdentifier;
	
	//
	//Function of entering Option Value Identifier field
	//
	public void enterOptionValuIidentifier(String optionvalueidentifier)
	{
		waitForVisibility(optionValueIdentifier);
		optionValueIdentifier.clear();
		optionValueIdentifier.sendKeys(optionvalueidentifier);
	}
	
	//
	//WebElement of Mandatory validation error message for Option Value Name English
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_optionvalue_name1")
	WebElement validationotionvaluenameenglish;
	
	//
	//Function of getting Mandatory validation error message for Option Value Name English
	//
	public String getvalidationOtionValuenameEnglish()
	{
		waitForVisibility(validationotionvaluenameenglish);
		return validationotionvaluenameenglish.getText();
	}
	
	//
	//WebElement of Option Value Name English field
	//
	@FindBy(how=How.NAME,using="optionvalue_name1")
	WebElement optionValueNameEnglish;
	
	//
	//Function of entering Option Value Name English field
	//
	public void enterOptionValueNameEnglish(String optionvaluenameenglish)
	{
		waitForVisibility(optionValueNameEnglish);
		optionValueNameEnglish.clear();
		optionValueNameEnglish.sendKeys(optionvaluenameenglish);
	}
	
	//
	//WebElement of Mandatory validation error message for Option Value Name Arabic
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_optionvalue_name2")
	WebElement validationotionvaluenameArabic;
	
	//
	//Function of getting Mandatory validation error message for Option Value Name Arabic
	//
	public String getvalidationOtionValuenameArabic()
	{
		waitForVisibility(validationotionvaluenameArabic);
		return validationotionvaluenameArabic.getText();
	}
	
	//
	//WebElement of Option Value Name Arabic field
	//
	@FindBy(how=How.NAME,using="optionvalue_name2")
	WebElement optionValueNameArabic;
	
	//
	//Function of entering Option Value Name Arabic field
	//
	public void enterOptionValueNameArabic(String optionvaluenamearabic)
	{
		waitForVisibility(optionValueNameArabic);
		optionValueNameArabic.clear();
		optionValueNameArabic.sendKeys(optionvaluenamearabic);
	}
	
	//
	//WebElement of Vadliation error message of duplicate Option Value Identifier
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement duplicateOptionValueIdentifier;
	
	//
	//Function of getting Vadliation error message of duplicate Option Value Identifier
	//
	public String getduplicateOptionValueIdentifier()
	{
		waitForVisibility(duplicateOptionValueIdentifier);
		return duplicateOptionValueIdentifier.getText();
	}

}
