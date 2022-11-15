package com.example.wetravel.Service;

import com.example.wetravel.DTO.TourDTO;
import com.example.wetravel.DTO.TourListDTO;
import com.example.wetravel.Exception.HandlerException;

import java.util.List;

public interface TourService {
    TourListDTO getAllTour(String tourName , List<Integer> tourCategoryList , Integer tourType ,
                                 Integer status , Integer fromPrice , Integer toPrice , Integer page , Integer size) throws HandlerException;

    TourDTO getDetailTour(Long tourId) throws HandlerException;

    TourDTO createTour(TourDTO tourDTO) throws HandlerException;

    TourDTO updateTour(TourDTO tourDTO , Long tourId) throws HandlerException;

    Integer countTour(String tourName , List<Integer> tourCategoryList , Integer tourType , Integer status , Integer fromPrice , Integer toPrice) throws HandlerException;

    Boolean deleteTour(Long tourId) throws HandlerException;

    Boolean activeTour(Long tourId) throws HandlerException;
}
