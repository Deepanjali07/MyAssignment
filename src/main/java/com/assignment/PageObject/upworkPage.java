package com.assignment.PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.assignment.Library.AppLibrary;

public class upworkPage {

	private WebDriver driver;
	public AppLibrary appLibrary;

	public static String searchField = "xpath://div[@class='navbar-collapse d-none d-lg-flex sticky-sublocation']//input[@class='form-control']";
	public static String searchIcon = "xpath://div[@class='navbar-collapse d-none d-lg-flex sticky-sublocation']//span[@class='glyphicon air-icon-search m-sm-left m-0-right']";
	public static String title = "xpath://div[@class='ellipsis freelancer-tile-title_compact d-none d-md-block']";
	public static String Description = "xpath://p[@data-qa='tile_description']";
	public static String skills = "xpath://div[@class=' skills-section']";
	public static String name = "xpath://a[@class='freelancer-tile-name']";
	public static String profileName = "xpath://section[@class='up-card-section py-30']//h1[@itemprop='name']";
	public static String profileTitle = "xpath://h2[@class='mb-0 font-weight-black']";
	public static String profileDesc = "xpath://div[@class='up-line-clamp']//span[@class='text-pre-line break']";
	public static String profileSkill = "xpath://a[@class='up-skill-badge']";
	public static String firstPageRandomName = "xpath://a[@class='freelancer-tile-name']";
	
//	String keyword="QA";


	public upworkPage(AppLibrary appLibrary) throws IOException {
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();
	}
	
	public void searchFreeLancers(String keyword) throws Exception {
		
		appLibrary.enterText(searchField, keyword);
		appLibrary.findElement(searchIcon).click();
		
		List<WebElement> ListTitles = appLibrary.findElements(title);
		List<WebElement> ListDescription = appLibrary.findElements(Description);
		List<WebElement> ListSkills = appLibrary.findElements(skills);
		List<WebElement> FreelancerName = appLibrary.findElements(name);
		List<String> all_Title = new ArrayList<>();
		List<String> all_Description = new ArrayList<>();
		List<String> all_Skill = new ArrayList<>();
		List<String> all_name = new ArrayList<>();
		// Storing title, description and skills
		for (int i = 0; i < ListTitles.size(); i++) {
			all_Title.add(ListTitles.get(i).getText());
			all_Description.add(ListDescription.get(i).getText());
			all_Skill.add(ListSkills.get(i).getText());
			all_name.add(FreelancerName.get(i).getText());
		}

		searchKeyword(all_Title, all_Description, all_Skill, all_name, keyword);
		clickONRandomName();
		verifyRandomDataWithStored(all_Title, all_Description, all_Skill, all_name, keyword);
	}

	public void clickONRandomName() {
		List<WebElement> ListRandomNames = appLibrary.findElements(firstPageRandomName);
		Random rn = new Random();
		int ran = 0;
		for (int i = 0; i < ListRandomNames.size(); i++) {
			ran = rn.nextInt(10) + 1;
		}
		ListRandomNames.get(ran).click();
	}

	public void searchKeyword(List<String> all_Title, List<String> all_Description,List<String> all_Skill, List<String> all_name, String keyword) {
		System.out.println("List of freelancers in which keyword is found :");
		// Checking keyword in each attribute
		for (int i = 0; i < all_Title.size(); i++) {
			String t = all_Title.get(i);
			String d = all_Description.get(i);
			String s = all_Skill.get(i);
			String Name = all_name.get(i);
			System.out.println("\n" + Name);
			if (t.contains(keyword)) {
				System.out.println("Title");
			}
			if (d.contains(keyword)) {
				System.out.println("Description");
			}
			if (s.contains(keyword)) {
				System.out.println("Skill");
			}
		}
	}

	public void verifyRandomDataWithStored(List<String> all_Title, List<String> all_Description,List<String> all_Skill, List<String> all_name, String keyword) {
		String pName = appLibrary.findElement(profileName).getText();
		String pTitle = appLibrary.findElement(profileTitle).getText();
		String pDes = appLibrary.findElement(profileDesc).getText();
		String pDes1 = pDes.replace("\n", "").replaceAll("\\s+", "");

		List<WebElement> ListRandomSkills = appLibrary.findElements(profileSkill);
		ArrayList<String> all_pSkills = new ArrayList<String>();
		for (WebElement ele : ListRandomSkills) {
			all_pSkills.add(ele.getText());
		}
		String RandomSkill = String.join(" ", all_pSkills);

		for (int j = 0; j < all_name.size(); j++) {
			if (all_name.get(j).equals(pName)) {
				System.out.println("Random Name " + pName + " found at " + j + " position");

				if (all_Title.get(j).equals(pTitle)) {
					System.out.println("Title : " + pTitle);
				}

				String t = all_Description.get(j).replaceAll("\\s+", "").replace("...", "");
				String skills = all_Skill.get(j).replaceAll("\\s+", "").replace("more", "").replaceAll("[0-9]",
						"");
				String RS = RandomSkill.replaceAll("\\s+", "");

				if (pDes1.contains(t)) {
					System.out.println("Description : " + pDes);
				}
				appLibrary.sleep(2000);
				if (RS.contains(skills)) {
					System.out.println("Skills : " + all_pSkills);
				}
			}

		}
		System.out.println("Finding keyword in Attributes of Random Record");

		if (pTitle.contains(keyword)) {
			System.out.println("Keyword found in Title: " + pTitle);
		}
		if (pDes.contains(keyword)) {
			System.out.println("Keyword found in Description: " + pDes);
		}

		for (int i = 0; i < all_pSkills.size(); i++) {
			if (all_pSkills.get(i).contains(keyword)) {
				System.out.println("Keyword found in Skills: " + all_pSkills.get(i));
			}
		}
	}
}