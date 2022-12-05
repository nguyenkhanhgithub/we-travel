package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
