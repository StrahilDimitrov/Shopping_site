package com.example.shopping.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Map;

@Service
public class EmailService {
    private final JavaMailSender emailSender;
    @Value("${spring.mail.username}")
    private String fromEmail;

    @Value("${spring.mail.verify.host}")
    private String host;

    private final TemplateEngine templateEngine;

    public EmailService(JavaMailSender emailSender, TemplateEngine templateEngine) {
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
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

    @Async
    public void sendAccountValidationEmail(String name, String to, String token) {
        try {
            Context context = new Context();
            context.setVariables(Map.of("name", name, "url", host + "/auth/verify?token=" + token));

            String text = templateEngine.process("accountValidationEmail", context);

            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setSubject("New User account verification.");
            helper.setFrom(fromEmail);
            helper.setTo(to);
            helper.setText(text, true);

            emailSender.send(message);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private String getEmailText(String name, String token) {
        return "Hello " + name + "\n\nTo change your password please click the link below. \n\n" + host + "/auth/changePassword?token=" + token;
    }
}
