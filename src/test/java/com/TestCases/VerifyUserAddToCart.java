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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserAddToCart {

	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11,child12,child13,child14,child15,child16,child17,child18;

	String usernamecorrect, usernamewrong, passwordwrong, password, passwordcorrect, minQuantity, nameCorrect, addressLine1, state;
	String city,NonAlphanumericPostalcode,alphanumericPostalcode,nonValidPhoneNumber,validPhoneNumber,creditCardNumber,cardHolderName;
	String creditCardExpiryYear,cvvSecurityCode;

	JSONParser parser = new JSONParser();

	@Test
	public void userSearchforAddedProduct()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Add to Cart for Added Product");

		//
		// --------------------------------------------------Opening User Login
		// form.-------------------------------------------------------
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
		// Created Page Object using Page Factory to call the functions from User Searcg
		// Page.
		//
		UserAddtoCartPage addtocart = PageFactory.initElements(driver, UserAddtoCartPage.class);

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

		addtocart.clickonAddToCart();
		child4.log(LogStatus.INFO, "Click on add to cart on searched product detail page.");

		logger.appendChild(child4);

		//
		// Checkout the newly added product
		//
		child5 = report.startTest("Checkout the newly added product");

		addtocart.clickOnCart();
		child5.log(LogStatus.INFO, "Click on cart on product detail page.");

		addtocart.clickViewBag();
		child5.log(LogStatus.INFO, "Click on View Bag in product detail page's cart side pop up.");

		addtocart.clickonCheckout();
		child5.log(LogStatus.INFO, "Click on Checkout in Cart Page.");

		child5.log(LogStatus.PASS, "Users is able to checkout and redirect to Billing Address successfully.");

		logger.appendChild(child5);

		//
		// Check User's Billing address form with keeping Name field Blank.
		//
		child6 = report.startTest("Check User's Billing address with keeping Name field Blank");

		addtocart.clickSaveChanges();
		child6.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form.");

		String errorName = addtocart.getMandatoryValidationName();

		if (errorName.contains("Mandatory")) {
			child6.log(LogStatus.PASS,
					"When user is not entering Name and click on Submit button on Billing Address form, user is getting correct validation error message.");
			child6.log(LogStatus.PASS, errorName);
		} else {
			child6.log(LogStatus.FAIL,
					"When user is not entering Name and click on Submit button on Billing Address form, user is not getting correct validation error message.");
			child6.log(LogStatus.FAIL, errorName);
		}

		logger.appendChild(child6);

		//
		// Check User's Billing address form with keeping Address Line1 field Blank.
		//
		child7 = report.startTest("Check User's Billing address with keeping Address Line1 field Blank");

		nameCorrect = (String) jsonObject1.get("Billing Name");

		addtocart.enterName(nameCorrect);
		child7.log(LogStatus.INFO, "Enter Name in Billing Address form.");

		addtocart.clickSaveChanges();
		child7.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with keeping Address Line1 field Blank.");

		String errorAddressLine1 = addtocart.getMandatoryValidationAddressLine1();

		if (errorAddressLine1.contains("Mandatory")) {
			child7.log(LogStatus.PASS,
					"When user is not entering Address Line1 and click on Submit button on Billing Address form, user is getting correct validation error message.");
			child7.log(LogStatus.PASS, errorAddressLine1);
		} else {
			child7.log(LogStatus.FAIL,
					"When user is not entering Address Line1 and click on Submit button on Billing Address form, user is not getting correct validation error message.");
			child7.log(LogStatus.FAIL, errorAddressLine1);
		}

		logger.appendChild(child7);

		//
		//Check User's Billing address form with keeping State field Blank.
		//
		child8 = report.startTest("Check User's Billing address with keeping State field Blank");

		addressLine1 = (String) jsonObject1.get("Address Line1");

		addtocart.enterAddressLine1(addressLine1);
		child8.log(LogStatus.INFO, "Enter Address Line 1 in Billing Address form.");

		addtocart.clickSaveChanges();
		child8.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with keeping State field Blank.");

		
		String errorstate = addtocart.getMandatoryValidationState();
		  
		if(errorstate.contains("Mandatory")) 
		{ 
			child8.log(LogStatus.PASS, "When user is not entering State and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child8.log(LogStatus.PASS, errorstate); 
		} 
		else 
		{
			child8.log(LogStatus.FAIL, "When user is not entering State and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child8.log(LogStatus.FAIL, errorstate); 
		}

		logger.appendChild(child8);
		
		//
		//Check User's Billing address form with keeping City field Blank.
		//
		child9 = report.startTest("Check User's Billing address form with keeping City field Blank");
		
		state = (String) jsonObject1.get("State");
		
		addtocart.selectDropDown(state);
		child9.log(LogStatus.INFO, "Select State in Billing Address form.");

		addtocart.clickSaveChanges();
		child9.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with keeping City field Blank.");
		
		String cityMandatory = addtocart.getCityValidation();
		
		if(cityMandatory.contains("Mandatory"))
		{
			child9.log(LogStatus.PASS, "When user is not entering City and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child9.log(LogStatus.PASS, cityMandatory); 
		} 
		else 
		{
			child9.log(LogStatus.FAIL, "When user is not entering City and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child9.log(LogStatus.FAIL, cityMandatory); 
		}
		
		logger.appendChild(child9);
		
		//
		//Check User's Billing address form with keeping Postalcode field Blank.
		//
		child10 = report.startTest("Check User's Billing address form with keeping Postalcode field Blank");
		
		city = (String) jsonObject1.get("City"); 
		
		addtocart.enterCity(city);
		child10.log(LogStatus.INFO, "Enter City in Billing Address form.");
		
		addtocart.clickSaveChanges();
		child10.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with keeping Postalcode field Blank.");
		
		String postalcode = addtocart.getValidationPostalCode();
		
		if(postalcode.contains("Mandatory"))
		{
			child10.log(LogStatus.PASS, "When user is not entering Postalcode and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child10.log(LogStatus.PASS, postalcode); 
		} 
		else 
		{
			child10.log(LogStatus.FAIL, "When user is not entering Postalcode and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child10.log(LogStatus.FAIL, postalcode); 
		}
		
		logger.appendChild(child10);
		
		//
		//Check User's Billing address form with entering Non-Alphanumeric Value in Postalcode field.
		//
		child11 = report.startTest("Check User's Billing address form with entering Non-Alphanumeric Value in Postalcode field");
		
		NonAlphanumericPostalcode = (String) jsonObject1.get("Non-Alphanumeric Postalcode");
		
		addtocart.enterPostalCode(NonAlphanumericPostalcode);
		child11.log(LogStatus.INFO, "Enter Non Alphanumeric Postalcode in Billing Address form.");
		
		addtocart.clickSaveChanges();
		child11.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with entering Non-Alphanumeric Value in Postalcode field.");
		
		String nonAlphanumericpostalcode = addtocart.getValidationPostalCode();
		
		if(nonAlphanumericpostalcode.contains("Alphanumeric"))
		{
			child11.log(LogStatus.PASS, "When user is entering Non-Alphanumeric Postalcode and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child11.log(LogStatus.PASS, nonAlphanumericpostalcode); 
		} 
		else 
		{
			child11.log(LogStatus.FAIL, "When user is entering Non-Alphanumeric Postalcode and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child11.log(LogStatus.FAIL, nonAlphanumericpostalcode);
		}
		
		logger.appendChild(child11);
		
		//
		//Check User's Billing address form with entering Alphanumeric Value and keeping Phone blank in Postalcode field.
		//
		child12 = report.startTest("Check User's Billing address form with entering Alphanumeric Value and keeping Phone blank in Postalcode field");
		
		alphanumericPostalcode = (String) jsonObject1.get("Alphanumeric Postalcode");
		
		addtocart.enterPostalCode(alphanumericPostalcode);
		child12.log(LogStatus.INFO, "Enter Alphanumeric Postalcode in Billing Address form.");
		
		addtocart.clickSaveChanges();
		child12.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with entering Alphanumeric Value in Postalcode field.");
		
		String mandatoryPhone = addtocart.getValidationMessagePhone();
		
		if(mandatoryPhone.contains("Mandatory"))
		{
			child12.log(LogStatus.PASS, "When user is not entering Alphanumeric Value and keeping Phone blank and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child12.log(LogStatus.PASS, mandatoryPhone); 
		} 
		else 
		{
			child12.log(LogStatus.FAIL, "When user is not entering Alphanumeric Value and keeping Phone blank and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child12.log(LogStatus.FAIL, mandatoryPhone); 
		}
		
		logger.appendChild(child12);
		
		//
		//Check User's Billing address form with entering non-valid phone number.
		//
		child13 = report.startTest("Check User's Billing address form with entering non-valid phone number");
		
		nonValidPhoneNumber = (String) jsonObject1.get("Non-valid Phone Number");
		
		addtocart.enterPhoneNumber(nonValidPhoneNumber);
		child13.log(LogStatus.INFO, "Enter Non Valid Phone Number in Billing Address form.");
		
		addtocart.clickSaveChanges();
		child13.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with entering non-valid phone number.");
		
		String nonValidPhone = addtocart.getValidationMessagePhone();
		
		if(mandatoryPhone.contains("Valid Format"))
		{
			child13.log(LogStatus.PASS, "When user is entering non-valid phone number and click on Submit button on Billing Address form, user is getting correct validation error message."); 
			child13.log(LogStatus.PASS, nonValidPhone); 
		} 
		else 
		{
			child13.log(LogStatus.FAIL, "When user is entering non-valid phone number and click on Submit button on Billing Address form, user is not getting correct validation error message."); 
			child13.log(LogStatus.FAIL, nonValidPhone);
		}
		
		logger.appendChild(child13);
		
		//
		//Check User's Billing address form with entering Valid phone number.
		//
		child14 = report.startTest("Check User's Billing address form with entering Valid phone number");
		
		validPhoneNumber = (String) jsonObject1.get("Valid Phone Number");
		
		addtocart.enterPhoneNumber(validPhoneNumber);
		child14.log(LogStatus.INFO, "Enter Valid Phone Number in Billing Address form.");
		
		addtocart.clickSaveChanges();
		child14.log(LogStatus.INFO, "Click on Save Changes button in Billing Address form with entering Valid phone number.");
		
		String successbilling = addtocart.getSuccessBilling();
		
		if(successbilling.contains("success"))
		{
			child14.log(LogStatus.PASS, "When user is entering valid inputs in all fields and click on Submit button on Billing Address form, user is getting correct message."); 
			child14.log(LogStatus.PASS, successbilling);
		}
		else
		{
			child14.log(LogStatus.FAIL, "When user is entering valid inputs in all fields and click on Submit button on Billing Address form, user is not getting correct message."); 
			child14.log(LogStatus.FAIL, successbilling);
		}
		
		logger.appendChild(child14);
		
		//
		//Check Shipping Summary
		//
		child15 = report.startTest("Check Shipping Summary");
		
		addtocart.clickContinueShippingSummary();
		child15.log(LogStatus.INFO, "Enter Valid Phone Number in Billing Address form.");
		
		child15.log(LogStatus.PASS, "User is able to enter Shipping Summary successfully.");
		
		logger.appendChild(child15);
		
		//
		//Selecting Credit Card in Payment Summary Screen
		//
		child16 = report.startTest("Selecting Credit Card in Payment Summary Screen");
		
		addtocart.selectCreditCardSelection();
		child16.log(LogStatus.INFO, "Selecting Credit Card in Payment Summary Screen.");
		
		addtocart.clickConfirmPayment();
		child16.log(LogStatus.INFO, "Click Confirm Payment in Payment Summary Screen.");
		
		child16.log(LogStatus.PASS, "User is able to Select Credit Card in Payment Summary screen.");
		
		logger.appendChild(child16);
		
		//
		//Enter Credit Card information in Credit Card Screen
		//
		child17 = report.startTest("Enter Credit Card information in Credit Card Screen");
		
		creditCardNumber = (String) jsonObject1.get("Credit Card Number");
		
		addtocart.enterCreditCardNumber(creditCardNumber);
		child17.log(LogStatus.INFO, "User is able to enter Credit Card number in Credit Card Screen.");
		
		cardHolderName = (String) jsonObject1.get("Card Holder Name");
		
		addtocart.enterCardHolderName(cardHolderName);
		child17.log(LogStatus.INFO, "User is able to enter Credit Card Holder Name in Credit Card Screen.");
		
		creditCardExpiryYear = (String) jsonObject1.get("Credit Card Expiry Year");
		
		addtocart.selectExpiryYear(creditCardExpiryYear);
		child17.log(LogStatus.INFO, "User is able to Select Credit Card Expiry Year in Credit Card Screen.");
		
		cvvSecurityCode = (String) jsonObject1.get("CVV Security Code");
		
		addtocart.enterCVVSecurityCode(cvvSecurityCode);
		child17.log(LogStatus.INFO, "User is able to enter CVV Security Code in Credit Card Screen.");
		
		addtocart.clickPayNow();
		child17.log(LogStatus.INFO, "User is able to click Pay Now in Credit Card Screen.");
		
		child17.log(LogStatus.PASS, "User is able to enter Credit Card information in Credit Card Screen.");
		
		logger.appendChild(child17);
		
		//
		//Check user is able to place order or not
		//
		child18 = report.startTest("Check user is able to place order or not");
		
		String successmessage = addtocart.getSuccessMessage();
		child18.log(LogStatus.INFO, "Get the Message coming on Payment screen.");
		
		child18.log(LogStatus.INFO, "Compare the Actual message coming on Payment screen and Expected Message.");		
		if(successmessage.contains("Congratulations"))
		{
			child18.log(LogStatus.PASS, "User is able to order Successfully."); 
			child18.log(LogStatus.PASS, successmessage);
		}
		else
		{
			child18.log(LogStatus.FAIL, "User is not able to order Successfully."); 
			child18.log(LogStatus.FAIL, successmessage);
		}
		
		logger.appendChild(child18);
		
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
			logger.log(LogStatus.FAIL, "User is Not able to checkout with Add to Cart.");
			logger.log(LogStatus.FAIL, "User_checkout_Failed", image);
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
