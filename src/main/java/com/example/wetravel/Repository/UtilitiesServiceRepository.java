package com.example.wetravel.Repository;

import com.example.wetravel.Entity.UtilitiesService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UtilitiesServiceRepository extends JpaRepository<UtilitiesService , Long> {
    @Query("select u from UtilitiesService u where u.serviceId.serviceId = :serviceId")
    List<UtilitiesService>getListUtilitiesServiceByServiceId(Long serviceId);
}
