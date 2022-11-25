package com.example.wetravel.Repository;


import com.example.wetravel.DTO.UserDTO;
import com.example.wetravel.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User getByAccountId_AccountId(Long accountId);
    Boolean existsByAccountId_AccountId(Long accountId);
    @Query(value = "SELECT u.accountId.accountId as accountId , u.accountId.isBlock as isBlock , u.accountId.email as email , u.firstName as firstName , u.lastName as lastName , u.gender as gender ," +
            " u.address as address , u.city as city , u.birthDate as birthDate , u.phone as phone ," +
            " u.rankPoint as rankPoint , u.accountId.roleId.roleId as roleId FROM User u")
    Page<UserDTO> getListUser(Pageable pageable);

    @Query(value = "SELECT u.accountId.accountId as accountId , u.accountId.isBlock as isBlock , u.accountId.email as email, u.firstName as firstName " +
            ", u.lastName as lastName , u.gender as gender ,u.address as address , u.city as city , u.birthDate as birthDate , u.phone as phone ," +
            " u.rankPoint as rankPoint , u.accountId.roleId.roleId as roleId FROM User u WHERE u.accountId.accountId = :accountId")
    UserDTO getDetailUser(Long accountId);

}
