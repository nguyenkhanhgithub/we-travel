package com.example.wetravel.Repository;

import com.example.wetravel.Entity.ReasonReportPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonReportPostRepository extends JpaRepository<ReasonReportPost , Long> {
}
