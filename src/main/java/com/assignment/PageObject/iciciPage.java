package com.assignment.PageObject;

import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.assignment.Library.AppLibrary;

public class iciciPage {
	
	public static String searchButton="xpath://a[@id='Campaign1_C017_LnkSearch']";
	public static String searchButtonNew="xpath://a[@id='Campaign1_C019_LnkSearch']";
	public static String tableRow= "xpath://table[@id='HospitalList']/tbody/tr";
	
	public static String beforexpath_hospital="xpath://*[@id='HospitalList']/tbody/tr[";
	public static String afterxpath_hospital="]/td[2]/span";
	
	public static String beforexpath_Address="xpath://*[@id='HospitalList']/tbody/tr[";
	public static String afterxpath_Address="]/td[3]/span";
	
	public static String beforexpath_City="xpath://*[@id='HospitalList']/tbody/tr[";
	public static String afterxpath_City="]/td[4]/span";
	
	public static String beforexpath_State="xpath://*[@id='HospitalList']/tbody/tr[";
	public static String afterxpath_State="]/td[5]/span";
	
	public static String beforexpath_Contact="xpath://*[@id='HospitalList']/tbody/tr[";
	public static String afterxpath_Contact="]/td[6]/span";
	
	public static String stateNameField="xpath://div[@class='state title']";
	public static String cityNameField="xpath://div[@class='city title']";
	
	public static String stateNamelist="xpath://ul[@id='sbOptions_72698161']";
	public static String cityNamelist="xpath://a[@id='sbSelector_23627786']";
		
	Row r;   
	Cell c;
	Sheet s,s1;
		
	private WebDriver driver;
	public AppLibrary appLibrary;

	public iciciPage(AppLibrary appLibrary) {
		this.appLibrary = appLibrary;
		this.driver = appLibrary.getCurrentDriverInstance();
	}
	
	public void getListofHospital() throws Exception {
		appLibrary.waitForPageToLoad();
		appLibrary.findElement(searchButton).click();
	
	List<WebElement> row =	appLibrary.findElements(tableRow);
	 System.out.println(row.size());
	 int rowCount=row.size();    
	 
	 FileInputStream fs = new FileInputStream("..//auto-assignTask/TestData/HospitalList.xlsx");
	 Workbook wb = WorkbookFactory.create(fs);
	  s= wb.getSheet("Sheet1");
	  
	  s.createRow(0).createCell(0).setCellValue("Hospital Name");
	  s.getRow(0).createCell(1).setCellValue("Address");
	  s.getRow(0).createCell(2).setCellValue("City");
	  s.getRow(0).createCell(3).setCellValue("State");
	  s.getRow(0).createCell(4).setCellValue("Contact");

	 for(int i=1;i<rowCount;i++)
		{
			String actualPath_hospital=beforexpath_hospital+i+afterxpath_hospital;
			String hospitalName= appLibrary.findElement(actualPath_hospital).getText();
    		s.createRow(i).createCell(0).setCellValue(hospitalName);
    		
			String actualPath_Address=beforexpath_Address+i+afterxpath_Address;
			String Address= appLibrary.findElement(actualPath_Address).getText();
			s.getRow(i).createCell(1).setCellValue(Address);
		
			String actualPath_City=beforexpath_City+i+afterxpath_City;
			String City= appLibrary.findElement(actualPath_City).getText();
			s.getRow(i).createCell(2).setCellValue(City);
			
			String actualPath_State=beforexpath_State+i+afterxpath_State;
			String State= appLibrary.findElement(actualPath_State).getText();
			s.getRow(i).createCell(3).setCellValue(State);
			
			String actualPath_Contact=beforexpath_Contact+i+afterxpath_Contact;
			String Contact= appLibrary.findElement(actualPath_Contact).getText();
			s.getRow(i).createCell(4).setCellValue(Contact);

	}
	 
	 wb.write(new FileOutputStream("..//auto-assignTask/TestData/HospitalList.xlsx"));
	}
	
