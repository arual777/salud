package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.controladores.DatosAsistencia;
import ar.edu.unlam.tallerweb1.controladores.DatosPostulacion;
import ar.edu.unlam.tallerweb1.modelo.*;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioAsistencia;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPerfilProfesional;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPostulacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.transaction.Transactional;
import java.util.List;


@Service("servicioMail")
@Transactional
public class ServicioMailImpl implements ServicioMail{

    private RepositorioAsistencia repositorioAsistencia;
    private RepositorioUsuario repositorioUsuario;
    private RepositorioPostulacion repositorioPostulacion;
    private RepositorioPerfilProfesional repositorioPerfilProfesional;

    @Autowired
    public ServicioMailImpl(RepositorioAsistencia repositorioAsistencia, RepositorioUsuario repositorioUsuario, RepositorioPostulacion repositorioPostulacion, RepositorioPerfilProfesional repositorioPerfilProfesional){
        this.repositorioAsistencia = repositorioAsistencia;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioPostulacion = repositorioPostulacion;
        this.repositorioPerfilProfesional = repositorioPerfilProfesional;
    }

    @Override
    public void SendMail() throws Exception {

        // Sender's email ID needs to be mentioned
        String from = "julietaldelfino@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication("fromaddress@gmail.com", "*******");

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }

}

