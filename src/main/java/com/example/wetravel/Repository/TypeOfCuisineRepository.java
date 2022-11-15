package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TypeOfCuisine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfCuisineRepository extends JpaRepository<TypeOfCuisine , Long> {
}
