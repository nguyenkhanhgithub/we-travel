package com.example.wetravel.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RoomDTO {
    private String roomName;

    private String roomType;

    private Float roomSize;

    private Integer numberOfRoom;

    private Integer numberOfPeopleRoom;

    private Float dailyPrice;

    private Float holidayPrice;

    private String description;

    private String bedType;
}
