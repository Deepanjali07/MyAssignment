package com.assignment.PageObject;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.assignment.Library.AppLibrary;



public class downloadImgPage {

	// public static String mobileimg="By.cssSelector("body >
	// div.g-gmail-hero.g-gmail-hero--standard > div > div > div > div:nth-child(2)
	// > div.content__poster > img");
	public static String laptopimg = "xpath://img[@src='https://lh3.googleusercontent.com/QmcmNCnb3Ln3oApBPEUfO3W0X_Ym41grEGspPDAB1ZDQ9qEQpukrZHSSwFOXmd0eJimtZFmnBITPKcBhT5Xn1p7SRWRFJNSjt7kZtMQ=w0']";
	public static String emailimg = "xpath://img[@src='https://lh3.googleusercontent.com/YzvIBrP6W8qYYtwszCXsyJoQpaVQxtLxxPfSyKh8Oe_AfBppPTlhvyEHEfpNnmVon9RbfiJ8Xfgb8BcUpSLBzpip1v9HMXUBxznCZQ=w0']";
	public static String emailimg1 = "xpath://img[@src='https://lh3.googleusercontent.com/SoN_g_n5BTtSxq6qpD2aE5JDNL_UcAOLNGFPI-8eOaGJdEQgKv5fER7fvxj3vy-zpvyxXeIUs8ypecDrBqt94AdJzFT0HeFA5Mkfl1Y=w0']";
	public static String emailimg2 = "xpath://img[@src='https://lh3.googleusercontent.com/zkX7gTBW3Ql69D0asDqnTMlqA_IpFwWr0PVJoH7qQN1be9L9njlQOy1-cSNDphn5z1_WS4-LaY0KlMaWHWwKOWty0_flmasay7mh=w0']";
	public static String resetpassimg = "xpath://img[@src='https://lh3.googleusercontent.com/7Yu9LBQSEaFZ7Bhq_JHsegDxd1XhiY7Em4uXI5YwoSUpO_RVVklfXTG1uig2FHqrmO6eg9cjQ7NyawAvR5dxi9T1a_kSyrpUw5pB=w0']";

//	public static By allImg = By.xpath("//img");
	public static String allImg="xpath://img";

	private WebDriver driver;
	public AppLibrary appLibrary;

	public downloadImgPage(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();

	}

	public void downloadimg() throws IOException
	{
		 appLibrary.waitForPageToLoad();
			List<WebElement> logo = appLibrary.findElements(allImg);
			appLibrary.sleep(2000);
			for(int i=1;i<logo.size();i++)
			{
			 String logoSRC = logo.get(i).getAttribute("src");
			 if(logoSRC.contains("https://lh3.googleusercontent.com/"))
			 {
				 URL imageURL = new URL(logoSRC);
				 System.out.println(imageURL);
				 BufferedImage saveImage = ImageIO.read(imageURL);
				 appLibrary.sleep(2000);
				 ImageIO.write(saveImage, "png", new File("..//auto-assignTask//Images", "pic" +i+ ".png"));
			 }//if
			 if(logoSRC.contains("https://www.google.com/gmail/"))
			 {
				 URL imageURL = new URL(logoSRC);
				 BufferedImage saveImage = ImageIO.read(imageURL);
				 appLibrary.sleep(2000);
				 ImageIO.write(saveImage, "png", new File("..//auto-assignTask//Images", "pic" +i+ ".png"));
			 }//if
			}//for

	}
	
}