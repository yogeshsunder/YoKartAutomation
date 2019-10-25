package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.AdminAddBrandsPage;
import com.Pages.AdminAddCategoryPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;

import Helper.BrowserFactory1;

public class DeleteAdminBrands {
	
	WebDriver driver;
	
	String CategoryName;
	
	@Test
	public void adminCategoriesDelete() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		
		driver=BrowserFactory1.startBrowser("chrome", "url");
		
		//
		//Created Page Object using Page Factory to call the functions from SellerCreationPage for Admin Login.
		//
		AdminLoginPage adminlogin=PageFactory.initElements(driver, AdminLoginPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from AdminSellerApprovalFormPage to click on dashboard from top.
		//
		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Category Page to click on dashboard from top.
		//
		AdminAddCategoryPage addCategory=PageFactory.initElements(driver, AdminAddCategoryPage.class);
		
		//
		//Created Page Object using Page Factory to call the functions from Admin Add Category Page to click on dashboard from top.
		//
		AdminAddBrandsPage addBrands=PageFactory.initElements(driver, AdminAddBrandsPage.class);

		adminlogin.loginAdmin();

		sellerapproval.clickonMenuIcon();
		
		addCategory.clickonCatalog();

		addBrands.clickonBrands();
		
		for(int j=91; j<=99; j++)
		{
	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\""+j+"\"]/td[6]/ul/li/a/i")).click();
	
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\""+j+"\"]/td[6]/ul/li/div/ul/li[2]/a")).click();
			Thread.sleep(1000);
			driver.switchTo().alert().accept();
		}
		
	}

}
