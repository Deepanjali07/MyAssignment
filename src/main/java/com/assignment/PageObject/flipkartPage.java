package com.assignment.PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assignment.Library.AppLibrary;

public class flipkartPage {
	
	private WebDriver driver;
	public AppLibrary appLibrary;

	public flipkartPage(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();

	}
	public static String clsoe="xpath://button[@class='_2AkmmA _29YdH8']";
	public static String searchbox="xpath://input[@class='LM6RPg']";
	public static String searchIcon="xpath://button[@class='vh79eN']";
	public static String allBooksTitle="xpath://a[@class='_2cLu-l']";
	public static String allBooksAuthor="xpath://div[@class='_1rcHFq']";
	public static String allBooksRatings="xpath://div[@class='_3O0U0u']//div[@class='hGSR34']";
	public static String allBooksOfferPrice="xpath://div[@class='_1vC4OE']";
//	public static String allBooksOrigitnalPrice="xpath://div[@class='_3auQ3N']";
	
	public void searchBook() throws Exception
	{
		appLibrary.waitForPageToLoad();
		appLibrary.findElement(clsoe).click();
		appLibrary.enterText(searchbox, "Science Book");
		appLibrary.findElement(searchIcon).click();
		
		List<WebElement> ListTitles = appLibrary.findElements(allBooksTitle);
		List<WebElement> ListAuthor = appLibrary.findElements(allBooksAuthor);
		List<WebElement> ListRatings = appLibrary.findElements(allBooksRatings);
		List<WebElement> ListOfferPrice = appLibrary.findElements(allBooksOfferPrice);
//		List<WebElement> ListOriginialPrice = appLibrary.findElements(allBooksOrigitnalPrice);
		
		List<String> all_Title = new ArrayList<>();
		List<String> all_Author = new ArrayList<>();
		List<String> all_Ratings = new ArrayList<>();
		List<String> all_OfferPrice = new ArrayList<>();
		List<String> all_OriginialPrice = new ArrayList<>();
		// Storing title, description and skills
		for (int i = 0; i < ListTitles.size(); i++) {
			
			all_Title.add(ListTitles.get(i).getText());
			all_Author.add(ListAuthor.get(i).getText());
			all_Ratings.add(ListRatings.get(i).getText());
			all_OfferPrice.add(ListOfferPrice.get(i).getText());
//			all_OriginialPrice.add(ListOriginialPrice.get(i).getText());
		}
		
		System.out.println(all_Title);
		System.out.println(all_Author);
		System.out.println(all_Ratings);
		System.out.println(all_OfferPrice);
//		System.out.println(all_OriginialPrice);	
		
	}


	
	
}
