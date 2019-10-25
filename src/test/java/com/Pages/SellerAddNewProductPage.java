package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerAddNewProductPage {
	
WebDriver driver;
	
	public SellerAddNewProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//Webelement of toggle icon on seller's dashboard
	//
	@FindBy(how=How.CLASS_NAME,using="hamburger-toggle")
	WebElement toggleIcon;
	
	//
	//Function to click on toggle icon on seller's dashboard
	//
	public void clickToggleIcon() throws InterruptedException
	{
		Thread.sleep(5000);
		toggleIcon.click();
		Thread.sleep(500);
	}
	
	//
	//WebElement of Products in left panel of seller dashboard
	//
	@FindBy(how=How.XPATH,using="//a[@href='/seller/catalog']")
	WebElement productIcon;
	
	//
	//Function to click on Products in left panel of seller dashboard
	//
	public void clickOnProductIcon() throws InterruptedException
	{
		waitForVisibility(productIcon);
		productIcon.click();
	}
	
	//
	//WebElement of Add New product link on Marketplace Products page 
	//
	@FindBy(how=How.XPATH,using="//a[@href='/seller/custom-product-form']")
	WebElement addNewproductLink;
	
	//
	//Function to click on Add New product link on Marketplace Products page 
	//
	public void clickOnAddNewProductLink()
	{
		waitForVisibility(addNewproductLink);
		addNewproductLink.click();
	}
	
	//
	//WebElement for Select Your Product Category
	//
	@FindBy(how=How.CSS,using="#categoryblock0 > div > div.simplebar-wrapper > div.simplebar-mask > div > div > div > ul")
	WebElement selectYourProductCategory;
	
	//
	//WebElement to select desired product category
	//
	@FindBy(how=How.CLASS_NAME,using="selectCategory")
	WebElement selectdesiredCategory;
	
	//
	//Function to Select Your Product Category 
	//
	public void clickOnSelectYourProductCategory(String category_Name)
	{
		waitForVisibility(selectYourProductCategory);
		
		List<WebElement> links=selectYourProductCategory.findElements(By.cssSelector("#categoryblock0 > div > div.simplebar-wrapper > div.simplebar-mask > div > div > div > ul > li"));
		for (int i = 0; i < links.size(); i++) 
			{			
				if (links.get(i).getText().equals(category_Name)) 
					{
						links.get(i).click();
					}		
			}
	}
	
	public void clickOnSelectProduct()
	{
		waitForVisibility(selectYourProductCategory);
		selectYourProductCategory.click();
	}
	
	//
	//WebElement of clicking on Select for sub-category
	//
	@FindBy(how=How.CSS,using="#categoryblock1 > div > div.simplebar-wrapper > div.simplebar-mask > div > div > div > ul > li.align--center > a")
	WebElement select;
	
	//
	//Function to click on Select for sub-category
	//
	public void clickOnSelectSubCategory()
	{
		waitForVisibility(select);
		select.click();
	}
	
	//
	//WebElement of mandatory validation error message of Brand/Manufacturer field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_brand_name")
	WebElement mandatoryBrandManufacturer;
	
	//
	//Function to get mandatory validation error message of Brand/Manufacturer field
	//
	public String getMandatoryBrandManufacturer()
	{
		waitForVisibility(mandatoryBrandManufacturer);
		return mandatoryBrandManufacturer.getText();
	}
	
	//
	//WebElement of Brand Name in Add My Product General Basic form
	//
	@FindBy(how=How.NAME,using="brand_name")
	WebElement brandName;
	
	//
	//Function to enter Name in Add My Product General Basic form
	//
	public void enterBrandName(String brand_name)
	{
		waitForVisibility(brandName);
		brandName.sendKeys(brand_name);
	}
	
	//
	//WebElement to select brand from brand drop down and put it in a list
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmCustomProduct > div:nth-child(2) > div:nth-child(1) > div > div.field-wraper > div > ul")
	List<WebElement> selectbrand;
	
	//
	//Function to click desired brand from brand drop down
	//	
	public void clickOnSelectBrandfromDropDown(String brand_name) throws InterruptedException
	{
		Thread.sleep(1000);
		for(int i=0; i<selectbrand.size(); i++)
		{
			if (selectbrand.get(i).getText().equals(brand_name));
				{
					selectbrand.get(i).click();
				}
		 }
	}
	
	//
	//WebElement to click Tax Category from Tax Category drop down and put it in a list
	//
	@FindBy(how=How.NAME,using="ptt_taxcat_id")
	WebElement clickTaxCategory;
	
	//
	//Function to select Tax Category from Tax Category drop down and put it in a list
	//
	public void selectTaxCategory(String tax_category) throws InterruptedException
	{
		waitForVisibility(clickTaxCategory);
		
		List<WebElement> linkstaxcategory=clickTaxCategory.findElements(By.cssSelector("#frm_fat_id_frmCustomProduct > div:nth-child(2) > div:nth-child(3) > div > div.field-wraper > div > select > option"));
		
		for (int i = 0; i < linkstaxcategory.size(); i++) 
		{			
			if (linkstaxcategory.get(i).getText().equals(tax_category)) 
				{
					//System.out.println("This is working fine.");
					linkstaxcategory.get(i).click();
				}		
		}
	}
	
	//
	//WebElement of shipping country field in Add My Product General basic form
	//
	@FindBy(how=How.NAME,using="shipping_country")
	WebElement shippingCountry;
	
	//
	//WebElement to select list of webelements in shipping country suggestion drop down
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmCustomProduct > div:nth-child(6) > div:nth-child(3) > div > div.field-wraper > div > ul")
	List<WebElement> getShippingCountry;
	
	//
	//Function to select desired shipping country coming in suggestion drop down
	//
	public void selectShippingCountry() throws InterruptedException
	{
		waitForVisibility(shippingCountry);
		
		//List<WebElement> listShippingCountry=shippingCountry.findElements(By.cssSelector("#frm_fat_id_frmCustomProduct > div:nth-child(6) > div:nth-child(3) > div > div.field-wraper > div > ul"));
		
		for (int i = 0; i < getShippingCountry.size(); i++)
		{
			Thread.sleep(1000);			
			if (getShippingCountry.get(i).getText().contains("India"))
			{
				getShippingCountry.get(i).click();
			}
		}
	}
	
	//
	//WebElement of Free Shipping checkbox
	//
	@FindBy(how=How.XPATH,using="//span[@class='checkbox']//input[@type='checkbox' and @name='ps_free']")
	WebElement freeShipping;
	
	//
	//Function to click on Free Shipping checkbox
	//
	public void clickOnFreeShippingCheckBox() throws InterruptedException
	{
		Thread.sleep(250);
		freeShipping.click();
	}
	
	public void clickOnFreeShippingCheckBox1() throws InterruptedException
	{
		Thread.sleep(1000);
		
		WebElement freeShippingCheckbox;
		List<WebElement> checkbox = driver.findElements(By.tagName("span"));
		for(int i = 0; i < checkbox.size(); i++)
		{
		     if(checkbox.get(i).getAttribute("class").contains("checkbox") &&
		    		 checkbox.get(i).getAttribute("type").equals("checkbox") &&
		    		 checkbox.get(i).getAttribute("name").equals("ps_free"))
		     			{
		    	 			freeShippingCheckbox = checkbox.get(i);
		    	 			freeShippingCheckbox.click();
		     			}
		}
	}
	
	//
	//WebElement of success message for product setup completion
	//
	@FindBy(how=How.CSS,using="#mbsmessage > div:nth-child(2)")
	WebElement successMessage;
	
	//
	//WebElement 2 of success message for product setup completion
	//
	//@FindBy(how=How.XPATH,using="//div[@id='mbsmessage']//div[@class='content' and contains(text(), 'Request Processing...')]")
	@FindBy(how=How.XPATH,using="//div[@id='mbsmessage']//div[@class='content']")
	WebElement successmessage;
	
	//
	//Function to get success message for product setup completion
	//
	public String getSuccessMessage() throws InterruptedException
	{
		waitForVisibility(successmessage);
		Thread.sleep(250);
		return successmessage.getText();
	}
	
	//
	//WebElement of entered product name so as to match it with created product
	//
	@FindBy(how=How.XPATH,using="//input[@type='text' and @name='product_name']")
	WebElement enteredProductName;
	
	//
	//Functiont to get entered product name so as to match it with created product
	//
	public String getEnteredProductName() throws InterruptedException
	{
		//Thread.sleep(2000);
		waitForVisibility(enteredProductName);
		return enteredProductName.getAttribute("value");
	}
	
	//
	//WebElement of entered product name so as to match it with created product
	//
	@FindBy(how=How.XPATH,using="//*[@id=\"listing\"]/table/tbody/tr[1]/td[2]")
	WebElement actualProductName;
	
	//
	//Functiont to get entered product name so as to match it with created product
	//
	public String getActualCreatedProductName()
	{
		waitForVisibility(actualProductName);
		return actualProductName.getText();
	}
	
	//
	//WebElement of English Tab
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div > div > div > div > div.tabs.tabs-sm.tabs--scroll.clearfix > ul > li:nth-child(2) > a")
	WebElement englishTab;
	
	//
	//Function to click on English Tab
	//
	public void clickOnEnglishTab() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(englishTab);
		englishTab.click();
		Thread.sleep(500);
	}

}
