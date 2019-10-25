package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminSettingsforSubscriptionPage {
	
WebDriver driver;
	
	public AdminSettingsforSubscriptionPage(WebDriver driver)
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
	//Function to click on Subscription in left nav of General Settings page
	//
	public void clickOnSubscription()
	{
		List<WebElement> list = listLinks.findElements(By.cssSelector("#body > div > div > div > div > div.tabs_nav_container.vertical > ul > li"));
		
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getText().equals("Subscription")) 
			{
				list.get(i).click();
			}
		}
	}
	
	//
	//WebElement of Accounts link on General Settings page
	//
	//@FindBy(how=How.CLASS_NAME,using="radio")
	@FindBy(how=How.CSS,using="#frm_fat_id_frmConfiguration > div:nth-child(1) > div > div > div.field-wraper > div > ul > li:nth-child(2) > label > span > input[type=radio]")
	WebElement subscriptionModule;
	
	//
	//Function to disable Subscription Module
	//
	public void disableSubscriptionModule() throws InterruptedException
	{
		Thread.sleep(5000);
		subscriptionModule.click();
	}
	
	//
	//WebElement of Save Changes button on the General Settings Subscription page
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button on the General Settings Subscription page
	//
	public void clickSaveChanges()
	{
		saveChanges.click();
	}
	
	//
	//WebElement of successful message in subscription page
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--success")
	WebElement messageSuccessful;
	
	//
	//Function to get successful message
	//
	public String getMessage()
	{
		waitForVisibility(messageSuccessful);
		return messageSuccessful.getText();
	}

}
