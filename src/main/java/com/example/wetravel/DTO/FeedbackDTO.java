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
public class FeedbackDTO {
    private Long feedbackId;

    private Long accountId;

    private Long tourId;

    private Long userbookingId;

    private LocalDate createDate;

    private String content;

    private Boolean isBlock;

    private String firstName;

    private String lastName;
}
