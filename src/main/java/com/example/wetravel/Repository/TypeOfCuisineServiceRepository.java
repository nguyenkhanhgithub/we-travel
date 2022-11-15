package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TypeOfCuisineService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeOfCuisineServiceRepository extends JpaRepository<TypeOfCuisineService , Long> {
    @Query("select t from TypeOfCuisineService t where t.restaurantId.restaurantId = :restaurantId")
    List<TypeOfCuisineService> getListTypeCuisineServiceByRestaurantId(Long restaurantId);
}
