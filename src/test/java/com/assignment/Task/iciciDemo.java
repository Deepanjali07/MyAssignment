package com.assignment.Task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.Library.AppLibrary;
import com.assignment.Library.TestBase;
import com.assignment.PageObject.iciciPage;


public class iciciDemo extends TestBase {
	
	public iciciPage ip;
		
	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("UserTest");
		ip = new iciciPage(appLibrary);
	}
	
//	@Test
	public void testgetList() throws Exception {
		appLibrary.getDriverInstance();
		appLibrary.launchApp("https://www.icicilombard.com/campaigns/health-insurance/health-insurance-pune");
		ip.getListofHospital();
	}
	
//	@Test
	public void testgetSecondList()  throws Exception{
		appLibrary.getDriverInstance();
		appLibrary.launchApp("https://www.icicilombard.com/campaigns/health-insurance/health-insurance-mumbai");
		ip.getListofHospitalByDiffCity();
		ip.getCommonHospital();
//		ip.sendemail();
	}
	
    @Test
	public void testgetexcelemial() throws Exception{
		System.out.println("Send Email test started");
		appLibrary.getDriverInstance();
		ip.sendemail();
		System.out.println("Email send Succesfully");
	}
	
}
