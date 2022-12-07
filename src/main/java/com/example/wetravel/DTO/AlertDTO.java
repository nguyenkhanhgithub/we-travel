package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlertDTO {
    private Long alertId;

    private Long accountId;

    private String title;

    private String content;

    private Boolean status;

    private LocalDateTime timeCreate;
}
