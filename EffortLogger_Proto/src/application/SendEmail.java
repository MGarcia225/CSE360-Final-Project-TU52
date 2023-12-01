// Java program to send email 
package application;

import java.io.UnsupportedEncodingException;
import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
  
public class SendEmail  
{ 
   private static String senderEmail = "effortloggermessaging@gmail.com"; 
   private static String senderEmailPassword = "wreb ozzq wndc nfpu";
   
   private static String gmailHostIP = "smtp.gmail.com";
   private static String gmailHostPort = "465";
   
   private static HashMap<String, String> carriers = new HashMap<String, String>();
   
   static {
	   carriers.put("AT&T", "@txt.att.net");
	   carriers.put("T-Mobile", "@tmomail.net");
	   carriers.put("Verizon", "@vtext.com");
	   carriers.put("Sprint", "@messaging.sprintpcs.com");
	   carriers.put("Xfinity Mobile", "@vtext.com");
	   carriers.put("Virgin Mobile", "vmobl.com");
	   carriers.put("Simple Mobile", "@smtext.com");
	   carriers.put("Mint Mobile", "@mailmymobile.net");
	   carriers.put("Red Pocket", "@vtext.com");
	   carriers.put("Metro PCS", "@mymetropcs.com");
	   carriers.put("Boost Mobile", "@sms.myboostmobile.com");
	   carriers.put("Cricket", "@sms.cricketwireless.net");
   }
  
   public static void send(Phone phoneData, String subject, String msg)  
   {         
	  // Check Carrier of Phone Number
	  String recipientCarrier = phoneData.getCarrier();
	  String phoneNumber = phoneData.getPhoneNumber();
	  String carrierEmail = carriers.get(recipientCarrier);
	  String recipientSMSEmail = phoneNumber + carrierEmail;
	  
	  String recipientEmail = recipientSMSEmail;
	  
      // Getting system properties 
      Properties properties = System.getProperties(); 
  
      // Setting up mail server 
      properties.put("mail.smtp.host", gmailHostIP); 
      properties.put("mail.smtp.port", gmailHostPort); 
      properties.put("mail.smtp.ssl.enable", "true"); 
      properties.put("mail.smtp.auth", "true"); 
  
   // Get the Session object.// and pass username and password
      Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

          protected PasswordAuthentication getPasswordAuthentication() {

              return new PasswordAuthentication(senderEmail, senderEmailPassword);

          }

      });
      
      // Used to debug SMTP issues
      session.setDebug(true);
  
      try {
          // Create a default MimeMessage object.
          MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(senderEmail, "Effort Logger"));

          // Set To: header field of the header.
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

          // Set Subject: header field
          message.setSubject(subject);

          // Now set the actual message
          message.setText(msg);

          //System.out.println("sending...");
          // Send message
          Transport.send(message);
          //System.out.println("Sent message successfully....");
      } catch (MessagingException | UnsupportedEncodingException mex) {
          mex.printStackTrace();
      }
   } 
} 