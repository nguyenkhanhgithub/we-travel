package com.example.wetravel.Service;


import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface BookingService {
    Page<UserBookingDTO> getListBookingByAccountId(Long accountId , Integer page , Integer size) throws HandlerException;
    UserBookingDTO createBooking(UserBookingDTO userBookingDTO) throws HandlerException;

    Boolean updateStatus(Long userBookingId , Integer status) throws HandlerException;

    Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) throws HandlerException;
}
