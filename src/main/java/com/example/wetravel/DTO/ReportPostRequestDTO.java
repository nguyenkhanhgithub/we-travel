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
public class ReportPostRequestDTO {
    private Long postId;

    private Long accountId;

    private Long reasonReportPostId;

    private LocalDate createDate;
}
