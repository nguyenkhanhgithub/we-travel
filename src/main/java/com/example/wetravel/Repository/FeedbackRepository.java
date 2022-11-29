package com.example.wetravel.Repository;

import com.example.wetravel.DTO.FeedbackDTO;
import com.example.wetravel.Entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
    List<Feedback> getAllByTourId_TourId(Long tourId);

    Boolean existsFeedbackByFeedbackId(Long feedbackId);
}
