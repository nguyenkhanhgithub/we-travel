package com.example.wetravel.Repository;

import com.example.wetravel.DTO.Login;
import com.example.wetravel.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account , Long> {
        Account getAllByEmailAndPassWord(String email , String password);

//        @Query(value = "select * from Account where email = :email" , nativeQuery = true)
//        Account checkAccountExist(String email);

        Account findByEmail(String mail);

        Boolean existsAccountByEmail(String email);
}
