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
import com.Pages.SellerInventoryDownloadsforDigitalProductPage;
import com.Pages.SellerProductSpecialOfferPricePage;
import com.Pages.SellerShopCreationPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifySellerInventoryDownloadsforDigitalProduct {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11;

	String digitalDownloadType,downloadableLinkEmpty,downloadableLinkcorrect;

	JSONParser parser = new JSONParser();

	@Test
	public void verifySellerAddSpecialOffer()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("Seller Inventory-Check Downloads for Digital Product");

		Object obj = parser.parse(new FileReader("src/test/java/JSONData/SellerInventoryDownloadsforDigitalProductInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;

		// --------------------------------------------------Seller Add New Physical
		// Product form.-------------------------------------------------------

		child1 = report.startTest("Check opening Downloads form for Digital product in setting up Inventory");

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
		SellerProductSpecialOfferPricePage sellerspecialprice = PageFactory.initElements(driver, SellerProductSpecialOfferPricePage.class);
		
		//
		// Created Page Object using Page Factory to call the functions from
		// Seller Inventory Downloads for Digital Product Page.
		//
		SellerInventoryDownloadsforDigitalProductPage sellerDownload = PageFactory.initElements(driver, SellerInventoryDownloadsforDigitalProductPage.class);

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
		
		sellerDownload.clickOnLinkDownloads();
		child1.log(LogStatus.INFO, "Click On the Link Downloads.");
		
		child1.log(LogStatus.PASS, "Seller is able to open Downloads form successfully.");
		
		logger.appendChild(child1);
		
		//
		//Check attaching Digital Download File in Digital Download Type with Upload file
		//
		child2 = report.startTest("Check attaching Digital Download File in Digital Download Type with Upload file");
		
		sellerDownload.clickOnChooseFile();
		child2.log(LogStatus.INFO, "Click On the Link Downloads.");
		
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");
		child2.log(LogStatus.PASS, "Selle is able to Upload File for Inventory setup Download file for digital product successfully.");
		
		logger.appendChild(child2);
		
		//
		//Check Downloads form for Digital product with keeping Downloadable Link field blank
		//
		child3 = report.startTest("Check Downloads form for Digital product with keeping Downloadable Link field blank");
		
		digitalDownloadType = (String) jsonObject.get("Digital Download Type");
		
		sellerDownload.selectDownloadType(digitalDownloadType);
		child3.log(LogStatus.INFO, "Select Digital Download Link in Digital Download Type drop down.");
		
		downloadableLinkEmpty = (String) jsonObject.get("Downloadable Link Empty");
		
		sellerDownload.enterDownloadableLink(downloadableLinkEmpty);
		child3.log(LogStatus.INFO, "Keep Downloadable Link field empty.");
		
		sellerDownload.clickOnSaveChanges();
		child3.log(LogStatus.INFO, "Click On Save Changes button Keep Downloadable Link field empty.");
		
		String mandatoryDownloadableLink = sellerDownload.getValidationDownloadableLink();
		
		if(mandatoryDownloadableLink.contains("Mandatory"))
		{
			child3.log(LogStatus.PASS, "Seller is getting correct validation error message when click On Save Changes button Keep Downloadable Link field empty.");
			child3.log(LogStatus.PASS, mandatoryDownloadableLink);
		}
		else
		{
			child3.log(LogStatus.FAIL, "Seller is not getting correct validation error message when click On Save Changes button Keep Downloadable Link field empty.");
		}
		
		logger.appendChild(child3);
		
		//
		//Check Downloads form for Digital product with entering correct Downloadable Link
		//
		child4 = report.startTest("Check Downloads form for Digital product with entering correct Downloadable Link");
		
		downloadableLinkcorrect = (String) jsonObject.get("Downloadable Link Correct");
		
		sellerDownload.enterDownloadableLink(downloadableLinkcorrect);
		child4.log(LogStatus.INFO, "Enter correct Downloadable Link.");
		
		sellerDownload.clickOnSaveChanges();
		child4.log(LogStatus.INFO, "Click On Save Changes button with entering correct Downloadable Link.");
		
		String successMessage = sellerDownload.getSucessAlert();
		
		if(successMessage.contains("Successful"))
		{
			child4.log(LogStatus.PASS, "Seller is able to set up Downloads in Inventory Setup for Digital Products.");
			child4.log(LogStatus.PASS, successMessage);
		}
		else
		{
			child4.log(LogStatus.FAIL, "Seller is not able to set up Downloads in Inventory Setup for Digital Products.");
		}
		
		logger.appendChild(child4);
		
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
		driver.close();
	}

}
