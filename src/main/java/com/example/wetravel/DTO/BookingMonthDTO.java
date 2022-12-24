package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookingMonthDTO {
    private Long thisMonth;

    private Long nextMonth;

    private Long afterNextMonth;
}
