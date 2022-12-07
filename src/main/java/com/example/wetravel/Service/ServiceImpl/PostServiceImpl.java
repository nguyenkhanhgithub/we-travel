package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.CommentDTO;
import com.example.wetravel.DTO.PostDTO;
import com.example.wetravel.DTO.ReportPostDTO;
import com.example.wetravel.DTO.ReportPostRequestDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    ReportPostRepository reportPostRepository;

    @Autowired
    ReasonReportPostRepository reasonReportPostRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO) throws HandlerException {
        Post post = new Post();
        Topic topic = topicRepository.getById(postDTO.getTopicId());
        post.setTopicId(topic);
        Account account = accountRepository.getById(postDTO.getAccountId());
        post.setAccountId(account);
        LocalDateTime timePost = LocalDateTime.now();
        post.setTimePost(timePost);
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        post.setIsPublic(postDTO.getIsPublic());
        post.setIsBlock(false);
        com.example.wetravel.Entity.Service service = serviceRepository.getById(postDTO.getServiceId());
        post.setServiceId(service);
        postRepository.save(post);
        postDTO.setTimePost(timePost);
        postDTO.setIsBlock(false);
        return postDTO;
    }

    @Override
    public Boolean deletePost(Long postId) throws HandlerException {
        if(!postRepository.existsPostByPostId(postId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        Post post = postRepository.getById(postId);
        postRepository.delete(post);
        return true;
    }

    @Override
    public Page<PostDTO> getListPost(Integer checkReport ,Long accountId, Integer isBlock, Integer isPublic, List<Long> topicList , Integer page , Integer size) throws HandlerException {
        Pageable pageable = PageRequest.of(page - 1 , size);
        if(topicList.isEmpty()){
            topicList.add(-1L);
        }
        List<Post> postList = new ArrayList<>();
        if(checkReport == 0){
            postList = postRepository.getListPost(accountId , isBlock , isPublic , topicList ,pageable);
        }else{
            postList = postRepository.getListPostReport(accountId , isBlock , isPublic , topicList ,pageable);
        }
        List<PostDTO> postDTOList = new ArrayList<>();
        for(Post p : postList){
            PostDTO postDTO = new PostDTO();
            postDTO.setTopicId(p.getTopicId().getTopicId());
            postDTO.setAccountId(p.getAccountId().getAccountId());
            postDTO.setTimePost(p.getTimePost());
            postDTO.setTitle(p.getTitle());
            postDTO.setDescription(p.getDescription());
            postDTO.setContent(p.getContent());
            postDTO.setIsPublic(p.getIsPublic());
            postDTO.setIsBlock(p.getIsBlock());
            postDTO.setServiceId(p.getServiceId().getServiceId());
            List<ReportPostDTO> reportPostDTOList = reportPostRepository.getListReportPostDTO();
            postDTO.setReportPostDTOList(reportPostDTOList);
            postDTOList.add(postDTO);
        }
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()) , postDTOList.size());
        return new PageImpl<>(postDTOList.subList(start , end) , pageable , postDTOList.size());
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) throws HandlerException {
        Comment comment = new Comment();
        Account account = accountRepository.getById(commentDTO.getAccountId());
        comment.setAccountId(account);
        LocalDateTime timeComment = LocalDateTime.now();
        comment.setCreateDate(timeComment);
        comment.setContent(commentDTO.getContent());
        comment.setParentCommentId(null);
        Post post = postRepository.getById(commentDTO.getPostId());
        comment.setPostId(post);
        commentDTO.setTimeComment(timeComment);
        commentRepository.save(comment);
        return commentDTO;
    }

    @Override
    public ReportPostRequestDTO createReportPost(ReportPostRequestDTO reportPostRequestDTO) throws HandlerException {
        ReportPost reportPost = new ReportPost();
        reportPost.setPostId(postRepository.getById(reportPostRequestDTO.getPostId()));
        reportPost.setAccountId(accountRepository.getById(reportPostRequestDTO.getAccountId()));
        reportPost.setReasonReportPostId(reasonReportPostRepository.getById(reportPostRequestDTO.getReasonReportPostId()));
        LocalDate timeCreate = LocalDate.now();
        reportPost.setCreateDate(timeCreate);
        reportPostRepository.save(reportPost);
        reportPostRequestDTO.setCreateDate(timeCreate);
        return reportPostRequestDTO;
    }
}
