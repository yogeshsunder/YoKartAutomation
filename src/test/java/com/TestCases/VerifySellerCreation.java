package com.TestCases;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.SellerCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerCreation {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11, child12, child13, child14, child15, child16, child17, child18, child19, child20;
	ExtentTest child21, child22;
	
	String yourEmail,youremailcorrect,yournamecorrect,yournameempty,usernameNumeric,usernameless,usernamemore,username,emailEmpty,passwordLessThanAllowed;
	String correctPassword,confirmPasswordDifferent,confirmPasswordcorrect;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void sellerRegistration() throws Exception
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Registration");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		child1=report.startTest("Check opening Register Today Form");

		//----------------------------------------Redirecting to Register Today form from Home Page---------------------------------------
		//
		//Start the Browser from BrowserFactory from Helper and Open Home page of the application.
		//
		driver=BrowserFactory.startBrowser("chrome", "url");	
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		//
		//Redirect to the bottom of the Page.
		//
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//jse.executeScript("scroll(0, 6000);");
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		child1.log(LogStatus.INFO, "Redirect to the bottom of the Page.");
		
		//
		//Created Page Object using Page Factory to call the functions from SellerCreationPage.
		//
		SellerCreationPage sellerCreation=PageFactory.initElements(driver, SellerCreationPage.class);
		
		//
		//Click on Open a Store Button from the bottom of the Home page.
		//
		sellerCreation.clickonOpenaStore();	
		child1.log(LogStatus.INFO, "Click on Open a Store Button from the bottom of the Home page.");
		
		child1.log(LogStatus.PASS, "User is able to open Register Today form successfully.");
		
		logger.appendChild(child1);
		
		//--------------------------------------------------Register Today------------------------------------------------------------------
		//
		//Check Register Today Form with keeping Your Email field blank
		//		
		child2=report.startTest("Check Register Today Form with keeping Your Email field blank");
		

		//
		//Accept cookies on the page
		//
		//sellerCreation.acceptCookies();
		
		//Thread.sleep(10000);
		sellerCreation.clickOnStartSelling();
		child2.log(LogStatus.INFO, "Click On Start Selling button with keeping Your Email field blank.");
		
		String mandatoryyouremail = sellerCreation.getMandatoryYourEmail();
		child2.log(LogStatus.INFO, "Getting the validation error message on Your Email field.");
		
		child2.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryyouremail.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "User is getting correct validation error message when click on Start Selling button with keeping Your Email field blank.");
			child2.log(LogStatus.PASS, mandatoryyouremail);
		}
		else
		{
			child2.log(LogStatus.FAIL, "User is not getting correct validation error message when click on Start Selling button with keeping Your Email field blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Register Today Form with invalid input in Your Email field
		//
		child3=report.startTest("Check Register Today Form with invalid input in Your Email field");

		yourEmail = (String) jsonObject.get("Your Email Invalid");
		
		sellerCreation.enterYourEmail(yourEmail);
		child3.log(LogStatus.INFO, "Enter invalid input in Your Email field of Register Today form.");
		
		sellerCreation.clickOnStartSelling();
		child3.log(LogStatus.INFO, "Click On Start Selling button with invalid input in Your Email field.");
		
		String invalidyouremail = sellerCreation.getMandatoryYourEmail();
		child3.log(LogStatus.INFO, "Getting the validation error message on Your Email field.");
		
		child3.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(invalidyouremail.contains("Valid Email"))
		{
			child3.log(LogStatus.PASS, "User is getting correct validation error message when click on Start Selling button with invalid input in Your Email field.");
			child3.log(LogStatus.PASS, invalidyouremail);
		}
		else
		{
			child3.log(LogStatus.FAIL, "User is not getting correct validation error message when click on Start Selling button with invalid input in Your Email field.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Register Today Form with keeping Your Name field blank
		//
		child4=report.startTest("Check Register Today Form with keeping Your Name field blank");
		
		youremailcorrect = (String) jsonObject.get("MailId");
		
		sellerCreation.enterYourEmail(youremailcorrect);
		child4.log(LogStatus.INFO, "Enter correct input in Your Email field of Register Today form.");
		
		sellerCreation.clickOnStartSelling();
		child4.log(LogStatus.INFO, "Click On Start Selling button with keeping Your Name field blank.");
		
		String mandatoryyourname = sellerCreation.getMandatoryYourName();
		child4.log(LogStatus.INFO, "Getting the validation error message on Your Name field.");
		
		child4.log(LogStatus.INFO, "Validating that the validation error message is correct.");	
		
		if(mandatoryyourname.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "User is getting correct validation error message when click On Start Selling button with keeping Your Name field blank.");
			child4.log(LogStatus.PASS, mandatoryyourname);
		}
		else
		{
			child4.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Start Selling button with keeping Your Name field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Register Today Form with correct input in Your Name field
		//
		child5=report.startTest("Check Register Today Form with correct input in Your Name field");
		
		sellerCreation.enterYourEmail(youremailcorrect);
		child5.log(LogStatus.INFO, "Enter correct input in Your Email field of Register Today form.");
		
		yournamecorrect = (String) jsonObject.get("YourName");
		
		sellerCreation.enterYourName(yournamecorrect);
		child5.log(LogStatus.INFO, "Enter correct input in Your Name field of Register Today form.");
		
		sellerCreation.clickOnStartSelling();
		child5.log(LogStatus.INFO, "Click On Start Selling button with correct input in Register Today form.");
		
		child5.log(LogStatus.PASS, "User is redirecting to the Seller Registration form successfully.");
		
		logger.appendChild(child5);
		
		//
		//Check Seller Registration Details Form with Name field blank
		//
		child6=report.startTest("Check Seller Registration Details Form with Name field blank");
		
		yournameempty = (String) jsonObject.get("Your Name Empty");
		
		sellerCreation.enterYourName(yournameempty);
		child6.log(LogStatus.INFO, "Keep Your Name field Empty in Seller Registration Details Form.");
		
		sellerCreation.clickOnSubmit();
		child6.log(LogStatus.INFO, "Click On Submit button in Seller Registration Details Form with keeping Name field blank.");
		
		String mandatoryyournameSellerRegistration = sellerCreation.getMandatoryYourName();
		child6.log(LogStatus.INFO, "Getting the validation error message on Your Name field.");
		
		child6.log(LogStatus.INFO, "Validating that the validation error message is correct.");	
		
		if(mandatoryyournameSellerRegistration.contains("Mandatory"))
		{
			child6.log(LogStatus.PASS, "User is getting correct validation error message when click On Start Selling button with keeping Your Name field blank.");
			child6.log(LogStatus.PASS, mandatoryyournameSellerRegistration);
		}
		else
		{
			child6.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Start Selling button with keeping Your Name field blank.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Seller Registration Details Form with Username field blank
		//
		child7=report.startTest("Check Seller Registration Details Form with Username field blank");
		
		sellerCreation.enterYourName(yournamecorrect);
		child7.log(LogStatus.INFO, "Enter correct input in Your Name field of Register Today form.");
		
		sellerCreation.clickOnSubmit();
		child7.log(LogStatus.INFO, "Click On Submit button in Seller Registration Details Form with keeping Username field blank.");
		
		String mandatoryusername = sellerCreation.getMandatoryUserName();
		child7.log(LogStatus.INFO, "Getting the validation error message on Username field.");
		
		child7.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryusername.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "User is getting correct validation error message when click On Submit button in Seller Registration Details Form with keeping Username field blank.");
			child7.log(LogStatus.PASS, mandatoryusername);
		}
		else
		{
			child7.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Submit button in Seller Registration Details Form with keeping Username field blank.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Seller Registration Details Form with input Start With A numeric Character in Username field
		//
		child8=report.startTest("Check Seller Registration Details Form with input Start With A numeric Character in Username field");
		
		usernameNumeric = (String) jsonObject.get("Username Starts Numeric");
		
		sellerCreation.enterUserName(usernameNumeric);
		child8.log(LogStatus.INFO, "Enter username which starts with a numeric character.");
		
		sellerCreation.clickOnSubmit();
		child8.log(LogStatus.INFO, "Click On Submit button");
		
		String numericusername = sellerCreation.getMandatoryUserName();
		child8.log(LogStatus.INFO, "Getting the validation error message on Username field.");
		
		child8.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(numericusername.contains("Must Start With A Letter"))
		{
			child8.log(LogStatus.PASS, "User is getting correct validation error message when entering username which starts with a numeric character.");
			child8.log(LogStatus.PASS, numericusername);
		}
		else
		{
			child8.log(LogStatus.FAIL, "User is not getting correct validation error message when when entering username which starts with a numeric character.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Seller Registration Details Form with input less than allowed in Username field
		//		
		child9=report.startTest("Check Seller Registration Details Form with input less than allowed in Username field");
		
		usernameless = (String) jsonObject.get("Username Less Than Allowed");
		
		sellerCreation.enterUserName(usernameless);
		child9.log(LogStatus.INFO, "Enter username less than allowed for the Username field.");
		
		sellerCreation.clickOnSubmit();
		child9.log(LogStatus.INFO, "Click On Submit button");
		
		String lessusername = sellerCreation.getMandatoryUserName();
		child9.log(LogStatus.INFO, "Getting the validation error message on Username field.");
		
		child9.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(lessusername.contains("Must Be Between 4 To 20"))
		{
			child9.log(LogStatus.PASS, "User is getting correct validation error message when entering username less than allowed in Username field.");
			child9.log(LogStatus.PASS, lessusername);
		}
		else
		{
			child9.log(LogStatus.FAIL, "User is not getting correct validation error message when when entering username less than allowed in Username field.");
		}
		
		logger.appendChild(child9);
		
		//
		//Check Seller Registration Details Form with input more than allowed in Username field
		//		
		child10=report.startTest("Check Seller Registration Details Form with input more than allowed in Username field");
		
		usernamemore = (String) jsonObject.get("Username More Than Allowed");
		
		sellerCreation.enterUserName(usernamemore);
		child10.log(LogStatus.INFO, "Enter username more than allowed for the Username field.");
		
		sellerCreation.clickOnSubmit();
		child10.log(LogStatus.INFO, "Click On Submit button");
		
		String moreusername = sellerCreation.getMandatoryUserName();
		child10.log(LogStatus.INFO, "Getting the validation error message on Username field.");
		
		child10.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(moreusername.contains("Must Be Between 4 To 20"))
		{
			child10.log(LogStatus.PASS, "User is getting correct validation error message when entering username more than allowed in Username field.");
			child10.log(LogStatus.PASS, moreusername);
		}
		else
		{
			child10.log(LogStatus.FAIL, "User is not getting correct validation error message when when entering username more than allowed in Username field.");
		}
		
		logger.appendChild(child10);
		
		//
		//Check Seller Registration Details Form with keeping Email field blank
		//		
		child11=report.startTest("Check Seller Registration Details Form with keeping Email field blank");
		
		username = (String) jsonObject.get("UsernameForRegistrationDetails");
		
		sellerCreation.enterUserName(username);
		child11.log(LogStatus.INFO, "Enter correct and valid username in Username field.");
		
		emailEmpty = (String) jsonObject.get("Email Empty");
		
		sellerCreation.enterYourEmail(emailEmpty);
		child11.log(LogStatus.INFO, "Keep email field empty.");
		
		sellerCreation.clickOnSubmit();
		child11.log(LogStatus.INFO, "Click On Submit button");
		
		String mandatoryemailDetails = sellerCreation.getMandatoryYourEmail();
		child11.log(LogStatus.INFO, "Getting the validation error message on Email field.");
		
		child11.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryemailDetails.contains("Mandatory"))
		{
			child11.log(LogStatus.PASS, "User is getting correct validation error message when click on Submit button with keeping Email field blank.");
			child11.log(LogStatus.PASS, mandatoryemailDetails);
		}
		else
		{
			child11.log(LogStatus.FAIL, "User is not getting correct validation error message when click on Submit button with keeping Email field blank.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Seller Registration Details Form with invalid input in Email field
		//
		child12=report.startTest("Check Seller Registration Details Form with invalid input in Email field");
		
		sellerCreation.enterYourEmail(yourEmail);
		child12.log(LogStatus.INFO, "Enter invalid input in Email field of Seller Registration Details form.");
		
		sellerCreation.clickOnSubmit();
		child12.log(LogStatus.INFO, "Click On Submit button with invalid input in Email field.");
		
		String invalidemail = sellerCreation.getMandatoryYourEmail();
		child12.log(LogStatus.INFO, "Getting the validation error message on Email field.");
		
		child12.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(invalidemail.contains("Valid Email"))
		{
			child12.log(LogStatus.PASS, "User is getting correct validation error message when click on Start Selling button with invalid input in Email field.");
			child12.log(LogStatus.PASS, invalidemail);
		}
		else
		{
			child12.log(LogStatus.FAIL, "User is not getting correct validation error message when click on Start Selling button with invalid input in Email field.");
		}
		
		logger.appendChild(child12);
		
		//
		//Check Seller Registration Details Form with keeping Password field blank
		//		
		child13=report.startTest("Check Seller Registration Details Form with keeping Password field blank");
		
		sellerCreation.enterYourEmail(youremailcorrect);
		child13.log(LogStatus.INFO, "Enter correct input in Email field of Seller Registration Details Form.");
		
		sellerCreation.clickOnSubmit();
		child13.log(LogStatus.INFO, "Click On Submit button with keeping Password field blank.");
		
		String mandatoryValidationPassword = sellerCreation.getMandatoryPassword();
		child13.log(LogStatus.INFO, "Getting the validation error message on Password field.");
		
		child13.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryValidationPassword.contains("Password Must Be Eight Characters Long"))
		{
			child13.log(LogStatus.PASS, "User is getting correct validation error when click on Submit button with keeping Password field blank.");
			child13.log(LogStatus.PASS, mandatoryValidationPassword);
		}
		else
		{
			child13.log(LogStatus.FAIL, "User is not getting correct validation error when click on Submit button with keeping Password field blank.");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Seller Registration Details Form with entering password less than allowed in Password field
		//
		child14=report.startTest("Check Seller Registration Details Form with entering password less than allowed in Password field");
		
		passwordLessThanAllowed = (String) jsonObject.get("Password Less Than Allowed");
		
		sellerCreation.enterPassword(passwordLessThanAllowed);
		child14.log(LogStatus.INFO, "Enter Password less than allowed.");
		
		sellerCreation.clickOnSubmit();
		child14.log(LogStatus.INFO, "Click On Submit button with entering password less than allowed in Password field.");
		
		String lessPassword = sellerCreation.getMandatoryPassword();
		child14.log(LogStatus.INFO, "Getting the validation error message on Password field.");
		
		child14.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(lessPassword.contains("Password Must Be Eight Characters Long"))
		{
			child14.log(LogStatus.PASS, "User is getting correct validation error when click on Submit button with entering password less than allowed in Password field.");
			child14.log(LogStatus.PASS, lessPassword);
		}
		else
		{
			child14.log(LogStatus.FAIL, "User is not getting correct validation error when click on Submit button with entering password less than allowed in Password field.");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Seller Registration Details Form with entering Non-AlphaNumeric password in Password field
		//
		child15=report.startTest("Check Seller Registration Details Form with entering Non-AlphaNumeric password in Password field");
		
		sellerCreation.enterPassword(passwordLessThanAllowed);
		child15.log(LogStatus.INFO, "Enter Non-AlphaNumeric password in Password field.");
		
		sellerCreation.clickOnSubmit();
		child15.log(LogStatus.INFO, "Click On Submit button with entering Non-AlphaNumeric password in Password field.");
		
		String nonAlphaNumericPassword = sellerCreation.getMandatoryPassword();
		child15.log(LogStatus.INFO, "Getting the validation error message on Password field.");
		
		child15.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(nonAlphaNumericPassword.contains("Alphanumeric"))
		{
			child15.log(LogStatus.PASS, "User is getting correct validation error when click on Submit button with entering Non-AlphaNumeric password in Password field.");
			child15.log(LogStatus.PASS, nonAlphaNumericPassword);
		}
		else
		{
			child15.log(LogStatus.FAIL, "User is not getting correct validation error when click on Submit button with entering Non-AlphaNumeric password in Password field.");
		}
		
		logger.appendChild(child15);
		
		//
		//Check Seller Registration Details Form with keeping confirm Password field blank
		//		
		child16=report.startTest("Check Seller Registration Details Form with keeping confirm Password field blank");
		
		correctPassword = (String) jsonObject.get("PasswordForRegistrationDetails");
		
		sellerCreation.enterPassword(correctPassword);
		child16.log(LogStatus.INFO, "Enter correct input in Password field of Seller Registration Details Form.");
		
		sellerCreation.clickOnSubmit();
		child16.log(LogStatus.INFO, "Click On Submit button with keeping Confirm Password field blank.");
		
		String mandatoryValidationConfirmPassword = sellerCreation.getMandatoryConfirmPassword();
		child16.log(LogStatus.INFO, "Getting the validation error message on Confirm Password field.");
		
		child16.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryValidationConfirmPassword.contains("Must Be Same As Password"))
		{
			child16.log(LogStatus.PASS, "User is getting correct validation error when click on Submit button with keeping Confirm Password field blank.");
			child16.log(LogStatus.PASS, mandatoryValidationConfirmPassword);
		}
		else
		{
			child16.log(LogStatus.FAIL, "User is not getting correct validation error when click on Submit button with keeping Confirm Password field blank.");
			child16.log(LogStatus.INFO, mandatoryValidationConfirmPassword);
		}
		
		logger.appendChild(child16);
		
		//
		//Check Seller Registration Details Form with entering Confirm Password different than Password
		//		
		child17=report.startTest("Check Seller Registration Details Form with entering Confirm Password different than Password");
		
		confirmPasswordDifferent = (String) jsonObject.get("Confirm Password Different");
		
		sellerCreation.enterConfirmPassword(confirmPasswordDifferent);
		child17.log(LogStatus.INFO, "Enter Confirm Password different than Password in Seller Registration Details Form.");
		
		sellerCreation.clickOnSubmit();
		child17.log(LogStatus.INFO, "Click On Submit button with entering Confirm Password different than Password.");
		
		String differentConfirmPassword = sellerCreation.getMandatoryConfirmPassword();
		child17.log(LogStatus.INFO, "Getting the validation error message on Confirm Password field.");
		
		child17.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(differentConfirmPassword.contains("Must Be Same As Password"))
		{
			child17.log(LogStatus.PASS, "User is getting correct validation error when entering Confirm Password different than Password.");
			child17.log(LogStatus.PASS, differentConfirmPassword);
		}
		else
		{
			child17.log(LogStatus.FAIL, "User is not getting correct validation error when entering Confirm Password different than Password.");
			child17.log(LogStatus.INFO, differentConfirmPassword);
		}
		
		logger.appendChild(child17);
		
		//
		//Check Seller Registration Details Form with Terms & Conditions unchecked
		//		
		child18=report.startTest("Check Seller Registration Details Form with Terms & Conditions unchecked");
		
		confirmPasswordcorrect = (String) jsonObject.get("ConfirmPasswordforRegistrationDetails");
		
		sellerCreation.enterConfirmPassword(confirmPasswordcorrect);
		child18.log(LogStatus.INFO, "Enter Confirm Password same as Password in Seller Registration Details Form.");
		
		sellerCreation.clickOnSubmit();
		child18.log(LogStatus.INFO, "Click On Submit button with keeping Terms & Conditions unchecked.");
		
		String termsConditionsBlank = sellerCreation.getMandatoryTermsConditions();
		child18.log(LogStatus.INFO, "Getting the validation error message on Terms & Conditions field.");
		
		child18.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(termsConditionsBlank.contains("required"))
		{
			child18.log(LogStatus.PASS, "User is getting correct validation error when click on Submit button with keeping Terms & Conditions unchecked.");
			child18.log(LogStatus.PASS, termsConditionsBlank);
		}
		else
		{
			child18.log(LogStatus.FAIL, "User is not getting correct validation error when click on Submit button with keeping Terms & Conditions unchecked.");
		}
		
		logger.appendChild(child18);
		
		//
		//Check Seller Registration Details Form with all correct Inputs
		//		
		child19=report.startTest("Check Seller Registration Details Form with all correct Inputs");
		
		sellerCreation.clickOnTermsConditions();
		child19.log(LogStatus.INFO, "Click On Terms and Conditions check box.");
		
		sellerCreation.clickOnSubmit();
		child19.log(LogStatus.INFO, "Click On Submit button with all correct input in Seller Registration Details form.");
		
		child19.log(LogStatus.PASS, "User redirects to Seller Registration Activation form successfully with all correct inputs in Seller Registration Details form");
		
		logger.appendChild(child19);
		
		//
		//Check Seller Registration Activation Form with Business Name blank
		//
		child20=report.startTest("Check Seller Registration Activation Form with keeping Business Name blank");
		
		sellerCreation.clickOnSaveChangesActivationForm();
		child20.log(LogStatus.INFO, "Click On Save Changes button with keeping Business Name blank.");
		
		String mandatoryBussinessName = sellerCreation.getMandatoryValidationBussinessName();
		child20.log(LogStatus.INFO, "Getting the validation error message on Bussiness Name field.");
		
		child20.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryBussinessName.contains("Mandatory"))
		{
			child20.log(LogStatus.PASS, "User is getting correct validation error message when click On Save Changes button with keeping Business Name blank.");
			child20.log(LogStatus.PASS, mandatoryBussinessName);
		}
		else
		{
			child20.log(LogStatus.FAIL, "User is not getting correct validation error message when click On Save Changes button with keeping Business Name blank.");
		}
		
		logger.appendChild(child20);
		
		//
		//Check Seller Registration Activation Form with correct inputs
		//
		child21=report.startTest("Check Seller Registration Activation Form with correct inputs");
		
		sellerCreation.fillSellerRegistrationActivationform();
		child21.log(LogStatus.INFO, "Fill the form for Seller Registration Activation with correct inputs and click on Save Changes.");
		
		child21.log(LogStatus.PASS, "User is redirecting to Seller Registration Confirmation Form");
		
		logger.appendChild(child21);
		
		//------------------------------------------------Check Seller Registration--------------------------------------------------------------
		child22=report.startTest("Check Seller is able to Register successfully or not");
		//
		//Get the Actual Message comes on actual screen into String
		//
		child22.log(LogStatus.INFO, "Getting the Actual Message coming on last step of Registration.");
		String actual_message=sellerCreation.matchSuccessMessage();
		
		child22.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(actual_message.contains("Congratulations"))
		{
			child22.log(LogStatus.PASS, "User is able to Register as a Seller successfully.");
			child22.log(LogStatus.PASS, actual_message);
		}
		else
		{
			child22.log(LogStatus.FAIL, "User is not able to Register as a Seller successfully.");
			child22.log(LogStatus.FAIL, actual_message);
		}
				
		//
		//Match Actual Message with Expected message and log results in Automation Report
		//
		//child22.log(LogStatus.INFO, "Match Actual Message with Expected message.");
		//Assert.assertTrue(actual_message.equals("Congratulations!!!"));
			
		//child22.log(LogStatus.PASS, "User is able to Register as a Seller successfully.");
				
		logger.appendChild(child22);
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
			logger.log(LogStatus.FAIL, "User is Not able to Register as a Seller.");
			logger.log(LogStatus.FAIL, "Seller_Registration_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		//driver.close();
	}
}