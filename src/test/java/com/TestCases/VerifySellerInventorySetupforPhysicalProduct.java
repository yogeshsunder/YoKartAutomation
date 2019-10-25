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
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerInventorySetupforPhysicalProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1,child2,child3,child4,child5,child6,child7,child8,child9,child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18,child19,child20;
	ExtentTest child21,child22,child23;
	
	String seofriendlyURLempty,seofriendlyURL,countryvalue,countryvalueselect,statevalue,nameReturn,cityReturn,address1Return;
	String categoryName,modelNumber,brandName;
	String minimumsellingprice,selecttaxcategoryblank,selecttaxcategory,dimensionsUnit,enterlengthcorrect;
	String enterwidthcorrect;
	String enterheightcorrect,selectweight;
	String weightcorrect,productstatus,shippingcountry;
	String priceNonNumeric,priceMoreThanAllowed,priceLessThanAllowed,priceCorrect;
	String quantityNonNumeric,quantityLessThanAllowed,quantityMoreThanAllowed,quantityCorrect;
	String minimumQuantitynonNumeric,minimumQuantityless,minimumQuantitymore,minimumQuantitycorrect;
	String productSKU,productCondition,productDisplayTitleEmpty,productDisplayTitle,costPrice;
	
	JSONParser parser=new JSONParser();
	
	@Test
	public void verifySellerAddNewProduct() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		report=ExtentFactory.getInstance();
		logger=report.startTest("Seller Inventory set up for Physical Product");
		
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
		//Created Page Object using Page Factory to call the functions from Seller Inventory Setup.
		//
		SellerInventorySetupPage sellerInventorySetup=PageFactory.initElements(driver, SellerInventorySetupPage.class);
		
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
		
		logger.appendChild(child1);
		
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
		//Check Creation of Physical Product from Seller
		//
		child2=report.startTest("Check opening Custom Product Setup form");
		
		String uuid = UUID.randomUUID().toString();
		
		addNewProduct.enterProductIdentifier(uuid);
		child2.log(LogStatus.INFO, "Enter non-existing / unique Product Identifier.");
			
		modelNumber = (String) jsonObject.get("Model");
		
		addNewProduct.enterModel(modelNumber);
		child2.log(LogStatus.INFO, "Enter Model in the form.");
		
		brandName = (String) jsonObject2.get("Brand Name");
		
		selleraddproduct.enterBrandName(brandName);
		child2.log(LogStatus.INFO, "Enter Brand Name.");
		
		selleraddproduct.clickOnSelectBrandfromDropDown(brandName);
		child2.log(LogStatus.INFO, "Select Brand Name from Brand Name suggestion drop down.");
		
		minimumsellingprice = (String) jsonObject.get("Minimum Selling Price");
		
		addNewProduct.enterProductMinimumSellingPrice(minimumsellingprice);
		child2.log(LogStatus.INFO, "Enter correct Product Minimum Selling Price.");
		
		selecttaxcategory = (String) jsonObject3.get("Tax Category Name");
		
		selleraddproduct.selectTaxCategory(selecttaxcategory);
		child2.log(LogStatus.INFO, "Select Tax Category.");
				
		dimensionsUnit = (String) jsonObject.get("Dimensions Unit");
		
		addNewProduct.selectDimensionsUnit(dimensionsUnit);
		child2.log(LogStatus.INFO, "Select Tax Category.");
				
		enterlengthcorrect = (String) jsonObject.get("Enter Length Correct");
		
		addNewProduct.enterLength(enterlengthcorrect);
		child2.log(LogStatus.INFO, "Enter correct and allowed lenght in Length field.");
		enterwidthcorrect = (String) jsonObject.get("Enter Width Correct");
		
		addNewProduct.enterWidth(enterwidthcorrect);
		child2.log(LogStatus.INFO, "Enter correct Width value in Width field.");
		enterheightcorrect = (String) jsonObject.get("Enter Height Correct");
		
		addNewProduct.enterHeight(enterheightcorrect);
		child2.log(LogStatus.INFO, "Enter correct height in Height field.");	
		
		selectweight = (String) jsonObject.get("Select Weight");
		
		addNewProduct.selectWeightUnit(selectweight);
		child2.log(LogStatus.INFO, "Select Weight");
		weightcorrect = (String) jsonObject.get("Enter Weight Correct");
		
		addNewProduct.enterWeight(weightcorrect);
		child2.log(LogStatus.INFO, "Enter correct weight in Weight field.");
		
		productstatus = (String) jsonObject.get("Product Status");
		
		addNewProduct.selectProductStatus(productstatus);
		child2.log(LogStatus.INFO, "Select Active in Product Status drop down.");
		shippingcountry = (String) jsonObject.get("Shipping Country");
		
		addNewProduct.enterShippingCountry(shippingcountry);
		child2.log(LogStatus.INFO, "Enter Shipping Country in Product Set up general form.");
		
		selleraddproduct.selectShippingCountry();
		child2.log(LogStatus.INFO, "Select India in the Shipping Country drop down.");
		
		selleraddproduct.clickOnFreeShippingCheckBox();
		child2.log(LogStatus.INFO, "Click On Free Shipping Check Box.");
		
		addNewProduct.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click On Save Changes button after entering shipping details.");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child2.log(LogStatus.INFO, "Enter Product Name in Product Setup English form.");
		
		addNewProduct.clickOnSaveChangesEnglish();
		child2.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup English form.");
		
		addNewProduct.enterProductNameEnglish(uuid);
		child2.log(LogStatus.INFO, "Enter Product Name in Product Setup Arabic form.");
		
		addNewProduct.clickOnSaveChangesArabic();
		child2.log(LogStatus.INFO, "Click On Save Changes button after entering Product Name in Product Setup Arabic form.");
		
		selleraddproduct.clickOnEnglishTab();
		child2.log(LogStatus.INFO, "Click On English Tab to get the name of the creating product.");
		
		String enteredProductName = selleraddproduct.getEnteredProductName();
		child2.log(LogStatus.INFO, "Get the name of the creating product.");
		
		selleraddproduct.clickOnProductIcon();
		child2.log(LogStatus.INFO, "Click On Product Icon to get the name of the created product.");
		
		String actualCreatedProduct = selleraddproduct.getActualCreatedProductName();
		child2.log(LogStatus.INFO, "Get the name of the created product.");
		
		child2.log(LogStatus.INFO, "Compare creating product with created product.");
		
		if(actualCreatedProduct.contains(enteredProductName))
		{
			child2.log(LogStatus.PASS, "Admin is able to create Product successfully.");
			child2.log(LogStatus.PASS, "Created Product Name is:" + actualCreatedProduct);
		}
		else
		{
			child2.log(LogStatus.FAIL, "Admin is not able to create Product successfully.");
			child2.log(LogStatus.FAIL, actualCreatedProduct);
		}		
		
		logger.appendChild(child2);
		
		//
		//Check opening Inventory Setup form
		//
		child3=report.startTest("Check opening Inventory Setup form");
		
		sellerInventorySetup.clickOnAddToStore();
		child3.log(LogStatus.INFO, "Click On Add To Store icon on Marketplace Products page.");
		
		child3.log(LogStatus.PASS, "Seller is able to open Inventory Setup form successfully. ");
		
		logger.appendChild(child3);
		
		//
		//Check Inventory Setup General Basic form with Price field blank
		//
		child4=report.startTest("Check Inventory Setup General Basic form with Price field blank");
		
		costPrice = (String) jsonObject4.get("Cost Price");
		
		sellerInventorySetup.enterCostPrice(costPrice);
		child4.log(LogStatus.INFO, "Enter Cost price on the form. ");
		
		sellerInventorySetup.clickOnSubmitButton();
		child4.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form with keeping Price field blank. ");
		
		String mandatoryPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child4.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child4.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(mandatoryPrice.contains("Mandatory"))
		{
			child4.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form with keeping Price field blank. ");
			child4.log(LogStatus.PASS, mandatoryPrice);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form with keeping Price field blank. ");
			child4.log(LogStatus.FAIL, mandatoryPrice);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Inventory Setup General Basic form when entering non-numeric price in Price field
		//
		child5=report.startTest("Check Inventory Setup General Basic form when entering non-numeric price in Price field");
		
		priceNonNumeric = (String) jsonObject4.get("Price Non-Numeric");
		
		sellerInventorySetup.enterPrice(priceNonNumeric);
		child5.log(LogStatus.INFO, "Enter Non-Numeric price in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child5.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when enter non-numeric price in Price field.");
		
		String nonNumericPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child5.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child5.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(nonNumericPrice.contains("Numeric"))
		{
			child5.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form When entering non-numeric price in Price field. ");
			child5.log(LogStatus.PASS, nonNumericPrice);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form When entering non-numeric price in Price field. ");
			child5.log(LogStatus.FAIL, nonNumericPrice);
		}
		
		logger.appendChild(child5);
		
		//
		//Check Inventory Setup General Basic form when entering price More than allowed in Price field
		//
		child6=report.startTest("Check Inventory Setup General Basic form when entering price More than allowed in Price field");
		
		priceMoreThanAllowed = (String) jsonObject4.get("Price More than Allowed");
		
		sellerInventorySetup.enterPrice(priceMoreThanAllowed);
		child6.log(LogStatus.INFO, "Enter price more than allowed in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child6.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering price more than allowed in Price field.");
		
		String moreThanAllowedPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child6.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child6.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(moreThanAllowedPrice.contains("Maximum"))
		{
			child6.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering price more than allowed in Price field. ");
			child6.log(LogStatus.PASS, moreThanAllowedPrice);
		}
		else
		{
			child6.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form when entering price more than allowed in Price field. ");
			child6.log(LogStatus.FAIL, moreThanAllowedPrice);
		}
		
		logger.appendChild(child6);
		
		//
		//Check Inventory Setup General Basic form when entering price Less than allowed in Price field
		//
		child7=report.startTest("Check Inventory Setup General Basic form when entering price Less than allowed in Price field");
		
		priceLessThanAllowed = (String) jsonObject4.get("Price Less than Allowed");
		
		sellerInventorySetup.enterPrice(priceLessThanAllowed);
		child7.log(LogStatus.INFO, "Enter price Less than allowed in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child7.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field.");
		
		String lessThanAllowedPrice = sellerInventorySetup.getMandatoryValidationPrice();
		child7.log(LogStatus.INFO, "Get the validation coming on Price field");
		
		child7.log(LogStatus.INFO, "Check the validation coming on Price field");
		
		if(lessThanAllowedPrice.contains("Minimum"))
		{
			child7.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field. ");
			child7.log(LogStatus.PASS, lessThanAllowedPrice);
		}
		else
		{
			child7.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button in Inventory Setup form when entering price Less than allowed in Price field. ");
			child7.log(LogStatus.FAIL, lessThanAllowedPrice);
		}
		
		logger.appendChild(child7);
		
		//
		//Check Inventory Setup General Basic form with keeping Quantity field Blank
		//
		child8=report.startTest("Check Inventory Setup General Basic form with keeping Quantity field Blank");
		
		priceCorrect = (String) jsonObject4.get("Price Correct");
		
		sellerInventorySetup.enterPrice(priceCorrect);
		child8.log(LogStatus.INFO, "Enter correct price in Price field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child8.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering correct price in Price field and with keeping Quantity field Blank.");
		
		String mandatoryQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(mandatoryQuantity.contains("Mandatory"))
		{
			child8.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Submit button keeping Quantity field blank.");
			child8.log(LogStatus.PASS, mandatoryQuantity);
		}
		else
		{
			child8.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click on Submit button keeping Quantity field blank.");
			child8.log(LogStatus.FAIL, mandatoryQuantity);
		}
		
		logger.appendChild(child8);
		
		//
		//Check Inventory Setup General Basic form when entering non-numeric value in Quantity field
		//
		child9=report.startTest("Check Inventory Setup General Basic form when entering non-numeric value in Quantity field");
		
		quantityNonNumeric = (String) jsonObject4.get("Quantity Non-Numeric");
		
		sellerInventorySetup.enterQuantity(quantityNonNumeric);
		child9.log(LogStatus.INFO, "Enter non-numeric quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child9.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering non-numeric value in Quantity field.");
		
		String nonNumericQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(nonNumericQuantity.contains("Integer"))
		{
			child9.log(LogStatus.PASS, "Seller is getting correct validation error message when entering non-numeric value in Quantity field.");
			child9.log(LogStatus.PASS, nonNumericQuantity);
		}
		else
		{
			child9.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering non-numeric value in Quantity field.");
			child9.log(LogStatus.FAIL, nonNumericQuantity);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Inventory Setup General Basic form when entering less than allowed value in Quantity field
		//
		child10=report.startTest("Check Inventory Setup General Basic form when entering less than allowed value in Quantity field");
		
		quantityLessThanAllowed = (String) jsonObject4.get("Quantity Less than Allowed");
		
		sellerInventorySetup.enterQuantity(quantityLessThanAllowed);
		child10.log(LogStatus.INFO, "Enter less than allowed quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child10.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering less than allowed value in Quantity field.");
		
		String lessThanAllowedQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(lessThanAllowedQuantity.contains("Between 0 And 9999999999"))
		{
			child10.log(LogStatus.PASS, "Seller is getting correct validation error message when entering less than allowed value in Quantity field.");
			child10.log(LogStatus.PASS, lessThanAllowedQuantity);
		}
		else
		{
			child10.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering less than allowed value in Quantity field.");
			child10.log(LogStatus.FAIL, lessThanAllowedQuantity);
		}
		
		logger.appendChild(child10);
		
		//
		//Check Inventory Setup General Basic form when entering more than allowed value in Quantity field
		//
		child11=report.startTest("Check Inventory Setup General Basic form when entering more than allowed value in Quantity field");
		
		quantityMoreThanAllowed = (String) jsonObject4.get("Quantity More than Allowed");
		
		sellerInventorySetup.enterQuantity(quantityMoreThanAllowed);
		child11.log(LogStatus.INFO, "Enter more than allowed quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child11.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering more than allowed value in Quantity field.");
		
		String moreThanAllowedQuantity = sellerInventorySetup.getValidationQuantity();
		
		if(moreThanAllowedQuantity.contains("Between 0 And 9999999999"))
		{
			child11.log(LogStatus.PASS, "Seller is getting correct validation error message when entering more than allowed value in Quantity field.");
			child11.log(LogStatus.PASS, moreThanAllowedQuantity);
		}
		else
		{
			child11.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering more than allowed value in Quantity field.");
			child11.log(LogStatus.FAIL, moreThanAllowedQuantity);
		}
		
		logger.appendChild(child11);
		
		//
		//Check Inventory Setup General Basic form with keeping Minimum Quantity field blank
		//
		child12=report.startTest("Check Inventory Setup General Basic form with keeping Minimum Quantity field blank");
		
		quantityCorrect = (String) jsonObject4.get("Quantity Correct");
		
		sellerInventorySetup.enterQuantity(quantityCorrect);
		child12.log(LogStatus.INFO, "Enter correct quantity in Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child12.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form with keeping Minimum Quantity field blank.");
		
		String mandatoryMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(mandatoryMinimumQuantity.contains("Mandatory"))
		{
			child12.log(LogStatus.PASS, "Seller is getting correct validation error message when keeping Minimum Quantity field blank");
			child12.log(LogStatus.PASS, mandatoryMinimumQuantity);
		}
		else
		{
			child12.log(LogStatus.FAIL, "Seller is not getting correct validation error message when keeping Minimum Quantity field blank");
			child12.log(LogStatus.FAIL, mandatoryMinimumQuantity);
		}
		
		logger.appendChild(child12);
		
		//
		//Check Inventory Setup General Basic form with entering Non-Numeric Minimum quantity in Minimum Quantity field
		//
		child13=report.startTest("Check Inventory Setup General Basic form with entering Non-Numeric Minimum quantity in Minimum Quantity field");
		
		minimumQuantitynonNumeric = (String) jsonObject4.get("Minimum Quantity Non-Numeric");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitynonNumeric);
		child13.log(LogStatus.INFO, "Enter Minimum Quantity Non-Numeric in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child13.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity Non-Numeric in Minimum Quantity field.");
		
		String nonNumericMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(nonNumericMinimumQuantity.contains("Integer"))
		{
			child13.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity Non-Numeric in Minimum Quantity field");
			child13.log(LogStatus.PASS, nonNumericMinimumQuantity);
		}
		else
		{
			child13.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity Non-Numeric in Minimum Quantity field");
			child13.log(LogStatus.FAIL, nonNumericMinimumQuantity);
		}
		
		logger.appendChild(child13);
		
		//
		//Check Inventory Setup General Basic form with entering less than allowed Minimum quantity in Minimum Quantity field
		//
		child14=report.startTest("Check Inventory Setup General Basic form with entering less than allowed Minimum quantity in Minimum Quantity field");
		
		minimumQuantityless = (String) jsonObject4.get("Minimum Quantity Less than Allowed");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantityless);
		child14.log(LogStatus.INFO, "Enter Minimum Quantity less than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child14.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity less than allowed in Minimum Quantity field.");
		
		String lessMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(lessMinimumQuantity.contains("Between 0 And 9999999999"))
		{
			child14.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity less than allowed in Minimum Quantity field");
			child14.log(LogStatus.PASS, lessMinimumQuantity);
		}
		else
		{
			child14.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity less than allowed in Minimum Quantity field");
			child14.log(LogStatus.FAIL, lessMinimumQuantity);
		}
		
		logger.appendChild(child14);
		
		//
		//Check Inventory Setup General Basic form with entering more than allowed Minimum quantity in Minimum Quantity field
		//
		child15=report.startTest("Check Inventory Setup General Basic form with entering more than allowed Minimum quantity in Minimum Quantity field");
		
		minimumQuantitymore = (String) jsonObject4.get("Minimum Quantity More than Allowed");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitymore);
		child15.log(LogStatus.INFO, "Enter Minimum Quantity more than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child15.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
		
		String moreMinimumQuantity = sellerInventorySetup.getValidationMinimumQuantity();
		
		if(moreMinimumQuantity.contains("Between 0 And 9999999999"))
		{
			child15.log(LogStatus.PASS, "Seller is getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field");
			child15.log(LogStatus.PASS, moreMinimumQuantity);
		}
		else
		{
			child15.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field");
			child15.log(LogStatus.FAIL, moreMinimumQuantity);
		}
		
		logger.appendChild(child15);
		
		//
		//Check Inventory Setup General Basic form with keeping Product SKU field blank
		//
		child16=report.startTest("Check Inventory Setup General Basic form with keeping Product SKU field blank");
		
		minimumQuantitycorrect = (String) jsonObject4.get("Minimum Quantity Correct");
		
		sellerInventorySetup.enterMinimumQuantity(minimumQuantitycorrect);
		child16.log(LogStatus.INFO, "Enter Minimum Quantity more than allowed in Minimum Quantity field.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child16.log(LogStatus.INFO, "Click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
		
		String mandatoryProductSKU = sellerInventorySetup.getValidationProductSKU();
		
		if(mandatoryProductSKU.contains("Mandatory")) 
		{
			child16.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button in Inventory Setup form when entering Minimum Quantity more than allowed in Minimum Quantity field.");
			child16.log(LogStatus.PASS, mandatoryProductSKU);
		}
		else
		{
			child16.log(LogStatus.FAIL, "Seller is not getting correct validation error message when entering Minimum Quantity more than allowed in Minimum Quantity field.");
			child16.log(LogStatus.FAIL, mandatoryProductSKU);
		}
		
		logger.appendChild(child16);
		
		//
		//Check Inventory Setup General Basic form with keeping Product Condition field blank
		//
		child17=report.startTest("Check Inventory Setup General Basic form with keeping Product Condition field blank");
		
		productSKU = (String) jsonObject4.get("Product SKU");
		
		sellerInventorySetup.enterProductSKU(productSKU);
		child17.log(LogStatus.INFO, "Enter Product SKU in Inventory Setup General Basic form");
		
		sellerInventorySetup.clickOnSubmitButton();
		child17.log(LogStatus.INFO, "Click On Submit Button with keeping Product Condition field blank");
		
		String validationProductCondition = sellerInventorySetup.getValidationProductCondition();
		
		if(validationProductCondition.contains("Mandatory"))
		{
			child17.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Submit Button with keeping Product Condition field blank.");
			child17.log(LogStatus.PASS, validationProductCondition);
		}
		else
		{
			child17.log(LogStatus.FAIL, "Seller is getting correct validation error message when click on Submit Button with keeping Product Condition field blank.");
			child17.log(LogStatus.FAIL, validationProductCondition);
		}
		
		logger.appendChild(child17);
		
		//
		//Check Inventory Setup General Basic form with Product Condition Selected
		//
		child18=report.startTest("Check Inventory Setup General Basic form with Product Condition Selected");
		
		productCondition = (String) jsonObject4.get("Production Condition");
		
		sellerInventorySetup.selectProductCondition(productCondition);
		child18.log(LogStatus.INFO, "Select Product Condition in Check Inventory Setup General Basic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child18.log(LogStatus.INFO, "Click On Submit Button with Product Condition Selected.");
		
		child18.log(LogStatus.PASS, "Seller redirects to Inventory Setup General English form successfully.");
			
		logger.appendChild(child18);
		
		//
		//Check Inventory Setup General English form with Product Display Title field blank
		//
		child19=report.startTest("Check Inventory Setup General English form with Product Display Title field blank");
		
		String productDisplayTitle = sellerInventorySetup.getProductDisplayTitle();
		child19.log(LogStatus.INFO, "Getting Product title to enter after validating product display title filed blank.");
		
		productDisplayTitleEmpty = (String) jsonObject4.get("Product Display Title Empty");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitleEmpty);
		child19.log(LogStatus.INFO, "Keep Product Display Title field Empty.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child19.log(LogStatus.INFO, "Click On Submit Button with Product Display Title field blank.");
		
		String validationTitle = sellerInventorySetup.getValidationProductDisplayTitle();
		
		if(validationTitle.contains("Mandatory"))
		{
			child19.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child19.log(LogStatus.PASS, validationTitle);
		}
		else
		{
			child19.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child19.log(LogStatus.FAIL, validationTitle);
		}
		
		logger.appendChild(child19);
		
		//
		//Check Inventory Setup General English form with correct Product Display Title
		//
		child20=report.startTest("Check Inventory Setup General English form with correct Product Display Title");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitle);
		child20.log(LogStatus.INFO, "Enter Product Display Title in Inventory Setup General English form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child20.log(LogStatus.INFO, "Click On Submit Button after entering Product Display Title.");
		
		child20.log(LogStatus.PASS, "Seller is able to enter Product Display Title successfully and redirects to next form.");
		
		logger.appendChild(child20);
		
		//
		//Check Inventory Setup General Arabic form with Product Display Title field blank
		//
		child21=report.startTest("Check Inventory Setup General Arabic form with Product Display Title field blank");
		
		//sellerInventorySetup.clickOnArabicLink();
		//child21.log(LogStatus.INFO, "Click on Arabic Link in Inventory Setup General Arabic form.");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitleEmpty);
		child21.log(LogStatus.INFO, "Keep Product Display Title field Empty.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child21.log(LogStatus.INFO, "Click On Submit Button with Product Display Title field blank.");
		
		String validationTitleArabic = sellerInventorySetup.getValidationProductDisplayTitle();
		
		if(validationTitleArabic.contains("Mandatory"))
		{
			child21.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child21.log(LogStatus.PASS, validationTitleArabic);
		}
		else
		{
			child21.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Submit Button with Product Display Title field blank.");
			child21.log(LogStatus.FAIL, validationTitle);
		}
		
		logger.appendChild(child21);
		
		//
		//Check Inventory Setup General Arabic form with correct Product Display Title
		//
		child22=report.startTest("Check Inventory Setup General Arabic form with correct Product Display Title");
		
		sellerInventorySetup.enterProductDisplayTitle(productDisplayTitle);
		child22.log(LogStatus.INFO, "Enter Product Display Title in Inventory Setup General Arabic form.");
		
		sellerInventorySetup.clickOnSubmitButton();
		child22.log(LogStatus.INFO, "Click On Submit Button after entering Product Display Title.");
		
		String successmsg = sellerInventorySetup.getSuccessMessage();
		
		if(successmsg.contains("Successful"))
		{
			child22.log(LogStatus.PASS, "Seller is able to enter Product Display Title and set up product in Inventory successfully.");
			child22.log(LogStatus.PASS, successmsg);
		}
		else
		{
			child22.log(LogStatus.FAIL, "Seller is not able to set up product in Inventory successfully.");
			child22.log(LogStatus.FAIL, successmsg);
		}
		
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
			logger.log(LogStatus.FAIL, "Seller is Not able to create Inventory for New Physical Product.");
			logger.log(LogStatus.FAIL, "Seller_InventorySetup_Failed", image);
		}
		//
		//End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();;
		//driver.close();
	}

}

