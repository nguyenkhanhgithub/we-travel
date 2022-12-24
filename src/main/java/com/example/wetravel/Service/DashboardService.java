package com.example.wetravel.Service;

import com.example.wetravel.DTO.BookingMonthDTO;
import com.example.wetravel.Exception.HandlerException;

public interface DashboardService {
    BookingMonthDTO calculateBookingMonth() throws HandlerException;
}
