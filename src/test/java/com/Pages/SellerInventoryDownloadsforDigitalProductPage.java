package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SellerInventoryDownloadsforDigitalProductPage {
	
WebDriver driver;
	
	public SellerInventoryDownloadsforDigitalProductPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void waitForVisibility(WebElement element)
	{
           new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
    }
	
	//
	//WebElement of Downalods link at the top
	//
	@FindBy(how=How.CSS,using="#listing > div.cards-content.p-3 > div.tabs.tabs--small.tabs--scroll.clearfix > ul > li:nth-child(6) > a")
	WebElement linkDownloads;
	
	//
	//Function to click on Downalods link at the top
	//
	public void clickOnLinkDownloads()
	{
		waitForVisibility(linkDownloads);
		linkDownloads.click();
	}
	
	//
	//WebElement of choose file in Download form
	//
	@FindBy(how=How.NAME,using="downloadable_file")
	WebElement chooseFile;
	
	//
	//Function to click on choose file in Download form
	//
	public void clickOnChooseFile()
	{
		waitForVisibility(chooseFile);
		chooseFile.click();
	}
	
	//
	//WebElement of Digital Download Type field
	//
	@FindBy(how=How.NAME,using="download_type")
	WebElement downloadType;
	
	//
	//Function to select Digital Download Type field
	//
	public void selectDownloadType(String Download_Type)
	{
		Select downloadtype = new Select(downloadType);
		downloadtype.selectByValue(Download_Type);
	}
	
	//
	//WebElement of Downloadable Link field
	//
	@FindBy(how=How.NAME,using="selprod_downloadable_link")
	WebElement downloadableLink;
	
	//
	//
	//
	public void enterDownloadableLink(String download_link)
	{
		waitForVisibility(downloadableLink);
		downloadableLink.clear();
		downloadableLink.sendKeys(download_link);
	}
	
	//
	//WebElement of Save changes button on the form
	//
	@FindBy(how=How.NAME,using="btn_submit")
	WebElement saveChanges;
	
	//
	//Function to click on Save changes button on the form
	//
	public void clickOnSaveChanges()
	{
		waitForVisibility(saveChanges);
		saveChanges.click();
	}
	
	//
	//WebElement of validation error message of Downloadable Link field
	//
	@FindBy(how=How.CLASS_NAME,using="erlist_selprod_downloadable_link")
	WebElement validationDownloadableLink;
	
	//
	//Function to get validation error message of Downloadable Link field
	//
	public String getValidationDownloadableLink()
	{
		waitForVisibility(validationDownloadableLink);
		return validationDownloadableLink.getText();
	}
	
	//
	//WebElement of success message coming at the top
	//
	@FindBy(how=How.CLASS_NAME,using="alert--success")
	WebElement successAlert;
	
	//
	//Function to get success message coming at the top of the form
	//
	public String getSucessAlert()
	{
		waitForVisibility(successAlert);
		return successAlert.getText();
	}
	

}
