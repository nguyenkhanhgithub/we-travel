package com.example.wetravel.Service;

import com.example.wetravel.DTO.AccommodationDTO;
import com.example.wetravel.DTO.EntertainmentDTO;
import com.example.wetravel.DTO.RestaurantDTO;
import com.example.wetravel.DTO.ServiceDTO;
import com.example.wetravel.Entity.Service;
import com.example.wetravel.Exception.HandlerException;
import org.springframework.data.domain.Page;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface ServiceService {
    Page<ServiceDTO> getAllServiceByCondition(String emailPartner , Long serviceCategoryId ,
                                              Integer isActive , Integer isBlock , Integer status , Integer page , Integer size) throws HandlerException;

    Page<ServiceDTO> getListServiceByPartnerId(Long partnerId , Integer page , Integer size) throws HandlerException;
    AccommodationDTO getDetailAccommodation(Long serviceId) throws HandlerException;

    RestaurantDTO getDetailRestaurant(Long serviceId) throws HandlerException;

    EntertainmentDTO getDetailEntertainment(Long serviceId) throws HandlerException;

    AccommodationDTO createAccommodation(AccommodationDTO accommodationDTO) throws HandlerException;

    RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) throws HandlerException;

    EntertainmentDTO createEntertainment(EntertainmentDTO entertainmentDTO) throws HandlerException;

    AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO , Long serviceId) throws HandlerException;

    RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO , Long serviceId) throws HandlerException;

    EntertainmentDTO updateEntertainment(EntertainmentDTO entertainmentDTO , Long serviceId) throws HandlerException;

    Boolean deleteService(Long serviceId) throws HandlerException;

    Boolean approveService(Long serviceId) throws HandlerException;

    Boolean unblockService(Long serviceId) throws HandlerException;
}
