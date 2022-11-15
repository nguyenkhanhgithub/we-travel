package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Room")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Room implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "room_name")
    private String roomName;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "area")
    private Float area;

    @Column(name = "number_of_rooms")
    private Integer numberRooms;

    @Column(name = "number_of_people")
    private Integer numberOfPeople;

    @Column(name = "daily_price")
    private Float dailyPrice;

    @Column(name = "holiday_price")
    private Float holidayPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "bed_type")
    private String bedType;

    @ManyToOne(fetch = FetchType.LAZY , cascade = {CascadeType.MERGE ,CascadeType.DETACH , CascadeType.PERSIST})
    @JoinColumn(name = "accommodation_id" , referencedColumnName = "accommodation_id")
    private Accommodation accommodationId;
}
