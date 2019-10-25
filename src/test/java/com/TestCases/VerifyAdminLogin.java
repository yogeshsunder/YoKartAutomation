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

import com.Pages.AdminLoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminLogin {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6;
	
	String userName,userNameWrong,passWordwrong,password;
	
	@Test
	public void adminLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Login");
		JSONParser parser=new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
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
			child1.log(LogStatus.FAIL, errorusrname);
		}
		
		logger.appendChild(child1);
		
		//--------------------------------Check Admin Login with Password Blank-----------------------------------------------
		
		child2=report.startTest("Check Admin login with Password blank");
							
		userName = (String) jsonObject.get("USERNAME");
			
		sellerCreation.enterUserName(userName);
		child2.log(LogStatus.INFO, "Enter Username on the Admin Login Page of the application.");
				
		sellerCreation.clickonSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit Button on the Admin login form without entering Password.");
						
		String errorpwd = sellerCreation.errorMessageofPassword();
		child2.log(LogStatus.INFO, "Get the Validation Error Message on Password field.");
					
		child2.log(LogStatus.INFO, "Validating that the validation error message should be Password is Mandatory.");
				
		if (errorpwd.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "When user is not entering Password and click on Submit button on login form, user is getting validation error message given below:");
			child2.log(LogStatus.PASS, errorpwd);
		}
		else
		{
			child2.log(LogStatus.FAIL, "When user is not entering password and click on Submit button on login form, user is not getting correct validation error message.");
			child2.log(LogStatus.FAIL, errorpwd);
			
		}
				
		logger.appendChild(child2);	
		
		//--------------------------------Check Admin Login with wrong Username and wrong Password-----------------------------------------------
		
		child3=report.startTest("Check Admin Login with wrong Username and wrong Password");
				
		userNameWrong = (String) jsonObject.get("USERNAME WRONG");
				
		sellerCreation.enterUserName(userNameWrong);
		child3.log(LogStatus.INFO, "Enter Wrong Username on the Admin Login Page of the application.");
				
		passWordwrong = (String) jsonObject.get("PASSWORD WRONG");
				
		sellerCreation.enterPassword(passWordwrong);
		child3.log(LogStatus.INFO, "Enter Wrong Password on the Admin Login Page of the application.");
				
		sellerCreation.clickonSubmitButton();
		child3.log(LogStatus.INFO, "Click on Submit Button on the Admin login form with entering Wrong Username and wrong password.");
				
		String invaliduidpwd = sellerCreation.getInvalidMessage();
				
		if(invaliduidpwd.contains("Invalid Username Or Password")) 
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save button when entering wrong username and wrong password.");
			child3.log(LogStatus.PASS, invaliduidpwd);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save button when entering wrong username and wrong password.");
			child3.log(LogStatus.FAIL, invaliduidpwd);
		}
				
		logger.appendChild(child3);	
		
		//--------------------------------Check Admin Login with correct Username and wrong Password-----------------------------------------------
		
		child4=report.startTest("Check Admin Login with correct Username and wrong Password");
				
		userName = (String) jsonObject.get("USERNAME");
				
		sellerCreation.enterUserName(userName);
		child4.log(LogStatus.INFO, "Enter correct Username on the Admin Login Page of the application.");
				
		sellerCreation.enterPassword(passWordwrong);
		child4.log(LogStatus.INFO, "Enter Wrong Password on the Admin Login Page of the application.");
				
		sellerCreation.clickonSubmitButton();
		child4.log(LogStatus.INFO, "Click on Submit Button on the Admin login form with entering Wrong password.");
				
		String invalidpwd = sellerCreation.getInvalidMessage();
				
		if(invalidpwd.contains("Invalid Username Or Password")) 
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save button when entering wrong password.");
			child4.log(LogStatus.PASS, invalidpwd);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save button when entering wrong password.");
			child4.log(LogStatus.FAIL, invalidpwd);
		}
					
		logger.appendChild(child4);
		
		//--------------------------------Check Admin Login with wrong Username and correct Password-----------------------------------------------
		
		child5=report.startTest("Check Admin Login with wrong Username and correct Password");
				
		sellerCreation.enterUserName(userNameWrong);
		child5.log(LogStatus.INFO, "Enter wrong Username on the Admin Login Page of the application.");
				
		password = (String) jsonObject.get("PASSWORD");
				
		sellerCreation.enterPassword(password);
		child5.log(LogStatus.INFO, "Enter correct Password on the Admin Login Page of the application.");
				
		sellerCreation.clickonSubmitButton();
		child5.log(LogStatus.INFO, "Click on Submit Button on the Admin login form with entering Wrong username.");
				
		String invalidusername = sellerCreation.getInvalidMessage();
				
		if(invalidusername.contains("Invalid Username Or Password")) 
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save button when entering wrong username.");
			child5.log(LogStatus.PASS, invalidusername);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save button when entering wrong username.");
			child5.log(LogStatus.FAIL, invalidusername);
		}
					
		logger.appendChild(child5);
		
		//--------------------------------Check Admin Login with Correct User Name and correct Password-----------------------------------------------
		
		child6=report.startTest("Check Admin Login with Correct User Name and correct Password");
							
		sellerCreation.enterUserName(userName);
		child6.log(LogStatus.INFO, "Enter correct Username on the Admin Login Page of the application.");
						
		sellerCreation.enterPassword(password);
		child6.log(LogStatus.INFO, "Enter correct Password on the Admin Login Page of the application.");
					
		sellerCreation.clickonSubmitButton();
		child6.log(LogStatus.INFO, "Click on Submit Button on the Admin login form without entering Password.");
						
		String scessMessage = sellerCreation.successMessageofAdminLogin();
					
		//Assert.assertTrue(scessMessage.contains("Logins"));
						
		if(scessMessage.contains("Login"))
		{		
			child6.log(LogStatus.PASS, "When user enter correct User Name and Password and click on Submit button, user is able to login as Admin.");
			child6.log(LogStatus.PASS, scessMessage);
		}
		else
		{
			child6.log(LogStatus.FAIL, "When user enter correct User Name and Password and click on Submit button, user is not able to login as Admin.");
				
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
			logger.log(LogStatus.FAIL, "User Login as Admin is not working fine.");
			logger.log(LogStatus.FAIL, "Admin_Login_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
