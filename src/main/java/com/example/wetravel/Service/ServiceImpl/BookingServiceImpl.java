package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.Tour;
import com.example.wetravel.Entity.UserBooking;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.TourRepository;
import com.example.wetravel.Repository.UserBookingRepository;
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
            userBookingDTO.setStatusDeposit(u.getStatusDeposit());
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
        userBookingRepository.save(userBooking);
        userBookingDTO.setUserBookingId(userBooking.getUserBookingId());
        userBookingDTO.setTourName(tour.getTourName());
        userBookingDTO.setTourType(tour.getTourType());
        return userBookingDTO;
    }

    @Override
    public UserBookingDTO getBookingOfTourPrivateByTourId(Long tourId) throws HandlerException{
        UserBooking userBooking = userBookingRepository.getBookingOfTourPrivateByTourId(tourId);
        UserBookingDTO userBookingDTO = new UserBookingDTO();
        userBookingDTO.setUserBookingId(userBooking.getUserBookingId());
        userBookingDTO.setAccountId(userBooking.getAccountId().getAccountId());
        userBookingDTO.setTourId(userBooking.getTourId().getTourId());
        userBookingDTO.setFullName(userBooking.getFullName());
        userBookingDTO.setPhone(userBooking.getPhone());
        userBookingDTO.setEmail(userBooking.getEmail());
        userBookingDTO.setBookingDate(userBooking.getBookingDate());
        userBookingDTO.setStartDate(userBooking.getStartDate());
        userBookingDTO.setIdCard(userBooking.getIdCard());
        userBookingDTO.setDateOfIssue(userBooking.getDateOfIssue());
        userBookingDTO.setPlaceOfIssue(userBooking.getPlaceOfIssue());
        userBookingDTO.setRequest(userBooking.getRequest());
        userBookingDTO.setAdultPrice(userBooking.getAdultPrice());
        userBookingDTO.setChildrenPrice(userBooking.getChildrenPrice());
        userBookingDTO.setNumberOfAdult(userBooking.getNumberOfAdult());
        userBookingDTO.setNumberOfChildren(userBooking.getNumberOfChildren());
        userBookingDTO.setTotalPrice(userBooking.getTotalPrice());
        userBookingDTO.setOrderId(userBooking.getOrderId());
        userBookingDTO.setOrderTitle(userBooking.getOrderTitle());
        userBookingDTO.setPayType(userBooking.getPayType());
        userBookingDTO.setStatus(userBooking.getStatus());
        userBookingDTO.setStatusDeposit(userBooking.getStatusDeposit());
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
}
