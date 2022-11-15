package com.example.wetravel.Service;

import com.example.wetravel.DTO.DataMailDTO;

import javax.mail.MessagingException;

public interface MailService {
    void sendMail(DataMailDTO dataMailDTO , String templateName) throws MessagingException;
}
