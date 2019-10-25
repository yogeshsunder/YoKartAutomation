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

import com.Pages.AdminAddNewTaxPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddNewTax {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	
	String value,valueMore,valueCorrect,taxCategoryName;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddNewTax() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Sales Tax");
		
		//-------------------------------------------------------------Redirecting to Tax Setup Setup Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Tax Setup form");
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
		AdminAddNewTaxPage addNewTax=PageFactory.initElements(driver, AdminAddNewTaxPage.class);
		
		//
		//Login into Admin.
		//
		adminlogin.loginAdmin();
		child1.log(LogStatus.PASS, "Admin is able to login successfully.");
		
		//
		//Click on Menu Icon
		//
		sellerapproval.clickonMenuIcon();
		child1.log(LogStatus.INFO, "Admin is able to click on Menu Icon on the top left of the Dashboard.");
		
		//Click on Settings
		
		addNewTax.clickonSettings();
		child1.log(LogStatus.INFO, "Admin is able to click on Settings under Dashboard drop down.");
		
		addNewTax.clickOnSalesTax();
		child1.log(LogStatus.INFO, "Admin is able to click on Sales Tax under Settings under Dashboard drop down.");
		
		addNewTax.clickOnAddNewIcon();
		child1.log(LogStatus.INFO, "Admin is able to click on Add New Icon on Manage Tax Page.");
		
		addNewTax.clickOnAddNewTax();
		child1.log(LogStatus.INFO, "Admin is able to click on Add New after click on Add New Icon on Manage Tax Page.");
		
		child1.log(LogStatus.PASS, "Pop up for Tax Setup opened successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Tax Setup General form with Tax Category Identifier field blank.
		//
		child2=report.startTest("Check Tax Setup General form with Tax Category Identifier field blank");
		
		addNewTax.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click on Save Changes button with keeping Tax Category Identifier field blank.");
		
		String mandatoryTaxCategoryIdentifier = addNewTax.getMandatoryValidationTaxCategoryIdentifier();
		
		if(mandatoryTaxCategoryIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error mesasge when Click on Save Changes button with keeping Tax Category Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryTaxCategoryIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation error mesasge when Click on Save Changes button with keeping Tax Category Identifier field blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Tax Setup General form with Value field blank.
		//
		child3=report.startTest("Check Tax Setup General form with Value field blank");
		
		String uuid = UUID.randomUUID().toString();
		
		addNewTax.enterTaxCategoryIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter unique/non-existing Tax Category Identifier.");
		
		addNewTax.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click on Save Changes button with keeping Value field blank.");
		
		String mandatoryValue = addNewTax.getMandatoryValidationValue();
		
		if(mandatoryValue.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Value field blank.");
			child3.log(LogStatus.PASS, mandatoryValue);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Value field blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Tax Setup General form with text input in Value field.
		//
		child4=report.startTest("Check Tax Setup General form with text input in Value field");
		
		addNewTax.enterTaxCategoryIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter unique/non-existing Tax Category Identifier.");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddSalesTaxInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		value = (String) jsonObject.get("Value_Text");
		
		addNewTax.enterValue(value);
		child4.log(LogStatus.INFO, "Enter Text value in Value field.");
		
		addNewTax.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click on Save Changes button with entering text value in Value field.");
		
		String numericValue = addNewTax.getMandatoryValidationValue();
		
		if(numericValue.contains("Numeric"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with entering text value in Value field.");
			child4.log(LogStatus.PASS, numericValue);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with entering text value in Value field.");
			child4.log(LogStatus.FAIL, numericValue);
		}
	
		logger.appendChild(child4);
		
		//
		//Check Tax Setup General form with text input in Value field.
		//
		child5=report.startTest("Check Tax Setup General form with text input in Value field");
		
		addNewTax.enterTaxCategoryIdentifier(uuid);
		child5.log(LogStatus.INFO, "Enter unique/non-existing Tax Category Identifier.");
		
		valueMore = (String) jsonObject.get("Value_MorethanAllowed");
		
		addNewTax.enterValue(valueMore);
		child5.log(LogStatus.INFO, "Enter Numeric value more than allowed i.e. 9999999999 in Value field.");
		
		addNewTax.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click on Save Changes button with keeping Numeric value more than allowed.");
		
		String numericValueMax = addNewTax.getMandatoryValidationValue();
		
		if(numericValueMax.contains("Value Must Be Between 0 And 9999999999"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with entering numeric value more than allowed in Value field.");
			child5.log(LogStatus.PASS, numericValueMax);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with entering numeric value moer than allowed in Value field.");
			child5.log(LogStatus.FAIL, numericValueMax);
		}
	
		logger.appendChild(child5);
		
		//
		//Check Tax Setup General form with correct input in Value field.
		//
		child6=report.startTest("Check Tax Setup General form with text input in Value field");
		
		addNewTax.enterTaxCategoryIdentifier(uuid);
		child6.log(LogStatus.INFO, "Enter unique/non-existing Tax Category Identifier.");
		
		valueCorrect = (String) jsonObject.get("Value_Correct");
		
		addNewTax.enterValue(valueCorrect);
		child6.log(LogStatus.INFO, "Enter correct value in Value field.");
		
		addNewTax.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click on Save Changes button with keeping correct value in Value field.");
		
		child6.log(LogStatus.PASS, "Admin is able to complete Sales Tax Setup General form and redirects to Sales Tax Setup English form successfully.");		
	
		logger.appendChild(child6);
		
		//
		//Check Tax Setup English form with Tax Category Name field Blank.
		//
		child7=report.startTest("Check Tax Setup English form with Tax Category Name field Blank");
		
		addNewTax.clickOnUpdateButton();
		child7.log(LogStatus.INFO, "click On Update Button with keeping Tax Category Name Blank.");
		
		String mandatoryTaxCategoryName = addNewTax.getMandatoryValidationTaxCategoryName();
		
		if(mandatoryTaxCategoryName.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button with keeping Tax Category Name field blank.");
			child7.log(LogStatus.PASS, mandatoryTaxCategoryName);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button with keeping Tax Category Name field blank.");
		}
				
		logger.appendChild(child7);
		
		//
		//Check Tax Setup English form with correct input in Tax Category Name field.
		//
		child8=report.startTest("Check Tax Setup English form with correct input in Tax Category Name field");
		
		taxCategoryName = (String) jsonObject.get("Tax Category Name");
		
		addNewTax.enterTaxCategoryName(taxCategoryName);
		child8.log(LogStatus.INFO, "Enter correct Tax Category Name.");
		
		addNewTax.clickOnUpdateButton();
		child8.log(LogStatus.INFO, "click On Update Button with entering correct Tax Category Name.");
		
		child8.log(LogStatus.PASS, "Admin is able to fill correct Tax Category Name and redirects to Sales Tax Setup Arabic form successfully.");
		
		logger.appendChild(child8);
		
		//
		//Check Tax Setup Arabic form with Tax Category Name field Blank.
		//
		child9=report.startTest("Check Tax Setup Arabic form with Tax Category Name field Blank");
		
		addNewTax.clickOnUpdateButton();
		child9.log(LogStatus.INFO, "click On Update Button with keeping Tax Category Name Blank.");
		
		String mandatoryTaxCategoryNameArabic = addNewTax.getMandatoryValidationTaxCategoryName();
		
		if(mandatoryTaxCategoryNameArabic.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button with keeping Tax Category Name field blank.");
			child9.log(LogStatus.PASS, mandatoryTaxCategoryNameArabic);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button with keeping Tax Category Name field blank.");
		}
				
		logger.appendChild(child9);
		
		//
		//Check Tax Setup Arabic form with correct input in Tax Category Name field.
		//
		child10=report.startTest("Check Tax Setup Arabic form with correct input in Tax Category Name field");
		
		addNewTax.enterTaxCategoryName(taxCategoryName);
		child10.log(LogStatus.INFO, "Enter correct Tax Category Name.");
		
		addNewTax.clickOnUpdateButton();
		child10.log(LogStatus.INFO, "click On Update Button with entering correct Tax Category Name.");
		
		String successMessage = addNewTax.getSuccessTaxSetup();
		
		if(successMessage.contains("Successfull"))
		{
			child10.log(LogStatus.PASS, "Admin is able to fill correct Tax Category Name and able to Setup Sales Tax successfully.");
			child10.log(LogStatus.PASS, successMessage);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Admin is not able to fill correct Tax Category Name and not able to Setup Sales Tax successfully.");
			child10.log(LogStatus.PASS, successMessage);
		}
		
		logger.appendChild(child10);
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add New Tax.");
			logger.log(LogStatus.FAIL, "Admin_Sales_Tax", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
