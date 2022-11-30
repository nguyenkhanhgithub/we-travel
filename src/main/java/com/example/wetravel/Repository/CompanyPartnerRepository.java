package com.example.wetravel.Repository;

import com.example.wetravel.Entity.CompanyPartner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyPartnerRepository extends JpaRepository<CompanyPartner , Long> {
    CompanyPartner getByPartnerId_PartnerId(Long partnerId);
}
