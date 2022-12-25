package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Accommodation;
import com.example.wetravel.Entity.Entertainment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntertainmentRepository extends JpaRepository<Entertainment , Long> {
    @Query("select e from Entertainment e where e.serviceId.serviceId = :serviceId")
    Entertainment getEntertainmentByServiceId(Long serviceId);

    @Query("select e.entertainmentType from Entertainment e where e.serviceId.serviceId = :serviceId")
    String getTypeByServiceId(Long serviceId);

    @Query("select e.description from Entertainment e where e.serviceId.serviceId = :serviceId")
    String getDescriptionByServiceId(Long serviceId);

    @Query(value = "select e.* from entertainment e join service s on e.service_id = s.service_id " +
            "where s.city like :city and s.is_block = 0" , nativeQuery = true)
    List<Entertainment> getListEntertainmentByCity(String city);
}
