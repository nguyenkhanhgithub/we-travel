package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.AlertDTO;
import com.example.wetravel.Entity.Account;
import com.example.wetravel.Entity.Alert;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.AccountRepository;
import com.example.wetravel.Repository.AlertRepository;
import com.example.wetravel.Service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AlertRepository alertRepository;

    @Override
    public AlertDTO createAlert(AlertDTO alertDTO) throws HandlerException {
        Alert alert = new Alert();
        Account account = accountRepository.getById(alertDTO.getAccountId());
        alert.setAccountId(account);
        alert.setTitle(alertDTO.getTitle());
        alert.setContent(alertDTO.getContent());
        alert.setStatus(false);
        LocalDateTime timeCreate = LocalDateTime.now();
        alert.setCreateDate(timeCreate);
        alertRepository.save(alert);
        alertDTO.setStatus(false);
        alertDTO.setTimeCreate(timeCreate);
        return alertDTO;
    }

    @Override
    public List<AlertDTO> getListAlertByAccountId(Long accountId) throws HandlerException {
        List<Alert> alertList = alertRepository.getAllByAccountId_AccountIdOrderByCreateDateDesc(accountId);
        if(alertList.isEmpty()){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        List<AlertDTO> alertDTOList = new ArrayList<>();
        for (Alert a : alertList){
            AlertDTO alertDTO = new AlertDTO();
            alertDTO.setAlertId(a.getAlertId());
            alertDTO.setAccountId(a.getAccountId().getAccountId());
            alertDTO.setTitle(a.getTitle());
            alertDTO.setContent(a.getContent());
            alertDTO.setStatus(a.getStatus());
            alertDTO.setTimeCreate(a.getCreateDate());
            alertDTOList.add(alertDTO);
        }
        return alertDTOList;
    }

    @Override
    public Boolean seenAlert(Long alertId) throws HandlerException {
        if(!alertRepository.existsAlertByAlertId(alertId)){
            throw new HandlerException(Constant.Message.NOT_FOUND);
        }
        Alert alert = alertRepository.getById(alertId);
        alert.setStatus(true);
        alertRepository.save(alert);
        return true;
    }
}
