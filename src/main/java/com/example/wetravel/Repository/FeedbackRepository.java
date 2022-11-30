package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
    @Query(value = "SELECT * FROM feedback where (-1 = :isBlock or is_block = :isBlock) and tour_id = :tourId" , nativeQuery = true)
    Page<Feedback> getAllByTourId(Long tourId , Integer isBlock , Pageable pageable);

    @Query(value = "select * from feedback" , nativeQuery = true)
    Page<Feedback> getListFeedback(Pageable pageable);

    Boolean existsFeedbackByFeedbackId(Long feedbackId);
}
