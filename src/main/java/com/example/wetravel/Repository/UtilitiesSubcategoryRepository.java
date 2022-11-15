package com.example.wetravel.Repository;

import com.example.wetravel.Entity.UtilitiesSubcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilitiesSubcategoryRepository extends JpaRepository<UtilitiesSubcategory , Long> {
    UtilitiesSubcategory findByUtilitiesSubcategoryId(Long utilitiesSubcategoryId);
}
