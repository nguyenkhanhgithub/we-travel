package com.example.wetravel.Controller;

import com.example.wetravel.Constant.BaseResponse;
import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.AccommodationDTO;
import com.example.wetravel.DTO.EntertainmentDTO;
import com.example.wetravel.DTO.RestaurantDTO;
import com.example.wetravel.DTO.ServiceDTO;
import com.example.wetravel.Entity.Service;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.ServiceRepository;
import com.example.wetravel.Service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("wetravel/")
@CrossOrigin
public class ServiceController {
    @Autowired
    ServiceService serviceService;

    @Autowired
    ServiceRepository serviceRepository;

    @GetMapping("service")
    public ResponseEntity<?> getListServicePartner(@RequestParam(defaultValue = "all") String emailPartner ,
                                                   @RequestParam(defaultValue = "0") Long serviceCategoryId ,
                                                   @RequestParam(defaultValue = "-1") Integer isActive ,
                                                   @RequestParam(defaultValue = "-1") Integer isBlock ,
                                                   @RequestParam(defaultValue = "-1") Integer status){
        try{
            List<ServiceDTO> result = serviceService.getAllServiceByCondition(emailPartner, serviceCategoryId, isActive, isBlock , status);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("service/list/partner")
    public ResponseEntity<?> getListServicePartner(@RequestParam Long partnerId , @RequestParam Integer page,
                                                    @RequestParam Integer size){
        try{
            Page<ServiceDTO> result = serviceService.getListServiceByPartnerId(partnerId , page , size);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("service/detail")
    public ResponseEntity<?> getDetail(@RequestParam Long serviceId){
        try{
            Service service = serviceRepository.getById(serviceId);
            if(Objects.equals(service.getServiceCategoryId().getServiceCategoryId(), Constant.ServiceCategory.ACCOMMODATION)){
                AccommodationDTO result = serviceService.getDetailAccommodation(serviceId);
                return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
            }else if(Objects.equals(service.getServiceCategoryId().getServiceCategoryId(), Constant.ServiceCategory.RESTAURANT)){
                RestaurantDTO result = serviceService.getDetailRestaurant(serviceId);
                return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
            }else if(Objects.equals(service.getServiceCategoryId().getServiceCategoryId(), Constant.ServiceCategory.ENTERTAINMENT)){
                EntertainmentDTO result = serviceService.getDetailEntertainment(serviceId);
                return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
            }
            return new ResponseEntity<>(new BaseResponse(400 , null , Constant.Message.NOT_FOUND) , HttpStatus.BAD_REQUEST);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/accommodation")
    public ResponseEntity<?> createAccommodation(@RequestBody AccommodationDTO accommodationDTO) {
        try{
            AccommodationDTO result = serviceService.createAccommodation(accommodationDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/restaurant")
    public ResponseEntity<?> createRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        try{
            RestaurantDTO result = serviceService.createRestaurant(restaurantDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("create/entertainment")
    public ResponseEntity<?> createEntertainment(@RequestBody EntertainmentDTO entertainmentDTO) {
        try{
            EntertainmentDTO result = serviceService.createEntertainment(entertainmentDTO);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.CREATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/accommodation/{serviceId}")
    public ResponseEntity<?> updateAccommodation(@RequestBody AccommodationDTO accommodationDTO , @PathVariable Long serviceId) {
        try{
            AccommodationDTO result = serviceService.updateAccommodation(accommodationDTO , serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.UPDATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/restaurant/{serviceId}")
    public ResponseEntity<?> updateRestaurant(@RequestBody RestaurantDTO restaurantDTO , @PathVariable Long serviceId) {
        try{
            RestaurantDTO result = serviceService.updateRestaurant(restaurantDTO , serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.UPDATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update/entertainment/{serviceId}")
    public ResponseEntity<?> updateEntertainment(@RequestBody EntertainmentDTO entertainmentDTO , @PathVariable Long serviceId) {
        try{
            EntertainmentDTO result = serviceService.updateEntertainment(entertainmentDTO , serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.UPDATE_SUCCESS) , HttpStatus.OK);
        }catch (HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/service/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable Long serviceId){
        try{
            Boolean result = serviceService.deleteService(serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.DELETE_SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("approve/service/{serviceId}")
    public ResponseEntity<?> approveService(@PathVariable Long serviceId){
        try{
            Boolean result = serviceService.approveService(serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.APPROVE_SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("unblock/service/{serviceId}")
    public ResponseEntity<?> unblockService(@PathVariable Long serviceId){
        try{
            Boolean result = serviceService.unblockService(serviceId);
            return new ResponseEntity<>(new BaseResponse(200 , result , Constant.Message.SUCCESS) , HttpStatus.OK);
        }catch(HandlerException e){
            return new ResponseEntity<>(new BaseResponse(400 , null , e.getMessage()) , HttpStatus.BAD_REQUEST);
        }
    }

}
