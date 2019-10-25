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
import com.Pages.SellerProductVolumeDiscountPage;
import com.Pages.SellerShopCreationPage;
import com.Pages.UserAddtoCartPage;
import com.Pages.UserBuyNowPage;
import com.Pages.UserCheckoutwithSpecialPricePage;
import com.Pages.UserCheckoutwithVolumeDiscountPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.BrowserFactory;
import Helper.Utility;

public class VerifyUserCheckoutwithVolumeDiscount {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	ExtentTest child1, child2, child3, child4, child5, child6, child7, child8, child9, child10;
	ExtentTest child11, child12, child13, child14, child15, child16, child17, child18, child19;

	String usernamecorrect, usernamewrong, passwordwrong, password, passwordcorrect, minQuantity, nameCorrect, addressLine1, state;
	String city,NonAlphanumericPostalcode,alphanumericPostalcode,nonValidPhoneNumber,validPhoneNumber,creditCardNumber,cardHolderName;
	String creditCardExpiryYear,cvvSecurityCode, volumeDiscountFirstCalculatednew,vol_Dis_second_Calculated_new, sub_total_second_new;
	String volume_Discount_third_Updated_new, sub_total_third_new, volume_Discount_fourth_Updated_new, sub_total_fourth_new;
	String subTotal_forth_new, subTotal_forth_new_updated, second_Discount, volume_Discount_fifth_Updated_new, subTotal_fifth_new;
	String subTotal_fifth_new_updated, tax_calculated_new, sales_Tax, net_payable_calculated_new, net_Payable_Shipping_new;
	
	
	String sellingPrice, subTotalFirst;
	
	String firstDiscount;

	JSONParser parser = new JSONParser();

	@Test
	public void userCheckoutwithVolumeDiscount() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		report = ExtentFactory.getInstance();
		logger = report.startTest("User Checkout with Volume Discount");

		//
		// --------------------------------------------------Opening User Login form.-------------------------------------------------------
		//
		child1 = report.startTest("Get the Volume Discount of the Product added to the Product");

		driver = BrowserFactory.startBrowser("chrome", "url");
		child1.log(LogStatus.INFO, "Started the Browser and Opened Home page of the application.");

