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
public class EntertainmentDTO {
    private ServiceDTO serviceDTO;

    private String entertainmentType;

    private String dowOpen;

    private LocalTime timeOpen;

    private LocalTime timeClose;

    private Float priceTicketAdult;

    private Float priceTicketChildren;

    private String description;

    private List<UtilitiesServiceDTO> utilitiesServiceDTOList;
}
