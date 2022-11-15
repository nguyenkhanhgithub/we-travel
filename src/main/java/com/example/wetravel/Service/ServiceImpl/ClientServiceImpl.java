package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.DataMailDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Repository.AccountRepository;
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

    @Override
    public Boolean createMailInfor(String email , Integer roleId , Integer serviceCategoryId) {
        //validate thông tin trước khi gửi thông tin cho người dùng
        try {
            DataMailDTO dataMail = new DataMailDTO();
            if(!accountRepository.existsAccountByEmail(email)){
                dataMail.setTo(email);
                dataMail.setSubject(Constant.Mail.SUBJECT_REGISTER);

                Map<String, Object> props = new HashMap<>();
                if(Objects.equals(roleId, Constant.Role.Customer)){
                    props.put("link", Constant.Server.LOCALHOST + "register-information-customer?email=" + email);
                }else if(Objects.equals(roleId, Constant.Role.Partner)){
                    props.put("link" ,Constant.Server.LOCALHOST + "register-information-partner?email=" + email + "&serviceCategoryId=" + serviceCategoryId);
                }
                dataMail.setProps(props);

                mailService.sendMail(dataMail, Constant.Mail.CLIENT_REGISTER);
                return true;
            }else{
                return false;
            }
        } catch (MessagingException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Boolean createMailForgotPassword(String email) {
        try{
            DataMailDTO dataMail = new DataMailDTO();
            if(accountRepository.existsAccountByEmail(email)){
                Account account = accountRepository.findByEmail(email);
                account.setIsActive(false);
                accountRepository.save(account);
                dataMail.setTo(email);
                dataMail.setSubject(Constant.Mail.SUBJECT_FORGOT_PASSWORD);

                Map<String, Object> props = new HashMap<>();
                props.put("link", Constant.Server.LOCALHOST + "change-password?email=" + email);
                dataMail.setProps(props);

                mailService.sendMail(dataMail, Constant.Mail.CLIENT_REGISTER);
                return true;
            }else{
                return false;
            }
        }catch(MessagingException e){
            e.printStackTrace();
        }
        return null;
    }
}
