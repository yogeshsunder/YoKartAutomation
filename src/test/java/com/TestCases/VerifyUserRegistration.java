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

import com.Pages.UserCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserRegistration {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18;
	
	String name,usernameNonLetter,usernameNonAlphanumeric,usernameLess,usernameMore,usernameDuplicate;
	String usernameCorrect,emailInvalid,emailDuplicate,emailCorrect,passwordNonAlphanumeric,passwordLess;
	String passwordCorrect,confirmPasswordDifferent,confirmPasswordCorrect;
	
	JSONParser parser = new JSONParser();
	
	@Test
	public void userRegistration() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Registration");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/UserCreationInputData.json"));
		JSONObject jsonObject= (JSONObject) obj;
		
		/*
		 * // //Creation of Random input for any field // RandomStringGenerator
		 * generator = new RandomStringGenerator.Builder() .withinRange('0', 'z')
		 * .filteredBy(CharacterPredicates.DIGITS, CharacterPredicates.LETTERS)
		 * .build();
		 */
		//
		//--------------------------------------------------Opening User Registration form.-------------------------------------------------------
		//
		child1=report.startTest("Check opening User Registration form");
		
		driver = BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		UserCreationPage usercreation=PageFactory.initElements(driver, UserCreationPage.class);
		
		//usercreation.clickAcceptCookies();
		//child1.log(LogStatus.INFO, "Accept cookies on the page.");
		
		usercreation.clickOnLoginIcon();
		child1.log(LogStatus.INFO, "Click On Login Icon on Homepage.");
		
		usercreation.clickOnNotRegisteredYet();
		child1.log(LogStatus.INFO, "Click On Not Registered Yet link on login form.");
		
		child1.log(LogStatus.PASS, "User is able to open User Registration form successfully.");
		
		logger.appendChild(child1);
		
		//
		//---------------------------------------------Check Create Your Account For Sign Up form-------------------------------------------------------
		//Check Create Your Account For Sign Up form with Name field blank
		//
		child2=report.startTest("Check Create Your Account For Sign Up form with Name field blank");
		
		usercreation.clickOnRegisterButton();
		child2.log(LogStatus.INFO, "Click On Register Button with keeping Name field blank.");
		
		String mandatoryName= usercreation.getValidationName();
		child2.log(LogStatus.INFO, "Getting validation error message from Name field.");
		
		child2.log(LogStatus.INFO, "Validating validation error message of Name field.");
		
		if(mandatoryName.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with keeping Name field blank.");
			child2.log(LogStatus.PASS, mandatoryName);
		}
		else
		{
			child2.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with keeping Name field blank.");
			child2.log(LogStatus.FAIL, mandatoryName);
		}
		
		logger.appendChild(child2);
		
		//
		//Check Create Your Account For Sign Up form with Username field blank
		//
		child3=report.startTest("Check Create Your Account For Sign Up form with Username field blank");
		
		name = (String) jsonObject.get("Name");
		
		usercreation.enterName(name);
		child3.log(LogStatus.INFO, "Enter name in Create Your Account For Sign Up form.");
		
		usercreation.clickOnRegisterButton();
		child3.log(LogStatus.INFO, "Click On Register Button with keeping User Name field blank.");
		
		String mandatoryUsername= usercreation.getValidationUserName();
		child3.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child3.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(mandatoryUsername.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with keeping User Name field blank.");
			child3.log(LogStatus.PASS, mandatoryUsername);
		}
		else
		{
			child3.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with keeping User Name field blank.");
			child3.log(LogStatus.FAIL, mandatoryUsername);
		}
		
		logger.appendChild(child3);
		
		//
		//Check Create Your Account For Sign Up form with entering Username field With input which doesn't start with Letter
		//
		child4=report.startTest("Check Create Your Account For Sign Up form with entering Username field With input which doesn't start with Letter");
		
		usernameNonLetter = (String) jsonObject.get("Username start with non-letter");
		
		usercreation.enterUserName(usernameNonLetter);
		child4.log(LogStatus.INFO, "Enter username which doesn't start with a letter.");
		
		usercreation.clickOnRegisterButton();
		child4.log(LogStatus.INFO, "Click On Register Button with entering Username field With input which doesn't start with Letter.");
		
		String nonLetterUsername= usercreation.getValidationUserName();
		child4.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child4.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(nonLetterUsername.contains("Must Start With A Letter"))
		{
			child4.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering Username field With input which doesn't start with Letter.");
			child4.log(LogStatus.PASS, nonLetterUsername);
		}
		else
		{
			child4.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering Username field With input which doesn't start with Letter.");
			child4.log(LogStatus.FAIL, nonLetterUsername);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Create Your Account For Sign Up form with entering non-Alphanumeric Username
		//
		child5=report.startTest("Check Create Your Account For Sign Up form with entering non-Alphanumeric Username");
		
		usernameNonAlphanumeric = (String) jsonObject.get("Username start with non-letter");
		
		usercreation.enterUserName(usernameNonAlphanumeric);
		child5.log(LogStatus.INFO, "Enter non-Alphanumeric Username.");
		
		usercreation.clickOnRegisterButton();
		child5.log(LogStatus.INFO, "Click On Register Button with keeping entering non-Alphanumeric Username.");
		
		String nonAlphanumericUsername= usercreation.getValidationUserName();
		child5.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child5.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(nonAlphanumericUsername.contains("Only Alphanumeric"))
		{
			child5.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering non-Alphanumeric Username.");
			child5.log(LogStatus.PASS, nonAlphanumericUsername);
		}
		else
		{
			child5.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering non-Alphanumeric Username.");
			child5.log(LogStatus.FAIL, nonAlphanumericUsername);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Create Your Account For Sign Up form with entering Username less than allowed
		//
		child6=report.startTest("Check Create Your Account For Sign Up form with entering Username less than allowed");
		
		usernameLess = (String) jsonObject.get("Username Less");
		
		usercreation.enterUserName(usernameLess);
		child6.log(LogStatus.INFO, "Enter charactes in username filed less than allowed.");
		
		usercreation.clickOnRegisterButton();
		child6.log(LogStatus.INFO, "Click On Register Button with entering charactes in username filed less than allowed.");
		
		String lessUsername= usercreation.getValidationUserName();
		child6.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child6.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(lessUsername.contains("Only Alphanumeric"))
		{
			child6.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering charactes in username filed less than allowed.");
			child6.log(LogStatus.PASS, lessUsername);
		}
		else
		{
			child6.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering charactes in username filed less than allowed.");
			child6.log(LogStatus.FAIL, lessUsername);
		}
		
		logger.appendChild(child6);
		
		//
		//Check Create Your Account For Sign Up form with entering Username more than allowed
		//
		child7=report.startTest("Check Create Your Account For Sign Up form with entering Username more than allowed");
		
		usernameMore = (String) jsonObject.get("Username More");
		
		usercreation.enterUserName(usernameMore);
		child7.log(LogStatus.INFO, "Enter charactes in username filed more than allowed.");
		
		usercreation.clickOnRegisterButton();
		child7.log(LogStatus.INFO, "Click On Register Button with entering charactes in username filed more than allowed.");
		
		String usernameMore= usercreation.getValidationUserName();
		child7.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child7.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(usernameMore.contains("Only Alphanumeric"))
		{
			child7.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering charactes in username filed more than allowed.");
			child7.log(LogStatus.PASS, usernameMore);
		}
		else
		{
			child7.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering charactes in username filed more than allowed.");
			child7.log(LogStatus.FAIL, usernameMore);
		}
		
		logger.appendChild(child7);
		
		//
		//Check Create Your Account For Sign Up form with entering already existing Username
		//
		child8=report.startTest("Check Create Your Account For Sign Up form with entering already existing Username");
		
		usernameDuplicate = (String) jsonObject.get("Username Duplicate");
		
		usercreation.enterUserName(usernameDuplicate);
		child8.log(LogStatus.INFO, "Enter duplicate username in Username field.");
		
		usercreation.clickOnRegisterButton();
		child8.log(LogStatus.INFO, "Click On Register Button with entering already existing Username.");
		
		String usernameduplicate= usercreation.getTopValidation();
		
		child8.log(LogStatus.INFO, "Getting validation error message from User Name field.");
		
		child8.log(LogStatus.INFO, "Validating validation error message of User Name field.");
		
		if(usernameduplicate.contains("Not Available"))
		{
			child8.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering already existing Username.");
			child8.log(LogStatus.PASS, usernameduplicate);
		}
		else
		{
			child8.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering already existing Username.");
			child8.log(LogStatus.FAIL, usernameduplicate);
		}
		
		logger.appendChild(child8);
		
		//
		//Check Create Your Account For Sign Up form with keeping Email field blank
		//
		child9=report.startTest("Check Create Your Account For Sign Up form with keeping Email field blank");
		
		usernameCorrect = (String) jsonObject.get("Username Correct");
		
		usercreation.enterUserName(usernameCorrect);
		child9.log(LogStatus.INFO, "Enter duplicate username in Username field.");
		
		usercreation.clickOnRegisterButton();
		child9.log(LogStatus.INFO, "Click On Register Button with keeping Email field blank.");
		
		String mandatoryEmail = usercreation.getValidationUserEmail();
		child9.log(LogStatus.INFO, "Getting validation error message from User Email field.");
		
		child9.log(LogStatus.INFO, "Validating validation error message of User Email field.");
		
		if(mandatoryEmail.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "User is getting correct validation error message when click On Register Button with keeping Email field blank.");
			child9.log(LogStatus.PASS, mandatoryEmail);
		}
		else
		{
			child9.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Register Button with keeping Email field blank.");
			child9.log(LogStatus.FAIL, mandatoryEmail);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Create Your Account For Sign Up form with entering invalid Email
		//
		child10=report.startTest("Check Create Your Account For Sign Up form with entering invalid Email");
		
		emailInvalid = (String) jsonObject.get("Email Invalid");
		
		usercreation.enterUserEmail(emailInvalid);
		child10.log(LogStatus.INFO, "Enter invalid email address in email field.");
		
		usercreation.clickOnRegisterButton();
		child10.log(LogStatus.INFO, "Click On Register Button with keeping Email field blank.");
		
		String invalidEmail = usercreation.getValidationUserEmail();
		child10.log(LogStatus.INFO, "Getting validation error message from User Email field.");
		
		child10.log(LogStatus.INFO, "Validating validation error message of User Email field.");
		
		if(invalidEmail.contains("Valid Email"))
		{
			child10.log(LogStatus.PASS, "User is getting correct validation error message when click On Register Button with entering invalid Email.");
			child10.log(LogStatus.PASS, invalidEmail);
		}
		else
		{
			child10.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Register Button with entering invalid Email.");
			child10.log(LogStatus.FAIL, invalidEmail);
		}
		
		logger.appendChild(child10);
		
		//
		//Check Create Your Account For Sign Up form with entering Already existing Email
		//
		child11=report.startTest("Check Create Your Account For Sign Up form with entering Already existing Email");
		
		emailDuplicate = (String) jsonObject.get("Email Duplicate");
		
		usercreation.enterUserEmail(emailDuplicate);
		child11.log(LogStatus.INFO, "Enter already existing email address in email field.");
		
		usercreation.clickOnRegisterButton();
		child11.log(LogStatus.INFO, "Click On Register Button with entering already existing Email.");
		
		String emailduplicate= usercreation.getTopValidation();
		
		child11.log(LogStatus.INFO, "Getting validation error message from Email field.");
		
		child11.log(LogStatus.INFO, "Validating validation error message of Email field.");
		
		if(emailduplicate.contains("Not Available"))
		{
			child11.log(LogStatus.PASS, "User is getting correct validation error message when Click On Register Button with entering Already existing Email.");
			child11.log(LogStatus.PASS, emailduplicate);
		}
		else
		{
			child11.log(LogStatus.FAIL, "User is not getting correct validation error message when Click On Register Button with entering Already existing Email.");
			child11.log(LogStatus.FAIL, emailduplicate);
		}
		
		logger.appendChild(child11);
		
		//
		//Check Create Your Account For Sign Up form with keeping Password field Blank
		//
		child12=report.startTest("Check Create Your Account For Sign Up form with keeping Password field Blank");
		
		emailCorrect = (String) jsonObject.get("Email Correct");
		
		usercreation.enterUserEmail(emailCorrect);
		child12.log(LogStatus.INFO, "Enter correct email address in email field.");
		
		usercreation.clickOnRegisterButton();
		child12.log(LogStatus.INFO, "Click On Register Button with keeping Password field Blank.");
		
		String passwordMandatory = usercreation.getValidationPassword();		
		child12.log(LogStatus.INFO, "Getting validation error message from Password field.");
		
		child12.log(LogStatus.INFO, "Validating validation error message of Password field.");
		
		if(passwordMandatory.contains("Alphanumeric"))
		{
			child12.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with keeping Password field Blank.");
			child12.log(LogStatus.PASS, passwordMandatory);
		}
		else
		{
			child12.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with keeping Password field Blank.");
			child12.log(LogStatus.FAIL, passwordMandatory);
		}
		
		logger.appendChild(child12);
		
		//
		//Check Create Your Account For Sign Up form with entering Password non-Alphanumeric
		//
		child13=report.startTest("Check Create Your Account For Sign Up form with entering Password non-Alphanumeric");
		
		passwordNonAlphanumeric = (String) jsonObject.get("Password non-Alphanumeric");
		
		usercreation.enterPassword(passwordNonAlphanumeric);
		child13.log(LogStatus.INFO, "Enter Non Alphanumeric password in Password field.");
		
		usercreation.clickOnRegisterButton();
		child13.log(LogStatus.INFO, "Click On Register Button with entering Password non-Alphanumeric.");
		
		String passwordnonAlphanumeric = usercreation.getValidationPassword();		
		child13.log(LogStatus.INFO, "Getting validation error message from Password field.");
		
		child13.log(LogStatus.INFO, "Validating validation error message of Password field.");
		
		if(passwordnonAlphanumeric.contains("Alphanumeric"))
		{
			child13.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with entering Password non-Alphanumeric.");
			child13.log(LogStatus.PASS, passwordnonAlphanumeric);
		}
		else
		{
			child13.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with entering Password non-Alphanumeric.");
			child13.log(LogStatus.FAIL, passwordnonAlphanumeric);
		}
		
		logger.appendChild(child13);
		
		//
		//Check Create Your Account For Sign Up form with entering Password less than Allowed
		//
		child14=report.startTest("Check Create Your Account For Sign Up form with entering Password less than Allowed");
		
		passwordLess = (String) jsonObject.get("Password Less than Allowed");
		
		usercreation.enterPassword(passwordLess);
		child14.log(LogStatus.INFO, "Enter password less than Allowed in Password field.");
		
		usercreation.clickOnRegisterButton();
		child14.log(LogStatus.INFO, "Click On Register Button with entering Password less than Allowed.");
		
		String passwordless = usercreation.getValidationPassword();		
		child14.log(LogStatus.INFO, "Getting validation error message from Password field.");
		
		child14.log(LogStatus.INFO, "Validating validation error message of Password field.");
		
		if(passwordless.contains("Characters"))
		{
			child14.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with entering Password less than Allowed.");
			child14.log(LogStatus.PASS, passwordless);
		}
		else
		{
			child14.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with entering Password less than Allowed.");
			child14.log(LogStatus.FAIL, passwordless);
		}
		
		logger.appendChild(child14);
		
		//
		//Check Create Your Account For Sign Up form with keeping Confirm Password Blank
		//
		child15=report.startTest("Check Create Your Account For Sign Up form with keeping Confirm Password Blank");
		
		passwordCorrect = (String) jsonObject.get("Password Correct");
		
		usercreation.enterPassword(passwordCorrect);
		child15.log(LogStatus.INFO, "Enter correct password in Password field.");
		
		usercreation.clickOnRegisterButton();
		child15.log(LogStatus.INFO, "Click On Register Button with entering correct Password.");
		
		String mandatoryConfirmPassword = usercreation.getValidationConfirmPassword();
		child15.log(LogStatus.INFO, "Getting validation error message from Confirm Password field.");
		
		child15.log(LogStatus.INFO, "Validating validation error message of Confirm Password field.");
		
		if(mandatoryConfirmPassword.contains("Mandatory")) 
		{
			child15.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with keeping Confirm Password Blank.");
			child15.log(LogStatus.PASS, mandatoryConfirmPassword);
		}
		else
		{
			child15.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with keeping Confirm Password Blank.");
			child15.log(LogStatus.FAIL, mandatoryConfirmPassword);
		}
		
		logger.appendChild(child15);
		
		//
		//Check Create Your Account For Sign Up form with keeping entering Confirm Password different than Password
		//
		child16=report.startTest("Check Create Your Account For Sign Up form with keeping entering Confirm Password different than Password");
		
		confirmPasswordDifferent = (String) jsonObject.get("Confirm Password Differnt");
		
		usercreation.enterConfirmPassword(confirmPasswordDifferent);
		child16.log(LogStatus.INFO, "Enter Confirm Password different than Password.");
		
		usercreation.clickOnRegisterButton();
		child16.log(LogStatus.INFO, "Click On Register Button with entering Confirm Password different than Password.");
		
		String differentConfirmPassword = usercreation.getValidationConfirmPassword();
		child16.log(LogStatus.INFO, "Getting validation error message from Confirm Password field.");
		
		child16.log(LogStatus.INFO, "Validating validation error message of Confirm Password field.");
		
		if(differentConfirmPassword.contains("Same")) 
		{
			child16.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with entering Confirm Password different than Password.");
			child16.log(LogStatus.PASS, differentConfirmPassword);
		}
		else
		{
			child16.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with entering Confirm Password different than Password.");
			child16.log(LogStatus.FAIL, differentConfirmPassword);
		}
		
		logger.appendChild(child16);
		
		//
		//Check Create Your Account For Sign Up form with keeping Terms & Conditions Non-Accepted 
		//
		child17=report.startTest("Check Create Your Account For Sign Up form with keeping Terms & Conditions Non-Accepted");
		
		usercreation.enterConfirmPassword(passwordCorrect);		
		child17.log(LogStatus.INFO, "Enter same password in Confirm Password field.");
		
		usercreation.clickOnRegisterButton();
		child17.log(LogStatus.INFO, "Click On Register Button with keeping Terms & Conditions Non-Accepted.");
		
		String mandatoryTerms = usercreation.getValidationTerms();
		child17.log(LogStatus.INFO, "Getting validation error message from Terms & Conditions field.");
		
		child17.log(LogStatus.INFO, "Validating validation error message of Terms & Conditions field.");
		
		if(mandatoryTerms.contains("Acceptance"))
		{
			child17.log(LogStatus.PASS, "User is getting correct Validation error message when click On Register Button with keeping Terms & Conditions Non-Accepted.");
			child17.log(LogStatus.PASS, differentConfirmPassword);
		}
		else
		{
			child17.log(LogStatus.FAIL, "User is not getting correct Validation error message when click On Register Button with keeping Terms & Conditions Non-Accepted.");
			child17.log(LogStatus.FAIL, differentConfirmPassword);
		}
		
		logger.appendChild(child17);
		
		//
		//Check Create Your Account For Sign Up form with accepting Terms & Conditions
		//
		child18=report.startTest("Check Create Your Account For Sign Up form with accepting Terms & Conditions");
		
		usercreation.clickOnAgree();
		child18.log(LogStatus.INFO, "Click on Terms & Conditions checkbox of Create Your Account For Sign Up form.");
		
		usercreation.clickOnRegisterButton();
		child18.log(LogStatus.INFO, "Click On Register Button with Accepted Terms & Conditions.");
		
		String headerContent = usercreation.getContentofHeaderLoggedIn();
		child18.log(LogStatus.INFO, "Getting Header of Logged in user.");
		
		child18.log(LogStatus.INFO, "Validating Header of Logged in user.");
		
		if(headerContent.contains("Congratulations")) 
		{
			
			child18.log(LogStatus.PASS, "User is able to Sign-Up as User successfully.");
			child18.log(LogStatus.PASS, headerContent);
		}
		else
		{
			child18.log(LogStatus.FAIL, "User is not able to Sign-Up as User successfully.");
			child18.log(LogStatus.FAIL, headerContent);
		}
		
		logger.appendChild(child18);
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		//
		// If test is getting failed then take the screen shot and put it in Automation Report.
		//
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "User is Not able to Register.");
			logger.log(LogStatus.FAIL, "User_ Registration_Failed", image);
		}
		//
		// End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
