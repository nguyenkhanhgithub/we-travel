package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.CustomerRegisterDTO;
import com.example.wetravel.DTO.PartnerRegisterDTO;
import com.example.wetravel.DTO.UserBookingDTO;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Security.JwtUtil;
import com.example.wetravel.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    CompanyPartnerRepository companyPartnerRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    UserBookingRepository userBookingRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public Boolean registerCustomerAccount(CustomerRegisterDTO customerRegisterDTO) throws HandlerException{
        Map<String , Object> claims = jwtUtil.extractAllClaims(customerRegisterDTO.getToken());
        String email = claims.get("email").toString();
        Integer roleId = (Integer) claims.get("role");
        if(!accountRepository.existsAccountByEmail(email)){
            Role role = roleRepository.getOne(roleId);
            Account account = new Account();
            account.setEmail(email);
            String passwordEncode = passwordEncoder.encode(customerRegisterDTO.getPassword());
            account.setPassWord(passwordEncode);
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
            throw new HandlerException(Constant.Message.EMAIL_EXIST);
        }
    }

    @Override
    public Boolean registerPartnerAccount(PartnerRegisterDTO partnerRegisterDTO) throws HandlerException{
        Map<String , Object> claims = jwtUtil.extractAllClaims(partnerRegisterDTO.getToken());
        String email = claims.get("email").toString();
        Integer roleId = (Integer) claims.get("role");
        Integer serviceCategoryId = (Integer) claims.get("serviceCategory");
        if(accountRepository.findByEmail(email) == null){
            Role role = roleRepository.getOne(roleId);
            Account account = new Account();
            account.setEmail(email);
            String passwordEncode = passwordEncoder.encode(partnerRegisterDTO.getAccountInfor().getPassWord());
            account.setPassWord(passwordEncode);
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
            ServiceCategory serviceCategory = serviceCategoryRepository.getOne(Long.valueOf(serviceCategoryId));
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
            companyPartner.setPartnerId(partner);
            companyPartnerRepository.save(companyPartner);
            return true;
        }else{
            throw new HandlerException(Constant.Message.EMAIL_EXIST);
        }
    }

    @Override
    public Boolean editProfileCustomer(Long accountId , CustomerRegisterDTO customerRegisterDTO) throws HandlerException {
        User user = userRepository.getByAccountId_AccountId(accountId);
        user.setFirstName(customerRegisterDTO.getFirstName());
        user.setLastName(customerRegisterDTO.getLastName());
        user.setGender(customerRegisterDTO.getGender());
        user.setPhone(customerRegisterDTO.getPhone());
        user.setBirthDate(customerRegisterDTO.getBirthDate());
        user.setCity(customerRegisterDTO.getCity());
        user.setIsPrivate(customerRegisterDTO.getIsPrivate());
        userRepository.save(user);
        return true;
    }

    @Override
    public Boolean editProfilePartner(Long accountId , PartnerRegisterDTO partnerRegisterDTO) throws HandlerException {
        Partner partner = partnerRepository.getPartnerByAccountId_AccountId(accountId);
        partner.setFirstName(partnerRegisterDTO.getPartnerInfor().getFirstName());
        partner.setLastName(partnerRegisterDTO.getPartnerInfor().getLastName());
        partner.setGender(partnerRegisterDTO.getPartnerInfor().getGender());
        partner.setPhone(partnerRegisterDTO.getPartnerInfor().getPhone());
        partner.setEmail(partnerRegisterDTO.getPartnerInfor().getEmail());
        partner.setBirthDate(partnerRegisterDTO.getPartnerInfor().getBirthDate());
        partner.setCity(partnerRegisterDTO.getPartnerInfor().getCity());
        partner.setAddress(partnerRegisterDTO.getPartnerInfor().getAddress());
        partner.setNumberIdCard(partnerRegisterDTO.getPartnerInfor().getNumberIdCard());
        partner.setDateIssue(partnerRegisterDTO.getPartnerInfor().getDateIssue());
        partner.setPlaceIssue(partnerRegisterDTO.getPartnerInfor().getPlaceIssue());
        partner.setDepartment(partnerRegisterDTO.getPartnerInfor().getDepartment());
        partner.setPosition(partnerRegisterDTO.getPartnerInfor().getPosition());
        partnerRepository.save(partner);

        CompanyPartner companyPartner = companyPartnerRepository.getByPartnerId_PartnerId(partner.getPartnerId());
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
        companyPartnerRepository.save(companyPartner);
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
        List<UserBooking> userBookingList = userBookingRepository.getAllByAccountId_AccountId(accountId);
        if(!userBookingList.isEmpty()){
            for (UserBooking u : userBookingList){
                u.setStatus(Constant.StatusBooking.CANCEL);
                userBookingRepository.save(u);
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
