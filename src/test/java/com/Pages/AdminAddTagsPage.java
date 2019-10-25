package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddTagsPage {
	
WebDriver driver;
	
	public AdminAddTagsPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Tags from Catalog drop down of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(2) > ul > li:nth-child(10) > a")
	WebElement tags;
	
	//
	//Function to click on Tags from Catalog drop down of Dashboard drop down
	//
	public void clickOnTags()
	{
		waitForVisibility(tags);
		tags.click();
	}
	
	//
	//WebElement of Edit Icon of Tag List to get Add New Tag option on Manage Tags page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(4) > div.sectionhead > ul > li > a > i")
	WebElement EditTagList;
	
	//
	//Function to click on Tags from Catalog drop down of Dashboard drop down
	//
	public void clickOnEditTagListtoGetAddNewTag()
	{
		waitForVisibility(EditTagList);
		EditTagList.click();
	}
	
	//
	//WebElement of add New Tag
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(4) > div.sectionhead > ul > li > div > ul > li:nth-child(3) > a")
	WebElement addNewTag;
	
	//
	//Function to click on add New Tag Updated
	//
	public void clickonaddNewTag() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.cssSelector("#body > div > div > div > div > section:nth-child(4) > div.sectionhead > ul > li > div > ul"));
		
		 List<WebElement> verticalLinks = dropdown.findElements(By.cssSelector("#body > div > div > div > div > section:nth-child(4) > div.sectionhead > ul > li > div > ul > li"));
		 
		 for (int i = 0; i < verticalLinks.size(); i++) 
		 	{	
			 	if (verticalLinks.get(i).getText().contentEquals("Add New Tag"))
			 		{
			 			Thread.sleep(500);
			 			verticalLinks.get(i).click();
			 		}	
		 	}
	}
	
	//
	//WebElement of getting text of Mandatory field validation error message of Tag Identifier in Tag Set up General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_tag_identifier")
	WebElement validationErrormessageofTagIdentifier;
		
	//
	//Function of getting text of Mandatory field validation error message of Tag Identifier in Tag Set up General form
	//
	public String getvalidationErrormessageofTagIdentifier()
	{
		waitForVisibility(validationErrormessageofTagIdentifier);
		return validationErrormessageofTagIdentifier.getText();
	}
	
	//
	//WebElement of Tag Identifier in Tag Set up General form
	//
	@FindBy(how=How.CSS,using="#frmTag > div:nth-child(1) > div > div > div.field-wraper > div > input")
	WebElement tagIdentifier;
	
	//
	//Function to enter Tag Identifier in Tag Set up General form
	//
	public void entertagIdentifier(String tagidentifier)
	{
		waitForVisibility(tagIdentifier);
		tagIdentifier.clear();
		tagIdentifier.sendKeys(tagidentifier);
	}
	
	//
	//WebElement of getting duplication validation error message for Tag Identifier in Tag Set up General form
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement duplicationValidationErrorMessageforTagIdentifier;
	
	//
	//Function of getting duplication validation error message for Tag Identifier in Tag Set up General form
	//
	public String getduplicationValidationErrorMessageforTagIdentifier()
	{
		waitForVisibility(duplicationValidationErrorMessageforTagIdentifier);
		return duplicationValidationErrorMessageforTagIdentifier.getText();
	}
	
	//
	//WebElement of Mandatory field validation error message of Tag Name English in Tag Set up General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_tag_name")
	WebElement validationErrormessageofTagNameEnglish;
	
	//
	//Function of getting text of Mandatory field validation error message of Tag Name English in Tag Set up General form
	//
	public String getValidationErrormessageofTagNameEnglish()
	{
		waitForVisibility(validationErrormessageofTagNameEnglish);
		return validationErrormessageofTagNameEnglish.getText();
	}
	
	//
	//WebElement of Tag Name English in Tag Set up General form
	//
	@FindBy(how=How.NAME,using="tag_name")
	WebElement tagNameEnglish;
	
	//
	//Function to enter Tag Name English in Tag Set up General form
	//
	public void enterTagNameEnglish(String tagnameenglish)
	{
		waitForVisibility(tagNameEnglish);
		tagNameEnglish.clear();
		tagNameEnglish.sendKeys(tagnameenglish);
	}
		
	//
	//WebElement of Mandatory field validation error message of Tag Name Arabic in Tag Set up General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_tag_name")
	WebElement validationErrormessageofTagNameArabic;
	
	//
	//Function of getting text of Mandatory field validation error message of Tag Name Arabic in Tag Set up General form
	//
	public String getValidationErrormessageofTagNameArabic()
	{
		waitForVisibility(validationErrormessageofTagNameArabic);
		return validationErrormessageofTagNameArabic.getText();
	}
	
	//
	//WebElement of Tag Name Arabic in Tag Set up General form
	//
	@FindBy(how=How.NAME,using="tag_name")
	WebElement tagNameArabic;
	
	//
	//Function to enter Tag Name Arabic in Tag Set up General form
	//
	public void enterTagNameArabic(String tagnamearabic)
	{
		waitForVisibility(tagNameArabic);
		tagNameArabic.clear();
		tagNameArabic.sendKeys(tagnamearabic);
	}
	
	//
	//WebElement of Save Changes on the Tag Set up General form
	//
	@FindBy(how=How.CSS,using="#frmTag > div:nth-child(2) > div > div > div.field-wraper > div > input[type=\"submit\"]")
	WebElement saveChangesgeneral;
	
	//
	//Function to Save Changes on the Tag Set up General form
	//
	public void clickonSaveChangesgeneral() throws InterruptedException
	{
		waitForVisibility(saveChangesgeneral);
		saveChangesgeneral.click();
	}
	
	//
	//WebElement of Save Changes on the Tag Set up English form
	//
	@FindBy(how=How.CSS,using="#frmTagLang > div:nth-child(2) > div > div > div.field-wraper > div > input[type=submit]")
	WebElement saveChangesenglish;
	
	//
	//Function to Save Changes on the Tag Set up English form
	//
	public void clickonSaveChangesgeneralenglish() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(saveChangesenglish);
		saveChangesenglish.click();
	}
	
	//
	//WebElement of Successfull message after Tag Creation
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--success > div.sysmsgcontent.content")
	WebElement successMessage;
	
	//
	//Function to get text of Successfull message after Tag Creation
	//
	public String getsuccessMessage() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(successMessage);
		return successMessage.getText();
	}

}
