package com.example.wetravel.Service;

import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.LoginResponse;
import com.example.wetravel.Exception.HandlerException;

public interface ClientService {
    LoginResponse login(Login login) throws HandlerException;
    String createMailInfor(String email , Integer roleId , Integer serviceCategoryId) throws HandlerException;

    String createMailForgotPassword(String email) throws HandlerException;

    Boolean forgotPassword(String token ,String password) throws HandlerException;

    Boolean changePassword(String email , String oldPassword , String newPassword) throws HandlerException;
}
