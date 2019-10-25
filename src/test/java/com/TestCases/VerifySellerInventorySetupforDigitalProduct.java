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
import com.Pages.SellerInventorySetupPage;
import com.Pages.SellerInventorySetupforDigitalProductPage;
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerInventorySetupforDigitalProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	ExtentTest child21,child22,child23,child24;
	
	String seofriendlyURLempty,seofriendlyURL,countryvalue,countryvalueselect,statevalue,nameReturn,cityReturn,address1Return;
	String categoryName,modelNumber,brandName;
	String minimumsellingprice,selecttaxcategory,dimensionsUnit,enterlengthcorrect;
	String enterwidthcorrect;
	String enterheightcorrect,selectweight;
	String emptyweight,weightnonnumeric,weightless,weightmore,weightcorrect,productstatus,shippingcountry,producttype;
	
	String priceNonNumeric,priceMoreThanAllowed,priceLessThanAllowed,priceCorrect,quantityNonNumeric,quantityLessThanAllowed;
	String quantityMoreThanAllowed,quantityCorrect,minimumQuantitynonNumeric,minimumQuantityless,minimumQuantitymore,minimumQuantitycorrect;
	String productSKU,maxDownloadTimesNonNumeric,maxDownloadTimesCorrect,nonNumericValidity,correctValidity,productDisplayTitleEmpty;
	String productDisplayTitle,costPrice;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifySellerAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Inventory Setup for Digital Product");
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerAddNewProductInputData.json"));
		JSONObject jsonObject= (JSONObject) obj;
		
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/adminAddCategoryInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		
		Object obj2 = parser.parse(new FileReader("src/test/java/JSONData/adminAddBrandsInputData.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
		
		Object obj3 = parser.parse(new FileReader("src/test/java/JSONData/adminAddSalesTaxInputData.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;
		
		Object obj4 = parser.parse(new FileReader("src/test/java/JSONData/SellerInventorySetupInputData.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;
		
		//--------------------------------------------------Seller Add New Physical Product form.-------------------------------------------------------
		
		child1=report.startTest("Check Creating Digital Product");
		
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
		//Created Page Object using Page Factory to call the functions from Seller Inventory Setup.
		//
		SellerInventorySetupPage sellerInventorySetup=PageFactory.initElements(driver, SellerInventorySetupPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Seller Inventory Setup.
		//
		SellerInventorySetupforDigitalProductPage sellerInventorySetupDigital=PageFactory.initElements(driver, SellerInventorySetupforDigitalProductPage.class);
		
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
		
		producttype = (String) jsonObject.get("Product Type");
		
		addNewProduct.selectProductType(producttype);
		child1.log(LogStatus.INFO, "Select Product Type as Digital in Product Setup general form.");

		String uuid = UUID.randomUUID().toString();
		
		addNewProduct.enterProductIdentifier(uuid);
		child1.log(LogStatus.INFO, "Enter non-existing / unique Product Identifier.");

		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child1.log(LogStatus.INFO, "Enter Model in the form.");

		brandName = (String) jsonObject2.get("Brand Name");
		
		selleraddproduct.enterBrandName(brandName);
		child1.log(LogStatus.INFO, "Enter Brand Name.");
		
		selleraddproduct.clickOnSelectBrandfromDropDown(brandName);
		child1.log(LogStatus.INFO, "Select Brand Name from Brand Name suggestion drop down.");
		
		minimumsellingprice = (String) jsonObject.get("Minimum Selling Price");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingprice);
		child1.log(LogStatus.INFO, "Enter correct Product Minimum Selling Price.");
		
		selecttaxcategory = (String) jsonObject3.get("Tax Category Name");
		
		selleraddproduct.selectTaxCategory(selecttaxcategory);
		child1.log(LogStatus.INFO, "Select Tax Category.");
		
		productstatus = (String) jsonObject.get("Product Status");
		
		addNewProduct.selectProductStatus(productstatus);
		child1.log(LogStatus.INFO, "Select Active in Product Status drop down.");
		
		addNewProduct.clickOnSaveChanges();
		child1.log(LogStatus.INFO, "Click On Save Changes button.");
		
		child1.log(LogStatus.PASS, "Seller is able to redirects to Product Setup English form successfully.");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child1.log(LogStatus.INFO, "Enter Product Name in Product Setup English form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child1.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup English form.");
		
		child1.log(LogStatus.PASS, "Admin is able to fill Product set up form and redirects to Product set up Arabic form successfully.");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child1.log(LogStatus.INFO, "Enter Product Name in Product Setup Arabic form.");
		
		selleraddproduct.clickOnEnglishTab();
		child1.log(LogStatus.INFO, "Click On English Tab to get the name of the creating product.");
		
		String enteredProductName = selleraddproduct.getEnteredProductName();
		child1.log(LogStatus.INFO, "Get the name of the creating product.");
		
		selleraddproduct.clickOnProductIcon();
		child1.log(LogStatus.INFO, "Click On Product Icon to get the name of the created product.");
		
		String actualCreatedProduct = selleraddproduct.getActualCreatedProductName();
		child1.log(LogStatus.INFO, "Get the name of the created product.");
		
		child1.log(LogStatus.INFO, "Compare creating product with created product.");
		
		if(actualCreatedProduct.contains(enteredProductName))
		{
			child1.log(LogStatus.PASS, "Seller is able to create Product successfully.");
			child1.log(LogStatus.PASS, "Created Product Name is:" + actualCreatedProduct);
		}
		else
		{
			child1.log(LogStatus.FAIL, "Seller is not able to create Product successfully.");
			child1.log(LogStatus.FAIL, actualCreatedProduct);
		}
				
		logger.appendChild(child1);
		
		//
		//Check opening Inventory Setup form
		//
		child2=report.startTest("Check opening Inventory Setup form for Digital Product");
		
		sellerInventorySetup.clickOnAddToStore();
		child2.log(LogStatus.INFO, "Click On Add To Store icon on Marketplace Products page.");
		
		child2.log(LogStatus.PASS, "Seller is able to open Inventory Setup form successfully. ");
		
		logger.appendChild(child2);
		
		//
		//Check Inventory Setup General Basic form with Price field blank
		//
		child3=report.startTest("Check Inventory Setup General Basic form with Price field blank");
		
		costPrice = (String) jsonObject4.get("Cost Price");
		
		sellerInventorySetup.enterCostPrice(costPrice);
		
		sellerInventorySetup.clickOnSubmitButton();
		child3.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form with keeping Price field blank. ");
		
		String mandatoryPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child3.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child3.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(mandatoryPrice.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form with keeping Price field blank. ");
			child3.log(LogStatus.PASS, mandatoryPrice);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form with keeping Price field blank. ");
			child3.log(LogStatus.FAIL, mandatoryPrice);
		}
		
		logger.appendChild(child3);
		
		//
		//Check Inventory Setup General Basic form when entering non-numeric price in Price field
		//
		child4=report.startTest("Check Inventory Setup General Basic form when entering non-numeric price in Price field");
		
		priceNonNumeric = (String) jsonObject4.get("Price Non-Numeric");
		
		sellerInventorySetup.enterPrice(priceNonNumeric);
		child4.log(LogStatus.INFO, "Enter Non-Numeric price in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child4.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when enter non-numeric price in Price field.");
		
		String nonNumericPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child4.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child4.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(nonNumericPrice.contains("Numeric"))
		{
			child4.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form When entering non-numeric price in Price field. ");
			child4.log(LogStatus.PASS, nonNumericPrice);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form When entering non-numeric price in Price field. ");
			child4.log(LogStatus.FAIL, nonNumericPrice);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Inventory Setup General Basic form when entering price More than allowed in Price field
		//
		child5=report.startTest("Check Inventory Setup General Basic form when entering price More than allowed in Price field");
		
		priceMoreThanAllowed = (String) jsonObject4.get("Price More than Allowed");
		
		sellerInventorySetup.enterPrice(priceMoreThanAllowed);
		child5.log(LogStatus.INFO, "Enter price more than allowed in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child5.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering price more than allowed in Price field.");
		
		String moreThanAllowedPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child5.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child5.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(moreThanAllowedPrice.contains("Maximum"))
		{
			child5.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering price more than allowed in Price field. ");
			child5.log(LogStatus.PASS, moreThanAllowedPrice);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form when entering price more than allowed in Price field. ");
			child5.log(LogStatus.FAIL, moreThanAllowedPrice);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Inventory Setup General Basic form when entering price Less than allowed in Price field
		//
		child6=report.startTest("Check Inventory Setup General Basic form when entering price Less than allowed in Price field");
		
		priceLessThanAllowed = (String) jsonObject4.get("Price Less than Allowed");
		
		sellerInventorySetup.enterPrice(priceLessThanAllowed);
		child6.log(LogStatus.INFO, "Enter price Less than allowed in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child6.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field.");
		
		String lessThanAllowedPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child6.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child6.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(lessThanAllowedPrice.contains("Minimum"))
		{
			child6.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field. ");
			child6.log(LogStatus.PASS, lessThanAllowedPrice);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field. ");
			child6.log(LogStatus.FAIL, lessThanAllowedPrice);
		}
		
		logger.appendChild(child6);
		
		//
		//Check Inventory Setup General Basic form with keeping Quantity field Blank
		//
		child7=report.startTest("Check Inventory Setup General Basic form with keeping Quantity field Blank");
		
		priceCorrect = (String) jsonObject4.get("Price Correct");
		
		sellerInventorySetup.enterPrice(priceCorrect);
		child7.log(LogStatus.INFO, "Enter correct price in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child7.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering correct price in Price field and with keeping Quantity field Blank.");
		
		String mandatoryQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(mandatoryQuantity.contains("Mandatory"))
		{
			child7.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Submit button keeping Quantity field blank.");
			child7.log(LogStatus.PASS, mandatoryQuantity);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Submit button keeping Quantity field blank.");
			child7.log(LogStatus.FAIL, mandatoryQuantity);
		}
		
		logger.appendChild(child7);
		
		//
		//Check Inventory Setup General Basic form when entering non-numeric value in Quantity field
		//
		child8=report.startTest("Check Inventory Setup General Basic form when entering non-numeric value in Quantity field");
		
		quantityNonNumeric = (String) jsonObject4.get("Quantity Non-Numeric");
		
		sellerInventorySetup.enterQuantity(quantityNonNumeric);
		child8.log(LogStatus.INFO, "Enter non-numeric quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child8.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering non-numeric value in Quantity field.");
		
		String nonNumericQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(nonNumericQuantity.contains("Integer"))
		{
			child8.log(LogStatus.PASS, "Seller is getting correct validation error message when entering non-numeric value in Quantity field.");
			child8.log(LogStatus.PASS, nonNumericQuantity);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering non-numeric value in Quantity field.");
			child8.log(LogStatus.FAIL, nonNumericQuantity);
		}
		
		logger.appendChild(child8);
		
		//
		//Check Inventory Setup General Basic form when entering less than allowed value in Quantity field
		//
		child9=report.startTest("Check Inventory Setup General Basic form when entering less than allowed value in Quantity field");
		
		quantityLessThanAllowed = (String) jsonObject4.get("Quantity Less than Allowed");
		
		sellerInventorySetup.enterQuantity(quantityLessThanAllowed);
		child9.log(LogStatus.INFO, "Enter less than allowed quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child9.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering less than allowed value in Quantity field.");
		
		String lessThanAllowedQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(lessThanAllowedQuantity.contains("Between 0 And 9999999999"))
		{
			child9.log(LogStatus.PASS, "Seller is getting correct validation error message when entering less than allowed value in Quantity field.");
			child9.log(LogStatus.PASS, lessThanAllowedQuantity);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering less than allowed value in Quantity field.");
			child9.log(LogStatus.FAIL, lessThanAllowedQuantity);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Inventory Setup General Basic form when entering more than allowed value in Quantity field
		//
		child10=report.startTest("Check Inventory Setup General Basic form when entering more than allowed value in Quantity field");
		
		quantityMoreThanAllowed = (String) jsonObject4.get("Quantity More than Allowed");
		
		sellerInventorySetup.enterQuantity(quantityMoreThanAllowed);
		child10.log(LogStatus.INFO, "Enter more than allowed quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child10.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering more than allowed value in Quantity field.");
		
		String moreThanAllowedQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(moreThanAllowedQuantity.contains("Between 0 And 9999999999"))
		{
			child10.log(LogStatus.PASS, "Seller is getting correct validation error message when entering more than allowed value in Quantity field.");
			child10.log(LogStatus.PASS, moreThanAllowedQuantity);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering more than allowed value in Quantity field.");
			child10.log(LogStatus.FAIL, moreThanAllowedQuantity);
		}
		
		logger.appendChild(child10);
		
		//
		//Check Inventory Setup General Basic form with keeping Minimum Quantity field blank
		//
		child11=report.startTest("Check Inventory Setup General Basic form with keeping Minimum Quantity field blank");
		
		quantityCorrect = (String) jsonObject4.get("Quantity Correct");
		
		sellerInventorySetup.enterQuantity(quantityCorrect);
		child11.log(LogStatus.INFO, "Enter correct quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child11.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form with keeping Minimum Quantity field blank.");
		
		String mandatoryMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(mandatoryMinimumQuantity.contains("Mandatory"))
		{
			child11.log(LogStatus.PASS, "Seller is getting correct validation error message when keeping Minimum Quantity field blank");
			child11.log(LogStatus.PASS, mandatoryMinimumQuantity);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Seller is not getting correct validation error message when keeping Minimum Quantity field blank");
			child11.log(LogStatus.FAIL, mandatoryMinimumQuantity);
		}
		
		logger.appendChild(child11);
		
		//
		//Check Inventory Setup General Basic form with entering Non-Numeric Minimum quantity in Minimum Quantity field
		//
		child12=report.startTest("Check Inventory Setup General Basic form with entering Non-Numeric Minimum quantity in Minimum Quantity field");
		
		minimumQuantitynonNumeric = (String) jsonObject4.get("Minimum Quantity Non-Numeric");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitynonNumeric);
		child12.log(LogStatus.INFO, "Enter Minimum Quantity Non-Numeric in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child12.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity Non-Numeric in Minimum Quantity field.");
		
		String nonNumericMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(nonNumericMinimumQuantity.contains("Integer"))
		{
			child12.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity Non-Numeric in Minimum Quantity field");
			child12.log(LogStatus.PASS, nonNumericMinimumQuantity);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity Non-Numeric in Minimum Quantity field");
			child12.log(LogStatus.FAIL, nonNumericMinimumQuantity);
		}
		
		logger.appendChild(child12);
		
		//
		//Check Inventory Setup General Basic form with entering less than allowed Minimum quantity in Minimum Quantity field
		//
		child13=report.startTest("Check Inventory Setup General Basic form with entering less than allowed Minimum quantity in Minimum Quantity field");
		
		minimumQuantityless = (String) jsonObject4.get("Minimum Quantity Less than Allowed");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantityless);
		child13.log(LogStatus.INFO, "Enter Minimum Quantity less than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child13.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity less than allowed in Minimum Quantity field.");
		
		String lessMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(lessMinimumQuantity.contains("Between 0 And 9999999999"))
		{
			child13.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity less than allowed in Minimum Quantity field");
			child13.log(LogStatus.PASS, lessMinimumQuantity);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity less than allowed in Minimum Quantity field");
			child13.log(LogStatus.FAIL, lessMinimumQuantity);
		}
		
		logger.appendChild(child13);
		
		//
		//Check Inventory Setup General Basic form with entering more than allowed Minimum quantity in Minimum Quantity field
		//
		child14=report.startTest("Check Inventory Setup General Basic form with entering more than allowed Minimum quantity in Minimum Quantity field");
		
		minimumQuantitymore = (String) jsonObject4.get("Minimum Quantity More than Allowed");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitymore);
		child14.log(LogStatus.INFO, "Enter Minimum Quantity more than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child14.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
		
		String moreMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(moreMinimumQuantity.contains("Between 0 And 9999999999"))
		{
			child14.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field");
			child14.log(LogStatus.PASS, moreMinimumQuantity);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field");
			child14.log(LogStatus.FAIL, moreMinimumQuantity);
		}
		
		logger.appendChild(child14);
		
		//
		//Check Inventory Setup General Basic form with keeping Product SKU field blank
		//
		child15=report.startTest("Check Inventory Setup General Basic form with keeping Product SKU field blank");
		
		minimumQuantitycorrect = (String) jsonObject4.get("Minimum Quantity Correct");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitycorrect);
		child15.log(LogStatus.INFO, "Enter Minimum Quantity more than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child15.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
		
		String mandatoryProductSKU = sellerInventorySetup.getValidationProductSKU();
		
		if(mandatoryProductSKU.contains("Mandatory")) 
		{
			child15.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
			child15.log(LogStatus.PASS, mandatoryProductSKU);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field.");
			child15.log(LogStatus.FAIL, mandatoryProductSKU);
		}
		
		logger.appendChild(child15);
		
		//
		//Check Inventory Setup General Basic form with keeping Max Download Times field blank
		//
		child16=report.startTest("Check Inventory Setup General Basic form with keeping Max Download Times field blank");
		
		productSKU = (String) jsonObject4.get("Product SKU");
		
		sellerInventorySetup.enterProductSKU(productSKU);
		child16.log(LogStatus.INFO, "Enter Product SKU in Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child16.log(LogStatus.INFO, "Click On Submit Button with keeping Max Download Times field blank.");
		
		String validationMaxDownloadTimes = sellerInventorySetupDigital.getValidationMaxDownloadTimes();
		
		if (validationMaxDownloadTimes.contains("Mandatory"))
		{
			child16.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with keeping Max Download Times field blank.");
			child16.log(LogStatus.PASS, validationMaxDownloadTimes);
		}
		else
		{
			child16.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with keeping Max Download Times field blank.");
			child16.log(LogStatus.FAIL, validationMaxDownloadTimes);
		}
		
		logger.appendChild(child16);
		
		//
		//Check Inventory Setup General Basic form with entering Non-Numeric Max Download Times
		//
		child17=report.startTest("Check Inventory Setup General Basic form with entering Non-Numeric Max Download Times");
		
		maxDownloadTimesNonNumeric = (String) jsonObject4.get("Max Download Times Non-Numeric");
		
		sellerInventorySetupDigital.enterMaxDownloadTimes(maxDownloadTimesNonNumeric);
		child17.log(LogStatus.INFO, "Enter non-numeric Max Download Times in Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child17.log(LogStatus.INFO, "Click on Save changes button with entering non-numeric Max Download Times.");
		
		String nonNumericMaxDownloadTimes = sellerInventorySetupDigital.getValidationMaxDownloadTimes();
		
		if (nonNumericMaxDownloadTimes.contains("Integer"))
		{
			child17.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with entering non-numeric Max Download Times.");
			child17.log(LogStatus.PASS, nonNumericMaxDownloadTimes);
		}
		else
		{
			child17.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with entering non-numeric Max Download Times.");
			child17.log(LogStatus.FAIL, nonNumericMaxDownloadTimes);
		}
		
		logger.appendChild(child17);
		
		//
		//Check Inventory Setup General Basic form with keeping Validity (days) blank
		//
		child18=report.startTest("Check Inventory Setup General Basic form with keeping Validity (days) blank");
		
		maxDownloadTimesCorrect = (String) jsonObject4.get("Max Download Times Correct");
		
		sellerInventorySetupDigital.enterMaxDownloadTimes(maxDownloadTimesCorrect);
		child18.log(LogStatus.INFO, "Enter correct Max Download Times in Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child18.log(LogStatus.INFO, "Click on Save changes button with keeping Validity (days) blank.");
		
		String mandatoryValidityDays = sellerInventorySetupDigital.getValidationOfValiditydays();
		
		if (mandatoryValidityDays.contains("Mandatory"))
		{
			child18.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save changes button with keeping Validity (days) blank.");
			child18.log(LogStatus.PASS, mandatoryValidityDays);
		}
		else
		{
			child18.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save changes button with keeping Validity (days) blank.");
			child18.log(LogStatus.FAIL, mandatoryValidityDays);
		}
		
		logger.appendChild(child18);
		
		//
		//Check Inventory Setup General Basic form with entering Non-Numeric Validity (days) blank
		//
		child19=report.startTest("Check Inventory Setup General Basic form with entering Non-Numeric Validity (days) blank");
		
		nonNumericValidity = (String) jsonObject4.get("Non-Numeric Validity");
		
		sellerInventorySetupDigital.enterValidityDays(nonNumericValidity);
		child19.log(LogStatus.INFO, "Enter Non-Numeric Validity in Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child19.log(LogStatus.INFO, "Click on Save changes button with entering Non-Numeric Validity.");
		
		String nonNumericValidityDays = sellerInventorySetupDigital.getValidationOfValiditydays();
		
		if (nonNumericValidityDays.contains("Integer"))
		{
			child19.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save changes button with entering Non-Numeric Validity.");
			child19.log(LogStatus.PASS, nonNumericValidityDays);
		}
		else
		{
			child19.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Save changes button with entering Non-Numeric Validity.");
			child19.log(LogStatus.FAIL, nonNumericValidityDays);
		}
				
		logger.appendChild(child19);
		
		//
		//Check Inventory Setup General Basic form with entering Non-Numeric Validity (days) blank
		//
		child20=report.startTest("Check Inventory Setup General Basic form with entering correct Validity (days) blank");
		
		correctValidity = (String) jsonObject4.get("Correct Validity");
		
		sellerInventorySetupDigital.enterValidityDays(correctValidity);
		child20.log(LogStatus.INFO, "Enter correct Validity in Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child20.log(LogStatus.INFO, "Click on Save changes button with entering correct Validity.");
		
		child20.log(LogStatus.PASS, "Seller redirects to Inventory Setup General English form successfully.");
		
		
		logger.appendChild(child20);
		
		//
		//Check Inventory Setup General English form with keeping Product Display Title blank
		//
		child21=report.startTest("Check Inventory Setup General English form with keeping Product Display Title blank");
		
		String productDisplayTitle = sellerInventorySetup.getProductDisplayTitle();
		child21.log(LogStatus.INFO, "Getting Product title to enter after validating product display title filed blank.");
		
		productDisplayTitleEmpty = (String) jsonObject4.get("Product Display Title Empty");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitleEmpty);
		child21.log(LogStatus.INFO, "Keep Product Display Title field Empty.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child21.log(LogStatus.INFO, "Click On Submit Button with Product Display Title field blank.");
		
		String validationTitle = sellerInventorySetup.getValidationProductDisplayTitle();
		
		if(validationTitle.contains("Mandatory"))
		{
			child21.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child21.log(LogStatus.PASS, validationTitle);
		}
		else
		{
			child21.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child21.log(LogStatus.FAIL, validationTitle);
		}
		
		logger.appendChild(child21);
		
		//
		//Check Inventory Setup General English form with correct Product Display Title
		//
		child22=report.startTest("Check Inventory Setup General English form with correct Product Display Title");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitle);
		child22.log(LogStatus.INFO, "Enter Product Display Title in Inventory Setup General English form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child22.log(LogStatus.INFO, "Click On Submit Button after entering Product Display Title.");
		
		child22.log(LogStatus.PASS, "Seller is able to enter Product Display Title successfully and redirects to next form.");
		
		logger.appendChild(child22);
		
		//
		//Check Inventory Setup General Arabic form with Product Display Title field blank
		//
		child23=report.startTest("Check Inventory Setup General Arabic form with Product Display Title field blank");
		
		//sellerInventorySetup.clickOnArabicLink();
		//child23.log(LogStatus.INFO, "Click on Arabic Link in Inventory Setup General Arabic form.");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitleEmpty);
		child23.log(LogStatus.INFO, "Keep Product Display Title field Empty.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child23.log(LogStatus.INFO, "Click On Submit Button with Product Display Title field blank.");
		
		String validationTitleArabic = sellerInventorySetup.getValidationProductDisplayTitle();
		
		if(validationTitleArabic.contains("Mandatory"))
		{
			child23.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child23.log(LogStatus.PASS, validationTitleArabic);
		}
		else
		{
			child23.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child23.log(LogStatus.FAIL, validationTitle);
		}
		
		logger.appendChild(child23);
		
		//
		//Check Inventory Setup General Arabic form with correct Product Display Title
		//
		child24=report.startTest("Check Inventory Setup General Arabic form with correct Product Display Title");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitle);
		child24.log(LogStatus.INFO, "Enter Product Display Title in Inventory Setup General Arabic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child24.log(LogStatus.INFO, "Click On Submit Button after entering Product Display Title.");
		
		String successmsg = sellerInventorySetup.getSuccessMessage();
		
		if(successmsg.contains("Successful"))
		{
			child24.log(LogStatus.PASS, "Seller is able to enter Product Display Title and set up product in Inventory successfully.");
			child24.log(LogStatus.PASS, successmsg);
		}
		else
		{
			child24.log(LogStatus.FAIL, "Seller is not able to set up product in Inventory successfully.");
			child24.log(LogStatus.FAIL, successmsg);
		}
		
		logger.appendChild(child24);
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

