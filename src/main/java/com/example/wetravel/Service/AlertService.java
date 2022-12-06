package com.example.wetravel.Service;

import com.example.wetravel.DTO.AlertDTO;
import com.example.wetravel.Exception.HandlerException;

import java.util.List;

public interface AlertService {
    AlertDTO createAlert(AlertDTO alertDTO) throws HandlerException;

    List<AlertDTO> getListAlertByAccountId(Long accountId) throws HandlerException;

    Boolean seenAlert(Long alertId) throws HandlerException;
}
