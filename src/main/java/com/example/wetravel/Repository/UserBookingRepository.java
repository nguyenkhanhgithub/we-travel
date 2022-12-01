package com.example.wetravel.Repository;

import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.UserBooking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserBookingRepository extends JpaRepository<UserBooking , Long> {
    List<UserBooking> getAllByAccountId_AccountId(Long accountId);
    Boolean existsByAccountId_AccountId(Long accountId);
    @Query(value = "SELECT * FROM user_booking where (:accountId = -1 or account_id = :accountId) " +
            "and (:tourId = -1 or tour_id = :tourId) and (:startDate = \"0000-00-00\" or start_date = :startDate)" , nativeQuery = true)
    Page<UserBooking> getListBooking(Long accountId , Long tourId , String startDate , Pageable pageable);

    @Query(value = "SELECT ub.* FROM user_booking ub join tour t on ub.account_id = t.account_id where t.tour_id = :tourId", nativeQuery = true)
    List<UserBooking> getBookingOfTourPrivateByTourId(Long tourId);
}
