package com.sp.fanikiwa;

import java.io.IOException; 
import java.io.UnsupportedEncodingException;
import java.util.Properties; 

import javax.mail.MessagingException;
import javax.mail.Session; 
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage; 
import javax.servlet.http.*; 

import com.google.api.server.spi.response.ConflictException;
import com.google.api.server.spi.response.NotFoundException;
import com.sp.fanikiwa.api.InformdbEndpoint;
import com.sp.fanikiwa.entity.Informdb;

public class MailHandlerServlet extends HttpServlet { 
    @Override
    public void doPost(HttpServletRequest req, 
                       HttpServletResponse resp) 
            throws IOException { 
        Properties props = new Properties(); 
        Session session = Session.getDefaultInstance(props, null); 
        try {
			MimeMessage message = new MimeMessage(session, req.getInputStream());
			        //save the mail
			Informdb mail = new Informdb();
			mail.setAddressFrom(message.getSender().toString());
			mail.setSubject(message.getSubject());
			mail.setBody(message.toString());
			mail.setMessageDate(message.getReceivedDate());
			mail.setStatus("New");
			
			InformdbEndpoint idep = new InformdbEndpoint();
			idep.insertInformdb(mail);

    } catch (AddressException e) {
        e.printStackTrace();
    } catch (MessagingException e) {
        e.printStackTrace();
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
    } catch (NotFoundException e) { 
		e.printStackTrace();
	} catch (ConflictException e) { 
		e.printStackTrace();
	}
    }
     
    
    
}