package com.bridgelabz.addressbook.configuration;

import com.bridgelabz.addressbook.utility.EmailSenderService;
import com.bridgelabz.addressbook.utility.JwtToken;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;

@Configuration
public class UserConfiguration {
    @Bean
    public JwtToken jwttoken(){
        return new JwtToken();
    }

    @Bean
    public EmailSenderService emailSenderService()
    {
        return new EmailSenderService();
    }
}