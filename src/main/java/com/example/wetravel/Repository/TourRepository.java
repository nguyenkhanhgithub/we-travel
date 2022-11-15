package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Tour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<Tour , Long> {
    @Query(value = "SELECT * FROM tour where (tour_name like %:tourName% or \"all\" like %:tourName%) and (tour_category_id in :tourCategoryList or -1 in :tourCategoryList)" +
            " and (tour_type = :tourType or -1 = :tourType) and (status = :status or -1 = :status) and ((adult_price between :fromPrice and :toPrice) or (-1 = :fromPrice and -1 = :toPrice))" , nativeQuery = true)
    Page<Tour> getListTour(String tourName , List<Integer> tourCategoryList , Integer tourType , Integer status ,Integer fromPrice, Integer toPrice , Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM tour where (tour_name like %:tourName% or \"all\" like %:tourName%) and (tour_category_id in :tourCategoryList or -1 in :tourCategoryList)" +
            " and (tour_type = :tourType or -1 = :tourType) and (status = :status or -1 = :status) and ((adult_price between :fromPrice and :toPrice) or (-1 = :fromPrice and -1 = :toPrice))" , nativeQuery = true)
    Integer countListTour(String tourName , List<Integer> tourCategoryList , Integer tourType , Integer status ,Integer fromPrice ,Integer toPrice);
}
