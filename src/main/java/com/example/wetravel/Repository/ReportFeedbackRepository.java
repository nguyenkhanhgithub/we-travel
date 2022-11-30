package com.example.wetravel.Repository;

import com.example.wetravel.Entity.ReportFeedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReportFeedbackRepository extends JpaRepository<ReportFeedback , Long> {
    List<ReportFeedback> getAllByFeedbackId_FeedbackId(Long feedbackId);
}
