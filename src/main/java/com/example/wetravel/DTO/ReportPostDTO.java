package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ReportPostDTO {
    private Long postId;

    private Long accountId;

    private String firstName;

    private String lastName;

    private Long reasonReportPostId;

    private LocalDate createDate;
}
