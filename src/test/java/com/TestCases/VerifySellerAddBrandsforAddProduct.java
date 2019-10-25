package com.TestCases;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.AdminAddBrandsPage;
import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;
import Helper.BrowserFactory1;
public class VerifySellerAddBrandsforAddProduct {
	
	WebDriver driver;
	
	String brandidentifier,brandSEOFriendlyURL,brandName,brandNamedupliate;
	JSONParser parser=new JSONParser();
	
	@Test
	public void adminAddBrands() throws FileNotFoundException, IOException, InterruptedException, ParseException
	{
		
		//
		//Start the Browser from BrowserFactory from Helper and Admin Login page of the application.
		//		
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
		AdminAddBrandsPage addBrands=PageFactory.initElements(driver, AdminAddBrandsPage.class);
		
		//
		//Login into Admin.
		//
		adminlogin.loginAdmin();
		//
		//Click on Menu Icon
		//
		sellerapproval.clickonMenuIcon();
		
		//
		//Click on Catalog option of Dashboard drop down
		//
		addBrands.clickonCatalog();
		
		//
		//Click on Brands option of Catalog drop down option of Dashboard drop down
		//
		addBrands.clickonBrands();
		
		//
		//Click on edit Icon of Brand List
		//
		addBrands.clickoneditIconofBrandList();
		//
		//click on add Brand
		//
		addBrands.clickAddBrands();
		//
		//Check validation error message for Brand Identifier
		//
		addBrands.clickonAddNew();
		
		String uuid = UUID.randomUUID().toString();
		addBrands.enterBrandIdentifier(uuid);
		
		addBrands.clickonAddNew();
		
		Object obj = parser.parse(new FileReader("src/test/java/JSONData/adminAddBrandsInputData.json"));
		JSONObject jsonObject = (JSONObject) obj;
		
		brandNamedupliate = (String) jsonObject.get("Brand Name Dupliate");
		
		addBrands.enterBrandName(brandNamedupliate);
		
		addBrands.clickonupdateButton();
	
		driver.close();
	}

}
