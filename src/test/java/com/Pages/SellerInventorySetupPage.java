package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerInventorySetupPage {
	
WebDriver driver;
	
	public SellerInventorySetupPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of add to store icon on Marketplace Products page 
	//
	@FindBy(how=How.XPATH,using="//a[@class='icn-highlighted' and @title='Add Inventory']")
	WebElement addToStore;
	
	//
	//Function to click on add to store icon on Marketplace Products page 
	//
	public void clickOnAddToStore()
	{
		waitForVisibility(addToStore);
		addToStore.click();
	}
	
	//
	//WebElement of Save Changes button on Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement submitButton;
	
	//
	//Function to click on Save Changes button on Inventory Setup General Basic form
	//
	public void clickOnSubmitButton()
	{
		waitForVisibility(submitButton);
		submitButton.click();
	}
	
	//
	//WebElement of mandatory validation error message for Price field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_price")
	WebElement mandatoryPrice;
	
	//
	//Function to get mandatory validation error message for Price field
	//
	public String getMandatoryValidationPrice()
	{
		waitForVisibility(mandatoryPrice);
		return mandatoryPrice.getText();
	}
	
	//
	//WebElement of price field in Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_price")
	WebElement priceField;
	
	//
	//Function to enter price in Inventory Setup General Basic form
	//
	public void enterPrice(String enter_price)
	{
		waitForVisibility(priceField);
		priceField.clear();
		priceField.sendKeys(enter_price);
	}
	
	//
	//WebElement of Quantity field in Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_stock")
	WebElement quantity;
	
	//
	//Function to enter quantity in Inventory Setup General Basic form
	//
	public void enterQuantity(String enter_quantity)
	{
		waitForVisibility(quantity);
		quantity.clear();
		quantity.sendKeys(enter_quantity);
	}
	
	//
	//WebElement for mandatory validation error message for Quantity field in Inventory Setup General Basic form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_stock")
	WebElement validationQuantity;
	
	//
	//Function to get mandatory validation error message for Quantity field in Inventory Setup General Basic form
	//
	public String getValidationQuantity()
	{
		waitForVisibility(validationQuantity);
		return validationQuantity.getText();
	}
	
	//
	//WebElement for validation error message of Minimum Quantity field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_min_order_qty")
	WebElement validationMinimumQuantity;
	
	//
	//Function to get validation error message of Minimum Quantity field
	//
	public String getValidationMinimumQuantity()
	{
		waitForVisibility(validationMinimumQuantity);
		return validationMinimumQuantity.getText();
	}
	
	//
	//WebElement of Minimum Quantity field in Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_min_order_qty")
	WebElement minimumQuantity;
	
	//
	//Function to enter Minimum Quantity in Inventory Setup General Basic form
	//
	public void enterMinimumQuantity(String enter_min_quantity)
	{
		waitForVisibility(minimumQuantity);
		minimumQuantity.clear();
		minimumQuantity.sendKeys(enter_min_quantity);
	}
	
	//
	//WebElement of validation error message of Product SKU in Inventory Setup General Basic form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_sku")
	WebElement validationProductSKU;
	
	//
	//Function to get validation error message of Product SKU in Inventory Setup General Basic form
	//
	public String getValidationProductSKU()
	{
		waitForVisibility(validationProductSKU);
		return validationProductSKU.getText();
	}
	
	//
	//WebELement for Product SKU field in Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_sku")
	WebElement productSKU;
	
	//
	//Function to enter Product SKU field in Inventory Setup General Basic form
	//
	public void enterProductSKU(String product_sku)
	{
		waitForVisibility(productSKU);
		productSKU.sendKeys(product_sku);
	}
	
	//
	//WebElement for validation error message of roduct Condition in Inventory Setup General Basic form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_condition")
	WebElement validationProductCondition;
	
	//
	//Function to get validation error message of product Condition in Inventory Setup General Basic form
	//
	public String getValidationProductCondition()
	{
		waitForVisibility(validationProductCondition);
		return validationProductCondition.getText();
	}
	
	//
	//WebElement of product condition field in Inventory Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_condition")
	WebElement productCondition;
	
	//
	//Function to select product condition field in Inventory Setup General Basic form
	//
	public void selectProductCondition(String production_condition)
	{
		waitForVisibility(productCondition);
		Select productcondition = new Select(productCondition);
		productcondition.selectByValue(production_condition);
	}
	
	//
	//WebElement of Product Display Title field of Inventory Setup English form
	//
	@FindBy(how=How.NAME,using="selprod_title")
	WebElement productDisplayTitle;
	
	//
	//Function to get entered Product Display Title from Product Display Title field of Inventory Setup English form
	//
	public String getProductDisplayTitle()
	{
		waitForVisibility(productDisplayTitle);
		return productDisplayTitle.getAttribute("value");
	}
	
	//
	//Function to enter Product Display Title field of Inventory Setup English form
	//
	public void enterProductDisplayTitle(String display_title)
	{
		waitForVisibility(productDisplayTitle);
		productDisplayTitle.clear();
		productDisplayTitle.sendKeys(display_title);
	}
	
	//
	//WebElement of validation error message of Product Display Title field of Inventory Setup English form
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_title")
	WebElement validationProductDisplayTitle;
	
	//
	//Function to get validation error message of Product Display Title field of Inventory Setup English form
	//
	public String getValidationProductDisplayTitle()
	{
		waitForVisibility(validationProductDisplayTitle);
		return validationProductDisplayTitle.getText();
	}
	
	//
	//WebElement of Arabic link in Inventory Setup General form
	//
	@FindBy(how=How.CSS,using="#listing > div.cards-content.pl-4.pr-4 > div.tabs__content.form > div > div > div:nth-child(1) > div > ul > li:nth-child(3) > a")
	WebElement arabicLink;
	
	//
	//Function to click on Arabic link in Inventory Setup General form
	//
	public void clickOnArabicLink() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(arabicLink);
		arabicLink.click();
	}
	
	//
	//WebElement of success message on the form
	//
	@FindBy(how=How.ID,using="mbsmessage")
	WebElement successMessage;
	
	//
	//Function to get success message on the form
	//
	public String getSuccessMessage() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(successMessage);
		return successMessage.getText();
	}
	
	//
	//WebElement of Cost Price field of Product Setup General Basic form
	//
	@FindBy(how=How.NAME,using="selprod_cost")
	WebElement costPrice;
	
	//
	//Function to enter Cost Price field of Product Setup General Basic form
	//
	public void enterCostPrice(String Cost_Price)
	{
		waitForVisibility(costPrice);
		costPrice.sendKeys(Cost_Price);
	}
}
