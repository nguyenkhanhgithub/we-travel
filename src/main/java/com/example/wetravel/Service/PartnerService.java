package com.example.wetravel.Service;

import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

public interface PartnerService {
    Page<PartnerDTO> getListPartner(String emailPartner , Integer serviceCategoryId , Integer isBlock ,Integer page , Integer size) throws HandlerException;

    PartnerDTO getDetailPartner(Long accountId) throws HandlerException;
}
