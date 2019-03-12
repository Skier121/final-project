package by.baranov.webproject.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


public class EmailSender {
    private final static Logger log= LogManager.getLogger();
    private final static String USERNAME = "baranovebservice@gmail.com";
    private static String PASSWORD = "Prophesy123";

    public static boolean sendMail(String addressTo, String message) {
        boolean result = false;
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
        props.put("mail.smtp.port", "587"); //TLS Port
        props.put("mail.smtp.auth", "true"); //enable authentication
        props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS

        Authenticator auth = new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        };

        Session session = Session.getDefaultInstance(props, auth);
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
            msg.addHeader("format", "flowed");
            msg.addHeader("Content-Transfer-Encoding", "8bit");
            msg.setFrom(new InternetAddress("no_reply@example.com", "NoReply-JD"));
            msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
            msg.setSubject("Administration of eDiary", "UTF-8");
            msg.setText("Greetengs dear user!!\n" + message, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(addressTo, false));
            Transport.send(msg);
            result=true;
            log.info("EMail Sent Successfully!! Recipient: "+addressTo);
        } catch (Exception e) {
            log.warn("Email sending error", e);
        }
        return result;
    }
}



