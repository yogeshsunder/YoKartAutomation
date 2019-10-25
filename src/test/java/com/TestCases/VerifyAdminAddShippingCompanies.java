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

import com.Pages.AdminAddDurationLabelPage;
import com.Pages.AdminAddShippingCompaniesPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddShippingCompanies {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8;
	
	String ShippingIdentifier,ShippingapiName;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddShippingCompanies() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Shipping Companies");
		
		//-------------------------------------------------------------Redirecting to Shipping Companies set up Form--------------------------------------------------------
		
		child1=report.startTest("Check opening Shipping Companies set up form");
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
		//Created Page Object using Page Factory to call the functions from Admin Add Duration Label Page to click on dashboard from top.
		//
		AdminAddDurationLabelPage addDurationLabel=PageFactory.initElements(driver, AdminAddDurationLabelPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Shipping Companies Page to click on dashboard from top.
		//
		AdminAddShippingCompaniesPage addShippingCompanies=PageFactory.initElements(driver, AdminAddShippingCompaniesPage.class);
		
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
		//Click on Shipping API of Dashboard drop down
		//
		addDurationLabel.clickOnShippingAPI();
		child1.log(LogStatus.INFO, "Admin is able to Click on Shipping API of Dashboard drop down.");
		
		addShippingCompanies.clickOnShippingCompanies();
		child1.log(LogStatus.INFO, "Admin is able to Click on Shipping Companies under Shippping API of Dashboard drop down.");
		
		addShippingCompanies.clickOnAddNewIcon();
		child1.log(LogStatus.INFO, "Click on Add New Icon on Manage Shipping Companies Page.");
		
		addShippingCompanies.clickOnAddNew();
		child1.log(LogStatus.INFO, "Click on Add New on Manage Shipping Companies Page to open.");
		child1.log(LogStatus.PASS, "Admin is able to open Shipping Companies set up form successfully.");
				
		logger.appendChild(child1);
		
		//
		//Check Shipping Companies Shipping Company General form with Shipping Identifier Blank
		//
		child2=report.startTest("Check Shipping Companies Shipping Company General form with Shipping Identifier Blank");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child2.log(LogStatus.INFO, "Click on Save changes button with keeping Shipping Identifier field blank.");
		
		String mandatoryShippingIdentifier = addShippingCompanies.getmandatoryShippingIdentifier();
		
		if (mandatoryShippingIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when Click on Save changes button with keeping Shipping Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryShippingIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL,  "Admin is not getting correct validation error message when Click on Save changes button with keeping Shipping Identifier field blank");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Shipping Companies Shipping Company General form
		//
		child3=report.startTest("Check Shipping Companies Shipping Company General form with duplicate Shipping Identifier in General Form");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddShippingCompaniesInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		ShippingIdentifier = (String) jsonObject.get("Shipping Identifier");
		
		addShippingCompanies.enterShippingIdentifier(ShippingIdentifier);
		child3.log(LogStatus.INFO, "Enter already existing Shipping Identifier");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child3.log(LogStatus.INFO, "Click on Save changes.");
		
		String duplicateShippingIdentifier = addShippingCompanies.getduplicateShippingIdentifier();
		
		if(duplicateShippingIdentifier.contains("Duplicate"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save changes with keep duplicate input in Shipping Identifier.");
			child3.log(LogStatus.PASS, duplicateShippingIdentifier);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save changes with keep duplicate input in Shipping Identifier.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Shipping Companies Shipping Company General form with correct input in Shipping Identifier
		//
		child4=report.startTest("Check Shipping Companies Shipping Company General form with correct input in Shipping Identifier");
		
		String uuid = UUID.randomUUID().toString();
		addShippingCompanies.enterShippingIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter unique / non-existing Shipping Identifier");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child4.log(LogStatus.INFO, "Click on Save changes.");
		
		child4.log(LogStatus.PASS, "Admin is able to redirect to Shipping Company English form successfully.");
		
		logger.appendChild(child4);
		
		//
		//Check Shipping Companies Shipping Company English form with Shipping Identifier Blank
		//
		child5=report.startTest("Check Shipping Companies Shipping Company English form with Shipping Api Name Blank");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child5.log(LogStatus.INFO, "Click on Save changes button with keeping Shipping Api Name field blank.");
		
		String mandatoryShippingapiName = addShippingCompanies.getmandatoryShippingApiNameEnglish();
		
		if (mandatoryShippingapiName.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when Click on Save changes button with keeping Shipping Api Namefield blank.");
			child5.log(LogStatus.PASS, mandatoryShippingapiName);
		}
		else
		{
			child5.log(LogStatus.FAIL,  "Admin is not getting correct validation error message when Click on Save changes button with keeping Shipping Api Name field blank");
		}
		
		logger.appendChild(child5);
		
		//
		//Check Shipping Companies Shipping Company English form with correct input in Shipping Api Name
		//
		child6=report.startTest("Check Shipping Companies Shipping Company General form with correct input in Shipping Api Name field");
		
		ShippingapiName = (String) jsonObject.get("Shipping API NAME English");
		addShippingCompanies.enterShippingApiNameEnglish(ShippingapiName);
		child6.log(LogStatus.INFO, "Enter unique / non-existing Shipping API Name");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child6.log(LogStatus.INFO, "Click on Save changes.");
		
		child6.log(LogStatus.PASS, "Admin is able to redirect to Shipping Company Arabic form successfully.");
		
		logger.appendChild(child6);
		
		
		//
		//Check Shipping Companies Shipping Company Arabic form with Shipping Identifier Blank
		//
		child7=report.startTest("Check Shipping Companies Shipping Company Arabic form with Shipping Api Name Blank");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child7.log(LogStatus.INFO, "Click on Save changes button with keeping Shipping Api Name field blank.");
		
		String mandatoryAPIname = addShippingCompanies.getmandatoryShippingApiNameArabic();
		
		if(mandatoryAPIname.contains("Mandatory"))
		{
			child7.log(LogStatus.INFO, "Admin is getting correct validation error message when we click on Save button with keeping shipping api blank.");
			child7.log(LogStatus.INFO, mandatoryAPIname);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when we click on Save button with keeping shipping api blank.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Shipping Companies Shipping Company Arabic form with correct input in Shipping Api Name
		//
		child8=report.startTest("Check Shipping Companies Shipping Company Arabic form with correct input in Shipping Api Name field");

		addShippingCompanies.enterShippingApiNameArabic(ShippingapiName);
		child8.log(LogStatus.INFO, "Enter unique / non-existing Shipping API Name");
		
		addShippingCompanies.clickOnSaveChangesGeneral();
		child8.log(LogStatus.INFO, "Click on Save changes.");
		
		String success = addShippingCompanies.getsuccessMessage();
		
		if(success.contains("Setup Successfull"))
		{
			child8.log(LogStatus.PASS, "Admin is able to create Shipping Company successfully.");
			child8.log(LogStatus.PASS, success);
			
		}
		else
		{
			child8.log(LogStatus.FAIL, "Admin is not able to create Shipping Company successfully.");
		}
		
		logger.appendChild(child8);
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Shipping Companies.");
			logger.log(LogStatus.FAIL, "Admin_shipping_companies", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}
	

}
