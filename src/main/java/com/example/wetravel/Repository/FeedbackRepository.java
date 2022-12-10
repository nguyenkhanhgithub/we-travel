package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Feedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback , Long> {
    @Query(value = "SELECT * FROM feedback where (-1 = :isBlock or is_block = :isBlock) and (tour_id = :tourId or -1 = :tourId)" +
            " and (user_booking_id = :bookingId or -1 = :bookingId) order by create_date desc" , nativeQuery = true)
    List<Feedback> getAllByTourId(Long tourId , Long bookingId , Integer isBlock);

    @Query(value = "select distinct f.* from feedback f right join report_feedback rf on f.feedback_id = rf.feedback_id order by create_date desc" , nativeQuery = true)
    List<Feedback> getListFeedbackContainReport();
    Boolean existsFeedbackByFeedbackId(Long feedbackId);
}
