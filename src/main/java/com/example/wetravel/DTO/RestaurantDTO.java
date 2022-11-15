package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDTO {
    private ServiceDTO serviceDTO;

    private String restaurantServiceType;

    private LocalTime timeOpen;

    private LocalTime timeClose;

    private String description;

    private Float rate;

    private List<UtilitiesServiceDTO> utilitiesServiceDTOList;

    private List<TypeCuisineServiceDTO> typeCuisineServiceDTOList;
}
