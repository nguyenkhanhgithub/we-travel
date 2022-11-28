package com.example.wetravel.Service;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.Exception.HandlerException;

public interface FeedbackService {
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) throws HandlerException;
}
