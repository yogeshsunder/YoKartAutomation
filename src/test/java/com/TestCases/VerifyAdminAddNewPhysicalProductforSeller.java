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

public class VerifyAdminAddNewPhysicalProductforSeller {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	ExtentTest child21,child22,child23,child24,child25,child26,child27,child28,child29,child30;
	ExtentTest child31,child32;

	String minimumsellingprice,selecttaxcategory,productIdentifierDuplciate,minimumsellingpriceNonNumeric,maximumallowedsellingprice,minimumallowedsellingprice;
	String selecttaxcategoryblank,modelNumber,dimensionsUnit,enterlengthNonNumeric,enterlengthless,enterlengthcorrect,enteremptyWidth;
	String enternonnumericwidth,enterwidthless,enterwidthmore,enterwidthcorrect;
	String enterheightempty,enterheightnonnumeric,enterheightless,enterheightmore,enterheightcorrect,selectweight;
	String emptyweight,weightnonnumeric,weightless,weightmore,weightcorrect,productstatus;
	String shipsTo,shippingcountry;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Admin Add New Physical Product for Seller");
		
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
		
		addNewProduct.clickUserField();
		child2.log(LogStatus.INFO, "Click in User field to see the Seller drop down to select.");
		
		addNewProduct.selectSellerinUserField();
		child2.log(LogStatus.INFO, "Select Seller for User field.");
		
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
		//Check Product Setup General form with Model field blank
		//
		child3=report.startTest("Check Product Setup General form with Model field blank");
		
		String uuid = UUID.randomUUID().toString();
		
		addNewProduct.enterProductIdentifier(uuid);
		child3.log(LogStatus.INFO, "Enter non-existing / unique Product Identifier.");
		
		addNewProduct.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click On Save Changes button keeping Model field blank.");
		
		String mandatoryModel = addNewProduct.getMandatoryModel();
		