	public void getListofHospitalByDiffCity() throws Exception {
		appLibrary.waitForPageToLoad();
		appLibrary.findElement(searchButtonNew).click();
		
	List<WebElement> row =	appLibrary.findElements(tableRow);
	 System.out.println(row.size());
	 int rowCount=row.size();    
	 
	 FileInputStream fs = new FileInputStream("..//auto-assignTask/TestData/HospitalList.xlsx");
	 Workbook wb = WorkbookFactory.create(fs);
	  s1= wb.getSheet("Sheet2");
	  
	  s1.createRow(0).createCell(0).setCellValue("Hospital Name");
	  s1.getRow(0).createCell(1).setCellValue("Address");
	  s1.getRow(0).createCell(2).setCellValue("City");
	  s1.getRow(0).createCell(3).setCellValue("State");
	  s1.getRow(0).createCell(4).setCellValue("Contact");

	 for(int i=1;i<rowCount;i++)
		{
			String actualPath_hospital=beforexpath_hospital+i+afterxpath_hospital;
			String hospitalName= appLibrary.findElement(actualPath_hospital).getText();
    		s1.createRow(i).createCell(0).setCellValue(hospitalName);
    		
			String actualPath_Address=beforexpath_Address+i+afterxpath_Address;
			String Address= appLibrary.findElement(actualPath_Address).getText();
			s1.getRow(i).createCell(1).setCellValue(Address);
		
			String actualPath_City=beforexpath_City+i+afterxpath_City;
			String City= appLibrary.findElement(actualPath_City).getText();
			s1.getRow(i).createCell(2).setCellValue(City);
			
			String actualPath_State=beforexpath_State+i+afterxpath_State;
			String State= appLibrary.findElement(actualPath_State).getText();
			s1.getRow(i).createCell(3).setCellValue(State);
			
			String actualPath_Contact=beforexpath_Contact+i+afterxpath_Contact;
			String Contact= appLibrary.findElement(actualPath_Contact).getText();
			s1.getRow(i).createCell(4).setCellValue(Contact);

	}
	 
	 wb.write(new FileOutputStream("..//auto-assignTask/TestData/HospitalList.xlsx"));
	}
	
	public void getCommonHospital() throws Exception
	{
		 FileInputStream fs = new FileInputStream("..//auto-assignTask/TestData/HospitalList.xlsx");
		 Workbook wb = WorkbookFactory.create(fs);
		 Sheet  sr= wb.getSheet("Sheet1");
		 Sheet sr1=wb.getSheet("Sheet2");
		 Sheet sr2=wb.getSheet("Sheet3");
		 int k=1;
		 
		 sr2.createRow(0).createCell(0).setCellValue("Hospital Name");
		
		 DataFormatter df = new DataFormatter();

		 for (int i = 1; i < sr.getLastRowNum() + 1; i++)
		 {
		     Cell cell = sr.getRow(i).getCell(0);
		     for (int j = 1; j < sr1.getLastRowNum() + 1; j++)
			 {
		    	 Cell cell1 = sr1.getRow(j).getCell(0);
		    	 if (df.formatCellValue(cell).equals(df.formatCellValue(cell1)))
		     		{
		    		 	String commonHospital=cell.getStringCellValue();;
		    		 	sr2.createRow(k).createCell(0).setCellValue(commonHospital);
		    		 	k++;
		     		}	
			 }//for j
		 }// for i
 	 	wb.write(new FileOutputStream("..//auto-assignTask/TestData/HospitalList.xlsx"));
	}//getCommonHospitalMethod
	
	public void sendemail() throws EmailException 
	{
		System.out.println("Start of email sending functionality....");
		
		 //Create Attachment
       EmailAttachment emailAttachment=new EmailAttachment();
       emailAttachment.setPath("E:\\Dr_pepperCodeN_Workspace\\auto-assignTask\\TestData\\HospitalList.xlsx");
       emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
//       emailAttachment.setDescription("TestDoc.txt");
//       emailAttachment.setName("Document");
		
       MultiPartEmail email=new MultiPartEmail();
//		Email email = new SimpleEmail();
//		email.setHostName("smtp.office365.com");
//		email.setHostName("smtp-mail.outlook.com");
//		email.setSmtpPort(587);
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("deepanjali.gaikwad.think@gmail.com", "deepanjali@123"));
//		email.setStartTLSEnabled(true);
		email.setSSLOnConnect(true);
		try {
		    email.setFrom("deepanjali.gaikwad.think@gmail.com");
		    email.setSubject("Email with attachment");
		    email.setDebug(true);
		    email.setMsg("This is a test mail ... :-)" );
//		    email.addTo("dhanesh.bhansali@thinkitive.com");
		    email.addTo("deepanjali.gaikwad@thinkitive.com");
		    email.attach(emailAttachment);
		    email.send();
		} catch (EmailException e) {
		    e.printStackTrace();
		}

		System.out.println("Email sent successfully....");
	}
	
}
	
	
