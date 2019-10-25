package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminSellerApprovalForm {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12;
	
	@Test
	public void sellerApprovalForm() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Seller Approval Form");
		
		//
		//Start Child1 case of test case for creation of Text Box field in seller approval form
		//
		child1=report.startTest("Check Creation of Text Box field in Seller Approval Form ");
		
		//
		//Start the Browser from BrowserFactory from Helper and Admin Login page of the application.
		//		
		driver=BrowserFactory1.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Admin Login page of the application.");
		
		//
		//Created Page Object using Page Factory to call the functions from SellerCreationPage.
		//
		AdminLoginPage sellerCreation=PageFactory.initElements(driver, AdminLoginPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from AdminSellerApprovalFormPage.
		//
		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);
		
		//
		//Login into Admin.
		//
		sellerCreation.loginAdmin();
		child1.log(LogStatus.PASS, "Admin is able to login successfully.");
		
		//
		//Click on Menu Icon on the top left of the Dashboard.
		//
		sellerapproval.clickonMenuIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Menu Icon on the top left of the Dashboard.");
		
		//
		//Click on user under Menu Icon on the top left of the Dashboard.
		//
		sellerapproval.clickonUser();
		child1.log(LogStatus.INFO, "Admin is able to Click on user under Menu Icon on the top left of the Dashboard.");
		
		//
		//Click on Seller Approval Form under Menu Icon on the top left of the Dashboard.
		//
		sellerapproval.clickonSellerApprovalForm();
		child1.log(LogStatus.INFO, "Admin is able to Click on Seller Approval Form under Menu Icon on the top left of the Dashboard.");
		
		//
		//Creating Text Box field in Seller Approval Form 
		//
		sellerapproval.clickonAddNewIcon();	
		child1.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();		
		child1.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		RandomStringGenerator generator = new RandomStringGenerator.Builder()
	            .withinRange('0', 'z')
	            .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
	            .build();
		
		String uuid = generator.generate(10, 11);
		
		sellerapproval.enterIdentifier(uuid);
		child1.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child1.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child1.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();		
		child1.log(LogStatus.INFO, "Admin is able to enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child1.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child1.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();
		child1.log(LogStatus.INFO, "Admin is able to enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child1.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child1.log(LogStatus.PASS, "Admin is able to Create Text Box field in Seller Approval Form.");
		
		logger.appendChild(child1);

		//
		//Start Child2 case of test case for creation of Text Area field in seller approval form
		//
		child2=report.startTest("Check Creation of Text Area field in Seller Approval Form");
		//
		//Creating Text Area field in Seller Approval Form 
		//
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();		
		child2.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();	
		child2.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		String uuid1 = generator.generate(10, 12);
		
		sellerapproval.enterIdentifier(uuid1);
		child2.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child2.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.selectTextArea();
		child2.log(LogStatus.INFO, "Admin is able to select Text Area.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child2.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();	
		child2.log(LogStatus.INFO, "Admin is able to enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child2.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child2.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();		
		child2.log(LogStatus.INFO, "Admin is able to enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child2.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child2.log(LogStatus.PASS, "Admin is able to Create Text Area field in Seller Approval Form.");
		
		logger.appendChild(child2);
		
		//
		//Start Child2 case of test case for creation of Text Area field in seller approval form
		//
		child3=report.startTest("Check Creation of File field in Seller Approval Form");
		//
		//Creating File field in Seller Approval Form 
		//
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();	
		child3.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();		
		child3.log(LogStatus.INFO, "Admin is able to click on Add New.");

		String uuid2 = generator.generate(10, 12);
		
		sellerapproval.enterIdentifier(uuid2);
		child3.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child3.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.selectFile();	
		child3.log(LogStatus.INFO, "Admin is able to select File.");
		
		sellerapproval.clickonSubmitSetUpFormFields();		
		child3.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();		
		child3.log(LogStatus.INFO, "Admin is able to enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child3.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child3.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();		
		child3.log(LogStatus.INFO, "Admin is able to enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child3.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child3.log(LogStatus.PASS, "Admin is able to Create File field in Seller Approval Form.");
		
		logger.appendChild(child3);
		
		//
		//Start Child2 case of test case for creation of Text Area field in seller approval form
		//
		child4=report.startTest("Check Creation of File field in Seller Approval Form");
		//
		//Creating Date in Seller Approval Form 
		//
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();	
		child4.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();	
		child4.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		String uuid3 = generator.generate(10, 11);
		
		sellerapproval.enterIdentifier(uuid3);
		child4.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child4.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.selectDate();	
		child4.log(LogStatus.INFO, "Admin is able to select Date.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child4.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();	
		child4.log(LogStatus.INFO, "Admin is able to enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child4.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child4.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();	
		child4.log(LogStatus.INFO, "Admin is able to enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child4.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child4.log(LogStatus.PASS, "Admin is able to Create Date field in Seller Approval Form.");
		
		logger.appendChild(child4);
		
		//
		//Start Child2 case of test case for creation of Text Area field in seller approval form
		//
		child5=report.startTest("Check Creation of DateTime field in Seller Approval Form");
		//
		//Creating Field DateTime in Seller Approval Form 
		//
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();	
		child5.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();	
		child5.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		String uuid4 = generator.generate(10, 13);
		
		sellerapproval.enterIdentifier(uuid4);
		child5.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child5.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.selectDateTime();		
		child5.log(LogStatus.INFO, "Admin is able to select Date Time.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child5.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();
		child5.log(LogStatus.INFO, "Admin is able to enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child5.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child5.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();
		child5.log(LogStatus.INFO, "Admin is able to enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child5.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child5.log(LogStatus.PASS, "Admin is able to Create Field DateTime in Seller Approval Form.");
		
		logger.appendChild(child5);
		
		//
		//Start Child2 case of test case for creation of Text Area field in seller approval form
		//
		child6=report.startTest("Check Creation of Time field in Seller Approval Form");
		//
		//Creating Field Time in Seller Approval Form 
		//
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();		
		child6.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();		
		child6.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		String uuid5 = generator.generate(10, 14);
		
		sellerapproval.enterIdentifier(uuid5);
		child6.log(LogStatus.INFO, "Admin is able to enter Identifier.");
		
		sellerapproval.requiredNo();
		child6.log(LogStatus.INFO, "Admin is able to select required No.");
		
		sellerapproval.selectTime();		
		child6.log(LogStatus.INFO, "Admin is able to select Time.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child6.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionEnglish();	
		child6.log(LogStatus.INFO, "Admin is able to click on enter Caption English.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child6.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.clickonSubmitSetUpFormFields();	
		child6.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		
		sellerapproval.enterCaptionArabic();		
		child6.log(LogStatus.INFO, "Admin is able to click on enter Caption Arabic.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child6.log(LogStatus.INFO, "Admin is able to click on Submit Set Up Form Fields.");
		child6.log(LogStatus.PASS, "Admin is able to Create Field Time in Seller Approval Form.");
		
		logger.appendChild(child6);
		
		//
		//Check Set Up Form Fields form with keeping Identifier blank
		//
		child7=report.startTest("Check Set Up Form Fields form with keeping Identifier field blank");
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		sellerapproval.clickonAddNewIcon();		
		child7.log(LogStatus.INFO, "Admin is able to click on Add New Icon.");
		
		sellerapproval.clickonAddNew();		
		child7.log(LogStatus.INFO, "Admin is able to click on Add New.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child7.log(LogStatus.INFO, "Click On Submit Set Up Form Fields with keeping Identifier field blank.");
		
		String mandatoryidentifier = sellerapproval.getMandatoryValidationIdentifier();
		
		if(mandatoryidentifier.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when we click on Save Changes keeping Identifier field blank.");
			child7.log(LogStatus.PASS, mandatoryidentifier);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when we click on Save Changes keeping Identifier field blank.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Set Up Form Fields form with correct input in Identifier field of Set Up Form Fields General form
		//
		child8=report.startTest("Check Set Up Form Fields form with correct input in Identifier field of Set Up Form Fields General form");
		
		String uuid6 = generator.generate(10, 16);
		
		sellerapproval.enterIdentifier(uuid6);
		child8.log(LogStatus.INFO, "Enter Identifier in Set Up Form Fields form.");
		
		sellerapproval.requiredNo();
		child8.log(LogStatus.INFO, "Making the field non-mandatory.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child8.log(LogStatus.INFO, "Click On Submit Set Up Form Fields with correct input in Identifier field.");	
		child8.log(LogStatus.PASS, "Admin is redirecting to Set Up Form Fields English form successfully.");	
		
		logger.appendChild(child8);
		
		//
		//Check Set Up Form Fields form with keeping Caption English field blank
		//
		child9=report.startTest("Check Set Up Form Fields form with keeping Caption English field blank");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child9.log(LogStatus.INFO, "Click On Submit in Set Up Form Fields with keeping Caption English field blank.");		
		
		String mandatorycaption = sellerapproval.getMandatoryValidationCaption();
		
		if(mandatorycaption.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when we click on Submit button keeping Caption field blank for English form.");
			child9.log(LogStatus.PASS, mandatorycaption);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when we click on Submit button keeping Caption field blank for English form.");
		}
		
		logger.appendChild(child9);
		
		//
		//Check Set Up Form Fields English form with correct input in Caption field
		//
		child10=report.startTest("Check Set Up Form Fields English form with correct input in Caption field");
		
		sellerapproval.enterCaptionEnglish();
		child10.log(LogStatus.INFO, "Enter Caption in Set Up Form Field English form.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child10.log(LogStatus.INFO, "Click On Submit button of Set Up Form Field English form.");
		child10.log(LogStatus.PASS, "Admin is redirecting to Set Up Form Fields Arabic form successfully.");
		
		logger.appendChild(child10);
		
		//
		//Check Set Up Form Fields Arabic form with keeping Caption field blank
		//
		child11=report.startTest("Check Set Up Form Fields Arabic form with keeping Caption field blank");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child11.log(LogStatus.INFO, "Click On Submit in Set Up Form Fields with keeping Caption Arabic field blank.");
		
		String mandatorycaptionArabic = sellerapproval.getMandatoryValidationCaption();
		
		if(mandatorycaptionArabic.contains("Mandatory"))
		{
			child11.log(LogStatus.PASS, "Admin is getting correct validation error message when we click on Submit button keeping Caption field blank for Arabic form.");
			child11.log(LogStatus.PASS, mandatorycaptionArabic);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Admin is not getting correct validation error message when we click on Submit button keeping Caption field blank for Arabic form.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Set Up Form Fields Arabic form with correct input in Caption field
		//
		child12=report.startTest("Check Set Up Form Fields Arabic form with correct input in Caption field");
		
		sellerapproval.enterCaptionEnglish();
		child12.log(LogStatus.INFO, "Enter Caption in Set Up Form Field Arabic form.");
		
		sellerapproval.clickonSubmitSetUpFormFields();
		child12.log(LogStatus.INFO, "Click On Submit button of Set Up Form Field Arabic form.");
		child12.log(LogStatus.PASS, "Admin is able to create Form Field successfully.");
		
		logger.appendChild(child12);
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
			logger.log(LogStatus.FAIL, "User is Not able to create Seller Approval Forms.");
			logger.log(LogStatus.FAIL, "Admin_sellerapproval_Form", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		
		report.flush();;
		driver.close();
	}

}
