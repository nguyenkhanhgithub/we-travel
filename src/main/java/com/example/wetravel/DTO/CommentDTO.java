package com.example.wetravel.DTO;

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
public class CommentDTO {
    private Long accountId;

    private String firstName;

    private String lastName;

    private LocalDateTime timeComment;

    private String content;

    private Long parentCommentId;

    private Long postId;

    private List<CommentDTO> commentDTOList;
}
