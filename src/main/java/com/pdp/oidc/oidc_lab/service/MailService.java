package com.pdp.oidc.oidc_lab.service;

import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class MailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        message.setFrom("your-email@gmail.com"); // Optional: set a default 'from' address
        mailSender.send(message);
    }

    public void sendWelcomeEmail(String to, String name, String website) throws Exception {
        // Load the HTML template
        String templatePath = "src/main/resources/templates/welcome-email.html";
        String htmlContent = new String(Files.readAllBytes(Paths.get(templatePath)));

        // Replace placeholders with actual values
        htmlContent = htmlContent.replace("{{name}}", name);
        htmlContent = htmlContent.replace("{{website}}", website);

        // Send email
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setTo(to);
        helper.setSubject("Welcome to HSBC!");
        helper.setText(htmlContent, true); // true for HTML content
        helper.setFrom("admin@hsbctest.com");
        mailSender.send(mimeMessage);
    }
}
