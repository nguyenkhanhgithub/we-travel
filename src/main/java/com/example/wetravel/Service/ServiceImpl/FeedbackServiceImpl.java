package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.Feedback;
import com.example.wetravel.Entity.Tour;
import com.example.wetravel.Entity.UserBooking;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.FeedbackRepository;
import com.example.wetravel.Repository.TourRepository;
import com.example.wetravel.Repository.UserBookingRepository;
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

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) throws HandlerException {
        Feedback feedback = new Feedback();
        Account account = accountRepository.getById(feedbackDTO.getAccountId());
        feedback.setAccountId(account);
        Tour tour = tourRepository.getById(feedbackDTO.getTourId());
        feedback.setTourId(tour);
        UserBooking userBooking = userBookingRepository.getById(feedbackDTO.getUserbookingId());
        feedback.setUserBookingId(userBooking);
        LocalDate now = LocalDate.now();
        feedback.setCreateDate(now);
        feedback.setContent(feedbackDTO.getContent());
        feedback.setIsBlock(feedbackDTO.getIsBlock());
        feedbackRepository.save(feedback);
        feedbackDTO.setCreateDate(now);
        return feedbackDTO;
    }
}
