package com.pdp.oidc.oidc_lab.controller;

import com.pdp.oidc.oidc_lab.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/send-mail")
    public String sendMail(@RequestParam String to, 
                           @RequestParam String subject, 
                           @RequestParam String text) {
        try {
           // mailService.sendSimpleEmail(to, subject, text);
            mailService.sendWelcomeEmail(to,"Parashar" ,"parashar.com");
            return "Mail sent successfully!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while sending mail: " + e.getMessage();
        }
    }
}
