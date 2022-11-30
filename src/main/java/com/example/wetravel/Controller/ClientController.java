package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.LoginResponse;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody Login loginRequest) throws HandlerException {
        try {
            Login login = new Login(loginRequest.getEmail(), loginRequest.getPassword());
            LoginResponse loginResponse = clientService.login(login);
            return new ResponseEntity<>(new BaseResponse(200 , loginResponse , "Login success!") , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/verify")
    public ResponseEntity<?> verifyMail(@RequestParam String email , @RequestParam Integer roleId , @RequestParam(defaultValue = "-1") Integer serviceCategoryId){
        try{
            String result = clientService.createMailInfor(email , roleId , serviceCategoryId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SEND_MAIL_SUCCESS) , HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , false , e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("send/mail/forgot-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email){
        try{
            String result = clientService.createMailForgotPassword(email);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SEND_MAIL_SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("forgot/password")
    public ResponseEntity<?> forgotPassword(@RequestParam String token , @RequestParam String newPassword){
        try{
            Boolean result = clientService.forgotPassword(token , newPassword);
            return new ResponseEntity<>(new BaseResponse(200 , result , "Reset Password Success!") , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("change/password")
    public ResponseEntity<?> activeAccount(@RequestParam String email , @RequestParam String oldPassword , @RequestParam String newPassword){
        try{
            Boolean result = clientService.changePassword(email , oldPassword , newPassword);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CHANGE_PASSWORD) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
