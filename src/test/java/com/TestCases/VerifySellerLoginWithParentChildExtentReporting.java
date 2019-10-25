package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.SellerLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerLoginWithParentChildExtentReporting {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest childTest1;
	ExtentTest childTest2;
	ExtentTest logger1;
	ExtentTest childTest11;
	ExtentTest childTest21;
	
	@Test(priority=0)
	public void verifyLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Login");
		childTest1=report.startTest("Open Browser");
		childTest2=report.startTest("Seller Login");
		
		logger.log(LogStatus.PASS, "Login");
		driver=BrowserFactory.startBrowser("chrome", "url");
		childTest1.log(LogStatus.PASS, "Open Browser");
		
		SellerLoginPage sellerlogin=PageFactory.initElements(driver, SellerLoginPage.class);
		
		sellerlogin.sellerLogin();
		childTest2.log(LogStatus.PASS, "User is able to Login.");
		
		logger.appendChild(childTest1);
		logger.appendChild(childTest2);

	}
	
	@Test(priority=1)
	public void verifyLogin1() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger1=report.startTest("Seller Login1");
		childTest1=report.startTest("Open Browser1");
		childTest2=report.startTest("Seller Login1");
		
		logger1.log(LogStatus.PASS, "Login");
		driver=BrowserFactory.startBrowser("chrome", "url");
		childTest1.log(LogStatus.PASS, "Open Browser");
		
		SellerLoginPage sellerlogin=PageFactory.initElements(driver, SellerLoginPage.class);
		
		sellerlogin.sellerLogin();
		childTest2.log(LogStatus.PASS, "User is able to Login.");
		
		logger1.appendChild(childTest1);
		logger1.appendChild(childTest2);

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
			logger.log(LogStatus.FAIL, "User is Not able to Login as Seller.");
			logger.log(LogStatus.FAIL, "Seller_Login_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}
}
