package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAddtoCartPage {
	
WebDriver driver;
	
	public UserAddtoCartPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of lastest product name created by seller
	//
	@FindBy(how=How.CLASS_NAME,using="item__sub_title")
	WebElement productName;
	
	//
	//Function to get latest product name created by seller
	//
	public String getProductName()
	{
		waitForVisibility(productName);
		return productName.getText();
	}
	
	//
	//WebElement of avatar of logged in seller
	//
	@FindBy(how=How.CLASS_NAME,using="my-account__avatar")
	WebElement avatar;
	
	//
	//Function to click on avatar of logged in seller
	//
	public void clickOnAvatar()
	{
		waitForVisibility(avatar);
		avatar.click();
	}
	
	//
	//WebElement of logout option of logged in seller
	//
	@FindBy(how=How.XPATH,using="//a[@href='/guest-user/logout']")
	WebElement logoutSeller;
	
	//
	//Function to click on logout option of logger in seller
	//
	public void clickOnLogout()
	{
		waitForVisibility(logoutSeller);
		logoutSeller.click();
	}
	
	//
	//WebElement of Toggle bar icon on dashboard of logged in user
	//
	@FindBy(how=How.CLASS_NAME,using="hamburger-toggle")
	WebElement toggler;
	
	//
	//Function to click on Toggle bar icon on dashboard of logged in user
	//
	public void clickToggleBarIcon()
	{
		waitForVisibility(toggler);
		toggler.click();
	}	
	
	//
	//WebElement of logo dashboard of logged in user
	//
	@FindBy(how=How.CLASS_NAME,using="logo-dashboard")
	WebElement logoDashboard;
	
	//
	//Function to click on logo on the dashboard of logged in user
	//
	public void clickOnLogoDashboard() throws InterruptedException
	{
		Thread.sleep(1500);
		waitForVisibility(logoDashboard);
		logoDashboard.click();
	}
	
	//
	//WebElement of Search bar on homepage
	//
	@FindBy(how=How.ID,using="header_search_keyword")
	WebElement searchBar;
	
	//
	//Function to enter product in search bar of homepage
	//
	public void enterProductinSearch(String enter_product)
	{
		waitForVisibility(searchBar);
		searchBar.sendKeys(enter_product);
	}
	
	//
	//WebElement of search button on search bar of homepage
	//
	@FindBy(how=How.NAME,using="btnSiteSrchSubmit")
	WebElement searchButton;
	
	//
	//WebElement of click on search button on search bar of homepage
	//
	@FindBy(how=How.CLASS_NAME,using="yokart-loader")
	WebElement loader;
	
	//
	//Function to click on search button on search bar of homepage
	//
	public void clickOnSearchButton()
	{
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(loader));
		waitForVisibility(searchButton);
		searchButton.click();
	}
	
	//
	//WebElement of product image on searched product page
	//
	@FindBy(how=How.CLASS_NAME,using="products__img")
	WebElement productImage;
	
	//
	//Function to click on product image on searched product page
	//
	public void clickOnProductImage()
	{
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(loader));
		waitForVisibility(productImage);
		productImage.click();
	}
	
	//
	//WebElement of quantity input field
	//
	@FindBy(how=How.NAME,using="quantity")
	WebElement quantity;
	
	//
	//Function to enter quantity in QUANTITY input field
	//
	public void enterQuantity(String enter_quantity)
	{
		new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(loader));
		waitForVisibility(quantity);
		quantity.clear();
		quantity.sendKeys(enter_quantity);
	}
	
	
	//
	//WebElement of Add to Cart on product detail page
	//
	@FindBy(how=How.ID,using="btnAddToCart")
	WebElement addToCart;
	
	//
	//Function to click on Add to Cart on product detail page
	//
	public void clickonAddToCart() throws InterruptedException
	{
		Thread.sleep(5000);
		waitForVisibility(addToCart);
		addToCart.click();
	}
	
	//
	//WebElement of cart option at top to go to cart
	//
	@FindBy(how=How.CLASS_NAME,using="cartQuantity")
	WebElement clickCart;
	
	//
	//Function to click on cart to go to cart
	//
	public void clickOnCart() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(clickCart);
		clickCart.click();
	}
	
	//
	//WebElement of View Bag in product detail page's cart side pop up
	//
	@FindBy(how=How.XPATH,using="//a[@href='/cart']")
	WebElement viewBag;
	
	//
	//Function to click on View Bag in product detail page's cart side pop up
	//
	public void clickViewBag() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(viewBag);
		viewBag.click();
	}
	
	//
	//WebElement of Checkout in cart Page
	//
	@FindBy(how=How.XPATH,using="//a[@onclick='goToCheckout()']")
	WebElement checkOut;
	
	//
	//Function to click on Checkout in cart Page
	//
	public void clickonCheckout() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(checkOut);
		checkOut.click();
	}
	
	//
	//WebElement of Save Changes button in Billing Address form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button in Billing Address form
	//
	public void clickSaveChanges() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	
	//
	//WebElement of Validation error message of field Name in Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_name")
	WebElement mandatoryValidationName;
	
	//
	//Function to get Validation error message of field Name in Billing Address form
	//
	public String getMandatoryValidationName()
	{
		waitForVisibility(mandatoryValidationName);
		return mandatoryValidationName.getText();
	}
	
	//
	//WebElement of name field in Billing Address form
	//
	@FindBy(how=How.NAME,using="ua_name")
	WebElement name;
	
	//
	//Function to enter name in name field in Billing Address form
	//
	public void enterName(String entername)
	{
		waitForVisibility(name);
		name.clear();
		name.sendKeys(entername);
	}
	
	//
	//WebElement of Validation error message of field Address Line1 in Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_address1")
	WebElement mandatoryValidationAddressLine1;
	
	//
	//Function to get Validation error message of field Address Line1 in Billing Address form
	//
	public String getMandatoryValidationAddressLine1()
	{
		waitForVisibility(mandatoryValidationAddressLine1);
		return mandatoryValidationAddressLine1.getText();
	}
	
	//
	//WebElement of Address Line 1 field in Bililng Address form
	//
	@FindBy(how=How.NAME,using="ua_address1")
	WebElement addressLine1;
	
	//
	//Function to enter Address Line 1 field in Bililng Address form
	//
	public void enterAddressLine1(String addline1)
	{
		addressLine1.clear();
		addressLine1.sendKeys(addline1);
	}
	
	//
	//WebElement of Validation error message of field State in Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_state_id")
	WebElement mandatoryValidationState;
	
	//
	//Function to get Validation error message of field State in Billing Address form
	//
	public String getMandatoryValidationState()
	{
		waitForVisibility(mandatoryValidationState);
		return mandatoryValidationState.getText();
	}
	
	//
	//WebElement of State drop down
	//
	@FindBy(how=How.ID,using="ua_state_id")
	WebElement stateDropDown;
	
	//
	//Function to select value from state drop down
	//
	public void selectDropDown(String state_value)
	{
		Select state = new Select(stateDropDown);
		state.selectByValue(state_value);
	}
	
	//
	//WebElement of validation error message of City field of Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_city")
	WebElement cityMandatory;
	
	//
	//Function to get validation error message of City field of Billing Address form
	//
	public String getCityValidation()
	{
		waitForVisibility(cityMandatory);
		return cityMandatory.getText();
	}
	
	//
	//WebElement of City field of Billing Address form
	//
	@FindBy(how=How.NAME,using="ua_city")
	WebElement city;
	
	//
	//Function to enter City field of Billing Address form
	//
	public void enterCity(String enter_city)
	{
		waitForVisibility(city);
		city.clear();
		city.sendKeys(enter_city);
	}
	
	//
	//WebElement of Postalcode validation error message of Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_zip")
	WebElement postalCode;
	
	//
	//Function to get Postalcode validation error message of Billing Address form
	//
	public String getValidationPostalCode()
	{
		waitForVisibility(postalCode);
		return postalCode.getText();
	}
	
	//
	//WebElement of Postalcode field of Billing Address form
	//
	@FindBy(how=How.NAME,using="ua_zip")
	WebElement postalcode;
	
	//
	//Function to enter Postalcode field of Billing Address form
	//
	public void enterPostalCode(String enter_postalcode)
	{
		waitForVisibility(postalcode);
		postalcode.clear();
		postalcode.sendKeys(enter_postalcode);
	}
	
	//
	//WebElement of validation error message of Phone field of Billing Address form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ua_phone")
	WebElement phone;
	
	//
	//Function to get validation error message of Phone field of Billing Address form
	//
	public String getValidationMessagePhone()
	{
		waitForVisibility(phone);
		return phone.getText();
	}
	
	//
	//WebElement of Phone number field of Billing Address form
	//
	@FindBy(how=How.NAME,using="ua_phone")
	WebElement phoneNumber;
	
	//
	//Function to enter phone number in Phone number field of Billing Address form
	//
	public void enterPhoneNumber(String enter_phone)
	{
		waitForVisibility(phoneNumber);
		phoneNumber.clear();
		phoneNumber.sendKeys(enter_phone);
	}
	
	//
	//WebElement of success message coming in setting up Billing Address
	//
	@FindBy(how=How.ID,using="mbsmessage")
	WebElement successBilling;
	
	//
	//Function to get success message coming in setting up Billing Address
	//
	public String getSuccessBilling()
	{
		waitForVisibility(successBilling);
		return successBilling.getText();
	}
	
	//
	//WebElement of Continue button on Shipping Summary screen
	//
	@FindBy(how=How.CLASS_NAME,using="btn--primary")
	WebElement continueShippingSummary;
	
	//
	//Function to click on Continue button on Shipping Summary screen
	//
	public void clickContinueShippingSummary() throws InterruptedException
	{
		Thread.sleep(15000);
		//waitForVisibility(continueShippingSummary);
		continueShippingSummary.click();
	}
	
	//
	//WebElement of Selecting Credit Card in Payment Summary screen
	//
	@FindBy(how=How.XPATH,using="//*[@id=\"payment_methods_tab\"]/div[1]/div[2]/div/div/div/li[3]/a")
	WebElement creditCardSelection;
	
	//
	//Function to Select Credit Card in Payment Summary screen
	//
	public void selectCreditCardSelection() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(creditCardSelection);
		creditCardSelection.click();
	}
	
	//
	//WebElement of Confirm Payment button on Payment Summary screen
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Confirm Payment']")
	WebElement confirmPayment;
	
	//
	//Function to click on Confirm Payment button on Payment Summary screen
	//
	public void clickConfirmPayment()
	{
		waitForVisibility(confirmPayment);
		confirmPayment.click();
	}
	
	//
	//WebElement of Credit Card field in Credit Card screen
	//
	@FindBy(how=How.ID,using="cc_number")
	WebElement creditCardNumber;
	
	//
	//Function to enter Credit Card in Credit Card screen
	//
	public void enterCreditCardNumber(String enter_creditcard)
	{
		waitForVisibility(creditCardNumber);
		creditCardNumber.sendKeys(enter_creditcard);
	}
	
	//
	//WebElement of Card Holder Name field in Credit Card screen
	//
	@FindBy(how=How.NAME,using="cc_owner")
	WebElement cardHolderName;
	
	//
	//Function to enter Card Holder Name field in Credit Card screen
	//
	public void enterCardHolderName(String cardHolder_name)
	{
		waitForVisibility(cardHolderName);
		cardHolderName.sendKeys(cardHolder_name);
	}
	
	//
	//WebElement of Credit Card Expiry Year in Credit Card screen
	//
	@FindBy(how=How.ID,using="ccExpYear")
	WebElement expiryYear;
	
	//
	//Function to select Credit Card Expiry Year in Credit Card screen
	//
	public void selectExpiryYear(String expiry_year)
	{
		waitForVisibility(expiryYear);
		Select expiryyear = new Select(expiryYear);
		expiryyear.selectByValue(expiry_year);
	}
	
	//
	//WebElement to enter CVV Security Code in Credit Card screen
	//
	@FindBy(how=How.NAME,using="cc_cvv")
	WebElement cvvSecurityCode;
	
	//
	//Function to enter CVV Security Code in Credit Card screen
	//
	public void enterCVVSecurityCode(String security_code)
	{
		waitForVisibility(cvvSecurityCode);
		cvvSecurityCode.sendKeys(security_code);
	}
	
	//
	//WebElement of Pay Now button in Credit Card screen
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement payNow;
	
	//
	//Function to click on Pay Now button in Credit Card screen
	//
	public void clickPayNow()
	{
		waitForVisibility(payNow);
		payNow.click();
	}
	
	//
	//WebElement of Success Message on payment success screen
	//
	@FindBy(how=How.CLASS_NAME,using="section__heading")
	WebElement successMessage;
	
	//
	//Function to get Success Message on payment success screen
	//
	public String getSuccessMessage()
	{
		waitForVisibility(successMessage);
		return successMessage.getText();
	}

}
