package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingMonthDTO {
    private String monthYear;

    private Integer thisMonth;

    private Integer lastMonth;

    private Integer beforeLastMonth;
}
