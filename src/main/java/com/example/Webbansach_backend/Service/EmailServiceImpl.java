package com.example.Webbansach_backend.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{


    private JavaMailSender javaMailSender ;
    @Autowired
    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void SendMessage(String from, String to, String Subject, String text) {
        // MimeMailMessage => có đính kèm media
        // SimpleMailMessage => nội dung thông thường
        MimeMessage message =javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(Subject);
            helper.setText(text,true);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        // thực hiện hành động gửi email
        javaMailSender.send(message);

    }
}
