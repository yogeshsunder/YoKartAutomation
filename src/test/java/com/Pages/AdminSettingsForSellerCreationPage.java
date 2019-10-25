package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSettingsForSellerCreationPage {
	
WebDriver driver;
	
	public AdminSettingsForSellerCreationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Accounts link on General Settings page
	//
	@FindBy(how=How.CLASS_NAME,using="outerul")
	WebElement listLinks;
	
	//
	//Function to click on Accounts in left nav of General Settings page
	//
	public void clickOnAccounts()
	{
		List<WebElement> list = listLinks.findElements(By.cssSelector("#body > div > div > div > div > div.tabs_nav_container.vertical > ul > li"));
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getText().equals("Account")) 
			{
				list.get(i).click();
			}
		}
	}
	
	//
	//WebElement of Activate Admin Approval After Registration (sign Up) field
	//
	@FindBy(how=How.NAME,using="CONF_ADMIN_APPROVAL_REGISTRATION")
	WebElement adminApprovalAfterRegistration;
	
	//
	//Function to Check Activate Admin Approval After Registration (sign Up) un-Checked if not un-check it
	//
	
	public void uncheckActivateAdminApprovalAfterRegistration() throws InterruptedException
	{
		Thread.sleep(2000);
		if(adminApprovalAfterRegistration.isSelected())
			adminApprovalAfterRegistration.click();
	}
	
	//
	//WebElement of Save Changes button on the form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Activate Email Verification After Registration
	//
	@FindBy(how=How.NAME,using="CONF_EMAIL_VERIFICATION_REGISTRATION")
	WebElement activateEmailVerificationAfterRegistration;
	
	//
	//Function to make Activate Email Verification After Registration un-Checked if not un-check it
	//
	public void uncheckActivateEmailVerificationAfterRegistration() throws InterruptedException
	{
		Thread.sleep(2000);
		if(activateEmailVerificationAfterRegistration.isSelected())
			activateEmailVerificationAfterRegistration.click();
	}
	
	//
	//WebElement of Activate Separate Seller Sign Up Form
	//
	@FindBy(how=How.NAME,using="CONF_ACTIVATE_SEPARATE_SIGNUP_FORM")
	WebElement activateSeparateSellerSignUpForm;
	
	//
	//Function to make Activate Separate Seller Sign Up Form Checked if not Check it
	//
	public void checkActivateSeparateSellerSignUpForm() throws InterruptedException
	{
		Thread.sleep(2000);
		if(!activateSeparateSellerSignUpForm.isSelected())
			activateSeparateSellerSignUpForm.click();
	}
	
	//
	//WebElement of Activate Administrator Approval On Seller Request
	//
	@FindBy(how=How.NAME,using="CONF_ADMIN_APPROVAL_SUPPLIER_REGISTRATION")
	WebElement activateAdministratorApprovalOnSellerRequest;
	
	//
	//Function to make Activate Administrator Approval On Seller Request un-checked if not un-check it
	//
	public void uncheckActivateAdministratorApprovalOnSellerRequest() throws InterruptedException
	{
		Thread.sleep(2000);
		if(activateAdministratorApprovalOnSellerRequest.isSelected())
			activateAdministratorApprovalOnSellerRequest.click();
	}

}
