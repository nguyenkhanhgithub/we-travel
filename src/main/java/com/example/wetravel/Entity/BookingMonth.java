package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "BookingMonth")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingMonth implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_month_id")
    private Long bookingMonthId;

    @Column(name = "month_year")
    private String monthYear;

    @Column(name = "number_of_bookings")
    private Long numberOfBooking;
}
