package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSellerApprovalFormPage {
	
	WebDriver driver;
	String identifier,captionEnglish,captionArabic;
	JSONParser parser=new JSONParser();

	//
	//Constructor for the class SellerCreationPage
	//
	public AdminSellerApprovalFormPage(WebDriver driver) {
		//
		//Putting wait for 10 seconds in driver if driver is null so that driver can wait if the driver cannot locate the defined WebElement
		//
		if(driver == null)
			throw new IllegalArgumentException("Driver object is null");
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		this.driver = driver;
	}
	
	//
	//Creation of private function to wait if WebElement is not visible for 120 seconds and this function can be used in this class to wait for Web elements.
	//
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//----------------------------------------------------Web Elements---------------------------------------------------------------------
	//
	//Web Element of Menu icon on dashboard of admin.
	//
	@FindBy(how=How.CLASS_NAME,using="menutrigger")
	WebElement menuclick;
	
	//
	//Web Element of user in user drop down
	//
	@FindBy(how=How.CSS,using="li.haschild:nth-child(3) > a:nth-child(1)")	
	WebElement clickuser;
	
	//
	//Web Element of Seller Approval Form in Menu drop down
	//
	@FindBy(how=How.CSS,using="li.haschild:nth-child(3) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
	WebElement sellerapprovalform;
	
	//
	//Web Element of user in Add icon in top right
	//
	@FindBy(how=How.XPATH,using="/html/body/div[2]/div/div/div/div/div/section/div[1]/ul/li/a/i")
	WebElement addnewicon;
	
	//
	//Web Element of user in Add New button coming after click on top right
	//
	@FindBy(how=How.CSS,using="li.active:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")
	WebElement addNew;
	
	//
	//Web Element of entering value on Identifier input field of General tab of Set Up Form Fields pop up form
	//
	@FindBy(how=How.NAME,using="sformfield_identifier")
	WebElement Identifier;
	
	//
	//Web Element of entering Required input field of General tab of Set Up Form Fields pop up form
	//
	@FindBy(how=How.NAME,using="sformfield_required")
	WebElement required;
	
	//
	//Function to click on Required field of the forms
	//
	public void clickOnRequiredField()
	{
		waitForVisibility(required);
		required.click();
	}
	
	//
	//Web Element of button Save Changes of Set Up Form Fields pop up form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement submitSetUpFormFields;
	
	//
	//Web Element of entering value on Identifier input field of General tab of Set Up Form Fields pop up form
	//
	@FindBy(how=How.NAME,using="sformfield_caption")
	WebElement caption;
	
	//
	//Web Element of click on drop down of Field Type field of General tab of Set Up Form Fields pop up form
	//
	@FindBy(how=How.NAME,using="sformfield_type")
	WebElement fieldType;
	
	//--------------------------------------------------------------------Functions------------------------------------------------------------
	//
	//Function to click on Menu icon on dashboard of admin.
	//
	public void clickonMenuIcon() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(menuclick);
		menuclick.click();
	}
		
	//
	//Function to click on user in Menu drop down
	//
	public void clickonUser() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(clickuser);
		clickuser.click();
	}
		
	//
	//Function to Seller Approval Form on user in Menu drop down
	//
	public void clickonSellerApprovalForm()
	{
		waitForVisibility(sellerapprovalform);
		sellerapprovalform.click();
	}
		
	//
	//Function to click on Add icon in top right
	//
	public void clickonAddNewIcon()
	{
		waitForVisibility(addnewicon);
		addnewicon.click();
	}
		
	//
	//Function to click on Add New button coming after click on top right
	//
	public void clickonAddNew()
	{
		waitForVisibility(addNew);
		addNew.click();
	}
		
	//
	//Function of entering value on Identifier input field of General tab of Set Up Form Fields pop up form
	//
	public void enterIdentifier(String enter_Identifier) throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminSellerApprovalFormData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		identifier = (String) jsonObject.get("IDENTIFIER");
		
		waitForVisibility(Identifier);
		Identifier.sendKeys(enter_Identifier);
	}
	
	//
	//Function of selecting NO to Required input field of General tab of Set Up Form Fields pop up form
	//
	public void requiredNo()
	{
		waitForVisibility(required);
		Select requiredno = new Select(required);
		requiredno.selectByIndex(1);
	}
		
	//
	//Function of button Save Changes of Set Up Form Fields pop up form
	//
	public void clickonSubmitSetUpFormFields() throws InterruptedException
	{
		Thread.sleep(1500);
		waitForVisibility(submitSetUpFormFields);
		submitSetUpFormFields.click();
	}
		
	//
	//Function of entering value on Identifier input field of General tab of Set Up Form Fields pop up form
	//
	public void enterCaptionEnglish() throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminSellerApprovalFormData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		captionEnglish = (String) jsonObject.get("CAPTIONENGLISH");
		
		waitForVisibility(caption);
		caption.clear();
		caption.sendKeys(captionEnglish);
	}
	
	//
	//Function of entering value on Identifier input field of General tab of Set Up Form Fields pop up form
	//
	public void enterCaptionArabic() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminSellerApprovalFormData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		captionArabic = (String) jsonObject.get("CAPTIONARABIC");
		
		waitForVisibility(caption);
		caption.clear();
		Thread.sleep(500);
		caption.sendKeys(captionArabic);
	}
	
	//
	//Web Element of selecting Text Area in Field Type of Set Up Form Fields pop up form
	//
	public void selectTextArea()
	{
		waitForVisibility(fieldType);
		Select selecttextarea= new Select(fieldType);
		selecttextarea.selectByIndex(1);				
	}
	
	//
	//Web Element of selecting File in Field Type of Set Up Form Fields pop up form
	//
	public void selectFile()
	{
		waitForVisibility(fieldType);
		Select selecttextarea= new Select(fieldType);
		selecttextarea.selectByIndex(2);				
	}
	
	//
	//Web Element of selecting Date in Field Type of Set Up Form Fields pop up form
	//
	public void selectDate()
	{
		waitForVisibility(fieldType);
		Select selecttextarea= new Select(fieldType);
		selecttextarea.selectByIndex(3);				
	}
	
	//
	//Web Element of selecting DateTime in Field Type of Set Up Form Fields pop up form
	//
	public void selectDateTime()
	{
		waitForVisibility(fieldType);
		Select selecttextarea= new Select(fieldType);
		selecttextarea.selectByIndex(4);				
	}
	
	//
	//Web Element of selecting Time in Field Type of Set Up Form Fields pop up form
	//
	public void selectTime()
	{
		waitForVisibility(fieldType);
		Select selecttextarea= new Select(fieldType);
		selecttextarea.selectByIndex(5);				
	}
	
	//
	//WebElement of Mandatory validation error message of Identifier field of Set Up Form Fields form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_sformfield_identifier")
	WebElement mandatoryIdentifier;
	
	//
	//Function to get Mandatory validation error message of Identifier field of Set Up Form Fields form
	//
	public String getMandatoryValidationIdentifier()
	{
		waitForVisibility(mandatoryIdentifier);
		return mandatoryIdentifier.getText();
	}
	
	//
	//WebElement of mandatory validation error message of Caption field of Set Up Form Fields English form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_sformfield_caption")
	WebElement mandatoryCaption;
	
	//
	//Function to get mandatory validation error message of Caption field of Set Up Form Fields English form
	//
	public String getMandatoryValidationCaption() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(mandatoryCaption);
		return mandatoryCaption.getText();
	}


}
