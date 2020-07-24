package com.assignment.Task;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.Library.AppLibrary;
import com.assignment.Library.TestBase;
import com.assignment.PageObject.upworkPage;

public class upwork extends TestBase {
	
	public upworkPage up;

		
	@BeforeClass
	public void setUp() throws Exception {
		appLibrary = new AppLibrary("Test");
		up = new upworkPage(appLibrary);
	}
	
	@Test
	public void testgetList() throws Exception {
		appLibrary.getDriverInstance();
		appLibrary.launchApp("https://www.upwork.com");
		up.searchFreeLancers("QA");
	}

}
