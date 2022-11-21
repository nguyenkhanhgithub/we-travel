package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.Login;
import com.example.wetravel.DTO.LoginResponse;
import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.DTO.UserDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public LoginResponse login(Login login) throws HandlerException {
        LoginResponse loginResponse = new LoginResponse();
        UserDTO userDTO;
        PartnerDTO partnerDTO;
        Account account = accountRepository.getAllByEmailAndPassWord(login.getEmail(), login.getPassword());
        if(account != null){
            if(!account.getIsActive()){
                throw new HandlerException("Account non active!");
            }else {
                userDTO = userRepository.getDetailUser(account.getAccountId());
                if (userDTO == null) {
                    partnerDTO = partnerRepository.getDetailPartner(account.getAccountId());
                    loginResponse.setInformation(partnerDTO);
                } else {
                    loginResponse.setInformation(userDTO);
                }
                return loginResponse;
            }
        }else{
            throw new HandlerException("Account not exist!");
        }
    }
}
