package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.RequestCancelBookingDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    UserBookingRepository userBookingRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    ReasonCancelRepository reasonCancelRepository;

    @Autowired
    RequestCancelRepository requestCancelRepository;

    @Override
    public Page<UserBookingDTO> getListBooking(Long accountId , Long tourId , String startDate , Integer page , Integer size) throws HandlerException{
        if(!userBookingRepository.existsByAccountId_AccountId(accountId) && accountId != -1){
            throw new HandlerException("Booking not exist!");
        }
        Pageable pageable = PageRequest.of(page - 1 , size);
        Page<UserBooking> userBookingPage = userBookingRepository.getListBooking(accountId , tourId , startDate , pageable);
        List<UserBooking> userBookingList = userBookingPage.getContent();
        List<UserBookingDTO> userBookingDTOList = new ArrayList<>();
        for (UserBooking u : userBookingList){
            UserBookingDTO userBookingDTO = new UserBookingDTO();
            userBookingDTO.setUserBookingId(u.getUserBookingId());
            userBookingDTO.setAccountId(u.getAccountId().getAccountId());
            userBookingDTO.setTourId(u.getTourId().getTourId());
            userBookingDTO.setTourName(u.getTourId().getTourName());
            userBookingDTO.setTourType(u.getTourId().getTourType());
            userBookingDTO.setFullName(u.getFullName());
            userBookingDTO.setPhone(u.getPhone());
            userBookingDTO.setEmail(u.getEmail());
            userBookingDTO.setBookingDate(u.getBookingDate());
            userBookingDTO.setStartDate(u.getStartDate());
            userBookingDTO.setIdCard(u.getIdCard());
            userBookingDTO.setDateOfIssue(u.getDateOfIssue());
            userBookingDTO.setPlaceOfIssue(u.getPlaceOfIssue());
            userBookingDTO.setRequest(u.getRequest());
            userBookingDTO.setAdultPrice(u.getAdultPrice());
            userBookingDTO.setChildrenPrice(u.getChildrenPrice());
            userBookingDTO.setNumberOfAdult(u.getNumberOfAdult());
            userBookingDTO.setNumberOfChildren(u.getNumberOfChildren());
            userBookingDTO.setTotalPrice(u.getTotalPrice());
            userBookingDTO.setOrderId(u.getOrderId());
            userBookingDTO.setOrderTitle(u.getOrderTitle());
            userBookingDTO.setPayType(u.getPayType());
            userBookingDTO.setStatus(u.getStatus());
            userBookingDTO.setDeposit(u.getTourId().getDeposit());
            userBookingDTO.setStatusDeposit(u.getStatusDeposit());
            userBookingDTO.setIsFeedback(u.getIsFeedback());
            userBookingDTOList.add(userBookingDTO);
        }
        return new PageImpl<>(userBookingDTOList , pageable , userBookingDTOList.size());
    }



    @Override
    public UserBookingDTO createBooking(UserBookingDTO userBookingDTO) throws HandlerException {
        UserBooking userBooking = new UserBooking();
        Account account = accountRepository.getById(userBookingDTO.getAccountId());
        userBooking.setAccountId(account);
        Tour tour = tourRepository.getById(userBookingDTO.getTourId());
        userBooking.setTourId(tour);
        userBooking.setFullName(userBookingDTO.getFullName());
        userBooking.setPhone(userBookingDTO.getPhone());
        userBooking.setEmail(userBookingDTO.getEmail());
        userBooking.setBookingDate(userBookingDTO.getBookingDate());
        userBooking.setStartDate(userBookingDTO.getStartDate());
        userBooking.setIdCard(userBookingDTO.getIdCard());
        userBooking.setDateOfIssue(userBookingDTO.getDateOfIssue());
        userBooking.setPlaceOfIssue(userBookingDTO.getPlaceOfIssue());
        userBooking.setRequest(userBookingDTO.getRequest());
        userBooking.setNumberOfAdult(userBookingDTO.getNumberOfAdult());
        userBooking.setNumberOfChildren(userBookingDTO.getNumberOfChildren());
        userBooking.setAdultPrice(userBookingDTO.getAdultPrice());
        userBooking.setChildrenPrice(userBookingDTO.getChildrenPrice());
        userBooking.setTotalPrice(userBookingDTO.getTotalPrice());
        userBooking.setOrderId(userBookingDTO.getOrderId());
        userBooking.setOrderTitle(userBookingDTO.getOrderTitle());
        userBooking.setPayType(userBookingDTO.getPayType());
        userBooking.setStatus(userBookingDTO.getStatus());
        userBooking.setStatusDeposit(userBookingDTO.getStatusDeposit());
        userBooking.setIsFeedback(false);
        userBookingRepository.save(userBooking);
        userBookingDTO.setUserBookingId(userBooking.getUserBookingId());
        userBookingDTO.setTourName(tour.getTourName());
        userBookingDTO.setTourType(tour.getTourType());
        return userBookingDTO;
    }

    @Override
    public Boolean updateStatus(Long userBookingId , Integer status) throws HandlerException{
        UserBooking userBooking = userBookingRepository.getById(userBookingId);
        userBooking.setStatus(status);
        userBookingRepository.save(userBooking);
        return true;
    }

    @Override
    public Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) throws HandlerException{
        UserBooking userBooking = userBookingRepository.getById(userBookingId);
        userBooking.setStatusDeposit(statusDeposit);
        userBookingRepository.save(userBooking);
        return true;
    }

    @Override
    public Boolean createRequestCancel(RequestCancelBookingDTO requestCancelBookingDTO) throws HandlerException {
        RequestCancel requestCancel = new RequestCancel();
        UserBooking userBooking = userBookingRepository.getById(requestCancelBookingDTO.getUserBookingId());
        requestCancel.setUserBookingId(userBooking);
        LocalDate now = LocalDate.now();
        requestCancel.setRequestDate(now);
        ReasonCancel reasonCancel = reasonCancelRepository.getById(requestCancelBookingDTO.getReasonCancelId());
        requestCancel.setReasonCancelId(reasonCancel);
        requestCancel.setDescription(requestCancelBookingDTO.getDescription());
        requestCancel.setStatus(0);
        requestCancelRepository.save(requestCancel);
        return true;
    }

    @Override
    public Boolean deleteRequestCancelBooking(Long requestCancelId) throws HandlerException{
        if(!requestCancelRepository.existsRequestCancelByRequestCancelId(requestCancelId)){
            throw new HandlerException("Request not found!");
        }
        RequestCancel requestCancel = requestCancelRepository.getById(requestCancelId);
        requestCancelRepository.delete(requestCancel);
        return true;
    }


}
