package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddNewTaxPage {
	
WebDriver driver;
	
	public AdminAddNewTaxPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement to click on Settings
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(6) > a")
	WebElement settings;
	
	//
	//Function to click on Settings
	//
	public void clickonSettings() throws InterruptedException
	{
		//new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.className("page-container")));
		Thread.sleep(2000);
		waitForVisibility(settings);
		settings.click();
	}
	
	//WebElement of Sales Tax
	//
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(6) > ul > li:nth-child(4) > a")
	WebElement salesTax;
	
	//
	//Function to click on Sales Tax
	//
	public void clickOnSalesTax()
	{
		waitForVisibility(salesTax);
		salesTax.click();
	}
	
	//
	//WebElement of Add New Icon on Manage Tax Page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > a > i")
	WebElement addNewIcon;
	
	//
	//Function to click on Add New Icon
	//
	public void clickOnAddNewIcon()
	{
		waitForVisibility(addNewIcon);
		addNewIcon.click();
	}
	
	//
	//WebElement of add new tax
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li:nth-child(2) > a")
	WebElement addNewTax;
	
	//
	//Function to click on add new tax
	//
	public void clickOnAddNewTax() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul"));
		
		 List<WebElement> verticalLinks = dropdown.findElements(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li"));
		 
		 for (int i = 0; i < verticalLinks.size(); i++) 
		 	{	
			 	if (verticalLinks.get(i).getText().contentEquals("Add New Tax"))
			 		{
			 			Thread.sleep(500);
			 			verticalLinks.get(i).click();
			 		}	
		 	}
	}
	
	//
	//WebElement of Save Changes button
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
		
	//
	//WebElement of Mandatory validation error message of Tax Category Identifier field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_taxcat_identifier")
	WebElement mandatoryTaxCatagoryIdentifier;
	
	//
	//Function to get Mandatory Validation error message of Tax Category Identifier field
	//
	public String getMandatoryValidationTaxCategoryIdentifier()
	{
		waitForVisibility(mandatoryTaxCatagoryIdentifier);
		return mandatoryTaxCatagoryIdentifier.getText();
	}
	
	//
	//WebElement of Tax Category Identifier to fill the field for the form
	//
	@FindBy(how=How.NAME,using="taxcat_identifier")
	WebElement taxcategoryidentifier;
	
	//
	//Function to enter Tax Category Identifier to fill the field for the form
	//
	public void enterTaxCategoryIdentifier(String taxcatidentifer)
	{
		waitForVisibility(taxcategoryidentifier);
		taxcategoryidentifier.clear();
		taxcategoryidentifier.sendKeys(taxcatidentifer);
	}
	
	//
	//WebElement of Mandatory validation error message of Value field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_taxval_value")
	WebElement mandatoryValidationValue;
	
	//
	//Function to get Mandatory validation error message of Value field
	//
	public String getMandatoryValidationValue()
	{
		waitForVisibility(mandatoryValidationValue);
		return mandatoryValidationValue.getText();
	}
	
	//
	//WebElement of Value field
	//
	@FindBy(how=How.NAME,using="taxval_value")
	WebElement valueField;
	
	//
	//Function to enter Value Field
	//
	public void enterValue(String value)
	{
		waitForVisibility(valueField);
		valueField.clear();
		valueField.sendKeys(value);
	}
	
	//
	//WebElement of Update button
	//
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @name='btn_submit' and @value='Update']")
	WebElement updateButton;
	
	//
	//Function to click on Update button
	//
	public void clickOnUpdateButton() throws InterruptedException
	{
		Thread.sleep(2500);
		waitForVisibility(updateButton);
		updateButton.click();
	}
	
	//
	//WebElement of Mandatory validation error message of Tax Category Name field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_taxcat_name")
	WebElement mandatoryTaxCatagoryName;
	
	//
	//Function to get Mandatory Validation error message of Tax Category Name field
	//
	public String getMandatoryValidationTaxCategoryName()
	{
		waitForVisibility(mandatoryTaxCatagoryName);
		return mandatoryTaxCatagoryName.getText();
	}
	
	//
	//WebElement of Tax Category Name field
	//
	@FindBy(how=How.XPATH,using="//input[@type='text' and @name='taxcat_name']")
	WebElement taxCategoryName;
	
	//
	//Function to enter of Tax Category Name field
	//
	public void enterTaxCategoryName(String taxcategoryname)
	{
		waitForVisibility(taxCategoryName);
		taxCategoryName.sendKeys(taxcategoryname);
	}
	
	//
	//WebElement of Successful message of Tax Setup
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--success")
	WebElement successTaxSetup;
	
	//
	//Function to get Mandatory Validation error message of Tax Category Name field
	//
	public String getSuccessTaxSetup()
	{
		waitForVisibility(successTaxSetup);
		return successTaxSetup.getText();
	}

}
