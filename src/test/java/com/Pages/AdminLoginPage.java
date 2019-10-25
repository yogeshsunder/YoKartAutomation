package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminLoginPage {
	
	WebDriver driver;
	String userName,passWord;
    JSONParser parser=new JSONParser();
	
	public AdminLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Username
	//
	@FindBy(how=How.NAME,using="username")
	WebElement username;
	
	//
	//Function to enter Username
	//
	public void enterUserName(String userName)
	{
		waitForVisibility(username);
		username.clear();
		username.sendKeys(userName);
	}
	
	//
	//WebElement of Password
	//
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	//
	//Function to enter Password
	//
	public void enterPassword(String passWord)
	{
		waitForVisibility(password);
		password.clear();
		password.sendKeys(passWord);
	}
	
	//
	//WebElement of Submit Button
	//
	@FindBy(how=How.XPATH,using="//input[@name='btn_submit' and @type='submit']")
	WebElement submit;
	
	//
	//Function to click on Submit
	//
	public void clickonSubmitButton()
	{
		waitForVisibility(submit);
		submit.click();
	}

	
	public void loginAdmin() throws FileNotFoundException, IOException, ParseException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		userName = (String) jsonObject.get("USERNAME");
		passWord = (String) jsonObject.get("PASSWORD");
		
		waitForVisibility(username);
		username.clear();
		username.sendKeys(userName);
		password.clear();
		password.sendKeys(passWord);
		submit.click();
	}
	
	//
	//WebElement of Error message for Username
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_username")
	WebElement errorUsername;
	
	//
	//Function of getting Error message for Username
	//
	public String errorMessageofUsername()
	{
		waitForVisibility(errorUsername);
		return errorUsername.getText();
	}
	
	//
	//WebElement of Error message for Password
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_password")
	WebElement errorPassword;
	
	//
	//Function of getting Error message for Password
	//
	public String errorMessageofPassword()
	{
		waitForVisibility(errorPassword);
		return errorPassword.getText();
	}
	
	//
	//WebElement of successful message
	//
	@FindBy(how=How.CLASS_NAME,using="div_msg")
	WebElement sucessMsg;
	
	//
	//Function to get success message of Admin Login
	//
	public String successMessageofAdminLogin() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(sucessMsg);
		return sucessMsg.getText();
	}
	
	//
	//WebElement of invalid username or password validation error message
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement invalidmessage;
	
	//
	//Function of getting invalid username or password validation error message
	//
	public String getInvalidMessage()
	{
		waitForVisibility(invalidmessage);
		return invalidmessage.getText();
	}

}