		if(mandatoryModel.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Admin is getting correct validaton error message when click On Save Changes button keeping Model field blank.");
			child3.log(LogStatus.PASS, mandatoryModel);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Admin is not getting correct validaton error message when click On Save Changes button keeping Model field blank.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Product Setup General form with Minimum Selling Price [$] field blank
		//
		child4=report.startTest("Check Product Setup General form with Minimum Selling Price [$] Mandatory field blank");
		
		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child4.log(LogStatus.INFO, "Enter Model in the form.");
		
		addNewProduct.enterProductMinimumSellingPrice("");
		child4.log(LogStatus.INFO, "Keep ProductMinimum Selling Price empty.");
		
		addNewProduct.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		String mandatoryMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(mandatoryMinimumSellingPrice.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Admin is getting correct validation error message when click On Save Changes button keeping Minimum Selling Price [$] field blank");
			child4.log(LogStatus.PASS, mandatoryMinimumSellingPrice);
		}
		else
		{
			child4.log(LogStatus.FAIL, mandatoryMinimumSellingPrice);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Minimum Selling Price [$] field
		//
		child5=report.startTest("Check Product Setup General form with entering Non-Numeric value in Minimum Selling Price [$] field");
		
		minimumsellingpriceNonNumeric = (String) jsonObject.get("Minimum Selling Price Non-Numeric");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingpriceNonNumeric);
		child5.log(LogStatus.INFO, "Enter Non-Numeric Product Minimum Selling Price.");
		
		addNewProduct.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button entering Non-Numeric Product Minimum Selling Price.");
		
		String nonNumericMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(nonNumericMinimumSellingPrice.contains("Numeric"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
			child5.log(LogStatus.PASS, nonNumericMinimumSellingPrice);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
		}
		
		logger.appendChild(child5);
		
		//
		//Check Product Setup General form with entering more than allowed value in Minimum Selling Price [$] field
		//
		child6=report.startTest("Check Product Setup General form with entering More than allowed value in Minimum Selling Price [$] field");
		
		maximumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price More");
		
		addNewProduct.enterProductMinimumSellingPrice(maximumallowedsellingprice);
		child6.log(LogStatus.INFO, "Enter Product Minimum Selling Price more than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price more than allowed.");
		
		String moreThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(moreThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child6.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
			child6.log(LogStatus.PASS, moreThanAllowedTaxCategory);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
		}
		
		logger.appendChild(child6);
		
		//
		//Check Product Setup General form with entering less than allowed value in Minimum Selling Price [$] field
		//
		child7=report.startTest("Check Product Setup General form with entering Less than allowed value in Minimum Selling Price [$] field");
		
		minimumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price Less");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumallowedsellingprice);
		child7.log(LogStatus.INFO, "Enter Product Minimum Selling Price less than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child7.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price less than allowed.");
		
		String lessThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(lessThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child7.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
			child7.log(LogStatus.PASS, lessThanAllowedTaxCategory);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Product Setup General form with Tax Category field blank
		//
		child8=report.startTest("Check Product Setup General form with Tax Category Mandatory field blank");
		
		minimumsellingprice = (String) jsonObject.get("Minimum Selling Price");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingprice);
		child8.log(LogStatus.INFO, "Enter correct Product Minimum Selling Price.");
		
		selecttaxcategoryblank = (String) jsonObject.get("Select Tax Category Blank");
		
		addNewProduct.selectTaxCategory(selecttaxcategoryblank);
		child5.log(LogStatus.INFO, "Select select in Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child8.log(LogStatus.INFO, "Click On Save Changes button keeping Tax Category field blank.");
		
		String mandatoryTaxCategory = addNewProduct.getMandatoryTaxCategory();
		
		if(mandatoryTaxCategory.contains("Mandatory"))
		{
			child8.log(LogStatus.PASS, "Admin is getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
			child8.log(LogStatus.PASS, mandatoryTaxCategory);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Product Setup General form with Dimensions Unit field blank
		//
		child9=report.startTest("Check Product Setup General form with keeping Dimensions Unit field blank");
		
		selecttaxcategory = (String) jsonObject1.get("Tax Category Name");
		
		addNewProduct.select_Tax_Category(selecttaxcategory);
		child9.log(LogStatus.INFO, "Select Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child9.log(LogStatus.INFO, "Click On Save Changes button keeping Dimensions Unit field blank.");
		
		String mandatoryDimension = addNewProduct.getMandatoryDimensionsUnit();
		
		if(mandatoryDimension.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button keeping Dimension Unit field blank.");
			child9.log(LogStatus.PASS, mandatoryDimension);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button keeping Dimension Unit field blank.");
		}
		
		logger.appendChild(child9);
		
		//
		//Check Product Setup General form with Length field blank
		//
		child10=report.startTest("Check Product Setup General form with Length field blank");
		
		dimensionsUnit = (String) jsonObject.get("Dimensions Unit");
		
		addNewProduct.selectDimensionsUnit(dimensionsUnit);
		child10.log(LogStatus.INFO, "Select Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child10.log(LogStatus.INFO, "Click On Save Changes button keeping Length field blank.");
		
		String lengthmandatory = addNewProduct.getMandatoryLength();
		
		if(lengthmandatory.contains("0.00001 And 9999999999"))
		{
			child10.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button keeping Length field blank.");
			child10.log(LogStatus.PASS, lengthmandatory);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button keeping Length field blank.");
		}
		
		logger.appendChild(child10);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Length field
		//
		child11=report.startTest("Check Product Setup General form with entering Non-Numeric value in Length field");
		
		enterlengthNonNumeric = (String) jsonObject.get("Enter Length Non Numeric");
		
		addNewProduct.enterLength(enterlengthNonNumeric);
		child11.log(LogStatus.INFO, "Enter Non-Numeric value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child11.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric value in Length field.");
		
		String lengthnonnumeric = addNewProduct.getMandatoryLength();
		
		if(lengthnonnumeric.contains("Numeric"))
		{
			child11.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Non-Numeric value in Length field.");
			child11.log(LogStatus.PASS, lengthnonnumeric);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering Non-Numeric value in Length field.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Product Setup General form with entering value less than allowed in Length field
		//
		child12=report.startTest("Check Product Setup General form with entering value less than allowed in Length field");
		
		enterlengthless = (String) jsonObject.get("Enter Length Less");
		
		addNewProduct.enterLength(enterlengthless);
		child12.log(LogStatus.INFO, "Enter lenght less than allowed value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child12.log(LogStatus.INFO, "Click On Save Changes button with entering lenght less than allowed value in Length field.");
		
		String lengthless = addNewProduct.getMandatoryLength();
		
		if(lengthless.contains("0.00001 And 9999999999"))
		{
			child12.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering lenght less than allowed value in Length field.");
			child12.log(LogStatus.PASS, lengthless);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering lenght less than allowed value in Length field.");
		}
		
		logger.appendChild(child12);
		
		//
		//Check Product Setup General form with entering value more than allowed in Length field
		//
		child13=report.startTest("Check Product Setup General form with entering value more than allowed in Length field");
		
		enterlengthless = (String) jsonObject.get("Enter Length More");
		
		addNewProduct.enterLength(enterlengthless);
		child13.log(LogStatus.INFO, "Enter lenght more than allowed value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child13.log(LogStatus.INFO, "Click On Save Changes button with entering lenght more than allowed value in Length field.");
		
		String lengthmore = addNewProduct.getMandatoryLength();
		
		if(lengthmore.contains("0.00001 And 9999999999"))
		{
			child13.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering lenght more than allowed value in Length field.");
			child13.log(LogStatus.PASS, lengthmore);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering lenght more than allowed value in Length field.");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Product Setup General form with keeping Width field Blank
		//
		child14=report.startTest("Check Product Setup General form with keeping Width field Blank");
		
		enterlengthcorrect = (String) jsonObject.get("Enter Length Correct");
		
		addNewProduct.enterLength(enterlengthcorrect);
		child14.log(LogStatus.INFO, "Enter correct and allowed lenght in Length field.");
		
		enteremptyWidth = (String) jsonObject.get("Enter Empty Width");
		
		addNewProduct.enterWidth(enteremptyWidth);
		child14.log(LogStatus.INFO, "Keep Width field Blank.");
		
		addNewProduct.clickOnSaveChanges();
		child14.log(LogStatus.INFO, "Click On Save Changes button with keeping Width field Blank.");
		
		String mandatoryWidth = addNewProduct.getvalidationWidth();
		
		if(mandatoryWidth.contains("Mandatory"))
		{
			child14.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with keeping Width field blank.");
			child14.log(LogStatus.PASS, mandatoryWidth);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with keeping Width field blank.");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Width field
		//
		child15=report.startTest("Check Product Setup General form with entering Non-Numeric value in Width field");
		
		enternonnumericwidth = (String) jsonObject.get("Non Numeric Width");
		
		addNewProduct.enterWidth(enternonnumericwidth);
		child15.log(LogStatus.INFO, "Enter Non Numeric Width in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child15.log(LogStatus.INFO, "Click On Save Changes button with entering Non Numeric Width.");
		
		String nonNumericWidth = addNewProduct.getvalidationWidth();
		
		if(nonNumericWidth.contains("Numeric"))
		{
			child15.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Non Numeric Width.");
			child15.log(LogStatus.PASS, nonNumericWidth);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button entering Non Numeric Width.");
		}
		
		logger.appendChild(child15);
		
		//
		//Check Product Setup General form with entering value less than allowed in Width field
		//
		child16=report.startTest("Check Product Setup General form with entering Width value less than allowed in Width field");
		
		enterwidthless = (String) jsonObject.get("Enter Width Less");
		
		addNewProduct.enterWidth(enterwidthless);
		child16.log(LogStatus.INFO, "Enter Width value less than allowed in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child16.log(LogStatus.INFO, "Click On Save Changes button with entering Width value less than allowed Width.");
		
		String lessWidth = addNewProduct.getvalidationWidth();
		
		if(lessWidth.contains("0.00001 And 9999999999"))
		{
			child16.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Width value less than allowed.");
			child16.log(LogStatus.PASS, lessWidth);
		}
		else
		{
			child16.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with entering Width value less than allowed.");
		}
		
		logger.appendChild(child16);
		
		//
		//Check Product Setup General form with entering value more than allowed in Width field
		//
		child17=report.startTest("Check Product Setup General form with entering Width value more than allowed in Width field");
		
		enterwidthmore = (String) jsonObject.get("Enter Width More");
		
		addNewProduct.enterWidth(enterwidthmore);
		child17.log(LogStatus.INFO, "Enter Width value more than allowed in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child17.log(LogStatus.INFO, "Click On Save Changes button with entering Width value more than allowed Width.");
		
		String moreWidth = addNewProduct.getvalidationWidth();
		
		if(moreWidth.contains("0.00001 And 9999999999"))
		{
			child17.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Width value more than allowed.");
			child17.log(LogStatus.PASS, moreWidth);
		}
		else
		{
			child17.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with entering Width value more than allowed.");
		}
		
		logger.appendChild(child17);
		
		//
		//Check Product Setup General form with keeping Height field blank
		//
		child18=report.startTest("Check Product Setup General form with keeping Height field blank");
		
		enterwidthcorrect = (String) jsonObject.get("Enter Width Correct");
		
		addNewProduct.enterWidth(enterwidthcorrect);
		child18.log(LogStatus.INFO, "Enter correct Width value in Width field.");
		
		enterheightempty = (String) jsonObject.get("Enter Height Empty");
		
		addNewProduct.enterHeight(enterheightempty);
		child18.log(LogStatus.INFO, "Keep Height field empty.");		
		
		addNewProduct.clickOnSaveChanges();
		child18.log(LogStatus.INFO, "Click On Save Changes button with correct Width value in Width field and Keeping Height field empty.");
		
		String emptyheight = addNewProduct.getvalidationHeight();
		
		if(emptyheight.contains("Mandatory"))
		{
			child18.log(LogStatus.PASS, "Admin is getting correct validation error message when entering correct Width value in Width field and Keeping Height field empty.");
			child18.log(LogStatus.PASS, emptyheight);
		}
		else
		{
			child18.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering correct Width value in Width field and Keeping Height field empty.");
		}
		
		logger.appendChild(child18);
		
		//
		//Check Product Setup General form with entering Height Non-Numeric in Height field
		//
		child19=report.startTest("Check Product Setup General form with entering Height Non-Numeric in Height field");
		
		enterheightnonnumeric = (String) jsonObject.get("Enter Height Non Numeric");
		
		addNewProduct.enterHeight(enterheightnonnumeric);
		child19.log(LogStatus.INFO, "Enter Non-Numeric height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child19.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric height in Height field.");
		
		String nonnumericheight = addNewProduct.getvalidationHeight();
		
		if(nonnumericheight.contains("Numeric"))
		{
			child19.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric height in Height field.");
			child19.log(LogStatus.PASS, nonnumericheight);
		}
		else
		{
			child19.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric height in Height field.");
		}
		
		logger.appendChild(child19);
		
		//
		//Check Product Setup General form with entering Height less than allowed in Height field
		//
		child20=report.startTest("Check Product Setup General form with entering Height less than allowed in Height field");
		
		enterheightless = (String) jsonObject.get("Enter Height Less");
		
		addNewProduct.enterHeight(enterheightless);
		child20.log(LogStatus.INFO, "Enter less than allowed height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child20.log(LogStatus.INFO, "Click On Save Changes button with entering less than allowed height in Height field.");
		
		String lessheight = addNewProduct.getvalidationHeight();
		
		if(lessheight.contains("0.00001 And 9999999999"))
		{
			child20.log(LogStatus.PASS, "Admin is getting correct validation error message when entering less than allowed height in Height field.");
			child20.log(LogStatus.PASS, lessheight);
		}
		else
		{
			child20.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering less than allowed height in Height field.");
		}
		
		logger.appendChild(child20);
		
		//
		//Check Product Setup General form with entering Height more than allowed in Height field
		//
		child21=report.startTest("Check Product Setup General form with entering Height more than allowed in Height field");
		
		enterheightmore = (String) jsonObject.get("Enter Height More");
		
		addNewProduct.enterHeight(enterheightmore);
		child21.log(LogStatus.INFO, "Enter more than allowed height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child21.log(LogStatus.INFO, "Click On Save Changes button with entering more than allowed height in Height field.");
		
		String moreheight = addNewProduct.getvalidationHeight();
		
		if(moreheight.contains("0.00001 And 9999999999"))
		{
			child21.log(LogStatus.PASS, "Admin is getting correct validation error message when entering more than allowed height in Height field.");
			child21.log(LogStatus.PASS, moreheight);
		}
		else
		{
			child21.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering more than allowed height in Height field.");
		}
		
		logger.appendChild(child21);
		
		//
		//Check Product Setup General form with Keeping Weight Unit blank
		//
		child22=report.startTest("Check Product Setup General form with Keeping Weight Unit blank");
		
		enterheightcorrect = (String) jsonObject.get("Enter Height Correct");
		
		addNewProduct.enterHeight(enterheightcorrect);
		child22.log(LogStatus.INFO, "Enter correct height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child22.log(LogStatus.INFO, "Click On Save Changes button with entering correct height in Height field and keeping Weight Unit blank.");
		
		String mandatoryWeightUnit = addNewProduct.getValidationWeightUnit();
		
		if(mandatoryWeightUnit.contains("Mandatory"))
		{
			child22.log(LogStatus.PASS, "Admin is getting correct validation error message when entering correct height in Height field and keeping Weight Unit blank.");
			child22.log(LogStatus.PASS, mandatoryWeightUnit);
		}
		else
		{
			child22.log(LogStatus.PASS, "Admin is not getting correct validation error message when entering correct height in Height field and keeping Weight Unit blank.");
		}
		
		logger.appendChild(child22);
		
		//
		//Check Product Setup General form with Keeping Weight field blank
		//
		child23=report.startTest("Check Product Setup General form with Keeping Weight field blank");
		
		selectweight = (String) jsonObject.get("Select Weight");
		
		addNewProduct.selectWeightUnit(selectweight);
		child23.log(LogStatus.INFO, "Select Weight");
		
		emptyweight = (String) jsonObject.get("Empty Weight");
		
		addNewProduct.enterWeight(emptyweight);
		child23.log(LogStatus.INFO, "Keep Weight field empty");
		
		addNewProduct.clickOnSaveChanges();
		child23.log(LogStatus.INFO, "Click On Save Changes button with entering correct height in Height field and keeping Weight Unit blank.");
		
		String mandatoryweight = addNewProduct.getValidationWeightField();
		
		if(mandatoryweight.contains("Mandatory"))
		{
			child23.log(LogStatus.PASS, "Admin is getting correct validation error message when entering correct height in Height field and keeping Weight Unit blank.");
			child23.log(LogStatus.PASS, mandatoryweight);
		}
		else
		{
			child23.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering correct height in Height field and keeping Weight Unit blank.");
		}
		
		logger.appendChild(child23);
		
		//
		//Check Product Setup General form with entering non-numeric weight in Weight field
		//
		child24=report.startTest("Check Product Setup General form with entering non-numeric weight in Weight field");
		
		weightnonnumeric = (String) jsonObject.get("Enter Weight Non Numeric");
		
		addNewProduct.enterWeight(weightnonnumeric);
		child24.log(LogStatus.INFO, "Enter Non-Numeric weight in Weight field.");
		
		addNewProduct.clickOnSaveChanges();
		child24.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric weight in Weight field.");
		
		String nonnumericweight = addNewProduct.getValidationWeightField();
		
		if(nonnumericweight.contains("Numeric"))
		{
			child24.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric weight in Weight field.");
			child24.log(LogStatus.PASS, nonnumericweight);
		}
		else
		{
			child24.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric weight in Weight field.");
		}
		
		logger.appendChild(child24);
		
		//
		//Check Product Setup General form with entering weight less than allowed in Weight field
		//
		child25=report.startTest("Check Product Setup General form with entering weight less than allowed in Weight field");
		
		weightless = (String) jsonObject.get("Enter Weight Less");
		
		addNewProduct.enterWeight(weightless);
		child25.log(LogStatus.INFO, "Enter weight less than allowed in Weight field.");
		
		addNewProduct.clickOnSaveChanges();
		child25.log(LogStatus.INFO, "Click On Save Changes button with entering weight less than allowed weight in Weight field.");
		
		String lessweight = addNewProduct.getValidationWeightField();
		
		if(lessweight.contains("0.01 And 9999999999"))
		{
			child25.log(LogStatus.PASS, "Admin is getting correct validation error message when entering weight less than allowed in Weight field.");
			child25.log(LogStatus.PASS, lessweight);
		}
		else
		{
			child25.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering weight less than allowed in Weight field.");
		}
		
		logger.appendChild(child25);
		
		//
		//Check Product Setup General form with entering weight more than allowed in Weight field
		//
		child26=report.startTest("Check Product Setup General form with entering weight more than allowed in Weight field");
		
		weightmore = (String) jsonObject.get("Enter Weight More");
		
		addNewProduct.enterWeight(weightmore);
		child26.log(LogStatus.INFO, "Enter weight more than allowed in Weight field.");
		
		addNewProduct.clickOnSaveChanges();
		child26.log(LogStatus.INFO, "Click On Save Changes button with entering weight moer than allowed weight in Weight field.");
		
		String moreweight = addNewProduct.getValidationWeightField();
		
		if(moreweight.contains("0.01 And 9999999999"))
		{
			child26.log(LogStatus.PASS, "Admin is getting correct validation error message when entering weight more than allowed in Weight field.");
			child26.log(LogStatus.PASS, moreweight);
		}
		else
		{
			child26.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering weight more than allowed in Weight field.");
		}
		
		logger.appendChild(child26);
		
		//
		//Check Making Product Status active in Product Setup General form
		//
		child27=report.startTest("Check Product Setup General form with entering correct weight in Weight field and Making Product Status active");
		
		weightcorrect = (String) jsonObject.get("Enter Weight Correct");
		
		addNewProduct.enterWeight(weightcorrect);
		child27.log(LogStatus.INFO, "Enter correct weight in Weight field.");
		
		productstatus = (String) jsonObject.get("Product Status");
		
		addNewProduct.selectProductStatus(productstatus);
		child27.log(LogStatus.INFO, "Select Active in Product Status drop down.");
		
		child27.log(LogStatus.PASS, "Admin is able to enter correct weight in Weight field and Made Product Status active.");
		
		logger.appendChild(child27);
		
		//
		//Add shipping details in Product Setup General form
		//
		child28=report.startTest("Check Adding shipping details in Product Setup General form for Free Shipping");
		
		shippingcountry = (String) jsonObject.get("Shipping Country");
		
		addNewProduct.enterShippingCountry(shippingcountry);
		child28.log(LogStatus.INFO, "Enter Shipping Country in Product Set up general form.");
		
		addNewProduct.clickShippingCountrydropdown();
		child28.log(LogStatus.INFO, "Select India in the Shipping Country drop down.");
		
		addNewProduct.clickOnFreeShippingCheckBox();
		child28.log(LogStatus.INFO, "Click On Free Shipping Check Box.");
		
		addNewProduct.clickOnSaveChanges();
		child28.log(LogStatus.INFO, "Click On Save Changes button after entering shipping details.");
		
		child28.log(LogStatus.PASS, "Admin is able to enter shipping details and redirects to Product Setup English form successfully.");
				
		logger.appendChild(child28);
		
		//
		//Check Product Setup English form with Product Name blank
		//
		child29=report.startTest("Check Product Setup English form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child29.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup English form.");
		
		String mandatoryProductNameEnglish = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameEnglish.contains("Mandatory"))
		{
			child29.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child29.log(LogStatus.PASS, mandatoryProductNameEnglish);
		}
		else
		{
			child29.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child29);
		
		//
		//Check Product Setup English form with correct Product Name
		//
		child30=report.startTest("Check Product Setup English form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child30.log(LogStatus.INFO, "Enter Product Name in Product Setup English form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child30.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup English form.");
		
		child30.log(LogStatus.PASS, "Admin is able to fill Product set up form and redirects to Product set up Arabic form successfully.");
				
		logger.appendChild(child30);
		
		//
		//Check Product Setup Arabic form with Product Name blank
		//
		child31=report.startTest("Check Product Setup Arabic form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child31.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup Arabic form.");
		
		String mandatoryProductNameArabic = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameArabic.contains("Mandatory"))
		{
			child31.log(LogStatus.PASS, "Admin is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child31.log(LogStatus.PASS, mandatoryProductNameArabic);
		}
		else
		{
			child31.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child31);
		
		//
		//Check Product Setup Arabic form with correct Product Name
		//
		child32=report.startTest("Check Product Setup Arabic form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child32.log(LogStatus.INFO, "Enter Product Name in Product Setup Arabic form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child32.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup Arabic form.");
		
		String successmessage = addNewProduct.getSuccessMessage();
		
		if(successmessage.contains("Successful"))
		{		
			child32.log(LogStatus.PASS, "Admin is able to create Product successfully.");
			child32.log(LogStatus.PASS, successmessage);
		}
		else
		{
			child32.log(LogStatus.FAIL, "Admin is not able to create Product successfully.");
			child32.log(LogStatus.FAIL, successmessage);
		}
				
		logger.appendChild(child32);

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
		//driver.close();
	}

}

