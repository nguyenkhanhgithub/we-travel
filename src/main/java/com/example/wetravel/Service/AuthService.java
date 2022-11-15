package com.example.wetravel.Service;

import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.LoginResponse;
import com.example.wetravel.Exception.HandlerException;


public interface AuthService {
    LoginResponse login(Login login) throws HandlerException;
}
