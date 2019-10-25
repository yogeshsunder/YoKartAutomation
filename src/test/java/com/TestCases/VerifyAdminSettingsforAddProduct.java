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
import com.Pages.AdminSettingsforAddProductPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminSettingsforAddProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminSettingsforAddProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Settings for Add Product");
		
		//-------------------------------------------------------------Check Redirecting to Product section of General Settings Page--------------------------------------------------------
		
		child1=report.startTest("Check Redirecting to Product section of General Settings Page");
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
		
		adminSettingsforAddProduct.clickOnProduct();
		child1.log(LogStatus.INFO, "click On Product on General Settings page.");
		
		child1.log(LogStatus.PASS, "Admin is able to redirect On Product section of General Settings page successfully.");
		
		logger.appendChild(child1);
		
		//
		//Make Product's Model Mandatory
		//
		child2=report.startTest("Make Product's Model Mandatory");
		
		adminSettingsforAddProduct.checkproductModelMandatoryChecked();
		child2.log(LogStatus.INFO, "Check whether Product Model Mandatory is Checked/Mandatory or not if not then check it.");
		
		adminSettingsforAddProduct.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click On Save Changes.");
		
		child2.log(LogStatus.PASS, "Admin is able to Make Product's Model Mandatory successfully.");
		
		logger.appendChild(child2);
		
		//
		//Make Product's Sku Mandatory Mandatory
		//
		child3=report.startTest("Make Product's Sku Mandatory Mandatory");
		
		adminSettingsforAddProduct.checkproductSkuMandatoryChecked();
		child3.log(LogStatus.INFO, "Check whether Product's Sku Mandatory is Checked/Mandatory or not if not then check it.");
		
		adminSettingsforAddProduct.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click On Save Changes.");
		
		child3.log(LogStatus.PASS, "Admin is able to Make Product's Sku Mandatory Mandatory successfully.");
		
		logger.appendChild(child3);
		
		//
		//Make Product's Dimensions Mandatory
		//
		child4=report.startTest("Make Product's Dimensions Mandatory");
		
		adminSettingsforAddProduct.checkproductDimensionsChecked();
		child4.log(LogStatus.INFO, "Check whether Product's Dimensions is Checked/Mandatory or not if not then check it.");
		
		adminSettingsforAddProduct.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes.");
		
		child4.log(LogStatus.PASS, "Admin is able to Make Product's Dimensions Mandatory successfully.");
		
		logger.appendChild(child4);
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
			logger.log(LogStatus.FAIL, "Admin is Not able to change settings to add New Product.");
			logger.log(LogStatus.FAIL, "Admin_settings_for_add_Product", image);
		}

		report.endTest(logger);

		report.flush();;
		driver.close();
	}

}
