package com.assignment.Task;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;

public class testEmail {
	
		public static void main(String[] args) {
			System.out.println("Start of email sending functionality....");
			
			 //Create Attachment
	        EmailAttachment emailAttachment=new EmailAttachment();
	        emailAttachment.setPath("E:\\Dr_pepperCodeN_Workspace\\auto-assignTask\\Test-Data\\HospitalList.xlsx");
	        emailAttachment.setDisposition(EmailAttachment.ATTACHMENT);
//	        emailAttachment.setDescription("TestDoc.txt");
//	        emailAttachment.setName("Document");
			
	        MultiPartEmail email=new MultiPartEmail();
//			Email email = new SimpleEmail();
//			email.setHostName("smtp.office365.com");
//			email.setHostName("smtp-mail.outlook.com");
//			email.setSmtpPort(587);
			email.setHostName("smtp.gmail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("deepanjali.gaikwad.think@gmail.com", "deepanjali@123"));
//			email.setStartTLSEnabled(true);
			email.setSSLOnConnect(true);
			try {
			    email.setFrom("deepanjali.gaikwad.think@gmail.com");
			    email.setSubject("Email with attachment");
			    email.setDebug(true);
			    email.setMsg("This is a test mail ... :-)" );
			    email.addTo("dhanesh.bhansali@thinkitive.com");
			    email.attach(emailAttachment);
			    email.send();
			} catch (EmailException e) {
			    e.printStackTrace();
			}

			System.out.println("Email sent successfully....");
		}

}
