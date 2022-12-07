package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.*;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Repository.UserRepository;
import com.example.wetravel.Security.JwtUtil;
import com.example.wetravel.Service.ClientService;
import com.example.wetravel.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    MailService mailService;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public LoginResponse login(Login login) throws HandlerException {
        LoginResponse loginResponse = new LoginResponse();
        Account account = accountRepository.getAccountByEmail(login.getEmail());
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if (account != null && bcrypt.matches(login.getPassword(), account.getPassWord()) || account.getRoleId().getRoleId() == Constant.Role.Admin) {
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("accountId", account.getAccountId());
            claims.put("role", account.getRoleId());
            claims.put("email", account.getEmail());
            if (Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Customer)) {
                UserDTO userDTO = userRepository.getDetailUser(account.getAccountId());
                //String token = jwtUtil.generateToken(login.getEmail(), claims);
                loginResponse.setInformation(userDTO);
            } else if(Objects.equals(account.getRoleId().getRoleId(), Constant.Role.Partner)){
                PartnerDTO partnerDTO = partnerRepository.getDetailPartner(account.getAccountId());
                //String token = jwtUtil.generateToken(login.getEmail(), claims);
                loginResponse.setInformation(partnerDTO);
            } else {
                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setAccountId(account.getAccountId());
                loginResponse.setInformation(accountDTO);
            }
            return loginResponse;
        } else {
            throw new HandlerException("Wrong email or password!");
        }
    }

    @Override
    public String createMailInfor(String email , Integer roleId , Integer serviceCategoryId) throws HandlerException {
        try {
            DataMailDTO dataMail = new DataMailDTO();
            if(!accountRepository.existsAccountByEmail(email)){
                dataMail.setTo(email);
                dataMail.setSubject(Constant.Mail.SUBJECT_REGISTER);

                Map<String, Object> props = new HashMap<>();
                Map<String , Object> claims = new HashMap<>();
                claims.put("email", email);
                claims.put("role" , roleId);
                claims.put("serviceCategory" , serviceCategoryId);
                String token = jwtUtil.generateToken(email , claims);
                if(Objects.equals(roleId, Constant.Role.Customer)){
                    props.put("link", Constant.Server.LOCALHOST + "register-information-customer?token=" + token);
                }else if(Objects.equals(roleId, Constant.Role.Partner)){
                    props.put("link" ,Constant.Server.LOCALHOST + "register-information-partner?token=" + token);
                }
                dataMail.setProps(props);

                mailService.sendMail(dataMail, Constant.Mail.CLIENT_REGISTER);
                return token;
            }else{
                return Constant.Message.EMAIL_EXIST;
            }
        } catch (MessagingException e){
            throw new HandlerException(Constant.Message.SEND_MAIL_ERROR);
        }
    }

    @Override
    public String createMailForgotPassword(String email) throws HandlerException{
        try{
            DataMailDTO dataMail = new DataMailDTO();
            if(accountRepository.existsAccountByEmail(email)){
                Account account = accountRepository.findByEmail(email);
                account.setIsBlock(true);
                accountRepository.save(account);
                Map<String , Object> claims = new HashMap<>();
                claims.put("email" , email);
                String token = jwtUtil.generateToken(email , claims);
                dataMail.setTo(email);
                dataMail.setSubject(Constant.Mail.SUBJECT_FORGOT_PASSWORD);

                Map<String, Object> props = new HashMap<>();
                props.put("link", Constant.Server.LOCALHOST + "forgot-password?token=" + token + "&email="+ email);
                dataMail.setProps(props);

                mailService.sendMail(dataMail, Constant.Mail.CLIENT_REGISTER);
                return token;
            }else{
                return Constant.Message.EMAIL_EXIST;
            }
        }catch(MessagingException e){
            throw new HandlerException(Constant.Message.SEND_MAIL_ERROR);
        }
    }

    @Override
    public Boolean forgotPassword(String token , String newPassword) throws HandlerException {
        Map<String , Object> claims = jwtUtil.extractAllClaims(token);
        String email = claims.get("email").toString();
        if(!accountRepository.existsAccountByEmail(email)){
            throw new HandlerException(Constant.Message.EMAIL_NOT_EXIST);
        }
        Account account = accountRepository.findByEmail(email);
        String passwordEncode = passwordEncoder.encode(newPassword);
        account.setPassWord(passwordEncode);
        account.setIsBlock(false);
        accountRepository.save(account);
        return true;
    }

    @Override
    public Boolean changePassword(String email, String oldPassword, String newPassword) throws HandlerException {
        if(!accountRepository.existsAccountByEmail(email)){
            throw new HandlerException(Constant.Message.EMAIL_NOT_EXIST);
        }
        Account account = accountRepository.findByEmail(email);
        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        if(bcrypt.matches(oldPassword , account.getPassWord())){
            account.setPassWord(passwordEncoder.encode(newPassword));
            accountRepository.save(account);
        }
        return true;
    }
}
