package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.PartnerDTO;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.PartnerRepository;
import com.example.wetravel.Service.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PartnerServiceImpl implements PartnerService {

    @Autowired
    PartnerRepository partnerRepository;

    @Override
    public Page<PartnerDTO> getListPartner(String emailPartner , Integer serviceCategoryId , Integer isActive , Integer isBlock , Integer page , Integer size) throws HandlerException {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<PartnerDTO> partnerList = partnerRepository.getAllPartner(emailPartner ,"all", isActive , isBlock , serviceCategoryId ,pageable);
        if(partnerList.isEmpty()){
            throw new HandlerException("Partner not found!");
        }
        return partnerList;
    }

    @Override
    public PartnerDTO getDetailPartner(Long partnerId) throws HandlerException {
        if(!partnerRepository.existsById(partnerId)){
            throw new HandlerException("Partner not found!");
        }
        return partnerRepository.getDetailPartner(partnerId);
    }
}
