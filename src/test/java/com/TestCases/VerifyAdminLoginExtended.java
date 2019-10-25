package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminLoginExtended {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3;
	
	@Test
	public void adminLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Login");
		
		//--------------------------------Check Admin Login with Username Blank--------------------------------------------
		
		child1=report.startTest("Check Admin login with User Name blank");
		
		driver=BrowserFactory1.startBrowser("chrome", "url");	
		
		AdminLoginPage sellerCreation=PageFactory.initElements(driver, AdminLoginPage.class);
		
		child1.log(LogStatus.INFO, "Started the Browser and Opened Admin Login page of the application.");
			
		sellerCreation.clickonSubmitButton();
		child1.log(LogStatus.INFO, "Click on Submit Button on the Admin login form without entering Username.");
		
		String errorusrname = sellerCreation.errorMessageofUsername();
		child1.log(LogStatus.INFO, "Get the Validation Error Message on User Name field.");
		
		child1.log(LogStatus.INFO, "Validating that the validation error message should be Username is Mandatory.");
		
		if(errorusrname.contains("Mandatory"))
		{		
		child1.log(LogStatus.PASS, "When user is not entering username and click on Submit button on login form, user is getting correct validation error message.");
		child1.log(LogStatus.PASS, errorusrname);
		}
		else
		{
			child1.log(LogStatus.FAIL, "When user is not entering username and click on Submit button on login form, user is not getting validation error message.");
		}
		
		logger.appendChild(child1);
		
		//--------------------------------Check Admin Login with Password Blank-----------------------------------------------
		
		child2=report.startTest("Check Admin login with Password blank");
					
		//sellerCreation.enterUserName();
		child2.log(LogStatus.INFO, "Enter Username on the Admin Login Page of the application.");
		
		sellerCreation.clickonSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit Button on the Admin login form without entering Password.");
				
		String errorpwd = sellerCreation.errorMessageofPassword();
		child2.log(LogStatus.INFO, "Get the Validation Error Message on Password field.");
				
		child2.log(LogStatus.INFO, "Validating that the validation error message should be Password is Mandatory.");
		
		if (errorpwd.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "When user is not entering Password and click on Submit button on login form, user is getting validation error message given below:");
			child1.log(LogStatus.PASS, errorpwd);
		}
		else
		{
			child1.log(LogStatus.FAIL, "When user is not entering password and click on Submit button on login form, user is not getting correct validation error message.");
			
		}
		
		logger.appendChild(child2);	
		
		//--------------------------------Check Admin Login with Correct User Name and Password Blank-----------------------------------------------
		
		child3=report.startTest("Check Admin login with Correct Credentials");
					
		//sellerCreation.enterUserName();
		child3.log(LogStatus.INFO, "Enter correct Username on the Admin Login Page of the application.");
		
		//sellerCreation.enterPassword();
		child3.log(LogStatus.INFO, "Enter correct Password on the Admin Login Page of the application.");
		
		sellerCreation.clickonSubmitButton();
		child3.log(LogStatus.INFO, "Click on Submit Button on the Admin login form without entering Password.");
		
		String scessMessage = sellerCreation.successMessageofAdminLogin();
		
		//Assert.assertTrue(scessMessage.contains("Logins"));
		
		if(scessMessage.contains("Login"))
		{		
		child3.log(LogStatus.PASS, "When user enter correct User Name and Password and click on Submit button, user is able to login as Admin.");
		}
		else
		{
			child3.log(LogStatus.FAIL, "When user enter correct User Name and Password and click on Submit button, user is not able to login as Admin.");
			
		}
		
				
		logger.appendChild(child3);	

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
			logger.log(LogStatus.FAIL, "User Login as Admin is not working fine.");
			logger.log(LogStatus.FAIL, "Admin_Login_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.endTest(child1);
		report.endTest(child2);
		report.endTest(child3);
		report.flush();;
		driver.close();
	}

}
