package com.sp.utils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.activation.DataHandler;
import javax.mail.Multipart;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;


public class MailUtil {

	public static void sendMail(String from,String to, String subject, String Body)
	throws UnsupportedEncodingException {
		List<String> toList = new ArrayList<String>();
		toList.add(to);
		sendMail( from, toList,  subject,  Body);
	}

	public static void sendMail(String from, List<String> toList, String subject, String Body)
			throws UnsupportedEncodingException {
		try {
			Message msg = SimpleMailMessage( from, toList,  subject,  Body) ;
			Transport.send(msg);

		} catch (AddressException e) {
			// ...
		} catch (MessagingException e) {
			// ...
		}
	}

	public static void sendMailWithAttachment(String from, List<String> toList, String subject,  String attchedfilename, String Body,byte[] attachmentData, String attachmenttype) throws MessagingException
	{
	
		Message message = SimpleMailMessage( from, toList,  subject,  Body) ;

		//add attachments
        Multipart mp = new MimeMultipart();
        MimeBodyPart attachment = new MimeBodyPart();
        attachment.setFileName(attchedfilename);
        attachment.setContent(attachmentData, attachmenttype);
        mp.addBodyPart(attachment);

        message.setContent(mp);
        Transport.send(message);
	}
	
	public static boolean isValidEmailAddress(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}
	

	private static MimeMessage SimpleMailMessage(String from, List<String> toList, String subject, String Body) throws MessagingException{
		Properties props = new Properties();
		Session session = Session.getDefaultInstance(props, null);
		Message msg = new MimeMessage(session);
		
		InternetAddress fromaddr = new InternetAddress(from);
		msg.setFrom(fromaddr);
		for(String to :toList )
		{
			InternetAddress toaddr = new InternetAddress(to);
			msg.addRecipient(Message.RecipientType.TO, toaddr);
		}
		msg.setSubject(subject);
		msg.setText(Body);
		
		return (MimeMessage) msg;
	}
	
	

}
