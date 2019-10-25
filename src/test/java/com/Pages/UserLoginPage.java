package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserLoginPage {
	
WebDriver driver;
	
	public UserLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Login button on login form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement login;
	
	//
	//Function to click on Login button on login form
	//
	public void clickOnLogin()
	{
		waitForVisibility(login);
		login.click();
	}
	
	//
	//WebElement of Icon text of logged in dashboard for user
	//
	@FindBy(how=How.CSS,using="#header > div.top-bar > div > div > div.col-lg-6.col-xs-12 > div > ul > li.dropdown.dropdown--arrow.dropdown--user > a > span")
	WebElement loginIcon;
	
	//
	//Function to get of Icon text of logged in dashboard for user
	//
	public String getLoginTextLoggedin()
	{
		waitForVisibility(loginIcon);
		return loginIcon.getText();
	}

}
