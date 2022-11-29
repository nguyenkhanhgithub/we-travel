package com.example.wetravel.Repository;

import com.example.wetravel.Entity.ReasonCancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReasonCancelRepository extends JpaRepository<ReasonCancel , Long> {
}
