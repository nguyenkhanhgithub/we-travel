package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant , Long> {
    @Query("select r from Restaurant r where r.serviceId.serviceId = :serviceId")
    Restaurant getRestaurantByServiceId(Long serviceId);

    @Query("select r.restaurantServiceType from Restaurant r where r.serviceId.serviceId = :serviceId")
    String getTypeByServiceId(Long serviceId);
}
