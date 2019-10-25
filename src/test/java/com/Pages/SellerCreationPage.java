/**
 * 
 */
package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Yogesh
 *
 */
public class SellerCreationPage {
	
	WebDriver driver;
	String mailid,yname;
	String usernameForRegistrationDetails,passwordForRegistrationDetails,confirmPasswordforRegistrationDetails;
	String businessName,txt,txtarea,time;
	private String today;
    JSONParser parser=new JSONParser();
	//
	//Constructor for the class SellerCreationPage
	//
	public SellerCreationPage(WebDriver driver) {
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
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//Creation of private function to Get The Current Day from any Calendar
	//
    private String getCurrentDay (){
        //Create a Calendar Object
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
 
        //Get Current Day as a number
        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
        //System.out.println("Today Int: " + todayInt +"\n");
 
        //Integer to String Conversion
        String todayStr = Integer.toString(todayInt);
        //System.out.println("Today Str: " + todayStr + "\n");
 
        return todayStr;
    }

	//
	///Web Element for Open a Store Button of the bottom of the Home page.
	//
	@FindBy(how=How.XPATH,using="//a[@href='/supplier']")
	WebElement clickOpenaStore;
	
	//
	//Click on Open a Store Button from the bottom of the Home page.
	//
	public void clickonOpenaStore()
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		clickOpenaStore.click();
	}
	
	//--------------------------------------------------Register Today------------------------------------------------------------------
	//
	//Web Element for "Your Email" field of Register Today form.
	//
	@FindBy(how=How.NAME,using="user_email")
	WebElement enterEmail;
	
	//
	//Function to enter "Your Email" field of Register Today form.
	//
	public void enterYourEmail(String youremail)
	{
		waitForVisibility(enterEmail);
		enterEmail.clear();
		enterEmail.sendKeys(youremail);
	}
	
	//
	//Web Element for Your Name in Register today form.
	//
	@FindBy(how=How.NAME,using="user_name")
	WebElement enteryourname;
	
	//
	//Function of entering Your Name in Register today form
	//
	public void enterYourName(String enter_your_name)
	{
		waitForVisibility(enteryourname);
		enteryourname.clear();
		enteryourname.sendKeys(enter_your_name);
	}
	
	//
	//Web Element for Start Selling Button.
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSeller > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > input:nth-child(1)")
	WebElement clickStartSelling;
	
	//
	//Function to click on Start Selling Button.
	//
	public void clickOnStartSelling()
	{
		waitForVisibility(clickStartSelling);
		clickStartSelling.click();
	}
	
	//
	//WebElement of mandatory validation error message of Your Email field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_email")
	WebElement mandatoryYourEmail;
	
	//
	//Function of getting mandatory validation error message of Your Email field
	//
	public String getMandatoryYourEmail()
	{
		waitForVisibility(mandatoryYourEmail);
		return mandatoryYourEmail.getText();
	}
	
	//
	//WebElement of mandatory validation error message of Your Name field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_name")
	WebElement mandatoryYourName;
	
	//
	//Function of getting mandatory validation error message of Your Name  field
	//
	public String getMandatoryYourName()
	{
		waitForVisibility(mandatoryYourName);
		return mandatoryYourName.getText();
	}
	
