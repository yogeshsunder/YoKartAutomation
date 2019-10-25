package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddShippingCompanyUserPage {
	
WebDriver driver;
	
	public AdminAddShippingCompanyUserPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of shipping Company Users under Shipping API in Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(5) > ul > li:nth-child(4) > a")
	WebElement shippingCompanyUsers;
	
	//
	//Function to click on shipping Company Users under Shipping API in Dashboard drop down
	//
	public void clickOnShippingCompanyUsers()
	{
		waitForVisibility(shippingCompanyUsers);
		shippingCompanyUsers.click();
	}
	
	//
	//WebElement of Add User icon on Manage Shipping Company Users page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > a > i")
	WebElement addUserIcon;
	
	//
	//Function to click on Add User Icon on Manage Shipping Company Users Page
	//
	public void clickOnAddUserIcon()
	{
		waitForVisibility(addUserIcon);
		addUserIcon.click();
	}
	
	//
	//WebElement of Add User on Manage Shipping Company Users Page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section > div.sectionhead > ul > li > div > ul > li > a")
	WebElement addUser;
	
	//
	//Function to click on Add User on Manage Shipping Company Users Page
	//
	public void clickOnAddUser()
	{
		waitForVisibility(addUser);
		addUser.click();
	}
	
	//
	//WebElement of Save Changes
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @value='Save Changes']")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes on Shipping Company User set up form
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Mandatory validation error message of Username field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_credential_username")
	WebElement mandatoryUserName;
	
	//
	//Function to get Mandatory Validation error message for User Name field
	//
	public String getMandatoryUserName()
	{
		waitForVisibility(mandatoryUserName);
		return mandatoryUserName.getText();
	}
	
	//
	//WebElement of User Name field
	//
	@FindBy(how=How.NAME,using="credential_username")
	WebElement userName;
	
	//
	//Function to enter User Name in Shipping Company User form
	//
	public void enterUserName(String username)
	{
		waitForVisibility(userName);
		userName.clear();
		userName.sendKeys(username);
	}
	
	//
	//WebElement of Mandatory validation error message of Customer Name field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_user_name")
	WebElement mandatoryCustomerName;
	
	//
	//Function to get Mandatory Validation error message for Customer Name field
	//
	public String getMandatoryCustomerName()
	{
		waitForVisibility(mandatoryCustomerName);
		return mandatoryCustomerName.getText();
	}
	
	//
	//WebElement of Customer Name field
	//
	@FindBy(how=How.NAME,using="user_name")
	WebElement customerName;
	
	//
	//Function to enter Customer Name in Shipping Company User form
	//
	public void enterCustomerName(String custname)
	{
		waitForVisibility(customerName);
		customerName.clear();
		customerName.sendKeys(custname);
	}
	
	//
	//WebElement of Mandatory validation error message of Email field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_credential_email")
	WebElement mandatoryEmail;
	
	//
	//Function to get Mandatory Validation error message for Email field
	//
	public String getMandatoryEmail()
	{
		waitForVisibility(mandatoryEmail);
		return mandatoryEmail.getText();
	}
	
	//
	//WebElement of Invalid validation error message of Email field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_credential_email")
	WebElement invalidEmail;
	
	//
	//Function to get Mandatory Validation error message for Email field
	//
	public String getinvalidEmail()
	{
		waitForVisibility(invalidEmail);
		return invalidEmail.getText();
	}
	
	//
	//WebElement of Email field
	//
	@FindBy(how=How.NAME,using="credential_email")
	WebElement email;
	
	//
	//Function to enter Customer Name in Shipping Company User form
	//
	public void enterEmail(String Email) throws InterruptedException
	{
		waitForVisibility(email);
		email.clear();
		email.sendKeys(Email);
	}
	
	//
	//WebElement of Close icon of Shipping Company User set up form
	//
	@FindBy(how=How.CLASS_NAME,using="close_image")
	WebElement closeIcon;
	
	//
	//Function of Close icon of Shipping Company User set up form
	//
	public void clickOnCloseIcon()
	{
		waitForVisibility(closeIcon);
		closeIcon.click();
	}
	
	//
	//WebElement of username of created Company User
	//
	@FindBy(how=How.CSS,using="#frmShpCompUsrListing > table > tbody > tr:nth-child(1) > td:nth-child(3)")
	WebElement usernameCreated;
	
	//
	//Function to get username of created Company User
	//
	public String getUsernameCreated() throws InterruptedException
	{
		waitForVisibility(usernameCreated);
		Thread.sleep(3000);
		return usernameCreated.getText();
	}
}
