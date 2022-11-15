package com.example.wetravel.Service;

public interface ClientService {
    Boolean createMailInfor(String email , Integer roleId , Integer serviceCategoryId);
    Boolean createMailForgotPassword(String email);
}
