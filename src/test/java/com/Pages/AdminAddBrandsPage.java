package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddBrandsPage {
	
	WebDriver driver;
	String brandidentifier;
	
	public AdminAddBrandsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Left Menu option of Dashboard drop down
	//
	@FindBy(how=How.CLASS_NAME,using="leftmenu")
	WebElement leftMenu;
	
	//
	//Function to click on Catalog option of Dashboard drop down
	//
	public void clickonCatalog() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> listMenu = leftMenu.findElements(By.cssSelector("#body > aside > div > ul > li"));
		
		for(int i = 0; i < listMenu.size(); i++)
		{			
			if(listMenu.get(i).getText().equals("Catalog"))
			{
				listMenu.get(i).click();
			}
		}
	}
	
	//
	//WebElement of brands option of Catalog drop down option of Dashboard drop down
	//
	@FindBy(how=How.CLASS_NAME,using="haschild")
	WebElement brands;
	
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(2) > ul > li:nth-child(8) > a")
	WebElement brand;
	
	public void clickBrands() throws InterruptedException
	{
		Thread.sleep(2000);
		brand.click();
	}
	
	//
	//Function to click on brands option of Catalog drop down option of Dashboard drop down
	//
	public void clickonBrands() throws InterruptedException
	{
		Thread.sleep(2000);
		List<WebElement> listCatalog = brands.findElements(By.xpath("//*[@id=\"body\"]/aside/div/ul/li[2]/ul/li"));
		
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
	//WebElement of Edit Brands option of Catalog drop down option of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > a > i")
	WebElement editIconBrandList;
	
	//
	//Function to click on Edit Brands option of Catalog drop down option of Dashboard drop down
	//
	public void clickoneditIconofBrandList() throws InterruptedException
	{
		Thread.sleep(5000);
		waitForVisibility(editIconBrandList);
		editIconBrandList.click();
	}
	
	//
	//WebElement of add Brand on add brand page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li:nth-child(6) > a")
	WebElement addBrand;
	
	//
	//Function of clicking add Brand on add brand page
	//
	public void clickonaddBrand() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(addBrand);
		addBrand.click();
	}
	
	//
	//Function of clicking add Brand on add brand page
	//
	public void clickAddBrands() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul"));
		 List<WebElement> verticalLinks = dropdown.findElements(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li"));
		 
		 for (int i = 0; i < verticalLinks.size(); i++) 
		 	{
			 	if (verticalLinks.get(i).getText().equals("Add Brand")) 
			 		{
			 			Thread.sleep(500);
			 			verticalLinks.get(i).click();
			 		}	
		 	}
	}
	
	//
	//WebElement of Brand Identifier in Product Brand Setup General form
	//
	@FindBy(how=How.XPATH,using="//input[@name='brand_identifier' and @type='text']")
	WebElement brandIdentifier;
	
	//
	//Function of Brand Identifier in Product Brand Setup General form
	//
	public void enterBrandIdentifier(String brandidentifier)
	{
		waitForVisibility(brandIdentifier);
		brandIdentifier.clear();
		brandIdentifier.sendKeys(brandidentifier);
	}
	
	//
	//WebElement of Brand SEO Friendly URLfield of General Product Brand Setup form
	//
	@FindBy(how=How.XPATH,using="//input[@name='urlrewrite_custom' and @type='text']")
	WebElement urlrewrite;
	
	//
	//Function of clearing BrandSEOFriendlyURL field of General Product Brand Setup form
	//
	public void clearBrandSEOFriendlyURL()
	{
		waitForVisibility(urlrewrite);
		urlrewrite.clear();
	}
	
	//
	//Function of clearing BrandSEOFriendlyURL field of General Product Brand Setup form
	//
	public void enterBrandSEOFriendlyURL(String urlRewrite)
	{
		waitForVisibility(urlrewrite);
		urlrewrite.clear();
		urlrewrite.sendKeys(urlRewrite);
	}
	
	//
	//WebElement of add new button on Product Brand Setup General form
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Add New']")
	WebElement addNew;
	
	//
	//Function of add new button on Product Brand Setup General form
	//
	public void clickonAddNew()
	{
		waitForVisibility(addNew);
		addNew.click();
	}
	
	//
	//WebElement of Update button on Product Brand Setup General form
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Update']")
	WebElement update;
	
	//
	//Function of Update button on Product Brand Setup General form
	//
	public void clickonUpdate()
	{
		waitForVisibility(update);
		update.click();
	}
	
	//
	//WebElement of getting validation error message of Brand Identifier* field of Product Brand Setup	General
	//
	@FindBy(how=How.CSS,using="#prodBrand > div:nth-child(1) > div > div > div.field-wraper > div > ul > li > a")
	WebElement validationBrandIdentifier;
	
	//
	//Function of getting validation error message of Brand Identifier* field of Product Brand Setup	General
	//
	public String validationMsgBrandIdentifier()
	{
		waitForVisibility(validationBrandIdentifier);
		return validationBrandIdentifier.getText();
	}
	
	//
	//WebElement of getting validation error message of Brand SEO Friendly URL field of Product Brand Setup	General
	//
	@FindBy(how=How.CSS,using="#prodBrand > div:nth-child(2) > div > div > div.field-wraper > div > ul > li > a")
	WebElement validationBrandSEOFriendlyURL;
	
	//
	//Function of getting validation error message of Brand SEO Friendly URL field of Product Brand Setup	General
	//
	public String validationMsgBrandSEOFriendlyURL()
	{
		waitForVisibility(validationBrandSEOFriendlyURL);
		return validationBrandSEOFriendlyURL.getText();
	}

	
	//
	//WebElement of Brand Name* in Product Brand Setup English form
	//
	@FindBy(how=How.XPATH,using="//input[@name='brand_name' and @type='text']")
	WebElement productBrand;

	//
	//Function of Brand Name* in Product Brand Setup English form
	//
	public void enterBrandName(String productbrand)
	{
		waitForVisibility(productBrand);
		productBrand.clear();
		productBrand.sendKeys(productbrand);
	}
	
	//
	//WebElement of Upload Logo button on Media Product Brand setup form
	//
	@FindBy(how=How.ID,using="logo")
	WebElement clickUploadLogo;
	
	//
	//Function to click on Upload Logo button on Media Product Brand setup form
	//
	public void clickonUploadLogo()
	{
		waitForVisibility(clickUploadLogo);
		clickUploadLogo.click();
	}
	
	//
	//WebElement of close Icon of Media Product Brand setup form
	//
	@FindBy(how=How.CLASS_NAME,using="close_image")
	WebElement crossicon;
	
	//
	//Function to click on close Icon button on Media Product Brand setup form
	//
	public void clickonCrossIcon()
	{
		waitForVisibility(clickUploadLogo);
		crossicon.click();
	}
	
	//
	//WebElement of getting duplicate Validation for Brand Iderntifier of Product Brand Setup
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement duplicateValidationforBrandIderntifier;
	
	//
	//Function to get duplicate Validation for Brand Iderntifier of Product Brand Setup
	//
	public String getduplicateValidationforBrandIderntifier()
	{
		waitForVisibility(duplicateValidationforBrandIderntifier);
		return duplicateValidationforBrandIderntifier.getText();
	}
	
	//
	//Web Element of Update Button of English Product Brand Setup form
	//
	@FindBy(how=How.CSS,using="#prodBrand > div:nth-child(3) > div > div > div.field-wraper > div > input[type=\"submit\"]")
	WebElement updateButton;
	
	//
	//click on update Button
	//
	public void clickonupdateButton() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(updateButton);
		updateButton.click();
	}
	
	//
	//click on update Button on Arabic form
	//
	public void clickonupdateButtonArabic() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(updateButton);
		updateButton.click();
	}
	
	//
	//Web Element of validation Brand Name
	//
	@FindBy(how=How.CSS,using="#prodBrand > div:nth-child(1) > div > div > div.field-wraper > div > ul > li > a")
	WebElement validationBrandName;
	
	//
	//Function of getting validation Brand Name in Product Brand Setup English form
	//
	public String getvalidationBrandName()
	{
		waitForVisibility(validationBrandName);
		return validationBrandName.getText();
	}
	
	//
	//WebElement of error message coming on below of Product Brand Setup form
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--danger")
	WebElement errorBelow;
	
	//
	//Function to get error message coming on below of Product Brand Setup form
	//
	public String getValidationBelow()
	{
		waitForVisibility(errorBelow);
		return errorBelow.getText();
	}
}
