package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AdminAddNewProductPage {
	
WebDriver driver;
	
	public AdminAddNewProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Products in Catalog drop down of Dashboard drop down
	//
	@FindBy(how=How.CSS,using="#body > aside > div > ul > li:nth-child(2) > ul > li:nth-child(3) > a")
	WebElement products;
	
	//
	//Function to click on Products in Catalog drop down of Dashboard drop down
	//
	public void clickOnProducts()
	{
		waitForVisibility(products);
		products.click();
	}
	
	//
	//WebElement of Add New Product icon on Manage Catalog page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > a > i")
	WebElement addNewProductIcon;
	
	//
	//
	//
	public void clickOnAddNewProductIcon() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(addNewProductIcon);
		addNewProductIcon.click();
	}
	
	//
	//WebElement of Add New Product on Manage Catalog page
	//
	@FindBy(how=How.CSS,using="#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul")
	WebElement addNewProduct;
	
	//
	//Function to click on Add New Product on Manage Catalog page
	//
	public void clickOnAddNewProduct() throws InterruptedException
	{
		WebElement dropdown = driver.findElement(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul"));
		
		 List<WebElement> verticalLinks = dropdown.findElements(By.cssSelector("#body > div > div > div > div > section:nth-child(3) > div.sectionhead > ul > li > div > ul > li"));
		 
		 for (int i = 0; i < verticalLinks.size(); i++) 
		 	{	
			 	if (verticalLinks.get(i).getText().contains("Add"))
			 		{
			 			Thread.sleep(500);
			 			verticalLinks.get(i).click();
			 		}
		 	}
	}
	
	//
	//WebElement of Save Changes on Product Setup General form
	//
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @name='btn_submit' and @value='Save Changes']")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes on Product Setup General form
	//
	public void clickOnSaveChanges() throws InterruptedException
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//Function to click on Save Changes on Product Setup English form
	//
	public void clickOnSaveChangesEnglish() throws InterruptedException
	{
		Thread.sleep(2500);
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Save Changes on Product Setup Arabic form
	//
	@FindBy(how=How.XPATH,using="//input[@type='submit' and @name='btn_submit']")
	WebElement saveChangesArabic;
	
	//
	//Function to click on Save Changes on Product Setup Arabic form
	//
	public void clickOnSaveChangesArabic() throws InterruptedException
	{
		Thread.sleep(3000);
		waitForVisibility(saveChangesArabic);
		saveChangesArabic.click();
	}
	
	//
	//WebElement of Mandatory validation error message of Product Identifier
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_identifier")
	WebElement mandatoryProductIdentifier;
	
	//
	//Function to get Mandatory validation error message of Product Identifier
	//
	public String getMandatoryProductIdentifier() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(mandatoryProductIdentifier);
		return mandatoryProductIdentifier.getText();
	}
	
	//
	//WebElement of User field in Product Setup General form
	//
	@FindBy(how=How.NAME,using="selprod_user_shop_name")
	WebElement User;
	
	//
	///Function to enter User field in Product Setup General form
	//
	public void enterUser(String user)
	{
		waitForVisibility(User);
		User.clear();
		User.sendKeys(user);
	}
	
	//
	//WebElement of Product Identifier
	//
	@FindBy(how=How.NAME,using="product_identifier")
	WebElement productIdentifier;
	
	//
	//Function to enter Product Identifier
	//
	public void enterProductIdentifier(String productidentifier)
	{
		waitForVisibility(productIdentifier);
		productIdentifier.clear();
		productIdentifier.sendKeys(productidentifier);
	}
	
	//
	//WebElement of Product Type field of Product Setup General form
	//
	@FindBy(how=How.ID,using="product_type")
	WebElement productType;
	
	//
	//Function to select Product Type field of Product Setup General form
	//
	public void selectProductType(String prdcttype)
	{
		waitForVisibility(productType);
		Select producttype = new Select(productType);
		producttype.selectByValue(prdcttype);
	}
	
	
	//
	//WebElement of Mandatory validation error message of Minimum Selling Price [$]
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_min_selling_price")
	WebElement mandatoryMinimumSellingPrice;
	
	//
	//Function to get Mandatory validation error message of Minimum Selling Price [$]
	//
	public String getmandatoryMinimumSellingPrice()
	{
		waitForVisibility(mandatoryMinimumSellingPrice);
		return mandatoryMinimumSellingPrice.getText();
	}
	
	//
	//WebElement of Minimum Selling Price [$] field
	//
	@FindBy(how=How.NAME,using="product_min_selling_price")
	WebElement productMinimumSellingPrice;
	
	//
	//Function to enter Product Minimum Selling Price
	//
	public void enterProductMinimumSellingPrice(String minimumsellingprice) 
	{
		waitForVisibility(productMinimumSellingPrice);
		productMinimumSellingPrice.clear();
		productMinimumSellingPrice.sendKeys(minimumsellingprice);
	}
	
	//
	//WebElement of Mandatory validation error message of Tax Category
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_ptt_taxcat_id")
	WebElement mandatoryTaxCategory;
	
	//
	//Function to get Mandatory validation error message of Tax Category
	//
	public String getMandatoryTaxCategory()
	{
		waitForVisibility(mandatoryTaxCategory);
		return mandatoryTaxCategory.getText();
	}
	
	//
	//WebElement of Tax Category drop down
	//
	@FindBy(how=How.NAME,using="ptt_taxcat_id")
	WebElement taxCategory;
	
	//
	//Function to click on Tax Category drop down
	//
	public void selectTaxCategory(String value)
	{
		waitForVisibility(taxCategory);
		Select taxcategory = new Select(taxCategory);
		taxcategory.selectByValue(value);
	}
	
	//
	//Function to click on Tax Category drop down
	//
	public void select_Tax_Category(String tax_cat)
	{
		List<WebElement> tax_category = taxCategory.findElements(By.cssSelector("#frmProduct > div:nth-child(8) > div > div > div.field-wraper > div > select > option"));
		
		for(int i = 0; i < tax_category.size(); i++)
		{
			if(tax_category.get(i).getText().contains(tax_cat))
			{
				tax_category.get(i).click();
			}
		}
	}
	
	//
	//WebElement of duplicate Product Identifier validation error message
	//
	@FindBy(how=How.CLASS_NAME,using="div_error")
	WebElement duplicateProductIdentifier;
	
	//
	//Function to get duplicate Product Identifier validation error message
	//
	public String getDuplicateProductIdentifier()
	{
		waitForVisibility(duplicateProductIdentifier);
		return duplicateProductIdentifier.getText();
	}
	
	//
	//WebElement of Mandatory validation error message of Model field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_model")
	WebElement mandatoryModel;
	
	//
	//Function of getting Mandatory validation error message of Model field
	//
	public String getMandatoryModel()
	{
		waitForVisibility(mandatoryModel);
		return mandatoryModel.getText();
	}
	
	//
	//WebElement of model field on the form
	//
	@FindBy(how=How.NAME,using="product_model")
	WebElement Model;
	
	//
	//Function to enter model in the form
	//
	public void enterModel(String model)
	{
		waitForVisibility(Model);
		Model.clear();
		Model.sendKeys(model);
	}
	
	//
	//WebElement of mandatory validation error message of Dimension Unit field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_dimension_unit")
	WebElement mandatoryDimensionsUnit;
	
	//
	//Function to get mandatory validation error message of Dimension Unit field
	//
	public String getMandatoryDimensionsUnit()
	{
		waitForVisibility(mandatoryDimensionsUnit);
		return mandatoryDimensionsUnit.getText();
	}
	
	//
	//WebElement of Dimensions Unit drop down
	//
	@FindBy(how=How.NAME,using="product_dimension_unit")
	WebElement dimensionsUnit;
	
	//
	//Function to click on Dimensions Unit drop down
	//
	public void selectDimensionsUnit(String dimension_unit)
	{
		waitForVisibility(dimensionsUnit);
		Select dimensionsunit = new Select(dimensionsUnit);
		dimensionsunit.selectByValue(dimension_unit);
	}
	
	//
	//WebElement of Mandatory validation error message for Length field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_length")
	WebElement mandatoryLength;
	
	//
	//Function to get Mandatory validation error message for Length field
	//
	public String getMandatoryLength()
	{
		waitForVisibility(mandatoryLength);
		return mandatoryLength.getText();
	}
	
	//
	//WebElement of Length field
	//
	@FindBy(how=How.NAME,using="product_length")
	WebElement enterlength;
	
	//
	//Function to enter Length in the field
	//
	public void enterLength(String length) 
	{
		waitForVisibility(enterlength);
		enterlength.clear();
		enterlength.sendKeys(length);
	}
	
	//
	//WebElement of Mandatory validation error message for Width field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_width")
	WebElement validationWidth;
	
	//
	//Function to get Mandatory validation error message for Width field
	//
	public String getvalidationWidth()
	{
		waitForVisibility(validationWidth);
		return validationWidth.getText();
	}
	
	//
	//WebElement of Width field
	//
	@FindBy(how=How.NAME,using="product_width")
	WebElement enterWidth;
	
	//
	//Function to enter Width in the field
	//
	public void enterWidth(String width) 
	{
		waitForVisibility(enterWidth);
		enterWidth.clear();
		enterWidth.sendKeys(width);
	}
	
	//
	//WebElement of validation error message of Height field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_height")
	WebElement validationHeight;
	
	//
	//Function of getting validation error message of Height field
	//
	public String getvalidationHeight()
	{
		waitForVisibility(validationHeight);
		return validationHeight.getText();
	}
	
	//
	//WebElement of height field
	//
	@FindBy(how=How.NAME,using="product_height")
	WebElement enterheight;
	
	//
	//Function to enter height in height field
	//
	public void enterHeight(String height)
	{
		waitForVisibility(enterheight);
		enterheight.clear();
		enterheight.sendKeys(height);
	}
	
	//
	//WebElement of mandatory Validation error message for Weight Unit
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_weight_unit")
	WebElement validationWeightUnit;
	
	//
	//Function to get mandatory Validation error message for Weight Unit
	//
	public String getValidationWeightUnit()
	{
		waitForVisibility(validationWeightUnit);
		return validationWeightUnit.getText();
	}
	
	//
	//WebElement of Weight Unit drop down
	//
	@FindBy(how=How.NAME,using="product_weight_unit")
	WebElement weightUnit;
	
	//
	//Function to click on Weight Unit drop down
	//
	public void selectWeightUnit(String weight_unit)
	{
		waitForVisibility(weightUnit);
		Select weightunit = new Select(weightUnit);
		weightunit.selectByValue(weight_unit);
	}
	
	//
	//WebElement of Weight field
	//
	@FindBy(how=How.NAME,using="product_weight")
	WebElement enterweight;
	
	//
	//Function to enter Weight field
	//
	public void enterWeight(String weight)
	{
		waitForVisibility(enterweight);
		enterweight.clear();
		enterweight.sendKeys(weight);
	}
	
	//
	//WebElement of validation error message of Weight Field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_weight")
	WebElement validationweightfield;
	
	//
	//Function to get validation error message of Weight Field
	//
	public String getValidationWeightField()
	{
		waitForVisibility(validationweightfield);
		return validationweightfield.getText();
	}
	
	//
	//WebElement of Product Status
	//
	@FindBy(how=How.NAME,using="product_active")
	WebElement productStatus;
	
	//
	//Function to select Product Status
	//
	public void selectProductStatus(String product_status)
	{
		waitForVisibility(productStatus);
		Select productstatus = new Select(productStatus);
		productstatus.selectByValue(product_status);
	}
	
	//
	//WebElement of add shipping icon
	//
	@FindBy(how=How.CLASS_NAME,using="ion-plus-round")
	WebElement addShippingIcon;
	
	//
	//Function to click on add shipping icon
	//
	public void clickOnAddShippingIcon()
	{
		waitForVisibility(addShippingIcon);
		addShippingIcon.click();
	}
	
	//
	//WebElement of Ships To field in Product Setup general form
	//
	@FindBy(how=How.NAME,using="product_shipping[0][country_name]")
	WebElement shipsTo;
	
	//
	//Function to enter Ships To
	//
	public void enterShipsTo(String shipsto)
	{
		waitForVisibility(shipsTo);
		shipsTo.clear();
		shipsTo.sendKeys(shipsto);
	}
	
	//
	//WebElement of Ships To drop down suggestion list to select
	//
	@FindBy(how=How.CSS,using="#shipping-row0 > td:nth-child(1) > ul > li > a")
	WebElement shipstoDropdown;
	
	//
	//Function to click on Ships To drop down suggestion list to select
	//
	public void clickOnShipsToDropdown()
	{
		waitForVisibility(shipstoDropdown);
		shipstoDropdown.click();
	}
	
	//
	//WebElement of Shipping Country field in Product setup General form
	//
	@FindBy(how=How.NAME,using="shipping_country")
	WebElement shippingCountry;
	
	//
	//Function to enter Shipping Country
	//
	public void enterShippingCountry(String shippingcountry)
	{
		waitForVisibility(shippingCountry);
		shippingCountry.clear();
		shippingCountry.sendKeys(shippingcountry);
	}
	
	//
	//WebElement of Shipping Country drop down suggestion list to select
	//
	@FindBy(how=How.CSS,using="#frmProduct > div:nth-child(19) > div > div > div.field-wraper > div > ul > li:nth-child(2)")
	WebElement shippingCountrydropdown;
	
	//
	//Function to click on India in Shipping Country drop down suggestion list to select
	//
	public void clickShippingCountrydropdown()
	{
		waitForVisibility(shippingCountrydropdown);
		shippingCountrydropdown.click();
	}
	
	//
	//WebElement of Free Shipping checkbox
	//
	@FindBy(how=How.CSS,using="#frmProduct > div:nth-child(20) > div > div > div.field-wraper > div > label > span")
	WebElement freeShipping;
	
	//
	//Function to click on Free Shipping checkbox
	//
	public void clickOnFreeShippingCheckBox() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(freeShipping);
		freeShipping.click();
	}
	
	//
	//WebElement of mandatory validation error message of Product Name
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_product_name")
	WebElement mandatoryProductName;
	
	//
	//Function to get mandatory validation error message of Product Name
	//
	public String getMandatoryValidationProductName()
	{
		waitForVisibility(mandatoryProductName);
		return mandatoryProductName.getText();
	}
	
	//
	//WebElement of Product Name field in Product set up English form
	//
	@FindBy(how=How.NAME,using="product_name")
	WebElement productName;
	
	//
	//Function to enter Product Name in Product set up English form
	//
	public void enterProductNameEnglish(String productname) throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(productName);
		productName.clear();
		productName.sendKeys(productname);
	}
	
	//
	//WebElement of success message for product setup completion
	//
	@FindBy(how=How.CSS,using="body > div.system_message.alert.alert--positioned-bottom-center.alert--positioned-small.alert--success")
	WebElement successMessage;
	
	//
	//
	//
	public String getSuccessMessage() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(successMessage);
		return successMessage.getText();
	}
	
	//
	//WebElement of User field of Product set up general form
	//
	@FindBy(how=How.NAME,using="selprod_user_shop_name")
	WebElement userField;
	
	//
	//Function to click on User field of Product set up general form
	//
	public void clickUserField()
	{
		waitForVisibility(userField);
		userField.click();
	}
	
	//
	//WebElement of selecting first seller for User Field
	//
	@FindBy(how=How.CSS,using="#frmProduct > div:nth-child(1) > div > div > div.field-wraper > div > ul > li:nth-child(1)")
	WebElement selectSeller;
	
	//
	//Functio to select first seller for User Field
	//
	public void selectSellerinUserField()
	{
		waitForVisibility(selectSeller);
		selectSeller.click();
	}

}
