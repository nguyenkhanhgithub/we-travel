package com.example.wetravel.Service;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Exception.HandlerException;

public interface FeedbackService {
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) throws HandlerException;

    ReportFeedbackDTO createReportFeedback(ReportFeedbackDTO reportFeedbackDTO) throws HandlerException;

    Boolean blockFeedback(Long feedbackId) throws HandlerException;
}
