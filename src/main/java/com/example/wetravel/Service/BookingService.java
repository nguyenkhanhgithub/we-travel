package com.example.wetravel.Service;


import com.example.wetravel.DTO.RequestCancelBookingDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

import java.time.LocalDate;

public interface BookingService {
    Page<UserBookingDTO> getListBooking(Long accountId , Long tourId , String startDate , Integer page , Integer size) throws HandlerException;
    UserBookingDTO createBooking(UserBookingDTO userBookingDTO) throws HandlerException;

    Boolean updateStatus(Long userBookingId , Integer status) throws HandlerException;

    Boolean updateStatusDeposit(Long userBookingId , Boolean statusDeposit) throws HandlerException;

    Boolean createRequestCancel(RequestCancelBookingDTO requestCancelBookingDTO) throws HandlerException;

    Page<RequestCancelBookingDTO> getListRequestCancelBooking(String email , Integer page , Integer size) throws HandlerException;

    Boolean deleteRequestCancelBooking(Long bookingId) throws HandlerException;
}
