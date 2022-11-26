package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.DTO.*;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ServiceCategoryRepository serviceCategoryRepository;

    @Autowired
    AccommodationRepository accommodationRepository;

    @Autowired
    RestaurantRepository restaurantRepository;

    @Autowired
    EntertainmentRepository entertainmentRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    UtilitiesServiceRepository utilitiesServiceRepository;

    @Autowired
    UtilitiesSubcategoryRepository utilitiesSubcategoryRepository;

    @Autowired
    TypeOfCuisineRepository typeOfCuisineRepository;

    @Autowired
    TypeOfCuisineServiceRepository typeOfCuisineServiceRepository;

    @Override
    public List<ServiceDTO> getAllServiceByCondition(String emailPartner , Long serviceCategoryId ,
                                                     Integer isActive , Integer isBlock , Integer status) throws HandlerException {
        List<Service> serviceList = serviceRepository.getListServiceByCondition(emailPartner, serviceCategoryId, isActive, isBlock , status);
        if(serviceList.isEmpty()){
            throw new HandlerException("Service not found!");
        }
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        for(Service s : serviceList){
            ServiceDTO serviceDTO = new ServiceDTO();
            Long serviceId = s.getServiceId();
            serviceDTO.setServiceId(serviceId);
            serviceDTO.setServiceName(s.getServiceName());
            serviceDTO.setFax(s.getFax());
            serviceDTO.setPhone(s.getPhone());
            serviceDTO.setEmail(s.getEmail());
            serviceDTO.setAddress(s.getAddress());
            serviceDTO.setCity(s.getCity());
            serviceDTO.setLink(s.getLink());
            serviceDTO.setStatus(s.getStatus());
            serviceDTO.setTaxCode(s.getTaxCode());
            serviceDTO.setIsActive(s.getIsActive());
            serviceDTO.setIsBlock(s.getIsBlock());

            Long serviceCateId = s.getServiceCategoryId().getServiceCategoryId();
            serviceDTO.setServiceCategory(serviceCateId);
            if(serviceCateId == 1){
                serviceDTO.setTypeOfServiceCategory(accommodationRepository.getTypeByServiceId(serviceId));
            }else if(serviceCateId == 2){
                serviceDTO.setTypeOfServiceCategory(entertainmentRepository.getTypeByServiceId(serviceId));
            }else {
                serviceDTO.setTypeOfServiceCategory(restaurantRepository.getTypeByServiceId(serviceId));
            }
            serviceDTO.setPartnerEmail(s.getPartnerId().getEmail());
            serviceDTOList.add(serviceDTO);
        }
        return serviceDTOList;
    }

    @Override
    public Page<ServiceDTO> getListServiceByPartnerId(Long partnerId , Integer page , Integer size) throws HandlerException{
        Pageable pageable = PageRequest.of(page - 1 , size);
        Page<Service> servicePage = serviceRepository.getListServiceByPartnerId(partnerId , pageable);
        if(servicePage.isEmpty()){
            throw new HandlerException("Service not found!");
        }

        List<Service> serviceList = servicePage.getContent();
        List<ServiceDTO> serviceDTOList = new ArrayList<>();
        for(Service s : serviceList){
            ServiceDTO serviceDTO = new ServiceDTO();
            Long serviceId = s.getServiceId();
            serviceDTO.setServiceId(serviceId);
            serviceDTO.setServiceName(s.getServiceName());
            serviceDTO.setFax(s.getFax());
            serviceDTO.setPhone(s.getPhone());
            serviceDTO.setEmail(s.getEmail());
            serviceDTO.setAddress(s.getAddress());
            serviceDTO.setCity(s.getCity());
            serviceDTO.setLink(s.getLink());
            serviceDTO.setStatus(s.getStatus());
            serviceDTO.setTaxCode(s.getTaxCode());
            serviceDTO.setIsActive(s.getIsActive());
            serviceDTO.setIsBlock(s.getIsBlock());

            Long serviceCateId = s.getServiceCategoryId().getServiceCategoryId();
            serviceDTO.setServiceCategory(serviceCateId);
            if(serviceCateId == 1){
                serviceDTO.setTypeOfServiceCategory(accommodationRepository.getTypeByServiceId(serviceId));
            }else if(serviceCateId == 2){
                serviceDTO.setTypeOfServiceCategory(entertainmentRepository.getTypeByServiceId(serviceId));
            }else {
                serviceDTO.setTypeOfServiceCategory(restaurantRepository.getTypeByServiceId(serviceId));
            }
            serviceDTO.setPartnerEmail(s.getPartnerId().getEmail());
            serviceDTOList.add(serviceDTO);
        }
        return new PageImpl<>(serviceDTOList , pageable , serviceDTOList.size());
    }

    @Override
    public AccommodationDTO getDetailAccommodation(Long serviceId) throws HandlerException {
        AccommodationDTO result = new AccommodationDTO();
        Service service = serviceRepository.getById(serviceId);
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setServiceName(service.getServiceName());
        serviceDTO.setFax(service.getFax());
        serviceDTO.setPhone(service.getPhone());
        serviceDTO.setEmail(service.getEmail());
        serviceDTO.setAddress(service.getAddress());
        serviceDTO.setCity(service.getCity());
        serviceDTO.setLink(service.getLink());
        serviceDTO.setStatus(service.getStatus());
        serviceDTO.setTaxCode(service.getTaxCode());
        serviceDTO.setIsActive(service.getIsActive());
        serviceDTO.setIsBlock(service.getIsBlock());
        serviceDTO.setServiceCategory(service.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(service.getPartnerId().getEmail());
        result.setServiceDTO(serviceDTO);
        Accommodation accommodation = accommodationRepository.getByServiceId(serviceId);
        result.setAccommodationType(accommodation.getAccommodationType());
        result.setRate(accommodation.getRate());
        result.setNumberFloors(accommodation.getNumberFloors());
        result.setDescription(accommodation.getDescription());
        List<Room> roomList = roomRepository.getListRoomByAccommodationId(accommodation.getAccommodationId());
        List<RoomDTO> roomDTOList = new ArrayList<>();
        for(Room r : roomList){
            RoomDTO roomDTO = new RoomDTO();
            roomDTO.setRoomName(r.getRoomName());
            roomDTO.setRoomType(r.getRoomType());
            roomDTO.setRoomSize(r.getArea());
            roomDTO.setNumberOfRoom(r.getNumberRooms());
            roomDTO.setNumberOfPeopleRoom(r.getNumberOfPeople());
            roomDTO.setDailyPrice(r.getDailyPrice());
            roomDTO.setHolidayPrice(r.getHolidayPrice());
            roomDTO.setDescription(r.getDescription());
            roomDTO.setBedType(r.getBedType());
            roomDTOList.add(roomDTO);
        }
        result.setRoomDTOList(roomDTOList);
        List<UtilitiesService> utilitiesServiceList = utilitiesServiceRepository.getListUtilitiesServiceByServiceId(serviceId);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = new ArrayList<>();
        for(UtilitiesService u : utilitiesServiceList){
            UtilitiesServiceDTO utilitiesServiceDTO = new UtilitiesServiceDTO();
            utilitiesServiceDTO.setUtilitiesSubcategoryId(u.getUtilitiesSubcategoryId().getUtilitiesSubcategoryId());
            utilitiesServiceDTO.setUtilitiesCategoryId(u.getUtilitiesSubcategoryId().getUtilitiesCategoryId().getUtilitiesCategoryId());
            utilitiesServiceDTOList.add(utilitiesServiceDTO);
        }
        result.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return result;
    }

    @Override
    public RestaurantDTO getDetailRestaurant(Long serviceId) throws HandlerException {
        RestaurantDTO result = new RestaurantDTO();
        Service service = serviceRepository.getById(serviceId);
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setServiceName(service.getServiceName());
        serviceDTO.setFax(service.getFax());
        serviceDTO.setPhone(service.getPhone());
        serviceDTO.setEmail(service.getEmail());
        serviceDTO.setAddress(service.getAddress());
        serviceDTO.setCity(service.getCity());
        serviceDTO.setLink(service.getLink());
        serviceDTO.setStatus(service.getStatus());
        serviceDTO.setTaxCode(service.getTaxCode());
        serviceDTO.setIsActive(service.getIsActive());
        serviceDTO.setIsBlock(service.getIsBlock());
        serviceDTO.setServiceCategory(service.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(service.getPartnerId().getEmail());
        result.setServiceDTO(serviceDTO);
        Restaurant restaurant = restaurantRepository.getRestaurantByServiceId(serviceId);
        result.setRestaurantServiceType(restaurant.getRestaurantServiceType());
        result.setTimeClose(restaurant.getTimeClose());
        result.setTimeOpen(restaurant.getTimeOpen());
        result.setDescription(restaurant.getDescription());
        result.setRate(restaurant.getRate());
        List<TypeOfCuisineService> typeOfCuisineServiceList =
                typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(restaurant.getRestaurantId());
        List<TypeCuisineServiceDTO> typeCuisineServiceDTOList = new ArrayList<>();
        for(TypeOfCuisineService t : typeOfCuisineServiceList){
            TypeCuisineServiceDTO typeCuisineServiceDTO = new TypeCuisineServiceDTO();
            typeCuisineServiceDTO.setTypeCuisineId(t.getTypeCuisineId().getTypeCuisineId());
            typeCuisineServiceDTOList.add(typeCuisineServiceDTO);
        }
        result.setTypeCuisineServiceDTOList(typeCuisineServiceDTOList);
        List<UtilitiesService> utilitiesServiceList = utilitiesServiceRepository.getListUtilitiesServiceByServiceId(serviceId);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = new ArrayList<>();
        for(UtilitiesService u : utilitiesServiceList){
            UtilitiesServiceDTO utilitiesServiceDTO = new UtilitiesServiceDTO();
            utilitiesServiceDTO.setUtilitiesSubcategoryId(u.getUtilitiesSubcategoryId().getUtilitiesSubcategoryId());
            utilitiesServiceDTO.setUtilitiesCategoryId(u.getUtilitiesSubcategoryId().getUtilitiesCategoryId().getUtilitiesCategoryId());
            utilitiesServiceDTOList.add(utilitiesServiceDTO);
        }
        result.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return result;
    }

    @Override
    public EntertainmentDTO getDetailEntertainment(Long serviceId) throws HandlerException {
        EntertainmentDTO result = new EntertainmentDTO();
        Service service = serviceRepository.getById(serviceId);
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        ServiceDTO serviceDTO = new ServiceDTO();
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setServiceName(service.getServiceName());
        serviceDTO.setFax(service.getFax());
        serviceDTO.setPhone(service.getPhone());
        serviceDTO.setEmail(service.getEmail());
        serviceDTO.setAddress(service.getAddress());
        serviceDTO.setCity(service.getCity());
        serviceDTO.setLink(service.getLink());
        serviceDTO.setStatus(service.getStatus());
        serviceDTO.setTaxCode(service.getTaxCode());
        serviceDTO.setIsActive(service.getIsActive());
        serviceDTO.setIsBlock(service.getIsBlock());
        serviceDTO.setServiceCategory(service.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(service.getPartnerId().getEmail());
        result.setServiceDTO(serviceDTO);
        Entertainment entertainment = entertainmentRepository.getEntertainmentByServiceId(serviceId);
        result.setEntertainmentType(entertainment.getEntertainmentType());
        result.setDowOpen(entertainment.getDowOpen());
        result.setTimeClose(entertainment.getTimeClose());
        result.setTimeOpen(entertainment.getTimeOpen());
        result.setPriceTicketAdult(entertainment.getPriceTicketAdult());
        result.setPriceTicketChildren(entertainment.getPriceTicketChildren());
        result.setDescription(entertainment.getDescription());
        List<UtilitiesService> utilitiesServiceList = utilitiesServiceRepository.getListUtilitiesServiceByServiceId(serviceId);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = new ArrayList<>();
        for(UtilitiesService u : utilitiesServiceList){
            UtilitiesServiceDTO utilitiesServiceDTO = new UtilitiesServiceDTO();
            utilitiesServiceDTO.setUtilitiesSubcategoryId(u.getUtilitiesSubcategoryId().getUtilitiesSubcategoryId());
            utilitiesServiceDTO.setUtilitiesCategoryId(u.getUtilitiesSubcategoryId().getUtilitiesCategoryId().getUtilitiesCategoryId());
            utilitiesServiceDTOList.add(utilitiesServiceDTO);
        }
        result.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return result;
    }

    public Service addService(ServiceDTO serviceDTO) throws HandlerException{
        Partner partner = partnerRepository.getPartnerByAccountEmail(serviceDTO.getPartnerEmail());
        if(partner == null){
            throw new HandlerException("Email partner wrong!");
        }
        Service service = new Service();
        service.setServiceName(serviceDTO.getServiceName());
        service.setFax(serviceDTO.getFax());
        service.setPhone(serviceDTO.getPhone());
        service.setEmail(serviceDTO.getEmail());
        service.setAddress(serviceDTO.getAddress());
        service.setCity(serviceDTO.getCity());
        service.setLink(serviceDTO.getLink());
        service.setStatus(serviceDTO.getStatus());
        service.setTaxCode(serviceDTO.getTaxCode());
        LocalDate now = LocalDate.now();
        service.setDateRegister(now);
        service.setIsActive(false);
        service.setIsBlock(false);
        ServiceCategory serviceCategory = serviceCategoryRepository.getById(serviceDTO.getServiceCategory());
        service.setServiceCategoryId(serviceCategory);
        service.setPartnerId(partner);
        return service;
    }

    @Override
    public AccommodationDTO createAccommodation(AccommodationDTO accommodationDTO) throws HandlerException {
        ServiceDTO serviceDTO = accommodationDTO.getServiceDTO();
        Service service = addService(serviceDTO);
        Accommodation accommodation = new Accommodation();
        accommodation.setAccommodationType(accommodationDTO.getAccommodationType());
        accommodation.setRate(accommodationDTO.getRate());
        accommodation.setNumberFloors(accommodationDTO.getNumberFloors());
        accommodation.setDescription(accommodationDTO.getDescription());
        accommodation.setServiceId(service);
        for(RoomDTO r : accommodationDTO.getRoomDTOList()){
            Room room = new Room();
            room.setRoomName(r.getRoomName());
            room.setRoomType(r.getRoomType());
            room.setArea(r.getRoomSize());
            room.setNumberRooms(r.getNumberOfRoom());
            room.setNumberOfPeople(r.getNumberOfPeopleRoom());
            room.setDailyPrice(r.getDailyPrice());
            room.setHolidayPrice(r.getHolidayPrice());
            room.setDescription(r.getDescription());
            room.setBedType(r.getBedType());
            room.setAccommodationId(accommodation);
            roomRepository.save(room);
        }
        for(UtilitiesServiceDTO u : accommodationDTO.getUtilitiesServiceDTOList()){
            UtilitiesService utilitiesService = new UtilitiesService();
            utilitiesService.setServiceId(service);
            UtilitiesSubcategory utilitiesSubcategory = utilitiesSubcategoryRepository.getById(u.getUtilitiesSubcategoryId());
            utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategory);
            utilitiesServiceRepository.save(utilitiesService);
        }
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setIsBlock(false);
        serviceDTO.setIsActive(false);
        accommodationDTO.setServiceDTO(serviceDTO);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = accommodationDTO.getUtilitiesServiceDTOList();
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        accommodationDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return accommodationDTO;
    }

    @Override
    public RestaurantDTO createRestaurant(RestaurantDTO restaurantDTO) throws HandlerException {
        ServiceDTO serviceDTO = restaurantDTO.getServiceDTO();
        Service service = addService(serviceDTO);
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantServiceType(restaurantDTO.getRestaurantServiceType());
        restaurant.setRate(restaurantDTO.getRate());
        restaurant.setTimeOpen(restaurantDTO.getTimeOpen());
        restaurant.setTimeClose(restaurantDTO.getTimeClose());
        restaurant.setDescription(restaurantDTO.getDescription());
        restaurant.setServiceId(service);
        restaurantRepository.save(restaurant);
        for(UtilitiesServiceDTO u : restaurantDTO.getUtilitiesServiceDTOList()){
            UtilitiesService utilitiesService = new UtilitiesService();
            utilitiesService.setServiceId(service);
            UtilitiesSubcategory utilitiesSubcategory = utilitiesSubcategoryRepository.getById(u.getUtilitiesSubcategoryId());
            utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategory);
            utilitiesServiceRepository.save(utilitiesService);
        }
        for(TypeCuisineServiceDTO t : restaurantDTO.getTypeCuisineServiceDTOList()){
            TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
            typeOfCuisineService.setRestaurantId(restaurant);
            TypeOfCuisine typeOfCuisine = typeOfCuisineRepository.getById(t.getTypeCuisineId());
            typeOfCuisineService.setTypeCuisineId(typeOfCuisine);
            typeOfCuisineServiceRepository.save(typeOfCuisineService);
        }
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setIsBlock(false);
        serviceDTO.setIsActive(false);
        restaurantDTO.setServiceDTO(serviceDTO);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = restaurantDTO.getUtilitiesServiceDTOList();
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        restaurantDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return restaurantDTO;
    }

    @Override
    public EntertainmentDTO createEntertainment(EntertainmentDTO entertainmentDTO) throws HandlerException {
        ServiceDTO serviceDTO = entertainmentDTO.getServiceDTO();
        Service service = addService(serviceDTO);
        Entertainment entertainment = new Entertainment();
        entertainment.setEntertainmentType(entertainmentDTO.getEntertainmentType());
        entertainment.setDowOpen(entertainmentDTO.getDowOpen());
        entertainment.setTimeOpen(entertainmentDTO.getTimeOpen());
        entertainment.setTimeClose(entertainmentDTO.getTimeClose());
        entertainment.setPriceTicketAdult(entertainmentDTO.getPriceTicketAdult());
        entertainment.setPriceTicketChildren(entertainmentDTO.getPriceTicketChildren());
        entertainment.setDescription(entertainmentDTO.getDescription());
        entertainment.setServiceId(service);
        entertainmentRepository.save(entertainment);
        for(UtilitiesServiceDTO u : entertainmentDTO.getUtilitiesServiceDTOList()){
            UtilitiesService utilitiesService = new UtilitiesService();
            utilitiesService.setServiceId(service);
            UtilitiesSubcategory utilitiesSubcategory = utilitiesSubcategoryRepository.getById(u.getUtilitiesSubcategoryId());
            utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategory);
            utilitiesServiceRepository.save(utilitiesService);
        }
        serviceDTO.setServiceId(service.getServiceId());
        serviceDTO.setIsBlock(false);
        serviceDTO.setIsActive(false);
        entertainmentDTO.setServiceDTO(serviceDTO);
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = entertainmentDTO.getUtilitiesServiceDTOList();
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        entertainmentDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return entertainmentDTO;
    }

    public Service updateService(ServiceDTO serviceDTO , List<UtilitiesServiceDTO> utilitiesServiceDTOList , Long serviceId) throws HandlerException {
        Service serviceUpdate = serviceRepository.getById(serviceId);
        if(Boolean.TRUE.equals(serviceRepository.existsAllByServiceName(serviceDTO.getServiceName()))
                && !serviceDTO.getServiceName().equals(serviceUpdate.getServiceName())){
            throw new HandlerException("Name of service exist!");
        }
        serviceUpdate.setServiceName(serviceDTO.getServiceName());
        serviceUpdate.setFax(serviceDTO.getFax());
        serviceUpdate.setPhone(serviceDTO.getPhone());
        serviceUpdate.setEmail(serviceDTO.getEmail());
        serviceUpdate.setAddress(serviceDTO.getAddress());
        serviceUpdate.setCity(serviceDTO.getCity());
        serviceUpdate.setLink(serviceDTO.getLink());
        List<UtilitiesService> utilitiesServiceList = utilitiesServiceRepository.getListUtilitiesServiceByServiceId(serviceId);
        utilitiesServiceRepository.deleteAll(utilitiesServiceList);
        for(UtilitiesServiceDTO u : utilitiesServiceDTOList){
            UtilitiesService utilitiesService = new UtilitiesService();
            utilitiesService.setServiceId(serviceUpdate);
            UtilitiesSubcategory utilitiesSubcategory = utilitiesSubcategoryRepository.getById(u.getUtilitiesSubcategoryId());
            utilitiesService.setUtilitiesSubcategoryId(utilitiesSubcategory);
            utilitiesServiceRepository.save(utilitiesService);
        }
        return serviceUpdate;
    }

    @Override
    public AccommodationDTO updateAccommodation(AccommodationDTO accommodationDTO , Long serviceId) throws HandlerException {
        ServiceDTO serviceDTO = accommodationDTO.getServiceDTO();
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = accommodationDTO.getUtilitiesServiceDTOList();
        Service serviceUpdate = updateService(serviceDTO,utilitiesServiceDTOList,serviceId);
        Accommodation accommodationUpdate = accommodationRepository.getByServiceId(serviceId);
        accommodationUpdate.setAccommodationType(accommodationDTO.getAccommodationType());
        accommodationUpdate.setRate(accommodationUpdate.getRate());
        accommodationUpdate.setNumberFloors(accommodationDTO.getNumberFloors());
        accommodationUpdate.setDescription(accommodationUpdate.getDescription());
        accommodationUpdate.setServiceId(serviceUpdate);
        List<Room> roomList = roomRepository.getListRoomByAccommodationId(accommodationUpdate.getAccommodationId());
        roomRepository.deleteAll(roomList);
        for(RoomDTO r : accommodationDTO.getRoomDTOList()){
            Room room = new Room();
            room.setRoomName(r.getRoomName());
            room.setRoomType(r.getRoomType());
            room.setArea(r.getRoomSize());
            room.setNumberRooms(r.getNumberOfRoom());
            room.setNumberOfPeople(r.getNumberOfPeopleRoom());
            room.setDailyPrice(r.getDailyPrice());
            room.setHolidayPrice(r.getHolidayPrice());
            room.setDescription(r.getDescription());
            room.setBedType(r.getBedType());
            room.setAccommodationId(accommodationUpdate);
            roomRepository.save(room);
        }
        serviceDTO.setServiceId(serviceUpdate.getServiceId());
        serviceDTO.setServiceCategory(serviceUpdate.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(serviceUpdate.getPartnerId().getEmail());
        serviceDTO.setIsBlock(serviceUpdate.getIsBlock());
        serviceDTO.setIsActive(serviceUpdate.getIsActive());
        accommodationDTO.setServiceDTO(serviceDTO);
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        accommodationDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return accommodationDTO;
    }

    @Override
    public RestaurantDTO updateRestaurant(RestaurantDTO restaurantDTO , Long serviceId) throws HandlerException {
        ServiceDTO serviceDTO = restaurantDTO.getServiceDTO();
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = restaurantDTO.getUtilitiesServiceDTOList();
        Service serviceUpdate = updateService(serviceDTO ,utilitiesServiceDTOList , serviceId);
        Restaurant restaurantUpdate = restaurantRepository.getRestaurantByServiceId(serviceId);
        restaurantUpdate.setRestaurantServiceType(restaurantDTO.getRestaurantServiceType());
        restaurantUpdate.setRate(restaurantDTO.getRate());
        restaurantUpdate.setTimeOpen(restaurantDTO.getTimeOpen());
        restaurantUpdate.setTimeClose(restaurantDTO.getTimeClose());
        restaurantUpdate.setDescription(restaurantDTO.getDescription());
        restaurantUpdate.setServiceId(serviceUpdate);
        restaurantRepository.save(restaurantUpdate);
        List<TypeOfCuisineService> typeOfCuisineServiceList =
                typeOfCuisineServiceRepository.getListTypeCuisineServiceByRestaurantId(restaurantUpdate.getRestaurantId());
        typeOfCuisineServiceRepository.deleteAll(typeOfCuisineServiceList);
        for(TypeCuisineServiceDTO t : restaurantDTO.getTypeCuisineServiceDTOList()){
            TypeOfCuisineService typeOfCuisineService = new TypeOfCuisineService();
            typeOfCuisineService.setRestaurantId(restaurantUpdate);
            TypeOfCuisine typeOfCuisine = typeOfCuisineRepository.getById(t.getTypeCuisineId());
            typeOfCuisineService.setTypeCuisineId(typeOfCuisine);
            typeOfCuisineServiceRepository.save(typeOfCuisineService);
        }
        serviceDTO.setServiceId(serviceUpdate.getServiceId());
        serviceDTO.setServiceCategory(serviceUpdate.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(serviceUpdate.getPartnerId().getEmail());
        serviceDTO.setIsBlock(serviceUpdate.getIsBlock());
        serviceDTO.setIsActive(serviceUpdate.getIsActive());
        restaurantDTO.setServiceDTO(serviceDTO);
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        restaurantDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return restaurantDTO;
    }

    @Override
    public EntertainmentDTO updateEntertainment(EntertainmentDTO entertainmentDTO , Long serviceId) throws HandlerException {
        ServiceDTO serviceDTO = entertainmentDTO.getServiceDTO();
        List<UtilitiesServiceDTO> utilitiesServiceDTOList = entertainmentDTO.getUtilitiesServiceDTOList();
        Service serviceUpdate = updateService(serviceDTO , utilitiesServiceDTOList , serviceId);
        Entertainment entertainment = entertainmentRepository.getEntertainmentByServiceId(serviceId);
        entertainment.setEntertainmentType(entertainmentDTO.getEntertainmentType());
        entertainment.setDowOpen(entertainmentDTO.getDowOpen());
        entertainment.setTimeOpen(entertainmentDTO.getTimeOpen());
        entertainment.setTimeClose(entertainmentDTO.getTimeClose());
        entertainment.setPriceTicketAdult(entertainmentDTO.getPriceTicketAdult());
        entertainment.setPriceTicketChildren(entertainmentDTO.getPriceTicketChildren());
        entertainment.setDescription(entertainmentDTO.getDescription());
        entertainment.setServiceId(serviceUpdate);
        entertainmentRepository.save(entertainment);
        serviceDTO.setServiceId(serviceUpdate.getServiceId());
        serviceDTO.setServiceCategory(serviceUpdate.getServiceCategoryId().getServiceCategoryId());
        serviceDTO.setPartnerEmail(serviceUpdate.getPartnerId().getEmail());
        serviceDTO.setIsBlock(serviceUpdate.getIsBlock());
        serviceDTO.setIsActive(serviceUpdate.getIsActive());
        entertainmentDTO.setServiceDTO(serviceDTO);
        for(UtilitiesServiceDTO us : utilitiesServiceDTOList){
            UtilitiesSubcategory utilitiesSubcategory =
                    utilitiesSubcategoryRepository.findByUtilitiesSubcategoryId(us.getUtilitiesSubcategoryId());
            us.setUtilitiesCategoryId(utilitiesSubcategory.getUtilitiesCategoryId().getUtilitiesCategoryId());
        }
        entertainmentDTO.setUtilitiesServiceDTOList(utilitiesServiceDTOList);
        return entertainmentDTO;
    }

    @Override
    public Boolean deleteService(Long serviceId) throws HandlerException{
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        Service service = serviceRepository.getById(serviceId);
        service.setIsBlock(true);
        serviceRepository.save(service);
        return true;
    }

    @Override
    public Boolean approveService(Long serviceId) throws HandlerException {
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        Service service = serviceRepository.getById(serviceId);
        service.setIsActive(true);
        LocalDate now = LocalDate.now();
        service.setDateRegister(now);
        serviceRepository.save(service);
        return true;
    }

    @Override
    public Boolean unblockService(Long serviceId) throws HandlerException {
        if(!serviceRepository.existsById(serviceId)){
            throw new HandlerException("Service not found!");
        }
        Service service = serviceRepository.getById(serviceId);
        service.setIsBlock(false);
        serviceRepository.save(service);
        return true;
    }


}
