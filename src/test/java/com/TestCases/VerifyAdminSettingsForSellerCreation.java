package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

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
import com.Pages.AdminSettingsForSellerCreationPage;
import com.Pages.AdminSettingsforAddProductPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminSettingsForSellerCreation {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	ExtentTest child1,child2,child3,child4,child5;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminSettingsforAddProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Settings for Seller Creation");
		
		//-------------------------------------------------------------Check Redirecting to Product section of General Settings Page--------------------------------------------------------
		
		child1=report.startTest("Check Redirecting to Account section of General Settings Page");
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
		//Created Page Object using Page Factory to call the functions from Admin Settings for Add Product Page to click on dashboard from top.
		//
		AdminSettingsforAddProductPage adminSettingsforAddProduct=PageFactory.initElements(driver, AdminSettingsforAddProductPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Settings for Add Product Page to click on dashboard from top.
		//
		AdminSettingsForSellerCreationPage adminSettingsforSellerRegistration=PageFactory.initElements(driver, AdminSettingsForSellerCreationPage.class);
		
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
		
		adminSettingsforAddProduct.clickOnGeneralSettings();
		child1.log(LogStatus.INFO, "Admin is able to click On General Settings under Settings under Dashboard drop down.");
		
		adminSettingsforSellerRegistration.clickOnAccounts();
		child1.log(LogStatus.INFO, "click On Accounts on General Settings page.");
		
		child1.log(LogStatus.PASS, "Admin is able to redirect On Account section of General Settings page successfully.");
		
		logger.appendChild(child1);
		
		//
		//Make Activate Admin Approval After Registration (sign Up) In-Active
		//
		child2=report.startTest("Make Activate Admin Approval After Registration (sign Up) In-Active");
		
		adminSettingsforSellerRegistration.uncheckActivateAdminApprovalAfterRegistration();
		child2.log(LogStatus.INFO, "Uncheck Activate Admin Approval After Registration.");
		
		adminSettingsforSellerRegistration.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "click On Save Changes.");
		
		child2.log(LogStatus.PASS, "Admin is able to make Activate Admin Approval After Registration (sign Up) In-Active.");
		
		logger.appendChild(child2);
		
		//
		//Make Activate Email Verification After Registration In-Active
		//
		child3=report.startTest("Make Activate Email Verification After Registration In-Active");
		
		adminSettingsforSellerRegistration.uncheckActivateEmailVerificationAfterRegistration();
		child3.log(LogStatus.INFO, "Uncheck Activate Email Verification After Registration.");
		
		adminSettingsforSellerRegistration.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "click On Save Changes.");
		
		child3.log(LogStatus.PASS, "Admin is able to make Activate Email Verification After Registration In-Active.");
		
		logger.appendChild(child3);
		
		//
		//Make Activate Separate Seller Sign Up Form Active
		//
		child4=report.startTest("Make Activate Separate Seller Sign Up Form Active");
		
		adminSettingsforSellerRegistration.checkActivateSeparateSellerSignUpForm();
		child4.log(LogStatus.INFO, "Check Activate Separate Seller Sign Up Form.");
		
		adminSettingsforSellerRegistration.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "click On Save Changes.");
		
		child4.log(LogStatus.PASS, "Admin is able to make Activate Separate Seller Sign Up Form Active.");
		
		logger.appendChild(child4);
		
		//
		//Make Activate Administrator Approval On Seller Request In-Active
		//
		child5=report.startTest("Make Activate Administrator Approval On Seller Request In-Active");
		
		adminSettingsforSellerRegistration.uncheckActivateAdministratorApprovalOnSellerRequest();
		child5.log(LogStatus.INFO, "Uncheck Activate Administrator Approval On Seller Request.");
		
		adminSettingsforSellerRegistration.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "click On Save Changes.");
		
		child5.log(LogStatus.PASS, "Admin is able to make Activate Administrator Approval On Seller Request In-Active.");
		
		logger.appendChild(child5);
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
			logger.log(LogStatus.FAIL, "Admin is Not able to change settings for Seller Registration.");
			logger.log(LogStatus.FAIL, "Admin_settings_for_Seller_Registration", image);
		}

		report.endTest(logger);

		report.flush();;
		//driver.close();
	}

}

