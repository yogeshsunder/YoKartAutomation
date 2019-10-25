package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddDiscountCoupon {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16;
	
	String coupon_Identifier,coupon_codeduplicate,product_Purchase,discount_nonNumeric,discount_value_correct,min_order_value_nonNumeric;
	String min_order_value_correct,max_discoun_nonNumeric,max_order_value_correct,uses_Per_Coupon,uses_Per_Customer;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddNewDiscountCoupon() throws FileNotFoundException, IOException, InterruptedException, ParseException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add New Dscount Coupn");
		
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
		
		addDiscountCoupon.clickonAddIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Add Icon on Manage Coupons Page.");
		
		addDiscountCoupon.clickAddNewCoupon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Add New Coupon on Manage Coupons Page.");
		
		child1.log(LogStatus.PASS, "Admin is able to Open Dscount Coupon Setup Form on Manage Coupons Page.");

		logger.appendChild(child1);
		
		//
		//Check Coupon Setup form with keeping Coupon Identifier blank
		//
		child2=report.startTest("Check Coupon Setup form with keeping Coupon Identifier blank");
		
		addDiscountCoupon.click_Save_Changes();
		child2.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Coupon Identifier blank.");
		
		String validation_Coupon_Discount = addDiscountCoupon.get_validation_Coupon_Identifier();
		
		if(validation_Coupon_Discount.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Coupon Identifier blank.");
			child2.log(LogStatus.PASS, validation_Coupon_Discount);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Coupon Identifier blank.");
			child2.log(LogStatus.FAIL, validation_Coupon_Discount);
		}
		
		logger.appendChild(child2);
		
		//
		//Check Coupon Setup form with keeping Coupon Code field blank
		//
		child3=report.startTest("Check Coupon Setup form with keeping Coupon Code field blank");
		
		coupon_Identifier = (String) jsonObject.get("Coupon Identifier");
		
		addDiscountCoupon.enter_Coupon_Identifier(coupon_Identifier);
		child3.log(LogStatus.INFO, "Enter Coupon Identifier in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child3.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Coupon Code field blank.");

		String validationCouponCode = addDiscountCoupon.getValidationCouponCode();
		
		if(validationCouponCode.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Coupon Code blank.");
			child3.log(LogStatus.PASS, validationCouponCode);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Coupon Code blank.");
			child3.log(LogStatus.FAIL, validationCouponCode);
		}
		
		logger.appendChild(child3);
		
		//
		//Check Coupon Setup form with keeping Select Discount Type field blank
		//
		child4=report.startTest("Check Coupon Setup form with keeping Select Discount Type field blank");
		
		String coupon_code = RandomStringUtils.random(8, "0123456789abcdefghijklmnopqrst"); 
		
		addDiscountCoupon.enterCoupnCode(coupon_code);
		child4.log(LogStatus.INFO, "Enter Coupon Code in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child4.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Select Discount Type field blank.");
		
		String validation_Coupon_Identifier = addDiscountCoupon.get_validation_Select_Discount_Type();
		
		if (validation_Coupon_Identifier.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Select Discount Type field blank.");
			child4.log(LogStatus.PASS, validationCouponCode);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Select Discount Type field blank.");
			child4.log(LogStatus.FAIL, validationCouponCode);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Coupon Setup form with keeping Discount Value field blank
		//
		child5=report.startTest("Check Coupon Setup form with keeping Discount Value field blank");
		
		product_Purchase = (String) jsonObject.get("Select Discount Type for Product Purchase");
		
		addDiscountCoupon.enter_coupon_Type(product_Purchase);
		child5.log(LogStatus.INFO, "Enter Discount Type in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child5.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Discount Value field blank.");
		
		String coupon_discount_value = addDiscountCoupon.get_validation_coupon_discount_value();
		
		if(coupon_discount_value.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Discount Value field blank.");
			child5.log(LogStatus.PASS, validationCouponCode);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Discount Value field blank.");
			child5.log(LogStatus.FAIL, validationCouponCode);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Coupon Setup form with entering non-numeric Discount Value
		//
		child6=report.startTest("Check Coupon Setup form with entering non-numeric Discount Value");
		
		discount_nonNumeric = (String) jsonObject.get("Discount Value Non-Numeric");
		
		addDiscountCoupon.enter_Discount_Value(discount_nonNumeric);
		child6.log(LogStatus.INFO, "Enter non-numeric Discount Value in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child6.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with entering non-numeric Discount Value.");
		
		String nonnumeric_discount_value = addDiscountCoupon.get_validation_coupon_discount_value();
		
		if(nonnumeric_discount_value.contains("Numeric"))
		{
			child6.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with entering non-numeric Discount Value field blank.");
			child6.log(LogStatus.PASS, nonnumeric_discount_value);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with entering non-numeric Discount Value field blank.");
			child6.log(LogStatus.FAIL, nonnumeric_discount_value);
		}
		
		logger.appendChild(child6);
		
		//
		//Check Coupon Setup form with keeping Min Order Value blank
		//
		child7=report.startTest("Check Coupon Setup form with keeping Min Order Value blank");
		
		discount_value_correct = (String) jsonObject.get("Discount Value Correct");
		
		addDiscountCoupon.enter_Discount_Value(discount_value_correct);
		child7.log(LogStatus.INFO, "Enter correct Discount Value in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child7.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Min Order Value blank.");
		
		String validation_Min_Order_Value = addDiscountCoupon.get_validation_Min_Order_Value();
		
		if(validation_Min_Order_Value.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Min Order Value blank.");
			child7.log(LogStatus.PASS, nonnumeric_discount_value);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Min Order Value blank.");
			child7.log(LogStatus.FAIL, nonnumeric_discount_value);
		}
		
		logger.appendChild(child7);
		
		//
		//Check Coupon Setup form with entering non-numeric Min Order Value
		//
		child8=report.startTest("Check Coupon Setup form with entering non-numeric Min Order Value");
		
		min_order_value_nonNumeric = (String) jsonObject.get("Min Order Value non-numeric");
		
		addDiscountCoupon.enter_min_order_value(min_order_value_nonNumeric);
		child8.log(LogStatus.INFO, "Enter Non-Numeric Minimum Order Value in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child8.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with entering non-numeric Min Order Value.");
		
		String nonNumeric_Min_Order_Value = addDiscountCoupon.get_validation_Min_Order_Value();
		
		if(nonNumeric_Min_Order_Value.contains("Numeric"))
		{
			child8.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with entering non-numeric Min Order Value.");
			child8.log(LogStatus.PASS, nonNumeric_Min_Order_Value);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with entering non-numeric Min Order Value.");
			child8.log(LogStatus.FAIL, nonNumeric_Min_Order_Value);
		}
		
		logger.appendChild(child8);
		
		//
		//Check Coupon Setup form with keeping Max Discount Value field blank
		//
		child9=report.startTest("Check Coupon Setup form with keeping Max Discount Value field blank");
		
		min_order_value_correct = (String) jsonObject.get("Min Order Value Correct");
		
		addDiscountCoupon.enter_min_order_value(min_order_value_correct);
		child9.log(LogStatus.INFO, "Enter correct Minimum Order Value in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child9.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with keeping Max Discount Value field blank.");
		
		String correct_Min_Order_Value = addDiscountCoupon.get_validation_Max_Discount_Value();
		
		if(correct_Min_Order_Value.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with keeping Max Discount Value field blank.");
			child9.log(LogStatus.PASS, correct_Min_Order_Value);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with keeping Max Discount Value field blank.");
			child9.log(LogStatus.FAIL, correct_Min_Order_Value);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Coupon Setup form with entering Non-Numeric Max Discount Value
		//
		child10=report.startTest("Check Coupon Setup form with entering Non-Numeric Max Discount Value");
		
		max_discoun_nonNumeric = (String) jsonObject.get("Min Order Value non-numeric");
		
		addDiscountCoupon.enter_max_discount_value(max_discoun_nonNumeric);
		child10.log(LogStatus.INFO, "Enter Non-Numeric Max Discount Value in Coupon setup form.");
		
		addDiscountCoupon.click_Save_Changes();
		child10.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with entering Non-Numeric Max Discount Value.");
		
		String nonNumeric_Max_discount_Value = addDiscountCoupon.get_validation_Max_Discount_Value();
		
		if(nonNumeric_Max_discount_Value.contains("Numeric"))
		{
			child10.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup form with entering Non-Numeric Max Discount Value.");
			child10.log(LogStatus.PASS, nonNumeric_Max_discount_Value);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup form with entering Non-Numeric Max Discount Value.");
			child10.log(LogStatus.FAIL, nonNumeric_Max_discount_Value);
		}
		
		logger.appendChild(child10);
		
		//
		//Check Coupon Setup form with entering correct inputs for General form
		//
		child11=report.startTest("Check Coupon Setup form with entering correct inputs for General form");
		
		max_order_value_correct = (String) jsonObject.get("Max Order Value Correct");
		
		addDiscountCoupon.enter_max_discount_value(max_order_value_correct);
		child11.log(LogStatus.INFO, "Enter correct Max Discount Value in Coupon setup form.");
		
		uses_Per_Coupon = (String) jsonObject.get("Uses Per Coupon");
		
		addDiscountCoupon.enter_uses_per_count(uses_Per_Coupon);
		
		uses_Per_Customer = (String) jsonObject.get("Uses Per Customer");
		
		addDiscountCoupon.enter_uses_per_customer(uses_Per_Customer);
		
		addDiscountCoupon.click_Save_Changes();
		child11.log(LogStatus.INFO, "Click on Submit button on Coupon Setup form with entering correct inputs for General form.");
		
		child11.log(LogStatus.PASS, "Admin is able to redirect to Coupon Setup English form when entering correct inputs for General form successfully.");
		
		logger.appendChild(child11);
		
		//
		//Check Coupon Setup English form with keeping Coupon Title field blank
		//
		child12=report.startTest("Check Coupon Setup English form with keeping Coupon Title field blank");
		
		addDiscountCoupon.click_Save_Changes_English();
		child12.log(LogStatus.INFO, "Click on Save Changes button on Coupon Setup English form with keeping Coupon Title feidl blank.");
		
		String coupon_title = addDiscountCoupon.get_validation_coupon_title();
		
		if(coupon_title.contains("Mandatory"))
		{
			child12.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup English form with keeping Coupon Title field blank.");
			child12.log(LogStatus.PASS, coupon_title);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup English form with keeping Coupon Title field blank.");
			child12.log(LogStatus.FAIL, coupon_title);
		}
		
		logger.appendChild(child12);
		
		//
		//Check Coupon Setup English form with entering correct Coupon Title field
		//
		child13=report.startTest("Check Coupon Setup English form with entering correct Coupon Title field");
		
		String coupon_code_english = RandomStringUtils.random(8, "0123456789abcdefghijklmnopqrst"); 
		
		addDiscountCoupon.enter_coupon_title_english(coupon_code_english);
		child13.log(LogStatus.INFO, "Enter Coupon Title English in Coupon Setup English form");
		
		addDiscountCoupon.click_Save_Changes_English();
		child13.log(LogStatus.INFO, "Click on Save Changes button on Coupon Setup English form with entering correct Coupon Title.");
		
		child13.log(LogStatus.PASS, "Admin is able to enter Coupon Setup English form successfully.");
		
		logger.appendChild(child13);
		
		//
		//Check Coupon Setup Arabic form with keeping Coupon Title field blank
		//
		child14=report.startTest("Check Coupon Setup Arabic form with keeping Coupon Title field blank");
		
		addDiscountCoupon.click_Save_Changes_English();
		child14.log(LogStatus.INFO, "Click on Save Changes button on Coupon Setup Arabic form with keeping Coupon Title feid blank.");
		
		String coupon_title_arabic = addDiscountCoupon.get_validation_coupon_title();
		
		if(coupon_title_arabic.contains("Mandatory"))
		{
			child14.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Submit button on Coupon Setup Arabic form with keeping Coupon Title field blank.");
			child14.log(LogStatus.PASS, coupon_title_arabic);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Submit button on Coupon Setup Arabic form with keeping Coupon Title field blank.");
			child14.log(LogStatus.FAIL, coupon_title_arabic);
		}
		
		logger.appendChild(child14);
		
		//
		//Check Coupon Setup Arabic form with entering correct Coupon Title field
		//
		child15=report.startTest("Check Coupon Setup Arabic form with entering correct Coupon Title field");
		
		String coupon_code_arabic = RandomStringUtils.random(8, "0123456789abcdefghijklmnopqrst"); 
		
		addDiscountCoupon.enter_coupon_title_english(coupon_code_arabic);
		child15.log(LogStatus.INFO, "Enter Coupon Title Arabic in Coupon Setup English form");
		
		addDiscountCoupon.click_Save_Changes_English();
		child15.log(LogStatus.INFO, "Click on Save Changes button on Coupon Setup Arabic form with entering correct Coupon Title.");
		
		child15.log(LogStatus.PASS, "Admin is able to enter Coupon Setup Arabic form successfully.");
		
		logger.appendChild(child15);
		
		//
		//Check Coupon Media Setup form with uploading file
		//
		child16=report.startTest("Check Coupon Media Setup form with uploading file");
		
		addDiscountCoupon.click_upload_coupon_image();
		child16.log(LogStatus.INFO, "Click on Upload Image button in Coupon Media Setup form");
		
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");
		Thread.sleep(7000);
		
		addDiscountCoupon.cilck_close_image();
		child16.log(LogStatus.PASS, "Click on Close Image icon on Coupon Media Setup form.");
		
		child16.log(LogStatus.PASS, "Admin is able to create Discount coupon successfully.");
		
		logger.appendChild(child16);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Discount Coupon.");
			logger.log(LogStatus.FAIL, "Admin_add_Coupon", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);

		report.flush();;
		driver.close();
	}

}
