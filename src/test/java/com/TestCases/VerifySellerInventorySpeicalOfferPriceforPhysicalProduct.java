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
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerInventorySpeicalOfferPriceforPhysicalProduct {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11;

	String specialPriceNonNumeric, specialPriceLess, specialPriceMore, specialPriceCorrect, secondPriceCorrect;

	JSONParser parser = new JSONParser();

	@Test
	public void verifySellerAddSpecialOffer()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("Seller Inventory Add Special Price for Physical Product");

		Object obj = parser.parse(new FileReader("src/test/java/JSONData/SellerInventorySpecialPriceInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;

		// --------------------------------------------------Seller Add New Physical
		// Product form.-------------------------------------------------------

		child1 = report.startTest("Check opening Special Price form for product in setting up Inventory");

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

		sellerspecialprice.click_Speical_Price();
		child1.log(LogStatus.INFO, "Click On Speical Price Option in Inventory Set up page.");

		sellerspecialprice.clickOnAddNewSpecialPrice();
		child1.log(LogStatus.INFO, "Click On Add New Special Price in Inventory Set up page.");

		child1.log(LogStatus.INFO, "Seller is able to open Special Price form for product in setting up Inventory.");

		logger.appendChild(child1);

		//
		// Check Special Price form with keeping Special Price field blank
		//
		child2 = report.startTest("Check Special Price form with keeping Special Price field blank");

		sellerspecialprice.clickOnSaveChanges();
		child2.log(LogStatus.INFO, "Click On Save Changes button with Special Price field blank.");

		String mandatoryPrice = sellerspecialprice.getValidationSpecialPrice();

		if (mandatoryPrice.contains("Mandatory")) {
			child2.log(LogStatus.PASS,
					"Seller is getting correct validation message when click On Save Changes button with keeping Special Price field blank.");
			child2.log(LogStatus.PASS, mandatoryPrice);
		} else {
			child2.log(LogStatus.FAIL,
					"Seller is not getting correct validation message when click On Save Changes button with keeping Special Price field blank.");
			child2.log(LogStatus.FAIL, mandatoryPrice);
		}

		logger.appendChild(child2);

		//
		// Check Special Price form with entering Non-Numeric Special Price
		//
		child3 = report.startTest("Check Special Price form with entering Non-Numeric Special Price");

		specialPriceNonNumeric = (String) jsonObject.get("Special Price Non-Numeric");

		sellerspecialprice.enterSpecialPrice(specialPriceNonNumeric);
		child3.log(LogStatus.INFO, "Enter Non-Numeric Special Price in the form.");

		sellerspecialprice.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click On Save Changes button with entering Non-Numeric Special Price.");

		String nonNumericPrice = sellerspecialprice.getValidationSpecialPrice();

		if (nonNumericPrice.contains("Numeric")) {
			child3.log(LogStatus.PASS,
					"Seller is getting correct validation message when click On Save Changes button with entering Non-Numeric Special Price.");
			child3.log(LogStatus.PASS, nonNumericPrice);
		} else {
			child3.log(LogStatus.FAIL,
					"Seller is not getting correct validation message click On Save Changes button with entering Non-Numeric Special Price.");
			child3.log(LogStatus.FAIL, nonNumericPrice);
		}

		logger.appendChild(child3);

		//
		// Check Special Price form with entering Less Than Allowed Special Price
		//
		child4 = report.startTest("Check Special Price form with entering Less Than Allowed Special Price");

		specialPriceLess = (String) jsonObject.get("Special Price Less Than Allowed");

		sellerspecialprice.enterSpecialPrice(specialPriceLess);
		child4.log(LogStatus.INFO, "Enter Special Price Less Than Allowed in the form.");

		sellerspecialprice.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button with entering Special Price Less Than Allowed.");

		String priceLess = sellerspecialprice.getValidationSpecialPrice();

		if (priceLess.contains("Between 0 And 9999999999")) {
			child4.log(LogStatus.PASS,
					"Seller is getting correct validation message when click On Save Changes button with entering Special Price Less than allowed.");
			child4.log(LogStatus.PASS, priceLess);
		} else {
			child4.log(LogStatus.FAIL,
					"Seller is not getting correct validation message click On Save Changes button with entering Special Price Less than allowed.");
			child4.log(LogStatus.FAIL, priceLess);
		}

		logger.appendChild(child4);

		//
		// Check Special Price form with entering More Than Allowed Special Price
		//
		child5 = report.startTest("Check Special Price form with entering More Than Allowed Special Price");

		specialPriceMore = (String) jsonObject.get("Special Price More Than Allowed");

		sellerspecialprice.enterSpecialPrice(specialPriceMore);
		child5.log(LogStatus.INFO, "Enter Special Price More Than Allowed in the form.");

		sellerspecialprice.clickOnSaveChanges();
		child5.log(LogStatus.INFO, "Click On Save Changes button with entering Special Price More Than Allowed.");

		String priceMore = sellerspecialprice.getValidationSpecialPrice();

		if (priceMore.contains("Between 0 And 9999999999")) {
			child5.log(LogStatus.PASS,
					"Seller is getting correct validation message when click On Save Changes button with entering Special Price More than allowed.");
			child5.log(LogStatus.PASS, priceMore);
		} else {
			child5.log(LogStatus.FAIL,
					"Seller is not getting correct validation message click On Save Changes button with entering Special Price More than allowed.");
			child5.log(LogStatus.FAIL, priceMore);
		}

		logger.appendChild(child5);

		//
		// Check Special Price form with keeping Price Start Date field blank
		//
		child6 = report.startTest("Check Special Price form with keeping Price Start Date field blank");

		specialPriceCorrect = (String) jsonObject.get("Special Price Correct");

		sellerspecialprice.enterSpecialPrice(specialPriceCorrect);
		child6.log(LogStatus.INFO, "Enter correct Special Price in the form.");

		sellerspecialprice.clickOnSaveChanges();
		child6.log(LogStatus.INFO,
				"Click On Save Changes button with entering correct Special Price and keeping Price Start Date field blank.");

		String mandatoryPriceStartDate = sellerspecialprice.getValidationPriceStartDate();

		if (mandatoryPriceStartDate.contains("Mandatory")) {
			child6.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with entering correct Special Price and keeping Price Start Date field blank.");
			child6.log(LogStatus.PASS, mandatoryPriceStartDate);
		} else {
			child6.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with entering correct Special Price and keeping Price Start Date field blank.");
			child6.log(LogStatus.FAIL, mandatoryPriceStartDate);
		}

		logger.appendChild(child6);

		//
		// Check Special Price form with keeping Price End Date field blank
		//
		child7 = report.startTest("Check Special Price form with keeping Price End Date field blank");

		sellerspecialprice.clickOnPriceStartDate();
		child7.log(LogStatus.INFO, "Click On Price Start Date field to open Calendar in Special Price form.");

		sellerspecialprice.clickOnTodayInCalendar();
		child7.log(LogStatus.INFO,
				"Click On Today's date In Calendar in Price Start Date field in Special Price form.");

		sellerspecialprice.clickOnSaveChanges();
		child7.log(LogStatus.INFO, "Click On Save Changes button with keeping Price End Date field blank.");

		String mandatoryPriceEndDate = sellerspecialprice.getValidationPriceEndDate();

		if (mandatoryPriceEndDate.contains("Mandatory")) {
			child6.log(LogStatus.PASS,
					"Seller is getting correct validation error message when click On Save Changes button with keeping Price End Date field blank.");
			child6.log(LogStatus.PASS, mandatoryPriceEndDate);
		} else {
			child6.log(LogStatus.FAIL,
					"Seller is not getting correct validation error message when click On Save Changes button with keeping Price End Date field blank.");
			child6.log(LogStatus.FAIL, mandatoryPriceEndDate);
		}

		logger.appendChild(child7);

		//
		// Check Special Price form with entering same date in Price Start Date field and Price End Date field
		//
		child8 = report.startTest("Check Special Price form with entering same date in Price Start Date field and Price End Date field");

		sellerspecialprice.clickOnPriceEndDate();
		child8.log(LogStatus.INFO, "Click On Price Start Date field to open Calendar in Special Price form.");

		sellerspecialprice.clickOnTodayInCalendar();
		child8.log(LogStatus.INFO, "Click On Today's date In Calendar in Price End Date field in Special Price form.");

		sellerspecialprice.clickOnSaveChanges();
		child8.log(LogStatus.INFO,"Click On Save Changes button with entering same date in Price Start Date field and Price End Date field.");

		String firstSpecialPrice = sellerspecialprice.getFirstSpecialPrice();

		if (firstSpecialPrice.contains(specialPriceCorrect)) 
		{
			child8.log(LogStatus.PASS,"Seller is able to Add New Special Price when entering same date in Price Start Date field and Price End Date field.");
			child8.log(LogStatus.PASS, firstSpecialPrice);
		} 
		else 
		{
			child8.log(LogStatus.FAIL,"Seller is not able to Add New Special Price when entering same date in Price Start Date field and Price End Date field.");
			child8.log(LogStatus.FAIL, firstSpecialPrice);
		}

		logger.appendChild(child8);

		//
		//Check Special Price form with entering Price End Date less than Price	StartDate
		//
		
		  child9=report.startTest("Check Special Price form with entering Price End Date less than Price Start Date");
		  
		  sellerspecialprice.clickOnManageSpecialPrice();
		  child9.log(LogStatus.INFO,"Click On Manage Special Price at the Top.");
		  
		  secondPriceCorrect = (String) jsonObject.get("Second Price Correct");
		  
		  sellerspecialprice.enterSpecialPrice(secondPriceCorrect);
		  child9.log(LogStatus.INFO, "Enter correct Special Price in the form.");
		  
		  sellerspecialprice.clickOnPriceStartDate(); 
		  child9.log(LogStatus.INFO,"Click On Price Start Date field to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnTomorrowInCalendar();
		  child9.log(LogStatus.INFO,"Click On Tomorrow In Start Date Calendar.");
		  
		  sellerspecialprice.clickOnPriceEndDate(); 
		  child9.log(LogStatus.INFO,"Click On Price End Date to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnTodayInCalendar();
		  child9.log(LogStatus.INFO,"Click On Today In End Date Calendar.");
		  
		  sellerspecialprice.click_Save_Changes_Manage(); 
		  child9.log(LogStatus.INFO,"Click On Save Changes button with entering Price End Date less than Price Start Date.");
		  
		  String endDateLess = sellerspecialprice.getValidationTop();
		  child9.log(LogStatus.INFO,"Get the Validation error message on Price End Date.");
		  
		  child9.log(LogStatus.INFO, "Validate the error message on Price End Date.");
		  if(endDateLess.contains("Invalid")) 
		  { 
			  child9.log(LogStatus.PASS,"Seller is getting correct validation error message when click On Save Changes button with entering Price End Date less than Price Start Date."); 
			  child9.log(LogStatus.PASS, endDateLess); 
		  } 
		  else 
		  {
			  child9.log(LogStatus.FAIL,"Seller is not getting correct validation error message when click On Save Changes button with entering Price End Date less than Price Start Date."); 
		  }
		 
		 
		  logger.appendChild(child9);
		  
		  //
		  //Check Special Price form with entering Price End Date more than Price Start Date 
		  //
		  child10=report.startTest("Check Special Price form with entering Price End Date more than Price Start Date");
		  
		  sellerspecialprice.clickOnPriceStartDate(); 
		  child10.log(LogStatus.INFO,"Click On Price Start Date field to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnTomorrowInCalendar(); 
		  child10.log(LogStatus.INFO,"Click On Tomorrow In Calendar in Price Start Date field in Special Price form");
		  
		  sellerspecialprice.clickOnPriceEndDate(); 
		  child10.log(LogStatus.INFO,"Click On Price End Date to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnDayAfterTomorrowInCalendar();
		  child10.log(LogStatus.INFO, "Click On Day After Tomorrow In Calendar.");
		  
		  sellerspecialprice.click_Save_Changes_Manage();
		  child10.log(LogStatus.INFO,"Click On Save Changes button with entering Price End Date more than Price Start Date .");
		  
		  String secondSpecialPrice = sellerspecialprice.getSecond_Special_Price();
		  
		  if(secondSpecialPrice.contains(secondPriceCorrect)) 
		  {
		  child10.log(LogStatus.PASS,"Seller is able to add special price when click On Save Changes button with entering Price End Date more than Price Start Date."); 
		  child10.log(LogStatus.PASS, secondSpecialPrice); 
		  } 
		  else 
		  {
		  child10.log(LogStatus.FAIL,"Seller is not able to add special price when click On Save Changes button with entering Price End Date more than Price Start Date.");  
		  child10.log(LogStatus.FAIL, secondSpecialPrice); }
		  
		  logger.appendChild(child10);
		  
		  //
		  //Check Special Price form with entering Speical Price for the Date for  which Special Price is already added
		  //
		  child11=report.startTest("Check Special Price form with entering Speical Price for the Date for which Special Price is already added");
		  
		  //sellerspecialprice.clickOnAddNewSpecialPrice();
		  //child11.log(LogStatus.INFO,"Click On Add New Special Price at the Top.");
		  
		  sellerspecialprice.clickOnPriceStartDate_waited(); 
		  child11.log(LogStatus.INFO,"Click On Price Start Date field to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnTomorrowInCalendar(); 
		  child11.log(LogStatus.INFO,"Click On Tomorrow In Start Date Calendar.");
		
		  sellerspecialprice.clickOnPriceEndDate();
		  child11.log(LogStatus.INFO,"Click On Price End Date to open Calendar in Special Price form.");
		  
		  sellerspecialprice.clickOnDayAfterTomorrowInCalendar();
		  child11.log(LogStatus.INFO, "Click On Day After Tomorrow In Calendar.");
		  
		  sellerspecialprice.enterSpecialPrice(specialPriceCorrect);
		  child11.log(LogStatus.INFO, "Enter correct Special Price in the form.");
		  
		  sellerspecialprice.click_Save_Changes_Manage(); 
		  child11.log(LogStatus.INFO,"Click On Save Changes button with entering Speical Price for the Date for which Special Price is already added.");
		  
		  String alreadyAddedPrice = sellerspecialprice.getValidationTopDuplicate();
		  
		  if(alreadyAddedPrice.contains("Already Added")) 
		  { 
			  child11.log(LogStatus.PASS,"Seller is getting correct validation error message when click on Save Changes button with entering Speical Price for the Date for which Special Price is already added."); 
			  child11.log(LogStatus.PASS, alreadyAddedPrice); 
		  } 
		  else 
		  {
			  child11.log(LogStatus.FAIL,"Seller is not getting correct validation error message when click on Save Changes button with entering Speical Price for the Date for which Special Price is already added."); 
			  child11.log(LogStatus.FAIL, alreadyAddedPrice); 
		  }
		 
		  
		  //sellerspecialprice.clickOnCancelButton(); 
		  //child11.log(LogStatus.INFO,"Click On Cancel Button to close the add special price pop up.");
		  
		  logger.appendChild(child11);
		 
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
			logger.log(LogStatus.FAIL, "Seller is Not able to Add Special Offer for New Physical Product.");
			logger.log(LogStatus.FAIL, "Seller_ AddSpecialOffer_Failed", image);
		}
		//
		// End the test in Automation Report and generate the report
		//
		report.endTest(logger);
		report.flush();
		;
		//driver.close();
	}

}
