package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TourServiceOfSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourServiceOfScheduleRepository extends JpaRepository<TourServiceOfSchedule, Long> {
}
