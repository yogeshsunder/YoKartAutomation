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

public class VerifySellerAddNewDigitalProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10,child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	ExtentTest child21,child22,child23,child24,child25,child26,child27,child28,child29,child30,child31,child32;
	
	String seofriendlyURLempty,seofriendlyURL,countryvalue,countryvalueselect,statevalue,nameReturn,cityReturn,address1Return;
	String categoryName,modelNumber,minimumsellingpriceNonNumeric,maximumallowedsellingprice,minimumallowedsellingprice,brandName;
	String minimumsellingprice,selecttaxcategoryblank,selecttaxcategory,dimensionsUnit,enterlengthNonNumeric,enterlengthless,enterlengthcorrect,enteremptyWidth;
	String enternonnumericwidth,enterwidthless,enterwidthmore,enterwidthcorrect;
	String enterheightempty,enterheightnonnumeric,enterheightless,enterheightmore,enterheightcorrect,selectweight;
	String emptyweight,weightnonnumeric,weightless,weightmore,weightcorrect,productstatus,shippingcountry,producttype;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifySellerAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Add New Digital Product");
		
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
		
		categoryName = (String) jsonObject1.get("Category Name");
		
		selleraddproduct.clickOnSelectYourProductCategory(categoryName);
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
			child2.log(LogStatus.PASS, "Seller is getting correct validaton error message when click on Save Changes button keeping Proudct Identifier field blank.");
			child2.log(LogStatus.PASS, mandatoryProductIdentifier);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Seller is not getting correct validaton error message when click on Save Changes button keeping Proudct Identifier field blank.");
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
		//Check Add My Product General Basic form with Model field blank
		//
		child4=report.startTest("Check Add My Product General Basic form with Model field blank");
		
		String uuid = UUID.randomUUID().toString();
		
		addNewProduct.enterProductIdentifier(uuid);
		child4.log(LogStatus.INFO, "Enter non-existing / unique Product Identifier.");
		
		addNewProduct.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button keeping Model field blank.");
		
		String mandatoryModel = addNewProduct.getMandatoryModel();
		
		if(mandatoryModel.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Seller is getting correct validaton error message when click On Save Changes button keeping Model field blank.");
			child4.log(LogStatus.PASS, mandatoryModel);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not getting correct validaton error message when click On Save Changes button keeping Model field blank.");
		}
		
		logger.appendChild(child4);
		
		//
		//Check Add My Product General Basic form with Brand/manfacturer field blank
		//
		child5=report.startTest("Check Add My Product General Basic form with Brand/manfacturer field blank");
		
		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child5.log(LogStatus.INFO, "Enter Model in the form.");
		
		addNewProduct.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button keeping Brand/manfacturer field blank.");
		
		String mandatoryBrandManufacturer = selleraddproduct.getMandatoryBrandManufacturer();
		
		if(mandatoryBrandManufacturer.contains("Mandatory"))
		{
			child5.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes button keepingBrand/manfacturer field blank.");
			child5.log(LogStatus.PASS, mandatoryBrandManufacturer);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes button keepingBrand/manfacturer field blank.");
		}
		
		logger.appendChild(child5);
		
		//
		//Check Add My Product General Basic form with Minimum Selling Price [$] field blank
		//
		child6=report.startTest("Check Add My Product General Basic form with Minimum Selling Price [$] field blank");
		
		brandName = (String) jsonObject2.get("Brand Name");
		
		selleraddproduct.enterBrandName(brandName);
		child6.log(LogStatus.INFO, "Enter Brand Name.");
		
		selleraddproduct.clickOnSelectBrandfromDropDown(brandName);
		child6.log(LogStatus.INFO, "Select Brand Name from Brand Name suggestion drop down.");
		
		addNewProduct.clickOnSaveChanges();		
		child6.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		addNewProduct.enterProductMinimumSellingPrice("");
		child6.log(LogStatus.INFO, "Keep ProductMinimum Selling Price empty.");
		
		addNewProduct.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click On Save Changes button keeping Minimum Selling Price [$] field blank.");
		
		String mandatoryMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(mandatoryMinimumSellingPrice.contains("Mandatory"))
		{
			child6.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes button keeping Minimum Selling Price [$] field blank");
			child6.log(LogStatus.PASS, mandatoryMinimumSellingPrice);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes button keeping Minimum Selling Price [$] field blank");
			child6.log(LogStatus.FAIL, mandatoryMinimumSellingPrice);
		}
		
		logger.appendChild(child6);
		
		//
		//Check Add My Product General Basic form with entering Non-Numeric value in Minimum Selling Price [$] field
		//
		child7=report.startTest("Check Add My Product General Basic form with entering Non-Numeric value in Minimum Selling Price [$] field");
		
		minimumsellingpriceNonNumeric = (String) jsonObject.get("Minimum Selling Price Non-Numeric");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingpriceNonNumeric);
		child7.log(LogStatus.INFO, "Enter Non-Numeric Product Minimum Selling Price.");
		
		addNewProduct.clickOnSaveChanges();
		child7.log(LogStatus.INFO, "Click On Save Changes button entering Non-Numeric Product Minimum Selling Price.");
		
		String nonNumericMinimumSellingPrice = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(nonNumericMinimumSellingPrice.contains("Numeric"))
		{
			child7.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
			child7.log(LogStatus.PASS, nonNumericMinimumSellingPrice);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Non-Numeric Product Minimum Selling Price.");
		}
		
		logger.appendChild(child7);
		
		//
		//Check Add My Product General Basic form with entering more than allowed value in Minimum Selling Price [$] field
		//
		child8=report.startTest("Check Add My Product General Basic form with entering more than allowed value in Minimum Selling Price [$] field");
		
		maximumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price More");
		
		addNewProduct.enterProductMinimumSellingPrice(maximumallowedsellingprice);
		child8.log(LogStatus.INFO, "Enter Product Minimum Selling Price more than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child8.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price more than allowed.");
		
		String moreThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(moreThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child8.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
			child8.log(LogStatus.PASS, moreThanAllowedTaxCategory);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Product Minimum Selling Price more than allowed.");
		}
		
		logger.appendChild(child8);
		
		//
		//Check Add My Product General Basic form form with entering less than allowed value in Minimum Selling Price [$] field
		//
		child9=report.startTest("Check Add My Product General Basic form form with entering less than allowed value in Minimum Selling Price [$] field");
		
		minimumallowedsellingprice = (String) jsonObject.get("Minimum Selling Price Less");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumallowedsellingprice);
		child9.log(LogStatus.INFO, "Enter Product Minimum Selling Price less than allowed.");
		
		addNewProduct.clickOnSaveChanges();
		child9.log(LogStatus.INFO, "Click On Save Changes button entering Product Minimum Selling Price less than allowed.");
		
		String lessThanAllowedTaxCategory = addNewProduct.getmandatoryMinimumSellingPrice();
		
		if(lessThanAllowedTaxCategory.contains("0 And 9999999999"))
		{
			child9.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
			child9.log(LogStatus.PASS, lessThanAllowedTaxCategory);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Product Minimum Selling Price less than allowed.");
		}
		
		logger.appendChild(child9);
		
		//
		//Check Add My Product General Basic form with Tax Category field blank
		//
		child10=report.startTest("Check Product Setup General form with Tax Category Mandatory field blank");
		
		minimumsellingprice = (String) jsonObject.get("Minimum Selling Price");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingprice);
		child10.log(LogStatus.INFO, "Enter correct Product Minimum Selling Price.");
		
		selecttaxcategoryblank = (String) jsonObject.get("Select Tax Category Blank");
		
		addNewProduct.selectTaxCategory(selecttaxcategoryblank);
		child10.log(LogStatus.INFO, "Select select in Tax Category.");
		
		addNewProduct.clickOnSaveChanges();
		child10.log(LogStatus.INFO, "Click On Save Changes button keeping Tax Category field blank.");
		
		String mandatoryTaxCategory = addNewProduct.getMandatoryTaxCategory();
		
		if(mandatoryTaxCategory.contains("Mandatory"))
		{
			child10.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
			child10.log(LogStatus.PASS, mandatoryTaxCategory);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes button keeping Tax Category field blank.");
		}
		
		logger.appendChild(child10);
		
		//
		//Check Product Setup General form with Dimensions Unit field blank
		//
		child11=report.startTest("Check Product Setup General form with keeping Dimensions Unit field blank");
		
		selecttaxcategory = (String) jsonObject3.get("Tax Category Name");
		
		selleraddproduct.selectTaxCategory(selecttaxcategory);
		child11.log(LogStatus.INFO, "Select Tax Category.");
		
		productstatus = (String) jsonObject.get("Product Status");
		
		addNewProduct.selectProductStatus(productstatus);
		child11.log(LogStatus.INFO, "Select Active in Product Status drop down.");
		
		addNewProduct.clickOnSaveChanges();
		child11.log(LogStatus.INFO, "Click On Save Changes button.");
		
		child11.log(LogStatus.PASS, "Seller is able to redirects to Product Setup English form successfully.");
		
		logger.appendChild(child11);
		
		//
		//Check Product Setup English form with Product Name blank
		//
		child12=report.startTest("Check Product Setup English form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child12.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup English form.");
		
		String mandatoryProductNameEnglish = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameEnglish.contains("Mandatory"))
		{
			child12.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child12.log(LogStatus.PASS, mandatoryProductNameEnglish);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child12);
		
		//
		//Check Product Setup English form with correct Product Name
		//
		child13=report.startTest("Check Product Setup English form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child13.log(LogStatus.INFO, "Enter Product Name in Product Setup English form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child13.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup English form.");
		
		child13.log(LogStatus.PASS, "Admin is able to fill Product set up form and redirects to Product set up Arabic form successfully.");
				
		logger.appendChild(child13);
		
		//
		//Check Product Setup Arabic form with Product Name blank
		//
		child14=report.startTest("Check Product Setup Arabic form with Product Name blank");
		
		addNewProduct.clickOnSaveChangesArabic();
		child14.log(LogStatus.INFO, "Click On Save Changes button with keeping Product Name blank on Product Setup Arabic form.");
		
		String mandatoryProductNameArabic = addNewProduct.getMandatoryValidationProductName();
		
		if(mandatoryProductNameArabic.contains("Mandatory"))
		{
			child14.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
			child14.log(LogStatus.PASS, mandatoryProductNameArabic);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save Changes button with keeping Product Name blank.");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Product Setup Arabic form with correct Product Name
		//
		child15=report.startTest("Check Product Setup Arabic form with correct Product Name");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child15.log(LogStatus.INFO, "Enter Product Name in Product Setup Arabic form.");
		
		addNewProduct.clickOnSaveChangesArabic();
		child15.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup Arabic form.");
		
		selleraddproduct.clickOnEnglishTab();
		child15.log(LogStatus.INFO, "Click On English Tab to get the name of the creating product.");
		
		String enteredProductName = selleraddproduct.getEnteredProductName();
		child15.log(LogStatus.INFO, "Get the name of the creating product.");
		
		selleraddproduct.clickOnProductIcon();
		child15.log(LogStatus.INFO, "Click On Product Icon to get the name of the created product.");
		
		String actualCreatedProduct = selleraddproduct.getActualCreatedProductName();
		child15.log(LogStatus.INFO, "Get the name of the created product.");
		
		child15.log(LogStatus.INFO, "Compare creating product with created product.");
		
		if(actualCreatedProduct.contains(enteredProductName))
		{
			child15.log(LogStatus.PASS, "Seller is able to create Product successfully.");
			child15.log(LogStatus.PASS, "Created Product Name is:" + actualCreatedProduct);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Seller is not able to create Product successfully.");
			child15.log(LogStatus.FAIL, actualCreatedProduct);
		}
		
		//String successmessage = selleraddproduct.getSuccessMessage();
		
		//if(successmessage.contains("Successful"))
		//{		
		//	child15.log(LogStatus.PASS, "Admin is able to create Product successfully.");
		//	child15.log(LogStatus.PASS, successmessage);
		//}
		//else
		//{
		//	child15.log(LogStatus.FAIL, "Admin is not able to create Product successfully.");
		//	child15.log(LogStatus.FAIL, successmessage);
		//}
				
		logger.appendChild(child15);
		
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

