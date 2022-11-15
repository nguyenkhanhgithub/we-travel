package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccommodationDTO {
    private ServiceDTO serviceDTO;

    private String accommodationType;

    private Float rate;

    private Integer numberFloors;

    private String description;

    private List<RoomDTO> roomDTOList;

    private List<UtilitiesServiceDTO> utilitiesServiceDTOList;
}
