package com.example.wetravel.Service;


import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface BookingService {
    Page<UserBookingDTO> getListBookingByAccountId(Long accountId , Long tourId , LocalDate startDate , Integer page , Integer size) throws HandlerException;
    UserBookingDTO createBooking(UserBookingDTO userBookingDTO) throws HandlerException;

    Boolean updateStatus(Long userBookingId , Integer status) throws HandlerException;

    Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) throws HandlerException;
}
