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
import com.Pages.SellerLoginPage;
import com.Pages.SellerProductSpecialOfferPricePage;
import com.Pages.SellerShopCreationPage;
//import com.Pages.UserCreationPage;
import com.Pages.UserAddtoCartPage;
import com.Pages.UserBuyNowPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserBuyNow {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8;

	String usernamecorrect, usernamewrong, passwordwrong, password, passwordcorrect, minQuantity, nameCorrect, addressLine1, state;
	String city,NonAlphanumericPostalcode,alphanumericPostalcode,nonValidPhoneNumber,validPhoneNumber,creditCardNumber,cardHolderName;
	String creditCardExpiryYear,cvvSecurityCode;

	JSONParser parser = new JSONParser();

	@Test
	public void userSearchforAddedProduct()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Buy Now for Added Product");

		//
		// --------------------------------------------------Opening User Login form.-------------------------------------------------------
		//
		child1 = report.startTest("Get the recently added product name");

		driver = BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");

		Object obj = parser.parse(new FileReader("src/test/java/JSONData/UserCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;

		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/UserAddtoCartData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;

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
		// login Page to click on login option.
		//
		SellerLoginPage sellerlogin = PageFactory.initElements(driver, SellerLoginPage.class);

		//
		// Created Page Object using Page Factory to call the functions from User Search Page.
		//
		UserAddtoCartPage addtocart = PageFactory.initElements(driver, UserAddtoCartPage.class);
		
		//
		// Created Page Object using Page Factory to call the functions from User Buy Now.
		//
		UserBuyNowPage userBuyNow = PageFactory.initElements(driver, UserBuyNowPage.class);

		//
		// Created object to call the functions from User Creation Page
		//
		// UserCreationPage usercreation = PageFactory.initElements(driver,
		// UserCreationPage.class);

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

		selleraddproduct.clickToggleIcon();
		child1.log(LogStatus.INFO,
				"Seller clicks On Toggle bar on Seller dashboard to open the grid to make Product Icon visible.");

		selleraddproduct.clickOnProductIcon();
		child1.log(LogStatus.INFO, "Seller clicks On Product Icon.");

		sellerspecialprice.clickOnMyInventory();
		child1.log(LogStatus.INFO, "Click On My Inventory link on the page.");

		String productName = addtocart.getProductName();
		child1.log(LogStatus.INFO, "Get the newest product name added by Seller.");

		child1.log(LogStatus.PASS, "Able to get correct product name to search in search bar successfully.");

		logger.appendChild(child1);

		//
		// Login to user's account and open homepage to search the product
		//
		child2 = report.startTest("Login to user's account and open homepage to search the product");

		addtocart.clickOnAvatar();
		child2.log(LogStatus.INFO, "Click on Avatar of the logged in Seller.");

		addtocart.clickOnLogout();
		child2.log(LogStatus.INFO, "Click on logout option of the logged in Seller.");

		child2.log(LogStatus.PASS, "Seller is able to logout successfully.");

		// usercreation.clickAcceptCookies();
		// child2.log(LogStatus.INFO, "Accept cookies on the page.");

		usernamecorrect = (String) jsonObject.get("Username Correct");

		sellerlogin.enterUserName(usernamecorrect);
		child2.log(LogStatus.INFO, "Enter User Name on the login form to login as a user in the application.");

		passwordcorrect = (String) jsonObject.get("Password Correct");

		sellerlogin.enterPassword(passwordcorrect);
		child2.log(LogStatus.INFO, "Enter correct Password on the login form to login as a user in the application.");

		sellerlogin.clickOnSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit button on login form to login.");

		child2.log(LogStatus.PASS, "User is able to login successfully.");
		
		addtocart.clickToggleBarIcon();
		child2.log(LogStatus.INFO, "Click on Toggle bar icon on dashboard of logged in user.");

		addtocart.clickOnLogoDashboard();
		child2.log(LogStatus.INFO, "Click on Dashboard link on logged in user.");

		child2.log(LogStatus.PASS, "User is able to open homepage to search product in search bar.");

		logger.appendChild(child2);

		//
		// Search the added product name
		//
		child3 = report.startTest("Search newly added product to buy");

		addtocart.enterProductinSearch(productName);
		child3.log(LogStatus.INFO, "User is entering new added product in search bar of homepage.");

		addtocart.clickOnSearchButton();
		child3.log(LogStatus.INFO, "User click on Search button to search product in search bar of homepage.");

		child3.log(LogStatus.INFO, "User is able to search the newly added product to buy.");

		logger.appendChild(child3);

		//
		// Add to Cart newly added product from product detail page
		//
		child4 = report.startTest("Add to Cart newly added product from product detail page");

		addtocart.clickOnProductImage();
		child4.log(LogStatus.INFO, "Click on product image on searched product page.");

		// minQuantity = (String) jsonObject1.get("Minimum Quantity Correct");

		// addtocart.enterQuantity(minQuantity);
		child4.log(LogStatus.INFO, "Enter quantity same as entered while creating product from seller.");
		
		userBuyNow.clickBuyNow();
		child4.log(LogStatus.INFO, "Click on Buy Now on searched product detail page.");

		logger.appendChild(child4);
		
		//
		//Check Shipping Summary
		//
		child5 = report.startTest("Check Shipping Summary");
		
		userBuyNow.clickContinueShippingSummary();
		child5.log(LogStatus.INFO, "Enter Valid Phone Number in Billing Address form.");
		
		child5.log(LogStatus.PASS, "User is able to enter Shipping Summary successfully.");
		
		logger.appendChild(child5);
		
		//
		//Selecting Credit Card in Payment Summary Screen
		//
		child6 = report.startTest("Selecting Credit Card in Payment Summary Screen");
		
		addtocart.selectCreditCardSelection();
		child6.log(LogStatus.INFO, "Selecting Credit Card in Payment Summary Screen.");
		
		addtocart.clickConfirmPayment();
		child6.log(LogStatus.INFO, "Click Confirm Payment in Payment Summary Screen.");
		
		child6.log(LogStatus.PASS, "User is able to Select Credit Card in Payment Summary screen.");
		
		logger.appendChild(child6);
		
		//
		//Enter Credit Card information in Credit Card Screen
		//
		child7 = report.startTest("Enter Credit Card information in Credit Card Screen");
		
		creditCardNumber = (String) jsonObject1.get("Credit Card Number");
		
		addtocart.enterCreditCardNumber(creditCardNumber);
		child7.log(LogStatus.INFO, "User is able to enter Credit Card number in Credit Card Screen.");
		
		cardHolderName = (String) jsonObject1.get("Card Holder Name");
		
		addtocart.enterCardHolderName(cardHolderName);
		child7.log(LogStatus.INFO, "User is able to enter Credit Card Holder Name in Credit Card Screen.");
		
		creditCardExpiryYear = (String) jsonObject1.get("Credit Card Expiry Year");
		
		addtocart.selectExpiryYear(creditCardExpiryYear);
		child7.log(LogStatus.INFO, "User is able to Select Credit Card Expiry Year in Credit Card Screen.");
		
		cvvSecurityCode = (String) jsonObject1.get("CVV Security Code");
		
		addtocart.enterCVVSecurityCode(cvvSecurityCode);
		child7.log(LogStatus.INFO, "User is able to enter CVV Security Code in Credit Card Screen.");
		
		addtocart.clickPayNow();
		child7.log(LogStatus.INFO, "User is able to click Pay Now in Credit Card Screen.");
		
		child7.log(LogStatus.PASS, "User is able to enter Credit Card information in Credit Card Screen.");
		
		logger.appendChild(child7);
		
		//
		//Check user is able to place order or not
		//
		child8 = report.startTest("Check user is able to place order or not");
		
		String successmessage = addtocart.getSuccessMessage();
		child8.log(LogStatus.INFO, "Get the Message coming on Payment screen.");
		
		child8.log(LogStatus.INFO, "Compare the Actual message coming on Payment screen and Expected Message.");		
		if(successmessage.contains("Congratulations"))
		{
			child8.log(LogStatus.PASS, "User is able to order Successfully."); 
			child8.log(LogStatus.PASS, successmessage);
		}
		else
		{
			child8.log(LogStatus.FAIL, "User is not able to order Successfully."); 
			child8.log(LogStatus.FAIL, successmessage);
		}
		
		logger.appendChild(child8);
		
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
			logger.log(LogStatus.FAIL, "User is Not able to checkout with Buy Now for added product.");
			logger.log(LogStatus.FAIL, "User_checkout_BuyNow", image);
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

