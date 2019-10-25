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
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddBrands {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10,child11,child12;
	
	String brandidentifier,brandSEOFriendlyURL,brandName,brandNamedupliate;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddBrands() throws FileNotFoundException, IOException, InterruptedException, ParseException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Brands");
		
		//-------------------------------------------------------------Product Category Setup General Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Product Brand Setup Form");
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
		
		//
		//Click on Brands option of Catalog drop down option of Dashboard drop down
		//
		addBrands.clickonBrands();
		child1.log(LogStatus.INFO, "Admin is able to Click on Brands option of Catalog drop down option of Dashboard drop down.");
		
		//
		//Click on edit Icon of Brand List
		//
		addBrands.clickoneditIconofBrandList();
		child1.log(LogStatus.INFO, "Admin is able to click on edit Brand on add brand page.");
		
		//
		//click on add Brand
		//
		addBrands.clickAddBrands();
		child1.log(LogStatus.INFO, "Admin is able to click on add Brand on add brand page.");
		child1.log(LogStatus.PASS, "Admin is able to open Product Brand Setup Form.");
		
		logger.appendChild(child1);
		
		//--------------------------------------------------------Product Brand Setup General Form------------------------------------------------------
		
		child2=report.startTest("Check Product Category Setup General Form with Brand Identifier Blank");
		
		//
		//Check validation error message for Brand Identifier
		//
		addBrands.clickonAddNew();
		child2.log(LogStatus.INFO, "Admin is clicking on Add New button keeping Brand Identifier field blank.");
		
		String validationBrandIdentifier = addBrands.validationMsgBrandIdentifier();
		
		if (validationBrandIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation message when keeping Brand Identifier field blank.");
			child2.log(LogStatus.PASS, validationBrandIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validation message when keeping Brand Identifier and Brand SEO Friendly URL field blank.");
		}
		
		logger.appendChild(child2);
		
		//
		//Check validation error message for Brand SEO Friendly URL
		//
		
		child3=report.startTest("Check Product Category Setup General Form with Brand SEO Friendly URL Blank");
		
		String uuid = UUID.randomUUID().toString();
		addBrands.enterBrandIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter correct Brand Identifier on the form.");
		
		addBrands.clearBrandSEOFriendlyURL();
		child3.log(LogStatus.INFO, "Clear Brand SEO Friendly URL on the form.");
		
		addBrands.clickonAddNew();
		child3.log(LogStatus.INFO, "Click on Add New button on the form.");
		
		String validationBrandSEOFriendlyURL = addBrands.validationMsgBrandSEOFriendlyURL();
		
		if (validationBrandSEOFriendlyURL.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation message when keeping Brand SEO Friendly URL field blank.");
			child3.log(LogStatus.PASS, validationBrandIdentifier);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation message when keeping Brand SEO Friendly URL field blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Duplication of Brand Identifier in Product Brand Setup General form
		//
		child4=report.startTest("Check Product Category Setup General Form with Brand Identifier Duplicated");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddBrandsInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		brandidentifier = (String) jsonObject.get("Brand Identifier");
		
		addBrands.enterBrandIdentifier(brandidentifier);
		child4.log(LogStatus.INFO, "Enter already existing Brand Identifier.");
		
		addBrands.clickonAddNew();
		child4.log(LogStatus.INFO, "Click on Add New button on the form.");
		
		String duplicateValidationforBrandIderntifier = addBrands.getduplicateValidationforBrandIderntifier();
		
		if (duplicateValidationforBrandIderntifier.contains("The Following Errors Occurred"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation message when entering already existing Brand Identifier.");
			child4.log(LogStatus.PASS, duplicateValidationforBrandIderntifier);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validation message when entering already existing Brand Identifier.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Product Category Setup General Form with all correct inputs
		//
		child5=report.startTest("Check Product Category Setup General Form with all correct inputs");
		
		addBrands.enterBrandIdentifier(uuid);
		child5.log(LogStatus.INFO, "Enter unique/non existing Brand Identifier");
		
		brandSEOFriendlyURL = (String) jsonObject.get("Brand SEO Friendly URL");
		addBrands.enterBrandSEOFriendlyURL(brandSEOFriendlyURL);
		child5.log(LogStatus.INFO, "Enter unique/non existing SEO Friendly URL");
		
		addBrands.clickonAddNew();
		child5.log(LogStatus.INFO, "Click on Add New button on the form.");
		
		child5.log(LogStatus.PASS, "Admin is able to fill General Product Brand Setup form.");
		
		logger.appendChild(child5);
		
		//
		//Check Product Category Setup English Form with keeping all fields of Product Category Setup English Form empty
		//
		child6=report.startTest("Check Product Category Setup English Form with keeping all fields empty");
		
		addBrands.clickonupdateButton();
		child6.log(LogStatus.INFO, "Click on Add New button on the form keeping all fields of Product Category Setup English Form empty.");
		
		String validationBrandNameEnglish = addBrands.getvalidationBrandName();
		
		if(validationBrandNameEnglish.contains("Mandatory"))
		{
			child6.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button keeping fields of Product Category Setup English Form empty.");
			child6.log(LogStatus.PASS, validationBrandNameEnglish);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button keeping fields of Product Category Setup English Form empty.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Product Category Setup English Form with duplicate Brand Name
		//
		child7=report.startTest("Check Product Category Setup English Form with duplicate Brand Name");
		
		brandNamedupliate = (String) jsonObject.get("Brand Name Dupliate");
		
		addBrands.enterBrandName(brandNamedupliate);
		child7.log(LogStatus.INFO, "Enter Brand Name which is already existing.");
		
		addBrands.clickonupdateButton();
		child7.log(LogStatus.INFO, "Click on Add New button on the form.");		
		
		String dupliateBrandNameEnglish = addBrands.getValidationBelow();
		child7.log(LogStatus.INFO, "Getting the validation error message on Brand Name field.");
		
		if(dupliateBrandNameEnglish.contains("Already Exists"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button with entering duplicate Brand Name.");
			child7.log(LogStatus.PASS, dupliateBrandNameEnglish);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button with entering duplicate Brand Name.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Product Category Setup English Form with all correct inputs
		//
		child8=report.startTest("Check Product Category Setup English Form with all correct inputs");
		
		addBrands.enterBrandName(uuid);
		child8.log(LogStatus.INFO, "Enter unique Brand Name.");
		
		addBrands.clickonupdateButton();
		child8.log(LogStatus.INFO, "Click on Add New button on the form.");
		
		child8.log(LogStatus.PASS, "Admin is able to fill Product Category Setup English Form.");
		
		logger.appendChild(child8);
		
		//
		//Check Product Category Setup Arabic Form with keeping all fields of Product Category Setup Arabic Form empty
		//
		child9=report.startTest("Check Product Category Setup Arabic Form with keeping all fields empty");
		
		addBrands.clickonupdateButtonArabic();
		child9.log(LogStatus.INFO, "Click on Add New button on the form keeping all fields of Product Category Setup English Form empty.");
		
		String validationBrandNameArabic = addBrands.getvalidationBrandName();
		
		if(validationBrandNameArabic.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button keeping fields of Product Category Setup Arabic Form empty.");
			child9.log(LogStatus.PASS, validationBrandNameArabic);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button keeping fields of Product Category Setup English Form empty.");
		}
		
		logger.appendChild(child9);	
		
		//
		//Check Product Category Setup Arabic Form with entering duplicate Brand Name
		//
		child10=report.startTest("Check Product Category Setup Arabic Form with entering duplicate Brand Name");
		
		addBrands.enterBrandName(brandNamedupliate);
		child10.log(LogStatus.INFO, "Enter Brand Name which is already existing.");
		
		addBrands.clickonupdateButton();
		child10.log(LogStatus.INFO, "Click on Add New button on the form.");		
		
		String dupliateBrandNameArabic = addBrands.getValidationBelow();
		child10.log(LogStatus.INFO, "Getting the validation error message on Brand Name field.");
		
		if(dupliateBrandNameArabic.contains("Already Exists"))
		{
			child10.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Update button with entering duplicate Brand Name.");
			child10.log(LogStatus.PASS, dupliateBrandNameArabic);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Update button with entering duplicate Brand Name.");
		}	
		
		logger.appendChild(child10);
		
		//
		//Check Product Category Setup Arabic Form with all correct inputs
		//
		child11=report.startTest("Check Product Category Setup Arabic Form with all correct inputs");
		
		addBrands.enterBrandName(uuid);
		child11.log(LogStatus.INFO, "Enter Brand Name.");
		
		addBrands.clickonupdateButton();
		child11.log(LogStatus.INFO, "Click on Add New button on the form.");
		
		child11.log(LogStatus.PASS, "Admin is able to fill Product Category Setup Arabic Form.");
		
		logger.appendChild(child11);
		
		//
		//Product Brand Setup General English Arabic Media form
		//
		child12=report.startTest("Check Product Brand Setup Media form.");
		
		addBrands.clickonUploadLogo();
		child12.log(LogStatus.INFO, "Click on Upload Logo button of Product Brand Setup Media form.");
		
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");
		Thread.sleep(7000);
		child12.log(LogStatus.INFO, "Upload logo for Universal Language.");
		
		addBrands.clickonCrossIcon();
		child12.log(LogStatus.INFO, "Close Product Brand Setup pop up window.");
		
		child12.log(LogStatus.PASS, "Admin is able to add Brand successfully.");
		
		logger.appendChild(child12);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to add Brands.");
			logger.log(LogStatus.FAIL, "Admin_add_Brands", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);

		report.flush();;
		driver.close();
	}

}
