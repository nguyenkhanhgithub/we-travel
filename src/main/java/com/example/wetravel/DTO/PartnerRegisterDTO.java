package com.example.wetravel.DTO;

import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.CompanyPartner;
import com.example.wetravel.Entity.Partner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PartnerRegisterDTO {
//    private String email;
//
//    private String password;
//
//    private Integer roleId;
//
//    private String firstName;
//
//    private String lastName;
//
//    private String gender;
//
//    private String address;
//
//    private String birthDate;
//
//    private String phone;
//
//    private String emailContact;
//
//    private String position;
//
//    private String department;
//
//    private String numberIdCard;
//
//    private String placeIssue;
//
//    private String dateIssue;

    private Account accountInfor;

    private Partner partnerInfor;

    private CompanyPartner companyPartnerInfor;

}
