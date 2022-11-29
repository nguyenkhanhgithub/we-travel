package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    UserBookingRepository userBookingRepository;

    @Autowired
    ReportFeedbackRepository reportFeedbackRepository;

    @Autowired
    ReasonReportFeedbackRepository reasonReportFeedbackRepository;

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) throws HandlerException {
        Feedback feedback = new Feedback();
        Account account = accountRepository.getById(feedbackDTO.getAccountId());
        feedback.setAccountId(account);
        Tour tour = tourRepository.getById(feedbackDTO.getTourId());
        feedback.setTourId(tour);
        UserBooking userBooking = userBookingRepository.getById(feedbackDTO.getUserbookingId());
        userBooking.setIsFeedback(true);
        userBookingRepository.save(userBooking);
        feedback.setUserBookingId(userBooking);
        LocalDate now = LocalDate.now();
        feedback.setCreateDate(now);
        feedback.setContent(feedbackDTO.getContent());
        feedback.setIsBlock(feedbackDTO.getIsBlock());
        feedbackRepository.save(feedback);
        feedbackDTO.setCreateDate(now);
        return feedbackDTO;
    }

    @Override
    public ReportFeedbackDTO createReportFeedback(ReportFeedbackDTO reportFeedbackDTO) throws HandlerException {
        ReportFeedback reportFeedback = new ReportFeedback();
        Feedback feedback = feedbackRepository.getById(reportFeedbackDTO.getFeedbackId());
        reportFeedback.setFeedbackId(feedback);
        ReasonReportFeedback reasonReportFeedback = reasonReportFeedbackRepository.getById(reportFeedbackDTO.getReasonReportFeedbackId());
        reportFeedback.setReasonReportFeedbackId(reasonReportFeedback);
        Account account = accountRepository.getById(reportFeedbackDTO.getAccountId());
        reportFeedback.setAccountId(account);
        reportFeedback.setDescription(reportFeedbackDTO.getDescription());
        return reportFeedbackDTO;
    }

    @Override
    public Boolean blockFeedback(Long feedbackId) throws HandlerException {
        if(!feedbackRepository.existsFeedbackByFeedbackId(feedbackId)){
            throw new HandlerException("Feedback not found!");
        }
        Feedback feedback = feedbackRepository.getById(feedbackId);
        feedback.setIsBlock(true);
        feedbackRepository.save(feedback);
        return true;
    }
}
