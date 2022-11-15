package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
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

    @PostMapping(value = "/verify")
    public ResponseEntity<?> verifyMail(@RequestParam String email , @RequestParam Integer roleId , @RequestParam(defaultValue = "-1") Integer serviceCategoryId){
        try{
            Boolean result = clientService.createMailInfor(email , roleId , serviceCategoryId);
            if(result.equals(true)){
                return new ResponseEntity<>(new BaseResponse(200 , true , "Send mail success!") , HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new BaseResponse(400 , null , "Email Exist!") , HttpStatus.BAD_REQUEST);
            }

        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , false , e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("reset/password")
    public ResponseEntity<?> resetPassword(@RequestParam String email){
        try{
            Boolean result = clientService.createMailForgotPassword(email);
            if(result.equals(true)){
                return new ResponseEntity<>(new BaseResponse(200 , true , "Send mail success!") , HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new BaseResponse(400 , null , "Email Not Exist!") , HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
