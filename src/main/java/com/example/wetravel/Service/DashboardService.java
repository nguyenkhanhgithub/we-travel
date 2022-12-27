package com.example.wetravel.Service;

import com.example.wetravel.DTO.BookingMonthDTO;
import com.example.wetravel.Exception.HandlerException;

import java.util.List;

public interface DashboardService {
    BookingMonthDTO calculateBookingMonth() throws HandlerException;

    List<BookingMonthDTO> calculateBookingByMonth() throws HandlerException;
}
