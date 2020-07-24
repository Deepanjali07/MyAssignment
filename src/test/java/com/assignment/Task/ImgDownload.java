package com.assignment.Task;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.assignment.Library.AppLibrary;
import com.assignment.Library.TestBase;
import com.assignment.PageObject.downloadImgPage;



public class ImgDownload extends TestBase {
		
		public downloadImgPage dp;
		WebDriver driver;
		public static By allImg = By.xpath("//img");
		
		@BeforeClass
		 public void setup() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "..//auto-drpepper//chromedriver.exe");
		  driver =new ChromeDriver();     
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.get("https://www.google.com/gmail/about/");
		 }
		
		@Test
		public void testgetList() throws Exception {
		List<WebElement> Image = driver.findElements(allImg);
		
		  Actions action= new Actions(driver);
		  action.contextClick().build().perform();
		  action.sendKeys(Keys.CONTROL, "v").build().perform();
		}
		
//		dp.downloadimg();

}


