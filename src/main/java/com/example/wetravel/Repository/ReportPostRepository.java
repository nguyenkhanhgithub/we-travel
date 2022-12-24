package com.example.wetravel.Repository;

import com.example.wetravel.DTO.ReportPostDTO;
import com.example.wetravel.Entity.ReportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportPostRepository extends JpaRepository<ReportPost , Long> {
    @Query("select rp.postId.postId, rp.accountId.accountId ,\n" +
            "rp.reasonReportPostId.reasonReportPostId , rp.createDate from ReportPost rp ")
    List<Object> getListReportPost();

    @Query("select rp.postId.postId, rp.accountId.accountId , rp.reasonReportPostId.reasonReportPostId\n" +
            " , rp.createDate from ReportPost rp where rp.postId.postId = :postId ")
    List<Object> getListReportPostByPostId(Long postId);
}
