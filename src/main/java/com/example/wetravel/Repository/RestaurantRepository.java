package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Accommodation;
import com.example.wetravel.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {
    @Query("select r from Restaurant r where r.serviceId.serviceId = :serviceId")
    Restaurant getRestaurantByServiceId(Long serviceId);

    @Query("select r.restaurantServiceType from Restaurant r where r.serviceId.serviceId = :serviceId")
    String getTypeByServiceId(Long serviceId);

    @Query("select r.description from Restaurant r where r.serviceId.serviceId = :serviceId")
    String getDescriptionByServiceId(Long serviceId);

    @Query(value = "select r.* from restaurant r join service s on r.service_id = s.service_id " +
            "where s.city like :city and s.is_block = 0" , nativeQuery = true)
    List<Restaurant> getListRestaurantByCity(String city);
}
