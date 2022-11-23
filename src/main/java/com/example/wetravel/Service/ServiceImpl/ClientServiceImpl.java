package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.DataMailDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Security.JwtUtil;
import com.example.wetravel.Service.ClientService;
import com.example.wetravel.Service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public String createMailInfor(String email , Integer roleId , Integer serviceCategoryId) throws HandlerException {
        //validate thông tin trước khi gửi thông tin cho người dùng
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
                return "Email not exist!";
            }
        } catch (MessagingException e){
            throw new HandlerException("Send email Error!");
        }
    }

    @Override
    public String createMailForgotPassword(String email) throws HandlerException{
        try{
            DataMailDTO dataMail = new DataMailDTO();
            if(accountRepository.existsAccountByEmail(email)){
                Account account = accountRepository.findByEmail(email);
                account.setIsActive(false);
                accountRepository.save(account);
                Map<String , Object> claims = new HashMap<>();
                claims.put("email" , email);
                String token = jwtUtil.generateToken(email , claims);
                dataMail.setTo(email);
                dataMail.setSubject(Constant.Mail.SUBJECT_FORGOT_PASSWORD);

                Map<String, Object> props = new HashMap<>();
                props.put("link", Constant.Server.LOCALHOST + "change-password?token=" + token);
                dataMail.setProps(props);

                mailService.sendMail(dataMail, Constant.Mail.CLIENT_REGISTER);
                return token;
            }else{
                return "Email not exist!";
            }
        }catch(MessagingException e){
            throw new HandlerException("Server Error!");
        }
    }
}
