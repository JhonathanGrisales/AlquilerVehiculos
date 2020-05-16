/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.utilidades;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jhonathan_G
 */
public class EnviarCorreo {
    
    
    
    
     public static final String USER = "jgrisalesg@gmail.com";
    public static final String PASS = "90112250769j";
    public static final String HOST = "localhost";
    public static final String SMTP = "smtp.gmail.com";
    public static final String port = "465";

 public static boolean enviarMail(String remitente, String receptor, String asunto, String mensaje) {

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP);
        props.put("mail.smtp.socketFactory.port", port);
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", port);
  
        Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USER,PASS);
                }
            });
  
        try {
  
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(receptor));
            message.setSubject(asunto);
            message.setText(mensaje);
  
            Transport.send(message);
            
  
            System.out.println("Mensaje enviado a :  " + receptor);
                        return true;
  
        } catch (MessagingException e) {
                    e.printStackTrace();
                        return false;
        }
    }
    
}
