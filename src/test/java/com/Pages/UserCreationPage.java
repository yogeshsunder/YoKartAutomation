package com.Pages;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;



public class UserCreationPage {
	
	WebDriver driver;
	
	public UserCreationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

	//
	//WebElement of accept cookies on Homepage
	//
	@FindBy(how=How.CLASS_NAME,using="cc-cookie-accept-js")
	WebElement acceptCookies;
	
	//
	//Function to click on accept cookies on Homepage
	//
	public void clickAcceptCookies()
	{
		waitForVisibility(acceptCookies);
		acceptCookies.click();
	}
	
	//
	//WebElement of Login icon on Homepage
	//
	@FindBy(how=How.CLASS_NAME,using="icn--login")
	WebElement loginIcon;
	
	//
	//Function to click on Login icon on Homapge
	//
	public void clickOnLoginIcon() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(loginIcon);
		loginIcon.click();
	}
	
	//
	//WebElement of Not Registered Yet link in login pop up
	//
	@FindBy(how=How.XPATH,using="//a[@href='/guest-user/login-form/1']")
	WebElement notRegisteredYet;
	
	//
	//Function to click on Not Registered Yet link in login pop up
	//
	public void clickOnNotRegisteredYet() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(notRegisteredYet);
		notRegisteredYet.click();
	}
	
	//
	//WebElement of Register button on Create Your Account For Sign Up form
	//
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @name='btn_submit' and @value='Register']")
	WebElement submitButton;
	
	//
	//Function to click on Register button on Create Your Account For Sign Up form
	//
	public void clickOnRegisterButton() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(submitButton);
		submitButton.click();
	}
	
	//
	//WebElement of validation error message of Name field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_name")
	WebElement validationName;
	
	//
	//Function to get validation error message of name field of Create Your Account For Sign Up form
	//
	public String getValidationName() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationName);
		return validationName.getText();
	}
	
	//
	//WebElement of Name field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="user_name")
	WebElement name;
	
	//
	//Function to enter Name in Create Your Account For Sign Up form
	//
	public void enterName(String enter_name) throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(name);
		name.clear();
		name.sendKeys(enter_name);
	}
	
	//
	//WebElement of validation error message of User Name field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_username")
	WebElement validationUserName;
	
	//
	//Function to get validation error message of user name field of Create Your Account For Sign Up form
	//
	public String getValidationUserName() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationUserName);
		return validationUserName.getText();
	}
	
	//
	//WebElement of User Name field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="user_username")
	WebElement userName;
	
	//
	//Function to enter Name in Create Your Account For Sign Up form
	//
	public void enterUserName(String enter_username) throws InterruptedException
	{
		Thread.sleep(1000);
		//waitForVisibility(userName);
		userName.clear();
		userName.sendKeys(enter_username);
	}
	
	//
	//WebElement of top validation of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="content")
	WebElement topValidation;
	
	//
	//Function to get top validation of Create Your Account For Sign Up form
	//
	public String getTopValidation()
	{
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3000, TimeUnit.MILLISECONDS)
		        .pollingEvery(250, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class);
		 
		 WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		 {
			 public WebElement apply(WebDriver driver) 
			 {
				 if(topValidation.isDisplayed())
				 	{
						 return topValidation;
				 	}
				 	else
				 	{
				 		return null;
				 	}
			 }
		 });
		 
		 return element.getText();
	}
	
	//
	//WebElement of validation error message of Email field in Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_email")
	WebElement validationUserEmail;
	
	//
	//Function to get validation error message of Email field in Create Your Account For Sign Up form
	//
	public String getValidationUserEmail() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationUserEmail);
		return validationUserEmail.getText();
	}
	
	//
	//WebElement of user email in Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="user_email")
	WebElement userEmail;
	
	//
	//Function to enter user email in Create Your Account For Sign Up form
	//
	public void enterUserEmail(String user_email) throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(userEmail);
		userEmail.clear();
		Thread.sleep(300);
		userEmail.sendKeys(user_email);
	}
	
	//
	//WebElement of validation error message of Password field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_password")
	WebElement validationPassword;
	
	//
	//Function to get validation error message of Password field of Create Your Account For Sign Up form
	//
	public String getValidationPassword() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationPassword);
		return validationPassword.getText();
	}
	
	//
	//WebElement of password field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="user_password")
	WebElement password;
	
	//
	//Function to enter password field of Create Your Account For Sign Up form
	//
	public void enterPassword(String enter_password) throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(password);
		password.clear();
		password.sendKeys(enter_password);
	}
	
	//
	//WebElement of validation error message of confirm password field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_password1")
	WebElement validationConfirmPassword;
	
	//
	//Function to get validation error message of confirm password field of Create Your Account For Sign Up form
	//
	public String getValidationConfirmPassword() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationConfirmPassword);
		return validationConfirmPassword.getText();
	}
	
	//
	//WebElement of confirm password of confirm password field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="password1")
	WebElement confirmPassword;
	
	//
	//Function to enter confirm password of confirm password field of Create Your Account For Sign Up form
	//
	public void enterConfirmPassword(String enter_confirm_password) throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(confirmPassword);
		confirmPassword.clear();
		confirmPassword.sendKeys(enter_confirm_password);
	}
	
	//
	//WebElement of validation error message of Terms & Conditions field of Create Your Account For Sign Up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_agree")
	WebElement validationTerms;
	
	//
	//Function to get validation error message of Terms & Conditions field of Create Your Account For Sign Up form
	//
	public String getValidationTerms() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationTerms);
		return validationTerms.getText();
	}
	
	//
	//WebElement of Terms & Conditions checkbox of Create Your Account For Sign Up form
	//
	@FindBy(how=How.NAME,using="agree")
	WebElement checkAgree;
	
	//
	//Function to click on Terms & Conditions checkbox of Create Your Account For Sign Up form
	//
	public void clickOnAgree() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(checkAgree);
		checkAgree.click();
	}
	
	//
	//WebElement of Content Header i.e. Dashboard of logged in user
	//
	@FindBy(how=How.CLASS_NAME,using="section__heading")
	WebElement header;
	
	//
	//Function to get Content Header i.e. Dashboard of logged in user 
	//
	public String getContentofHeaderLoggedIn() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(header);
		return header.getText();
	}
}
