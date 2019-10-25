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

import com.Pages.AdminAddBrandsPage;
import com.Pages.AdminAddTagsPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddTags {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8;
	
	String tagidentifier,tagnameEnglish,tagnameArabic;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddTags() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Tags");
		
		//-------------------------------------------------------------Redirecting to Tags Setup Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Tags Setup Form");
		//
		//Start the Browser from BrowserFactory from Helper and Admin Login page of the application.
		//		
		driver=BrowserFactory1.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Admin Login page of the application.");
		
		//
		//Created Page Object using Page Factory to call the functions from SellerCreationPage for Admin Login.
		//
		AdminLoginPage adminlogin=PageFactory.initElements(driver, AdminLoginPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from AdminSellerApprovalFormPage to click on dashboard from top.
		//
		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Category Page to click on dashboard from top.
		//
		AdminAddBrandsPage addBrands=PageFactory.initElements(driver, AdminAddBrandsPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Options Page to click on dashboard from top.
		//
		AdminAddTagsPage addTags=PageFactory.initElements(driver, AdminAddTagsPage.class);
		
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
		
		//
		//Click on Catalog option of Dashboard drop down
		//
		addBrands.clickonCatalog();
		child1.log(LogStatus.INFO, "Admin is able to Click on Catalog option of Dashboard drop down.");
		
		addTags.clickOnTags();
		child1.log(LogStatus.INFO, "Admin is able to Click on Tags option of Dashboard drop down.");
		
		addTags.clickOnEditTagListtoGetAddNewTag();
		child1.log(LogStatus.INFO, "Admin is able to Click on Edit Tag List to Get Add New Tag.");
		
		addTags.clickonaddNewTag();
		child1.log(LogStatus.INFO, "Admin is able to Click on add New Tag.");
		child1.log(LogStatus.PASS, "Admin is able to open Tag Setup form.");
		
		logger.appendChild(child1);
		
		//-------------------------------------------------------------Tag Setup Form--------------------------------------------------------
		//
		//Check Mandatory Validation error message for Tag Identifier for Tag Setup General form
		//
		child2=report.startTest("Check Mandatory Validation error message for Tag Identifier for Tag Setup General form");
		
		addTags.clickonSaveChangesgeneral();
		child2.log(LogStatus.INFO, "Click on Save changes button with keeping Tag Identifier field blank.");
		
		String mandatoryValidationTagIdentifier = addTags.getvalidationErrormessageofTagIdentifier();
		
		if(mandatoryValidationTagIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes button with keeping Tag Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryValidationTagIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes button with keeping Tag Identifier field blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check Validation error message for Tag Identifier with duplicate entry for Tag Setup General form
		//
		child3=report.startTest("Check Validation error message for Tag Identifier with duplicate entry for Tag Setup General form");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddTagsInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		tagidentifier = (String) jsonObject.get("Tag Identifier");
		
		addTags.entertagIdentifier(tagidentifier);
		child3.log(LogStatus.INFO, "Enter already existing Tag Identifier.");
		
		addTags.clickonSaveChangesgeneral();
		child3.log(LogStatus.INFO, "Click on Save changes button with keeping Tag Identifier duplicated in the field.");
		
		String duplicationValidationforTagIdentifier = addTags.getduplicationValidationErrorMessageforTagIdentifier();
		
		if(duplicationValidationforTagIdentifier.contains("This Identifier Is Not Available"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when entering duplicated entry in Tag Identifier field.");
			child3.log(LogStatus.PASS, duplicationValidationforTagIdentifier);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering duplicated entry in Tag Identifier field.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Tag Identifier field with correct input for Tag Setup General form
		//
		child4=report.startTest("Check Tag Identifier field with correct input for Tag Setup General form");
		
		String uuid = UUID.randomUUID().toString();
		
		addTags.entertagIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter correct and non-exiting input in Tag Identifier field.");
		
		addTags.clickonSaveChangesgeneral();
		child4.log(LogStatus.INFO, "Click on Save changes button with correct and non-existing input in Tag Identifier field.");
		child4.log(LogStatus.PASS, "Admin is redirecting to the Tag Setup English form when entering non-existing input in Tag Identifier field.");
		
		logger.appendChild(child4);
		
		//
		//Check Mandatory Validation error message for Tag Name English for Tag Setup General form
		//
		child5=report.startTest("Check Mandatory Validation error message for Tag Name field for English in Tag Setup form");
		
		addTags.clickonSaveChangesgeneralenglish();
		child5.log(LogStatus.INFO, "Click on Save changes button with keeping Tag Name English field blank.");
		
		String mandatoryValidationTagNameEnglish = addTags.getValidationErrormessageofTagNameEnglish();
		
		if(mandatoryValidationTagNameEnglish.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes button with keeping Tag Name English field blank.");
			child5.log(LogStatus.PASS, mandatoryValidationTagNameEnglish);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes button with keeping Tag Name English field blank.");
		}
		
		logger.appendChild(child5);
			
		//
		//Check Tag Name field with correct input for English in Tag Setup form
		//
		child6=report.startTest("Check Tag Name field for English in Tag Setup form");
		
		tagnameEnglish = (String) jsonObject.get("Tag Name English");
		
		addTags.enterTagNameEnglish(tagnameEnglish);
		child6.log(LogStatus.INFO, "Enter correct input in Tag Name English field.");
		
		addTags.clickonSaveChangesgeneralenglish();
		child6.log(LogStatus.INFO, "Click on Save changes button with correct input in Tag Name English field.");
		child6.log(LogStatus.PASS, "Admin is redirecting to the Tag Setup Arabic form when entering correct input in Tag Name English field.");
		
		logger.appendChild(child6);
		
		//
		//Check Mandatory Validation error message for Tag Name Arabic for Tag Setup General form
		//
		child7=report.startTest("Check Mandatory Validation error message for Tag Name field for Arabic in Tag Setup form");
		
		addTags.clickonSaveChangesgeneralenglish();
		child7.log(LogStatus.INFO, "Click on Save changes button with keeping Tag Name Arabic field blank.");
		
		String mandatoryValidationTagNameArabic = addTags.getValidationErrormessageofTagNameArabic();
		
		if(mandatoryValidationTagNameArabic.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save changes button with keeping Tag Name Arabic field blank.");
			child7.log(LogStatus.PASS, mandatoryValidationTagNameArabic);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save changes button with keeping Tag Name Arabic field blank.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Tag Name field with correct input for Arabic in Tag Setup form and creation of Tag Successfully
		//
		child8=report.startTest("Check Tag Name field for Arabic in Tag Setup form and creation of Tag Successfully");
		
		tagnameArabic = (String) jsonObject.get("Tag Name Arabic");
		
		addTags.enterTagNameArabic(tagnameArabic);
		child8.log(LogStatus.INFO, "Enter correct input in Tag Name Arabic field.");
		
		addTags.clickonSaveChangesgeneralenglish();
		child8.log(LogStatus.INFO, "Click on Save changes button with correct input in Tag Name Arabic field.");
		
		String getsuccessmsg = addTags.getsuccessMessage();
		
		if (getsuccessmsg.contains("Tag Setup Successfully"))
		{
			child8.log(LogStatus.PASS, "Admin is able to create Tag successfully.");
			child8.log(LogStatus.PASS, getsuccessmsg);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Admin is not able to create Tag successfully.");
		}
		
		
		logger.appendChild(child8);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Tags.");
			logger.log(LogStatus.FAIL, "Admin_add_Tags", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
