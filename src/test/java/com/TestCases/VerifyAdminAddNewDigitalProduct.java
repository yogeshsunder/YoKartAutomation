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
import com.Pages.AdminAddNewProductPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory1;
import Helper.Utility;

public class VerifyAdminAddNewDigitalProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14;

	String minimumsellingprice,selecttaxcategory,productIdentifierDuplciate,minimumsellingpriceNonNumeric,maximumallowedsellingprice,minimumallowedsellingprice;
	String selecttaxcategoryblank,modelNumber;
	String productstatus;
	String producttype;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add New Digital Product");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddNewProductInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/adminAddSalesTaxInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		//-------------------------------------------------------------Redirecting to Tax Setup Setup Form--------------------------------------------------------
		
		child1=report.startTest("Check Opening Product Setup form");
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
		//Created Page Object using Page Factory to call the functions from Admin Add Duration Label Page to click on dashboard from top.
		//
		AdminAddNewProductPage addNewProduct=PageFactory.initElements(driver, AdminAddNewProductPage.class);
		
		//
		//Login into Admin.
		//
		adminlogin.loginAdmin();
		child1.log(LogStatus.PASS, "Admin is able to login successfully.");
		
		//
		//Click on Menu Icon
		//
		sellerapproval.clickonMenuIcon();
		child1.log(LogStatus.INFO, "Admin is able to click on Menu Icon on the top left of the Dashboard.");
		
		//
		//Click on Catalog option of Dashboard drop down
		//
		addBrands.clickonCatalog();
		child1.log(LogStatus.INFO, "Admin is able to Click on Catalog option of Dashboard drop down.");
		
		//
		//click On Products under Catalog option of Dashboard drop down
		//
		addNewProduct.clickOnProducts();
		child1.log(LogStatus.INFO, "Admin is able to Click on Products option of Catalog drop down.");
		
		addNewProduct.clickOnAddNewProductIcon();
		child1.log(LogStatus.INFO, "Admin is able to Click On Add New Product Icon on Manage Catalog Page.");
		
		addNewProduct.clickOnAddNewProduct();
		child1.log(LogStatus.INFO, "Admin is able to Click On Add New Product on Manage Catalog Page.");
		
		child1.log(LogStatus.PASS, "Admin is able to open Product Setup form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Product Setup General form with Product Identifier Mandatory field blank
		//
		child2=report.startTest("Check Product Setup General form with Product Identifier Mandatory field blank");
		
		addNewProduct.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click On Save Changes button keeping Product Identifier field blank.");
		
		String mandatoryProductIdentifier = addNewProduct.getMandatoryProductIdentifier();
		
		if(mandatoryProductIdentifier.contains("Mandatory"))
		{
			child2.log(LogStatus.PASS, "Admin is getting correct validaton error message when click on Save Changes button keeping Proudct Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryProductIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not getting correct validaton error message when click on Save Changes button keeping Proudct Identifier field blank.");
		}

		logger.appendChild(child2);
		
		//
		//Make Product Type Digital
		//
		child3=report.startTest("Make Product Type Digital");
		
		producttype = (String) jsonObject.get("Product Type");
		
		addNewProduct.selectProductType(producttype);
		child3.log(LogStatus.INFO, "Select Product Type as Digital in Product Setup general form.");
		
		logger.appendChild(child3);
		
		//
		//Check Product Setup General form with Model field blank
		//
		child4=report.startTest("Check Product Setup General form with Model field blank");
		
		String uuid = UUID.randomUUID().toString();
		
		addNewProduct.enterProductIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter non-existing / unique Product Identifier.");
		
		addNewProduct.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button keeping Model field blank.");
		
		String mandatoryModel = addNewProduct.getMandatoryModel();
		
		if(mandatoryModel.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validaton error message when click On Save Changes button keeping Model field blank.");
			child4.log(LogStatus.PASS, mandatoryModel);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Admin is not getting correct validaton error message when click On Save Changes button keeping Model field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Product Setup General form with Minimum Selling Price [$] field blank
		//
		child5=report.startTest("Check Product Setup General form with Minimum Selling Price [$] Mandatory field blank");
		
		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child5.log(LogStatus.INFO, "Enter Model in the form.");
		
		addNewProduct.enterProductMinimumSellingPrice("");
		child5.log(LogStatus.INFO, "Keep ProductMinimum Selling Price empty.");
		
		addNewProduct.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		String mandatoryMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(mandatoryMinimumSellingPrice.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click On Save Changes button keeping Minimum Selling Price [$] field blank");
			child5.log(LogStatus.PASS, mandatoryMinimumSellingPrice);
		}
		else
		{
			child5.log(LogStatus.FAIL, mandatoryMinimumSellingPrice);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Minimum Selling Price [$] field
		//
		child6=report.startTest("Check Product Setup General form with entering Non-Numeric value in Minimum Selling Price [$] field");
		
		minimumsellingpriceNonNumeric = (String) jsonObject.get("Minimum Selling Price Non-Numeric");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingpriceNonNumeric);
		child6.log(LogStatus.INFO, "Enter Non-Numeric Product Minimum Selling Price.");
		
		addNewProduct.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click On Save Changes button entering Non-Numeric Product Minimum Selling Price.");
		
		String nonNumericMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(nonNumericMinimumSellingPrice.contains("Numeric"))
		{
			child6.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
			child6.log(LogStatus.PASS, nonNumericMinimumSellingPrice);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Product Setup General form with entering more than allowed value in Minimum Selling Price [$] field
		//
		child7=report.startTest("Check Product Setup General form with entering More than allowed value in Minimum Selling Price [$] field");
		
		maximumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price More");
		
		addNewProduct.enterProductMinimumSellingPrice(maximumallowedsellingprice);
		child7.log(LogStatus.INFO, "Enter Product Minimum Selling Price more than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child7.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price more than allowed.");
		
		String moreThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(moreThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
			child7.log(LogStatus.PASS, moreThanAllowedTaxCategory);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Product Setup General form with entering less than allowed value in Minimum Selling Price [$] field
		//
		child8=report.startTest("Check Product Setup General form with entering Less than allowed value in Minimum Selling Price [$] field");
		
		minimumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price Less");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumallowedsellingprice);
		child8.log(LogStatus.INFO, "Enter Product Minimum Selling Price less than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child8.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price less than allowed.");
		
		String lessThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(lessThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child8.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
			child8.log(LogStatus.PASS, lessThanAllowedTaxCategory);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Product Setup General form with Tax Category field blank
		//
		child9=report.startTest("Check Product Setup General form with Tax Category Mandatory field blank");
		
		minimumsellingprice = (String) jsonObject.get("Minimum Selling Price");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingprice);
		child9.log(LogStatus.INFO, "Enter correct Product Minimum Selling Price.");
		
		selecttaxcategoryblank = (String) jsonObject.get("Select Tax Category Blank");
		
		addNewProduct.selectTaxCategory(selecttaxcategoryblank);
		child9.log(LogStatus.INFO, "Select select in Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child9.log(LogStatus.INFO, "Click On Save Changes button keeping Tax Category field blank.");
		
		String mandatoryTaxCategory = addNewProduct.getMandatoryTaxCategory();
		
		if(mandatoryTaxCategory.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
			child9.log(LogStatus.PASS, mandatoryTaxCategory);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
			child9.log(LogStatus.FAIL, mandatoryTaxCategory);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Making Product Status active in Product Setup General form
		//
		child10=report.startTest("Check Product Setup General form with Making Product Status active");
		
		selecttaxcategory = (String) jsonObject1.get("Tax Category Name");
		
		addNewProduct.select_Tax_Category(selecttaxcategory);
		child9.log(LogStatus.INFO, "Select Tax Category.");
		
		productstatus = (String) jsonObject.get("Product Status");
		
		addNewProduct.selectProductStatus(productstatus);
		child10.log(LogStatus.INFO, "Select Active in Product Status drop down.");
		
		child10.log(LogStatus.PASS, "Admin is able to Made Product Status active.");
			
		addNewProduct.clickOnSaveChanges();
		child10.log(LogStatus.INFO, "Click On Save Changes button after entering shipping details.");
		
		child10.log(LogStatus.PASS, "Admin is able to enter shipping details and redirects to Product Setup English form successfully.");
				
		logger.appendChild(child10);
		
		//
		//Check Product Setup English form with Product Name blank
		//
		child11=report.startTest("Check Product Setup English form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child11.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup English form.");
		
		String mandatoryProductNameEnglish = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameEnglish.contains("Mandatory"))
		{
			child11.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child11.log(LogStatus.PASS, mandatoryProductNameEnglish);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Product Setup English form with correct Product Name
		//
		child12=report.startTest("Check Product Setup English form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child12.log(LogStatus.INFO, "Enter Product Name in Product Setup English form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child12.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup English form.");
		
		child12.log(LogStatus.PASS, "Admin is able to fill Product set up form and redirects to Product set up Arabic form successfully.");
				
		logger.appendChild(child12);
		
		//
		//Check Product Setup Arabic form with Product Name blank
		//
		child13=report.startTest("Check Product Setup Arabic form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child13.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup Arabic form.");
		
		String mandatoryProductNameArabic = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameArabic.contains("Mandatory"))
		{
			child13.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child13.log(LogStatus.PASS, mandatoryProductNameArabic);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Product Setup Arabic form with correct Product Name
		//
		child14=report.startTest("Check Product Setup Arabic form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child14.log(LogStatus.INFO, "Enter Product Name in Product Setup Arabic form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child14.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup Arabic form.");
		
		String successmessage = addNewProduct.getSuccessMessage();
		
		if(successmessage.contains("Successful"))
		{		
			child14.log(LogStatus.PASS, "Admin is able to create Product successfully.");
			child14.log(LogStatus.PASS, successmessage);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Admin is not able to create Product successfully.");
			child14.log(LogStatus.FAIL, successmessage);
		}
				
		logger.appendChild(child14);

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
			logger.log(LogStatus.FAIL, "Admin is Not able to add New Product.");
			logger.log(LogStatus.FAIL, "Admin_add_Product", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);

		report.flush();;
		driver.close();
	}

}
