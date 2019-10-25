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

import com.Pages.AdminAddNewProductPage;
import com.Pages.SellerAddNewProductPage;
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerAddNewPhysicalProduct_New {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	ExtentTest child21,child22,child23,child24,child25,child26,child27,child28,child29,child30;
	ExtentTest child31,child32;
	
	String seofriendlyURLempty,seofriendlyURL,countryvalue,countryvalueselect,statevalue,nameReturn,cityReturn,address1Return;
	String categoryName,modelNumber,minimumsellingpriceNonNumeric,maximumallowedsellingprice,minimumallowedsellingprice,brandName;
	String minimumsellingprice,selecttaxcategoryblank,selecttaxcategory,dimensionsUnit,enterlengthNonNumeric,enterlengthless,enterlengthcorrect,enteremptyWidth;
	String enternonnumericwidth,enterwidthless,enterwidthmore,enterwidthcorrect;
	String enterheightempty,enterheightnonnumeric,enterheightless,enterheightmore,enterheightcorrect,selectweight;
	String emptyweight,weightnonnumeric,weightless,weightmore,weightcorrect,productstatus,shippingcountry;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifySellerAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Add New Physical Product");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerAddNewProductInputData.json"));
		JSONObject jsonObject= (JSONObject) obj;
		
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/adminAddCategoryInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		
		Object obj2 = parser.parse(new FileReader("src/test/java/JSONData/adminAddBrandsInputData.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
		
		Object obj3 = parser.parse(new FileReader("src/test/java/JSONData/adminAddSalesTaxInputData.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
		
		//--------------------------------------------------Seller Add New Physical Product form.-------------------------------------------------------
		
		child1=report.startTest("Check opening Custom Product Setup form");
		
		driver=BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");
		
		//
		//Created Page Object using Page Factory to call the functions from Seller Shop Creation Page to click on dashboard from top.
		//
		SellerShopCreationPage sellershopcreation=PageFactory.initElements(driver, SellerShopCreationPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Seller Add New Product Page to click on dashboard from top.
		//
		SellerAddNewProductPage selleraddproduct=PageFactory.initElements(driver, SellerAddNewProductPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add New Product Page to click on dashboard from top.
		//
		AdminAddNewProductPage addNewProduct=PageFactory.initElements(driver, AdminAddNewProductPage.class);
		
		//
		//Seller is trying to login
		//
		sellershopcreation.sellerLogin();
		child1.log(LogStatus.PASS, "Seller is able to login successfully.");
		
		//
		//Seller go to Dashboard
		//
		sellershopcreation.gotoDashboard();
		child1.log(LogStatus.INFO, "Seller is able to go to Dashboard.");
		
		//
		//Seller is clicking on Products icon from left panel of seller dashboard
		//
		selleraddproduct.clickOnProductIcon();
		child1.log(LogStatus.INFO, "Seller clicks On Product Icon.");
		
		selleraddproduct.clickOnAddNewProductLink();
		child1.log(LogStatus.INFO, "Seller clicks On Add New Product Link.");
		
		categoryName = (String) jsonObject1.get(categoryName);
		
		selleraddproduct.clickOnSelectYourProductCategory("Yogesh");
		child1.log(LogStatus.INFO, "Click On Select Your Product Category.");
		
		selleraddproduct.clickOnSelectSubCategory();
		child1.log(LogStatus.INFO, "Click On Select Sub Category.");
		
		child1.log(LogStatus.PASS, "Seler redirects to Custom Product Setup form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check Add My Product General Basic form with Product Identifier Mandatory field blank
		//
		child2=report.startTest("Check Add My Product General Basic form with Product Identifier Mandatory field blank");
		
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
		//Check Add My Product General Basic form with Model field blank
		//
		child3=report.startTest("Check Add My Product General Basic form with Model field blank");
		
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
		//Check Add My Product General Basic form with Brand/manfacturer field blank
		//
		child4=report.startTest("Check Add My Product General Basic form with Brand/manfacturer field blank");
		
		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child4.log(LogStatus.INFO, "Enter Model in the form.");
		
		addNewProduct.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button keeping Brand/manfacturer field blank.");
		
		String mandatoryBrandManufacturer = selleraddproduct.getMandatoryBrandManufacturer();
		
		if(mandatoryBrandManufacturer.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes button keepingBrand/manfacturer field blank.");
			child4.log(LogStatus.PASS, mandatoryBrandManufacturer);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes button keepingBrand/manfacturer field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Add My Product General Basic form with Minimum Selling Price [$] field blank
		//
		child5=report.startTest("Check Add My Product General Basic form with Minimum Selling Price [$] field blank");
		
		brandName = (String) jsonObject2.get("Brand Name Dupliate");
		
		selleraddproduct.enterBrandName(brandName);
		child5.log(LogStatus.INFO, "Enter Brand Name.");
		
		selleraddproduct.clickOnSelectBrandfromDropDown(brandName);
		child5.log(LogStatus.INFO, "Select Brand Name from Brand Name suggestion drop down.");
		
		addNewProduct.clickOnSaveChanges();		
		child5.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		addNewProduct.enterProductMinimumSellingPrice("");
		child5.log(LogStatus.INFO, "Keep ProductMinimum Selling Price empty.");
		
		addNewProduct.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		String mandatoryMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(mandatoryMinimumSellingPrice.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Admin is getting correct validation error message when click On Save Changes button keeping 		Minimum Selling Price [$] field blank");
			child5.log(LogStatus.PASS, mandatoryMinimumSellingPrice);
		}
		else
		{
			child5.log(LogStatus.FAIL, mandatoryMinimumSellingPrice);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Add My Product General Basic form with entering Non-Numeric value in Minimum Selling Price [$] field
		//
		child6=report.startTest("Check Add My Product General Basic form with entering Non-Numeric value in Minimum Selling Price [$] field");
		
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
		//Check Add My Product General Basic form with entering more than allowed value in Minimum Selling Price [$] field
		//
		child7=report.startTest("Check Add My Product General Basic form with entering more than allowed value in Minimum Selling Price [$] field");
		
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
		//Check Add My Product General Basic form form with entering less than allowed value in Minimum Selling Price [$] field
		//
		child8=report.startTest("Check Add My Product General Basic form form with entering less than allowed value in Minimum Selling Price [$] field");
		
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
			child8.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Add My Product General Basic form with Tax Category field blank
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
		}
		
		logger.appendChild(child9);
		
		//
		//Check Product Setup General form with Dimensions Unit field blank
		//
		child10=report.startTest("Check Product Setup General form with keeping Dimensions Unit field blank");
		
		selecttaxcategory = (String) jsonObject3.get("Tax Category Name");
		
		selleraddproduct.selectTaxCategory(selecttaxcategory);
		child10.log(LogStatus.INFO, "Select Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child10.log(LogStatus.INFO, "Click On Save Changes button keeping Dimensions Unit field blank.");
		
		String mandatoryDimension = addNewProduct.getMandatoryDimensionsUnit();
		
		if(mandatoryDimension.contains("Mandatory"))
		{
			child10.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button keeping Dimension Unit field blank.");
			child10.log(LogStatus.PASS, mandatoryDimension);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button keeping Dimension Unit field blank.");
		}
		
		logger.appendChild(child10);		
		
		//
		//Check Product Setup General form with Length field blank
		//
		child11=report.startTest("Check Product Setup General form with Length field blank");
		
		dimensionsUnit = (String) jsonObject.get("Dimensions Unit");
		
		addNewProduct.selectDimensionsUnit(dimensionsUnit);
		child11.log(LogStatus.INFO, "Select Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child11.log(LogStatus.INFO, "Click On Save Changes button keeping Length field blank.");
		
		String lengthmandatory = addNewProduct.getMandatoryLength();
		
		if(lengthmandatory.contains("0.00001 And 9999999999"))
		{
			child11.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button keeping Length field blank.");
			child11.log(LogStatus.PASS, lengthmandatory);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button keeping Length field blank.");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Length field
		//
		child12=report.startTest("Check Product Setup General form with entering Non-Numeric value in Length field");
		
		enterlengthNonNumeric = (String) jsonObject.get("Enter Length Non Numeric");
		
		addNewProduct.enterLength(enterlengthNonNumeric);
		child12.log(LogStatus.INFO, "Enter Non-Numeric value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child12.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric value in Length field.");
		
		String lengthnonnumeric = addNewProduct.getMandatoryLength();
		
		if(lengthnonnumeric.contains("Numeric"))
		{
			child12.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Non-Numeric value in Length field.");
			child12.log(LogStatus.PASS, lengthnonnumeric);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering Non-Numeric value in Length field.");
		}
		
		logger.appendChild(child12);
		
		//
		//Check Product Setup General form with entering value less than allowed in Length field
		//
		child13=report.startTest("Check Product Setup General form with entering value less than allowed in Length field");
		
		enterlengthless = (String) jsonObject.get("Enter Length Less");
		
		addNewProduct.enterLength(enterlengthless);
		child13.log(LogStatus.INFO, "Enter lenght less than allowed value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child13.log(LogStatus.INFO, "Click On Save Changes button with entering lenght less than allowed value in Length field.");
		
		String lengthless = addNewProduct.getMandatoryLength();
		
		if(lengthless.contains("0.00001 And 9999999999"))
		{
			child13.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering lenght less than allowed value in Length field.");
			child13.log(LogStatus.PASS, lengthless);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering lenght less than allowed value in Length field.");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Product Setup General form with entering value more than allowed in Length field
		//
		child14=report.startTest("Check Product Setup General form with entering value more than allowed in Length field");
		
		enterlengthless = (String) jsonObject.get("Enter Length More");
		
		addNewProduct.enterLength(enterlengthless);
		child14.log(LogStatus.INFO, "Enter lenght more than allowed value in Length field.");
		
		addNewProduct.clickOnSaveChanges();
		child14.log(LogStatus.INFO, "Click On Save Changes button with entering lenght more than allowed value in Length field.");
		
		String lengthmore = addNewProduct.getMandatoryLength();
		
		if(lengthmore.contains("0.00001 And 9999999999"))
		{
			child14.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering lenght more than allowed value in Length field.");
			child14.log(LogStatus.PASS, lengthmore);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save butto nwith entering lenght more than allowed value in Length field.");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Product Setup General form with keeping Width field Blank
		//
		child15=report.startTest("Check Product Setup General form with keeping Width field Blank");
		
		enterlengthcorrect = (String) jsonObject.get("Enter Length Correct");
		
		addNewProduct.enterLength(enterlengthcorrect);
		child15.log(LogStatus.INFO, "Enter correct and allowed lenght in Length field.");
		
		enteremptyWidth = (String) jsonObject.get("Enter Empty Width");
		
		addNewProduct.enterWidth(enteremptyWidth);
		child15.log(LogStatus.INFO, "Keep Width field Blank.");
		
		addNewProduct.clickOnSaveChanges();
		child15.log(LogStatus.INFO, "Click On Save Changes button with keeping Width field Blank.");
		
		String mandatoryWidth = addNewProduct.getvalidationWidth();
		
		if(mandatoryWidth.contains("Mandatory"))
		{
			child15.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with keeping Width field blank.");
			child15.log(LogStatus.PASS, mandatoryWidth);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with keeping Width field blank.");
		}
		
		logger.appendChild(child15);
		
		//
		//Check Product Setup General form with entering Non-Numeric value in Width field
		//
		child16=report.startTest("Check Product Setup General form with entering Non-Numeric value in Width field");
		
		enternonnumericwidth = (String) jsonObject.get("Non Numeric Width");
		
		addNewProduct.enterWidth(enternonnumericwidth);
		child16.log(LogStatus.INFO, "Enter Non Numeric Width in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child16.log(LogStatus.INFO, "Click On Save Changes button with entering Non Numeric Width.");
		
		String nonNumericWidth = addNewProduct.getvalidationWidth();
		
		if(nonNumericWidth.contains("Numeric"))
		{
			child16.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Non Numeric Width.");
			child16.log(LogStatus.PASS, nonNumericWidth);
		}
		else
		{
			child16.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button entering Non Numeric Width.");
		}
		
		logger.appendChild(child16);
		
		//
		//Check Product Setup General form with entering value less than allowed in Width field
		//
		child17=report.startTest("Check Product Setup General form with entering Width value less than allowed in Width field");
		
		enterwidthless = (String) jsonObject.get("Enter Width Less");
		
		addNewProduct.enterWidth(enterwidthless);
		child17.log(LogStatus.INFO, "Enter Width value less than allowed in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child17.log(LogStatus.INFO, "Click On Save Changes button with entering Width value less than allowed Width.");
		
		String lessWidth = addNewProduct.getvalidationWidth();
		
		if(lessWidth.contains("0.00001 And 9999999999"))
		{
			child17.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Width value less than allowed.");
			child17.log(LogStatus.PASS, lessWidth);
		}
		else
		{
			child17.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with entering Width value less than allowed.");
		}
		
		logger.appendChild(child17);
		
		//
		//Check Product Setup General form with entering value more than allowed in Width field
		//
		child18=report.startTest("Check Product Setup General form with entering Width value more than allowed in Width field");
		
		enterwidthmore = (String) jsonObject.get("Enter Width More");
		
		addNewProduct.enterWidth(enterwidthmore);
		child18.log(LogStatus.INFO, "Enter Width value more than allowed in Width field.");
		
		addNewProduct.clickOnSaveChanges();
		child18.log(LogStatus.INFO, "Click On Save Changes button with entering Width value more than allowed Width.");
		
		String moreWidth = addNewProduct.getvalidationWidth();
		
		if(moreWidth.contains("0.00001 And 9999999999"))
		{
			child18.log(LogStatus.PASS, "Admin is getting correct validation error message when click on save button with entering Width value more than allowed.");
			child18.log(LogStatus.PASS, moreWidth);
		}
		else
		{
			child18.log(LogStatus.FAIL, "Admin is not getting correct validation error message when click on save button with entering Width value more than allowed.");
		}
		
		logger.appendChild(child18);
		
		//
		//Check Product Setup General form with keeping Height field blank
		//
		child19=report.startTest("Check Product Setup General form with keeping Height field blank");
		
		enterwidthcorrect = (String) jsonObject.get("Enter Width Correct");
		
		addNewProduct.enterWidth(enterwidthcorrect);
		child19.log(LogStatus.INFO, "Enter correct Width value in Width field.");
		
		enterheightempty = (String) jsonObject.get("Enter Height Empty");
		
		addNewProduct.enterHeight(enterheightempty);
		child19.log(LogStatus.INFO, "Keep Height field empty.");		
		
		addNewProduct.clickOnSaveChanges();
		child19.log(LogStatus.INFO, "Click On Save Changes button with correct Width value in Width field and Keeping Height field empty.");
		
		String emptyheight = addNewProduct.getvalidationHeight();
		
		if(emptyheight.contains("Mandatory"))
		{
			child19.log(LogStatus.PASS, "Admin is getting correct validation error message when entering correct Width value in Width field and Keeping Height field empty.");
			child19.log(LogStatus.PASS, emptyheight);
		}
		else
		{
			child19.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering correct Width value in Width field and Keeping Height field empty.");
		}
		
		logger.appendChild(child19);
		
		//
		//Check Product Setup General form with entering Height Non-Numeric in Height field
		//
		child20=report.startTest("Check Product Setup General form with entering Height Non-Numeric in Height field");
		
		enterheightnonnumeric = (String) jsonObject.get("Enter Height Non Numeric");
		
		addNewProduct.enterHeight(enterheightnonnumeric);
		child20.log(LogStatus.INFO, "Enter Non-Numeric height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child20.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric height in Height field.");
		
		String nonnumericheight = addNewProduct.getvalidationHeight();
		
		if(nonnumericheight.contains("Numeric"))
		{
			child20.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric height in Height field.");
			child20.log(LogStatus.PASS, nonnumericheight);
		}
		else
		{
			child20.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric height in Height field.");
		}
		
		logger.appendChild(child20);
		
		//
		//Check Product Setup General form with entering Height less than allowed in Height field
		//
		child21=report.startTest("Check Product Setup General form with entering Height less than allowed in Height field");
		
		enterheightless = (String) jsonObject.get("Enter Height Less");
		
		addNewProduct.enterHeight(enterheightless);
		child21.log(LogStatus.INFO, "Enter less than allowed height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child21.log(LogStatus.INFO, "Click On Save Changes button with entering less than allowed height in Height field.");
		
		String lessheight = addNewProduct.getvalidationHeight();
		
		if(lessheight.contains("0.00001 And 9999999999"))
		{
			child21.log(LogStatus.PASS, "Admin is getting correct validation error message when entering less than allowed height in Height field.");
			child21.log(LogStatus.PASS, lessheight);
		}
		else
		{
			child21.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering less than allowed height in Height field.");
		}
		
		logger.appendChild(child21);
		
		//
		//Check Product Setup General form with entering Height more than allowed in Height field
		//
		child22=report.startTest("Check Product Setup General form with entering Height more than allowed in Height field");
		
		enterheightmore = (String) jsonObject.get("Enter Height More");
		
		addNewProduct.enterHeight(enterheightmore);
		child22.log(LogStatus.INFO, "Enter more than allowed height in Height field.");		
		
		addNewProduct.clickOnSaveChanges();
		child22.log(LogStatus.INFO, "Click On Save Changes button with entering more than allowed height in Height field.");
		
		String moreheight = addNewProduct.getvalidationHeight();
		
		if(moreheight.contains("0.00001 And 9999999999"))
		{
			child22.log(LogStatus.PASS, "Admin is getting correct validation error message when entering more than allowed height in Height field.");
			child22.log(LogStatus.PASS, moreheight);
		}
		else
		{
			child22.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering more than allowed height in Height field.");
		}
		
		logger.appendChild(child22);
		
		//
		//Check Product Setup General form with Keeping Weight field blank
		//
		child23=report.startTest("Check Product Setup General form with Keeping Weight field blank");
		
		enterheightcorrect = (String) jsonObject.get("Enter Height Correct");
		
		addNewProduct.enterHeight(enterheightcorrect);
		child23.log(LogStatus.INFO, "Enter correct height in Height field.");	
		
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
		
//		//
//		//Check Product Setup General form with entering non-numeric weight in Weight field
//		//
//		child24=report.startTest("Check Product Setup General form with entering non-numeric weight in Weight field");
//		
//		weightnonnumeric = (String) jsonObject.get("Enter Weight Non Numeric");
//		
//		addNewProduct.enterWeight(weightnonnumeric);
//		child24.log(LogStatus.INFO, "Enter Non-Numeric weight in Weight field.");
//		
//		addNewProduct.clickOnSaveChanges();
//		child24.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric weight in Weight field.");
//		
//		String nonnumericweight = addNewProduct.getValidationWeightField();
//		
//		if(nonnumericweight.contains("Numeric"))
//		{
//			child24.log(LogStatus.PASS, "Admin is getting correct validation error message when entering Non-Numeric weight in Weight field.");
//			child24.log(LogStatus.PASS, nonnumericweight);
//		}
//		else
//		{
//			child24.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering Non-Numeric weight in Weight field.");
//		}
//		
//		logger.appendChild(child24);
//		
//		//
//		//Check Product Setup General form with entering weight less than allowed in Weight field
//		//
//		child25=report.startTest("Check Product Setup General form with entering weight less than allowed in Weight field");
//		
//		weightless = (String) jsonObject.get("Enter Weight Less");
//		
//		addNewProduct.enterWeight(weightless);
//		child25.log(LogStatus.INFO, "Enter weight less than allowed in Weight field.");
//		
//		addNewProduct.clickOnSaveChanges();
//		child25.log(LogStatus.INFO, "Click On Save Changes button with entering weight less than allowed weight in Weight field.");
//		
//		String lessweight = addNewProduct.getValidationWeightField();
//		
//		if(lessweight.contains("0.01 And 9999999999"))
//		{
//			child25.log(LogStatus.PASS, "Admin is getting correct validation error message when entering weight less than allowed in Weight field.");
//			child25.log(LogStatus.PASS, lessweight);
//		}
//		else
//		{
//			child25.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering weight less than allowed in Weight field.");
//		}
//		
//		logger.appendChild(child25);
//		
//		//
//		//Check Product Setup General form with entering weight more than allowed in Weight field
//		//
//		child26=report.startTest("Check Product Setup General form with entering weight more than allowed in Weight field");
//		
//		weightmore = (String) jsonObject.get("Enter Weight More");
//		
//		addNewProduct.enterWeight(weightmore);
//		child26.log(LogStatus.INFO, "Enter weight more than allowed in Weight field.");
//		
//		addNewProduct.clickOnSaveChanges();
//		child26.log(LogStatus.INFO, "Click On Save Changes button with entering weight moer than allowed weight in Weight field.");
//		
//		String moreweight = addNewProduct.getValidationWeightField();
//		
//		if(moreweight.contains("0.01 And 9999999999"))
//		{
//			child26.log(LogStatus.PASS, "Admin is getting correct validation error message when entering weight more than allowed in Weight field.");
//			child26.log(LogStatus.PASS, moreweight);
//		}
//		else
//		{
//			child26.log(LogStatus.FAIL, "Admin is not getting correct validation error message when entering weight more than allowed in Weight field.");
//		}
//		
//		logger.appendChild(child26);
		

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
		
		selleraddproduct.selectShippingCountry();
		child28.log(LogStatus.INFO, "Select India in the Shipping Country drop down.");
		
		selleraddproduct.clickOnFreeShippingCheckBox();
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
		
		addNewProduct.clickOnSaveChangesArabic();
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
		
		addNewProduct.clickOnSaveChangesArabic();
		child32.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup Arabic form.");
		
		selleraddproduct.clickOnEnglishTab();
		child32.log(LogStatus.INFO, "Click On English Tab to get the name of the creating product.");
		
		String enteredProductName = selleraddproduct.getEnteredProductName();
		child32.log(LogStatus.INFO, "Get the name of the creating product.");
		
		selleraddproduct.clickOnProductIcon();
		child32.log(LogStatus.INFO, "Click On Product Icon to get the name of the created product.");
		
		String actualCreatedProduct = selleraddproduct.getActualCreatedProductName();
		child32.log(LogStatus.INFO, "Get the name of the created product.");
		
		child32.log(LogStatus.INFO, "Compare creating product with created product.");
		
		if(actualCreatedProduct.contains(enteredProductName))
		{
			child32.log(LogStatus.PASS, "Admin is able to create Product successfully.");
			child32.log(LogStatus.PASS, "Created Product Name is:" + actualCreatedProduct);
		}
		else
		{
			child32.log(LogStatus.FAIL, "Admin is not able to create Product successfully.");
			child32.log(LogStatus.FAIL, actualCreatedProduct);
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
			logger.log(LogStatus.FAIL, "Seller is Not able to create New Product.");
			logger.log(LogStatus.FAIL, "Seller_ProductCreation_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		driver.close();
	}

}

