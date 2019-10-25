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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerLogin {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6;
	
	String usernamecorrect,usernamewrong,passwordwrong,password,passwordcorrect;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifyLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Login");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		//--------------------------------Check Seller Login with Username Blank--------------------------------------------------------------
		
		child1=report.startTest("Check Seller login with User Name field blank");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		SellerLoginPage sellerlogin=PageFactory.initElements(driver, SellerLoginPage.class);
		
		sellerlogin.clickOnLogin();
		child1.log(LogStatus.INFO, "Click on Login option at the top of the Home page.");
		
		sellerlogin.clickOnSubmitButton();
		child1.log(LogStatus.INFO, "Click on Submit button on login form without entering Username.");
		
		String errorusername = sellerlogin.valiationOfUsernameField();
		
		if(errorusername.contains("Mandatory"))
		{
			child1.log(LogStatus.PASS, "When user is not entering username and click on Submit button on login form, user is getting correct validation error message.");
			child1.log(LogStatus.PASS, errorusername);
		}
		else
		{
			child1.log(LogStatus.FAIL, "When user is not entering username and click on Submit button on login form, user is not getting validation error message.");
			child1.log(LogStatus.FAIL, errorusername);
		}
		
		logger.appendChild(child1);
		
		//--------------------------------Check Seller Login with Password Blank---------------------------------------------------------------
		
		child2=report.startTest("Check Seller login with Password field blank");
		
		usernamecorrect = (String) jsonObject.get("UsernameForRegistrationDetails");
		
		sellerlogin.enterUserName(usernamecorrect);
		child2.log(LogStatus.INFO, "Enter the User Name.");
		
		sellerlogin.clickOnSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit button on login form without entering Password.");
		
		String errorpassword = sellerlogin.valiationOfPasswordField();
		
		if(errorpassword.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "When user is not entering Password and click on Submit button on login form, user is getting correct validation error message.");
			child2.log(LogStatus.PASS, errorpassword);
		}
		else
		{
			child2.log(LogStatus.FAIL, "When user is not entering Password and click on Submit button on login form, user is not getting validation error message.");
			child2.log(LogStatus.FAIL, errorpassword);
		}
		
		logger.appendChild(child2);
		
		//--------------------------------Check Seller Login with wrong User Name and wrong Password-----------------------------------------------
		//
		//Check Seller Login with wrong User Name and wrong Password
		//
		child3=report.startTest("Check Seller Login with wrong User Name and wrong Password");
		
		usernamewrong = (String) jsonObject.get("User Name Wrong");
		
		sellerlogin.enterUserName(usernamewrong);
		child3.log(LogStatus.INFO, "Enter wrong User Name.");
		
		passwordwrong = (String) jsonObject.get("Password Wrong");
		
		sellerlogin.enterPassword(passwordwrong);
		child3.log(LogStatus.INFO, "Enter wrong Password.");
		
		sellerlogin.clickOnSubmitButton();
		child3.log(LogStatus.INFO, "Click on Submit button on login form with wrong User Name and wrong Password.");
		
		String invalidusername = sellerlogin.getInvalidError();
		
		if(invalidusername.contains("Invalid"))
		{
			child3.log(LogStatus.PASS, "When user is entering wrong username and click on Submit button on login form, user is getting correct validation error message.");
			child3.log(LogStatus.PASS, invalidusername);
		}
		else
		{
			child3.log(LogStatus.FAIL, "When user is entering wrong username and click on Submit button on login form, user is not getting validation error message.");
			child3.log(LogStatus.FAIL, invalidusername);
		}
		
		logger.appendChild(child3);
		
		//--------------------------------Check Seller Login with correct User Name and wrong Password-----------------------------------------------
		//
		//Check Seller Login with correct User Name and wrong Password
		//
		child4=report.startTest("Check Seller Login with correct User Name and wrong Password");

		sellerlogin.enterUserName(usernamecorrect);
		child4.log(LogStatus.INFO, "Enter correct User Name.");
			
		sellerlogin.enterPassword(passwordwrong);
		child4.log(LogStatus.INFO, "Enter wrong Password.");
				
		sellerlogin.clickOnSubmitButton();
		child4.log(LogStatus.INFO, "Click on Submit button on login form with correct User Name and wrong Password.");
				
		String wrongusername = sellerlogin.getInvalidError();
				
		if(wrongusername.contains("Invalid"))
		{
			child4.log(LogStatus.PASS, "When user is entering correct User Name and wrong Password and click on Submit button on login form, user is getting correct validation error message.");
			child4.log(LogStatus.PASS, wrongusername);
		}
		else
		{
			child4.log(LogStatus.FAIL, "When user is entering correct User Name and wrong Password and click on Submit button on login form, user is not getting validation error message.");
			child4.log(LogStatus.FAIL, wrongusername);
		}
				
		logger.appendChild(child4);
		
		//--------------------------------Check Seller Login with wrong User Name and correct Password-----------------------------------------------
		//
		//Check Seller Login with wrong User Name and correct Password
		//
		child5=report.startTest("Check Seller Login with wrong User Name and correct Password");

		sellerlogin.enterUserName(usernamewrong);
		child5.log(LogStatus.INFO, "Enter wrong User Name.");
		
		passwordcorrect = (String) jsonObject.get("PasswordForRegistrationDetails");
					
		sellerlogin.enterPassword(passwordcorrect);
		child5.log(LogStatus.INFO, "Enter correct Password.");
						
		sellerlogin.clickOnSubmitButton();
		child5.log(LogStatus.INFO, "Click on Submit button on login form with wrong User Name and correct Password.");
						
		String wrongpassword = sellerlogin.getInvalidError();
						
		if(wrongpassword.contains("Invalid"))
		{
			child5.log(LogStatus.PASS, "When user is entering wrong User Name and correct Password and click on Submit button on login form, user is getting correct validation error message.");
			child5.log(LogStatus.PASS, wrongpassword);
		}
		else
		{
			child5.log(LogStatus.FAIL, "When user is entering wrong User Name and correct Password and click on Submit button on login form, user is not getting validation error message.");
			child5.log(LogStatus.FAIL, wrongpassword);
		}
						
		logger.appendChild(child5);
		
		
		//--------------------------------Check Seller Login with Correct User Name and Password-----------------------------------------------
		
		child6=report.startTest("Check Seller login with correct Username and Password");
		
		sellerlogin.enterUserName(usernamecorrect);
		child6.log(LogStatus.INFO, "Enter the correct User Name.");
		
		sellerlogin.enterPassword(passwordcorrect);
		child6.log(LogStatus.INFO, "Enter the correct Password.");
		
		sellerlogin.clickOnSubmitButton();
		child6.log(LogStatus.INFO, "Click on Submit button on login form with correct Username and Password.");
		
		String currency = sellerlogin.getTextofCurrencyOption();
		
		if(currency.contains("Yogesh"))
		{
			child6.log(LogStatus.PASS, "User is able to login as a Seller successfully with correct username and password.");
			child6.log(LogStatus.PASS, currency);
		}
		else
		{
			child6.log(LogStatus.FAIL, "User is not able to login with correct username and password.");
			child6.log(LogStatus.FAIL, currency);
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
			logger.log(LogStatus.FAIL, "User is Not able to Login as Seller.");
			logger.log(LogStatus.FAIL, "Seller_Login_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);;
		report.flush();;
		driver.close();
	}
}
