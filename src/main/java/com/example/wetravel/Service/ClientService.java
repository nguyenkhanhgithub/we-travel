package com.example.wetravel.Service;

import com.example.wetravel.Exception.HandlerException;

public interface ClientService {
    String createMailInfor(String email , Integer roleId , Integer serviceCategoryId) throws HandlerException;
    String createMailForgotPassword(String email) throws HandlerException;
}
