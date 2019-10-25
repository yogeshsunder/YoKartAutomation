package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.JSONObject;

//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;

//import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerShopCreationPage {
	
	WebDriver driver;
	String username,password;
	String seoUrl,postCode,phone,shipping;
	String shopName;
	String nameReturn,cityReturn,address1Return;
    JSONParser parser=new JSONParser();
	//
	//Constructor for the class SellerCreationPage
	//
	public SellerShopCreationPage(WebDriver driver) {
		//
		//Putting wait for 10 seconds in driver if driver is null so that driver can wait if the driver cannot locate the defined WebElement
		//
		if(driver == null)
			throw new IllegalArgumentException("Driver object is null");
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
		this.driver = driver;
	}
	
	//
	//Creation of private function to wait if WebElement is not visible for 120 seconds and this function can be used in this class to wait for Web elements.
	//
	private void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	@FindBy(how=How.CSS,using=".sign-in > span:nth-child(2) > strong:nth-child(1)")
	WebElement clicklogin;
	
	@FindBy(how=How.NAME,using="username")
	WebElement usrname;
	
	@FindBy(how=How.NAME,using="password")
	WebElement pwd;
	
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement sbmnit;
	
	public void sellerLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		username = (String) jsonObject.get("MailId");
		password = (String) jsonObject.get("PasswordForRegistrationDetails");		
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		waitForVisibility(clicklogin);
		clicklogin.click();
		waitForVisibility(usrname);
		usrname.clear();
		usrname.sendKeys(username);
		waitForVisibility(pwd);
		pwd.clear();
		pwd.sendKeys(password);
		sbmnit.click();
		
	}
	
	//
	//WebElement of Hi user
	//
	@FindBy(how=How.CSS,using=".icn-txt")
	WebElement hiUser;
	
	//
	//WebElement of Dashboard link
	//
	@FindBy(how=How.XPATH,using="//a[@href='/seller']")
	WebElement dashboard;
	
	//
	//Function to go to Dashboard from user drop down list
	//
	public void gotoDashboard() throws InterruptedException
	{
		Thread.sleep(5000);
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		waitForVisibility(hiUser);
		hiUser.click();
		waitForVisibility(dashboard);
		dashboard.click();
	}
	
	//
	//WebElement of Create shop button on seller dashboard
	//
	@FindBy(how=How.CSS,using="#main-area > div > div.content-header.row.justify-content-between.mb-3 > div:nth-child(2) > div > a:nth-child(1)")
	WebElement createShop;
	
	//
	//Function to click on Create shop button on seller dashboard
	//
	public void clickOnCreateShopButton()
	{
		createShop.click();
	}
	
	//--------------------------------------------------------Shop Setup General--------------------------------------------------------
	//
	//WebElement of mandatory validation error message of Identifier field of Shop Setup General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_shop_identifier")
	WebElement mandatoryIdentifier;
	
	//
	//Function to get mandatory validation error message of Identifier field of Shop Setup General form
	//
	public String getMandatoryIdentifier()
	{
		waitForVisibility(mandatoryIdentifier);
		return mandatoryIdentifier.getText();
	}
	
	//
	//WebElement of identifier of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_identifier")
	WebElement identifierGeneral;
	
	//
	//Function to enter identifier of General form of Shop Setup
	//
	public void enterIdentifierGeneral(String identifier)
	{
		waitForVisibility(identifierGeneral);
		identifierGeneral.clear();
		identifierGeneral.sendKeys(identifier);
	}
	
	//
	//WebElement of mandatory validation error message of Shop SEO Friendly URL field of Shop Setup General form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_urlrewrite_custom")
	WebElement mandatorySEOFriendlyURL;
	
	//
	//Function to get mandatory validation error message of Shop SEO Friendly URL field of Shop Setup General form
	//
	public String getMandatorySEOFriendlyURL()
	{
		waitForVisibility(mandatorySEOFriendlyURL);
		return mandatorySEOFriendlyURL.getText();
	}
	
	//
	//WebElement of Shop SEO Friendly URL of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="urlrewrite_custom")
	WebElement shopSEOFriendlyURL;
	
	//
	//Function to enter Shop SEO Friendly URL of General form of Shop Setup
	//
	public void enterShopSEOFriendlyURL(String seofriendlyurl)
	{
		waitForVisibility(shopSEOFriendlyURL);
		shopSEOFriendlyURL.clear();
		shopSEOFriendlyURL.sendKeys(seofriendlyurl);
	}
	
	//
	//WebElement of Postalcode of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_postalcode")
	WebElement postalcode;
	
	//
	//WebElement of Phone of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_phone")
	WebElement phoneNumber;
	
	//
	//WebElement of validation error message of State field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_shop_state")
	WebElement mandatoryState;
	
	//
	//Function to get validation error message of State field
	//
	public String getMandatoryState()
	{
		waitForVisibility(mandatoryState);
		return mandatoryState.getText();
	}
	
	//
	//WebElement of Country of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_country_id")
	WebElement countryDrpDown;
	
	//
	//WebElement of State of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_state")
	WebElement stateDrpDown;
	
	//
	//WebElement of Display Status of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_supplier_display_status")
	WebElement displayStatusdrpDown;
	
	//
	//WebElement of Free Shipping On of General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_free_ship_upto")
	WebElement freeShippingOn;
	
	//
	//WebElement of Save Changes button On General form of Shop Setup
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChangesButton;
	
	//
	//Function to click on Save Changes button On General form of Shop Setup
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChangesButton);
		saveChangesButton.click();
	}
	
	//
	//Function for filling General Shop Setup form
	//
	public void fillGeneralShopSetupform() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		seoUrl = (String) jsonObject1.get("Shop SEO Friendly URL");
		postCode = (String) jsonObject1.get("POSTCODE");
		phone = (String) jsonObject1.get("PHONE");
		shipping = (String) jsonObject1.get("Free Shipping On");
		
		String uuid = UUID.randomUUID().toString();
		
		Thread.sleep(2000);
		waitForVisibility(identifierGeneral);
		identifierGeneral.sendKeys(uuid);
		shopSEOFriendlyURL.clear();
		shopSEOFriendlyURL.sendKeys(seoUrl);
		postalcode.sendKeys(postCode);
		phoneNumber.sendKeys(phone);
		
		Select countrydropdown = new Select(countryDrpDown);
		countrydropdown.selectByValue("99");
		
		Thread.sleep(500);
		Select statedropdown = new Select(stateDrpDown);
		statedropdown.selectByValue("1294");
		freeShippingOn.sendKeys(shipping);
		saveChangesButton.click();
		
	}
	
	//--------------------------------------------------------Shop Setup English--------------------------------------------------------
	//
	//WebElement of Shop Name of English form of Shop Setup
	//
	@FindBy(how=How.NAME,using="shop_name")
	WebElement shopname;
	
	//
	//Function to click on Save Changes button On English form of Shop Setup
	//
	public void clickOnSaveChangesEnglish() throws InterruptedException
	{
		Thread.sleep(2500);
		waitForVisibility(saveChangesButton);
		saveChangesButton.click();
	}
	
	//
	//WebElement of mandatory validation error message of Shop Name field of Shop Setup English form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_shop_name")
	WebElement mandatoryShopName;
	
	//
	//Function to get mandatory validation error message of Shop Name field of Shop Setup English form
	//
	public String getMandatoryShopName()
	{
		waitForVisibility(mandatoryShopName);
		return mandatoryShopName.getText();
	}
	
	//
	//Function to enter Shop Name of English form of Shop Setup
	//
	public void enterShopnameforEnglish() throws FileNotFoundException, IOException, ParseException
	{
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject2 = (JSONObject) obj1;
		shopName = (String) jsonObject2.get("Shop Name*");
		waitForVisibility(shopname);
		shopname.sendKeys(shopName);
		saveChangesButton.click();
	}
	
	//--------------------------------------------------------Shop Setup Arabic--------------------------------------------------------
	//
	//WebElement of Shop Name of English form of Shop Setup
	//
	//@FindBy(how=How.NAME,using="shop_name")
	//WebElement shopname;
	
	//
	//Function to enter Shop Name of English form of Shop Setup
	//
	public void enterShopnameforArabic() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject3 = (JSONObject) obj1;
		shopName = (String) jsonObject3.get("Shop Name*");
		
		Thread.sleep(2000);
		waitForVisibility(saveChangesButton);
		saveChangesButton.click();
		waitForVisibility(shopname);
		shopname.sendKeys(shopName);
		saveChangesButton.click();
	}
	
	//--------------------------------------------------------Return Address--------------------------------------------------------
	//
	//WebElement of mandatory validation error message of Country drop down
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ura_country_id")
	WebElement mandatoryCountryName;
	
	//
	//Function to get mandatory validation error message of Country drop down
	//
	public String getMandatoryCountryName()
	{
		waitForVisibility(mandatoryCountryName);
		return mandatoryCountryName.getText();
	}
	
	//
	//WebElement of Country drop down of Return Address General form of Shop Setup
	//
	@FindBy(how=How.ID,using="ura_country_id")
	WebElement countryreturnaddressdrpdown;
	
	//
	//Function to click on Country drop down of Return Address General form of Shop Setup
	//
	public void selectCounty(String country_value)
	{
		waitForVisibility(countryreturnaddressdrpdown);
		Select countryreturn = new Select(countryreturnaddressdrpdown);
		countryreturn.selectByValue(country_value);
	}
	
	//
	//WebElement of Mandatory Validation error message of State drop down of Return Address General form of Shop Setup
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ura_state_id")
	WebElement mandatoryReturnState;
	
	//
	//Function to get Mandatory Validation error message of State drop down of Return Address General form of Shop Setup
	//
	public String getMandatoryReturnState()
	{
		waitForVisibility(mandatoryReturnState);
		return mandatoryReturnState.getText();
	}
	
	//
	//WebElement of State drop down of Return Address General form of Shop Setup
	//
	@FindBy(how=How.ID,using="ura_state_id")
	WebElement statereturnaddressdrpdown;
	
	//
	//Function to click on State drop down of Return Address General form of Shop Setup
	//
	public void selectState(String state_value)
	{
		waitForVisibility(statereturnaddressdrpdown);
		Select statereturn = new Select(statereturnaddressdrpdown);
		statereturn.selectByValue(state_value);
	}
	
	//
	//WebElement of validation error message of Return Address English Name field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ura_name")
	WebElement mandatoryReturnEnglishName;
	
	//
	//Function to get validation error message of Return Address English Name field
	//
	public String getMandatoryReturnEnglishName()
	{
		waitForVisibility(mandatoryReturnEnglishName);
		return mandatoryReturnEnglishName.getText();
	}
	
	//
	//WebElement of Name of Return Address English form of Shop Setup
	//
	@FindBy(how=How.NAME,using="ura_name")
	WebElement nameReturnenglishform;
	
	//
	//Function to enter Name of Return Address English form of Shop Setup
	//
	public void enterReturnAddressEnglishName(String return_address)
	{
		waitForVisibility(nameReturnenglishform);
		nameReturnenglishform.sendKeys(return_address);
	}
	
	//
	//WebElement of validation error message of City field of Return Address English form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ura_city")
	WebElement mandatoryReturnEnglishCity;
	
	//
	//Function to get validation error message of City field of Return Address English form
	//
	public String getMandatoryReturnEnglishCity()
	{
		waitForVisibility(mandatoryReturnEnglishCity);
		return mandatoryReturnEnglishCity.getText();
	}
	
	//
	//WebElement of City of Return Address English form of Shop Setup
	//
	@FindBy(how=How.NAME,using="ura_city")
	WebElement cityReturnenglishform;
	
	//
	//Function to enter City of Return Address English form of Shop Setup
	//
	public void enterReturnAddressEnglishCity(String return_city)
	{
		waitForVisibility(cityReturnenglishform);
		cityReturnenglishform.sendKeys(return_city);
	}
	
	//
	//WebElement of validaiton error message of Address1 field of Return Address English Form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ura_address_line_1")
	WebElement mandatoryAddress1ReturnEnglish;
	
	//
	//Function to get validaiton error message of Address1 field of Return Address English Form
	//
	public String getMandatoryAddress1ReturnEnglish()
	{
		waitForVisibility(mandatoryAddress1ReturnEnglish);
		return mandatoryAddress1ReturnEnglish.getText();
	}
	
	//
	//WebElement of Address1 of Return Address English form of Shop Setup
	//
	@FindBy(how=How.NAME,using="ura_address_line_1")
	WebElement address1Returnenglishform;
	
	//
	//Function to enter Address1 of Return Address English form of Shop Setup
	//
	public void enterAddress1ReturnAddressEnglish(String address1_english)
	{
		waitForVisibility(address1Returnenglishform);
		address1Returnenglishform.sendKeys(address1_english);
	}
	
	//
	//Function to fill Return Address General form of Shop Setup
	//
	public void fillReturnAddressGeneralform() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(countryreturnaddressdrpdown);
		Select cntryreturn = new Select(countryreturnaddressdrpdown);
		cntryreturn.selectByValue("99");
		waitForVisibility(statereturnaddressdrpdown);
		Select statereturn = new Select(statereturnaddressdrpdown);
		statereturn.selectByValue("1267");
		saveChangesButton.click();
	}
	
	//
	//Function to fill Return Address English form of Shop Setup
	//
	public void fillReturnAddressEnglishform() throws FileNotFoundException, IOException, ParseException
	{
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		nameReturn = (String) jsonObject1.get("Name Return Address*");
		cityReturn = (String) jsonObject1.get("City Return Address*");
		address1Return = (String) jsonObject1.get("Address1 Return Address*");
		
		waitForVisibility(nameReturnenglishform);
		nameReturnenglishform.sendKeys(nameReturn);
		cityReturnenglishform.sendKeys(cityReturn);
		address1Returnenglishform.sendKeys(address1Return);
		saveChangesButton.click();
	}

	//
	//Function to fill Return Address English form of Shop Setup
	//
	public void fillReturnAddressArabicform() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj1 = parser.parse(new FileReader("src/test/java/JSONData/sellerShopCreationInputData.json"));
		JSONObject jsonObject1 = (JSONObject) obj1;
		nameReturn = (String) jsonObject1.get("Name Return Address*");
		cityReturn = (String) jsonObject1.get("City Return Address*");
		address1Return = (String) jsonObject1.get("Address1 Return Address*");
		
		Thread.sleep(2000);
		waitForVisibility(nameReturnenglishform);
		nameReturnenglishform.sendKeys(nameReturn);
		cityReturnenglishform.sendKeys(cityReturn);
		address1Returnenglishform.sendKeys(address1Return);
		//saveChangesButton.click();
	}
	
	//
	//WebElement of success message
	//
	@FindBy(how=How.ID,using="mbsmessage")
	WebElement success;
	
	public String getsuccessmessage() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(success);
		return success.getText();
	}
}
