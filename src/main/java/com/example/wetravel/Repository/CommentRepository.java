package com.example.wetravel.Repository;

import com.example.wetravel.DTO.CommentDTO;
import com.example.wetravel.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment , Long> {
    Boolean existsCommentByParentCommentId(Long commentId);
    List<Comment> getAllByParentCommentId(Long commentId);
    List<Comment> getAllByPostId_PostIdAndParentCommentIdNullOrderByCreateDateDesc(Long postId);
}
