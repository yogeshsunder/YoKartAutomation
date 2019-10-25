package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminAddDurationLabelPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddDurationLabel {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1;
	ExtentTest child2;
	ExtentTest child3;
	ExtentTest child4;
	ExtentTest child5;
	ExtentTest child6;
	ExtentTest child7;
	
	@Test
	public void adminAddDurationLabel() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Duration Label");
		
		//-------------------------------------------------------------Redirecting to Duration Label Setup Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Shipping Duration Label form");
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
		
		addDurationLabel.clickOnDurationLabels();
		child1.log(LogStatus.INFO, "Admin is able to Click on Duration Labels under Shipping API of Dashboard drop down.");
		
		addDurationLabel.clickOnAddNewIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Add New Icon on Manage Shipping Durations Page.");
		
		addDurationLabel.clickOnAddNew();
		child1.log(LogStatus.INFO, "Admin is able to Click on Add New on Manage Shipping Durations Page to open Shipping Duration Label form.");
		
		child1.log(LogStatus.PASS, "Admin is able to open Shipping Duration Label form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Shipping Duration Label General Form with Identifier field blank
		//
		child2=report.startTest("Check Shipping Duration Label General Form with Identifier field blank");
		
		addDurationLabel.clickOnSaveChangesGeneral();
		child2.log(LogStatus.INFO, "Click on Save Changes button on Shipping Duration Label General form with keeping Identifier field blank.");
		
		String mandatoryvalidationIdentifier = addDurationLabel.getMandatoryValidationIdentifier();
		
		if(mandatoryvalidationIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button on Shipping Duration Label General form with keeping Identifier blank.");
			child2.log(LogStatus.PASS, mandatoryvalidationIdentifier);
		}
		else
		{
			child2.log(LogStatus.PASS, "Admin is not getting correct validation error message when click on Save Changes button on Shipping Duration Label General form with keeping Identifier blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Shipping Duration Label General Form with correct input in General Identifier field
		//
		child3=report.startTest("Check Shipping Duration Label General Form with correct input in General Identifier field");
		
		String uuid = UUID.randomUUID().toString();
		
		addDurationLabel.enterIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter unique/non-existing Identifier in Shipping Duration Label General form.");
		
		addDurationLabel.clickOnSaveChangesGeneral();
		child3.log(LogStatus.PASS, "Admin redirects to Shipping Duration Label Setup English form successfully.");
		
		logger.appendChild(child3);
		
		//
		//Check Shipping Duration Label English Form with Label field blank
		//
		child4=report.startTest("Check Shipping Duration Label English Form with Label field blank");
				
		addDurationLabel.clickOnSaveChangesGeneral();
		child4.log(LogStatus.INFO, "Click on Save Changes button on Shipping Duration Label English form with keeping Label field blank.");
		
		String mandatoryLabel = addDurationLabel.getMandatoryValidationLabelEnglish();
		
		if (mandatoryLabel.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button on Shipping Duration Label English form with keeping Label field blank.");
			child4.log(LogStatus.PASS, mandatoryLabel);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button on Shipping Duration Label English form with keeping Label field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Shipping Duration Label English Form with correct input for Label field
		//
		child5=report.startTest("Check Shipping Duration Label English Form with correct input for Label field");
		
		addDurationLabel.enterLabelEnglish(uuid);
		child5.log(LogStatus.INFO, "Enter unique value in Label field of Shipping Duration Label English form.");
		
		addDurationLabel.clickOnSaveChangesGeneral();
		child5.log(LogStatus.INFO, "Click on Save Changes button on Shipping Duration Label English form with correct input in Label field.");
		child5.log(LogStatus.PASS, "Admin is able to open Shipping Duration Label Setup Arabic form successfully.");
		
		logger.appendChild(child5);
		
		//
		//Check Shipping Duration Label Arabic Form with Label field blank
		//
		child6=report.startTest("Check Shipping Duration Label Arabic Form with Label field blank");
		
		addDurationLabel.clickOnSaveChangesGeneral();
		child6.log(LogStatus.INFO, "Click on Save Changes button with keeping Shipping Duration Label Arabic Form with Label field blank.");
		
		String getmandatoryValidationLabelArabic = addDurationLabel.getmandatoryValidationLabelArabic();
		
		if (getmandatoryValidationLabelArabic.contains("Mandatory")) 
		{
			child6.log(LogStatus.PASS, "Admin is getting correct validation error message when Click on Save Changes button with keeping Shipping Duration Label Arabic Form with Label field blank.");
			child6.log(LogStatus.PASS, getmandatoryValidationLabelArabic);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not getting correct validation error message when Click on Save Changes button with keeping Shipping Duration Label Arabic Form with Label field blank.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Shipping Duration Label Arabic Form with correct Label field
		//
		child7=report.startTest("Check Shipping Duration Label Arabic Form with correct input in Label field and creation of Duration label");
		
		addDurationLabel.enterlabelArabic(uuid);
		child7.log(LogStatus.INFO, "Enter unique value in Label field of Shipping Duration Label Arabic form.");
		
		addDurationLabel.clickOnSaveChangesGeneral();
		child7.log(LogStatus.INFO, "Click on Save Changes button on Shipping Duration Label Arabic Form with correct input in Label field.");
		child7.log(LogStatus.PASS, "Admin is able to create Duration label successfully..");
		
		logger.appendChild(child7);
		
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Duration Label.");
			logger.log(LogStatus.FAIL, "Admin_duration_Label", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
