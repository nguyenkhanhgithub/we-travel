package com.example.wetravel.Repository;

import com.example.wetravel.Entity.TourCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourCategoryRepository extends JpaRepository<TourCategory , Long> {
}
