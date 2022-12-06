package com.example.wetravel.DTO;

import com.example.wetravel.Entity.ReportPost;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Long topicId;

    private Long accountId;

    private LocalDateTime timePost;

    private String title;

    private String description;

    private String content;

    private Boolean isPublic;

    private Boolean isBlock;

    private Long serviceId;

    private List<ReportPostDTO> reportPostDTOList;
}
