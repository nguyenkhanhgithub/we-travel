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
import com.example.wetravel.Security.JwtUtil;
import com.example.wetravel.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public LoginResponse login(Login login) throws HandlerException {
        LoginResponse loginResponse = new LoginResponse();
        PartnerDTO partnerDTO;
        Account account = accountRepository.getAccountByEmail(login.getEmail());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (account != null && bcrypt.matches(login.getPassword(), account.getPassWord())) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("accountId", account.getAccountId());
            claims.put("role", account.getRoleId());
            claims.put("email", account.getEmail());
            if (userRepository.existsByAccountId_AccountId(account.getAccountId())) {
                UserDTO userDTO = userRepository.getDetailUser(account.getAccountId());
                //String token = jwtUtil.generateToken(login.getEmail(), claims);
                loginResponse.setInformation(userDTO);
            } else {
                partnerDTO = partnerRepository.getDetailPartner(account.getAccountId());
                //String token = jwtUtil.generateToken(login.getEmail(), claims);
                loginResponse.setInformation(partnerDTO);
            }
            return loginResponse;
        } else {
            throw new HandlerException("Wrong email or password!");
        }
    }
}
