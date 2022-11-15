package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TagOfTour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagOfTourRepository extends JpaRepository<TagOfTour , Long> {
    @Query(value = "SELECT * FROM tag_of_tour where tour_detail_id = :tourDetailId" , nativeQuery = true)
    List<TagOfTour> getByTourDetailId(Long tourDetailId);
}
