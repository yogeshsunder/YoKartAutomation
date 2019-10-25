/**
 * 
 */
package com.TestCases;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

/**
 * @author Yogesh
 *
 */
public class ExtentFactory {
	public static ExtentReports getInstance()
	{
		ExtentReports extent;
		//String Path = "D://Yogesh//YoKart//Functional Automation Reports//YoKart_AutomationJuly5.html";
		String Path = "D://Yogesh//YoKart//YoKart_Functional_Automation_October23_1.html";
		//extent = new ExtentReports(Path, true);
		extent = new ExtentReports(Path, false);
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		
		extent.addSystemInfo("User Name", "Yogesh Kumar");
		extent.addSystemInfo("Host Name", "AblySoft QC Team");
		extent.addSystemInfo("Version of Yo! Kart", "9.0.0");
		
		return extent;
		
	}

}