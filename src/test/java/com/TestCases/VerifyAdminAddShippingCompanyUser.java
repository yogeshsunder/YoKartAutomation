package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminAddDurationLabelPage;
import com.Pages.AdminAddShippingCompanyUserPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddShippingCompanyUser {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddShippingCompanyUser() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		String uuid = UUID.randomUUID().toString();
		String uuid1 = UUID.randomUUID().toString() + "@dummyid.com";
		String uuid2 = UUID.randomUUID().toString();
		String uuid3 = UUID.randomUUID().toString();
		String uuid4 = UUID.randomUUID().toString();
		
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Shipping Company Users");
		
		//-------------------------------------------------------------Redirecting to Shipping Company User set up Form--------------------------------------------------------
		
		child1=report.startTest("Check opening Shipping Company User set up form");
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
		AdminAddShippingCompanyUserPage addShippingCompanyUser=PageFactory.initElements(driver, AdminAddShippingCompanyUserPage.class);
		
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
		
		addShippingCompanyUser.clickOnShippingCompanyUsers();
		child1.log(LogStatus.INFO, "Click On Shipping Company Users on Shipping API of Dashboard drop down.");
		
		addShippingCompanyUser.clickOnAddUserIcon();
		child1.log(LogStatus.INFO, "Click On Add User Icon on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.clickOnAddUser();
		child1.log(LogStatus.INFO, "Click On Add User on Manage Shipping Company Users Page.");
		child1.log(LogStatus.PASS, "Admin is able to open Shipping Company User set up form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Shipping Company User set up form with Username field blank
		//
		child2=report.startTest("Check Shipping Company User set up form with Username field blank.");
		
		addShippingCompanyUser.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click on Save Changes with keeping Uesrname field blank.");
		
		String mandatoryusername = addShippingCompanyUser.getMandatoryUserName();
		if(mandatoryusername.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes with keeping username field blank.");
			child2.log(LogStatus.PASS, mandatoryusername);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes with keeping username field blank.");
		}
		
		addShippingCompanyUser.clickOnCloseIcon();
		child2.log(LogStatus.INFO, "Close the Shipping Company User form.");
		
		logger.appendChild(child2);
		
		//
		//Check Shipping Company User set up form with Customer Name field blank
		//
		child3=report.startTest("Check Shipping Company User set up form with Customer Name field blank.");
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		
		addShippingCompanyUser.clickOnAddUserIcon();
		child3.log(LogStatus.INFO, "Click On Add User Icon on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.clickOnAddUser();
		child3.log(LogStatus.INFO, "Click On Add User on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.enterUserName(uuid2);
		child3.log(LogStatus.INFO, "Enter non-existing User Name.");
		
		addShippingCompanyUser.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click on Save Changes.");
		
		String mandatoryCustomerName = addShippingCompanyUser.getMandatoryCustomerName();
		
		if(mandatoryCustomerName.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes with keeping Customer Name field blank.");
			child3.log(LogStatus.PASS, mandatoryCustomerName);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes with keeping Customer Name field blank.");
		}
		
		addShippingCompanyUser.clickOnCloseIcon();
		child3.log(LogStatus.INFO, "Close the Shipping Company User form.");
		
		logger.appendChild(child3);
		
		//
		//Check Shipping Company User set up form with Email field blank
		//
		child4=report.startTest("Check Shipping Company User set up form with Email field blank.");
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		
		addShippingCompanyUser.clickOnAddUserIcon();
		child4.log(LogStatus.INFO, "Click On Add User Icon on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.clickOnAddUser();
		child4.log(LogStatus.INFO, "Click On Add User on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.enterUserName(uuid3);
		child4.log(LogStatus.INFO, "Enter non-existing User Name.");
		
		addShippingCompanyUser.enterCustomerName(uuid3);
		child4.log(LogStatus.INFO, "Enter non-existing Customer Name.");
		
		addShippingCompanyUser.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click on Save Changes.");
		
		String mandatoryEmail = addShippingCompanyUser.getMandatoryEmail();
		
		if(mandatoryEmail.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes with keeping Email field blank.");
			child4.log(LogStatus.PASS, mandatoryEmail);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes with keeping Email field blank.");
		}
		
		addShippingCompanyUser.clickOnCloseIcon();
		child4.log(LogStatus.INFO, "Close the Shipping Company User form.");
		
		logger.appendChild(child4);
		
		//
		//Check Shipping Company User set up form with wrong invalid email
		//
		child5=report.startTest("Check Shipping Company User set up form with invalid email.");
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		
		addShippingCompanyUser.clickOnAddUserIcon();
		child5.log(LogStatus.INFO, "Click On Add User Icon on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.clickOnAddUser();
		child5.log(LogStatus.INFO, "Click On Add User on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.enterUserName(uuid4);
		child5.log(LogStatus.INFO, "Enter non-existing User Name.");
		
		addShippingCompanyUser.enterCustomerName(uuid4);
		child5.log(LogStatus.INFO, "Enter non-existing Customer Name.");
		
		addShippingCompanyUser.enterEmail(uuid4);
		child5.log(LogStatus.INFO, "Enter invalid Email.");
		
		addShippingCompanyUser.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click on Save Changes.");
		
		String invalidEmail = addShippingCompanyUser.getMandatoryEmail();
				
		if(invalidEmail.contains("Please Enter Valid Email Id For Email"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes with entering invalid Email.");
			child5.log(LogStatus.PASS, invalidEmail);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes with entering invalid Email.");
		}
		
		addShippingCompanyUser.clickOnCloseIcon();
		child5.log(LogStatus.INFO, "Close the Shipping Company User form.");
		
		logger.appendChild(child5);
		
		//
		//Check Shipping Company User set up form with all correct inputs
		//
		child6=report.startTest("Check Shipping Company User set up form with all correct inputs");
		
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.id("facebox_overlay")));
		
		addShippingCompanyUser.clickOnAddUserIcon();
		child6.log(LogStatus.INFO, "Click On Add User Icon on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.clickOnAddUser();
		child6.log(LogStatus.INFO, "Click On Add User on Manage Shipping Company Users Page.");
		
		addShippingCompanyUser.enterUserName(uuid);
		child6.log(LogStatus.INFO, "Enter non-existing User Name.");
		
		addShippingCompanyUser.enterCustomerName(uuid);
		child6.log(LogStatus.INFO, "Enter non-existing Customer Name.");
		
		addShippingCompanyUser.enterEmail(uuid1);
		//addShippingCompanyUser.enterEmail("@dummyid.com");
		child6.log(LogStatus.INFO, "Enter invalid Email.");
		
		addShippingCompanyUser.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click on Save Changes.");
		
		String createdUsername = addShippingCompanyUser.getUsernameCreated();
		
		if(createdUsername.equals(uuid))
		{
			child6.log(LogStatus.PASS, "Admin is able to create Shipping Company User successfully.");
			child6.log(LogStatus.PASS, createdUsername);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not able to create Shipping Company User successfully.");
			child6.log(LogStatus.FAIL, createdUsername);
		}
		
		logger.appendChild(child6);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Shipping Company User.");
			logger.log(LogStatus.FAIL, "Admin_shipping_company_user", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
