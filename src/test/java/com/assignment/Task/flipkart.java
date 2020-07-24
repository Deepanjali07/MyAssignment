package com.assignment.Task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.Library.AppLibrary;
import com.assignment.Library.TestBase;
import com.assignment.PageObject.flipkartPage;

public class flipkart  extends TestBase {
			
			public flipkartPage fp;
			
			@BeforeClass
			public void setUp() throws Exception {
				appLibrary = new AppLibrary("DownloadTest");
				fp =new flipkartPage(appLibrary);
			}
			@Test
			public void testgetList() throws Exception {
				appLibrary.getDriverInstance();
				appLibrary.launchApp("https://www.flipkart.com");
				fp.searchBook();
			}
		
}

