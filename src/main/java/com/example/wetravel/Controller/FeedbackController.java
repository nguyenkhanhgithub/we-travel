package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Entity.ReportFeedback;
import com.example.wetravel.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PostMapping(value = "/create/feedback")
    public ResponseEntity<?> createFeedback(@RequestBody FeedbackDTO feedbackDTO){
        try{
            FeedbackDTO result = feedbackService.createFeedback(feedbackDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , false , e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(value = "/create/report/feedback")
    public ResponseEntity<?> createReportFeedback(@RequestBody ReportFeedbackDTO reportFeedbackDTO){
        try{
            ReportFeedbackDTO result = feedbackService.createReportFeedback(reportFeedbackDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , false , e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/block/feedback/{feedbackId}")
    public ResponseEntity<?> blockFeedback(@PathVariable Long feedbackId){
        try{
            Boolean result = feedbackService.blockFeedback(feedbackId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(new BaseResponse(400 , false , e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
