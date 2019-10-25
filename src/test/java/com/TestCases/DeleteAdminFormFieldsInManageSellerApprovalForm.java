package com.TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.Pages.AdminLoginPage;
import com.Pages.AdminSellerApprovalFormPage;

import Helper.BrowserFactory1;

public class DeleteAdminFormFieldsInManageSellerApprovalForm {
	
	static WebDriver driver;
	
	@Test
	public static void deleteFormFieldsManageSellerApprovalForm() throws FileNotFoundException, IOException, ParseException, InterruptedException
	{
		//int i=1;
		//do
		//{
			//System.out.println(i);
			//i++;
		//}
		
		//while(i<=10);
		
		driver=BrowserFactory1.startBrowser("chrome", "url");

		AdminLoginPage sellerCreation=PageFactory.initElements(driver, AdminLoginPage.class);

		AdminSellerApprovalFormPage sellerapproval=PageFactory.initElements(driver, AdminSellerApprovalFormPage.class);

		sellerCreation.loginAdmin();

		sellerapproval.clickonMenuIcon();

		sellerapproval.clickonUser();

		sellerapproval.clickonSellerApprovalForm();
		
		//String[] XPATHIcon = new String[]{"//*[@id=\"102\"]/td[6]/ul/li/a/i", "//*[@id=\"103\"]/td[6]/ul/li/a/i","//*[@id=\"104\"]/td[6]/ul/li/a/i"};
		//String[] XPATHdelete = new String[]{"//*[@id=\"101\"]/td[6]/ul/li/div/ul/li[2]/a", "//*[@id=\"102\"]/td[6]/ul/li/div/ul/li[2]/a","//*[@id=\"103\"]/td[6]/ul/li/div/ul/li[2]/a"};
		
		// for(String icon: XPATHIcon)
		//{
	
		//	Thread.sleep(1000);
		//	driver.findElement(By.xpath(XPATHIcon)).click();
	
		//	Thread.sleep(1000);
		//	driver.findElement(By.xpath("//*[@id=\"101\"]/td[6]/ul/li/div/ul/li[2]/a")).click();
		//	Thread.sleep(1000);
		//	driver.switchTo().alert().accept();
		//}
		
		 for(int j=57; j<=74; j++)
				{
			
					Thread.sleep(2500);
					driver.findElement(By.xpath("//*[@id=\""+j+"\"]/td[6]/ul/li/a/i")).click();
			
					Thread.sleep(2500);
					driver.findElement(By.xpath("//*[@id=\""+j+"\"]/td[6]/ul/li/div/ul/li[2]/a")).click();
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
				}
	}
}
