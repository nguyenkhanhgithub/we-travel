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
    Boolean existsByAccountId_AccountId(Long accountId);

//    @Query(value = "SELECT ub.userBookingId as userBookingId , ub.tourId.tourId as tourId , ub.tourId.tourName as tourName , " +
//            "ub.startDate as startDate , ub.numberOfAdult as adultPeople , ub.numberOfChildren as childrenPeople," +
//            "ub.tourId.tourType as tourType , ub.status as status , ub.statusDeposit as statusDeposit , ub.totalPrice as totalPrice ," +
//            "ub.tourId.deposit as deposit FROM UserBooking ub where ub.accountId.accountId = :accountId")
//    List<Object> getListBookingByAccountId(Long accountId);

    @Query(value = "SELECT ub FROM UserBooking ub where (ub.accountId.accountId = -1 or ub.accountId.accountId = :accountId) " +
            "and (ub.tourId.tourId = -1 or ub.tourId.tourId = :tourId) and (ub.startDate = :defaultDate or ub.startDate = :startDate)")
    Page<UserBooking> getListBookingByAccountId(Long accountId , Long tourId , LocalDate startDate , LocalDate defaultDate , Pageable pageable);
}
