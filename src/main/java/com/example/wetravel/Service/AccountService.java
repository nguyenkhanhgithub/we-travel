package com.example.wetravel.Service;


import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.PartnerRegisterDTO;

public interface AccountService {
    Boolean registerCustomerAccount(CustomerRegisterDTO customerRegisterDTO);

    Boolean registerPartnerAccount(PartnerRegisterDTO partnerRegisterDTO);

    Boolean changePassWord(Login login);

    Boolean blockAccount(Long accountId);

    Boolean activeAccount(Long accountId);
}
