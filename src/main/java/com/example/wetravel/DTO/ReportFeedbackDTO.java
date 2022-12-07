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
public class ReportFeedbackDTO {
    private Long accountId;

    private String firstName;

    private String lastName;

    private Long feedbackId;

    private Long reasonReportFeedbackId;

    private LocalDate createDate;
}
