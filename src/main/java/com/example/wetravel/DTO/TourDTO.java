package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourDTO {
    private Long tourId;

    private String tourName;

    private String tourCode;

    private String startPlace;

    private String endPlace;

    private Integer status;

    private Integer tourType;

    private Boolean tourMode;

    private LocalDate startDate;

    private LocalTime startTime;

    private LocalTime endTime;

    private Integer numberOfDay;

    private Integer numberOfNight;

    private Integer minAdult;

    private Integer maxAdult;

    private Integer minChildren;

    private Integer maxChildren;

    private Integer minToStart;

    private Float priceAdult;

    private Float priceChildren;

    private Float totalPrice;

    private Float deposit;

    private String note;

    private Long tourCategoryId;

    private TourDetailDTO tourDetailDTO;

    private List<TourScheduleDTO> tourScheduleDTOList;

    private Long accountId;

    private UserBookingDTO userBookingDTO;

}
