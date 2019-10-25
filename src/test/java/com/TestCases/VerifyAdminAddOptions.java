package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminAddBrandsPage;
import com.Pages.AdminAddOptionsPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddOptions {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10,child11;
	
	String optionNameEnglish,optionIdentifier,OptionNameArabic,OptionValuIidentifier,OptionValueNameEnglish,OptionValueNameArabic;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddOptions() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Options");
		
		//-------------------------------------------------------------Redirecting to Option Setup Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Option Setup Form");
		//
		//Start the Browser from BrowserFactory from Helper and Admin Login page of the application.
		//		
		driver=BrowserFactory1.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Admin Login page of the application.");
		
		//
		//Created Page Object using Page Factory to call the functions from SellerCreationPage for Admin Login.
		//
		AdminLoginPage adminlogin=PageFactory.initElements(driver, AdminLoginPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from AdminSellerApprovalFormPage to click on dashboard from top.
		//
		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Category Page to click on dashboard from top.
		//
		AdminAddBrandsPage addBrands=PageFactory.initElements(driver, AdminAddBrandsPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Options Page to click on dashboard from top.
		//
		AdminAddOptionsPage addOptions=PageFactory.initElements(driver, AdminAddOptionsPage.class);
		
		//
		//Login into Admin.
		//
		adminlogin.loginAdmin();
		child1.log(LogStatus.PASS, "Admin is able to login successfully.");
		
		//
		//Click on Menu Icon
		//
		sellerapproval.clickonMenuIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Menu Icon on the top left of the Dashboard.");
		
		//
		//Click on Catalog option of Dashboard drop down
		//
		addBrands.clickonCatalog();
		child1.log(LogStatus.INFO, "Admin is able to Click on Catalog option of Dashboard drop down.");
		
		//
		//Click on Options option of Catalog drop down of Dashboard drop down
		//
		addOptions.clickOnOptions();
		child1.log(LogStatus.INFO, "Admin is able to Click on Options option of Catalog dropdown of Dashboard drop down.");
		
		//
		//click on edit Icon of Options List
		//
		addBrands.clickoneditIconofBrandList();
		child1.log(LogStatus.INFO, "Admin is able to Click on edit Icon of Options List.");
		
		addOptions.clickAddNewOption();
		child1.log(LogStatus.INFO, "Admin is able to Click on edit Icon of Add New Options.");
		child1.log(LogStatus.PASS, "Admin is able to open Option Setup form.");
		
		logger.appendChild(child1);
		
		//-------------------------------------------------------------Option Setup Form--------------------------------------------------------
		//
		//Check Option Setup Form with keeping Option Identifier field Blank
		//
		child2=report.startTest("Check Option Setup Form with keeping Option Identifier field Blank");
		
		addOptions.clickonSaveChanges();
		child2.log(LogStatus.INFO, "Click on Save Changes button with keeping Option Identifier field Blank.");
		
		String validationMandarotyOptionIdentifier = addOptions.getvalidationMandatoryOptionIdentifier();
		
		if (validationMandarotyOptionIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when clicking on Save changes button on Option Setup form wth Option Identifier field Blank.");
			child2.log(LogStatus.PASS, validationMandarotyOptionIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation error message when clicking on Save changes button on Option Setup form wth Option Identifier field Blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Option Setup Form with keeping Option Name English field Blank
		//
		child3=report.startTest("Check Option Setup Form with keeping Option Name English field Blank");
		
		String uuid = UUID.randomUUID().toString();
		addOptions.enterOptionIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter unique/non-existing Option Identifier in Option set up form.");
		
		addOptions.clickonSaveChanges();
		child3.log(LogStatus.INFO, "Click on Save Changes button with keeping Option Name English field Blank.");
		
		String validatinMandatoryOptionNameEnglish = addOptions.getvalidationOptionNameEnglish();
		
		if(validatinMandatoryOptionNameEnglish.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Option Name English field Blank.");
			child3.log(LogStatus.PASS, validatinMandatoryOptionNameEnglish);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Option Name English field Blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Option Setup Form with keeping Option Name Arabic field Blank
		//
		child4=report.startTest("Check Option Setup Form with keeping Option Name Arabic field Blank");
		
		addOptions.enterOptionIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter unique/non-existing Option Identifier in Option set up form.");
		
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddOptionsInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		optionNameEnglish = (String) jsonObject.get("Option Name English");
		
		addOptions.enterOptionNameEnglish(optionNameEnglish);
		child4.log(LogStatus.INFO, "Enter Option Name English in Option set up form.");
		
		addOptions.clickonSaveChanges();
		child4.log(LogStatus.INFO, "Click on Save Changes button with keeping Option Name Arabic field Blank.");
		
		String mandatoryValidationOtionNameArabic = addOptions.getmandatoryValidationOtionNameArabic();
		
		if(mandatoryValidationOtionNameArabic.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Option Name Arabic field Blank.");
			child4.log(LogStatus.PASS, mandatoryValidationOtionNameArabic);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is getting not correct validation error message when click on Save Changes button with keeping Option Name Arabic field Blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Option Setup Form with Duplicate Option Identifier
		//
		child5=report.startTest("Check Option Setup Form with Duplicate Option Identifier");
		
		optionIdentifier = (String) jsonObject.get("Option Identifier");
		
		addOptions.enterOptionIdentifier(optionIdentifier);
		child5.log(LogStatus.INFO, "Enter already existing Option Identifier.");
		
		addOptions.enterOptionNameEnglish(optionNameEnglish);
		child5.log(LogStatus.INFO, "Enter Option Name English.");
		
		OptionNameArabic = (String) jsonObject.get("Option Name Arabic");
		addOptions.enterOptionNameArabic(OptionNameArabic);		
		child5.log(LogStatus.INFO, "Enter Option Name Arabic.");
		
		addOptions.clickonSaveChanges();
		child5.log(LogStatus.INFO, "Click on Save Changes button with keeping Option Identifier field filled with duplicate/already-existing entry.");
		
		String validationDuplicatedOptionIdentifier = addOptions.getvalidationDuplicatedOptionIdentifier();
		
		if(validationDuplicatedOptionIdentifier.contains("Duplicate entry"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when try to enter duplicate Option Identifier.");
			child5.log(LogStatus.PASS, validationDuplicatedOptionIdentifier);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Option Value Listing form
		//
		child6=report.startTest("Check opening Option Value Listing form");
		
		addOptions.enterOptionIdentifier(uuid);
		child6.log(LogStatus.INFO, "Enter unique/non-existing Option Identifier in Option set up form.");
		
		addOptions.clickonSaveChanges();
		child6.log(LogStatus.INFO, "Click on Save Changes button with all correct entries.");
		
		addOptions.clickoptionValueListingEdit();
		child6.log(LogStatus.INFO, "Click on option Value Listing Edit to get Add New option which can open Option Value Listing form.");
		
		addOptions.clickoptionValueListingAddNew();
		child6.log(LogStatus.INFO, "Click on Add New option to open Option Value Listing form.");
		
		logger.appendChild(child6);
		
		//
		//Check Mandatory validation error message of Option Value Identifier
		//
		child7=report.startTest("Check Mandatory validation error message for Option Value Identifier in Configure Option Values form");
		
		addOptions.clicksaveChangesConfigureOptionValues();
		child7.log(LogStatus.INFO, "Click on Save Changes button with all fields empty.");
		
		String MandatoryvalidationforOptionValueIdentifier = addOptions.getMandatoryvalidationforOptionValueIdentifier();
		
		if (MandatoryvalidationforOptionValueIdentifier.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with Option Value Identifier field empty.");
			child7.log(LogStatus.PASS, MandatoryvalidationforOptionValueIdentifier);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with Option Value Identifier field empty.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Mandatory validation error message of Option Value Name English
		//
		child8=report.startTest("Check Mandatory validation error message of Option Value Name English in Configure Option Values form");

		OptionValuIidentifier = (String) jsonObject.get("Option Value Identifier");
		addOptions.enterOptionValuIidentifier(OptionValuIidentifier);
		child8.log(LogStatus.INFO, "Enter Option Value Identifier in Configure Option Values form.");
		
		addOptions.clicksaveChangesConfigureOptionValues();
		child8.log(LogStatus.INFO, "Click on Save Changes button with Option Value Name English field empty.");
		
		String validationMandatoryOptionValueNameEnglish = addOptions.getvalidationOtionValuenameEnglish();
		
		if(validationMandatoryOptionValueNameEnglish.contains("Mandatory"))
		{
			child8.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with Option Value Name English field empty.");
			child8.log(LogStatus.PASS, validationMandatoryOptionValueNameEnglish);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with Option Value Name English field empty.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Mandatory validation error message of Option Value Name Arabic
		//
		child9=report.startTest("Check Mandatory validation error message of Option Value Name Arabic in Configure Option Values form");
		
		OptionValueNameEnglish = (String) jsonObject.get("Option Value Name English");
		addOptions.enterOptionValueNameEnglish(OptionValueNameEnglish);
		child9.log(LogStatus.INFO, "Enter Option Value Name English in Configure Option Values form.");
		
		addOptions.clicksaveChangesConfigureOptionValues();
		child9.log(LogStatus.INFO, "Click on Save Changes button with Option Value Name Arabic field empty.");
		
		String validationOtionValuenameArabic = addOptions.getvalidationOtionValuenameArabic();
		
		if(validationOtionValuenameArabic.contains("Mandatory")) 
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with Option Value Name Arabic field empty.");
			child9.log(LogStatus.PASS, validationOtionValuenameArabic);
		}
		else
		{
			child9.log(LogStatus.PASS, "Admin is not getting correct validation error message when click on Save Changes button with Option Value Name Arabic field empty.");
		}
		
		logger.appendChild(child9);
		
		//
		//Check Configure Option Values form with all correct inputs in the fields
		//
		child10=report.startTest("Check Configure Option Values form with all correct inputs in the fields");
		
		OptionValueNameArabic = (String) jsonObject.get("Option Value Name Arabic");
		addOptions.enterOptionValueNameArabic(OptionValueNameArabic);
		child10.log(LogStatus.INFO, "Enter Option Value Name Arabic in Configure Option Values form.");
		
		addOptions.clicksaveChangesConfigureOptionValues();
		child10.log(LogStatus.INFO, "Click on Save Changes button with all correct inputs.");
		child10.log(LogStatus.PASS, "Admin is able to add Option Value in Option Value Listing.");
		
		logger.appendChild(child10);
		
		//
		//Check Configure Option Values form with Option Value Identifier Duplicated
		//
		child11=report.startTest("Check Configure Option Values form with Option Value Identifier Duplicated");

		Thread.sleep(2000);
		
		addOptions.enterOptionValuIidentifier(OptionValuIidentifier);
		child11.log(LogStatus.INFO, "Enter already existing Option Value Identifier.");
		
		addOptions.enterOptionValueNameEnglish(OptionValueNameEnglish);
		child11.log(LogStatus.INFO, "Enter Option Value Name English.");
		
		addOptions.enterOptionValueNameArabic(OptionValueNameArabic);
		child11.log(LogStatus.INFO, "Enter Option Value Name Arabic.");
		
		addOptions.clicksaveChangesConfigureOptionValues();
		child11.log(LogStatus.INFO, "click on save Changes of Configure Option Values Form.");
		
		String duplicateOptionValueIdentifier = addOptions.getduplicateOptionValueIdentifier();
		
		if(duplicateOptionValueIdentifier.contains("Duplicate"))
		{
			child11.log(LogStatus.PASS, "Admin is getting correct validation error message when try to enter duplicate input for Option Value Identifier field.");
			child11.log(LogStatus.PASS, duplicateOptionValueIdentifier);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Admin is not getting correct validation error message when try to enter duplicate input for Option Value Identifier field.");
		}
		
		logger.appendChild(child11);
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		//
		//If test is getting failed then take the screen shot and put it in Automation Report.
		//
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screenshot_path=Utility.captureScreenshot(driver, result.getName());
			String image=logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Admin is Not able to add Options.");
			logger.log(LogStatus.FAIL, "Admin_add_Options", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);

		report.flush();;
		driver.close();
	}

}
