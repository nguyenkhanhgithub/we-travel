package com.example.wetravel.Repository;

import com.example.wetravel.DTO.ReportPostDTO;
import com.example.wetravel.Entity.ReportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportPostRepository extends JpaRepository<ReportPost , Long> {
    @Query("select rp.postId.postId as postId , rp.accountId.accountId as accountId ," +
            "rp.reasonReportPostId.reasonReportPostId as reasonReportPostId , rp.createDate as createDate from ReportPost rp ")
    List<ReportPostDTO> getListReportPostDTO();
}
