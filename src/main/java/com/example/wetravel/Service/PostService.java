package com.example.wetravel.Service;

import com.example.wetravel.DTO.CommentDTO;
import com.example.wetravel.DTO.PostDTO;
import com.example.wetravel.DTO.ReportPostDTO;
import com.example.wetravel.DTO.ReportPostRequestDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    PostDTO createPost(PostDTO postDTO) throws HandlerException;

    PostDTO updatePost(Long postId , PostDTO postDTO) throws HandlerException;

    Boolean deletePost(Long postId) throws HandlerException;

    Boolean blockPost(Long postId) throws HandlerException;

    Page<PostDTO> getListPost(Integer checkReport ,String title , Long accountId , Integer isBlock , Integer isPublic , List<Long> topicList , Integer page , Integer size) throws HandlerException;

    PostDTO getDetailPost(Long postId) throws HandlerException;

    CommentDTO createComment(CommentDTO commentDTO) throws HandlerException;

    Page<CommentDTO> getListCommentByPost(Long postId , Integer page , Integer size) throws HandlerException;

    ReportPostRequestDTO createReportPost(ReportPostRequestDTO reportPostRequestDTO) throws HandlerException;

    Boolean deleteReportPost(Long postId) throws HandlerException;

}
