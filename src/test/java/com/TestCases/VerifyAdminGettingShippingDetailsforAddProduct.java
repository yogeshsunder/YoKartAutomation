package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminAddDurationLabelPage;
import com.Pages.AdminGetShippingDetailsForAddProductsPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminGettingShippingDetailsforAddProduct {
	
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2;
	
	@Test
	public void adminGetShippingDetailsForAddProducts() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Get Shipping Details for Add Product");
		
		//-------------------------------------------------------------Redirecting to Duration Label Setup Form--------------------------------------------------------
		
		child1=report.startTest("Get Duration Label for Add Product");
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
		//Created Page Object using Page Factory to call the functions from Admin Add Duration Label Page to click on dashboard from top.
		//
		AdminGetShippingDetailsForAddProductsPage getshippingdetails=PageFactory.initElements(driver, AdminGetShippingDetailsForAddProductsPage.class);
		
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
		
		
		
		String durationlabel = getshippingdetails.getShppingDurationLabel();
		
		System.out.println(durationlabel);
		
		child1.log(LogStatus.INFO, durationlabel);
		
		logger.appendChild(child1);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to get shipping details for Add Product.");
			logger.log(LogStatus.FAIL, "Admin_get_Shipping", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