		Object obj = parser.parse(new FileReader("src/test/java/JSONData/UserCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;

		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/SellerInventoryAddVolumeDiscountInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		
		Object obj2 = parser.parse(new FileReader("src/test/java/JSONData/adminAddSalesTaxInputData.json"));
		JSONObject jsonObject2 = (JSONObject) obj2;
		
		Object obj3 = parser.parse(new FileReader("src/test/java/JSONData/UserCreationInputData.json"));
		JSONObject jsonObject3 = (JSONObject) obj3;

		Object obj4 = parser.parse(new FileReader("src/test/java/JSONData/UserAddtoCartData.json"));
		JSONObject jsonObject4 = (JSONObject) obj4;

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
		// Created Page Object using Page Factory to call the functions from Seller
		// Product Add Discount Page to click on dashboard from top.
		//
		SellerProductVolumeDiscountPage selleradddiscount = PageFactory.initElements(driver, SellerProductVolumeDiscountPage.class);

		//
		// Created object to call the functions from User Creation Page
		//
		// UserCreationPage usercreation = PageFactory.initElements(driver, UserCreationPage.class);
		
		//
		// Created object to call the functions from Checkout with Volume Discount Page
		//
		UserCheckoutwithVolumeDiscountPage checkoutVolumeDiscount = PageFactory.initElements(driver, UserCheckoutwithVolumeDiscountPage.class);

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
		
		selleradddiscount.clickOnVolumeDiscount();
		child1.log(LogStatus.INFO, "Click On Volume Discount Option in Inventory Set up page.");
		
		String firstVolumeDiscountQuantity = checkoutVolumeDiscount.getfirstVolumeDiscountQuantity();
		child1.log(LogStatus.INFO, "Got the first Volume Discount Quantity successfully." + firstVolumeDiscountQuantity);
		
		String firstVolumeDiscount = checkoutVolumeDiscount.getDiscountPercentageoffirstVolumeDiscountQuantity();
		child1.log(LogStatus.INFO, "Got the Volume Discount of first Volume Discount Quantity successfully." + firstVolumeDiscount);
		
		String secondVolumeDiscountQuantity = checkoutVolumeDiscount.getsecondVolumeDiscountQuantity();
		child1.log(LogStatus.INFO, "Got the second Volume Discount Quantity successfully." + secondVolumeDiscountQuantity);
		
		String secondVolumeDiscount = checkoutVolumeDiscount.getDiscountPercentageofsecondVolumeDiscountQuantity();
		child1.log(LogStatus.INFO, "Got the Volume Discount of second Volume Discount Quantity successfully." + secondVolumeDiscount);
		  
		child1.log(LogStatus.PASS, "Able to get Minimum Purchase Quantities for Volume Discounts of the product.");
		  
		logger.appendChild(child1);
		  
		//
		//Login to user's account and open homepage to search the product 
		//
		child2 = report.startTest("Login to user's account and open homepage to search the product");
		  
		addtocart.clickOnAvatar(); child2.log(LogStatus.INFO, "Click on Avatar of the logged in Seller.");
		  
		addtocart.clickOnLogout(); child2.log(LogStatus.INFO, "Click on logout option of the logged in Seller.");
		  
		child2.log(LogStatus.PASS, "Seller is able to logout successfully.");
		  
		//usercreation.clickAcceptCookies(); 
		//child2.log(LogStatus.INFO, "Accept cookies on the page.");
		  
		usernamecorrect = (String) jsonObject.get("Username Correct");
		  
		sellerlogin.enterUserName(usernamecorrect); 
		child2.log(LogStatus.INFO, "Enter User Name on the login form to login as a user in the application.");
		  
		passwordcorrect = (String) jsonObject.get("Password Correct");
		  
		sellerlogin.enterPassword(passwordcorrect); child2.log(LogStatus.INFO, "Enter correct Password on the login form to login as a user in the application.");
		  
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
		  
		addtocart.enterProductinSearch(productName); child3.log(LogStatus.INFO, "User is entering new added product in search bar of homepage.");
		  
		addtocart.clickOnSearchButton(); child3.log(LogStatus.INFO, "User click on Search button to search product in search bar of homepage.");
		  
		child3.log(LogStatus.PASS, "User is able to search the newly added product to buy.");
		 
		logger.appendChild(child3);
		
		//
		//Check First Volume Discount with Minimum Quantities on Product detail page
		//
		child4 = report.startTest("Check First Volume Discounts with Minimum Quantities on Product detail page");

		addtocart.clickOnProductImage();
		child4.log(LogStatus.INFO, "Click on product image on searched product page.");
		
		String quantityfirstVolumeDiscountActual_ProductDetailPage = checkoutVolumeDiscount.getfirstVolumeDiscountonProductDetailPage();
		child4.log(LogStatus.INFO, "First Volume discount of the product is:" + quantityfirstVolumeDiscountActual_ProductDetailPage);
		
		if(quantityfirstVolumeDiscountActual_ProductDetailPage.contains(firstVolumeDiscountQuantity))
		{
			child4.log(LogStatus.PASS, "First Volume discount quantity coming under WHOLESALE PRICE (PIECE) is same as the actual Volume discount quantity of product.");
			child4.log(LogStatus.PASS, quantityfirstVolumeDiscountActual_ProductDetailPage);
		}
		else
		{
			child4.log(LogStatus.FAIL, "First Volume discount quantity coming under WHOLESALE PRICE (PIECE) is not same as the actual Volume discount quantity of product.");
			child4.log(LogStatus.FAIL, quantityfirstVolumeDiscountActual_ProductDetailPage);
		}
		
		if(quantityfirstVolumeDiscountActual_ProductDetailPage.contains(firstVolumeDiscount))
		{
			child4.log(LogStatus.PASS, "First Volume discount coming under WHOLESALE PRICE (PIECE) is same as the actual Volume discount of product.");
			child4.log(LogStatus.PASS, quantityfirstVolumeDiscountActual_ProductDetailPage);
		}
		else
		{
			child4.log(LogStatus.FAIL, "First Volume discount coming under WHOLESALE PRICE (PIECE) is not same as the actual Volume discount of product.");
			child4.log(LogStatus.FAIL, quantityfirstVolumeDiscountActual_ProductDetailPage);
		}
		
		logger.appendChild(child4);
		
		//
		//Check Second Volume Discount with Minimum Quantities on Product detail page
		//
		child5 = report.startTest("Check Second Volume Discounts with Minimum Quantities on Product detail page");
		
		String quantitysecondVolumeDiscountActual_ProductDetailPage = checkoutVolumeDiscount.getsecondVolumeDiscountonProductDetailPage();
		child5.log(LogStatus.INFO, "Second Volume discount of the product is:" + quantitysecondVolumeDiscountActual_ProductDetailPage);
		
		if(quantitysecondVolumeDiscountActual_ProductDetailPage.contains(secondVolumeDiscountQuantity))
		{
			child5.log(LogStatus.PASS, "Second Volume discount quantity coming under WHOLESALE PRICE (PIECE) is same as the actual Volume discount quantity of product.");
			child5.log(LogStatus.PASS, quantitysecondVolumeDiscountActual_ProductDetailPage);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Second Volume discount quantity coming under WHOLESALE PRICE (PIECE) is not same as the actual Volume discount quantity of product.");
			child5.log(LogStatus.FAIL, quantitysecondVolumeDiscountActual_ProductDetailPage);
		}
		
		if(quantitysecondVolumeDiscountActual_ProductDetailPage.contains(secondVolumeDiscount))
		{
			child5.log(LogStatus.PASS, "Second Volume discount coming under WHOLESALE PRICE (PIECE) is same as the actual Volume discount of product.");
			child5.log(LogStatus.PASS, quantitysecondVolumeDiscountActual_ProductDetailPage);
		}
		else
		{
			child5.log(LogStatus.FAIL, "Second Volume discount coming under WHOLESALE PRICE (PIECE) is not same as the actual Volume discount of product.");
			child5.log(LogStatus.FAIL, quantitysecondVolumeDiscountActual_ProductDetailPage);
		}
		
		logger.appendChild(child5);
		
		//
		// Check Volume Discount on Cart Bag in Product detail page
		//
		child6 = report.startTest("Check Volume Discount on Cart Bag in Product detail page");

		// minQuantity = (String) jsonObject1.get("Minimum Quantity Correct");

		// addtocart.enterQuantity(minQuantity);
		child6.log(LogStatus.INFO, "Keep quantity default i.e. 1.");

		addtocart.clickonAddToCart();
		child6.log(LogStatus.INFO, "Click on add to cart on searched product detail page.");
		
		addtocart.clickOnCart();
		child6.log(LogStatus.INFO, "Click on cart on product detail page.");

		//addtocart.clickViewBag();
		//child6.log(LogStatus.INFO, "Click on View Bag in product detail page's cart side pop up.");
		
		String cartDetailsonProductDetailPage = checkoutVolumeDiscount.getCartDetailonProductDetailPage();
		child6.log(LogStatus.INFO, "Get the cart details in Cart Bag in Proudct Detail Page.");
		
		if(!cartDetailsonProductDetailPage.contains("Volume Discount"))
		{
			child6.log(LogStatus.PASS, "When we are not entring wholesale quantity, Volume Discount is not coming in Cart Bag in Product detail page.");
			child6.log(LogStatus.PASS, cartDetailsonProductDetailPage);
		}
		else if(cartDetailsonProductDetailPage.contains("Volume Discount"))
		{
			child6.log(LogStatus.FAIL, "When we are not entring wholesale quantity, Volume Discount is still coming in Cart Bag in Product detail page.");
			child6.log(LogStatus.FAIL, cartDetailsonProductDetailPage);
		}
		
		checkoutVolumeDiscount.clickViewBagOnCartBag();
		child6.log(LogStatus.INFO, "Click on View Bag in Cart Bag of product detail page.");

		child6.log(LogStatus.PASS, "Users is able to checkout and redirect to Cart Page.");

		logger.appendChild(child6);
		
		//
		//Check Volume Discount on Cart Page with default Product Quantity
		//
		child7 = report.startTest("Check Volume Discount on Cart Page with default Product Quantity");
		
		String cartDetailsonCartPagewithDefaulty = checkoutVolumeDiscount.getCartSection();
		child7.log(LogStatus.INFO, "Get the cart details in Cart Section in Cart Page.");
		
		if(!cartDetailsonCartPagewithDefaulty.contains("Volume Discount"))
		{
			child7.log(LogStatus.PASS, "When we are keeping default Product quantity, Volume Discount is not coming in Cart Section in Cart page.");
			child7.log(LogStatus.PASS, cartDetailsonCartPagewithDefaulty);
		}
		else if(cartDetailsonCartPagewithDefaulty.contains("Volume Discount"))
		{
			child7.log(LogStatus.FAIL, "When we are keeping default Product quantity, Volume Discount is still coming in Cart Section in Cart page.");
			child7.log(LogStatus.FAIL, cartDetailsonCartPagewithDefaulty);
		}
		
		logger.appendChild(child7);
		
		//
		//Check Volume Discount on Cart Page with Product Quantity jsut less than first wholesale quantity
		//
		child8 = report.startTest("Check Volume Discount on Cart Page with Product Quantity jsut less than first wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		checkoutVolumeDiscount.clickIncreaseQuantity();
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child8.log(LogStatus.INFO, "Enter the quantity of the product boundary less than the first minimum wholesale quantity.");
		
		String cartDetailsonCartPagewithBoundayfirstLess = checkoutVolumeDiscount.getCartSection();
		child8.log(LogStatus.INFO, "Get the cart details in Cart Section in Cart Page.");
		
		if(!cartDetailsonCartPagewithBoundayfirstLess.contains("Volume Discount"))
		{
			child8.log(LogStatus.PASS, "When we are keeping Product quantity less than Boundary value, Volume Discount is not coming in Cart Section in Cart page.");
			child8.log(LogStatus.PASS, cartDetailsonCartPagewithBoundayfirstLess);
		}
		else if(cartDetailsonCartPagewithBoundayfirstLess.contains("Volume Discount"))
		{
			child8.log(LogStatus.FAIL, "When we are keeping Product quantity less than Boundary value, Volume Discount is still coming in Cart Section in Cart page.");
			child8.log(LogStatus.FAIL, cartDetailsonCartPagewithBoundayfirstLess);
		}
		
		logger.appendChild(child8);
		
		//
		//Check Volume Discount presence on Cart Page with Product Quantity equal to first wholesale quantity
		//
		child9 = report.startTest("Check Volume Discount presence on Cart Page with Product Quantity equal to first wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child9.log(LogStatus.INFO, "Enter the quantity of the product boundary equal to minimum wholesale quantity.");
		
		String cartDetailsonCartPagewithBoundayfirst = checkoutVolumeDiscount.getCartSection();
		child9.log(LogStatus.INFO, "Get the cart details in Cart Section in Cart Page.");
		
		if(cartDetailsonCartPagewithBoundayfirst.contains("Volume Discount"))
		{
			child9.log(LogStatus.PASS, "When we are keeping Product quantity equal to minimum wholesale quantity, Volume Discount is coming in Cart Section in Cart page.");
			child9.log(LogStatus.PASS, cartDetailsonCartPagewithBoundayfirst);
		}
		else if(!cartDetailsonCartPagewithBoundayfirst.contains("Volume Discount"))
		{
			child9.log(LogStatus.FAIL, "When we are keeping Product quantity equal to minimum wholesale quantity, Volume Discount is not coming in Cart Section in Cart page.");
			child9.log(LogStatus.FAIL, cartDetailsonCartPagewithBoundayfirst);
		}
		
		logger.appendChild(child9);
		
		//
		//Check Subtotal on Cart Page with Product Quantity equal to first wholesale quantity
		//
		child10 = report.startTest("Check Subtotal on Cart Page with Product Quantity equal to first wholesale quantity");
		
		String quantityEqualFirstWholesaleQuantity = checkoutVolumeDiscount.getProductQuantity();
		child10.log(LogStatus.INFO, "Get the Product quantity when it is equal to first whole sale quantity on Shopping cart page.");
		
		double productQuantityequalWholesaleFirst = Double.parseDouble(quantityEqualFirstWholesaleQuantity);
		
		String sellingPriceCartPagefirstwholesale = checkoutVolumeDiscount.getSellingPriceonCartPage();
		child10.log(LogStatus.INFO, "Get the selling price of Product when it is equal to first whole sale quantity on Shopping cart page.");
		
		if(sellingPriceCartPagefirstwholesale.contains("$"))
			{
				sellingPrice = sellingPriceCartPagefirstwholesale.replace("$","");
			}
		
		double sellingPriceValue = Double.parseDouble(sellingPrice);
		
		String subTotalonCartPagefirstwholesale = checkoutVolumeDiscount.getsubTotalPriceonCartPage();
		child10.log(LogStatus.INFO, "Get the SubTotal of Product when it is equal to first whole sale quantity on Shopping cart page.");
		
		if(subTotalonCartPagefirstwholesale.contains("$"))
			{
				subTotalFirst = subTotalonCartPagefirstwholesale.replace("$","");
			}
		
		double subtotalFirst = Double.parseDouble(subTotalFirst);
		
		child10.log(LogStatus.INFO, "Compare SubTotal of Product with Selling price and Product Quantity of the product on Shopping cart page.");
		
		if(subtotalFirst == (sellingPriceValue*productQuantityequalWholesaleFirst))
			{
				child10.log(LogStatus.PASS, "When we are keeping Product quantity equal to minimum wholesale quantity, Sub Total is coming in Cart Section in Cart page is Correct.");
			}
		else
			{
				child10.log(LogStatus.FAIL, "When we are keeping Product quantity equal to minimum wholesale quantity, Sub Total is not coming in Cart Section in Cart page is Wrong.");
			}	
		
		logger.appendChild(child10);
		
		//
		//Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity equal to first wholesale quantity
		//
		child11 = report.startTest("Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity equal to first wholesale quantity");
		
		String volume_Discount_First_Calculated = checkoutVolumeDiscount.getvolumeDiscountFirstCalculated();
		child11.log(LogStatus.INFO, "Get the calculated Volume Discount on Shopping Cart page.");
		
		if(volume_Discount_First_Calculated.contains("$"))
		{
			volumeDiscountFirstCalculatednew = volume_Discount_First_Calculated.replace("$","");
		}
		
		double volumeDiscountFirstCalculatedActual = Double.parseDouble(volumeDiscountFirstCalculatednew);
		
		firstDiscount = (String) jsonObject1.get("Discount Correct");
		child11.log(LogStatus.INFO, "Get the actual added Volume Discount on the creation of product by seller.");
		
		double firstDiscountActual = Double.parseDouble(firstDiscount);
		
		child11.log(LogStatus.INFO, "Compare Volume Discount on Cart Page whether it is calculated correct or not on Shopping cart page.");
		
		if(volumeDiscountFirstCalculatedActual == ((subtotalFirst * firstDiscountActual)/100))
		{
			child11.log(LogStatus.PASS, "When we are keeping Product quantity equal to minimum wholesale quantity, Volume Discount on Cart Page is calculated correct");
		}
		else
		{
			child11.log(LogStatus.FAIL, "When we are keeping Product quantity equal to minimum wholesale quantity, Volume Discount on Cart Page is not calculated correct");
		}
		
		logger.appendChild(child11);
		
		//
		//Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly more than first wholesale quantity
		//
		child12 = report.startTest("Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly more than first wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child12.log(LogStatus.INFO, "Enter the quantity of the product slightly more than minimum wholesale quantity");
		
		String volume_Discount_second_Updated = checkoutVolumeDiscount.getvolumeDiscountFirstCalculated();
		child12.log(LogStatus.INFO, "Get the updated Volume discount when Quantity is slightly more than first wholesale quantity");
		
		if(volume_Discount_second_Updated.contains("$"))
		{
			vol_Dis_second_Calculated_new = volume_Discount_second_Updated.replace("$","");
		}
		
		double vol_Discount_second_Actual = Double.parseDouble(vol_Dis_second_Calculated_new);
		
		String sub_total_second = checkoutVolumeDiscount.getsubTotalPriceonCartPage();
		child12.log(LogStatus.INFO, "Get the updated Sub Total on the page when Quantity is slightly more than first wholesale quantity");
		
		if(sub_total_second.contains("$"))
		{
			sub_total_second_new = sub_total_second.replace("$","");
		}
		
		double sub_total_second_actual = Double.parseDouble(sub_total_second_new);
		
		child12.log(LogStatus.INFO, "Compare Volume Discount on Cart Page whether it is calculated correct or not when Quantity is slightly more than first wholesale quantity.");
		
		if(vol_Discount_second_Actual == ((sub_total_second_actual * firstDiscountActual)/100))
		{
			child12.log(LogStatus.PASS, "When we are keeping Product quantity slightly more than first wholesale quantity, Volume Discount on Cart Page is calculated correct");
		}
		else
		{
			child12.log(LogStatus.FAIL, "When we are keeping Product quantity slightly more than first wholesale quantity, Volume Discount on Cart Page is not calculated correct");
		}
		
		logger.appendChild(child12);
		
		//
		//Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly less than second wholesale quantity
		//
		child13 = report.startTest("Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly less than second wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		checkoutVolumeDiscount.clickIncreaseQuantity();
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child13.log(LogStatus.INFO, "Enter the quantity of the product boundary less than the second minimum wholesale quantity.");
		
		String volume_Discount_third_Updated = checkoutVolumeDiscount.getvolumeDiscountFirstCalculated();
		child13.log(LogStatus.INFO, "Get the updated Volume discount when Quantity is slightly less than second wholesale quantity");
		
		if(volume_Discount_third_Updated.contains("$"))
		{
			volume_Discount_third_Updated_new = volume_Discount_third_Updated.replace("$","");
		}
		
		double volume_Discount_third__Actual = Double.parseDouble(volume_Discount_third_Updated_new);
		
		String sub_total_third = checkoutVolumeDiscount.getsubTotalPriceonCartPage();
		child13.log(LogStatus.INFO, "Get the updated Sub Total on the page when Quantity is slightly less than second wholesale quantity");
		
		if(sub_total_third.contains("$"))
		{
			sub_total_third_new = sub_total_third.replace("$","");
		}
		
		double sub_total_third_actual = Double.parseDouble(sub_total_third_new);
		
		child13.log(LogStatus.INFO, "Compare Volume Discount on Cart Page whether it is calculated correct or not when Quantity is slightly more than first wholesale quantity.");
		
		if(volume_Discount_third__Actual == ((sub_total_third_actual * firstDiscountActual)/100))
		{
			child13.log(LogStatus.PASS, "When we are keeping Product quantity slightly less than second wholesale quantity, Volume Discount on Cart Page is calculated correct");
		}
		else
		{
			child13.log(LogStatus.FAIL, "When we are keeping Product quantity slightly less than second wholesale quantity, Volume Discount on Cart Page is not calculated correct");
		}
		
		logger.appendChild(child13);
		
		//
		//Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity equal to second wholesale quantity
		//
		child14 = report.startTest("Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity equal to second wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child14.log(LogStatus.INFO, "Enter the quantity of the product boundary equal to second wholesale quantity.");
		
		String volume_Discount_fourth_Updated = checkoutVolumeDiscount.getvolumeDiscountFirstCalculated();
		child14.log(LogStatus.INFO, "Get the updated Volume discount when Quantity is equal to second wholesale quantity");
		
		if(volume_Discount_fourth_Updated.contains("$"))
		{
			volume_Discount_fourth_Updated_new = volume_Discount_fourth_Updated.replace("$","");
		}
		
		double volume_Discount_fourth_Actual = Double.parseDouble(volume_Discount_fourth_Updated_new);

		String sub_total_fourth = checkoutVolumeDiscount.getsubTotalPriceonCartPage();
		child14.log(LogStatus.INFO, sub_total_fourth);
		
		if(sub_total_fourth.contains("$"))
		{
			subTotal_forth_new = sub_total_fourth.replace("$", "");
		}
		
		if(subTotal_forth_new.contains(","))
		{
			subTotal_forth_new_updated = subTotal_forth_new.replace(",", "");
		}
		
		child14.log(LogStatus.INFO, "Get the sub total when Quantity is equal to second wholesale quantity");
		
		double sub_total_forth_actual = Double.parseDouble(subTotal_forth_new_updated);
		
		second_Discount = (String) jsonObject1.get("Discount Correct Another");
		child14.log(LogStatus.INFO, "Get the second actual added Volume Discount on the creation of product by seller.");
		
		double second_discount = Double.parseDouble(second_Discount);
		
		child14.log(LogStatus.INFO, "Compare Volume Discount on Cart Page whether it is calculated correct or not when Quantity is equal to second wholesale quantity.");
		
		if(volume_Discount_fourth_Actual == ((sub_total_forth_actual * second_discount)/100))
		{
			child14.log(LogStatus.PASS, "When we are keeping Product quantity equal to second wholesale quantity, Volume Discount on Cart Page is calculated correct");
		}
		else
		{
			child14.log(LogStatus.FAIL, "When we are keeping Product quantity equal to second wholesale quantity, Volume Discount on Cart Page is not calculated correct");
		}
		
		logger.appendChild(child14);
		
		//
		//Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly more than the second wholesale quantity
		//
		child15 = report.startTest("Check Volume Discount on Cart Page whether it is calculated correct or not with Product Quantity slightly more than the second wholesale quantity");
		
		checkoutVolumeDiscount.clickIncreaseQuantity();
		child15.log(LogStatus.INFO, "Enter the quantity of the product slightly more than the second wholesale quantity.");
		
		String volume_Discount_fifth_Updated = checkoutVolumeDiscount.getvolumeDiscountFirstCalculated();
		child15.log(LogStatus.INFO, "Get the updated Volume discount when Quantity is equal to second wholesale quantity");
		
		if(volume_Discount_fifth_Updated.contains("$"))
		{
			volume_Discount_fifth_Updated_new = volume_Discount_fifth_Updated.replace("$", "");
		}
		
		double volume_Discount_fifth_Actual = Double.parseDouble(volume_Discount_fifth_Updated_new);
		
		
		String sub_total_fifth = checkoutVolumeDiscount.getsubTotalPriceonCartPage();
		child15.log(LogStatus.INFO, sub_total_fifth);
		
		if(sub_total_fifth.contains("$"))
		{
			subTotal_fifth_new = sub_total_fifth.replace("$", "");
		}
		
		if(subTotal_fifth_new.contains(","))
		{
			subTotal_fifth_new_updated = subTotal_fifth_new.replace(",", "");
		}
		
		child15.log(LogStatus.INFO, "Get the sub total when Quantity is equal to second wholesale quantity");
		
		double sub_total_fifth_actual = Double.parseDouble(subTotal_fifth_new_updated);
		
		if(volume_Discount_fifth_Actual == ((sub_total_fifth_actual * second_discount)/100))
		{
			child15.log(LogStatus.PASS, "When we are keeping Product quantity slightly more than second wholesale quantity, Volume Discount on Cart Page is calculated correct");
		}
		else
		{
			child15.log(LogStatus.FAIL, "When we are keeping Product quantity slightly more than second wholesale quantity, Volume Discount on Cart Page is not calculated correct");
		}
		
		logger.appendChild(child15);
		
		//
		//Check Tax on Cart Page whether it is calculated correct or not
		//
		child16 = report.startTest("Check Tax on Cart Page whether it is calculated correct or not");
		
		String tax_Calculated = checkoutVolumeDiscount.getTaxCalculated();
		
		child16.log(LogStatus.INFO, "Get the Tax calculated on Cart Page");
		
		if(tax_Calculated.contains("$"))
		{
			tax_calculated_new = tax_Calculated.replace("$", "");
		}
		
		double tax_calculated_Actual = Double.parseDouble(tax_calculated_new);
		
		sales_Tax = (String) jsonObject2.get("Value_Correct");
		child16.log(LogStatus.INFO, "Get the actual added Sales Tax on the creation of Sales Tax by Admin.");
		
		double sales_Tax_actual = Double.parseDouble(sales_Tax);
		
		child16.log(LogStatus.INFO, "Compare the calculated Sales Tax with Actual Sales tax added by Admin.");
		
		if(tax_calculated_Actual == ((sub_total_fifth_actual - volume_Discount_fifth_Actual)/sales_Tax_actual))
		{
			child16.log(LogStatus.PASS, "The tax calculated on Cart page is correct.");
		}
		else
		{
			child16.log(LogStatus.FAIL, "The tax calculated on Cart page is not correct.");
		}
		
		logger.appendChild(child16);
		
		//
		//Check Net Payable on Cart Page whether it is calculated correct or not
		//
		child17 = report.startTest("Check Net Payable on Cart Page whether it is calculated correct or not");
		
		String net_payable_calculated = checkoutVolumeDiscount.getNetPayable();
		
		if(net_payable_calculated.contains("$"))
		{
			net_payable_calculated_new = net_payable_calculated.replace("$", "");
		}
		
		double net_Payable_Calculated = Double.parseDouble(net_payable_calculated_new);
		
		child17.log(LogStatus.INFO, "Get the Net Payable calculated on Cart page is correct.");
				
		double calculated_sales_tax = (sub_total_fifth_actual - volume_Discount_fifth_Actual)/sales_Tax_actual;
		
		child17.log(LogStatus.INFO, "Get the calculated Sales Tax on Cart page is correct.");
		
		if(net_Payable_Calculated == (sub_total_fifth_actual - volume_Discount_fifth_Actual) + calculated_sales_tax)
		{
			child17.log(LogStatus.PASS, "The Net Payable calculated on Cart page is correct.");
		}
		else
		{
			child17.log(LogStatus.FAIL, "The Net Payable calculated on Cart page is not correct.");
		}
		
		logger.appendChild(child17);
		
		//
		//Check Whether Net Payable on Shipping Summary page is same as Net Payable on Shopping Cart Page
		//
		child18 = report.startTest("Check Whether Net Payable on Shipping Summary page is same as Net Payable on Shopping Cart Page");
		
		checkoutVolumeDiscount.clickCheckout();
		child18.log(LogStatus.INFO, "Click on Checkout button on Shopping Cart page.");
		
		String net_Payable_Shipping = checkoutVolumeDiscount.getNetPayableShipping();
		
		if(net_Payable_Shipping.contains("$"))
		{
			net_Payable_Shipping_new = net_Payable_Shipping.replace("$", "");
		}
		
		double net_Payable_Shipping_Actual = Double.parseDouble(net_Payable_Shipping_new);
		child18.log(LogStatus.INFO, "Get Net Payale on Shipping Summary Page.");
		
		if(net_Payable_Shipping_Actual == net_Payable_Calculated) 
		{
			child18.log(LogStatus.PASS, "Net Payable on Shipping Summary page is same as Net Payable on Shopping Cart Page."); 
			} 
		else 
		{ 
			child18.log(LogStatus.FAIL, "Net Payable on Shipping Summary page is not same as Net Payable on Shopping Cart Page."); 
		}

		logger.appendChild(child18);

		//
		//Check Whether User is able to complete the traction and buy the product with all Volume Discounts and price is same in Order Details on Buyer Dashboard
		// 
		child19 = report. startTest("Check Whether User is able to complete the traction and buy the product with all Volume Discounts and price is same in Order Details on Buyer Dashboard");
		
		checkoutVolumeDiscount.click_Continue_ShippingSummary();
		child19.log(LogStatus.INFO, "Click on Continue On Shipping Summary page.");
		
		addtocart.selectCreditCardSelection();
		child19.log(LogStatus.INFO, "Selecting Credit Card in Payment Summary Screen.");
		
		addtocart.clickConfirmPayment();
		child19.log(LogStatus.INFO, "Click Confirm Payment in Payment Summary Screen.");
		
		creditCardNumber = (String) jsonObject4.get("Credit Card Number");
		
		addtocart.enterCreditCardNumber(creditCardNumber);
		child19.log(LogStatus.INFO, "User is able to enter Credit Card number in Credit Card Screen.");
		
		cardHolderName = (String) jsonObject4.get("Card Holder Name");
		
		addtocart.enterCardHolderName(cardHolderName);
		child19.log(LogStatus.INFO, "User is able to enter Credit Card Holder Name in Credit Card Screen.");
		
		creditCardExpiryYear = (String) jsonObject4.get("Credit Card Expiry Year");
		
		addtocart.selectExpiryYear(creditCardExpiryYear);
		child19.log(LogStatus.INFO, "User is able to Select Credit Card Expiry Year in Credit Card Screen.");
		
		cvvSecurityCode = (String) jsonObject4.get("CVV Security Code");
		
		addtocart.enterCVVSecurityCode(cvvSecurityCode);
		child19.log(LogStatus.INFO, "User is able to enter CVV Security Code in Credit Card Screen.");
		
		addtocart.clickPayNow();
		child19.log(LogStatus.INFO, "User is able to click Pay Now in Credit Card Screen.");
		
		userSpecialPrice.clickHistory();
		child19.log(LogStatus.INFO, "Click on History link on Congratulations Screen.");
		
		userSpecialPrice.clickEyeIcon();
		child19.log(LogStatus.INFO, "Click on eye icon on Order History screen for the latest order.");
		
		String amount_orderDetailPage = checkoutVolumeDiscount.getAmountOrderDetailPage();
		child19.log(LogStatus.INFO, "Get Amount on Order History screen for the latest order.");
		
		if(amount_orderDetailPage.contains(net_Payable_Shipping))
		{
			child19.log(LogStatus.PASS, "Amount paid by user is same amount showing on Order History screen for the latest order.");
		}
		else
		{
			child19.log(LogStatus.FAIL, "Amount paid by user is not same amount showing on Order History screen for the latest order.");
		}

		logger.appendChild(child19);
		
	}
	
		
		@AfterMethod
		public void tearDown(ITestResult result) {
			//
			// If test is getting failed then take the screen shot and put it in Automation Report.
			//
			if (result.getStatus() == ITestResult.FAILURE) {
				String screenshot_path = Utility.captureScreenshot(driver, result.getName());
				String image = logger.addScreenCapture(screenshot_path);
				logger.log(LogStatus.FAIL, "Volume Discount is not correct for added product.");
				logger.log(LogStatus.FAIL, "Volume_Discount_Wrong", image);
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
