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
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    public
    PostRepository postRepository;

    @Autowired
    public
    TopicRepository topicRepository;

    @Autowired
    public
    AccountRepository accountRepository;

    @Autowired
    public
    UserRepository userRepository;

    @Autowired
    public
    PartnerRepository partnerRepository;

    @Autowired
    public
    CommentRepository commentRepository;

    @Autowired
    public
    ReportPostRepository reportPostRepository;

    @Autowired
    public
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
        postRepository.save(post);
        postDTO.setPostId(post.getPostId());
        postDTO.setTimePost(timePost);
        postDTO.setIsBlock(false);
        return postDTO;
    }

    @Override
    public PostDTO updatePost(Long postId, PostDTO postDTO) throws HandlerException {
        Post post = postRepository.getById(postId);
        if(!postRepository.existsPostByPostId(postId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        Topic topic = topicRepository.getById(postDTO.getTopicId());
        post.setTopicId(topic);
        post.setTitle(postDTO.getTitle());
        post.setDescription(postDTO.getDescription());
        post.setContent(postDTO.getContent());
        post.setIsPublic(postDTO.getIsPublic());
        postRepository.save(post);
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
    public Boolean blockPost(Long postId) throws HandlerException {
        if(!postRepository.existsPostByPostId(postId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        Post post = postRepository.getById(postId);
        post.setIsBlock(true);
        List<ReportPost> reportPostList = reportPostRepository.getAllByPostId_PostId(postId);
        reportPostRepository.deleteAll(reportPostList);
        return true;
    }

    @Override
    public Page<PostDTO> getListPost(Integer checkReport ,String title , Long accountId, Integer isBlock, Integer isPublic, List<Long> topicList , Integer page , Integer size) throws HandlerException {
        Pageable pageable = PageRequest.of(page - 1 , size);
        if(topicList.isEmpty()){
            topicList.add(-1L);
        }
        List<Post> postList;
        if(checkReport == 0){
            postList = postRepository.getListPost( "%" +title+"%" ,accountId , isBlock , isPublic , topicList ,pageable);
        }else{
            postList = postRepository.getListPostReport("%" +title+"%" ,accountId , isBlock , isPublic , topicList ,pageable);
        }
        List<PostDTO> postDTOList = new ArrayList<>();
        for(Post p : postList){
            PostDTO postDTO = new PostDTO();
            postDTO.setPostId(p.getPostId());
            postDTO.setTopicId(p.getTopicId().getTopicId());
            Account account = p.getAccountId();
            postDTO.setAccountId(account.getAccountId());
            if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Customer)){
                User user = userRepository.getByAccountId_AccountId(account.getAccountId());
                postDTO.setFirstName(user.getFirstName());
                postDTO.setLastName(user.getLastName());
            }else if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Partner)){
                Partner partner = partnerRepository.getPartnerByAccountId_AccountId(account.getAccountId());
                postDTO.setFirstName(partner.getFirstName());
                postDTO.setLastName(partner.getLastName());
            } else {
                postDTO.setFirstName("Admin");
            }
            postDTO.setTimePost(p.getTimePost());
            postDTO.setTitle(p.getTitle());
            postDTO.setDescription(p.getDescription());
            postDTO.setContent(p.getContent());
            postDTO.setIsPublic(p.getIsPublic());
            postDTO.setIsBlock(p.getIsBlock());
            List<Object> reportPostDTOList = reportPostRepository.getListReportPostByPostId(p.getPostId());
            List<ReportPostDTO> reportPostDTOS = new ArrayList<>();
            for(Object o : reportPostDTOList){
                Object[] objects = (Object[]) o;
                ReportPostDTO reportPostDTO = new ReportPostDTO();
                reportPostDTO.setPostId((Long) objects[0]);
                reportPostDTO.setReasonReportPostId((Long) objects[2]);
                reportPostDTO.setCreateDate((LocalDate) objects[3]);
                Long accId = (Long) objects[1];
                reportPostDTO.setAccountId(accId);
                Account accountReport = accountRepository.getById(accId);
                if(Objects.equals(accountReport.getRoleId().getRoleId(), Constant.Role.Customer)){
                    User user = userRepository.getByAccountId_AccountId(accId);
                    reportPostDTO.setFirstName(user.getFirstName());
                    reportPostDTO.setLastName(user.getLastName());
                }else if(Objects.equals(accountReport.getRoleId().getRoleId(), Constant.Role.Partner)){
                    Partner partner = partnerRepository.getPartnerByAccountId_AccountId(accId);
                    reportPostDTO.setFirstName(partner.getFirstName());
                    reportPostDTO.setLastName(partner.getLastName());
                }
                reportPostDTOS.add(reportPostDTO);
            }
            postDTO.setReportPostDTOList(reportPostDTOS);
            postDTOList.add(postDTO);
        }
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()) , postDTOList.size());
        return new PageImpl<>(postDTOList.subList(start , end) , pageable , postDTOList.size());
    }

    @Override
    public PostDTO getDetailPost(Long postId) throws HandlerException {
        Post post = postRepository.getById(postId);
        if(!postRepository.existsPostByPostId(postId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        PostDTO postDTO = new PostDTO();
        postDTO.setPostId(post.getPostId());
        postDTO.setTopicId(post.getTopicId().getTopicId());
        Account account = post.getAccountId();
        postDTO.setAccountId(account.getAccountId());
        if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Customer)){
            User user = userRepository.getByAccountId_AccountId(account.getAccountId());
            postDTO.setFirstName(user.getFirstName());
            postDTO.setLastName(user.getLastName());
        }else if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Partner)){
            Partner partner = partnerRepository.getPartnerByAccountId_AccountId(account.getAccountId());
            postDTO.setFirstName(partner.getFirstName());
            postDTO.setLastName(partner.getLastName());
        } else {
            postDTO.setFirstName("Admin");
        }
        postDTO.setTimePost(post.getTimePost());
        postDTO.setTitle(post.getTitle());
        postDTO.setDescription(post.getDescription());
        postDTO.setContent(post.getContent());
        postDTO.setIsPublic(post.getIsPublic());
        postDTO.setIsBlock(post.getIsBlock());
        List<Object> reportPostDTOList = reportPostRepository.getListReportPostByPostId(postId);
        List<ReportPostDTO> reportPostDTOS = new ArrayList<>();
        for(Object o : reportPostDTOList){
            Object[] objects = (Object[]) o;
            ReportPostDTO reportPostDTO = new ReportPostDTO();
            reportPostDTO.setPostId((Long) objects[0]);
            reportPostDTO.setReasonReportPostId((Long) objects[2]);
            Long accId = (Long) objects[1];
            reportPostDTO.setAccountId(accId);
            Account accountReport = accountRepository.getById(accId);
            if(Objects.equals(accountReport.getRoleId().getRoleId(), Constant.Role.Customer)){
                User user = userRepository.getByAccountId_AccountId(accId);
                reportPostDTO.setFirstName(user.getFirstName());
                reportPostDTO.setLastName(user.getLastName());
            }else if(Objects.equals(accountReport.getRoleId().getRoleId(), Constant.Role.Partner)){
                Partner partner = partnerRepository.getPartnerByAccountId_AccountId(accId);
                reportPostDTO.setFirstName(partner.getFirstName());
                reportPostDTO.setLastName(partner.getLastName());
            }
            reportPostDTOS.add(reportPostDTO);
        }
        postDTO.setReportPostDTOList(reportPostDTOS);
        return postDTO;
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO) throws HandlerException {
        Comment comment = new Comment();
        Account account = accountRepository.getById(commentDTO.getAccountId());
        comment.setAccountId(account);
        LocalDateTime timeComment = LocalDateTime.now();
        comment.setCreateDate(timeComment);
        comment.setContent(commentDTO.getContent());
        if (commentDTO.getParentCommentId() == null) {
            comment.setParentCommentId(null);
        } else {
            comment.setParentCommentId(commentDTO.getParentCommentId());
        }
        Post post = postRepository.getById(commentDTO.getPostId());
        comment.setPostId(post);
        commentDTO.setTimeComment(timeComment);
        commentRepository.save(comment);
        commentDTO.setCommentId(comment.getCommentId());
        return commentDTO;
    }

    @Override
    public Page<CommentDTO> getListCommentByPost(Long postId , Integer page , Integer size) throws HandlerException {
        List<Comment> commentList = commentRepository.getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(postId);
        List<CommentDTO> commentDTOList = new ArrayList<>();
        for (Comment c : commentList){
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCommentId(c.getCommentId());
            Account account = c.getAccountId();
            commentDTO.setAccountId(account.getAccountId());
            if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Customer)){
                User user = userRepository.getByAccountId_AccountId(account.getAccountId());
                commentDTO.setFirstName(user.getFirstName());
                commentDTO.setLastName(user.getLastName());
            }else if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Partner)){
                Partner partner = partnerRepository.getPartnerByAccountId_AccountId(account.getAccountId());
                commentDTO.setFirstName(partner.getFirstName());
                commentDTO.setLastName(partner.getLastName());
            } else {
                commentDTO.setFirstName("Admin");
            }
            commentDTO.setPostId(c.getPostId().getPostId());
            commentDTO.setParentCommentId(c.getParentCommentId());
            commentDTO.setContent(c.getContent());
            commentDTO.setTimeComment(c.getCreateDate());
            if(commentRepository.existsCommentByParentCommentId(c.getCommentId())){
                List<CommentDTO> listComment = new ArrayList<>();
                listComment = getListReplyComment(listComment, c.getCommentId());
                commentDTO.setCommentDTOList(listComment);
            }else{
                commentDTO.setCommentDTOList(null);
            }
            commentDTOList.add(commentDTO);
        }
        Pageable pageable = PageRequest.of(page -1 , size);
        int start = (int) pageable.getOffset();
        int end = Math.min((start + pageable.getPageSize()) , commentDTOList.size());
        return new PageImpl<>(commentDTOList.subList(start , end) , pageable , commentDTOList.size());
    }

    public List<CommentDTO> getListReplyComment(List<CommentDTO> commentDTOList ,Long commentId){
        List<Comment> commentList = commentRepository.getAllByParentCommentId(commentId);
        for(Comment c : commentList){
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setCommentId(c.getCommentId());
            Account account = c.getAccountId();
            commentDTO.setAccountId(account.getAccountId());
            if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Customer)){
                User user = userRepository.getByAccountId_AccountId(account.getAccountId());
                commentDTO.setFirstName(user.getFirstName());
                commentDTO.setLastName(user.getLastName());
            }else if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Partner)){
                Partner partner = partnerRepository.getPartnerByAccountId_AccountId(account.getAccountId());
                commentDTO.setFirstName(partner.getFirstName());
                commentDTO.setLastName(partner.getLastName());
            } else {
                commentDTO.setFirstName("Admin");
            }
            commentDTO.setPostId(c.getPostId().getPostId());
            commentDTO.setParentCommentId(c.getParentCommentId());
            commentDTO.setContent(c.getContent());
            commentDTO.setTimeComment(c.getCreateDate());
            if(commentRepository.existsCommentByParentCommentId(c.getCommentId())){
                List<CommentDTO> listComment = new ArrayList<>();
                listComment = getListReplyComment(listComment, c.getCommentId());
                commentDTO.setCommentDTOList(listComment);
            }else{
                commentDTO.setCommentDTOList(null);
            }
            commentDTOList.add(commentDTO);
        }
        return commentDTOList;
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

    @Override
    public Boolean deleteReportPost(Long postId) throws HandlerException{
        List<ReportPost> reportPostList = reportPostRepository.getReportPostByPostId_PostId(postId);
        if(!reportPostRepository.existsByPostId_PostId(postId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        reportPostRepository.deleteAll(reportPostList);
        return true;
    }
}
