package com.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddDiscountCouponPage {

	
	WebDriver driver;
	String brandidentifier;
	
	public AdminAddDiscountCouponPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	public void waitForClickability(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }
	
	//
	//WebElement of Left Menu option of Dashboard drop down
	//
	@FindBy(how=How.CLASS_NAME,using="leftmenu")
	WebElement leftMenu;
	
	//
	//Function to click on Catalog option of Dashboard drop down
	//
	public void clickonCms() throws InterruptedException
	{
		waitForVisibility(leftMenu);
		
		List<WebElement> listMenu = leftMenu.findElements(By.cssSelector("#body > aside > div > ul > li"));
		
		for(int i = 0; i < listMenu.size(); i++)
		{			
			if(listMenu.get(i).getText().equals("Cms"))
			{
				listMenu.get(i).click();
			}
		}
	}
	
	//
	//WebElement of CMS drop down options list of Dashboard
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(4) > ul")
	WebElement cmsDropdown;
	
	//
	//Function to click on Discount Coupon in CMS drop down option list of Dashboard
	//
	public void clickOnDiscountCoupon() throws InterruptedException
	{
		List<WebElement> listCms = driver.findElements(By.cssSelector("#body > aside > div > ul > li:nth-child(4) > ul > li"));
		
		for(int i = 0; i < listCms.size(); i++)
		{
			if(listCms.get(i).getText().contains("Discount Coupons"))
			{
				listCms.get(i).click();
				
				break;
			}
		}
	}
	
	//
	//WebElement of Add icon on Manage Coupons Page
	//
	@FindBy(how=How.CLASS_NAME,using="icon")
	WebElement addIcon;
	
	//
	//Function to click on Add icon on Manage Coupons Page
	//
	public void clickonAddIcon()
	{
		waitForVisibility(addIcon);
		addIcon.click();
	}
	
	//
	//WebElement of Add New Coupon link on Manage Coupons Page
	//
	@FindBy(how=How.XPATH,using="//a[@title='Add New Coupon']")
	WebElement addNewCoupon;
	
	//
	//Function to click on Add New Coupon link on Manage Coupons Page
	//
	public void clickAddNewCoupon()
	{
		waitForVisibility(addNewCoupon);
		addNewCoupon.click();
	}
	
	//
	//WebElement of Save Changes button on Coupon set up form
	//
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @value='Save Changes']")
	WebElement saveChangesButton;
	
	//
	//Function to click on Save Changes button on Coupon set up form
	//
	public void click_Save_Changes() throws InterruptedException
	{
		waitForClickability(saveChangesButton);
		Thread.sleep(250);
		saveChangesButton.click();
	}
	
	//
	//Function to click on Save Changes button on Coupon set up English form
	//
	public void click_Save_Changes_English() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForClickability(saveChangesButton);
		saveChangesButton.click();
	}
	
	//
	//WebElement of validation of Coupon Identifier filed in Coupon set up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_identifier")
	WebElement validation_Coupon_Identifier;
	
	//
	//Function to get validation of Coupon Identifier filed in Coupon set up form
	//
	public String get_validation_Coupon_Identifier()
	{
		waitForVisibility(validation_Coupon_Identifier);
		return validation_Coupon_Identifier.getText();
	}
	
	//
	//WebElement of the field Coupon Identifier in Coupon setup form
	//
	@FindBy(how=How.NAME,using="coupon_identifier")
	WebElement coupon_Identifier;
	
	//
	//Function to enter Coupon Identifier in Coupon setup form
	//
	public void enter_Coupon_Identifier(String couponIdentifier)
	{
		coupon_Identifier.clear();
		coupon_Identifier.sendKeys(couponIdentifier);
	}
	
	//
	//WebElement of validation of Coupon Code filed in Coupon set up form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_code")
	WebElement validationCouponCode;
	
	//
	//Function to get validation of Coupon Code filed in Coupon set up form
	//
	public String getValidationCouponCode()
	{
		waitForVisibility(validationCouponCode);
		return validationCouponCode.getText();
	}
	
	//
	//WebElement of Coupon Code field
	//
	@FindBy(how=How.NAME,using="coupon_code")
	WebElement couponCode;
	
	//
	//Function to enter Coupon Code field
	//
	public void enterCoupnCode(String couponcode)
	{
		waitForVisibility(couponCode);
		couponCode.clear();
		couponCode.sendKeys(couponcode);
	}
	
	public static String generateRandomChars(String candidateChars, int length) 
	{
	    StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < length; i++) 
	    {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars.length())));
	    }

	    return sb.toString();
	}
	
	//
	//WebElement of Select Discount Type filed in Discount Coupon Setup form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_type")
	WebElement validation_Select_Discount_Type;
	
	//
	//Function to get Select Discount Type filed in Discount Coupon Setup form
	//
	public String get_validation_Select_Discount_Type()
	{
		waitForVisibility(validation_Select_Discount_Type);
		return validation_Select_Discount_Type.getText();
	}
	
	//
	//WebElement of Select Discount Type field in Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_type")
	WebElement 	coupon_Type;
	
	//
	//Function to enter Discount Type in Discount Type field in Discount Coupon Setup form
	//
	public void enter_coupon_Type(String discounttype)
	{
		List<WebElement> discountTypeDropdown = coupon_Type.findElements(By.cssSelector("#frm_fat_id_frmCoupon > div:nth-child(3) > div > div > div.field-wraper > div > select > option"));
		
		for(int i = 0; i < discountTypeDropdown.size(); i++)
		{
			if(discountTypeDropdown.get(i).getText().contains(discounttype))
			{
				discountTypeDropdown.get(i).click();
			}
		}
	}
	
	//
	//WebElement of validation error message of Discount Value in Discount Coupon Setup form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_discount_value")
	WebElement coupon_discount_value;
	
	//
	//Function to get validation error message of Discount Value in Discount Coupon Setup form
	//
	public String get_validation_coupon_discount_value()
	{
		waitForVisibility(coupon_discount_value);
		return coupon_discount_value.getText();
	}
	
	//
	//WebElement of Discount Value field in Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_discount_value")
	WebElement discount_Value;
	
	//
	//Function to enter Discount Value in Discount Coupon Setup form
	//
	public void enter_Discount_Value(String discountvalue)
	{
		waitForVisibility(discount_Value);
		discount_Value.clear();
		discount_Value.sendKeys(discountvalue);
	}
	
	//
	//WebElement of validation error message of Min Order Value in Discount Coupon Setup form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_min_order_value")
	WebElement validation_Min_Order_Value;
	
	//
	//Function to get validation error message of Min Order Value in Discount Coupon Setup form
	//
	public String get_validation_Min_Order_Value()
	{
		waitForVisibility(validation_Min_Order_Value);
		return validation_Min_Order_Value.getText();
	}
	
	//
	//WebElement of Min Order Value field in Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_min_order_value")
	WebElement min_order_value;
	
	//
	//Function to enter Min Order Value in Discount Coupon Setup form
	//
	public void enter_min_order_value(String minOrderValue)
	{
		waitForVisibility(min_order_value);
		min_order_value.clear();
		min_order_value.sendKeys(minOrderValue);
	}
	
	//
	//WebElement of validation error message of Max Discount Value in Discount Coupon Setup form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_max_discount_value")
	WebElement validation_Max_Discount_Value;
	
	//
	//Function to get validation error message of Max Discount Value in Discount Coupon Setup form
	//
	public String get_validation_Max_Discount_Value()
	{
		waitForVisibility(validation_Max_Discount_Value);
		return validation_Max_Discount_Value.getText();
	}
	
	//
	//WebElement of Max Discount Value field in Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_max_discount_value")
	WebElement max_discount_value;
	
	//
	//Function to enter Max Discount Value field in Discount Coupon Setup form
	//
	public void enter_max_discount_value(String maxDiscountValue)
	{
		waitForVisibility(max_discount_value);
		max_discount_value.clear();
		max_discount_value.sendKeys(maxDiscountValue);
	}
	
	//
	//WebElement of validation error message of Coupon Title in Discount Coupon Setup English form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_coupon_title")
	WebElement couponTitle;
	
	//
	//Function to get validation error message of Coupon Title in Discount Coupon Setup English form
	//
	public String get_validation_coupon_title()
	{
		waitForVisibility(couponTitle);
		return couponTitle.getText();
	}
	
	//
	//WebELement of Coupon Title English in Discount Coupon Setup English form
	//
	@FindBy(how=How.NAME,using="coupon_title")
	WebElement couponTitleEnglish;
	
	//
	//Function to enter Coupon Title English in Discount Coupon Setup English form
	//
	public void enter_coupon_title_english(String coupon_english)
	{
		waitForVisibility(couponTitleEnglish);
		couponTitleEnglish.sendKeys(coupon_english);
	}
	
	//
	//WebElement of Upload File button in Discount Coupon Media Setup form
	//
	@FindBy(how=How.NAME,using="coupon_image")
	WebElement uploadImagCoupon;
	
	//
	//Function to click Upload File button in Discount Coupon Media Setup form
	//
	public void click_upload_coupon_image()
	{
		waitForVisibility(uploadImagCoupon);
		uploadImagCoupon.click();
	}
	
	//
	//WebElement of Close Image icon on Discount Coupon Media Setup form
	//
	@FindBy(how=How.CLASS_NAME,using="close_image")
	WebElement closeImage;
	
	//
	//Function to click on Close Image icon on Discount Coupon Media Setup form
	//
	public void cilck_close_image()
	{
		waitForVisibility(closeImage);
		closeImage.click();
	}
	
	//
	//WebElement of Uses Per Coupon field of Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_uses_count")
	WebElement uses_per_count;
	
	//
	//Function to enter Uses Per Coupon field of Discount Coupon Setup form
	//
	public void enter_uses_per_count(String usespercount)
	{
		waitForVisibility(uses_per_count);
		uses_per_count.clear();
		uses_per_count.sendKeys(usespercount);
	}
	
	//
	//WebElement of Uses Per Customer field of Discount Coupon Setup form
	//
	@FindBy(how=How.NAME,using="coupon_uses_coustomer")
	WebElement uses_per_customer;
	
	//
	//Function to enter Uses Per Customer field of Discount Coupon Setup form
	//
	public void enter_uses_per_customer(String usespercustomer)
	{
		waitForVisibility(uses_per_customer);
		uses_per_customer.clear();
		uses_per_customer.sendKeys(usespercustomer);
	}

}
