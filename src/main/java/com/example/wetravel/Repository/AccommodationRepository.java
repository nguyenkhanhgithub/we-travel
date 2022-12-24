package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<Accommodation , Long> {
    @Query("select a from Accommodation a where a.serviceId.serviceId = :serviceId")
    Accommodation getByServiceId(Long serviceId);

    @Query("select a.accommodationType from Accommodation a where a.serviceId.serviceId = :serviceId ")
    String getTypeByServiceId(Long serviceId);

    @Query("select a.description from Accommodation a where a.serviceId.serviceId = :serviceId ")
    String getDescriptionByServiceId(Long serviceId);

    @Query(value = "select a.* from accommodation a join service s on a.service_id = s.service_id " +
            "where s.city like :city and s.is_block = 0" , nativeQuery = true)
    List<Accommodation> getListAccommodationByCity(String city);
}
