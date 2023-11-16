package FeastFast.ApplicationCore;

import javax.mail.*;
import javax.mail.internet.*;

import java.util.Properties;

public class EmailService {

    private String username;
    private String password;

    private final Properties prop;
    
    public EmailService(String host, int port, String username, String password) {
            prop = new Properties();
            prop.put("mail.smtp.auth", true);
            prop.put("mail.smtp.starttls.enable", "true");
            prop.put("mail.smtp.host", host);
            prop.put("mail.smtp.port", port);
            prop.put("mail.smtp.ssl.trust", host);
    
            this.username = username;
            this.password = password;
        }
    
    public void sendMail(String from,String to,String subject, String msg) throws Exception {
    
        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject(subject);
    
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
    
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
    
        message.setContent(multipart);
    
        Transport.send(message);
    }
}