package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.AdminAddDiscountCouponPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.Pages.SellerAddNewProductPage;
import com.Pages.SellerLoginPage;
import com.Pages.SellerProductSpecialOfferPricePage;
import com.Pages.SellerShopCreationPage;
import com.Pages.UserAddtoCartPage;
import com.Pages.UserBuyNowPage;
import com.Pages.UserCheckoutwithSpecialPricePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyUserCheckoutwithDiscountCoupon {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16;
	
	String coupon_Identifier,coupon_codeduplicate,product_Purchase,discount_nonNumeric,discount_value_correct,min_order_value_nonNumeric;
	String min_order_value_correct,max_discoun_nonNumeric,max_order_value_correct,uses_Per_Coupon,uses_Per_Customer;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void userCheckoutwithDiscountCoupon() throws FileNotFoundException, IOException, InterruptedException, ParseException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("User Checkout with Discount Coupon");
		
		//
		//Get the data from the Json file i.e. adminAddDiscountCouponInputData from JSONData package
		//
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddDiscountCouponInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		//-------------------------------------------------------------Add New Discount Coupon General Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Dscount Coupon Setup Form");
		//
		//Start the Browser from BrowserFactory from Helper and Admin Login page of the application.
		//		
		driver=BrowserFactory1.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Admin Login page of the application.");
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Login Page for Admin Login.
		//
		AdminLoginPage adminlogin=PageFactory.initElements(driver, AdminLoginPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from AdminSellerApprovalFormPage to click on dashboard from top.
		//
		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Discount Coupon Page to click on dashboard from top.
		//
		AdminAddDiscountCouponPage addDiscountCoupon=PageFactory.initElements(driver, AdminAddDiscountCouponPage.class);
		
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
		
		addDiscountCoupon.clickonCms();
		child1.log(LogStatus.INFO, "Admin is able to Click on CMS Icon on the top left of the Dashboard.");
		
		addDiscountCoupon.clickOnDiscountCoupon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Discount Coupon on the top left of the Dashboard.");
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		//
		// If test is getting failed then take the screen shot and put it in Automation Report.
		//
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Special price is not correct for added product.");
			logger.log(LogStatus.FAIL, "Special_Search_Wrong", image);
		}
		//
		// End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();
		;
		//driver.close();

	}

}