	//
	//Fill Email id, Your name and click on start selling button in Register today form
	//
	public void fillRegisterTodayForm() throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		mailid = (String) jsonObject.get("MailId");
		yname = (String) jsonObject.get("YourName");
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		waitForVisibility(enterEmail);
		enterEmail.sendKeys(mailid);
		enteryourname.sendKeys(yname);		
		clickStartSelling.click();
	}
		
	//--------------------------------------------------Seller Registration Details--------------------------------------------------------
	//
	//WebElement for Mandatory validation error message of Username field in Seller Registration Details form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_username")
	WebElement mandatoryUserName;
	
	//
	//Function to get Mandatory validation error message of Username field in Seller Registration Details form
	//
	public String getMandatoryUserName()
	{
		waitForVisibility(mandatoryUserName);
		return mandatoryUserName.getText();
	}
	
	//
	//Web Element for User Name in Seller Registration Details form
	//
	@FindBy(how=How.NAME,using="user_username")
	WebElement username;
	
	//
	//Function to enter User Name in Seller Registration Details form
	//
	public void enterUserName(String user_name)
	{
		waitForVisibility(username);
		username.clear();
		username.sendKeys(user_name);
	}
	
	//
	//WebElement of mandatory validation error message of Password field in Seller Registration Details form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_password")
	WebElement mandatoryPassword;
	
	//
	//Function of getting mandatory validation error message of Password field in Seller Registration Details form
	//
	public String getMandatoryPassword()
	{
		waitForVisibility(mandatoryPassword);
		return mandatoryPassword.getText();
	}
			
	//
	//Web Element for Password in Seller Registration Details form
	//
	@FindBy(how=How.NAME,using="user_password")
	WebElement password;
	
	//
	//Function to enter password in Seller Registration Details form
	//
	public void enterPassword(String enterpassword)
	{
		waitForVisibility(password);
		password.clear();
		password.sendKeys(enterpassword);
	}
	
	//
	//WebElement for mandatory validation error message of Confirm Password in Seller Registration Details form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_password1")
	WebElement mandatoryConfirmPassword;
	
	//
	//Funciton to get mandatory validation error message of Confirm Password in Seller Registration Details form
	//
	public String getMandatoryConfirmPassword()
	{
		waitForVisibility(mandatoryConfirmPassword);
		return mandatoryConfirmPassword.getText();
	}
	
	//
	//Web Element for Confirm Password in Seller Registration Details form
	//
	@FindBy(how=How.NAME,using="password1")
	WebElement cnfmpassword;
	
	//
	//Function to enter Confirm Password in Seller Registration Details form
	//
	public void enterConfirmPassword(String confirm_password)
	{
		waitForVisibility(cnfmpassword);
		cnfmpassword.clear();
		cnfmpassword.sendKeys(confirm_password);
	}
	
	//
	//WebElement of Mandatory validation error message of Terms & Conditions field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_agree")
	WebElement mandatoryTermsConditions;
	
	//
	//Function to get Mandatory validation error message of Terms & Conditions field
	//
	public String getMandatoryTermsConditions()
	{
		waitForVisibility(mandatoryTermsConditions);
		return mandatoryTermsConditions.getText();
	}

	//
	//Web Element of agree on Terms and Conditions in Seller Registration Details form
	//
	@FindBy(how=How.NAME,using="agree")
	WebElement agre;
	
	//
	//Function to agree on Terms and Conditions in Seller Registration Details form
	//
	public void clickOnTermsConditions()
	{
		//waitForVisibility(agre);
		agre.click();
	}

	//
	//Web Element for Submit button in Seller Registration Details form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSellerRegistration > div:nth-child(3) > div > div > div.field-wraper > div > input[type=\"submit\"]:nth-child(2)")
	WebElement submit;
	
	//
	//Function to click on Submit button in Seller Registration Details form
	//
	public void clickOnSubmit()
	{
		waitForVisibility(submit);
		submit.click();
	}
	
	//
	//Fill User Name, Password, Confirm Password and click on agree radio button and submit button in Seller Registration Details form
	//
	public void fillSellerRegistrationDetails() throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		usernameForRegistrationDetails = (String) jsonObject.get("UsernameForRegistrationDetails");
		passwordForRegistrationDetails = (String) jsonObject.get("PasswordForRegistrationDetails");
		confirmPasswordforRegistrationDetails = (String) jsonObject.get("ConfirmPasswordforRegistrationDetails");
		
		waitForVisibility(username);
		username.sendKeys(usernameForRegistrationDetails);
		password.sendKeys(passwordForRegistrationDetails);
		cnfmpassword.sendKeys(confirmPasswordforRegistrationDetails);
		agre.click();
		submit.click();
	}
	
	//
	//--------------------------------------------------Seller Registration Activation------------------------------------------------------
	//
	//WebElement of Business Name input field in Seller Registration Activation form
	//
	
	@FindBy(how=How.NAME,using="sformfield_1")
	WebElement frmfield;
	
	//
	//WebElement of Text field in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(4) > div > div > div.field-wraper > div > input[type=\"text\"]")
	WebElement text;
	
	//
	//WebElement of Text Area in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(5) > div > div > div.field-wraper > div > textarea")
	WebElement textarea;
	
	//
	//WebElement of Upload file in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(6) > div > div > div.field-wraper > div > input[type=\"button\"]")
	WebElement clickupload;
	
	//
	//WebElement of date calendar field in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(7) > div > div > div.field-wraper > div > input[type=\"text\"]")
	WebElement clickclndr;
	
	//
	//WebElement of tbody of date calendar to pick all dates in tr of the table in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#ui-datepicker-div > table > tbody")
	WebElement pickdate;
	
	//
	//WebElement of date Time calendar field in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(8) > div > div > div.field-wraper > div > input[type=\"text\"]")
	WebElement clickclndrtime;
	
	//
	//WebElement of Time calendar field in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#frm_fat_id_frmSupplierForm > div:nth-child(9) > div > div > div.field-wraper > div > input[type=\"text\"]")
	WebElement clicktime;
	
	//
	//WebElement of OK button of Calendar of calendar field in Seller Registration Activation form
	//
	@FindBy(how=How.CSS,using="#ui-datepicker-div > div.ui-datepicker-buttonpane.ui-widget-content > button.ui-datepicker-close.ui-state-default.ui-priority-primary.ui-corner-all")
	WebElement clickOKtime;

	//
	//WebElement of Save Changes button in Seller Registration Activation form
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement savechngs;
	
	//
	//WebElement of box cookies overlay to show save changes button in Seller Registration Activation form
	//
	@FindBy(how=How.CLASS_NAME,using="box-cookies")
	WebElement boxCookes;
	
	//
	//Function to click on Save Changes button in Seller Registration Activation form
	//
	public void clickOnSaveChangesActivationForm() throws InterruptedException
	{
		
		Thread.sleep(2000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		jse.executeScript("arguments[0].scrollIntoView();", savechngs);
		//driver.manage().getCookies().clear();
		Thread.sleep(1000);
		waitForVisibility(savechngs);
		savechngs.click();
	}
	
	//
	//WebElement of mandatory Validation error message of Bussiness Name field of Seller Registration Activation form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_sformfield_1")
	WebElement mandatoryValidationBussinessName;
	
	//
	//Function of getting mandatory Validation error message of Bussiness Name field of Seller Registration Activation form
	//
	public String getMandatoryValidationBussinessName()
	{
		waitForVisibility(mandatoryValidationBussinessName);
		return mandatoryValidationBussinessName.getText();
	}
		
	//
	//Enter Business Name and click on Save Changes button with waiting for Web Elements to visible in Seller Registration Activation form
	//
	public void fillSellerRegistrationActivationform() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerCreationInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		businessName = (String) jsonObject.get("BusinessName");
		txt = (String) jsonObject.get("TEXT");
		txtarea = (String) jsonObject.get("TEXTAREA");
		time = (String) jsonObject.get("TIME");
		
		waitForVisibility(frmfield);
		frmfield.sendKeys(businessName);

		//
		//Enter value in text field.
		//
		waitForVisibility(text);
		text.sendKeys(txt);
		
		//
		//Enter value in text Area.
		//
		waitForVisibility(textarea);
		textarea.sendKeys(txtarea);
		
		//
		//scroll page to down
		//
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 600);");
		
		//
		//Upload document
		//
		waitForVisibility(clickupload);
		clickupload.click();
		//Get the Auto IT exe file executed
		//Runtime.getRuntime().exec("C:\\Users\\QC\\Desktop\\UploadFileSellerRegistration.exe");
		Runtime.getRuntime().exec("UploadFileSellerRegistration.exe");
		
		//---------------------------Handling date/calander field--------------------------------------------------------------------------------------
		//Click on the field to open the calendar
		//
		waitForVisibility(clickclndr);
		clickclndr.click();
		
		//
		//
		//
		waitForVisibility(pickdate);
		//WebElement dateWidgetFrom = pickdate;
		
		//Get today's date and put it in today so that we can use it in the clicking on date of the calendar 
		today = getCurrentDay();
		 
	    //These are the rows of the from date picker table
	    //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
	 
	    //These are the columns of the from date picker table
	    List<WebElement> columns = pickdate.findElements(By.tagName("td"));
	 
	    //DatePicker is a table. Thus we can navigate to each cell
	    //and if a cell matches with the current date then we will click it.
	    for (WebElement cell: columns) {
	       /*
	      //If you want to click 18th Date
	       */
	      //if (cell.getText().equals("18")) {
	           
	     //Select Today's Date
	            if (cell.getText().equals(today))
	            {
	                cell.click();
	                break;
	            }
	        }
	 
	        //Wait for 4 Seconds to see Today's date selected.
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        
	
		//Thread.sleep(2000);
	        
	        //
	        //---------------------------Handling date time/calendar field--------------------------------------------------------------------------------------
	        //
	        waitForVisibility(clickclndrtime);
	        clickclndrtime.click();
	        
	        //
			//
			//
			waitForVisibility(pickdate);
			//WebElement dateWidgetFrom = pickdate;
			
			//Get today's date and put it in today so that we can use it in the clicking on date of the calendar 
			today = getCurrentDay();
			 
		    //These are the rows of the from date picker table
		    //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
		 
		    //These are the columns of the from date picker table
		    List<WebElement> columns1 = pickdate.findElements(By.tagName("td"));
		 
		    //DatePicker is a table. Thus we can navigate to each cell
		    //and if a cell matches with the current date then we will click it.
		    for (WebElement cell: columns1) {
		       /*
		      //If you want to click 18th Date
		       */
		      //if (cell.getText().equals("18")) {
		           
		     //Select Today's Date
		            if (cell.getText().equals(today))
		            {
		                cell.click();
		                break;
		            }
		        }
		 
		        //Wait for 4 Seconds to see Today's date selected.
		        try {
		            Thread.sleep(1000);
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }
		        Thread.sleep(2000);
		        //jse.executeScript("scroll(0, 1200);");
		        		
		//
		//Click on OK button of Calendar of Date time field of Seller Registration Activation form.        
		//
        waitForVisibility(clickOKtime);
		clickOKtime.click();
		//
		//Enter time in Seller Registration Activation form.
		//
		waitForVisibility(clicktime);
		clicktime.sendKeys(time);
		
		//
		//Navigate to the Save changes button at the bottom of the page
		//
		Thread.sleep(1000);
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		
		//
		//Click on Save changes in Seller Registration Activation form.
		//
		Thread.sleep(1000);
		waitForVisibility(savechngs);
		savechngs.click();
	}
	
	//
	//------------------------------------------------Check Seller Registration-------------------------------------------------------------
	//
	@FindBy(how=How.CSS,using="#regFrmBlock > div.message.message--success.align--center.cms > div.section-head.section--head--center > div > h2")
	WebElement successmsg;
	
	public String matchSuccessMessage()
	{
		waitForVisibility(successmsg);
		return successmsg.getText();
	}		
	
	//
	//---------------------------------------------Accept Cookies on the page----------------------------------------------------------------
	//WebElement of accept cookies button on the page.
	//
	@FindBy(how=How.CSS,using="body > div.wrapper > div.cc-window.cc-banner.cc-type-info.cc-theme-block.cc-bottom.cookie-alert.no-print > div > span.cc-close.cc-cookie-accept-js")
	WebElement cookies;
	
	//
	//Function to accept cookies on the page.
	//
	public void acceptCookies()
	{
		waitForVisibility(cookies);
		cookies.click();
	}
}