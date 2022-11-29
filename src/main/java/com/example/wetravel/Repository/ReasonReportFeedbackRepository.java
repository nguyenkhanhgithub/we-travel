package com.example.wetravel.Repository;

import com.example.wetravel.Entity.ReasonReportFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonReportFeedbackRepository extends JpaRepository<ReasonReportFeedback , Long> {
}
