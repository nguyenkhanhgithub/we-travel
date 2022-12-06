package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.AlertDTO;
import com.example.wetravel.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class AlertController {
    @Autowired
    AlertService alertService;

    @PostMapping("create/alert")
    public ResponseEntity<?> createAlert(@RequestBody AlertDTO alertDTO){
        try {
            AlertDTO result =  alertService.createAlert(alertDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("get-list-alert")
    public ResponseEntity<?> getListAlertByAccountId(@RequestParam Long accountId){
        try {
            List<AlertDTO> result =  alertService.getListAlertByAccountId(accountId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("seen/alert/{alertId}")
    public ResponseEntity<?> changeStatusAlert(@PathVariable Long alertId){
        try {
            Boolean result =  alertService.seenAlert(alertId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
