package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.*;
import com.example.wetravel.Service.AccountService;
import com.example.wetravel.Service.PartnerService;
import com.example.wetravel.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class AccountController {
    @Autowired
    AccountService accountService;

    @Autowired
    PartnerService partnerService;

    @Autowired
    UserService userService;

    @PostMapping("register/customer")
    public ResponseEntity<?> registerAccountCustomer(@RequestBody CustomerRegisterDTO customerRegisterDTO){
        try {
            Boolean result =  accountService.registerCustomerAccount(customerRegisterDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("register/partner")
    public ResponseEntity<?> registerAccountPartner(@RequestBody PartnerRegisterDTO partnerRegisterDTO){
        try{
            Boolean result = accountService.registerPartnerAccount(partnerRegisterDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result ,  Constant.Message.CREATE_SUCCESS ) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("edit/profile/customer/{accountId}")
    public ResponseEntity<?> editProfileCustomer(@PathVariable Long accountId , @RequestBody CustomerRegisterDTO customerRegisterDTO){
        try{
            Boolean result = accountService.editProfileCustomer(accountId , customerRegisterDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result ,  Constant.Message.UPDATE_SUCCESS ) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("edit/profile/partner/{accountId}")
    public ResponseEntity<?> editProfilePartner(@PathVariable Long accountId , @RequestBody PartnerRegisterDTO partnerRegisterDTO){
        try{
            Boolean result = accountService.editProfilePartner(accountId , partnerRegisterDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result ,  Constant.Message.UPDATE_SUCCESS ) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/list-partner")
    public ResponseEntity<?> getListPartner(@RequestParam(defaultValue = "all") String emailPartner,
                                            @RequestParam(defaultValue = "-1") Integer serviceCategoryId ,
                                            @RequestParam(defaultValue = "-1") Integer isBlock ,
                                            @RequestParam Integer page , @RequestParam Integer size){
        try{
            Page<PartnerDTO> result = partnerService.getListPartner(emailPartner ,serviceCategoryId ,isBlock ,page , size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/detail/partner/{accountId}")
    public ResponseEntity<?> getDetailPartner(@PathVariable Long accountId){
        try{
            PartnerDTO result = partnerService.getDetailPartner(accountId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/list-user")
    public ResponseEntity<?> getListUser(@RequestParam Integer page , @RequestParam Integer size){
        try{
            Page<UserDTO> result = userService.getListUser(page , size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get/detail/user/{accountId}")
    public ResponseEntity<?> getDetailUser(@PathVariable Long accountId){
        try{
            UserDTO result = userService.getDetailUser(accountId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("block/account/{accountId}")
    public ResponseEntity<?> blockAccount(@PathVariable Long accountId){
        try{
            Boolean result = accountService.blockAccount(accountId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("active/account/{accountId}")
    public ResponseEntity<?> activeAccount(@PathVariable Long accountId){
        try{
            Boolean result = accountService.activeAccount(accountId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
