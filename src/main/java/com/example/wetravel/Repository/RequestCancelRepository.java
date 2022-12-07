package com.example.wetravel.Repository;

import com.example.wetravel.Entity.RequestCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestCancelRepository extends JpaRepository<RequestCancel , Long> {
    Boolean existsRequestCancelByUserBookingId_UserBookingId(Long bookingId);

    RequestCancel getRequestCancelByUserBookingId_UserBookingId(Long bookingId);

    @Query(value = "SELECT rc.* FROM request_cancel rc join user_booking ub on rc.user_booking_id = ub.user_booking_id \n" +
            "join account a on ub.account_id = a.account_id where (a.email like :email or \"all\" like :email) " , nativeQuery = true)
    List<RequestCancel> getListRequestCancel(String email);
}
