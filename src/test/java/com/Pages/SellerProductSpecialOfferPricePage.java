package com.Pages;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class SellerProductSpecialOfferPricePage {
	
	WebDriver driver;
	
	public SellerProductSpecialOfferPricePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	private void waitForVisibility(WebElement element) throws Error
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }
	
	public void waitForClickability(WebElement element)
	{
           new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
    }
	
	//
	//WebElement of special price on product inventory setup form
	//
	@FindBy(how=How.LINK_TEXT,using="Special Price")
	//@FindBy(how=How.XPATH,using="//a[@onclick='sellerProductSpecialPrices(247)']")
	WebElement specialPrice;
	
	//
	//Function to click on special price on product inventory setup form
	//
	public void clickOnSpeicalPrice()
	{
		waitForVisibility(specialPrice);
		specialPrice.click();
	}
	
	//
	//WebElement of Inventory Setup list on product inventory setup form
	//
	@FindBy(how=How.CSS,using="#listing > div.tabs.tabs--small.tabs--scroll.clearfix > ul")
	WebElement inventoryMenuList;
	
	//
	//Function to click on special price on product inventory setup form
	//
	public void click_Speical_Price()
	{
		waitForVisibility(inventoryMenuList);
		List<WebElement> inventorySetupList = inventoryMenuList.findElements(By.cssSelector("#listing > div.tabs.tabs--small.tabs--scroll.clearfix > ul > li"));
		for(int i = 0; i < inventorySetupList.size(); i++)
		{
			if(inventorySetupList.get(i).getText().contains("Special Price"))
			{
				inventorySetupList.get(i).click();
				break;
			}
		}
	}
	
	//
	//WebElement of My Inventory link on Marketplace Products page
	//
	@FindBy(how=How.XPATH,using="//a[@href='/seller/products']")
	WebElement myInventory;
	
	//
	//Function to click on My Inventory link on Marketplace Products page
	//
	public void clickOnMyInventory()
	{
		waitForClickability(myInventory);
		myInventory.click();
	}
	
	//
	//WebElement of Edit Inventory option in My Inventory page
	//
	@FindBy(how=How.CLASS_NAME,using="fa-edit")
	WebElement editInventory;
	
	//
	//Function to click On Edit Inventory in My Inventory page
	//
	public void clickOnEditInventory()
	{
		waitForVisibility(editInventory);
		editInventory.click();
	}
	
	//
	//WebElement of Add New Special Price button on Inventory Setup Special Price page
	//
	@FindBy(how=How.LINK_TEXT,using="Add New Special Price")
	WebElement addNewSpecialPrice;
	
	//
	//Function to click on Add New Special Price button on Inventory Setup Special Price page
	//
	public void clickOnAddNewSpecialPrice() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(addNewSpecialPrice);
		addNewSpecialPrice.click();
	}
	
	//
	//WebElement of Manage Special Price button on Inventory Setup Special Price page
	//
	@FindBy(how=How.LINK_TEXT,using="Manage Special Price")
	WebElement manageSpecialPrice;
	
	//
	//Function to click on Add New Special Price button on Inventory Setup Special Price page
	//
	public void clickOnManageSpecialPrice() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(manageSpecialPrice);
		manageSpecialPrice.click();
	}
	
	//
	//WebElement of Save Changes button on Special Price form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save Changes button on Special Price form
	//
	public void clickOnSaveChanges() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of Save Changes button on Special Price form
	//
	@FindBy(how=How.NAME,using="btn_update")
	WebElement save_Changes;
	
	//
	//Function to click on Save Changes button on Special Price form
	//
	public void click_Save_Changes_Manage() throws InterruptedException
	{
		Thread.sleep(500);
		waitForVisibility(save_Changes);
		save_Changes.click();
	}
	
	//
	//WebElement of validation error message of Special Price field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_splprice_price")
	WebElement validationSpecialPrice;
	
	//
	//Function to get validation error message of Special Price field
	//
	public String getValidationSpecialPrice()
	{
		waitForVisibility(validationSpecialPrice);
		return validationSpecialPrice.getText();
	}
	
	//
	//WebElement of Special Price field
	//
	@FindBy(how=How.NAME,using="splprice_price")
	WebElement speicalPrice;
	
	//
	//Function to Enter Special Price
	//
	public void enterSpecialPrice(String special_price)
	{
		waitForVisibility(speicalPrice);
		speicalPrice.clear();
		speicalPrice.sendKeys(special_price);
	}
	
	//
	//WebElement of validation error message of Price Start Date field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_splprice_start_date")
	WebElement validationPriceStartDate;
	
	//
	//Function to get validation error message of Price Start Date field
	//
	public String getValidationPriceStartDate()
	{
		waitForVisibility(validationPriceStartDate);
		return validationPriceStartDate.getText();
	}
	
	//
	//WebElement of field Price Start Date in Special Price form
	//
	@FindBy(how=How.NAME,using="splprice_start_date")
	WebElement priceStartDate;
	
	//
	//Function to click on field Price Start Date in Special Price form
	//
	public void clickOnPriceStartDate()
	{
		waitForVisibility(priceStartDate);
		priceStartDate.click();
	}
	
	//
	//Function to click on field Price Start Date in Special Price form
	//
	public void clickOnPriceStartDate_waited() throws InterruptedException
	{
		Thread.sleep(2000);
		waitForVisibility(priceStartDate);
		priceStartDate.click();
	}
	
	//
	//Creation of private function to Get The Current Date from any Calendar
	//
	private String getCurrentDay()
	{
        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int todayInt = calendar.get(Calendar.DAY_OF_MONTH);

        String todayStr = Integer.toString(todayInt);
        
        return todayStr;
    }
	
	//
	//Creation of private function to Get The Tomorrow's Date from any Calendar
	//
	private String getTomorrow()
	{
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int tomorrow = calendar.get(Calendar.DAY_OF_MONTH);
        
        int tomorrowInt = tomorrow+1;

        String tomorrowStr = Integer.toString(tomorrowInt);
        
        return tomorrowStr;
		
		/*
		 * Date dt = new Date(0);
		 * 
		 * Calendar calendar = Calendar.getInstance(); calendar.setTime(dt);
		 * calendar.add(Calendar.DATE, 1); dt = (Date) calendar.getTime();
		 * 
		 * 
		 * String tommorowsDate = new SimpleDateFormat("MM/dd/yyyy").format(dt);
		 * 
		 * System.out.println("Tomorrow is:" + tommorowsDate);
		 */
		
		/*
		 * Calendar calendar = Calendar.getInstance();
		 * 
		 * calendar.add(Calendar.DAY_OF_MONTH, 1);
		 * 
		 * int tomorrowInt = calendar.add(Calendar.DAY_OF_MONTH, 1);
		 * 
		 * String tommorowsDate = Integer.toString(tomorrowInt);
		 * 
		 * //String tommorowsDate = new
		 * SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime()); //String
		 * tommorowsDate = new
		 * SimpleDateFormat("MM/dd/yyyy").format(calendar.getTime());
		 * 
		 * System.out.println("Tomorrow is:" + tommorowsDate);
		 */ 
	        
	     //return tommorowsDate;
    }
	
	//
	//Creation of private function to Get The day after Tomorrow's Date from any Calendar
	//
	private String getDayAfterTomorrow()
	{
		
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        int dayaftertomorrow = calendar.get(Calendar.DAY_OF_MONTH);
        
        int dayaftertomorrowInt = dayaftertomorrow+2;

        String dayaftertomorrowStr = Integer.toString(dayaftertomorrowInt);
        
        return dayaftertomorrowStr;
    }
	
	
	//
	//WebElement of price Start Date Calendar
	//
	@FindBy(how=How.CSS,using="#ui-datepicker-div > table > tbody")
	WebElement priceStartDateCalendar;
	
	//
	//Function to click on today's date in price Start Date Calendar
	//
	public void clickOnTodayInCalendar()
	{
		String today = getCurrentDay();
		
		List<WebElement> columns = priceStartDateCalendar.findElements(By.tagName("td"));
		
	    for (WebElement cell: columns) 
	    {

	            if (cell.getText().equals(today))
	            {
	                cell.click();
	                break;
	            }
	    }
	}
	
	//
	//Function to click on tomorrow's date in price Start Date Calendar
	//
	public void clickOnTomorrowInCalendar()
	{
		String tomorrow = getTomorrow();
		
		List<WebElement> columns = priceStartDateCalendar.findElements(By.tagName("td"));
		
	    for (WebElement cell: columns) 
	    {

	            if (cell.getText().equals(tomorrow))
	            {
	                cell.click();
	                break;
	            }
	    }
	}
	
	//
	//Function to click on day after tomorrow's date in price Start Date Calendar
	//
	public void clickOnDayAfterTomorrowInCalendar()
	{
		String dayaftertomorrow = getDayAfterTomorrow();
		
		List<WebElement> columns = priceStartDateCalendar.findElements(By.tagName("td"));
		
	    for (WebElement cell: columns) 
	    {

	            if (cell.getText().equals(dayaftertomorrow))
	            {
	                cell.click();
	                break;
	            }
	    }
	}
	
	//
	//WebElement of validation error message of Price End Date field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_splprice_end_date")
	WebElement validationPriceEndDate;
	
	//
	//Function to get validation error message of Price End Date field
	//
	public String getValidationPriceEndDate()
	{
		waitForVisibility(validationPriceEndDate);
		return validationPriceEndDate.getText();
	}
	
	//
	//WebElement of Price End Date field
	//
	@FindBy(how=How.NAME,using="splprice_end_date")
	WebElement speciallPriceEndDate;
	
	//
	//Function to click on Price End Date field
	//
	public void clickOnPriceEndDate()
	{
		waitForVisibility(speciallPriceEndDate);
		speciallPriceEndDate.click();
	}
	
	//
	//WebElement of Add New Special Price at top
	//
	@FindBy(how=How.CSS,using="#listing > div.cards-header.p-3 > div > a")
	WebElement addNewSpecialPrice2;
	
	//
	//Function to click on Add New Special Price at top
	//
	public void clickOnAddNewSpecialPriceTop()
	{
		//waitForVisibility(addNewSpecialPrice2);
		addNewSpecialPrice2.click();
	}
	
	//
	//WebElement of first Special Price of the product 
	//
	@FindBy(how=How.CLASS_NAME,using="form__subcontent")
	WebElement firstSpecialPrice;
	
	//
	//Function to get first Special Price of the product 
	//
	public String getFirstSpecialPrice() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(firstSpecialPrice);
		return firstSpecialPrice.getText();
	}
	
	//
	//WebElement of second Special Price of the product 
	//
	@FindBy(how=How.CSS,using="#frmSplPriceListing > table > tbody")
	WebElement secondSpecialPrice;
	
	//
	//Function to get second Special Price of the product 
	//
	public String getSecondSpecialPrice()
	{
		waitForVisibility(secondSpecialPrice);
		return secondSpecialPrice.getText();
	}
	
	//
	//WebElement of second Special Price of the product 
	//
	@FindBy(how=How.ID,using="frmSplPriceListing")
	WebElement second_Special_Price;
	
	//
	//Function to get second Special Price of the product 
	//
	public String getSecond_Special_Price() throws InterruptedException
	{
		Thread.sleep(5000);
		waitForVisibility(second_Special_Price);
		return second_Special_Price.getText();
	}
	
	//
	//Function to get second Special Price of the product updated as per flow change
	//
	public String getSecondSpecialPrice_updated()
	{
		
		waitForVisibility(secondSpecialPrice);
		
		WebElement htmltable=driver.findElement(By.cssSelector("#frmSplPriceListing > table > tbody"));

		List<WebElement> rows=htmltable.findElements(By.xpath("//*[@id=\\\"frmSplPriceListing\\\"]/table/tbody/tr"));
		
		

		for(int rnum=0;rnum<rows.size();rnum++)
			{
			
				System.out.println("Rows text is given below:" + rnum);

				List<WebElement> columns=rows.get(rnum).findElements(By.tagName("td"));

				

				for(int cnum=0;cnum<columns.size();cnum++)
					
					{
						//System.out.println(columns.get(cnum).getText());
							if (columns.get(cnum).getText().contains("10"))
							{
								System.out.println("System is entering into first row.");
							}
					}
			}
		return null;
	}
	
	//
	//WebElement of validation error message coming at top of special price pop up
	//
	@FindBy(how=How.CLASS_NAME,using="content")
	WebElement validationTop;
	
	//
	//Function to get validation error message coming at top of special price pop up
	//
	public String getValidationTop() throws InterruptedException
	{
		Thread.sleep(1000);
		waitForVisibility(validationTop);
		return validationTop.getText();
	}
	
	//
	//Another Function to get validation error message coming at top of special price pop up
	//
	public String getTopValidation()
	{
		@SuppressWarnings("deprecation")
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
		        .withTimeout(3000, TimeUnit.MILLISECONDS)
		        .pollingEvery(250, TimeUnit.MILLISECONDS)
		        .ignoring(NoSuchElementException.class);
		 
		 WebElement element = wait.until(new Function<WebDriver, WebElement>() 
		 {
			 public WebElement apply(WebDriver driver) 
			 {
				 if(validationTop.isDisplayed())
				 	{
						 return validationTop;
				 	}
				 	else
				 	{
				 		return null;
				 	}
			 }
		 });
		 
		 return element.getText();
	}
	
	//
	//WebElement of validation error message coming at top of special price pop up
	//
	@FindBy(how=How.CLASS_NAME,using="content")
	WebElement validationAlreadyAdded;
	
	//
	//Function to get validation error message coming at top of special price pop up
	//
	public String getValidationTopDuplicate() throws InterruptedException
	{
		waitForVisibility(validationAlreadyAdded);
		return validationAlreadyAdded.getText();
	}
	
	//
	//WebElement of Cancel button on Add Special Price pop up
	//
	@FindBy(how=How.NAME,using="btn_cancel")
	WebElement cancelButton;
	
	//
	//Function to click on Cancel button on Add Special Price pop up
	//
	public void clickOnCancelButton()
	{
		cancelButton.click();
	}
}
