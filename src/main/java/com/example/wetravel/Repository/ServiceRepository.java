package com.example.wetravel.Repository;

import com.example.wetravel.Entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    boolean existsAllByServiceName(String serviceName);

    @Query(value = "select s.* from service s join partner p on s.partner_id = p.partner_id join \n" +
            "account a on p.account_id = a.account_id where (a.email like :emailPartner or \"all\" like :emailPartner) \n" +
            "and (s.service_category_id = :serviceCategoryId or 0 = :serviceCategoryId) and " +
            "(s.is_active = :isActive or -1 = :isActive) and (s.is_block = :isBlock or -1 = :isBlock)" +
            " and (s.status = :status or -1 = :status)" , nativeQuery = true)
    List<Service> getListServiceByCondition(String emailPartner , Long serviceCategoryId , Integer isActive , Integer isBlock , Integer status);

    @Query(value = "select s from Service s join Partner p on s.partnerId.partnerId = p.partnerId join \n" +
            "Account a on p.accountId.accountId = a.accountId where p.partnerId = :partnerId")
    Page<Service> getListServiceByPartnerId(Long partnerId , Pageable pageable);

    @Query(value = "SELECT s.* FROM service s join partner p on s.partner_id = p.partner_id where p.account_id = :accountId",nativeQuery = true)
    List<Service> getListServiceByAccountPartner(Long accountId);
}
