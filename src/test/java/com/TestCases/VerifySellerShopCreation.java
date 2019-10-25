package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerShopCreation {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	
	String seofriendlyURLempty,seofriendlyURL,countryvalue,countryvalueselect,statevalue,nameReturn,cityReturn,address1Return;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifySellerShopCreation() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Shop Creation");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject= (JSONObject) obj;
		
		//--------------------------------------------------General Shop Setup form.-------------------------------------------------------
		
		child1=report.startTest("Check opening General Shop Setup form");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		//SellerLoginPage sellerlogin=PageFactory.initElements(driver, SellerLoginPage.class);
		SellerShopCreationPage sellershopcreation=PageFactory.initElements(driver, SellerShopCreationPage.class);
		
		//
		//Seller is trying to login
		//
		sellershopcreation.sellerLogin();
		//sellerlogin.sellerLogin();
		child1.log(LogStatus.PASS, "Seller is able to login successfully.");
		
		//
		//Seller go to Dashboard
		//
		sellershopcreation.gotoDashboard();
		child1.log(LogStatus.INFO, "Seller is able to go to Dashboard.");
		
		//
		//click On Create Shop Button
		//
		sellershopcreation.clickOnCreateShopButton();
		child1.log(LogStatus.INFO, "Seller is able to click On Create Shop Button.");
		
		child1.log(LogStatus.PASS, "Seller is able to open Shop Setup form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Shop Setup GENERAL Form with keeping Identifier field blank
		//
		child2=report.startTest("Check Shop Setup GENERAL Form with keeping Identifier field blank");
		
		sellershopcreation.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click on Save Changes button with keeping Identifier field blank.");
		
		String mandatoryIdentifier = sellershopcreation.getMandatoryIdentifier();
		child2.log(LogStatus.INFO, "Getting the validation error message of Identifier field.");
		
		child2.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with keeping Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save Changes button with keeping Identifier field blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Shop Setup GENERAL Form with keeping Shop SEO Friendly URL field blank
		//
		child3=report.startTest("Check Shop Setup GENERAL Form with keeping Shop SEO Friendly URL field blank");
		
		String uuid = UUID.randomUUID().toString();
		
		sellershopcreation.enterIdentifierGeneral(uuid);
		child3.log(LogStatus.INFO, "Enter Identifier in Shop Setup General form");
		
		seofriendlyURLempty = (String) jsonObject.get("Shop SEO Friendly URL Empty");
		
		sellershopcreation.enterShopSEOFriendlyURL(seofriendlyURLempty);
		child3.log(LogStatus.INFO, "Keep Shop SEO Friendly URL field blank.");
		
		sellershopcreation.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click on Save Changes button with keeping Identifier field blank.");
		
		String mandatoryShopSEOFriendlyURL = sellershopcreation.getMandatorySEOFriendlyURL();
		child3.log(LogStatus.INFO, "Getting the validation error message of Shop SEO Friendly URL field.");
		
		child3.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryShopSEOFriendlyURL.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with keeping Shop SEO Friendly URL field blank.");
			child3.log(LogStatus.PASS, mandatoryShopSEOFriendlyURL);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save Changes button with keeping Shop SEO Friendly URL field blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Shop Setup GENERAL Form with keeping State field blank
		//
		child4=report.startTest("Check Shop Setup GENERAL Form with keeping State field blank");
		
		seofriendlyURL = (String) jsonObject.get("Shop SEO Friendly URL");
		
		sellershopcreation.enterShopSEOFriendlyURL(seofriendlyURL);		
		child4.log(LogStatus.INFO, "Enter Shop SEO Friendly URL in Shop Setup General form.");
		
		sellershopcreation.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click on Save Changes button with keeping State field blank.");
		
		String mandatoryState = sellershopcreation.getMandatoryState();
		child4.log(LogStatus.INFO, "Getting the validation error message of State field.");
		
		child4.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryState.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with keeping State field blank.");
			child4.log(LogStatus.PASS, mandatoryState);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save Changes button with keeping State field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Shop Setup ENGLISH Form with all correct inputs in all fields
		//
		child5=report.startTest("Check Shop Setup ENGLISH Form with all correct inputs in all fields");
		
		sellershopcreation.fillGeneralShopSetupform();
		child5.log(LogStatus.INFO, "Fill General Shop Setup form with all correct inputs in all fields.");
		
		child5.log(LogStatus.PASS, "Seller redirects to General Shop Setup English form successfully.");		
		
		logger.appendChild(child5);
		
		//
		//Check Shop Setup ENGLISH Form with Shop Name field blank
		//
		child6=report.startTest("Check Shop Setup ENGLISH Form with Shop Name field blank");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child6.log(LogStatus.INFO, "Click On Save Changes in Shop Setup English form.");
		
		String mandatoryShopName = sellershopcreation.getMandatoryShopName();
		
		if(mandatoryShopName.contains("Mandatory"))
		{
			child6.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes in Shop Setup English form.");
			child6.log(LogStatus.PASS, mandatoryShopName);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes in Shop Setup English form.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Shop Setup ENGLISH Form with correct input in the form
		//
		child7=report.startTest("Check Shop Setup ENGLISH Form with correct input in the form");
		
		child7.log(LogStatus.INFO, "Enter Shop name and click on Save Changes button on Shop Setup English form.");
		
		sellershopcreation.enterShopnameforEnglish();
		child7.log(LogStatus.PASS, "Seller redirects to Shop Setup Arabic form.");
		
		logger.appendChild(child7);
		
		//
		//Check Shop Setup ARABIC Form with Shop Name field blank
		//
		child8=report.startTest("Check Shop Setup ARABIC Form with Shop Name field blank");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child8.log(LogStatus.INFO, "Click On Save Changes in Shop Setup Arabic form.");
		
		String mandatoryShopNameArabic = sellershopcreation.getMandatoryShopName();
		
		if(mandatoryShopNameArabic.contains("Mandatory"))
		{
			child8.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes in Shop Setup Arabic form.");
			child8.log(LogStatus.PASS, mandatoryShopNameArabic);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes in Shop Setup Arabic form.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Shop Setup ARABIC Form with correct input in the form
		//
		child9=report.startTest("Check Shop Setup ARABIC Form with correct input in the form");
		
		child9.log(LogStatus.INFO, "Enter Shop name and click on Save Changes button on Shop Setup Arabic form.");
		
		sellershopcreation.enterShopnameforArabic();
		child9.log(LogStatus.PASS, "Seller redirects to RETURN ADDRESS Shop Setup form successfully.");
		
		logger.appendChild(child9);
		
		//
		//Check Shop Setup Return Address General form with Country field blank
		//
		//child10=report.startTest("Check Shop Setup Return Address General form with Country field blank");
		
		//countryvalueselect = (String) jsonObject.get("County Drop Down Select");
		
		//sellershopcreation.selectCounty(countryvalueselect);
		//child10.log(LogStatus.INFO, "Select County from County drop down of Shop Setup Return Address General form.");
		
		//sellershopcreation.clickOnSaveChangesEnglish();
		//child10.log(LogStatus.INFO, "Click On Save Changes with keeping Country field blank in Shop Setup Return Address General form");
		
		//String mandatoryCountry = sellershopcreation.getMandatoryCountryName();
		
		//if(mandatoryCountry.contains("Mandatory"))
		//{
		//	child10.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes with keeping Country field blank in ");
		//	child10.log(LogStatus.PASS, mandatoryCountry);
		//}
		//else
		//{
		//	child10.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes with keeping Country field blank in ");
		//}
		
		//logger.appendChild(child10);
		
		child11=report.startTest("Check Shop Setup Return Address General form with State field blank");
		
		countryvalue = (String) jsonObject.get("County Drop Down");
		
		sellershopcreation.selectCounty(countryvalue);
		child11.log(LogStatus.INFO, "Select County from County drop down of Shop Setup Return Address General form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child11.log(LogStatus.INFO, "Click On Save Changes with keeping State field blank in  Shop Setup Return Address General form.");
		
		String mandatoryreturnstate = sellershopcreation.getMandatoryReturnState();
		
		if(mandatoryreturnstate.contains("Mandatory"))
		{
			child11.log(LogStatus.INFO, "Seller is getting correct validaion error message when click On Save Changes with keeping State field blank in  Shop Setup Return Address General form.");
			child11.log(LogStatus.INFO, mandatoryreturnstate);
		}
		else
		{
			child11.log(LogStatus.INFO, "Seller is not getting correct validaion error message when click On Save Changes with keeping State field blank in  Shop Setup Return Address General form.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Shop Setup Return Address General form with all correct inputs
		//
		child12=report.startTest("Check Shop Setup Return Address General form with all correct inputs");
		
		statevalue = (String) jsonObject.get("State Drop Down");
		
		sellershopcreation.selectState(statevalue);
		child12.log(LogStatus.INFO, "Select state from State drop down of Shop Setup Return Address General form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child12.log(LogStatus.INFO, "Click On Save Changes with all correct inputs in Shop Setup Return Address General form.");
		
		child12.log(LogStatus.PASS, "Seller redirects to Shop Setup Return Address English form.");
		
		logger.appendChild(child12);
		
		//
		//Check Shop Setup Return Address English form with Name field blank
		//
		child13=report.startTest("Check Shop Setup Return Address English form with Name field blank");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child13.log(LogStatus.INFO, "Click On Save Changes with Name field blank in Shop Setup Return Address English form.");
		
		String mandatoryReturnAddressName = sellershopcreation.getMandatoryReturnEnglishName();
		
		if(mandatoryReturnAddressName.contains("Mandatory"))
		{
			child13.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes with Name field blank in Shop Setup Return Address English form.");
			child13.log(LogStatus.PASS, mandatoryReturnAddressName);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Selller is not getting correct validation error message when click On Save Changes with Name field blank in Shop Setup Return Address English form.");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Shop Setup Return Address English form with City field blank
		//
		child14=report.startTest("Check Shop Setup Return Address English form with City field blank");
		
		nameReturn = (String) jsonObject.get("Name Return Address*");
		
		sellershopcreation.enterReturnAddressEnglishName(nameReturn);
		child14.log(LogStatus.INFO, "Enter Name in Name field in Shop Setup Return Address English form");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child14.log(LogStatus.INFO, "Click On Save Changes with City field blank in Shop Setup Return Address English form.");
		
		String mandatoryReturnEnglishCity = sellershopcreation.getMandatoryReturnEnglishCity();
		
		if(mandatoryReturnEnglishCity.contains("Mandatory"))
		{
			child14.log(LogStatus.PASS, "Seller is getting correct validtion error message when click On Save Changes with City field blank in Shop Setup Return Address English form.");
			child14.log(LogStatus.PASS, mandatoryReturnEnglishCity);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Seller is not getting correct validtion error message when click On Save Changes with City field blank in Shop Setup Return Address English form.");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Shop Setup Return Address English form with Address1 field blank
		//
		child15=report.startTest("Check Shop Setup Return Address English form with Address1 field blank");
		
		cityReturn = (String) jsonObject.get("City Return Address*");
		
		sellershopcreation.enterReturnAddressEnglishCity(cityReturn);
		child15.log(LogStatus.INFO, "Enter Return Address English City in Shop Setup Return Address English form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child15.log(LogStatus.INFO, "Click On Save Changes with City field blank in Shop Setup Return Address English form.");		
		
		String mandatoryAddress1ReturnEnglish = sellershopcreation.getMandatoryAddress1ReturnEnglish();
		
		if(mandatoryAddress1ReturnEnglish.contains("Mandatory"))
		{
			child15.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes with City field blank in Shop Setup Return Address English form.");
			child15.log(LogStatus.PASS, mandatoryAddress1ReturnEnglish);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes with City field blank in Shop Setup Return Address English form.");
		}
		
		logger.appendChild(child15);
		
		//
		//Check Shop Setup Return Address English form with all correct inputs
		//
		child16=report.startTest("Check Shop Setup Return Address English form with all correct inputs");
		
		address1Return = (String) jsonObject.get("Address1 Return Address*");
		
		sellershopcreation.enterAddress1ReturnAddressEnglish(address1Return);
		child16.log(LogStatus.INFO, "Enter Address1 in Shop Setup Return Address English form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child16.log(LogStatus.INFO, "Click On Save Changes with all correct inputs in Shop Setup Return Address English form.");
		
		child16.log(LogStatus.PASS, "Seller redirects to Return Address Arabic form.");
		
		logger.appendChild(child16);
		
		//
		//Check Shop Setup Return Address Arabic form with Name field blank
		//
		child17=report.startTest("Check Shop Setup Return Address Arabic form with Name field blank");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child17.log(LogStatus.INFO, "Click On Save Changes with Name field blank in Shop Setup Return Address Arabic form.");
		
		String mandatoryReturnAddressNameArabic = sellershopcreation.getMandatoryReturnEnglishName();
		
		if(mandatoryReturnAddressNameArabic.contains("Mandatory"))
		{
			child17.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes with Name field blank in Shop Setup Return Address Arabic form.");
			child17.log(LogStatus.PASS, mandatoryReturnAddressNameArabic);
		}
		else
		{
			child17.log(LogStatus.FAIL, "Selller is not getting correct validation error message when click On Save Changes with Name field blank in Shop Setup Return Address Arabic form.");
		}
		
		logger.appendChild(child17);
		
		//
		//Check Shop Setup Return Address Arabic form with City field blank
		//
		child18=report.startTest("Check Shop Setup Return Address Arabic form with City field blank");
		
		sellershopcreation.enterReturnAddressEnglishName(nameReturn);
		child18.log(LogStatus.INFO, "Enter Name in Name field in Shop Setup Return Address Arabic form");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child18.log(LogStatus.INFO, "Click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
		
		String mandatoryReturnEnglishCityArabic = sellershopcreation.getMandatoryReturnEnglishCity();
		
		if(mandatoryReturnEnglishCityArabic.contains("Mandatory"))
		{
			child14.log(LogStatus.PASS, "Seller is getting correct validtion error message when click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
			child14.log(LogStatus.PASS, mandatoryReturnEnglishCityArabic);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Seller is not getting correct validtion error message when click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
		}
		
		logger.appendChild(child18);
		
		//
		//Check Shop Setup Return Address Arabic form with Address1 field blank
		//
		child19=report.startTest("Check Shop Setup Return Address English form with Arabic field blank");
		
		sellershopcreation.enterReturnAddressEnglishCity(cityReturn);
		child19.log(LogStatus.INFO, "Enter City in Shop Setup Return Address Arabic form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child19.log(LogStatus.INFO, "Click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
		
		String mandatoryAddress1ReturnArabic = sellershopcreation.getMandatoryAddress1ReturnEnglish();
		
		if(mandatoryAddress1ReturnArabic.contains("Mandatory"))
		{
			child19.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
			child19.log(LogStatus.PASS, mandatoryAddress1ReturnArabic);
		}
		else
		{
			child19.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes with City field blank in Shop Setup Return Address Arabic form.");
		}
		
		logger.appendChild(child19);
		
		//
		//Check Shop Setup Return Address Arabic form with all correct inputs
		//
		child20=report.startTest("Check Shop Setup Return Address Arabic form with all correct inputs");
		
		sellershopcreation.enterAddress1ReturnAddressEnglish(address1Return);
		child20.log(LogStatus.INFO, "Enter Address1 in Shop Setup Return Address Arabic form.");
		
		sellershopcreation.clickOnSaveChangesEnglish();
		child20.log(LogStatus.INFO, "Click On Save Changes with all correct inputs in Shop Setup Return Address Arabic form.");
		
		//
		//Get the Actual Message comes on successful pop up.
		//
		String actual_message=sellershopcreation.getsuccessmessage();
				
		//
		//Match Actual Message with Expected message and log results in Automation Report
		//	
		if(actual_message.contains("Setup Successful"))
		{
			child20.log(LogStatus.PASS, "Seller is able to create Shop Successfully.");
			child20.log(LogStatus.PASS, actual_message);
		}
		else
		{
			child20.log(LogStatus.FAIL, "Seller is not able to create Shop Successfully.");
			child20.log(LogStatus.PASS, actual_message);
		}
		
		logger.appendChild(child20);
		
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
			logger.log(LogStatus.FAIL, "Seller is Not able to Set up Shop.");
			logger.log(LogStatus.FAIL, "Seller_ShopCreation_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		//driver.close();
	}

}
