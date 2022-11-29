package com.example.wetravel.Repository;

import com.example.wetravel.Entity.RequestCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCancelRepository extends JpaRepository<RequestCancel , Long> {
    Boolean existsRequestCancelByRequestCancelId(Long requestCancelId);
}
