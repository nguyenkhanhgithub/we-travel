package com.example.wetravel.Repository;

import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.Entity.Partner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {
    Partner getPartnerByAccountId_AccountId(Long accountId);
    Boolean existsByAccountId_AccountId(Long accountId);
    @Query(value = "SELECT p.* FROM partner p join account a on p.account_id = a.account_id where a.email like :email" , nativeQuery = true)
    Partner getPartnerByAccountEmail(String email);

    @Query(value = "SELECT p.accountId.accountId as accountId , p.accountId.isBlock as isBlock ,p.accountId.email as email , p.firstName as firstName , p.lastName as lastName , p.gender as gender , p.city as cityContact , p.address as addressContact ," +
            "p.birthDate as birthDate , p.phone as phone , p.email as emailContact , p.department as department , p.position as position ," +
            "p.numberIdCard as numberIdCard , p.dateIssue as dateIssue , p.placeIssue as placeIssue  , cp.companyName as companyName , " +
            "cp.shortName as shortName , cp.fax as fax , cp.phone as phoneCompany , cp.taxCode as taxCode , cp.email as emailContactCompany , cp.address as addressCompany," +
            "cp.city as cityCompany , cp.website as website , cp.businessCode as businessLicenseCode , cp.incorporationDate as incorporationDate , " +
            "cp.registrationDate as registrationDate , p.accountId.roleId.roleId as roleId , p.serviceCategoryId.serviceCategoryId as serviceCategory " +
            " FROM Partner p join CompanyPartner cp on p.companyPartnerId.companyPartnerId = cp.companyPartnerId WHERE (:emailPartner like %:all% or p.email like %:emailPartner%) " +
            "and (-1 = :isBlock or p.accountId.isBlock = :isBlock) and (:serviceCategoryId = -1 or p.serviceCategoryId.serviceCategoryId = :serviceCategoryId)")
    Page<PartnerDTO> getAllPartner(@Param("emailPartner") String emailPartner ,@Param("all") String all , @Param("isBlock") Integer isBlock ,@Param("serviceCategoryId") Integer serviceCategoryId , Pageable pageable);
    @Query(value = "SELECT p.accountId.accountId as accountId , p.accountId.isBlock as isBlock ,p.accountId.email as email, p.firstName as firstName , p.lastName as lastName , p.gender as gender , p.city as cityContact , p.address as addressContact ," +
            "p.birthDate as birthDate , p.phone as phone , p.email as emailContact , p.department as department , p.position as position ," +
            "p.numberIdCard as numberIdCard , p.dateIssue as dateIssue , p.placeIssue as placeIssue  , cp.companyName as companyName , " +
            "cp.shortName as shortName , cp.fax as fax , cp.phone as phoneCompany , cp.taxCode as taxCode , cp.email as emailContactCompany , cp.address as addressCompany," +
            "cp.city as cityCompany , cp.website as website , cp.businessCode as businessLicenseCode , cp.incorporationDate as incorporationDate , " +
            "cp.registrationDate as registrationDate , p.accountId.roleId.roleId as roleId , p.serviceCategoryId.serviceCategoryId as serviceCategory " +
            " FROM Partner p join CompanyPartner cp on p.companyPartnerId.companyPartnerId = cp.companyPartnerId where p.accountId.accountId = :accountId" )
    PartnerDTO getDetailPartner(Long accountId);

}
