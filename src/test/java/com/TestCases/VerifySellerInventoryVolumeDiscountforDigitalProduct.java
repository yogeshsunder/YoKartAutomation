package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.SellerAddNewProductPage;
import com.Pages.SellerProductSpecialOfferPricePage;
import com.Pages.SellerProductVolumeDiscountPage;
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerInventoryVolumeDiscountforDigitalProduct {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11, child12, child13;

	String minimumQuantityNonNumeric, minimumQuantityLess, minimumQuantityMore, minimumQuantityCorrect,
			nonNumericDiscountIn, lessDiscountIn, moreDiscountIn;
	String moreDiscountInthanActual, correctDiscount, quantitymorethanActual, minimumQuantityCorrectAnother, discountCorrectAnother;

	JSONParser parser = new JSONParser();

	@Test
	public void verifySellerAddVoumeDiscount()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("Seller Inventory Add Volume Discount for Digital Product");

		Object obj = parser
				.parse(new FileReader("src/test/java/JSONData/SellerInventoryAddVolumeDiscountInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;

		//
		// --------------------------------------------------Seller Add New Physical Product form.-------------------------------------------------------
		//
		child1 = report.startTest("Check opening Volume Discount form for product in setting up Inventory");

		driver = BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");

		//
		// Created Page Object using Page Factory to call the functions from Seller Shop
		// Creation Page to click on dashboard from top.
		//
		SellerShopCreationPage sellershopcreation = PageFactory.initElements(driver, SellerShopCreationPage.class);

		//
		// Created Page Object using Page Factory to call the functions from Seller Add
		// New Product Page to click on dashboard from top.
		//
		SellerAddNewProductPage selleraddproduct = PageFactory.initElements(driver, SellerAddNewProductPage.class);

		//
		// Created Page Object using Page Factory to call the functions from Seller
		// Product Special Offer Price Page to click on dashboard from top.
		//
		SellerProductSpecialOfferPricePage sellerspecialprice = PageFactory.initElements(driver,
				SellerProductSpecialOfferPricePage.class);

		//
		// Created Page Object using Page Factory to call the functions from Seller
		// Product Add Discount Page to click on dashboard from top.
		//
		SellerProductVolumeDiscountPage selleradddiscount = PageFactory.initElements(driver,
				SellerProductVolumeDiscountPage.class);

		//
		// Seller is trying to login
		//
		sellershopcreation.sellerLogin();
		child1.log(LogStatus.PASS, "Seller is able to login successfully.");

		//
		// Seller go to Dashboard
		//
		sellershopcreation.gotoDashboard();
		child1.log(LogStatus.INFO, "Seller is able to go to Dashboard.");

		//
		// Seller is clicking on Products icon from left panel of seller dashboard
		//
		selleraddproduct.clickOnProductIcon();
		child1.log(LogStatus.INFO, "Seller clicks On Product Icon.");

		sellerspecialprice.clickOnMyInventory();
		child1.log(LogStatus.INFO, "Click On My Inventory link on the page.");

		sellerspecialprice.clickOnEditInventory();
		child1.log(LogStatus.INFO, "Click On Edit Inventory Option in Edit Inventory page.");

		selleradddiscount.clickOnVolumeDiscount();
		child1.log(LogStatus.INFO, "Click On Volume Discount Option in Inventory Set up page.");

		selleradddiscount.clickOnAddNewVolumeDiscount();
		child1.log(LogStatus.INFO, "Click On Add New Volume Discount in Inventory Set up page.");

		child1.log(LogStatus.PASS, "Seller is able to open Volume Discount form for product in setting up Inventory.");

		logger.appendChild(child1);

		//
		// Check Volume Discount form with keeping Minimum Quantity blank
		//
		child2 = report.startTest("Check Volume Discount form with keeping Minimum Quantity blank");

		selleradddiscount.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click On Save Changes button with keeping Minimum Quantity blank.");

		String mandatoryMinimumQuantity = selleradddiscount.getVlidationMinimumQuantity();

		if (mandatoryMinimumQuantity.contains("Mandatory")) {
			child2.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with keeping Minimum Quantity blank.");
			child2.log(LogStatus.PASS, mandatoryMinimumQuantity);
		} else {
			child2.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with keeping Minimum Quantity blank.");
			child2.log(LogStatus.FAIL, mandatoryMinimumQuantity);
		}

		logger.appendChild(child2);

		//
		// Check Volume Discount form with entering Non-Numeric Minimum Quantity
		//
		child3 = report.startTest("Check Volume Discount form with entering Non-Numeric Minimum Quantity");

		minimumQuantityNonNumeric = (String) jsonObject.get("Minimum Quantity Non-Numeric");

		selleradddiscount.enterMinimumQuantity(minimumQuantityNonNumeric);
		child3.log(LogStatus.INFO, "Enter Non Numeric Minimum Quantity.");

		selleradddiscount.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric Minimum Quantity.");

		String nonNumericMinimumQuantity = selleradddiscount.getVlidationMinimumQuantity();

		if (nonNumericMinimumQuantity.contains("Integer")) {
			child3.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering Non-Numeric Minimum Quantity.");
			child3.log(LogStatus.PASS, nonNumericMinimumQuantity);
		} else {
			child3.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering Non-Numeric Minimum Quantity.");
			child3.log(LogStatus.FAIL, nonNumericMinimumQuantity);
		}

		logger.appendChild(child3);

		//
		// Check Volume Discount form with entering Minimum Quantity Less than Allowed
		//
		child4 = report.startTest("Check Volume Discount form with entering Minimum Quantity Less than Allowed");

		minimumQuantityLess = (String) jsonObject.get("Minimum Quantity Less than Allowed");

		selleradddiscount.enterMinimumQuantity(minimumQuantityLess);
		child4.log(LogStatus.INFO, "Enter Minimum Quantity less than Allowed.");

		selleradddiscount.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button with entering Minimum Quantity less than Allowed.");

		String lessMinimumQuantity = selleradddiscount.getVlidationMinimumQuantity();

		if (lessMinimumQuantity.contains("Between 0 And 9999999999")) {
			child4.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering Minimum Quantity less than Allowed.");
			child4.log(LogStatus.PASS, lessMinimumQuantity);
		} else {
			child4.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering Minimum Quantity less than Allowed.");
			child4.log(LogStatus.FAIL, lessMinimumQuantity);
		}

		logger.appendChild(child4);

		//
		// Check Volume Discount form with entering Minimum Quantity More than Allowed
		//
		child5 = report.startTest("Check Volume Discount form with entering Minimum Quantity More than Allowed");

		minimumQuantityMore = (String) jsonObject.get("Minimum Quantity More than Allowed");

		selleradddiscount.enterMinimumQuantity(minimumQuantityMore);
		child5.log(LogStatus.INFO, "Enter Minimum Quantity More than Allowed.");

		selleradddiscount.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button with entering Minimum Quantity More than Allowed.");

		String moreMinimumQuantity = selleradddiscount.getVlidationMinimumQuantity();

		if (moreMinimumQuantity.contains("Between 0 And 9999999999")) {
			child5.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering Minimum Quantity More than Allowed.");
			child5.log(LogStatus.PASS, moreMinimumQuantity);
		} else {
			child5.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering Minimum Quantity More than Allowed.");
			child5.log(LogStatus.FAIL, moreMinimumQuantity);
		}

		logger.appendChild(child5);

		//
		// Check Volume Discount form with keeping Discount In (%) field blank
		//
		child6 = report.startTest("Check Volume Discount form with keeping Discount In (%) field blank");

		minimumQuantityCorrect = (String) jsonObject.get("Minimum Quantity Correct");

		selleradddiscount.enterMinimumQuantity(minimumQuantityCorrect);
		child6.log(LogStatus.INFO, "Enter correct Minimum Quantity");

		selleradddiscount.clickOnSaveChanges();
		child6.log(LogStatus.INFO, "Click On Save Changes button with keeping Discount In (%) field blank.");

		String mandatoryDiscountIn = selleradddiscount.getValidationDiscountIn();

		if (mandatoryDiscountIn.contains("Mandatory")) {
			child6.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with keeping Discount In (%) field blank.");
			child6.log(LogStatus.PASS, mandatoryDiscountIn);
		} else {
			child6.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with keeping Discount In (%) field blank.");
			child6.log(LogStatus.FAIL, mandatoryDiscountIn);
		}

		logger.appendChild(child6);

		//
		// Check Volume Discount form with entering Non-Numeric Discount In (%)
		//
		child7 = report.startTest("Check Volume Discount form with entering Non-Numeric Discount In (%)");

		nonNumericDiscountIn = (String) jsonObject.get("Discount In Non-Numeric");

		selleradddiscount.enterDiscountIn(nonNumericDiscountIn);
		child7.log(LogStatus.INFO, "Enter Non Numeric Discount In");

		selleradddiscount.clickOnSaveChanges();
		child7.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric Discount In (%).");

		String nonNumericDiscountIn = selleradddiscount.getValidationDiscountIn();

		if (nonNumericDiscountIn.contains("Numeric")) {
			child7.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering Non-Numeric Discount In (%).");
			child7.log(LogStatus.PASS, nonNumericDiscountIn);
		} else {
			child7.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering Non-Numeric Discount In (%).");
			child7.log(LogStatus.FAIL, nonNumericDiscountIn);
		}

		logger.appendChild(child7);

		//
		// Check Volume Discount form with entering Discount In (%) less than allowed
		//
		child8 = report.startTest("Check Volume Discount form with entering Discount In (%) less than allowed");

		lessDiscountIn = (String) jsonObject.get("Discount In Less than Allowed");

		selleradddiscount.enterDiscountIn(lessDiscountIn);
		child8.log(LogStatus.INFO, "Enter Discount In less than allowed");

		selleradddiscount.clickOnSaveChanges();
		child8.log(LogStatus.INFO, "Click On Save Changes button with entering Discount In less than allowed.");

		String lessDiscountIn = selleradddiscount.getValidationDiscountIn();

		if (lessDiscountIn.contains("Between 0 And 9999999999")) {
			child8.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering Discount In less than allowed.");
			child8.log(LogStatus.PASS, lessDiscountIn);
		} else {
			child8.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering Discount In less than allowed.");
			child8.log(LogStatus.FAIL, lessDiscountIn);
		}

		logger.appendChild(child8);

		//
		// Check Volume Discount form with entering Discount In (%) more than allowed
		//
		child9 = report.startTest("Check Volume Discount form with entering Discount In (%) more than allowed");

		moreDiscountIn = (String) jsonObject.get("Discount In More than Allowed");

		selleradddiscount.enterDiscountIn(moreDiscountIn);
		child9.log(LogStatus.INFO, "Enter Discount In more than allowed");

		selleradddiscount.clickOnSaveChanges();
		child9.log(LogStatus.INFO, "Click On Save Changes button with entering Discount In more than allowed.");

		child9.log(LogStatus.FAIL,
				"Seller is not getting correct validation error message when click On Save Changes button with entering Discount In more than allowed.");

		// Will make this code active when the validation error message will apply as
		// there is no such validation there on the form right now.
		/*
		 * String moreDiscountIn = selleradddiscount.getValidationDiscountIn();
		 * 
		 * if(moreDiscountIn.contains("Between 0 And 9999999999")) {
		 * child9.log(LogStatus.PASS,
		 * "Seller is getting validation error message when click On Save Changes button with entering Discount In more than allowed."
		 * ); child9.log(LogStatus.PASS, moreDiscountIn); } else {
		 * child9.log(LogStatus.FAIL,
		 * "Seller is not getting validation error message when click On Save Changes button with entering Discount In more than allowed."
		 * ); child9.log(LogStatus.FAIL, moreDiscountIn); }
		 */

		logger.appendChild(child9);

		//
		// Check Volume Discount form with entering Discount In (%) correct
		//
		child10 = report.startTest("Check Volume Discount form with entering Discount In (%) correct");

		correctDiscount = (String) jsonObject.get("Discount Correct");

		selleradddiscount.enterDiscountIn(correctDiscount);
		child10.log(LogStatus.INFO, "Enter correct Discount.");

		selleradddiscount.clickOnSaveChanges();
		child10.log(LogStatus.INFO, "Click On Save Changes button with entering correct Discount.");

		String createdDiscount = selleradddiscount.getCreatedDiscount();

		if (createdDiscount.contains(minimumQuantityCorrect)) {
			child10.log(LogStatus.PASS,
					"Seller is able to add Volume Discount successfully when click On Save Changes button with entering correct Discount and Minimum Quantity.");
			child10.log(LogStatus.PASS, createdDiscount);
		} else {
			child10.log(LogStatus.FAIL,
					"Seller is not able to add Volume Discount successfully when click On Save Changes button with entering correct Discount and Minimum Quantity.");
			child10.log(LogStatus.FAIL, createdDiscount);
		}

		logger.appendChild(child10);

		//
		// Check Volume Discount form with entering Minimum Quantity more than actual
		// quantity of the product
		//
		child11 = report.startTest(
				"Check Volume Discount form with entering Minimum Quantity more than actual quantity of the product");

		selleradddiscount.clickOnAddNewVolumeDiscount();
		child11.log(LogStatus.INFO, "Click On Add New Discount top button.");

		quantitymorethanActual = (String) jsonObject.get("Minimum Quantity More than Actual Quantity of Product");

		selleradddiscount.enterMinimumQuantity(quantitymorethanActual);
		child11.log(LogStatus.INFO, "Enter Minimum Quantity more than actual quantity of the product.");

		selleradddiscount.enterDiscountIn(correctDiscount);
		child11.log(LogStatus.INFO, "Enter correct Discount.");

		selleradddiscount.clickOnSaveChanges();
		child11.log(LogStatus.INFO,
				"Click on Save Changes button with entering Minimum Quantity more than actual quantity of the product.");

		String quantityMoreThanStock = selleradddiscount.getValidationForm();

		if (quantityMoreThanStock.contains("More Than The Stock")) {
			child11.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click on Save Changes button with entering Minimum Quantity more than actual quantity of the product.");
			child11.log(LogStatus.PASS, quantityMoreThanStock);
		} else {
			child11.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click on Save Changes button with entering Minimum Quantity more than actual quantity of the product.");
			child11.log(LogStatus.FAIL, quantityMoreThanStock);
		}

		logger.appendChild(child11);

		//
		// Check Volume Discount form with entering Minimum Quantity Already Added for another volume discount
		//
		child12 = report.startTest(
				"Check Volume Discount form with entering Minimum Quantity Already Added for another volume discount");

		selleradddiscount.enterMinimumQuantity(minimumQuantityCorrect);
		child12.log(LogStatus.INFO,
				"Enter Minimum Quantity same as Minimum Quantity Already Added for another volume discount");

		selleradddiscount.enterDiscountIn(correctDiscount);
		child12.log(LogStatus.INFO, "Enter correct Discount.");

		selleradddiscount.clickOnSaveChanges();
		child12.log(LogStatus.INFO, "Click on Save Changes button with entering Minimum Quantity same as Minimum Quantity Already Added for another volume discount");

		String quantityDuplicate = selleradddiscount.getValidationForm();

		
		 if(quantityDuplicate.contains("Already Added")) 
		 { 
			 child12.log(LogStatus.PASS, "Seller is getting correct validation error message when click on Save Changes button with entering Minimum Quantity same as Minimum Quantity Already Added for another volume discount."); 
			 child12.log(LogStatus.PASS, quantityDuplicate); 
		 } 
		 else 
		 {
			 child12.log(LogStatus.FAIL,"Seller is not getting correct validation error message when click on Save Changes button with entering Minimum Quantity same as Minimum Quantity Already Added for another volume discount."); 
			 child12.log(LogStatus.FAIL, quantityDuplicate); 
		 }	

		logger.appendChild(child12);
		
		//
		// Check Volume Discount form with entering another Minimum Quantity Added with another volume discount for another volume discount
		//
		child13 = report.startTest("Check Volume Discount form with entering another Minimum Quantity Added with another volume discount for another volume discount");
		
		minimumQuantityCorrectAnother = (String) jsonObject.get("Minimum Quantity Correct Another");
		
		selleradddiscount.enterMinimumQuantity(minimumQuantityCorrectAnother);
		child13.log(LogStatus.INFO, "Enter another valid Minimum Quantity for another volume discount");
		
		discountCorrectAnother = (String) jsonObject.get("Discount Correct Another");

		selleradddiscount.enterDiscountIn(discountCorrectAnother);
		child13.log(LogStatus.INFO, "Enter another correct Discount.");
		
		Thread.sleep(5000);

		selleradddiscount.clickOnSaveChanges();
		child13.log(LogStatus.INFO, "Click on Save Changes button with entering  another valid Minimum Quantity for another volume discount.");
		
		String createdanotherDiscount = selleradddiscount.getCreatedDiscount();

		if (createdanotherDiscount.contains(minimumQuantityCorrectAnother)) 
		{
			child13.log(LogStatus.PASS,	"Seller is able to add another Volume Discount successfully when click On Save Changes button with entering correct Discount and Minimum Quantity.");
			child13.log(LogStatus.PASS, createdanotherDiscount);
		} 
		else 
		{
			child13.log(LogStatus.FAIL, "Seller is not able to add another Volume Discount successfully when click On Save Changes button with entering correct Discount and Minimum Quantity.");
			child13.log(LogStatus.FAIL, createdanotherDiscount);
		}
		
		//selleradddiscount.clickOnCloseIcon();
		//child13.log(LogStatus.INFO, "Click On Close Icon to close the Volume Discount form.");
		
		logger.appendChild(child13);
		
		//Links are pending as not working as expected for now.

	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		//
		// If test is getting failed then take the screen shot and put it in Automation
		// Report.
		//
		if (result.getStatus() == ITestResult.FAILURE) {
			String screenshot_path = Utility.captureScreenshot(driver, result.getName());
			String image = logger.addScreenCapture(screenshot_path);
			logger.log(LogStatus.FAIL, "Seller is Not able to Add Volume Discount for New Physical Product.");
			logger.log(LogStatus.FAIL, "Seller_ AddVolumeDiscount_Failed", image);
		}
		//
		// End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();
		;
		driver.close();
	}

}
