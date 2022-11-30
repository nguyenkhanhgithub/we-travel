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
public class TourDetailDTO {
    private String tourIntroduce;

    private String tourInclude;

    private String tourNonInclude;

    private String generalTerms;

    private String addressStart;

    private String description;

    private String moreDescription;

    private Float longitude;

    private Float latitude;

    private List<TagOfTourDTO> tagOfTourDTOList;
}
