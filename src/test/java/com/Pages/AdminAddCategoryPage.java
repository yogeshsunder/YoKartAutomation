package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddCategoryPage {
	
	WebDriver driver;
	String userName,passWord;
    JSONParser parser=new JSONParser();
	
	public AdminAddCategoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Catalog option of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(2) > a")
	WebElement catalog;
	
	//
	//Function to click on Catalog option of Dashboard drop down
	//
	public void clickonCatalog() throws InterruptedException
	{
		Thread.sleep(1000);
		new WebDriverWait(driver, 120).until(ExpectedConditions.visibilityOf(catalog));
		waitForVisibility(catalog);
		catalog.click();
	}
	
	//
	//WebElement of product Category
	//
	@FindBy(how=How.CSS,using="li.haschild:nth-child(2) > ul:nth-child(2) > li:nth-child(2) > a:nth-child(1)")
	WebElement productCategory;
	
	//
	//Function to click on product Category option of Cataloque drop down of Dashboard drop down
	//
	public void clickonproductCategory()
	{
		waitForVisibility(productCategory);
		productCategory.click();
	}
	
	//
	//WebElement of Edit Icon on page Category List Page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > a > i")
	WebElement editIcon;
	
	//
	//Function to click on Edit Icon on page Category List Page
	//
	public void clickoneditIconofProductCategoryPage()
	{
		waitForVisibility(editIcon);
		editIcon.click();
	}
	
	//
	//WebElement of Edit Icon on page Category List Page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > div > ul > li:nth-child(3) > a")
	WebElement addCategory;
	
	//
	//Function to click on Edit Icon on page Category List Page
	//
	public void clickonaddCategory() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(addCategory);
		addCategory.click();
	}
	
	//
	//Web Element of Category Identifier in Product Category Setup General Form
	//
	@FindBy(how=How.CSS,using="#prodCate > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	WebElement categoryIdentifier;
	
	//
	//Function to enter Category Identifier in Product Category Setup General Form
	//
	public void enterCategoryIdentifier(String categoryidentifier)
	{
		waitForVisibility(categoryIdentifier);
		categoryIdentifier.clear();
		categoryIdentifier.sendKeys(categoryidentifier);
	}
	
	//
	//WebElement of Category SEO Friendly URL in Product Category Setup General Form
	//
	@FindBy(how=How.ID,using="urlrewrite_custom")
	WebElement seoFriendUrl;
	
	//
	//Function to enter Category SEO Friendly URL in Product Category Setup General Form
	//
	public void enterseoFriendUrl(String seofriendlyurl)
	{
		waitForVisibility(seoFriendUrl);
		seoFriendUrl.clear();
		seoFriendUrl.sendKeys(seofriendlyurl);
	}
	
	//
	//Function to clear Category SEO Friendly URL in Product Category Setup General Form
	//
	public void clearseoFriendUrl()
	{
		waitForVisibility(seoFriendUrl);
		seoFriendUrl.clear();
	}
	
	//
	//WebElement of mandatory validation error message of Category SEO Friendly URL field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_urlrewrite_custom")
	WebElement mandatoryCategorySEOFriendlyURL;
		
	//
	//Function to get mandatory validation error message of Category SEO Friendly URL field
	//
	public String getmandatoryCategorySEOFriendlyURL()
	{
		waitForVisibility(mandatoryCategorySEOFriendlyURL);
		return mandatoryCategorySEOFriendlyURL.getText();
	}
	
	//
	//WebElement of Save Changes
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @type='submit']")
	WebElement submitButton;
	
	//
	//Function to click on Save Changes button in Product Category Setup General Form
	//
	public void clickOnSaveChanges() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(submitButton);
		submitButton.click();
	}
	
	//
	//Function to click on Save Changes button in Product Category Setup General Form
	//
	public void clickOnSaveChangesEnglish() throws InterruptedException
	{
		Thread.sleep(2500);
		waitForVisibility(submitButton);
		submitButton.click();
	}
	
	//
	//WebElement of Mandatory validation error message of the field Category Identifier in Product Category Setup General Form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_prodcat_identifier")
	WebElement mandatoryCategoryIdentifier;
	
	//
	//Function to get Mandatory validation error message of the field Category Identifier in Product Category Setup General Form
	//
	public String getMandatoryCategoryIdentifier()
	{
		waitForVisibility(mandatoryCategoryIdentifier);
		return mandatoryCategoryIdentifier.getText();
	}
	
	//
	//Function to enter Category Identifier in Product Category Setup General Form
	//
	public void enterProductCategorySetupGeneralForm()
	{
				
		String uuid = UUID.randomUUID().toString();

		waitForVisibility(categoryIdentifier);		
		categoryIdentifier.click();
		categoryIdentifier.sendKeys(uuid);
		waitForVisibility(submitButton);
		submitButton.click();		
	}
	
	//
	//WebElement of Category Name in Product Category Setup English Form
	//
	@FindBy(how=How.XPATH,using="//input[@name='prodcat_name' and @type='text']")
	WebElement categoryName;
	
	//
	//Function to enter Category Name in Product Category Setup English Form
	//
	public void enterCategoryName(String categoryname)
	{
		waitForVisibility(categoryName);
		categoryName.clear();
		categoryName.sendKeys(categoryname);
	}
	
	//
	//WebElement of Mandatory validaion error message of Category Name field in Product Category Setup English Form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_prodcat_name")
	WebElement mandatoryCategoryName;
	
	//
	//Function to get Mandatory validaion error message of Category Name field in Product Category Setup English Form
	//
	public String getMandatoryCategoryName()
	{
		waitForVisibility(mandatoryCategoryName);
		return mandatoryCategoryName.getText();
	}
	
	//
	//Function to enter Product Category Setup English Form
	//
	public void enterProductCategorySetupEnglishForm()
	{
				
		String uuid = UUID.randomUUID().toString();
		
		waitForVisibility(categoryName);		
		categoryName.click();
		categoryName.sendKeys(uuid);
		waitForVisibility(submitButton);
		submitButton.click();		
	}
	
	//
	//WebElement of Category Name* in Product Category Setup Arabic Form
	//
	@FindBy(how=How.XPATH,using="//input[@name='prodcat_name' and @type='text']")
	WebElement categoryNamearabic;
	
	//
	//WebElFunction of enter Product Categories Setup Arabic Form in Product Category Setup Arabic Form
	//
	public void enterProductCategoriesSetupArabicForm() throws InterruptedException
	{
		String uuid = UUID.randomUUID().toString();
		
		Thread.sleep(1000);
		waitForVisibility(submitButton);
		submitButton.click();
		waitForVisibility(categoryNamearabic);
		categoryNamearabic.sendKeys(uuid);
		//categoryNamearabic.sendKeys(uuid);
		submitButton.click();
	}
	
	//
	//WebElement of upload of icon in Media Form in Product Category Setup Arabic Form
	//
	@FindBy(how=How.NAME,using="cat_icon")
	WebElement shoplogo;
	
	//
	//WebElement of upload of Banner in Media Form in Product Category Setup Arabic Form
	//
	@FindBy(how=How.NAME,using="cat_banner")
	WebElement shopbanner;
	
	public void enterProductCategoriesSetupMeidaForm() throws IOException, InterruptedException
	{
		//Upload image in Media
		waitForVisibility(shoplogo);
		shoplogo.click();
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");		
		Thread.sleep(10000);
		
		//Upload image in Media
		waitForVisibility(shopbanner);
		shopbanner.click();
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");
		Thread.sleep(10000);
	}
	
	public void enterUserName() throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		userName = (String) jsonObject.get("USERNAME");
		
		waitForVisibility(catalog);
		catalog.sendKeys(userName);
	}
	
	//
	//WebElement of upload of Close the Product Category Setup Form
	//
	@FindBy(how=How.CLASS_NAME,using="close_image")
	WebElement close;
	
	//
	//Function of upload of Close the Product Category Setup Form
	//
	public void closeProductCategoryMediaSetup()
	{
		close.click();
	}

}
