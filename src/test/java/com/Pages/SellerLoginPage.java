package com.Pages;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;


public class SellerLoginPage {
	
	WebDriver driver;
	String username,password;
    JSONParser parser=new JSONParser();
	
	public SellerLoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of login option of the top of Homepage
	//
	@FindBy(how=How.CSS,using=".sign-in > span:nth-child(2) > strong:nth-child(1)")
	WebElement clicklogin;
	
	//
	//Function of click on login option of the top of Homepage
	//
	public void clickOnLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		waitForVisibility(clicklogin);
		clicklogin.click();
	}
	
	//
	//WebElement of Username field on login form
	//
	@FindBy(how=How.NAME,using="username")
	WebElement usrname;
	
	//
	//Function of enter username on login form
	//
	public void enterUserName(String user_name)
	{
		waitForVisibility(usrname);
		usrname.clear();
		usrname.sendKeys(user_name);
	}
	
	//
	//WebELement of password field of login form
	//
	@FindBy(how=How.NAME,using="password")
	WebElement pwd;
	
	//
	//Function to enter password on login form
	//
	public void enterPassword(String pass_word)
	{
		waitForVisibility(pwd);
		pwd.clear();
		pwd.sendKeys(pass_word);
	}
	
	//
	//WebElement of submit button on login form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement sbmnit;
	
	//
	//Funciton of clicking submit button on login form
	//
	public void clickOnSubmitButton() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		waitForVisibility(sbmnit);
		sbmnit.click();
	}
	
	//
	//WebElement of Validation error message of Username field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_username")
	WebElement validationUsername;
	
	//
	//Function of getting validation error message of username field
	//
	public String valiationOfUsernameField()
	{
		waitForVisibility(validationUsername);
		return validationUsername.getText();
	}
	
	//
	//WebElement of Validation error message of Password field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_password")
	WebElement validationPassword;
	
	//
	//Function of getting validation error message of username field
	//
	public String valiationOfPasswordField()
	{
		waitForVisibility(validationPassword);
		return validationPassword.getText();
	}
	
	//
	//WebElement of Currency option on logged in seller page
	//
	@FindBy(how=How.CLASS_NAME,using="icn-txt")
	WebElement currency;
	
	//
	//Function of getting text of currency option on logged in seller page
	//
	public String getTextofCurrencyOption() throws InterruptedException
	{
		new WebDriverWait(driver, 120).until(ExpectedConditions.invisibilityOfElementLocated(By.className("yokart-loader")));
		Thread.sleep(5000);
		waitForVisibility(currency);
		return currency.getText();
	}
	
	//
	//Function of complete login for Seller
	//
	public void sellerLogin() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/sellerLoginInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		username = (String) jsonObject.get("UserName");
		password = (String) jsonObject.get("Password");		
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
	//Webelement of validation error coming on login page
	//
	@FindBy(how=How.ID,using="mbsmessage")
	WebElement invaliderror;
	
	//
	//Function to get  validation error coming on login page
	//
	public String getInvalidError()
	{
		 @SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
			        .withTimeout(5000, TimeUnit.MILLISECONDS)
			        .pollingEvery(250, TimeUnit.MILLISECONDS)
			        .ignoring(NoSuchElementException.class);
			 
			 WebElement element = wait.until(new Function<WebDriver, WebElement>() 
			 {
			 public WebElement apply(WebDriver driver) 
			 {
				 String getTextOnPage = invaliderror.getText();
				 
				 if(getTextOnPage.contains("Invalid Username Or Password"))
				 	{
					 	return invaliderror;
				 	}
				 else
				 	{
					 	return null;
				 	}
			 }
			 }
			 );
			
			return element.getText();
	}
}
