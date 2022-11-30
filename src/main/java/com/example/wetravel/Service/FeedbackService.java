package com.example.wetravel.Service;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

public interface FeedbackService {
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) throws HandlerException;

    ReportFeedbackDTO createReportFeedback(ReportFeedbackDTO reportFeedbackDTO) throws HandlerException;

    Boolean blockFeedback(Long feedbackId) throws HandlerException;

    Page<FeedbackDTO> getListFeedbackByTourId(Long tourId , Integer page , Integer size) throws HandlerException;
}
