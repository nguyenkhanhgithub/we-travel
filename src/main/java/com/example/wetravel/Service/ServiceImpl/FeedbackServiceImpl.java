package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.DTO.ReportFeedbackDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerRepository partnerRepository;

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
        reportFeedbackRepository.save(reportFeedback);
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

    @Override
    public Page<FeedbackDTO> getListFeedback(Long tourId , Integer isBlock , Integer page , Integer size) throws HandlerException {
        Pageable pageable = PageRequest.of(page - 1 , size);
        Page<Feedback> feedbackPage = feedbackRepository.getAllByTourId(tourId , isBlock , pageable);
        List<Feedback> feedbackList = feedbackPage.getContent();
        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        for (Feedback f : feedbackList) {
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setFeedbackId(f.getFeedbackId());
            feedbackDTO.setAccountId(f.getAccountId().getAccountId());
            feedbackDTO.setTourId(f.getTourId().getTourId());
            feedbackDTO.setUserbookingId(f.getUserBookingId().getUserBookingId());
            feedbackDTO.setCreateDate(f.getCreateDate());
            feedbackDTO.setContent(f.getContent());
            feedbackDTO.setIsBlock(f.getIsBlock());
            Account account = accountRepository.getById(f.getAccountId().getAccountId());
            if(account.getRoleId().getRoleId() == Constant.Role.Customer){
                User user = userRepository.getByAccountId_AccountId(account.getAccountId());
                feedbackDTO.setFirstName(user.getFirstName());
                feedbackDTO.setLastName(user.getLastName());
            }else{
                Partner partner = partnerRepository.getPartnerByAccountId_AccountId(account.getAccountId());
                feedbackDTO.setFirstName(partner.getFirstName());
                feedbackDTO.setLastName(partner.getLastName());
            }
            feedbackDTOList.add(feedbackDTO);
        }
        return new PageImpl<>(feedbackDTOList , pageable , feedbackDTOList.size());
    }

    @Override
    public Page<FeedbackDTO> getListFeedbackContainReport(Integer page , Integer size) throws HandlerException {
        Pageable pageable = PageRequest.of(page - 1 ,size);
        Page<Feedback> feedbackPage = feedbackRepository.getListFeedback(pageable);
        List<Feedback> feedbackList = feedbackPage.getContent();
        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        for (Feedback f : feedbackList){
            FeedbackDTO feedbackDTO = new FeedbackDTO();
            feedbackDTO.setFeedbackId(f.getFeedbackId());
            feedbackDTO.setAccountId(f.getAccountId().getAccountId());
            feedbackDTO.setTourId(f.getTourId().getTourId());
            feedbackDTO.setUserbookingId(f.getUserBookingId().getUserBookingId());
            feedbackDTO.setCreateDate(f.getCreateDate());
            feedbackDTO.setContent(f.getContent());
            feedbackDTO.setIsBlock(f.getIsBlock());
            List<ReportFeedbackDTO> reportFeedbackDTOList = new ArrayList<>();
            List<ReportFeedback> reportFeedbackList = reportFeedbackRepository.getAllByFeedbackId_FeedbackId(f.getFeedbackId());
            for (ReportFeedback rf : reportFeedbackList){
                ReportFeedbackDTO reportFeedbackDTO = new ReportFeedbackDTO();
                reportFeedbackDTO.setAccountId(rf.getAccountId().getAccountId());
                reportFeedbackDTO.setFeedbackId(rf.getFeedbackId().getFeedbackId());
                reportFeedbackDTO.setReasonReportFeedbackId(rf.getReportFeedbackId());
                reportFeedbackDTOList.add(reportFeedbackDTO);
            }
            feedbackDTO.setReportFeedbackDTOList(reportFeedbackDTOList);
            feedbackDTOList.add(feedbackDTO);
        }
        return new PageImpl<>(feedbackDTOList , pageable , feedbackDTOList.size());
    }
}
