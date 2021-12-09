package ar.edu.unlam.tallerweb1.utils;

import ar.edu.unlam.tallerweb1.controladores.DatosContacto;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTP {
    // Sender's email ID needs to be mentioned
    static String FROM = "facultadCuenta2021@gmail.com";
    // Assuming you are sending email from through gmails smtp
    static String HOST = "smtp.gmail.com";
    // Get system properties
    static Properties PROPERTIES = System.getProperties();

    static {
        // Setup mail server
        PROPERTIES.put("mail.smtp.host", HOST);
        PROPERTIES.put("mail.smtp.port", "465");
        PROPERTIES.put("mail.smtp.ssl.enable", "true");
        PROPERTIES.put("mail.smtp.auth", "true");
    }

    public static void sendMail(DatosContacto contacto) throws Exception {
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(PROPERTIES, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, "facultad1234");
            }
        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(contacto.getEmail()));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(FROM));

            // Set Subject: header field
            message.setSubject(contacto.getSubject());


            // Now set the actual message
            message.setText(contacto.getEmail() + " se quiere comunicar con usted con el siguiente mensaje: " + contacto.getMessage());

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
