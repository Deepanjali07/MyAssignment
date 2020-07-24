package com.assignment.Task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.Library.AppLibrary;
import com.assignment.Library.TestBase;
import com.assignment.PageObject.downloadImgPage;



public class downloadImg extends TestBase {
		
		public downloadImgPage dp;
		
		@BeforeClass
		public void setUp() throws Exception {
			appLibrary = new AppLibrary("DownloadTest");
			dp =new downloadImgPage(appLibrary);
		}
		@Test
		public void testgetList() throws Exception {
			appLibrary.getDriverInstance();
			appLibrary.launchApp("https://www.google.com/gmail/about/");
			dp.downloadimg();
		}
	
	

}
