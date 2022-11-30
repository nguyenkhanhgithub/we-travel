package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.TourDTO;
import com.example.wetravel.DTO.TourListDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class TourController {
    @Autowired
    TourService tourService;

    @GetMapping("all/tour")
    public ResponseEntity<?> getAllTour(@RequestParam(defaultValue = "all") String tourName , @RequestParam(defaultValue = "-1") List<Integer> tourCategoryList ,
                                        @RequestParam(defaultValue = "-1") Integer status , @RequestParam(defaultValue = "-1") Integer tourType ,
                                        @RequestParam(defaultValue = "-1") Integer fromPrice , @RequestParam(defaultValue = "-1") Integer toPrice ,
                                        @RequestParam Integer page , @RequestParam Integer size){
        try{
            TourListDTO result = tourService.getAllTour(tourName , tourCategoryList , tourType , status , fromPrice , toPrice , page , size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("count/tour")
    public ResponseEntity<?> countTour(@RequestParam(defaultValue = "all") String tourName , @RequestParam(defaultValue = "-1") List<Integer> tourCategoryList ,
                                       @RequestParam(defaultValue = "-1") Integer status , @RequestParam(defaultValue = "-1") Integer tourType ,
                                       @RequestParam(defaultValue = "-1") Integer fromPrice , @RequestParam(defaultValue = "-1") Integer toPrice ){
        try{
            Integer result = tourService.countTour(tourName , tourCategoryList , tourType , status , fromPrice , toPrice);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("detail/tour/{tourId}")
    public ResponseEntity<?> getDetailTour(@PathVariable Long tourId){
        try{
            TourDTO result = tourService.getDetailTour(tourId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/tour")
    public ResponseEntity<?> createTour(@RequestBody TourDTO tourDTO){
        try{
            TourDTO result = tourService.createTour(tourDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("update/tour/{tourId}")
    public ResponseEntity<?> updateTour(@RequestBody TourDTO tourDTO , @PathVariable Long tourId){
        try{
            TourDTO result = tourService.updateTour(tourDTO , tourId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.UPDATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping ("delete/tour/{tourId}")
    public ResponseEntity<?> deleteTour(@PathVariable Long tourId){
        try{
            Boolean result = tourService.deleteTour(tourId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.DELETE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("active/tour/{tourId}")
    public ResponseEntity<?> activeTour(@PathVariable Long tourId){
        try{
            Boolean result = tourService.activeTour(tourId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }
}
