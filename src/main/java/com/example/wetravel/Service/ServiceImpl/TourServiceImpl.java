package com.example.wetravel.Service.ServiceImpl;

import com.example.wetravel.Constant.Constant;
import com.example.wetravel.DTO.*;
import com.example.wetravel.Entity.*;
import com.example.wetravel.Exception.HandlerException;
import com.example.wetravel.Repository.*;
import com.example.wetravel.Service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TourServiceImpl implements TourService {
    @Autowired
    TourCategoryRepository tourCategoryRepository;

    @Autowired
    TagRepository tagRepository;

    @Autowired
    TagOfTourRepository tagOfTourRepository;

    @Autowired
    TourDetailRepository tourDetailRepository;

    @Autowired
    TourRepository tourRepository;

    @Autowired
    TourScheduleRepository tourScheduleRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserBookingRepository userBookingRepository;

    @Override
    public TourListDTO getAllTour(String tourName , List<Integer> tourCategoryList , Integer tourType
            , Integer status , Integer fromPrice , Integer toPrice , Integer page, Integer size) throws HandlerException{
        TourListDTO tourListDTO = new TourListDTO();
        Pageable pageable = PageRequest.of(page-1, size);
        Page<Tour> tourList = tourRepository.getListTour("%" +tourName+"%" , tourCategoryList , tourType , status , fromPrice , toPrice , pageable);
        if(tourList.isEmpty()){
            throw new HandlerException("Tour not found!");
        }
        List<TourDTO> tourDTOList = new ArrayList<>();
        for(Tour t : tourList){
            TourDTO tourDTO = new TourDTO();
            tourDTO.setTourId(t.getTourId());
            tourDTO.setTourName(t.getTourName());
            tourDTO.setTourCode(t.getTourCode());
            tourDTO.setStartPlace(t.getStartPlace());
            tourDTO.setEndPlace(t.getEndPlace());
            tourDTO.setStatus(t.getStatus());
            tourDTO.setTourType(t.getTourType());
            tourDTO.setTourMode(t.getTourMode());
            tourDTO.setStartDate(t.getStartDate());
            tourDTO.setStartTime(t.getStartTime());
            tourDTO.setEndTime(t.getEndTime());
            tourDTO.setNumberOfDay(t.getNumberOfDay());
            tourDTO.setNumberOfNight(t.getNumberOfNight());
            tourDTO.setMinAdult(t.getMinAdult());
            tourDTO.setMaxAdult(t.getMaxAdult());
            tourDTO.setMinChildren(t.getMinChildren());
            tourDTO.setMaxChildren(t.getMaxChildren());
            tourDTO.setMinToStart(t.getMinToStart());
            tourDTO.setPriceAdult(t.getPriceAdult());
            tourDTO.setPriceChildren(t.getPriceChildren());
            tourDTO.setTotalPrice(t.getTotalPrice());
            tourDTO.setDeposit(t.getDeposit());
            tourDTO.setNote(t.getNote());
            tourDTO.setTourCategoryId(t.getTourCategoryId().getTourCategoryId());
            try{
                tourDTO.setAccountId(t.getAccountId().getAccountId());
            } catch (Exception e){
                tourDTO.setAccountId(null);
            }
            tourDTOList.add(tourDTO);
        }
        Integer count = tourRepository.countListTour("%" +tourName +"%" , tourCategoryList , tourType , status , fromPrice , toPrice);
        tourListDTO.setTourDTO(tourDTOList);
        tourListDTO.setCountTour(count);
        return tourListDTO;
    }

    @Override
    public TourDTO getDetailTour(Long tourId) throws HandlerException{
        Tour tour = tourRepository.getById(tourId);
        if(!tourRepository.existsById(tourId)){
            throw new HandlerException("Tour not found!");
        }
        TourDTO tourDTO = new TourDTO();
        tourDTO.setTourId(tourId);
        tourDTO.setTourName(tour.getTourName());
        tourDTO.setTourCode(tour.getTourCode());
        tourDTO.setStartPlace(tour.getStartPlace());
        tourDTO.setEndPlace(tour.getEndPlace());
        tourDTO.setStatus(tour.getStatus());
        tourDTO.setTourType(tour.getTourType());
        tourDTO.setTourMode(tour.getTourMode());
        tourDTO.setStartDate(tour.getStartDate());
        tourDTO.setStartTime(tour.getStartTime());
        tourDTO.setEndTime(tour.getEndTime());
        tourDTO.setNumberOfDay(tour.getNumberOfDay());
        tourDTO.setNumberOfNight(tour.getNumberOfNight());
        tourDTO.setMinAdult(tour.getMinAdult());
        tourDTO.setMaxAdult(tour.getMaxAdult());
        tourDTO.setPriceAdult(tour.getPriceAdult());
        tourDTO.setPriceChildren(tour.getPriceChildren());
        tourDTO.setMinChildren(tour.getMinChildren());
        tourDTO.setMaxChildren(tour.getMaxChildren());
        tourDTO.setTotalPrice(tour.getTotalPrice());
        tourDTO.setDeposit(tour.getDeposit());
        tourDTO.setMinToStart(tour.getMinToStart());
        tourDTO.setNote(tour.getNote());
        tourDTO.setTourCategoryId(tour.getTourCategoryId().getTourCategoryId());
        try{
            tourDTO.setAccountId(tour.getAccountId().getAccountId());
            List<UserBooking> userBookingList = userBookingRepository.getBookingOfTourPrivateByTourId(tourId);
            for(UserBooking u : userBookingList){
                UserBookingDTO userBookingDTO = new UserBookingDTO();
                userBookingDTO.setUserBookingId(u.getUserBookingId());
                userBookingDTO.setAccountId(u.getAccountId().getAccountId());
                userBookingDTO.setTourId(u.getTourId().getTourId());
                userBookingDTO.setFullName(u.getFullName());
                userBookingDTO.setPhone(u.getPhone());
                userBookingDTO.setEmail(u.getEmail());
                userBookingDTO.setBookingDate(u.getBookingDate());
                userBookingDTO.setStartDate(u.getStartDate());
                userBookingDTO.setIdCard(u.getIdCard());
                userBookingDTO.setDateOfIssue(u.getDateOfIssue());
                userBookingDTO.setPlaceOfIssue(u.getPlaceOfIssue());
                userBookingDTO.setRequest(u.getRequest());
                userBookingDTO.setAdultPrice(u.getAdultPrice());
                userBookingDTO.setChildrenPrice(u.getChildrenPrice());
                userBookingDTO.setNumberOfAdult(u.getNumberOfAdult());
                userBookingDTO.setNumberOfChildren(u.getNumberOfChildren());
                userBookingDTO.setTotalPrice(u.getTotalPrice());
                userBookingDTO.setOrderId(u.getOrderId());
                userBookingDTO.setOrderTitle(u.getOrderTitle());
                userBookingDTO.setPayType(u.getPayType());
                userBookingDTO.setStatus(u.getStatus());
                userBookingDTO.setStatusDeposit(u.getStatusDeposit());
                tourDTO.setUserBookingDTO(userBookingDTO);
            }
        } catch (Exception e){
            tourDTO.setAccountId(null);
            tourDTO.setUserBookingDTO(null);
        }

        TourDetail tourDetail = tourDetailRepository.getByTourId(tourId);
        TourDetailDTO tourDetailDTO = new TourDetailDTO();
        tourDetailDTO.setTourIntroduce(tourDetail.getTourIntroduce());
        tourDetailDTO.setTourInclude(tourDetail.getTourInclude());
        tourDetailDTO.setTourNonInclude(tourDetail.getTourNonInclude());
        tourDetailDTO.setGeneralTerms(tourDetail.getGeneralTerms());
        tourDetailDTO.setAddressStart(tourDetail.getAddressStart());
        tourDetailDTO.setDescription(tourDetail.getDescription());
        tourDetailDTO.setMoreDescription(tourDetail.getMoreDescription());
        tourDetailDTO.setLongitude(tourDetail.getLongitude());
        tourDetailDTO.setLatitude(tourDetail.getLatitude());

        List<TagOfTour> tagOfTourList = tagOfTourRepository.getByTourDetailId(tourDetail.getTourDetailId());
        List<TagOfTourDTO> tagOfTourDTOList = new ArrayList<>();
        for(TagOfTour tot : tagOfTourList){
            TagOfTourDTO tagOfTourDTO = new TagOfTourDTO();
            tagOfTourDTO.setTagId(tot.getTagId().getTagId());
            tagOfTourDTOList.add(tagOfTourDTO);
        }
        tourDetailDTO.setTagOfTourDTOList(tagOfTourDTOList);

        tourDTO.setTourDetailDTO(tourDetailDTO);

        List<TourSchedule> tourScheduleList = tourScheduleRepository.getByTourId(tourId);
        List<TourScheduleDTO> tourScheduleDTOList = new ArrayList<>();
        for(TourSchedule ts : tourScheduleList){
            TourScheduleDTO tourScheduleDTO = new TourScheduleDTO();
            tourScheduleDTO.setTourScheduleName(ts.getTourScheduleName());
            tourScheduleDTO.setContent(ts.getContent());
            tourScheduleDTO.setToPlace(ts.getToPlace());
            tourScheduleDTOList.add(tourScheduleDTO);
        }
        tourDTO.setTourScheduleDTOList(tourScheduleDTOList);

        return tourDTO;
    }

    @Override
    public TourDTO createTour(TourDTO tourDTO) throws HandlerException {
        Tour tour = new Tour();
        tour.setTourName(tourDTO.getTourName());
        tour.setTourCode(tourDTO.getTourCode());
        tour.setStartPlace(tourDTO.getStartPlace());
        tour.setEndPlace(tourDTO.getEndPlace());
        tour.setStatus(tourDTO.getStatus());
        tour.setTourType(tourDTO.getTourType());
        tour.setTourMode(tourDTO.getTourMode());
        tour.setStartDate(tourDTO.getStartDate());
        tour.setStartTime(tourDTO.getStartTime());
        tour.setEndTime(tourDTO.getEndTime());
        tour.setNumberOfDay(tourDTO.getNumberOfDay());
        tour.setNumberOfNight(tourDTO.getNumberOfNight());
        tour.setMinAdult(tourDTO.getMinAdult());
        tour.setMaxAdult(tourDTO.getMaxAdult());
        tour.setMinChildren(tourDTO.getMinChildren());
        tour.setMaxChildren(tourDTO.getMaxChildren());
        tour.setMinToStart(tourDTO.getMinToStart());
        tour.setNote(tourDTO.getNote());
        tour.setPriceAdult(tourDTO.getPriceAdult());
        tour.setPriceChildren(tourDTO.getPriceChildren());
        tour.setTotalPrice(tourDTO.getTotalPrice());
        tour.setDeposit(tourDTO.getDeposit());
        TourCategory tourCategory = tourCategoryRepository.getById(tourDTO.getTourCategoryId());
        tour.setTourCategoryId(tourCategory);
        try{
            Account account = accountRepository.getById(tourDTO.getAccountId());
            tour.setAccountId(account);
        } catch (Exception e){
            tour.setAccountId(null);
        }

        TourDetail tourDetail = new TourDetail();
        TourDetailDTO tourDetailDTO = tourDTO.getTourDetailDTO();
        tourDetail.setTourIntroduce(tourDetailDTO.getTourIntroduce());
        tourDetail.setTourInclude(tourDetailDTO.getTourInclude());
        tourDetail.setTourNonInclude(tourDetailDTO.getTourNonInclude());
        tourDetail.setGeneralTerms(tourDetailDTO.getGeneralTerms());
        tourDetail.setAddressStart(tourDetailDTO.getAddressStart());
        tourDetail.setDescription(tourDetailDTO.getDescription());
        tourDetail.setMoreDescription(tourDetailDTO.getMoreDescription());
        tourDetail.setLongitude(tourDetailDTO.getLongitude());
        tourDetail.setLatitude(tourDetailDTO.getLatitude());
        tourDetail.setTourId(tour);
        tourDetailRepository.save(tourDetail);

        for(TagOfTourDTO tot : tourDetailDTO.getTagOfTourDTOList()){
            TagOfTour tagOfTour = new TagOfTour();
            Tag tag = tagRepository.getById(tot.getTagId());
            tagOfTour.setTagId(tag);
            tagOfTour.setTourDetailId(tourDetail);
            tagOfTourRepository.save(tagOfTour);
        }


        for(TourScheduleDTO ts : tourDTO.getTourScheduleDTOList()){
            TourSchedule tourSchedule = new TourSchedule();
            tourSchedule.setTourScheduleName(ts.getTourScheduleName());
            tourSchedule.setContent(ts.getContent());
            tourSchedule.setToPlace(ts.getToPlace());
            tourSchedule.setTourId(tour);
            tourScheduleRepository.save(tourSchedule);
        }
        tourDTO.setTourId(tour.getTourId());
        return tourDTO;
    }

    @Override
    public TourDTO updateTour(TourDTO tourDTO, Long tourId) throws HandlerException {
        Tour tour = tourRepository.getById(tourId);
        if(!tourRepository.existsById(tourId)){
            throw new HandlerException("Tour not found!");
        }
        tour.setTourName(tourDTO.getTourName());
        tour.setTourCode(tourDTO.getTourCode());
        tour.setStartPlace(tourDTO.getStartPlace());
        tour.setEndPlace(tourDTO.getEndPlace());
        tour.setStatus(tourDTO.getStatus());
        tour.setTourType(tourDTO.getTourType());
        tour.setTourMode(tourDTO.getTourMode());
        tour.setStartDate(tourDTO.getStartDate());
        tour.setStartTime(tourDTO.getStartTime());
        tour.setEndTime(tourDTO.getEndTime());
        tour.setNumberOfDay(tourDTO.getNumberOfDay());
        tour.setNumberOfNight(tourDTO.getNumberOfNight());
        tour.setMinAdult(tourDTO.getMinAdult());
        tour.setMaxAdult(tourDTO.getMaxAdult());
        tour.setMinChildren(tourDTO.getMinChildren());
        tour.setMaxChildren(tourDTO.getMaxChildren());
        tour.setMinToStart(tourDTO.getMinToStart());
        tour.setNote(tourDTO.getNote());
        tour.setPriceAdult(tourDTO.getPriceAdult());
        tour.setPriceChildren(tourDTO.getPriceChildren());
        tour.setTotalPrice(tourDTO.getTotalPrice());
        tour.setDeposit(tourDTO.getDeposit());
        TourCategory tourCategory = tourCategoryRepository.getById(tourDTO.getTourCategoryId());
        tour.setTourCategoryId(tourCategory);
        tourRepository.save(tour);

        TourDetail tourDetail = tourDetailRepository.getByTourId(tourId);
        TourDetailDTO tourDetailDTO = tourDTO.getTourDetailDTO();
        tourDetail.setTourIntroduce(tourDetailDTO.getTourIntroduce());
        tourDetail.setTourInclude(tourDetailDTO.getTourInclude());
        tourDetail.setTourNonInclude(tourDetailDTO.getTourNonInclude());
        tourDetail.setGeneralTerms(tourDetailDTO.getGeneralTerms());
        tourDetail.setAddressStart(tourDetailDTO.getAddressStart());
        tourDetail.setDescription(tourDetailDTO.getDescription());
        tourDetail.setMoreDescription(tourDetailDTO.getMoreDescription());
        tourDetail.setLongitude(tourDetailDTO.getLongitude());
        tourDetail.setLatitude(tourDetailDTO.getLatitude());
        tourDetailRepository.save(tourDetail);

        List<TagOfTour> tagOfTourList = tagOfTourRepository.getByTourDetailId(tourDetail.getTourDetailId());
        tagOfTourRepository.deleteAll(tagOfTourList);
        for(TagOfTourDTO tot : tourDetailDTO.getTagOfTourDTOList()){
            TagOfTour tagOfTour = new TagOfTour();
            Tag tag = tagRepository.getById(tot.getTagId());
            tagOfTour.setTagId(tag);
            tagOfTour.setTourDetailId(tourDetail);
            tagOfTourRepository.save(tagOfTour);
        }

        List<TourSchedule> tourScheduleList = tourScheduleRepository.getByTourId(tourId);
        tourScheduleRepository.deleteAll(tourScheduleList);
        for(TourScheduleDTO ts : tourDTO.getTourScheduleDTOList()){
            TourSchedule tourSchedule = new TourSchedule();
            tourSchedule.setTourScheduleName(ts.getTourScheduleName());
            tourSchedule.setContent(ts.getContent());
            tourSchedule.setToPlace(ts.getToPlace());
            tourSchedule.setTourId(tour);
            tourScheduleRepository.save(tourSchedule);
        }
        return tourDTO;
    }

    @Override
    public Integer countTour(String tourName , List<Integer> tourCategoryList , Integer tourType , Integer status , Integer fromPrice , Integer toPrice) throws HandlerException {
        Integer count = tourRepository.countListTour("%" +tourName + "%" , tourCategoryList , status , tourType , fromPrice , toPrice);
        if(count == 0){
            throw new HandlerException("Tour not found!");
        }
        return count;
    }

    @Override
    public Boolean deleteTour(Long tourId) throws HandlerException {
        Tour tour = tourRepository.getById(tourId);
        if(!tourRepository.existsById(tourId)){
            throw new HandlerException("Tour not found!");
        }
        tour.setStatus(Constant.StatusTour.CLOSE);
        tourRepository.save(tour);
        return true;
    }

    @Override
    public Boolean activeTour(Long tourId) throws HandlerException {
        Tour tour = tourRepository.getById(tourId);
        if(!tourRepository.existsById(tourId)){
            throw new HandlerException("Tour not found!");
        }
        tour.setStatus(Constant.StatusTour.ACTIVE);
        tourRepository.save(tour);
        return true;
    }


}
