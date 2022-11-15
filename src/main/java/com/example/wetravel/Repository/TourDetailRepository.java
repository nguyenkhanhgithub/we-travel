package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TourDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TourDetailRepository extends JpaRepository<TourDetail , Long> {
    @Query(value = "SELECT * FROM tour_detail where tour_id = :tourId" , nativeQuery = true)
    TourDetail getByTourId(Long tourId);
}
