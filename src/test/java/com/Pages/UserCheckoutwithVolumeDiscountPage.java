package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserCheckoutwithVolumeDiscountPage {
	
WebDriver driver;
	
	public UserCheckoutwithVolumeDiscountPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(element));
    }	
	
	//
	//WebElement of first Minimum Purchase Quantity for first Volume Discount
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div.cards-content.pl-4.pr-4 > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(2)")
	WebElement firstVolumeDiscountQuantity;
	
	//
	//Function to get first Minimum Purchase Quantity for first Volume Discount
	//
	public String getfirstVolumeDiscountQuantity()
	{
		waitForVisibility(firstVolumeDiscountQuantity);
		return firstVolumeDiscountQuantity.getText();
	}
	
	//
	//WebElement of first Minimum Purchase Quantity for first Volume Discount
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div.cards-content.pl-4.pr-4 > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(3)")
	WebElement discountPercentageoffirstVolumeDiscountQuantity;
	
	//
	//Function to get Discount (%) of first Minimum Purchase Quantity for first Volume Discount
	//
	public String getDiscountPercentageoffirstVolumeDiscountQuantity()
	{
		waitForVisibility(discountPercentageoffirstVolumeDiscountQuantity);
		return discountPercentageoffirstVolumeDiscountQuantity.getText();
	}
	
	//
	//WebElement of second Minimum Purchase Quantity for second Volume Discount
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div.cards-content.pl-4.pr-4 > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(2)")
	WebElement secondVolumeDiscountQuantity;
	
	//
	//Function to get second Minimum Purchase Quantity for second Volume Discount
	//
	public String getsecondVolumeDiscountQuantity()
	{
		waitForVisibility(secondVolumeDiscountQuantity);
		return secondVolumeDiscountQuantity.getText();
	}
	
	//
	//WebElement of second Minimum Purchase Quantity for second Volume Discount
	//
	@FindBy(how=How.CSS,using="#listing > div.cards > div.cards-content.pl-4.pr-4 > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(3)")
	WebElement discountPercentageofsecondVolumeDiscountQuantity;
	
	//
	//Function to get Discount (%) of second Minimum Purchase Quantity for second Volume Discount
	//
	public String getDiscountPercentageofsecondVolumeDiscountQuantity()
	{
		waitForVisibility(discountPercentageofsecondVolumeDiscountQuantity);
		return discountPercentageofsecondVolumeDiscountQuantity.getText();
	}
	
	//
	//WebElement of WHOLESALE PRICE first field on product detail page
	//
	@FindBy(how=How.XPATH,using="//li[@class='slick-slide slick-current slick-active']")
	WebElement firstVolumeDiscountonProductDetailPage;
	
	//
	//Function to get WHOLESALE PRICE first field on product detail page
	//
	public String getfirstVolumeDiscountonProductDetailPage()
	{
		waitForVisibility(firstVolumeDiscountonProductDetailPage);
		return firstVolumeDiscountonProductDetailPage.getText();
	}
	
	//
	//WebElement of WHOLESALE PRICE second field on product detail page
	//
	@FindBy(how=How.XPATH,using="//li[@class='slick-slide slick-active']")
	WebElement secondVolumeDiscountonProductDetailPage;
	
	//
	//Function to get WHOLESALE PRICE second field on product detail page
	//
	public String getsecondVolumeDiscountonProductDetailPage()
	{
		waitForVisibility(secondVolumeDiscountonProductDetailPage);
		return secondVolumeDiscountonProductDetailPage.getText();
	}
	
	//
	//WebElement of Cart Details on Product Detail Page
	//
	@FindBy(how=How.CLASS_NAME,using="cartdetail__footer")
	WebElement cartDetailonProductDetailPage;
	
	//
	//Function to get Cart Details on Product Detail Page
	//
	public String getCartDetailonProductDetailPage()
	{
		waitForVisibility(cartDetailonProductDetailPage);
		return cartDetailonProductDetailPage.getText();
	}
	
	//
	//WebElement of View Bag button in Cart Bag on Product Detail Page
	//
	@FindBy(how=How.XPATH,using="//a[@href='/cart']")
	WebElement viewBagOnCartBag;
	
	//
	//Function to click on View Bag button in Cart Bag on Product Detail Page
	//
	public void clickViewBagOnCartBag() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(viewBagOnCartBag);
		viewBagOnCartBag.click();
	}
	
	//
	//WebElement of Quantity input field on Shopping Cart page
	//
	@FindBy(how=How.XPATH,using="//input[@class='qty-input cartQtyTextBox productQty-js']")
	WebElement quantityInputFieldShoppingCart;
	
	//
	//Function to enter Quantity input field on Shopping Cart page
	//
	public void enterQuantityInputFieldShoppingCart(String input_Quantity) throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(quantityInputFieldShoppingCart);
		quantityInputFieldShoppingCart.clear();
		quantityInputFieldShoppingCart.sendKeys(input_Quantity);
	}
	
	//
	//WebElement of Quantity input field's increase icon on Shopping Cart page
	//
	@FindBy(how=How.CLASS_NAME,using="increase-js")
	WebElement increaseQuantity;
	
	//
	//Function to click on Quantity input field's increase icon on Shopping Cart page
	//
	public void clickIncreaseQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(increaseQuantity);
		increaseQuantity.click();
	}
	
	//
	//WebElement of Cart Section on Shopping Cart page
	//
	@FindBy(how=How.CLASS_NAME,using="cart-footer")
	WebElement cartSection;
	
	//
	//Function to get Cart Section on Shopping Cart page
	//
	public String getCartSection() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(cartSection);
		return cartSection.getText();
	}
	
	//
	//Function to get entered quantity on Shopping cart page
	//
	public String getProductQuantity() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(quantityInputFieldShoppingCart);
		return quantityInputFieldShoppingCart.getAttribute("value");
	}
	
	//
	//WebElement of Seeling Price on Shopping Cart page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-9.col-lg-8 > div > table > tbody > tr > td:nth-child(4) > span")
	WebElement sellingPrice;
	
	//
	//Function to get Seeling Price on Shopping cart page
	//
	public String getSellingPriceonCartPage() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(sellingPrice);
		return sellingPrice.getText();
	}
	
	//
	//WebElement of Sub Total on Shopping Cart Page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-9.col-lg-8 > div > table > tbody > tr > td:nth-child(5) > span")
	WebElement subTotal;
	
	//
	//Function to get Sub Total on Shopping cart page
	//
	public String getsubTotalPriceonCartPage() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(subTotal);
		return subTotal.getText();
	}
	
	//
	//WebElement of volume Discount for First whole sale discount Calculated on Shopping Cart Page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-3.col-lg-4 > div > div.cartdetail__footer > table > tbody > tr:nth-child(3) > td.text-right")
	WebElement volumeDiscountFirstCalculated;
	
	//
	//Function to get volume Discount for First whole sale discount Calculated on Shopping Cart Page
	//
	public String getvolumeDiscountFirstCalculated() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(volumeDiscountFirstCalculated);
		return volumeDiscountFirstCalculated.getText();
	}
	
	//
	//WebElement of Tax Calculated on Shopping Cart Page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-3.col-lg-4 > div > div.cartdetail__footer > table > tbody > tr:nth-child(2) > td.text-right")
	WebElement taxCalculated;
	
	//
	//Function to get Tax Calculated on Shopping Cart Page
	//
	public String getTaxCalculated()
	{
		waitForVisibility(taxCalculated);
		return taxCalculated.getText();
	}
	
	//
	//WebElement of Net Payable calculated on Shopping Cart Page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-3.col-lg-4 > div > div.cartdetail__footer > table > tbody > tr:nth-child(4) > td.text-right.hightlighted")
	WebElement netPayable;
	
	//
	//Function to get Net Payable calculated on Shopping Cart Page
	//
	public String getNetPayable()
	{
		waitForVisibility(netPayable);
		return netPayable.getText();
	}
	
	//
	//WebElement of Checkout button on Shopping Cart Page
	//
	@FindBy(how=How.CSS,using="#cartList > div > div.col-xl-3.col-lg-4 > div > div.cartdetail__footer > table > tbody > tr:nth-child(5) > td > div > a.btn.btn--primary-border")
	WebElement checkout;
	
	//
	//Function to click on Checkout button on Shopping Cart Page
	//
	public void clickCheckout()
	{
		waitForVisibility(checkout);
		checkout.click();
	}
	
	//
	//WebElement of Net Payale on Shipping Summary Page
	//
	@FindBy(how=How.CSS,using="body > div.wrapper > section > div > div > div.col-lg-4 > div > div > div:nth-child(7) > div > table > tbody > tr:nth-child(4) > td.text-right.hightlighted")
	WebElement netPayableShipping;
	
	//
	//Function to get Net Payale on Shipping Summary Page
	//
	public String getNetPayableShipping()
	{
		waitForVisibility(netPayableShipping);
		return netPayableShipping.getText();
	}
	
	//
	//WebElement of Continue button on Shipping Summary Page
	//
	@FindBy(how=How.CSS,using="body > div.wrapper > section > div > div > div.col-lg-8.mb-4.mb-md-0.checkout-content-js > div.box.box--white.box--radius.p-4 > div > div.col-auto > a")
	WebElement continueShippingSummary;
	
	//
	//Function to click on Continue button on Shipping Summary Page
	//
	public void click_Continue_ShippingSummary()
	{
		waitForVisibility(continueShippingSummary);
		continueShippingSummary.click();
	}
	
	//
	//WebElement of Amount on Order Details Page
	//
	@FindBy(how=How.CSS,using="#main-area > div > div.content-body > div > div.cards-content.pl-4.pr-4 > table > tbody > tr:nth-child(2) > td:nth-child(9)")
	WebElement amountOnDetailPage;
	
	//
	//Function to get Amount on Order Details Page
	//
	public String getAmountOrderDetailPage()
	{
		waitForVisibility(amountOnDetailPage);
		return amountOnDetailPage.getText();
	}
}
