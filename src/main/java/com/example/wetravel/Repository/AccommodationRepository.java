package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation , Long> {
    @Query("select a from Accommodation a where a.serviceId.serviceId = :serviceId")
    Accommodation getByServiceId(Long serviceId);

    @Query("select a.accommodationType from Accommodation a where a.serviceId.serviceId = :serviceId ")
    String getTypeByServiceId(Long serviceId);
}
