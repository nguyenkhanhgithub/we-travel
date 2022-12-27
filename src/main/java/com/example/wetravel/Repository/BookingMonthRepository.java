package com.example.wetravel.Repository;

import com.example.wetravel.Entity.BookingMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingMonthRepository extends JpaRepository<BookingMonth , Long> {
    @Query(value = "select count(*) from user_booking where day(booking_date) <= :day and month(booking_date) = :month and year(booking_date) = :year" , nativeQuery = true)
    Integer countBookingByDayMonthYear(Integer day , Integer month , Integer year);

    @Query(value = "select count(*) from user_booking where month(booking_date) = :month and year(booking_date) = :year" , nativeQuery = true)
    Integer countBookingByMonthYear(Integer month , Integer year);
}
