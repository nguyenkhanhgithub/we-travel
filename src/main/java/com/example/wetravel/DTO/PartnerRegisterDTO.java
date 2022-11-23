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
    private String token;//bao gồm email , role , serviceCategory

    private Account accountInfor;

    private Partner partnerInfor;

    private CompanyPartner companyPartnerInfor;

}
