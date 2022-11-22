package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntertainmentRepository extends JpaRepository<Entertainment , Long> {
    @Query("select e from Entertainment e where e.serviceId.serviceId = :serviceId")
    Entertainment getEntertainmentByServiceId(Long serviceId);

    @Query("select e.entertainmentType from Entertainment e where e.serviceId.serviceId = :serviceId")
    String getTypeByServiceId(Long serviceId);
}
