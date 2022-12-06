package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


public interface ReportPostDTO {
    Long getPostId();

    Long getAccountId();

    Long getReasonReportPostId();

    LocalDate getCreateDate();

    LocalDate setCreateDate(LocalDate localDate);
}
