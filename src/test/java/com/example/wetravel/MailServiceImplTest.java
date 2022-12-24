package com.example.wetravel;

import com.example.wetravel.DTO.DataMailDTO;
import com.example.wetravel.Service.ServiceImpl.MailServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.context.IContext;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class MailServiceImplTest {

    private MailServiceImpl mailServiceImplUnderTest;

    @BeforeEach
    void setUp() throws Exception {
        mailServiceImplUnderTest = new MailServiceImpl();
        mailServiceImplUnderTest.getMailSender = mock(JavaMailSender.class);
        mailServiceImplUnderTest.templateEngine = mock(SpringTemplateEngine.class);
    }

    @Test
    void testSendMail() throws Exception {
        // Setup
        final DataMailDTO dataMailDTO = new DataMailDTO("to", "subject", "content", new HashMap<>());

        // Configure JavaMailSender.createMimeMessage(...).
        final MimeMessage mimeMessage = new MimeMessage(Session.getInstance(new Properties()));
        when(mailServiceImplUnderTest.getMailSender.createMimeMessage()).thenReturn(mimeMessage);

        when(mailServiceImplUnderTest.templateEngine.process(eq("templateName"), any(IContext.class)))
                .thenReturn("result");

        // Run the test
        mailServiceImplUnderTest.sendMail(dataMailDTO, "templateName");

        // Verify the results
        verify(mailServiceImplUnderTest.getMailSender).send(any(MimeMessage.class));
    }

    @Test
    void testSendMail_JavaMailSenderSendThrowsMailException() {
        // Setup
        final DataMailDTO dataMailDTO = new DataMailDTO("to", "subject", "content", new HashMap<>());

        // Configure JavaMailSender.createMimeMessage(...).
        final MimeMessage mimeMessage = new MimeMessage(Session.getInstance(new Properties()));
        when(mailServiceImplUnderTest.getMailSender.createMimeMessage()).thenReturn(mimeMessage);

        when(mailServiceImplUnderTest.templateEngine.process(eq("templateName"), any(IContext.class)))
                .thenReturn("result");
        doThrow(MailException.class).when(mailServiceImplUnderTest.getMailSender).send(any(MimeMessage.class));

        // Run the test
        assertThatThrownBy(() -> mailServiceImplUnderTest.sendMail(dataMailDTO, "templateName"))
                .isInstanceOf(MailException.class);
    }
}
