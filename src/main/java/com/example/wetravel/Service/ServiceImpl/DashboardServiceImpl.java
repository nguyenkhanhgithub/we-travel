package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.BookingMonthDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.BookingMonthRepository;
import com.example.wetravel.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    BookingMonthRepository bookingMonthRepository;

    @Override
    public BookingMonthDTO calculateBookingMonth() throws HandlerException {
        LocalDate now = LocalDate.now();
        int day = now.getDayOfMonth();
        int month = now.getMonthValue();
        int year = now.getYear();
        Calendar cal = Calendar.getInstance();

        BookingMonthDTO bookingMonthDTO;
        Integer countBookingThisMonth = bookingMonthRepository.countBookingByDayMonthYear(day , month , year);
        Integer countBookingNextMonth = 0;

        if(month == 1){
            Integer lastDay = cal.getMaximum(12);
            countBookingNextMonth = bookingMonthRepository.countBookingByDayMonthYear(lastDay , 12 , year - 1);
        }else{
            Integer lastDay = cal.getMaximum(month - 1);
            countBookingNextMonth = bookingMonthRepository.countBookingByDayMonthYear(lastDay , month - 1 , year);
        }
        Integer countBookingNextAfterMonth = 0;
        if(month == 2){
            Integer lastDay = cal.getMaximum(12);
            countBookingNextAfterMonth = bookingMonthRepository.countBookingByDayMonthYear(lastDay ,12 , year - 1);
        }else if(month == 1){
            Integer lastDay = cal.getMaximum(11);
            countBookingNextAfterMonth = bookingMonthRepository.countBookingByDayMonthYear(lastDay ,11 , year - 1);
        }else{
            Integer lastDay = cal.getMaximum(month-2);
            countBookingNextAfterMonth = bookingMonthRepository.countBookingByDayMonthYear(lastDay , month - 2 , year);
        }
        bookingMonthDTO = new BookingMonthDTO(null ,countBookingThisMonth , countBookingNextMonth , countBookingNextAfterMonth);
        return bookingMonthDTO;
    }

    @Override
    public List<BookingMonthDTO> calculateBookingByMonth() throws HandlerException {
        LocalDate now = LocalDate.now();
        int month = 1;
        int year = now.getYear();
        List<BookingMonthDTO> bookingMonthDTOList = new ArrayList<>();
        int count = 0;
        int booking = 0;
        for(int i = month-1 ; i >= 0 ; i--){
            BookingMonthDTO bookingMonthDTO = new BookingMonthDTO();
            if(i == 0){
                count++;
                month = 12;
                i = month;
                booking = bookingMonthRepository.countBookingByMonthYear(month , year);
            }else{
                count++;
                booking = bookingMonthRepository.countBookingByMonthYear(i , year);
            }
            bookingMonthDTO.setMonthYear(i + "/" + year);
            bookingMonthDTO.setThisMonth(booking);
            bookingMonthDTOList.add(bookingMonthDTO);
            if(count == 7){
                break;
            }
        }
        return bookingMonthDTOList;
    }


}
