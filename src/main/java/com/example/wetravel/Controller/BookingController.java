package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.RequestCancelBookingDTO;
import com.example.wetravel.DTO.TourListDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class BookingController {
    @Autowired
    BookingService bookingService;

    @GetMapping("get-list-booking/by-account")
    public ResponseEntity<?> getListBooking(@RequestParam(defaultValue = "-1") Long accountId , @RequestParam(defaultValue = "-1") Long tourId ,
                                            @RequestParam(defaultValue = "0000-00-00") String startDate, @RequestParam Integer page , @RequestParam Integer size){
        try{
            Page<UserBookingDTO> result = bookingService.getListBooking(accountId , tourId , startDate , page , size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("booking")
    public ResponseEntity<?> createBooking(@RequestBody UserBookingDTO userBookingDTO){
        try{
            UserBookingDTO result = bookingService.createBooking(userBookingDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("update/status")
    public ResponseEntity<?> updateStatus(@RequestParam Long userBookingId , @RequestParam Integer status){
        try{
            Boolean result = bookingService.updateStatus(userBookingId , status);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("update/status-deposit")
    public ResponseEntity<?> updateStatusDeposit(@RequestParam Long userBookingId , @RequestParam Boolean statusDeposit){
        try{
            Boolean result = bookingService.updateStatusDeposit(userBookingId , statusDeposit);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("request/cancel/booking")
    public ResponseEntity<?> cancelRequestBooking(@RequestBody RequestCancelBookingDTO requestCancelBookingDTO){
        try{
            Boolean result = bookingService.createRequestCancel(requestCancelBookingDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/request/cancel/booking/{requestCancelId}")
    public ResponseEntity<?> deleteRequestCancelBooking(@PathVariable Long requestCancelId){
        try{
            Boolean result = bookingService.deleteRequestCancelBooking(requestCancelId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.DELETE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
