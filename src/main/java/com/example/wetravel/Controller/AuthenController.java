package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.LoginResponse;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class AuthenController {

    @Autowired
    AuthService authService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Login loginRequest) throws HandlerException{
        try {
            Login login = new Login(loginRequest.getEmail(), loginRequest.getPassword());
            LoginResponse loginResponse = authService.login(login);
            if(loginResponse != null){
                return new ResponseEntity<>(new BaseResponse(200 , loginResponse , "Login success!") , HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new BaseResponse(400 , null , "Wrong email or password!") , HttpStatus.BAD_REQUEST);
            }
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
