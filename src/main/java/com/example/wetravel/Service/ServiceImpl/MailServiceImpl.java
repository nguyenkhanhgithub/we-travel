package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.DataMailDTO;
import com.example.wetravel.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class MailServiceImpl implements MailService {
    @Autowired
    JavaMailSender getMailSender;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void sendMail(DataMailDTO dataMailDTO, String templateName) throws MessagingException {
        MimeMessage message = getMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

        Context context = new Context();
        context.setVariables(dataMailDTO.getProps());

        String html = templateEngine.process(templateName, context);

        helper.setTo(dataMailDTO.getTo());
        helper.setSubject(dataMailDTO.getSubject());
        helper.setText(html, true);

        getMailSender.send(message);
    }
}
