package com.example.wetravel.Service;


import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Exception.HandlerException;

import java.util.List;

public interface BookingService {
    List<UserBookingDTO> getListBookingByAccountId(Long accountId) throws HandlerException;
    UserBookingDTO createBooking(UserBookingDTO userBookingDTO) throws HandlerException;

    Boolean updateStatus(Long userBookingId , Integer status) throws HandlerException;

    Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) throws HandlerException;
}
