package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.BookingMonthDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class DashboardController {
    @Autowired
    DashboardService dashboardService;

    @GetMapping("calculate/booking-month")
    public ResponseEntity<?> calculateBookingMonth() throws HandlerException {
        try {
            BookingMonthDTO result = dashboardService.calculateBookingMonth();
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("calculate/booking-by-booking-date")
    public ResponseEntity<?> calculateBookingByBookingDate(@RequestParam String monthYear , @RequestParam Integer numberOfMonth) throws HandlerException {
        try {
            List<BookingMonthDTO> result = dashboardService.calculateBookingByBookingDate(monthYear , numberOfMonth);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("calculate/booking-by-start-date")
    public ResponseEntity<?> calculateBookingByStartDate(@RequestParam String monthYear , @RequestParam Integer numberOfMonth) throws HandlerException {
        try {
            List<BookingMonthDTO> result = dashboardService.calculateBookingByStartDate(monthYear , numberOfMonth);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
