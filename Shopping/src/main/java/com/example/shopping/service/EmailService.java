package com.example.shopping.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${spring.mail.verify.host}")
    private String host;

    public EmailService(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Async
    public void sendConfirmationEmail(String name, String to, String token) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setSubject("Changing password confirmation");
            message.setFrom(fromEmail);
            message.setTo(to);
            message.setText(getEmailText(name, token));

            emailSender.send(message);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String getEmailText(String name, String token) {
        return "Hello " + name + "\n\nTo change your password please click the link below. \n\n" + host + "/auth/changePassword?token=" + token;
    }
}
