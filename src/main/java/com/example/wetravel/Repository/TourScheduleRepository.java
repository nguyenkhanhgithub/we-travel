package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TourSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourScheduleRepository extends JpaRepository<TourSchedule , Long> {
    @Query(value = "SELECT * FROM tour_schedule where tour_id = :tourId" , nativeQuery = true)
    List<TourSchedule> getByTourId(Long tourId);
}
