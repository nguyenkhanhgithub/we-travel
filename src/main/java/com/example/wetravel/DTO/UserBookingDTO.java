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
public class UserBookingDTO {
    private Long userBookingId;

    private Long accountId;

    private Long tourId;

    private String tourName;

    private Integer tourType;

    private String fullName;

    private String phone;

    private String email;

    private LocalDate bookingDate;

    private LocalDate startDate;

    private String idCard;

    private LocalDate dateOfIssue;

    private String placeOfIssue;

    private String request;

    private Float adultPrice;

    private Float childrenPrice;

    private Integer numberOfAdult;

    private Integer numberOfChildren;

    private Float totalPrice;

    private Long orderId;

    private String orderTitle;

    private String payType;

    private Integer status;

    private Boolean statusDeposit;

    private Float deposit;

    private Boolean isFeedback;
}
