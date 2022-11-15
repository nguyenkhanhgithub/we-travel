package com.example.wetravel.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@Table(name = "Restaurant")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "restaurant_service_type")
    private String restaurantServiceType;

    @Column(name = "time_open")
    private LocalTime timeOpen;

    @Column(name = "time_close")
    private LocalTime timeClose;

    @Column(name = "description")
    private String description;

    @Column(name = "rate")
    private Float rate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service_id" , referencedColumnName = "service_id")
    private Service serviceId;

    @OneToMany(fetch = FetchType.LAZY , mappedBy = "restaurantId" , cascade = CascadeType.ALL)
    private List<TypeOfCuisineService> typeOfCuisineServiceList;
}
