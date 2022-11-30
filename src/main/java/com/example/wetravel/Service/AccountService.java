package com.example.wetravel.Service;


import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.PartnerRegisterDTO;
import com.example.wetravel.Exception.HandlerException;

public interface AccountService {
    Boolean registerCustomerAccount(CustomerRegisterDTO customerRegisterDTO) throws HandlerException;

    Boolean registerPartnerAccount(PartnerRegisterDTO partnerRegisterDTO) throws HandlerException;

    Boolean editProfileCustomer(Long accountId , CustomerRegisterDTO customerRegisterDTO) throws HandlerException;

    Boolean editProfilePartner(Long accountId , PartnerRegisterDTO partnerRegisterDTO) throws HandlerException;

    Boolean blockAccount(Long accountId);

    Boolean activeAccount(Long accountId);
}
