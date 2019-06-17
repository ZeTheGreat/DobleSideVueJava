package br.gov.sp.fatec.model;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email{
	Properties props = new Properties();
	Session session;
	public Email(String host, String port, String classe, boolean auth, String port2){
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.socketFactory.port", port);
		props.put("mail.smtp.socketFactory.class", classe);
		props.put("mail.smtp.auth", auth);
		props.put("mail.smtp.port", port2);
		this.session = Session.getDefaultInstance(props,
			      new javax.mail.Authenticator() {
			           protected PasswordAuthentication getPasswordAuthentication() 
			           {
			                 return new PasswordAuthentication("flwtheknow@gmail.com", 
			                 "tison123");
			           }
			      });
		
	}
	public void sendEmail(String email, String text, String titulo) {
		this.session.setDebug(true);
		 
	    try {
	 
	      Message message = new MimeMessage(this.session);
	      message.setFrom(new InternetAddress("flwtheknow@gmail.com")); 
	 
	      Address[] toUser = InternetAddress.parse(email);  
	 
	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject(titulo);
	      message.setText(text);
	      Transport.send(message);
	 
	      System.out.println("Feito!!!");
	 
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	  }
	}
