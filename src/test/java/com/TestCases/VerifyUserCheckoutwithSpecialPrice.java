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
import com.Pages.UserAddtoCartPage;
import com.Pages.UserBuyNowPage;
import com.Pages.UserCheckoutwithSpecialPricePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserCheckoutwithSpecialPrice {
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8;

	String usernamecorrect, usernamewrong, passwordwrong, password, passwordcorrect, minQuantity, nameCorrect, addressLine1, state;
	String city,NonAlphanumericPostalcode,alphanumericPostalcode,nonValidPhoneNumber,validPhoneNumber,creditCardNumber,cardHolderName;
	String creditCardExpiryYear,cvvSecurityCode;

	JSONParser parser = new JSONParser();

	@Test
	public void userCheckoutwithSpecialPrice() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Checkout with Special Price");

		//
		// --------------------------------------------------Opening User Login form.-------------------------------------------------------
		//
		child1 = report.startTest("Get the Special Price added to the Product");

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
		SellerProductSpecialOfferPricePage sellerspecialprice = PageFactory.initElements(driver, SellerProductSpecialOfferPricePage.class);

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
		// Created Page Object using Page Factory to call the functions from User Buy Now.
		//
		UserCheckoutwithSpecialPricePage userSpecialPrice = PageFactory.initElements(driver, UserCheckoutwithSpecialPricePage.class);

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
		//Seller is clicking on Products icon from left panel of seller dashboard
		//

		selleraddproduct.clickToggleIcon();
		child1.log(LogStatus.INFO, "Seller clicks On Toggle bar on Seller dashboard to open the grid to make Product Icon visible.");

		selleraddproduct.clickOnProductIcon();
		child1.log(LogStatus.INFO, "Seller clicks On Product Icon.");

		sellerspecialprice.clickOnMyInventory();
		child1.log(LogStatus.INFO, "Click On My Inventory link on the page.");
		
		String productName = addtocart.getProductName();
		child1.log(LogStatus.INFO, "Get the newest product name added by Seller.");

		child1.log(LogStatus.PASS, "Able to get correct product name to search in search bar successfully.");
		
		sellerspecialprice.clickOnEditInventory();
		child1.log(LogStatus.INFO, "Click On Edit Inventory Option in Edit Inventory page.");
		
		sellerspecialprice.clickOnSpeicalPrice();
		child1.log(LogStatus.INFO, "Click On Speical Price Option in Inventory Set up page.");
		
		String actualSpecialPrice = userSpecialPrice.getActualSpecialPrice();
		child1.log(LogStatus.INFO, "Get the Actual special price of the product.");
		
		child1.log(LogStatus.PASS, "Able to get actual special price of the product.");
		
		logger.appendChild(child1);
		
		//
		//Login to user's account and open homepage to search the product
		//
		child2 = report.startTest("Login to user's account and open homepage to search the product");

		addtocart.clickOnAvatar();
		child2.log(LogStatus.INFO, "Click on Avatar of the logged in Seller.");

		addtocart.clickOnLogout();
		child2.log(LogStatus.INFO, "Click on logout option of the logged in Seller.");

		child2.log(LogStatus.PASS, "Seller is able to logout successfully.");

		//usercreation.clickAcceptCookies();
		//child2.log(LogStatus.INFO, "Accept cookies on the page.");

		usernamecorrect = (String) jsonObject.get("Username Correct");

		sellerlogin.enterUserName(usernamecorrect);
		child2.log(LogStatus.INFO, "Enter User Name on the login form to login as a user in the application.");

		passwordcorrect = (String) jsonObject.get("Password Correct");

		sellerlogin.enterPassword(passwordcorrect);
		child2.log(LogStatus.INFO, "Enter correct Password on the login form to login as a user in the application.");

		sellerlogin.clickOnSubmitButton();
		child2.log(LogStatus.INFO, "Click on Submit button on login form to login.");

		child2.log(LogStatus.PASS, "User is able to login successfully.");
		
		selleraddproduct.clickToggleIcon();
		child2.log(LogStatus.INFO, "User clicks On Toggle bar on Seller dashboard to open the grid to make Product Icon visible.");

		addtocart.clickOnLogoDashboard();
		child2.log(LogStatus.INFO, "Click on Dashboard link on logged in user.");

		child2.log(LogStatus.PASS, "User is able to open homepage to search product in search bar.");

		logger.appendChild(child2);
		
		//
		//Search the added product name
		//
		child3 = report.startTest("Search newly added product to buy");

		addtocart.enterProductinSearch(productName);
		child3.log(LogStatus.INFO, "User is entering new added product in search bar of homepage.");

		addtocart.clickOnSearchButton();
		child3.log(LogStatus.INFO, "User click on Search button to search product in search bar of homepage.");

		child3.log(LogStatus.PASS, "User is able to search the newly added product to buy.");

		logger.appendChild(child3);
		
		//
		//Compare the actual special price with special price on product in Search Page
		//
		child4 = report.startTest("Compare the actual special price with special price on product in Search Page");
		
		String getProductPriceonSearch = userSpecialPrice.getProductPriceonSearch();
		child4.log(LogStatus.INFO, "Getting the special price on product in search page.");
		
		child4.log(LogStatus.INFO, "Comparing the actual special price with special price on product in Search Page.");
		
		if(getProductPriceonSearch.contains(actualSpecialPrice))
		{
			child4.log(LogStatus.PASS, "The Special price on product in Search Page is correct and same as like actual special price of product.");
			child4.log(LogStatus.PASS, getProductPriceonSearch);
		}
		else
		{
			child4.log(LogStatus.FAIL, "The Special price on product in Search Page is not correct and same as like actual special price of product.");
			child4.log(LogStatus.FAIL, getProductPriceonSearch);
		}
		
		logger.appendChild(child4);
		
		//
		//Compare the actual special price with special price on product in product detail page
		//
		child5 = report.startTest("Compare the actual special price with special price on product in product detail page");

		addtocart.clickOnProductImage();
		child5.log(LogStatus.INFO, "Click on product image on searched product page.");
		
		String getProductPriceonDetailPage = userSpecialPrice.getProductPriceonSearch();
		child5.log(LogStatus.INFO, "Getting the special price on product in product detail page.");
		
		child5.log(LogStatus.INFO, "Comparing the actual special price with special price on product in product detail page.");
		
		if(getProductPriceonDetailPage.contains(actualSpecialPrice))
		{
			child5.log(LogStatus.PASS, "The Special price on product in product detail page is correct and same as like actual special price of product.");
			child5.log(LogStatus.PASS, getProductPriceonDetailPage);
		}
		else
		{
			child5.log(LogStatus.FAIL, "The Special price on product in product detail page is not correct and same as like actual special price of product.");
			child5.log(LogStatus.FAIL, getProductPriceonDetailPage);
		}
		
		logger.appendChild(child5);
		
		//
		//Compare the actual special price with special price on product in Order Summary
		//
		child6 = report.startTest("Compare the actual special price with special price on product in Order Summary");
		
		userBuyNow.clickBuyNow();
		child6.log(LogStatus.INFO, "Click on Buy Now on searched product detail page.");
		
		String productPriceonOrderSummary = userSpecialPrice.getProductPriceonproductPriceonOrderSummaryPage();
		child6.log(LogStatus.INFO, "Get Product Price on product in Order Summary.");
		
		child6.log(LogStatus.INFO, "Comparing the actual special price with special price on product in Order Summary.");
		
		if(productPriceonOrderSummary.contains(actualSpecialPrice))
		{
			child6.log(LogStatus.PASS, "The Special price on product in Order Summary section is correct and same as like actual special price of product.");
			child6.log(LogStatus.PASS, productPriceonOrderSummary);
		}
		else
		{
			child6.log(LogStatus.FAIL, "The Special price on product in Order Summary section is not correct and same as like actual special price of product.");
			child6.log(LogStatus.FAIL, productPriceonOrderSummary);
		}
		
		logger.appendChild(child6);
		
		//
		//Compare the actual special price with special price on product in Shipping Summary page
		//
		child7 = report.startTest("Compare the actual special price with special price on product in Shipping Summary page");
		
		String productPriceonShippingSummparyPage = userSpecialPrice.getProductPriceonShippingSummparyPage();
		child7.log(LogStatus.INFO, "Get Product Price on Shipping Summpary Page.");
		
		child7.log(LogStatus.INFO, "Comparing the actual special price with special price on product in Shipping Summary page.");
		if(productPriceonShippingSummparyPage.contains(actualSpecialPrice))
		{
			child7.log(LogStatus.PASS, "The Special price on product in Shipping Summary page is correct and same as like actual special price of product.");
			child7.log(LogStatus.PASS, productPriceonShippingSummparyPage);
		}
		else
		{
			child7.log(LogStatus.FAIL, "The Special price on product in Shipping Summary page is not correct and same as like actual special price of product.");
			child7.log(LogStatus.FAIL, productPriceonShippingSummparyPage);
		}
		
		logger.appendChild(child7);
		
		//
		//Compare the actual special price with special price on product in Order Details page
		//
		child8 = report.startTest("Compare the actual special price with special price on product in Order History page");
		
		userBuyNow.clickContinueShippingSummary();
		child8.log(LogStatus.INFO, "Enter Valid Phone Number in Billing Address form.");
		
		addtocart.selectCreditCardSelection();
		child8.log(LogStatus.INFO, "Selecting Credit Card in Payment Summary Screen.");
		
		addtocart.clickConfirmPayment();
		child8.log(LogStatus.INFO, "Click Confirm Payment in Payment Summary Screen.");
		
		creditCardNumber = (String) jsonObject1.get("Credit Card Number");
		
		addtocart.enterCreditCardNumber(creditCardNumber);
		child8.log(LogStatus.INFO, "User is able to enter Credit Card number in Credit Card Screen.");
		
		cardHolderName = (String) jsonObject1.get("Card Holder Name");
		
		addtocart.enterCardHolderName(cardHolderName);
		child8.log(LogStatus.INFO, "User is able to enter Credit Card Holder Name in Credit Card Screen.");
		
		creditCardExpiryYear = (String) jsonObject1.get("Credit Card Expiry Year");
		
		addtocart.selectExpiryYear(creditCardExpiryYear);
		child8.log(LogStatus.INFO, "User is able to Select Credit Card Expiry Year in Credit Card Screen.");
		
		cvvSecurityCode = (String) jsonObject1.get("CVV Security Code");
		
		addtocart.enterCVVSecurityCode(cvvSecurityCode);
		child8.log(LogStatus.INFO, "User is able to enter CVV Security Code in Credit Card Screen.");
		
		addtocart.clickPayNow();
		child8.log(LogStatus.INFO, "User is able to click Pay Now in Credit Card Screen.");
		
		userSpecialPrice.clickHistory();
		child8.log(LogStatus.INFO, "Click on History link on Congratulations Screen.");
		
		userSpecialPrice.clickEyeIcon();
		child8.log(LogStatus.INFO, "Click on eye icon on Order History screen for the latest order.");
		
		String sellingPriceonOrder = userSpecialPrice.getSellingPrice();
		child8.log(LogStatus.INFO, "Getting Selling Price on Order Details for the latest order.");
		
		child8.log(LogStatus.INFO, "Compare the actual special price with special price on product in Order Details page.");
		if(sellingPriceonOrder.contains(actualSpecialPrice))
		{
			child8.log(LogStatus.PASS, "The Special price on product in Order Details is correct and same as like actual special price of product.");
			child8.log(LogStatus.PASS, sellingPriceonOrder);
		}
		else
		{
			child8.log(LogStatus.FAIL, "The Special price on product in Order Details is not correct and same as like actual special price of product.");
			child8.log(LogStatus.FAIL, sellingPriceonOrder);
		}
		
		logger.appendChild(child8);
		
	}
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			//
			// If test is getting failed then take the screen shot and put it in Automation Report.
			//
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshot_path = Utility.captureScreenshot(driver, result.getName());
				String image = logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "Special price is not correct for added product.");
				logger.log(LogStatus.FAIL, "Special_Search_Wrong", image);
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
