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

import com.Pages.SellerLoginPage;
import com.Pages.UserCreationPage;
import com.Pages.UserLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserLogin {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	ExtentTest child1,child2,child3,child4,child5,child6,child7;
	
	String usernamecorrect,usernamewrong,passwordwrong,password,passwordcorrect;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void userLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Login");
		
		//
		//--------------------------------------------------Opening User Login form.-------------------------------------------------------
		//
		child1=report.startTest("Check opening User Login form");
		
		driver = BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/UserCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		//
		//Created object to call the functions from User Creation Page
		//
		UserCreationPage usercreation = PageFactory.initElements(driver, UserCreationPage.class);
		
		//
		//Created object to call the functions from User Login Page
		//
		UserLoginPage userlogin = PageFactory.initElements(driver, UserLoginPage.class);
		
		//usercreation.clickAcceptCookies();
		//child1.log(LogStatus.INFO, "Accept cookies on the page.");
		
		usercreation.clickOnLoginIcon();
		child1.log(LogStatus.INFO, "Click On Login Icon on Homepage.");
		
		child1.log(LogStatus.PASS, "Click On Login Icon on Homepage.");
		
		logger.appendChild(child1);
		
		//--------------------------------Check User Login with Username Blank--------------------------------------------------------------
		
		child2=report.startTest("Check User login with User Name field blank");
				
		SellerLoginPage sellerlogin=PageFactory.initElements(driver, SellerLoginPage.class);
				
		sellerlogin.clickOnSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit button on login form without entering Username.");
				
		String errorusername = sellerlogin.valiationOfUsernameField();
				
		if(errorusername.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "When user is not entering username and click on Submit button on login form, user is getting correct validation error message.");
			child2.log(LogStatus.PASS, errorusername);
		}
		else
		{
			child2.log(LogStatus.FAIL, "When user is not entering username and click on Submit button on login form, user is not getting validation error message.");
			child2.log(LogStatus.FAIL, errorusername);
		}
				
		logger.appendChild(child2);
				
		//--------------------------------Check User Login with Password Blank---------------------------------------------------------------
				
		child3=report.startTest("Check User login with Password field blank");
				
		usernamecorrect = (String) jsonObject.get("Username Correct");
				
		sellerlogin.enterUserName(usernamecorrect);
		child3.log(LogStatus.INFO, "Enter the User Name.");
				
		sellerlogin.clickOnSubmitButton();
		child3.log(LogStatus.INFO, "Click on Submit button on login form without entering Password.");
				
		String errorpassword = sellerlogin.valiationOfPasswordField();
				
		if(errorpassword.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "When user is not entering Password and click on Submit button on login form, user is getting correct validation error message.");
			child3.log(LogStatus.PASS, errorpassword);
		}
		else
		{
			child3.log(LogStatus.FAIL, "When user is not entering Password and click on Submit button on login form, user is not getting validation error message.");
			child3.log(LogStatus.FAIL, errorpassword);
		}
				
		logger.appendChild(child3);
				
		//--------------------------------Check User Login with wrong User Name and wrong Password-----------------------------------------------
		//
		//Check User Login with wrong User Name and wrong Password
		//
		child4=report.startTest("Check User Login with wrong User Name and wrong Password");
				
		usernamewrong = (String) jsonObject.get("Name");
				
		sellerlogin.enterUserName(usernamewrong);
		child4.log(LogStatus.INFO, "Enter wrong User Name.");
				
		passwordwrong = (String) jsonObject.get("Name");
				
		sellerlogin.enterPassword(passwordwrong);
		child4.log(LogStatus.INFO, "Enter wrong Password.");
				
		sellerlogin.clickOnSubmitButton();
		child4.log(LogStatus.INFO, "Click on Submit button on login form with wrong User Name and wrong Password.");
				
		String invalidusername = sellerlogin.getInvalidError();
				
		if(invalidusername.contains("Invalid"))
		{
			child4.log(LogStatus.PASS, "When user is entering wrong username and click on Submit button on login form, user is getting correct validation error message.");
			child4.log(LogStatus.PASS, invalidusername);
		}
		else
		{
			child4.log(LogStatus.FAIL, "When user is entering wrong username and click on Submit button on login form, user is not getting validation error message.");
			child4.log(LogStatus.FAIL, invalidusername);
		}
				
		logger.appendChild(child4);
				
		//--------------------------------Check User Login with correct User Name and wrong Password-----------------------------------------------
		//
		//Check User Login with correct User Name and wrong Password
		//
		child5=report.startTest("Check User Login with correct User Name and wrong Password");

		sellerlogin.enterUserName(usernamecorrect);
		child5.log(LogStatus.INFO, "Enter correct User Name.");
					
		sellerlogin.enterPassword(passwordwrong);
		child5.log(LogStatus.INFO, "Enter wrong Password.");
						
		sellerlogin.clickOnSubmitButton();
		child5.log(LogStatus.INFO, "Click on Submit button on login form with correct User Name and wrong Password.");
						
		String wrongusername = sellerlogin.getInvalidError();
						
		if(wrongusername.contains("Invalid"))
		{
			child5.log(LogStatus.PASS, "When user is entering correct User Name and wrong Password and click on Submit button on login form, user is getting correct validation error message.");
			child5.log(LogStatus.PASS, wrongusername);
		}
		else
		{
			child5.log(LogStatus.FAIL, "When user is entering correct User Name and wrong Password and click on Submit button on login form, user is not getting validation error message.");
			child5.log(LogStatus.FAIL, wrongusername);
		}
						
		logger.appendChild(child5);
				
		//--------------------------------Check User Login with wrong User Name and correct Password-----------------------------------------------
		//
		//Check User Login with wrong User Name and correct Password
		//
		child6=report.startTest("Check User Login with wrong User Name and correct Password");

		sellerlogin.enterUserName(usernamewrong);
		child6.log(LogStatus.INFO, "Enter wrong User Name.");
				
		passwordcorrect = (String) jsonObject.get("Password Correct");
							
		sellerlogin.enterPassword(passwordcorrect);
		child6.log(LogStatus.INFO, "Enter correct Password.");
								
		sellerlogin.clickOnSubmitButton();
		child6.log(LogStatus.INFO, "Click on Submit button on login form with wrong User Name and correct Password.");
								
		String wrongpassword = sellerlogin.getInvalidError();
							
		if(wrongpassword.contains("Invalid"))
		{
			child6.log(LogStatus.PASS, "When user is entering wrong User Name and correct Password and click on Submit button on login form, user is getting correct validation error message.");
			child6.log(LogStatus.PASS, wrongpassword);
		}
		else
		{
			child6.log(LogStatus.FAIL, "When user is entering wrong User Name and correct Password and click on Submit button on login form, user is not getting validation error message.");
			child6.log(LogStatus.FAIL, wrongpassword);
		}
						
		logger.appendChild(child6);
						
		//--------------------------------Check User Login with Correct User Name and Password-----------------------------------------------
				
		child7=report.startTest("Check User login with correct Username and Password");
		
		sellerlogin.enterUserName(usernamecorrect);
		child7.log(LogStatus.INFO, "Enter the correct User Name.");
				
		sellerlogin.enterPassword(passwordcorrect);
		child7.log(LogStatus.INFO, "Enter the correct Password.");
				
		sellerlogin.clickOnSubmitButton();
		child7.log(LogStatus.INFO, "Click on Submit button on login form with correct Username and Password.");
				
		String currency = userlogin.getLoginTextLoggedin();
				
		if(currency.contains(usernamewrong))
		{
			child7.log(LogStatus.PASS, "User is able to login as a Seller successfully with correct username and password.");
			child7.log(LogStatus.PASS, currency);
		}
		else
		{
			child7.log(LogStatus.FAIL, "User is not able to login with correct username and password.");
			child7.log(LogStatus.FAIL, currency);
		}
				
		logger.appendChild(child7);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		//
		// If test is getting failed then take the screen shot and put it in Automation Report.
		//
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "User is Not able to Login.");
			logger.log(LogStatus.FAIL, "User_ Login_Failed", image);
		}
		//
		// End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
