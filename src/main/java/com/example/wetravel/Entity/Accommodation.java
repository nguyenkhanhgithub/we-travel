package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Table(name = "Accommodation")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Accommodation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accommodation_id")
    private Long accommodationId;

    @Column(name = "accommodation_type")
    private String accommodationType;

    @Column(name = "rate")
    private Float rate;

    @Column(name = "number_of_floors")
    private Integer numberFloors;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "accommodationId" , cascade = CascadeType.ALL)
    private List<Room> roomList;
}
