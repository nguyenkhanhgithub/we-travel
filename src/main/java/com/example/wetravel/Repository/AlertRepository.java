package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert , Long> {
    List<Alert> getAllByAccountId_AccountIdOrderByCreateDateDesc(Long accountId);

    Boolean existsAlertByAlertId(Long alertId);
}
