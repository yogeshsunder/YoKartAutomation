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

import com.Pages.AdminAddCategoryPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddCategory {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9;
	
	String CategoryName;
	
	@Test
	public void adminAddCategory() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add Category");
		
		JSONParser parser=new JSONParser();
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddCategoryInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		//-------------------------------------------------------------Product Category Setup General Form--------------------------------------------------------
		
		child1=report.startTest("Check opening Product Category Setup Form");
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
		AdminAddCategoryPage addCategory=PageFactory.initElements(driver, AdminAddCategoryPage.class);
		
		//
		//Login into Admin.
		//
		adminlogin.loginAdmin();
		child1.log(LogStatus.PASS, "Admin is able to login successfully.");
		
		//
		//click on Menu Icon
		//
		sellerapproval.clickonMenuIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click on Menu Icon on the top left of the Dashboard.");
		
		//
		//Click on Catalog option of Dashboard drop down
		//
		addCategory.clickonCatalog();
		child1.log(LogStatus.INFO, "Admin is able to Click on Catalog option of Dashboard drop down.");
		
		//
		//Click on product Category
		//
		addCategory.clickonproductCategory();
		child1.log(LogStatus.INFO, "Admin is able to Click on Product Category option of Dashboard drop down.");
		
		//
		//click on Edit Icon on page Category List Page
		//
		addCategory.clickoneditIconofProductCategoryPage();
		child1.log(LogStatus.INFO, "Admin is able to Click on Edit Icon on Category List Page.");
		
		//
		//click on add Category
		//
		addCategory.clickonaddCategory();
		child1.log(LogStatus.INFO, "Admin is able to Click on add Category on Category List Page.");
		child1.log(LogStatus.PASS, "Admin is able to open Product Category Setup Form.");
		
		logger.appendChild(child1);
		
		//
		//Check Product Category Setup General Form with Category Identifier blank
		//
		child2=report.startTest("Check Product Category Setup General Form with Category Identifier blank");
		
		addCategory.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click on Save Changes button with keeping Category Identifier blank.");
		
		String mandatorycategoryidentifier = addCategory.getMandatoryCategoryIdentifier();
		child2.log(LogStatus.INFO, "Getting the validation error message on Category Identifier field.");
		
		child2.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatorycategoryidentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Category Identifier blank.");
			child2.log(LogStatus.PASS, mandatorycategoryidentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is notgetting correct validation error message when click on Save Changes button with keeping Category Identifier blank.");
		}
		
		logger.appendChild(child2);		
		
		//
		//Check Product Category Setup General Form with Category SEO Friendly URL blank
		//
		child3=report.startTest("Check Product Category Setup General Form with Category SEO Friendly URL blank");
		
		String uuid = UUID.randomUUID().toString();
		
		addCategory.enterCategoryIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter Category Identifier.");
		
		addCategory.clearseoFriendUrl();
		child3.log(LogStatus.INFO, "Keep category SEO friendly URL empty.");
		
		addCategory.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click on Save Changes button with keeping Category SEO Friendly URL blank.");
		
		String mandatoryCategorySEOFriendlyURL = addCategory.getmandatoryCategorySEOFriendlyURL();
		child3.log(LogStatus.INFO, "Getting the validation error message on Category SEO Friendly URL field.");
		
		child3.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryCategorySEOFriendlyURL.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Category SEO Friendly URL blank.");
			child3.log(LogStatus.PASS, mandatoryCategorySEOFriendlyURL);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Category SEO Friendly URL blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Product Category Setup General Form with correct inputs
		//
		child4=report.startTest("Check Product Category Setup General Form with correct inputs");
		
		addCategory.enterCategoryIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter correct input in Category Identifier field of the form.");
		
		addCategory.enterseoFriendUrl(uuid);
		child4.log(LogStatus.INFO, "Enter correct input in Category SEO Friendly URL field of the form.");
		
		addCategory.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click on Save Changes button with correct inputs in the form.");
		
		child4.log(LogStatus.PASS, "Admin is able to redirect to Product Category Setup English form successfully.");
		
		logger.appendChild(child4);
		
		//-----------------------------------------------------------Product Category Setup English Form-----------------------------------------------------------
		
		//
		//Check Product Category Setup English Form with Category Name field blank
		//
		child5=report.startTest("Check Product Category Setup English Form with Category Name field blank");
		
		addCategory.clickOnSaveChangesEnglish();
		child5.log(LogStatus.INFO, "Click on Save Changes button with keeping Category Name field blank.");
		
		String mandatoryCategoryName = addCategory.getMandatoryCategoryName();
		child5.log(LogStatus.INFO, "Getting the validation error message on Category Name field.");
		
		child5.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryCategoryName.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validaion error message when click on Save Changes button with keeping Category Name field blank.");
			child5.log(LogStatus.PASS, mandatoryCategoryName);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validaion error message when click on Save Changes button with keeping Category Name field blank.");
		}
		
		logger.appendChild(child5);
		
		//
		//Check Product Category Setup English Form with correct input in Category Name field
		//
		child6=report.startTest("Check Product Category Setup English Form with correct input in Category Name field");
		
		CategoryName = (String) jsonObject.get("Category Name");
		
		addCategory.enterCategoryName(CategoryName);
		child6.log(LogStatus.INFO, "Enter Category Name in Product Category Setup English Form");
		
		addCategory.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click on Save Changes button with correct input in Category Name field.");
		
		child6.log(LogStatus.PASS, "Admin is able to redirect to Product Category Setup Arabic form successfully.");
		
		logger.appendChild(child6);
		
		//------------------------------------------------------------Product Categories Setup Arabic Form-----------------------------------------------------------
		//
		//Check Product Category Setup Arabic Form with Category Name field blank
		//
		child7=report.startTest("Check Product Category Setup Arabic Form with Category Name field blank");
		
		addCategory.clickOnSaveChangesEnglish();
		child7.log(LogStatus.INFO, "Click on Save Changes button with keeping Category Name field blank.");
		
		String mandatoryCategoryNameArabic = addCategory.getMandatoryCategoryName();
		child7.log(LogStatus.INFO, "Getting the validation error message on Category Name field.");
		
		child7.log(LogStatus.INFO, "Validating that the validation error message is correct.");
		
		if(mandatoryCategoryNameArabic.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validaion error message when click on Save Changes button with keeping Category Name field blank.");
			child7.log(LogStatus.PASS, mandatoryCategoryNameArabic);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validaion error message when click on Save Changes button with keeping Category Name field blank.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Product Category Setup English Form with correct input in Category Name field
		//
		child8=report.startTest("Check Product Category Setup Arabic Form with correct input in Category Name field");
		
		addCategory.enterCategoryName(CategoryName);
		child8.log(LogStatus.INFO, "Enter Category Name in Product Category Setup Arabic Form");
		
		addCategory.clickOnSaveChanges();
		child8.log(LogStatus.INFO, "Click on Save Changes button with correct input in Category Name field.");
		
		child8.log(LogStatus.PASS, "Admin is able to redirect to Product Category Media Setup form successfully.");
		
		logger.appendChild(child8);
		
		//------------------------------------------------------------Product Categories Setup Media Form-----------------------------------------------------------
		
		child9=report.startTest("Check Product Categories Setup Media Form");
				
		//
		//enter Product Categories Setup Media Form
		//
		addCategory.enterProductCategoriesSetupMeidaForm();
		child9.log(LogStatus.INFO, "Admin is able to Enter Product Category Setup Media Form.");
				
		//
		//Upload Media files for icon and banner
		//
		addCategory.closeProductCategoryMediaSetup();
		child9.log(LogStatus.INFO, "Admin is able to Close Product Category Media Setup.");
		child9.log(LogStatus.PASS, "Admin is able to create Product Category.");
			
		logger.appendChild(child9);
		
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
			logger.log(LogStatus.FAIL, "Admin is Not able to create Product Category.");
			logger.log(LogStatus.FAIL, "Admin_sellerapproval_Form", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}
