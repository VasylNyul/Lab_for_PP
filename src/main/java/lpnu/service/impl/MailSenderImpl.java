package lpnu.service.impl;

import lpnu.service.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderImpl implements MailSender {

    @Autowired
    public JavaMailSender emailSender;


    @Override
    public void send(final String toAddress, final String subject, final String message) {

        final SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("vasyl.nul@gmail.com");
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }

}
