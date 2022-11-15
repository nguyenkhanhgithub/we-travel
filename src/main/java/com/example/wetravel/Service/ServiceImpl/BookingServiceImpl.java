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
    public List<UserBookingDTO> getListBookingByAccountId(Long accountId) throws HandlerException{
        if(!userBookingRepository.existsByAccountId_AccountId(accountId)){
            throw new HandlerException("Booking not exist!");
        }
        List<Object> objectList = userBookingRepository.getListBookingByAccountId(accountId);
        List<UserBookingDTO> userBookingDTOList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (Object o : objectList){
            Object[] objects = (Object[]) o;
            UserBookingDTO userBookingDTO = new UserBookingDTO();
            Long bookingId = (Long) objects[0];
            userBookingDTO.setUserBookingId(bookingId);
            Long tourId = (Long) objects[1];
            userBookingDTO.setTourId(tourId);
            String tourName = objects[2].toString();
            userBookingDTO.setTourName(tourName);
            LocalDate startDate = LocalDate.parse(objects[3].toString(),formatter);
            userBookingDTO.setStartDate(startDate);
            Integer numberOfAdult = (Integer) objects[4];
            userBookingDTO.setNumberOfAdult(numberOfAdult);
            Integer numberOfChildren = (Integer) objects[5];
            userBookingDTO.setNumberOfChildren(numberOfChildren);
            Integer tourType = (Integer) objects[6];
            userBookingDTO.setTourType(tourType);
            Integer status = (Integer) objects[7];
            userBookingDTO.setStatus(status);
            Boolean statusDeposit = (Boolean) objects[8];
            userBookingDTO.setStatusDeposit(statusDeposit);
            Float totalPrice = (Float) objects[9];
            userBookingDTO.setTotalPrice(totalPrice);
            Float deposit = (Float) objects[10];
            userBookingDTO.setDeposit(deposit);

            userBookingDTOList.add(userBookingDTO);
        }
        return userBookingDTOList;
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
        userBooking.setPromoCode(userBookingDTO.getPromoCode());
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
    public Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) {
        UserBooking userBooking = userBookingRepository.getById(userBookingId);
        userBooking.setStatusDeposit(statusDeposit);
        userBookingRepository.save(userBooking);
        return true;
    }
}
