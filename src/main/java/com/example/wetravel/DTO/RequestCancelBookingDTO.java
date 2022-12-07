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
public class RequestCancelBookingDTO {
    private Long requestCancelBookingId;

    private Long userBookingId;

    private UserBookingDTO userBookingDTO;

    private Long reasonCancelId;

    private LocalDate requestDate;

    private String description;

    private Integer status;

    private String accountEmail;
}
