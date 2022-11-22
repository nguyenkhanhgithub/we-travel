package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.PartnerRegisterDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.BadRequestException;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CompanyPartnerRepository companyPartnerRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public Boolean registerCustomerAccount(CustomerRegisterDTO customerRegisterDTO) throws HandlerException{
        if(accountRepository.findByEmail(customerRegisterDTO.getEmail()) == null){
            Role role = roleRepository.getOne(customerRegisterDTO.getRoleId());
            Account account = new Account();
            account.setEmail(customerRegisterDTO.getEmail());
            account.setPassWord(customerRegisterDTO.getPassword());
            account.setIsActive(true);
            account.setIsBlock(false);
            account.setRoleId(role);
            User user = new User();
            user.setFirstName(customerRegisterDTO.getFirstName());
            user.setLastName(customerRegisterDTO.getLastName());
            user.setGender(customerRegisterDTO.getGender());
            user.setAddress(customerRegisterDTO.getAddress());
            user.setCity(customerRegisterDTO.getCity());
            user.setBirthDate(customerRegisterDTO.getBirthDate());
            user.setPhone(customerRegisterDTO.getPhone());
            user.setIsPrivate(customerRegisterDTO.getIsPrivate());
            user.setRankPoint(0);
            user.setAccountId(account);
            userRepository.save(user);
            return true;
        }else{
            throw new HandlerException("Email exist");
        }
    }

    @Override
    public Boolean registerPartnerAccount(PartnerRegisterDTO partnerRegisterDTO) throws HandlerException{
        if(accountRepository.findByEmail(partnerRegisterDTO.getAccountInfor().getEmail()) == null){
            Role role = roleRepository.getOne(partnerRegisterDTO.getAccountInfor().getRoleId().getRoleId());
            Account account = new Account();
            account.setEmail(partnerRegisterDTO.getAccountInfor().getEmail());
            account.setPassWord(partnerRegisterDTO.getAccountInfor().getPassWord());
            account.setIsActive(true);
            account.setIsBlock(false);
            account.setRoleId(role);
            Partner partner = new Partner();
            partner.setFirstName(partnerRegisterDTO.getPartnerInfor().getFirstName());
            partner.setLastName(partnerRegisterDTO.getPartnerInfor().getLastName());
            partner.setGender(partnerRegisterDTO.getPartnerInfor().getGender());
            partner.setAddress(partnerRegisterDTO.getPartnerInfor().getAddress());
            partner.setPhone(partnerRegisterDTO.getPartnerInfor().getPhone());
            partner.setCity(partnerRegisterDTO.getPartnerInfor().getCity());
            partner.setBirthDate(partnerRegisterDTO.getPartnerInfor().getBirthDate());
            partner.setEmail(partnerRegisterDTO.getPartnerInfor().getEmail());
            partner.setPosition(partnerRegisterDTO.getPartnerInfor().getPosition());
            partner.setDepartment(partnerRegisterDTO.getPartnerInfor().getDepartment());
            partner.setNumberIdCard(partnerRegisterDTO.getPartnerInfor().getNumberIdCard());
            partner.setDateIssue(partnerRegisterDTO.getPartnerInfor().getDateIssue());
            partner.setPlaceIssue(partnerRegisterDTO.getPartnerInfor().getPlaceIssue());
            ServiceCategory serviceCategory = serviceCategoryRepository.getOne(partnerRegisterDTO.
                    getPartnerInfor().getServiceCategoryId().getServiceCategoryId());
            partner.setServiceCategoryId(serviceCategory);
            partner.setAccountId(account);
            CompanyPartner companyPartner = new CompanyPartner();
            companyPartner.setCompanyName(partnerRegisterDTO.getCompanyPartnerInfor().getCompanyName());
            companyPartner.setShortName(partnerRegisterDTO.getCompanyPartnerInfor().getShortName());
            companyPartner.setAddress(partnerRegisterDTO.getCompanyPartnerInfor().getAddress());
            companyPartner.setCity(partnerRegisterDTO.getCompanyPartnerInfor().getCity());
            companyPartner.setEmail(partnerRegisterDTO.getCompanyPartnerInfor().getEmail());
            companyPartner.setFax(partnerRegisterDTO.getCompanyPartnerInfor().getFax());
            companyPartner.setPhone(partnerRegisterDTO.getCompanyPartnerInfor().getPhone());
            companyPartner.setTaxCode(partnerRegisterDTO.getCompanyPartnerInfor().getTaxCode());
            companyPartner.setWebsite(partnerRegisterDTO.getCompanyPartnerInfor().getWebsite());
            companyPartner.setBusinessCode(partnerRegisterDTO.getCompanyPartnerInfor().getBusinessCode());
            companyPartner.setRegistrationDate(partnerRegisterDTO.getCompanyPartnerInfor().getRegistrationDate());
            companyPartner.setIncorporationDate(partnerRegisterDTO.getCompanyPartnerInfor().getIncorporationDate());
            companyPartner.setPartner(partner);
            companyPartnerRepository.save(companyPartner);
            return true;
        }else{
            throw new HandlerException("Email exist!");
        }
    }

    @Override
    public Boolean changePassWord(Login login) {
        Account account = accountRepository.findByEmail(login.getEmail());
        account.setPassWord(login.getPassword());
        account.setIsActive(true);
        accountRepository.save(account);
        return true;
    }

    @Override
    public Boolean blockAccount(Long accountId) {
        Account account = accountRepository.getById(accountId);
        account.setIsBlock(true);
        accountRepository.save(account);
        List<com.example.wetravel.Entity.Service> serviceList = serviceRepository.getListServiceByAccountPartner(accountId);
        if(!serviceList.isEmpty()){
            for (com.example.wetravel.Entity.Service s : serviceList){
                s.setIsBlock(true);
                serviceRepository.save(s);
            }
        }
        return true;
    }

    @Override
    public Boolean activeAccount(Long accountId) {
        Account account = accountRepository.getById(accountId);
        account.setIsBlock(false);
        accountRepository.save(account);
        List<com.example.wetravel.Entity.Service> serviceList = serviceRepository.getListServiceByAccountPartner(accountId);
        if(!serviceList.isEmpty()){
            for (com.example.wetravel.Entity.Service s : serviceList){
                s.setIsBlock(false);
                serviceRepository.save(s);
            }
        }
        return true;
    }
}
